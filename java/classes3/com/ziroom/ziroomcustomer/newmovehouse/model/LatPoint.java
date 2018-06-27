package com.ziroom.ziroomcustomer.newmovehouse.model;

import com.baidu.mapapi.model.LatLng;

public class LatPoint
{
  private String address;
  private LatLng latlng;
  private String name;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public LatLng getLatlng()
  {
    return this.latlng;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setLatlng(LatLng paramLatLng)
  {
    this.latlng = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    String str = "";
    if (this.name != null) {
      str = this.name;
    }
    return str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/LatPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */