package it.fabioformosa.metamorphosis.jpa;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.fabioformosa.metamorphosis.core.mappers.FieldMappingHelper;
import it.fabioformosa.metamorphosis.jpa.dtos.mapping.AuditItemDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class MappingTest {

  private static final Logger log = LoggerFactory.getLogger(MappingTest.class);

  @Autowired
  private FieldMappingHelper dtoFieldMapper;

  @Test
  public void untaggedDTOFieldAreNotInMapping() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertFalse(entityMapping.containsKey("id"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingWithTheSameName() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("name"));
    Assertions.assertEquals("name", entityMapping.get("name"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingWithNotEqualFieldname() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("categoryName"));
    Assertions.assertEquals("category", entityMapping.get("categoryName"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingNotPrimitiveField() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("locationDTO.name"));
    Assertions.assertEquals("location.name", entityMapping.get("locationDTO.name"));
    Assertions.assertEquals("location.latitude", entityMapping.get("locationDTO.latitude"));
    Assertions.assertEquals("location.longitude", entityMapping.get("locationDTO.longitude"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingWithNotTheSameStructure() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("auditDTO.createdDate"));
    Assertions.assertEquals("createdDate", entityMapping.get("auditDTO.createdDate"));
    Assertions.assertTrue(entityMapping.containsKey("auditDTO.creationUser"));
    Assertions.assertEquals("creationUser", entityMapping.get("auditDTO.creationUser"));
    Assertions.assertTrue(entityMapping.containsKey("auditDTO.lastModifyDate"));
    Assertions.assertEquals("lastModifyDate", entityMapping.get("auditDTO.lastModifyDate"));
    Assertions.assertTrue(entityMapping.containsKey("auditDTO.lastModifyUser"));
    Assertions.assertEquals("lastModifyUser", entityMapping.get("auditDTO.lastModifyUser"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingWithNotTheSameStructure2() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("targetLocationName"));
    Assertions.assertEquals("targetLocation.name", entityMapping.get("targetLocationName"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

  @Test
  public void mappingWithNotTheSameStructure3() {
    Map<String, String> entityMapping = dtoFieldMapper.getMappingByDTO(AuditItemDTO.class);
    Assertions.assertTrue(entityMapping.containsKey("itemType.enumLabel"));
    Assertions.assertEquals("itemTypeLabel", entityMapping.get("itemType.enumLabel"));
    log.info("mapping: {}", dtoFieldMapper.getMappingByDTO(AuditItemDTO.class));
  }

}
