package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiNearbySearchOption
{
  String a = null;
  LatLng b = null;
  int c = -1;
  float d = 12.0F;
  int e = 0;
  int f = 10;
  PoiSortType g = PoiSortType.comprehensive;
  
  public PoiNearbySearchOption keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public PoiNearbySearchOption location(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }
  
  public PoiNearbySearchOption pageCapacity(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption pageNum(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption radius(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption sortType(PoiSortType paramPoiSortType)
  {
    if (paramPoiSortType != null) {
      this.g = paramPoiSortType;
    }
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiNearbySearchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */