package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class desktopSearch
  implements Serializable
{
  private String bizcircle_code = "";
  private String bizcircle_name = "";
  private String city_id = "";
  private String house_type = "合租";
  private String huxing = "";
  private String keyword = "";
  private String max_rentfee = "";
  private String min_rentfee = "";
  private String subway_station_name = "";
  
  public String getBizcircle_code()
  {
    return this.bizcircle_code;
  }
  
  public String getBizcircle_name()
  {
    return this.bizcircle_name;
  }
  
  public String getCity_id()
  {
    return this.city_id;
  }
  
  public String getHouse_type()
  {
    return this.house_type;
  }
  
  public String getHuxing()
  {
    return this.huxing;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getMax_rentfee()
  {
    return this.max_rentfee;
  }
  
  public String getMin_rentfee()
  {
    return this.min_rentfee;
  }
  
  public String getSubway_station_name()
  {
    return this.subway_station_name;
  }
  
  public void setBizcircle_code(String paramString)
  {
    this.bizcircle_code = paramString;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.bizcircle_name = paramString;
  }
  
  public void setCity_id(String paramString)
  {
    this.city_id = paramString;
  }
  
  public void setHouse_type(String paramString)
  {
    this.house_type = paramString;
  }
  
  public void setHuxing(String paramString)
  {
    this.huxing = paramString;
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  public void setMax_rentfee(String paramString)
  {
    this.max_rentfee = paramString;
  }
  
  public void setMin_rentfee(String paramString)
  {
    this.min_rentfee = paramString;
  }
  
  public void setSubway_station_name(String paramString)
  {
    this.subway_station_name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/desktopSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */