package dev.metamorphosis.dtos.mapping;

import java.io.Serializable;

public class EnumDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String enumValue;

  private String enumLabel;

  public EnumDTO() {
    super();
  }

  public EnumDTO(String enumValue, String enumLabel) {
    super();
    this.enumValue = enumValue;
    this.enumLabel = enumLabel;
  }

  public String getEnumLabel() {
    return enumLabel;
  }

  public String getEnumValue() {
    return enumValue;
  }

  public void setEnumLabel(String enumLabel) {
    this.enumLabel = enumLabel;
  }

  public void setEnumValue(String enumValue) {
    this.enumValue = enumValue;
  }

}
