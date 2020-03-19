package it.fabioformosa.metamorphosis.jpa.dtos.mapping;

import java.time.LocalDateTime;


public class AuditDTO {

  private LocalDateTime createdDate;
  private String creationUser;
  private LocalDateTime lastModifyDate;
  private String lastModifyUser;

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

}

