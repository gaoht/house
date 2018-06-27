package com.ziroom.ziroomcustomer.findhouse.model;

import com.baidu.mapapi.model.LatLng;

public class MapBuildingBean
  extends MapMarkerData
  implements ImapLatLng
{
  private String almost;
  private String building_code;
  private String building_name;
  private int count;
  private String icon;
  private double lat;
  private double lng;
  private int min_price;
  
  public String getAlmost()
  {
    return this.almost;
  }
  
  public String getBuilding_code()
  {
    return this.building_code;
  }
  
  public String getBuilding_name()
  {
    return this.building_name;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public double getLat()
  {
    return this.lat;
  }
  
  public LatLng getLatLng()
  {
    return new LatLng(this.lat, this.lng);
  }
  
  public double getLng()
  {
    return this.lng;
  }
  
  public String getMapMarkerCode()
  {
    return this.building_code;
  }
  
  public String getMapMarkerDesc()
  {
    return "¥" + this.min_price + "起";
  }
  
  public String getMapMarkerIcon()
  {
    return this.icon;
  }
  
  public String getMapMarkerName()
  {
    return this.building_name;
  }
  
  public int getMin_price()
  {
    return this.min_price;
  }
  
  public LatLng getTouchLatLng()
  {
    return getLatLng();
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void setAlmost(String paramString)
  {
    this.almost = paramString;
  }
  
  public void setBuilding_code(String paramString)
  {
    this.building_code = paramString;
  }
  
  public void setBuilding_name(String paramString)
  {
    this.building_name = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setLat(double paramDouble)
  {
    this.lat = paramDouble;
  }
  
  public void setLng(double paramDouble)
  {
    this.lng = paramDouble;
  }
  
  public void setMin_price(int paramInt)
  {
    this.min_price = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/MapBuildingBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */