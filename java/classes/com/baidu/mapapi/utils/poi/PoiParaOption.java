package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiParaOption
{
  String a;
  String b;
  LatLng c;
  int d;
  
  public PoiParaOption center(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.c;
  }
  
  public String getKey()
  {
    return this.b;
  }
  
  public int getRadius()
  {
    return this.d;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public PoiParaOption key(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public PoiParaOption radius(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public PoiParaOption uid(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/poi/PoiParaOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */