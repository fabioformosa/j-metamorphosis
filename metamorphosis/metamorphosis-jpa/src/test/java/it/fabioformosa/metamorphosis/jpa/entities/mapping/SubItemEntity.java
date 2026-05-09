package it.fabioformosa.metamorphosis.jpa.entities.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

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
