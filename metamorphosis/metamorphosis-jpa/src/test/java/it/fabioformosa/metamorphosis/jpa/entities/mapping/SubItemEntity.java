package it.fabioformosa.metamorphosis.jpa.entities.mapping;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;

@Entity
public class SubItemEntity {

  private Long id;
  private String context;
  private int quantity;

  @ManyToOne(targetEntity = SubItemEntity.class, fetch = FetchType.LAZY)
  @JoinColumns({ @JoinColumn(name = "fk_item", referencedColumnName = "id", nullable = false) })
  private ItemEntity item;

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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
