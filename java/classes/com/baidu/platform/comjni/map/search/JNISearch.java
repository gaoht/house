package com.baidu.platform.comjni.map.search;

import android.os.Bundle;

public class JNISearch
{
  public native boolean AreaSearch(long paramLong, Bundle paramBundle);
  
  public native boolean BusLineDetailSearch(long paramLong, String paramString1, String paramString2);
  
  public native long Create();
  
  public native boolean ForceSearchByCityName(long paramLong, Bundle paramBundle);
  
  public native String GetSearchResult(long paramLong, int paramInt);
  
  public native boolean IndoorSearch(long paramLong, Bundle paramBundle);
  
  public native boolean MapBoundSearch(long paramLong, Bundle paramBundle);
  
  public native boolean POIDetailSearchPlace(long paramLong, String paramString);
  
  public native boolean PoiDetailShareUrlSearch(long paramLong, String paramString);
  
  public native boolean PoiRGCShareUrlSearch(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public native int Release(long paramLong);
  
  public native boolean ReverseGeocodeSearch(long paramLong, int paramInt1, int paramInt2);
  
  public native boolean RoutePlanByBus(long paramLong, Bundle paramBundle);
  
  public native boolean RoutePlanByCar(long paramLong, Bundle paramBundle);
  
  public native boolean RoutePlanByFoot(long paramLong, Bundle paramBundle);
  
  public native boolean SuggestionSearch(long paramLong, Bundle paramBundle);
  
  public native boolean districtSearch(long paramLong, String paramString1, String paramString2);
  
  public native boolean geocode(long paramLong, String paramString1, String paramString2);
  
  public native boolean routePlanByBike(long paramLong, Bundle paramBundle);
  
  public native boolean routeShareUrlSearch(long paramLong, Bundle paramBundle);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/map/search/JNISearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */