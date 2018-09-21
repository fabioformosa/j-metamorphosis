package dev.metamorphosis.entities.mapping;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AuditedItemEntity {

  private Long id;
  private String name;

  private String category;

  private Location location;
  private Location targetLocation;

  private String itemTypeLabel;

  @OneToMany(mappedBy = "item", targetEntity = SubItemEntity.class)
  private List<SubItemEntity> subItems;

  private LocalDateTime createdDate;
  private String creationUser;
  private LocalDateTime lastModifyDate;
  private String lastModifyUser;

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

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreationUser() {
    return creationUser;
  }

  public void setCreationUser(String creationUser) {
    this.creationUser = creationUser;
  }

  public LocalDateTime getLastModifyDate() {
    return lastModifyDate;
  }

  public void setLastModifyDate(LocalDateTime lastModifyDate) {
    this.lastModifyDate = lastModifyDate;
  }

  public String getLastModifyUser() {
    return lastModifyUser;
  }

  public void setLastModifyUser(String lastModifyUser) {
    this.lastModifyUser = lastModifyUser;
  }

  public List<SubItemEntity> getSubItems() {
    return subItems;
  }

  public void setSubItems(List<SubItemEntity> subItems) {
    this.subItems = subItems;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Location getTargetLocation() {
    return targetLocation;
  }

  public void setTargetLocation(Location targetLocation) {
    this.targetLocation = targetLocation;
  }

}
