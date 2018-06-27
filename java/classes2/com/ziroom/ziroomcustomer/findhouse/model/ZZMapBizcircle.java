package com.ziroom.ziroomcustomer.findhouse.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZZMapBizcircle
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
    private String bizcircle_code;
    private String bizcircle_name;
    private int house_counts;
    private double lat;
    private double lng;
    
    public String getBizcircle_code()
    {
      return this.bizcircle_code;
    }
    
    public String getBizcircle_name()
    {
      return this.bizcircle_name;
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
    
    public void setBizcircle_code(String paramString)
    {
      this.bizcircle_code = paramString;
    }
    
    public void setBizcircle_name(String paramString)
    {
      this.bizcircle_name = paramString;
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
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZMapBizcircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */