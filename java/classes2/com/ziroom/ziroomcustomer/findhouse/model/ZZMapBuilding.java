package com.ziroom.ziroomcustomer.findhouse.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZZMapBuilding
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
    private String building_code;
    private String building_name;
    private int house_counts;
    private int house_minPrice;
    private double lat;
    private double lng;
    
    public String getBuilding_code()
    {
      return this.building_code;
    }
    
    public String getBuilding_name()
    {
      return this.building_name;
    }
    
    public int getHouse_counts()
    {
      return this.house_counts;
    }
    
    public int getHouse_minPrice()
    {
      return this.house_minPrice;
    }
    
    public double getLat()
    {
      return this.lat;
    }
    
    public double getLng()
    {
      return this.lng;
    }
    
    public void setBuilding_code(String paramString)
    {
      this.building_code = paramString;
    }
    
    public void setBuilding_name(String paramString)
    {
      this.building_name = paramString;
    }
    
    public void setHouse_counts(int paramInt)
    {
      this.house_counts = paramInt;
    }
    
    public void setHouse_minPrice(int paramInt)
    {
      this.house_minPrice = paramInt;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZMapBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */