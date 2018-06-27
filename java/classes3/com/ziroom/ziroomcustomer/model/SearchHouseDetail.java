package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class SearchHouseDetail
  implements Serializable
{
  private String house_code;
  private String house_lat;
  private String house_lng;
  private String house_name;
  private String house_photos;
  private String house_price;
  private List<String> house_tags;
  private int house_type;
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_lat()
  {
    return this.house_lat;
  }
  
  public String getHouse_lng()
  {
    return this.house_lng;
  }
  
  public String getHouse_name()
  {
    return this.house_name;
  }
  
  public String getHouse_photos()
  {
    return this.house_photos;
  }
  
  public String getHouse_price()
  {
    return this.house_price;
  }
  
  public List<String> getHouse_tags()
  {
    return this.house_tags;
  }
  
  public int getHouse_type()
  {
    return this.house_type;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_lat(String paramString)
  {
    this.house_lat = paramString;
  }
  
  public void setHouse_lng(String paramString)
  {
    this.house_lng = paramString;
  }
  
  public void setHouse_name(String paramString)
  {
    this.house_name = paramString;
  }
  
  public void setHouse_photos(String paramString)
  {
    this.house_photos = paramString;
  }
  
  public void setHouse_price(String paramString)
  {
    this.house_price = paramString;
  }
  
  public void setHouse_tags(List<String> paramList)
  {
    this.house_tags = paramList;
  }
  
  public void setHouse_type(int paramInt)
  {
    this.house_type = paramInt;
  }
  
  public String toString()
  {
    return "SearchHouseDetail [house_type=" + this.house_type + ", house_code=" + this.house_code + ", house_photos=" + this.house_photos + ", house_price=" + this.house_price + ", house_name=" + this.house_name + ", house_lng=" + this.house_lng + ", house_lat=" + this.house_lat + ", house_tags=" + this.house_tags + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SearchHouseDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */