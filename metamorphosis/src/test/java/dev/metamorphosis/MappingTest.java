package dev.metamorphosis;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.metamorphosis.dtos.mapping.AuditItemDTO;
import dev.metamorphosis.mappers.DtoFieldMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class MappingTest {

  @Autowired
  private DtoFieldMapper dtoFieldMapper;

  @Test
  public void untaggedDTOFieldAreNotInMapping() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertFalse(entityMapping.containsKey("id"));
  }

  @Test
  public void mappingWithTheSameName() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("name"));
    Assert.assertEquals(entityMapping.get("name"), "name");
  }

  @Test
  public void mappingWithNotEqualFieldname() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("categoryName"));
    Assert.assertEquals(entityMapping.get("categoryName"), "category");
  }

  @Test
  public void mappingNotPrimitiveField() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("locationDTO.name"));
    Assert.assertEquals(entityMapping.get("locationDTO.name"), "location.name");
    Assert.assertEquals(entityMapping.get("locationDTO.latitude"), "location.latitude");
    Assert.assertEquals(entityMapping.get("locationDTO.longitude"), "location.longitude");
  }

  @Test
  public void mappingWithNotTheSameStructure() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("auditDTO.createdDate"));
    Assert.assertEquals(entityMapping.get("auditDTO.createdDate"), "createdDate");
    Assert.assertTrue(entityMapping.containsKey("auditDTO.creationUser"));
    Assert.assertEquals(entityMapping.get("auditDTO.creationUser"), "creationUser");
    Assert.assertTrue(entityMapping.containsKey("auditDTO.lastModifyDate"));
    Assert.assertEquals(entityMapping.get("auditDTO.lastModifyDate"), "lastModifyDate");
    Assert.assertTrue(entityMapping.containsKey("auditDTO.lastModifyUser"));
    Assert.assertEquals(entityMapping.get("auditDTO.lastModifyUser"), "lastModifyUser");
  }

  @Test
  public void mappingWithNotTheSameStructure2() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("targetLocationName"));
    Assert.assertEquals(entityMapping.get("targetLocationName"), "targetLocation.name");
  }

  @Test
  public void mappingWithNotTheSameStructure3() {
    Map<String, String> entityMapping = dtoFieldMapper.getMapping(AuditItemDTO.class);
    Assert.assertTrue(entityMapping.containsKey("itemType.enumLabel"));
    Assert.assertEquals(entityMapping.get("itemType.enumLabel"), "itemTypeLabel");
  }

}
