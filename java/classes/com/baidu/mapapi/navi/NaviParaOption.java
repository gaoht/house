package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

public class NaviParaOption
{
  LatLng a;
  String b;
  LatLng c;
  String d;
  
  public NaviParaOption endName(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public NaviParaOption endPoint(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public String getEndName()
  {
    return this.d;
  }
  
  public LatLng getEndPoint()
  {
    return this.c;
  }
  
  public String getStartName()
  {
    return this.b;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
  }
  
  public NaviParaOption startName(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public NaviParaOption startPoint(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/navi/NaviParaOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */