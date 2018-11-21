package dev.metamorphosis.dtos.mapping;

import java.util.List;

import dev.metamorphosis.entities.mapping.AuditedItemEntity;
import dev.metamorphosis.mappers.MappedOnEntity;
import dev.metamorphosis.mappers.MappedOnEntityField;

@MappedOnEntity(AuditedItemEntity.class)
public class AuditItemDTO {

  private Long id;

  @MappedOnEntityField
  private String name;

  @MappedOnEntityField(entityField = "category")
  private String categoryName;

  @MappedOnEntityField(entityField = "location", cascade = true)
  private LocationDTO locationDTO;

  @MappedOnEntityField(entityField = "targetLocation.name")
  private String targetLocationName;

  @MappedOnEntityField(entityField = "itemTypeLabel", innerDtoField = "enumLabel", cascade = false)
  private EnumDTO itemType;

  private List<SubItemDTO> subItemDTOs;

  @MappedOnEntityField(cascade = true, concatOnCascade = false)
  private AuditDTO auditDTO;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SubItemDTO> getSubItemDTOs() {
    return subItemDTOs;
  }

  public void setSubItemDTOs(List<SubItemDTO> subItemDTOs) {
    this.subItemDTOs = subItemDTOs;
  }

  public AuditDTO getAuditDTO() {
    return auditDTO;
  }

  public void setAuditDTO(AuditDTO auditDTO) {
    this.auditDTO = auditDTO;
  }

}
