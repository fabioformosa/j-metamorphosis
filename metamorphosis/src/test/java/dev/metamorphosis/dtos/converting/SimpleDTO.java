package dev.metamorphosis.dtos.converting;

public class SimpleDTO {

  private Long id;
  private String foo;

  private String fooBar;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFoo() {
    return foo;
  }

  public void setFoo(String foo) {
    this.foo = foo;
  }

  public String getFooBar() {
    return fooBar;
  }

  public void setFooBar(String fooBar) {
    this.fooBar = fooBar;
  }

  @Override
  public String toString() {
    return "SimpleDTO [id=" + id + ", foo=" + foo + ", fooBar=" + fooBar + "]";
  }


}
