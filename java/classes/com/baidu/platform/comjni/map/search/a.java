package com.baidu.platform.comjni.map.search;

import android.os.Bundle;

public class a
{
  private static final String a = a.class.getSimpleName();
  private long b = 0L;
  private JNISearch c = null;
  
  public long a()
  {
    this.b = this.c.Create();
    return this.b;
  }
  
  public String a(int paramInt)
  {
    return this.c.GetSearchResult(this.b, paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.c.ReverseGeocodeSearch(this.b, paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return this.c.PoiRGCShareUrlSearch(this.b, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public boolean a(Bundle paramBundle)
  {
    return this.c.ForceSearchByCityName(this.b, paramBundle);
  }
  
  public boolean a(String paramString)
  {
    return this.c.POIDetailSearchPlace(this.b, paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.c.BusLineDetailSearch(this.b, paramString1, paramString2);
  }
  
  public int b()
  {
    return this.c.Release(this.b);
  }
  
  public boolean b(Bundle paramBundle)
  {
    return this.c.AreaSearch(this.b, paramBundle);
  }
  
  public boolean b(String paramString)
  {
    return this.c.PoiDetailShareUrlSearch(this.b, paramString);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return this.c.geocode(this.b, paramString1, paramString2);
  }
  
  public boolean c(Bundle paramBundle)
  {
    return this.c.IndoorSearch(this.b, paramBundle);
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return this.c.districtSearch(this.b, paramString1, paramString2);
  }
  
  public boolean d(Bundle paramBundle)
  {
    return this.c.RoutePlanByBus(this.b, paramBundle);
  }
  
  public boolean e(Bundle paramBundle)
  {
    return this.c.RoutePlanByCar(this.b, paramBundle);
  }
  
  public boolean f(Bundle paramBundle)
  {
    return this.c.RoutePlanByFoot(this.b, paramBundle);
  }
  
  public boolean g(Bundle paramBundle)
  {
    return this.c.routePlanByBike(this.b, paramBundle);
  }
  
  public boolean h(Bundle paramBundle)
  {
    return this.c.SuggestionSearch(this.b, paramBundle);
  }
  
  public boolean i(Bundle paramBundle)
  {
    return this.c.routeShareUrlSearch(this.b, paramBundle);
  }
  
  public boolean j(Bundle paramBundle)
  {
    return this.c.MapBoundSearch(this.b, paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/map/search/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */