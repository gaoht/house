package com.ziroom.ziroomcustomer.findhouse.model;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

public class MapDistrictBean
  extends MapMarkerData
  implements ImapLatLng
{
  private String almost;
  private int count;
  private String district_code;
  private String district_name;
  private double lat;
  private double lng;
  
  public String getAlmost()
  {
    return this.almost;
  }
  
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
    return this.district_code;
  }
  
  public String getMapMarkerDesc()
  {
    if (!TextUtils.isEmpty(this.almost)) {
      return this.almost;
    }
    return "";
  }
  
  public String getMapMarkerIcon()
  {
    return null;
  }
  
  public String getMapMarkerName()
  {
    return this.district_name;
  }
  
  public LatLng getTouchLatLng()
  {
    return getLatLng();
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void setAlmost(String paramString)
  {
    this.almost = paramString;
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
  
  public void setLat(double paramDouble)
  {
    this.lat = paramDouble;
  }
  
  public void setLng(double paramDouble)
  {
    this.lng = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/MapDistrictBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */