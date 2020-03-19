package it.fabioformosa.metamorphosis.jpa.dtos.mapping;

public class SubItemDTO {

  private Long id;
  private String context;

  private AuditDTO itemDTO;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public AuditDTO getItemDTO() {
    return itemDTO;
  }

  public void setItemDTO(AuditDTO itemDTO) {
    this.itemDTO = itemDTO;
  }

}
