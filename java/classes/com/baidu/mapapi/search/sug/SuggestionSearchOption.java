package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;

public class SuggestionSearchOption
{
  String a = null;
  String b = null;
  LatLng c = null;
  
  public SuggestionSearchOption city(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public SuggestionSearchOption keyword(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public SuggestionSearchOption location(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/SuggestionSearchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */