package com.baidu.mapapi.search.poi;

public class PoiIndoorOption
{
  String a;
  String b;
  String c;
  int d = 0;
  int e = 10;
  
  public PoiIndoorOption poiCurrentPage(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public PoiIndoorOption poiFloor(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public PoiIndoorOption poiIndoorBid(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public PoiIndoorOption poiIndoorWd(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public PoiIndoorOption poiPageSize(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiIndoorOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */