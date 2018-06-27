package com.baidu.mapapi.search.busline;

public class BusLineSearchOption
{
  String a = null;
  String b = null;
  
  public BusLineSearchOption city(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public BusLineSearchOption uid(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/busline/BusLineSearchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */