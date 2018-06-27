package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;

public class ReverseGeoCodeOption
{
  LatLng a = null;
  
  public ReverseGeoCodeOption location(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/ReverseGeoCodeOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */