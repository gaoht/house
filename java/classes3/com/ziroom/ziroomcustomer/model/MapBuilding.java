package com.ziroom.ziroomcustomer.model;

public class MapBuilding
{
  private String building_code;
  private String building_name;
  private String house_counts;
  private String house_minPrice;
  private String lat;
  private String lng;
  private String lng_lat;
  private String to_commute_time;
  
  public String getBuilding_code()
  {
    return this.building_code;
  }
  
  public String getBuilding_name()
  {
    return this.building_name;
  }
  
  public String getHouse_counts()
  {
    return this.house_counts;
  }
  
  public String getHouse_minPrice()
  {
    return this.house_minPrice;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLng()
  {
    return this.lng;
  }
  
  public String getLng_lat()
  {
    return this.lng + "," + this.lat;
  }
  
  public String getTo_commute_time()
  {
    return this.to_commute_time;
  }
  
  public void setBuilding_code(String paramString)
  {
    this.building_code = paramString;
  }
  
  public void setBuilding_name(String paramString)
  {
    this.building_name = paramString;
  }
  
  public void setHouse_counts(String paramString)
  {
    this.house_counts = paramString;
  }
  
  public void setHouse_minPrice(String paramString)
  {
    this.house_minPrice = paramString;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLng(String paramString)
  {
    this.lng = paramString;
  }
  
  public void setLng_lat(String paramString)
  {
    this.lng_lat = paramString;
  }
  
  public void setTo_commute_time(String paramString)
  {
    this.to_commute_time = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MapBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */