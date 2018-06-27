package com.baidu.mapapi.search.geocode;

public class GeoCodeOption
{
  String a = null;
  String b = null;
  
  public GeoCodeOption address(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public GeoCodeOption city(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/GeoCodeOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */