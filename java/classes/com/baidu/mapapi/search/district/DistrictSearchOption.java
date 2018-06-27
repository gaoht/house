package com.baidu.mapapi.search.district;

public class DistrictSearchOption
{
  String a;
  String b;
  
  public DistrictSearchOption cityName(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public DistrictSearchOption districtName(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/district/DistrictSearchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */