package com.ziroom.ziroomcustomer.model;

import com.freelxl.baselibrary.b.b;

public class Find_Tab_list
  extends b
{
  public data data;
  
  public static class all
  {
    public String bizcircle_name;
    public String district_name;
    public String house_code;
    public String house_dw;
    public String house_id;
    public String house_photo;
    public String house_price;
    public String house_type;
    public String subway_station_code;
  }
  
  public class data
  {
    public Find_Tab_list.all all_rent_info;
    public Find_Tab_list.joint joint_rent_info;
    public Find_Tab_list.relet relet_info;
    public Find_Tab_list.short_rent short_rent_info;
    
    public data() {}
  }
  
  public static class joint
  {
    public String bizcircle_name;
    public String district_name;
    public String house_code;
    public String house_dw;
    public String house_id;
    public String house_photo;
    public String house_price;
    public String house_type;
    public String subway_station_code;
  }
  
  public static class relet
  {
    public String bizcircle_name;
    public String district_name;
    public String house_code;
    public String house_dw;
    public String house_id;
    public String house_photo;
    public String house_price;
    public String house_type;
    public String subway_station_code;
  }
  
  public static class short_rent
  {
    public String bizcircle_name;
    public String district_name;
    public String house_code;
    public String house_dw;
    public String house_id;
    public String house_photo;
    public String house_price;
    public String house_type;
    public String subway_station_code;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Find_Tab_list.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */