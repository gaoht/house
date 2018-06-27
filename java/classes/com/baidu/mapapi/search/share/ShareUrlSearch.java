package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.platform.comapi.search.d;

public class ShareUrlSearch
  extends g
{
  private d a = null;
  private OnGetShareUrlResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  
  ShareUrlSearch()
  {
    this.a.a(new a(null));
  }
  
  private boolean a(String paramString)
  {
    try
    {
      Integer.parseInt(paramString);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public static ShareUrlSearch newInstance()
  {
    BMapManager.init();
    return new ShareUrlSearch();
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
  
  public boolean requestLocationShareUrl(LocationShareURLOption paramLocationShareURLOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramLocationShareURLOption == null) || (paramLocationShareURLOption.a == null) || (paramLocationShareURLOption.b == null) || (paramLocationShareURLOption.c == null)) {
      throw new IllegalArgumentException("option or name or snippet  can not be null");
    }
    this.d = this.e;
    this.e = 2;
    return this.a.a(CoordUtil.ll2point(paramLocationShareURLOption.a), paramLocationShareURLOption.b, paramLocationShareURLOption.c);
  }
  
  public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramPoiDetailShareURLOption == null) || (paramPoiDetailShareURLOption.a == null)) {
      throw new IllegalArgumentException("option or uid can not be null");
    }
    this.d = this.e;
    this.e = 1;
    return this.a.b(paramPoiDetailShareURLOption.a);
  }
  
  public boolean requestRouteShareUrl(RouteShareURLOption paramRouteShareURLOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if (paramRouteShareURLOption == null) {
      throw new IllegalStateException("option is null");
    }
    if (paramRouteShareURLOption.getmMode().ordinal() < 0) {
      return false;
    }
    if ((paramRouteShareURLOption.a == null) || (paramRouteShareURLOption.b == null)) {
      throw new IllegalArgumentException("start or end point can not be null");
    }
    this.d = this.e;
    this.e = 3;
    if (paramRouteShareURLOption.c == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
      if (((paramRouteShareURLOption.a.getLocation() == null) || (paramRouteShareURLOption.b.getLocation() == null)) && (paramRouteShareURLOption.e < 0)) {
        throw new IllegalArgumentException("city code can not be null if don't set start or end point");
      }
    }
    for (boolean bool = this.a.a(CoordUtil.ll2point(paramRouteShareURLOption.a.getLocation()), CoordUtil.ll2point(paramRouteShareURLOption.b.getLocation()), paramRouteShareURLOption.a.getName(), paramRouteShareURLOption.b.getName(), -1, -1, paramRouteShareURLOption.c.ordinal(), paramRouteShareURLOption.e, paramRouteShareURLOption.d);; bool = this.a.a(CoordUtil.ll2point(paramRouteShareURLOption.a.getLocation()), CoordUtil.ll2point(paramRouteShareURLOption.b.getLocation()), paramRouteShareURLOption.a.getName(), paramRouteShareURLOption.b.getName(), b(paramRouteShareURLOption.a.getCity()), b(paramRouteShareURLOption.b.getCity()), paramRouteShareURLOption.c.ordinal(), 0, 0))
    {
      return bool;
      if ((paramRouteShareURLOption.a.getLocation() == null) && (!a(paramRouteShareURLOption.a.getCity()))) {
        throw new IllegalArgumentException("start cityCode must be set if not set start location");
      }
      if ((paramRouteShareURLOption.b.getLocation() == null) && (!a(paramRouteShareURLOption.b.getCity()))) {
        throw new IllegalArgumentException("end cityCode must be set if not set end location");
      }
    }
  }
  
  public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener paramOnGetShareUrlResultListener)
  {
    this.b = paramOnGetShareUrlResultListener;
  }
  
  private class a
    implements com.baidu.platform.comapi.search.b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((ShareUrlSearch.a(ShareUrlSearch.this)) || (ShareUrlSearch.b(ShareUrlSearch.this) == null)) {
        return;
      }
      SearchResult.ERRORNO localERRORNO = null;
      switch (paramInt)
      {
      }
      while (localERRORNO != null) {
        switch (ShareUrlSearch.c(ShareUrlSearch.this))
        {
        default: 
          return;
        case 1: 
          ShareUrlSearch.b(ShareUrlSearch.this).onGetPoiDetailShareUrlResult(new ShareUrlResult(localERRORNO));
          return;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.KEY_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_TIME_OUT;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
        }
      }
      ShareUrlSearch.b(ShareUrlSearch.this).onGetLocationShareUrlResult(new ShareUrlResult(localERRORNO));
      return;
      ShareUrlSearch.b(ShareUrlSearch.this).onGetRouteShareUrlResult(new ShareUrlResult(localERRORNO));
    }
    
    public void a(String paramString) {}
    
    public void b(String paramString) {}
    
    public void c(String paramString) {}
    
    public void d(String paramString) {}
    
    public void e(String paramString)
    {
      if ((ShareUrlSearch.a(ShareUrlSearch.this)) || (ShareUrlSearch.b(ShareUrlSearch.this) == null)) {
        return;
      }
      switch (ShareUrlSearch.c(ShareUrlSearch.this))
      {
      default: 
        return;
      case 1: 
        ShareUrlSearch.b(ShareUrlSearch.this).onGetPoiDetailShareUrlResult(b.a(paramString));
        return;
      case 2: 
        ShareUrlSearch.b(ShareUrlSearch.this).onGetLocationShareUrlResult(b.a(paramString));
        return;
      }
      ShareUrlSearch.b(ShareUrlSearch.this).onGetRouteShareUrlResult(b.a(paramString));
    }
    
    public void f(String paramString) {}
    
    public void g(String paramString) {}
    
    public void h(String paramString) {}
    
    public void i(String paramString) {}
    
    public void j(String paramString) {}
    
    public void k(String paramString) {}
    
    public void l(String paramString) {}
    
    public void m(String paramString) {}
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/ShareUrlSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */