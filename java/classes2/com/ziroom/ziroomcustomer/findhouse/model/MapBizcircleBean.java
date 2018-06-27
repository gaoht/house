package com.ziroom.ziroomcustomer.findhouse.model;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

public class MapBizcircleBean
  extends MapMarkerData
  implements ImapLatLng
{
  private String almost;
  private String bizcircle_code;
  private String bizcircle_name;
  private int count;
  private double lat;
  private double lng;
  
  public String getAlmost()
  {
    return this.almost;
  }
  
  public String getBizcircle_code()
  {
    return this.bizcircle_code;
  }
  
  public String getBizcircle_name()
  {
    return this.bizcircle_name;
  }
  
  public int getCount()
  {
    return this.count;
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
    return this.bizcircle_code;
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
    return this.bizcircle_name;
  }
  
  public LatLng getTouchLatLng()
  {
    return getLatLng();
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void setAlmost(String paramString)
  {
    this.almost = paramString;
  }
  
  public void setBizcircle_code(String paramString)
  {
    this.bizcircle_code = paramString;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.bizcircle_name = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/MapBizcircleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */