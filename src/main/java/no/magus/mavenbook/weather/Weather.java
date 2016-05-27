package no.magus.mavenbook.weather;

public class Weather {
  private String city;
  private String region;
  private String country;
  private String temp;
  private String windspeed;
  
  public Weather() {}
  
  public String getWindspeed() { return windspeed; }
  
  public void setWindspeed(String windspeed) {
	  this.windspeed = windspeed;
  }
  public String getCity() { return city; }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getRegion() { return region; }
  
  public void setRegion(String region) {
    this.region = region;
  }
  
  public String getCountry() { return country; }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public String getTemp() { return temp; }
  
  public void setTemp(String temp) {
    this.temp = temp;
  }

}