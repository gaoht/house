package com.ziroom.ziroomcustomer.findhouse.model;

import com.baidu.mapapi.model.LatLng;

public class Region
  extends MapMarkerData
  implements ImapLatLng
{
  private String almost;
  private String building_code;
  private String building_name;
  private Integer count;
  private Double distance;
  private Integer duration;
  private String icon;
  private Double lat;
  private Double lng;
  private Integer min_price;
  private String msg;
  private Double touch_lat;
  private Double touch_lng;
  private Integer type;
  
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
  
  public Integer getCount()
  {
    return this.count;
  }
  
  public Double getDistance()
  {
    return this.distance;
  }
  
  public Integer getDuration()
  {
    return this.duration;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public Double getLat()
  {
    return this.lat;
  }
  
  public LatLng getLatLng()
  {
    if ((this.lat == null) || (this.lng == null)) {
      return null;
    }
    return new LatLng(this.lat.doubleValue(), this.lng.doubleValue());
  }
  
  public Double getLng()
  {
    return this.lng;
  }
  
  public String getMapMarkerCode()
  {
    return this.building_code;
  }
  
  public String getMapMarkerDesc()
  {
    if ((this.type.intValue() == 1) || (this.type.intValue() == 2)) {
      return this.almost;
    }
    if (this.type.intValue() == 3) {
      return "¥" + this.min_price + "起";
    }
    return "";
  }
  
  public String getMapMarkerIcon()
  {
    return this.icon;
  }
  
  public String getMapMarkerName()
  {
    return this.building_name;
  }
  
  public Integer getMin_price()
  {
    return this.min_price;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public LatLng getTouchLatLng()
  {
    if ((this.touch_lat != null) && (this.touch_lng != null)) {
      return new LatLng(this.touch_lat.doubleValue(), this.touch_lng.doubleValue());
    }
    return getLatLng();
  }
  
  public Double getTouch_lat()
  {
    return this.touch_lat;
  }
  
  public Double getTouch_lng()
  {
    return this.touch_lng;
  }
  
  public int getType()
  {
    return this.type.intValue();
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
  
  public void setCount(Integer paramInteger)
  {
    this.count = paramInteger;
  }
  
  public void setDistance(Double paramDouble)
  {
    this.distance = paramDouble;
  }
  
  public void setDuration(Integer paramInteger)
  {
    this.duration = paramInteger;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setLat(Double paramDouble)
  {
    this.lat = paramDouble;
  }
  
  public void setLng(Double paramDouble)
  {
    this.lng = paramDouble;
  }
  
  public void setMin_price(Integer paramInteger)
  {
    this.min_price = paramInteger;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setTouch_lat(Double paramDouble)
  {
    this.touch_lat = paramDouble;
  }
  
  public void setTouch_lng(Double paramDouble)
  {
    this.touch_lng = paramDouble;
  }
  
  public void setType(Integer paramInteger)
  {
    this.type = paramInteger;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/Region.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */