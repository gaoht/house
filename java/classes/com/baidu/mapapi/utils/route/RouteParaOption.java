package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;

public class RouteParaOption
{
  LatLng a;
  LatLng b;
  String c;
  String d;
  String e;
  EBusStrategyType f = EBusStrategyType.bus_recommend_way;
  
  public RouteParaOption busStrategyType(EBusStrategyType paramEBusStrategyType)
  {
    this.f = paramEBusStrategyType;
    return this;
  }
  
  public RouteParaOption cityName(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public RouteParaOption endName(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public RouteParaOption endPoint(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }
  
  public EBusStrategyType getBusStrategyType()
  {
    return this.f;
  }
  
  public String getCityName()
  {
    return this.e;
  }
  
  public String getEndName()
  {
    return this.d;
  }
  
  public LatLng getEndPoint()
  {
    return this.b;
  }
  
  public String getStartName()
  {
    return this.c;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
  }
  
  public RouteParaOption startName(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public RouteParaOption startPoint(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public static enum EBusStrategyType
  {
    static
    {
      bus_no_subway = new EBusStrategyType("bus_no_subway", 3);
      bus_recommend_way = new EBusStrategyType("bus_recommend_way", 4);
    }
    
    private EBusStrategyType() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/route/RouteParaOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */