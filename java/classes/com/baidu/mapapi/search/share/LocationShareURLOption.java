package com.baidu.mapapi.search.share;

import com.baidu.mapapi.model.LatLng;

public class LocationShareURLOption
{
  LatLng a = null;
  String b = null;
  String c = null;
  
  public LocationShareURLOption location(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public LocationShareURLOption name(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public LocationShareURLOption snippet(String paramString)
  {
    this.c = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/LocationShareURLOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */