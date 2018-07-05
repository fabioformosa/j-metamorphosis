package dev.metamorphosis;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

/**
 * Root Class for all converters, according to template design-pattern.
 * 
 * <br>
 * <br>
 * 
 * Children converters have to implement createOrRetrieveTarget method to create
 * the target or retrieve it from source (e.g. DB retrieve when source has ID)
 * <br>
 * 
 * @see also AbstractBaseConverterToDTO or AbstractBaseConverterToEntity if you
 *      have to convert from/to jpa entity
 * 
 * @author Fabio.Formosa
 *
 * @param <S>
 *          source class
 * @param <T>
 *          target class
 */
public abstract class AbstractBaseConverter<S, T> implements Converter<S, T> {

  @Resource
  protected ConversionService conversionService;

  @Override
  public T convert(S source) {
    T target = createOrRetrieveTarget(source);
    convert(source, target);
    return target;
  }

  protected abstract void convert(S source, T target);

  /**
   * 
   * Invokes default constructor by reflection
   * 
   * @param source
   * @return
   */
  @SuppressWarnings("unchecked")
  protected T createNewTargetInstance(S source) {
    Class<?> targetClass = getTargetClass();
    try {
      Constructor<T> defaultConstructor = (Constructor<T>) targetClass.getDeclaredConstructor();
      return defaultConstructor.newInstance();
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException("Cannot invoke default constructor to instantiate new " + targetClass.getSimpleName(), e);
    }
  }

  protected abstract T createOrRetrieveTarget(S source);

  @SuppressWarnings("unchecked")
  protected Class<T> getTargetClass() {
    ParameterizedType converterSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    Type[] converterTypeArguments = converterSuperclass.getActualTypeArguments();
    return (Class<T>) converterTypeArguments[converterTypeArguments.length - 1];
  }

}
