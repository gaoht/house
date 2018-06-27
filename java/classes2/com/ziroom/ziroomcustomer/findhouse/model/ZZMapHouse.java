package com.ziroom.ziroomcustomer.findhouse.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZZMapHouse
  extends b
{
  private List<DataEntity> data;
  
  public List<DataEntity> getData()
  {
    return this.data;
  }
  
  public int getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(List<DataEntity> paramList)
  {
    this.data = paramList;
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataEntity
  {
    private String bizcircle_name;
    private String build_year;
    private String district_name;
    private String floor;
    private String floor_total;
    private double house_area;
    private int house_bedroom;
    private int house_code;
    private String house_face;
    private String house_id;
    private String house_name;
    private String house_name_short;
    private String house_number;
    private int house_parlor;
    private String house_photo;
    private String house_photo_min;
    private int house_price;
    private int house_type;
    private double lat;
    private double lng;
    private String price_unit;
    private String resblock_id;
    private String resblock_name;
    private int short_dayRental;
    private String subway_station_info;
    private int supply_heat;
    
    public String getBizcircle_name()
    {
      return this.bizcircle_name;
    }
    
    public String getBuild_year()
    {
      return this.build_year;
    }
    
    public String getDistrict_name()
    {
      return this.district_name;
    }
    
    public String getFloor()
    {
      return this.floor;
    }
    
    public String getFloor_total()
    {
      return this.floor_total;
    }
    
    public double getHouse_area()
    {
      return this.house_area;
    }
    
    public int getHouse_bedroom()
    {
      return this.house_bedroom;
    }
    
    public int getHouse_code()
    {
      return this.house_code;
    }
    
    public String getHouse_face()
    {
      return this.house_face;
    }
    
    public String getHouse_id()
    {
      return this.house_id;
    }
    
    public String getHouse_name()
    {
      return this.house_name;
    }
    
    public String getHouse_name_short()
    {
      return this.house_name_short;
    }
    
    public String getHouse_number()
    {
      return this.house_number;
    }
    
    public int getHouse_parlor()
    {
      return this.house_parlor;
    }
    
    public String getHouse_photo()
    {
      return this.house_photo;
    }
    
    public String getHouse_photo_min()
    {
      return this.house_photo_min;
    }
    
    public int getHouse_price()
    {
      return this.house_price;
    }
    
    public int getHouse_type()
    {
      return this.house_type;
    }
    
    public double getLat()
    {
      return this.lat;
    }
    
    public double getLng()
    {
      return this.lng;
    }
    
    public String getPrice_unit()
    {
      return this.price_unit;
    }
    
    public String getResblock_id()
    {
      return this.resblock_id;
    }
    
    public String getResblock_name()
    {
      return this.resblock_name;
    }
    
    public int getShort_dayRental()
    {
      return this.short_dayRental;
    }
    
    public String getSubway_station_info()
    {
      return this.subway_station_info;
    }
    
    public int getSupply_heat()
    {
      return this.supply_heat;
    }
    
    public void setBizcircle_name(String paramString)
    {
      this.bizcircle_name = paramString;
    }
    
    public void setBuild_year(String paramString)
    {
      this.build_year = paramString;
    }
    
    public void setDistrict_name(String paramString)
    {
      this.district_name = paramString;
    }
    
    public void setFloor(String paramString)
    {
      this.floor = paramString;
    }
    
    public void setFloor_total(String paramString)
    {
      this.floor_total = paramString;
    }
    
    public void setHouse_area(double paramDouble)
    {
      this.house_area = paramDouble;
    }
    
    public void setHouse_bedroom(int paramInt)
    {
      this.house_bedroom = paramInt;
    }
    
    public void setHouse_code(int paramInt)
    {
      this.house_code = paramInt;
    }
    
    public void setHouse_face(String paramString)
    {
      this.house_face = paramString;
    }
    
    public void setHouse_id(String paramString)
    {
      this.house_id = paramString;
    }
    
    public void setHouse_name(String paramString)
    {
      this.house_name = paramString;
    }
    
    public void setHouse_name_short(String paramString)
    {
      this.house_name_short = paramString;
    }
    
    public void setHouse_number(String paramString)
    {
      this.house_number = paramString;
    }
    
    public void setHouse_parlor(int paramInt)
    {
      this.house_parlor = paramInt;
    }
    
    public void setHouse_photo(String paramString)
    {
      this.house_photo = paramString;
    }
    
    public void setHouse_photo_min(String paramString)
    {
      this.house_photo_min = paramString;
    }
    
    public void setHouse_price(int paramInt)
    {
      this.house_price = paramInt;
    }
    
    public void setHouse_type(int paramInt)
    {
      this.house_type = paramInt;
    }
    
    public void setLat(double paramDouble)
    {
      this.lat = paramDouble;
    }
    
    public void setLng(double paramDouble)
    {
      this.lng = paramDouble;
    }
    
    public void setPrice_unit(String paramString)
    {
      this.price_unit = paramString;
    }
    
    public void setResblock_id(String paramString)
    {
      this.resblock_id = paramString;
    }
    
    public void setResblock_name(String paramString)
    {
      this.resblock_name = paramString;
    }
    
    public void setShort_dayRental(int paramInt)
    {
      this.short_dayRental = paramInt;
    }
    
    public void setSubway_station_info(String paramString)
    {
      this.subway_station_info = paramString;
    }
    
    public void setSupply_heat(int paramInt)
    {
      this.supply_heat = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZMapHouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */