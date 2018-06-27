package com.ziroom.ziroomcustomer.findhouse.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZZMapDistrict
  extends b
{
  private List<DataEntity> data;
  
  public List<DataEntity> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataEntity> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataEntity
  {
    private int count;
    private String district_code;
    private String district_name;
    private int house_counts;
    private double lat;
    private double lng;
    private String lng_lat;
    
    public int getCount()
    {
      return this.count;
    }
    
    public String getDistrict_code()
    {
      return this.district_code;
    }
    
    public String getDistrict_name()
    {
      return this.district_name;
    }
    
    public int getHouse_counts()
    {
      return this.house_counts;
    }
    
    public double getLat()
    {
      return this.lat;
    }
    
    public double getLng()
    {
      return this.lng;
    }
    
    public String getLng_lat()
    {
      return this.lng_lat;
    }
    
    public void setCount(int paramInt)
    {
      this.count = paramInt;
    }
    
    public void setDistrict_code(String paramString)
    {
      this.district_code = paramString;
    }
    
    public void setDistrict_name(String paramString)
    {
      this.district_name = paramString;
    }
    
    public void setHouse_counts(int paramInt)
    {
      this.house_counts = paramInt;
    }
    
    public void setLat(double paramDouble)
    {
      this.lat = paramDouble;
    }
    
    public void setLng(double paramDouble)
    {
      this.lng = paramDouble;
    }
    
    public void setLng_lat(String paramString)
    {
      this.lng_lat = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZMapDistrict.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */