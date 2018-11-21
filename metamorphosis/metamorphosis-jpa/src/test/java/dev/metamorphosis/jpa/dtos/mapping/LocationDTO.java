package dev.metamorphosis.jpa.dtos.mapping;

public class LocationDTO {

  private Long id;
  private String name;

  private String latitude;
  private String longitude;

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

}
