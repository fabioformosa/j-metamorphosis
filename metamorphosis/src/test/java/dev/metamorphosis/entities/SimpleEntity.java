package dev.metamorphosis.entities;

import javax.persistence.Entity;

@Entity
public class SimpleEntity {

  private Long id;
  private String foo;
  private String bar;

  public Long getId() {
    return id;
  }

  public String getFoo() {
    return foo;
  }

  public void setFoo(String foo) {
    this.foo = foo;
  }

  public String getBar() {
    return bar;
  }

  public void setBar(String bar) {
    this.bar = bar;
  }

  public void setId(Long id) {
    this.id = id;
  }



}
