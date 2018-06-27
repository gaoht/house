package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import com.baidu.mapapi.model.LatLng;
import com.ziroom.ziroomcustomer.findhouse.model.ImapLatLng;
import com.ziroom.ziroomcustomer.findhouse.model.MapMarkerData;

public abstract class MinsuMapBean
  extends MapMarkerData
  implements ImapLatLng
{
  private double latitude;
  private double longitude;
  private String name;
  private String num;
  
  public LatLng getLatLng()
  {
    return new LatLng(this.latitude, this.longitude);
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getMapMarkerCode()
  {
    return null;
  }
  
  public String getMapMarkerDesc()
  {
    return this.num + "间";
  }
  
  public String getMapMarkerIcon()
  {
    return null;
  }
  
  public String getMapMarkerName()
  {
    return this.name;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNum()
  {
    return this.num;
  }
  
  public LatLng getTouchLatLng()
  {
    return getLatLng();
  }
  
  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNum(String paramString)
  {
    this.num = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/MinsuMapBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */