package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;

public class PoiBoundSearchOption
{
  LatLngBounds a = null;
  String b = null;
  float c = 12.0F;
  int d = 0;
  int e = 10;
  
  public PoiBoundSearchOption bound(LatLngBounds paramLatLngBounds)
  {
    this.a = paramLatLngBounds;
    return this;
  }
  
  public PoiBoundSearchOption keyword(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public PoiBoundSearchOption pageCapacity(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public PoiBoundSearchOption pageNum(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiBoundSearchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */