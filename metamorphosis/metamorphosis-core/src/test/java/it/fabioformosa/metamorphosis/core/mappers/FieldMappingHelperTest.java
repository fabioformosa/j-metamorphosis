package it.fabioformosa.metamorphosis.core.mappers;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldMappingHelperTest {

  @Test
  void scanDtoAndCreateMappingsBuildsFieldMappings() {
    FieldMappingHelper fieldMappingHelper = new FieldMappingHelper();
    fieldMappingHelper.scanDtoAndCreateMappings(Set.of(getClass().getPackageName()));

    Map<String, String> mapping = fieldMappingHelper.getMappingByDTO(MappedTestDTO.class);

    Assertions.assertNotNull(mapping);
    Assertions.assertEquals("name", mapping.get("name"));
    Assertions.assertEquals("category", mapping.get("categoryName"));
    Assertions.assertEquals("location.name", mapping.get("locationDTO.name"));
    Assertions.assertFalse(mapping.containsKey("ignored"));
  }

}

@MappedOnEntity(MappedTestEntity.class)
class MappedTestDTO {

  @MappedOnEntityField
  private String name;

  @MappedOnEntityField(entityField = "category")
  private String categoryName;

  @MappedOnEntityField(entityField = "location", cascade = true)
  private MappedLocationDTO locationDTO;

  private String ignored;

}

class MappedLocationDTO {

  private String name;

}

class MappedTestEntity {
}
