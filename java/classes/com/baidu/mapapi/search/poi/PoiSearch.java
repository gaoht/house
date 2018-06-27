package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.b;
import java.util.HashMap;
import java.util.Map;

public class PoiSearch
  extends g
{
  private com.baidu.platform.comapi.search.d a = null;
  private OnGetPoiSearchResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  private boolean f;
  private int g = 0;
  
  PoiSearch()
  {
    this.a.a(new a(null));
  }
  
  public static PoiSearch newInstance()
  {
    BMapManager.init();
    return new PoiSearch();
  }
  
  public void destroy()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b = null;
    this.a.a();
    this.a = null;
    BMapManager.destroy();
  }
  
  public boolean searchInBound(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiBoundSearchOption == null) || (paramPoiBoundSearchOption.a == null) || (paramPoiBoundSearchOption.b == null)) {
      throw new IllegalArgumentException("option or bound or keyworld can not be null");
    }
    this.d = this.e;
    this.e = 2;
    this.g = paramPoiBoundSearchOption.d;
    this.a.a(paramPoiBoundSearchOption.e);
    MapBound localMapBound = new MapBound();
    localMapBound.setPtRT(CoordUtil.ll2point(paramPoiBoundSearchOption.a.northeast));
    localMapBound.setPtLB(CoordUtil.ll2point(paramPoiBoundSearchOption.a.southwest));
    return this.a.a(paramPoiBoundSearchOption.b, 1, paramPoiBoundSearchOption.d, localMapBound, (int)paramPoiBoundSearchOption.c, null, null);
  }
  
  public boolean searchInCity(PoiCitySearchOption paramPoiCitySearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiCitySearchOption == null) || (paramPoiCitySearchOption.a == null) || (paramPoiCitySearchOption.b == null)) {
      throw new IllegalArgumentException("option or city or keyworld can not be null");
    }
    this.d = this.e;
    this.e = 1;
    this.g = paramPoiCitySearchOption.e;
    this.a.a(paramPoiCitySearchOption.f);
    return this.a.a(paramPoiCitySearchOption.b, paramPoiCitySearchOption.a, paramPoiCitySearchOption.e, null, (int)paramPoiCitySearchOption.c, null);
  }
  
  public boolean searchNearby(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiNearbySearchOption == null) || (paramPoiNearbySearchOption.b == null) || (paramPoiNearbySearchOption.a == null)) {
      throw new IllegalArgumentException("option or location or keyworld can not be null");
    }
    if (paramPoiNearbySearchOption.c <= 0) {
      return false;
    }
    this.d = this.e;
    this.e = 3;
    this.g = paramPoiNearbySearchOption.e;
    this.a.a(paramPoiNearbySearchOption.f);
    Object localObject2 = CoordUtil.ll2point(paramPoiNearbySearchOption.b);
    Object localObject1 = new Point(((Point)localObject2).x - paramPoiNearbySearchOption.c, ((Point)localObject2).y - paramPoiNearbySearchOption.c);
    Point localPoint = new Point(((Point)localObject2).x + paramPoiNearbySearchOption.c, ((Point)localObject2).y + paramPoiNearbySearchOption.c);
    localObject2 = new MapBound();
    ((MapBound)localObject2).setPtLB((Point)localObject1);
    ((MapBound)localObject2).setPtRT(localPoint);
    localObject1 = new HashMap();
    ((Map)localObject1).put("distance", Integer.valueOf(paramPoiNearbySearchOption.c));
    return this.a.a(paramPoiNearbySearchOption.a, 1, paramPoiNearbySearchOption.e, (int)paramPoiNearbySearchOption.d, (MapBound)localObject2, (MapBound)localObject2, (Map)localObject1, paramPoiNearbySearchOption.g.ordinal());
  }
  
  public boolean searchPoiDetail(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiDetailSearchOption == null) || (paramPoiDetailSearchOption.a == null)) {
      throw new IllegalArgumentException("option or uid can not be null");
    }
    this.d = this.e;
    this.e = 4;
    this.f = paramPoiDetailSearchOption.b;
    return this.a.a(paramPoiDetailSearchOption.a);
  }
  
  public boolean searchPoiIndoor(PoiIndoorOption paramPoiIndoorOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiIndoorOption == null) || (paramPoiIndoorOption.a == null) || (paramPoiIndoorOption.b == null)) {
      throw new IllegalArgumentException("option or indoor bid or keyword can not be null");
    }
    this.d = this.e;
    this.e = 5;
    return this.a.a(paramPoiIndoorOption.a, paramPoiIndoorOption.b, paramPoiIndoorOption.d, paramPoiIndoorOption.e, paramPoiIndoorOption.c);
  }
  
  public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener)
  {
    this.b = paramOnGetPoiSearchResultListener;
  }
  
  private class a
    implements b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (PoiSearch.b(PoiSearch.this) == null)) {}
      SearchResult.ERRORNO localERRORNO;
      for (;;)
      {
        return;
        localERRORNO = null;
        switch (paramInt)
        {
        }
        while (localERRORNO != null)
        {
          if (PoiSearch.e(PoiSearch.this) != 4) {
            break label192;
          }
          PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(new PoiDetailResult(localERRORNO));
          return;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.KEY_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_TIME_OUT;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          continue;
          localERRORNO = SearchResult.ERRORNO.POIINDOOR_BID_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.POIINDOOR_FLOOR_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.POIINDOOR_SERVER_ERROR;
        }
      }
      label192:
      if (PoiSearch.e(PoiSearch.this) == 5)
      {
        PoiSearch.b(PoiSearch.this).onGetPoiIndoorResult(new PoiIndoorResult(localERRORNO));
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiResult(new PoiResult(localERRORNO));
    }
    
    public void a(String paramString)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null)) {
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiResult(d.a(paramString, PoiSearch.c(PoiSearch.this), PoiSearch.d(PoiSearch.this).b()));
    }
    
    public void b(String paramString)
    {
      if ((paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null)) {
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiResult(d.a(paramString));
    }
    
    public void c(String paramString) {}
    
    public void d(String paramString)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null)) {
        return;
      }
      PoiDetailResult localPoiDetailResult = new PoiDetailResult();
      if (localPoiDetailResult.a(paramString))
      {
        PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(localPoiDetailResult);
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(new PoiDetailResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
    }
    
    public void e(String paramString) {}
    
    public void f(String paramString) {}
    
    public void g(String paramString) {}
    
    public void h(String paramString) {}
    
    public void i(String paramString) {}
    
    public void j(String paramString) {}
    
    public void k(String paramString) {}
    
    public void l(String paramString) {}
    
    public void m(String paramString) {}
    
    public void n(String paramString)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null)) {
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiIndoorResult(d.b(paramString));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */