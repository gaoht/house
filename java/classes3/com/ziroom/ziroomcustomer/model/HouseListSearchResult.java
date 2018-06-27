package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class HouseListSearchResult
  implements Serializable
{
  private String bizcircle_name;
  private String block_id;
  private String compartment_face;
  private String house_area;
  private String house_code;
  private String house_company;
  private String house_id;
  private String house_lat;
  private String house_lng;
  private String house_name;
  private String house_num;
  private String house_photos;
  private String house_price;
  private List<String> house_tags;
  private int house_type;
  private int is_add;
  private int is_duanzu;
  private int is_recommend = 0;
  private int is_reserve;
  private String ju_num;
  private String resblock_id;
  private String resblock_name;
  private String style_tag;
  private String subway_station_info;
  private String supply_heat;
  private String to_see_state;
  
  public String getBizcircle_name()
  {
    return this.bizcircle_name;
  }
  
  public String getBlock_id()
  {
    return this.block_id;
  }
  
  public String getCompartment_face()
  {
    return this.compartment_face;
  }
  
  public String getHouse_area()
  {
    return this.house_area;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_company()
  {
    return this.house_company;
  }
  
  public String getHouse_id()
  {
    return this.house_id;
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
  
  public String getHouse_num()
  {
    return this.house_num;
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
  
  public int getIs_add()
  {
    return this.is_add;
  }
  
  public int getIs_duanzu()
  {
    return this.is_duanzu;
  }
  
  public int getIs_recommend()
  {
    return this.is_recommend;
  }
  
  public int getIs_reserve()
  {
    return this.is_reserve;
  }
  
  public String getJu_num()
  {
    return this.ju_num;
  }
  
  public String getResblock_id()
  {
    return this.resblock_id;
  }
  
  public String getResblock_name()
  {
    return this.resblock_name;
  }
  
  public String getStyle_tag()
  {
    return this.style_tag;
  }
  
  public String getSubway_station_info()
  {
    return this.subway_station_info;
  }
  
  public String getSupply_heat()
  {
    return this.supply_heat;
  }
  
  public String getTo_see_state()
  {
    return this.to_see_state;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.bizcircle_name = paramString;
  }
  
  public void setBlock_id(String paramString)
  {
    this.block_id = paramString;
  }
  
  public void setCompartment_face(String paramString)
  {
    this.compartment_face = paramString;
  }
  
  public void setHouse_area(String paramString)
  {
    this.house_area = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_company(String paramString)
  {
    this.house_company = paramString;
  }
  
  public void setHouse_id(String paramString)
  {
    this.house_id = paramString;
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
  
  public void setHouse_num(String paramString)
  {
    this.house_num = paramString;
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
  
  public void setIs_add(int paramInt)
  {
    this.is_add = paramInt;
  }
  
  public void setIs_duanzu(int paramInt)
  {
    this.is_duanzu = paramInt;
  }
  
  public void setIs_recommend(int paramInt)
  {
    this.is_recommend = paramInt;
  }
  
  public void setIs_reserve(int paramInt)
  {
    this.is_reserve = paramInt;
  }
  
  public void setJu_num(String paramString)
  {
    this.ju_num = paramString;
  }
  
  public void setResblock_id(String paramString)
  {
    this.resblock_id = paramString;
  }
  
  public void setResblock_name(String paramString)
  {
    this.resblock_name = paramString;
  }
  
  public void setStyle_tag(String paramString)
  {
    this.style_tag = paramString;
  }
  
  public void setSubway_station_info(String paramString)
  {
    this.subway_station_info = paramString;
  }
  
  public void setSupply_heat(String paramString)
  {
    this.supply_heat = paramString;
  }
  
  public void setTo_see_state(String paramString)
  {
    this.to_see_state = paramString;
  }
  
  public String toString()
  {
    return "HouseListSearchResult [house_type=" + this.house_type + ", house_code=" + this.house_code + ", house_id=" + this.house_id + ", house_photos=" + this.house_photos + ", house_tags=" + this.house_tags + ", house_price=" + this.house_price + ", house_name=" + this.house_name + ", house_lng=" + this.house_lng + ", house_lat=" + this.house_lat + ", to_see_state=" + this.to_see_state + ", is_duanzu=" + this.is_duanzu + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseListSearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */