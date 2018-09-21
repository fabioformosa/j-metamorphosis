package dev.metamorphosis.mappers;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class DtoFieldMapper {

  static private class MapRecord {
    private String dtoField;
    private String entityPath;

    public MapRecord(String dtoField, String entityPath) {
      super();
      this.dtoField = dtoField;
      this.entityPath = entityPath;
    }

    public String getDtoField() {
      return dtoField;
    }

    public String getEntityPath() {
      return entityPath;
    }

  }

  private static final Logger log = LoggerFactory.getLogger(DtoFieldMapper.class);

  /** dtoClass - Map<dtoField, path of entityField> */
  private Map<Class<?>, Map<String, String>> entityMappingsIndexedByDtoClass = new HashMap<>();

  @PostConstruct
  public void scanDtoAndCreateMappings() {
    log.debug("Scanning DTOs mapped by {} ...", MappedOnEntity.class.getSimpleName());

    ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
    scanner.addIncludeFilter(new AnnotationTypeFilter(MappedOnEntity.class));

    scanner.findCandidateComponents("dev").stream().map(beanDefinition -> beanDefinition.getBeanClassName())
    .forEach(this::buildMappingByDTOName);

    log.debug("Completed scanning of DTOs mapped by {} ...", MappedOnEntity.class.getSimpleName());
  }

  private void buildMappingByDTOName(String annotatedDtoClassName) {
    log.debug("Found DTO {} mapped by {}...", annotatedDtoClassName, MappedOnEntity.class.getSimpleName());
    try {
      Class<?> annotatedDtoClass = Class.forName(annotatedDtoClassName);
      Map<String, String> entityMapping = buildMappingByAnnotatedDTOClass(annotatedDtoClass);
      entityMappingsIndexedByDtoClass.put(annotatedDtoClass, entityMapping);
    } catch (ClassNotFoundException e) {
      log.error("Class not found {}", annotatedDtoClassName);
    } catch (IllegalAccessError e) {
      log.error(e.getMessage(), e);
    } catch (SecurityException | IllegalArgumentException e) {
      log.error(e.getMessage(), e);
    }
  }

  public Map<String, String> getMapping(Class<?> dtoClass) {
    return entityMappingsIndexedByDtoClass.get(dtoClass);
  }

  private Map<String, String> buildMappingByAnnotatedDTOClass(Class<?> clazz) {
    Map<String, String> entityMapping = new HashMap<>();

    // annotated fields
    Set<Field> mappedFieldsInDTO = findAnnotatedFields(clazz, MappedOnEntityField.class);
    mappedFieldsInDTO.stream().flatMap(this::getMappingRecords)
    .forEach(mapRecord -> entityMapping.put(mapRecord.getDtoField(), mapRecord.getEntityPath()));

    // annotated methods
    Set<Method> mappedGettersInDTO = findAnnotedMethods(clazz, MappedOnEntityField.class);
    mappedGettersInDTO.stream()//
    .forEach(dtoGetter -> {//
      Optional<Field> optionalField = fromMethodToField(dtoGetter, clazz);
      optionalField.ifPresent(field -> getMappingRecords(field)
          .forEach(mapRecord -> entityMapping.put(mapRecord.getDtoField(), mapRecord.getEntityPath())));
      if (!optionalField.isPresent()) {
        MappedOnEntityField mappedOnEntityAnnotation = dtoGetter.getAnnotation(MappedOnEntityField.class);
        if (mappedOnEntityAnnotation != null) {
          String virtualDTOField = StringUtils.uncapitalize(dtoGetter.getName().substring(3)); // 3 = "get".length
          entityMapping.put(virtualDTOField, "");
        }
      }
    });

    return entityMapping;
  }

  private Set<Field> findAnnotatedFields(Class<?> clazz, Class<? extends Annotation> ann) {
    Set<Field> set = new HashSet<>();
    Class<?> c = clazz;
    while (c != null) {
      for (Field field : c.getDeclaredFields()) {
        if (field.isAnnotationPresent(ann)) {
          set.add(field);
        }
      }
      c = c.getSuperclass();
    }
    return set;
  }

  private Set<Method> findAnnotedMethods(Class<?> clazz, Class<? extends Annotation> ann) {
    Set<Method> set = new HashSet<>();
    Class<?> c = clazz;
    while (c != null) {
      for (Method method : c.getDeclaredMethods()) {
        if (method.isAnnotationPresent(ann)) {
          set.add(method);
        }
      }
      c = c.getSuperclass();
    }
    return set;
  }

  private Optional<Field> fromMethodToField(Method method, @SuppressWarnings("rawtypes") Class clazz) {
    try {
      BeanInfo info = Introspector.getBeanInfo(clazz);
      PropertyDescriptor[] props = info.getPropertyDescriptors(); // Gets all the properties for the class.
      for (PropertyDescriptor pd : props)
        if (method.equals(pd.getWriteMethod()) || method.equals(pd.getReadMethod()))
          return Optional.of(clazz.getField(pd.getName()));
      return Optional.empty();
    } catch (IntrospectionException | ReflectiveOperationException e) {
      return Optional.empty();
    }
  }

  private Stream<MapRecord> getMappingRecords(Field dtoField) {
    MappedOnEntityField mappingAnnotation = dtoField.getAnnotation(MappedOnEntityField.class);

    if (mappingAnnotation == null)
      return Stream.of(new MapRecord(dtoField.getName(), dtoField.getName()));

    String fieldNameInEntity = retrieveFieldNameInEntity(dtoField, mappingAnnotation);

    if (mappingAnnotation.cascade()) {
      Field[] subfieldsInDTO = dtoField.getType().getDeclaredFields();
      return Stream.of(subfieldsInDTO) //
          .flatMap(this::getMappingRecords) //
          .map(subMapRecord -> {
            String entityPath = mappingAnnotation.concatOnCascade()
                ? fieldNameInEntity + "." + subMapRecord.getEntityPath()
                : subMapRecord.getEntityPath();
                return new MapRecord(dtoField.getName() + "." + subMapRecord.getDtoField(), entityPath);
          });
    } else {
      String fieldnameInDTO = StringUtils.isNotEmpty(mappingAnnotation.innerDtoField())
          ? dtoField.getName() + "." + mappingAnnotation.innerDtoField()
          : dtoField.getName();
          return Stream.of(new MapRecord(fieldnameInDTO, fieldNameInEntity));
    }
  }

  private String retrieveFieldNameInEntity(Field dtoField, MappedOnEntityField mappingAnnotation) {
    return StringUtils.isNotBlank(mappingAnnotation.entityField()) ? mappingAnnotation.entityField() : dtoField.getName();
  }

}
