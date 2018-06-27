package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.d;

public class GeoCoder
  extends g
{
  private d a = null;
  private OnGetGeoCoderResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  
  GeoCoder()
  {
    this.a.a(new a(null));
  }
  
  public static GeoCoder newInstance()
  {
    BMapManager.init();
    return new GeoCoder();
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
  
  public boolean geocode(GeoCodeOption paramGeoCodeOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramGeoCodeOption == null) || (paramGeoCodeOption.b == null) || (paramGeoCodeOption.a == null)) {
      throw new IllegalArgumentException("option or address or city can not be null");
    }
    this.d = this.e;
    this.e = 1;
    return this.a.b(paramGeoCodeOption.b, paramGeoCodeOption.a);
  }
  
  public boolean reverseGeoCode(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramReverseGeoCodeOption == null) || (paramReverseGeoCodeOption.a == null)) {
      throw new IllegalArgumentException("option or mLocation can not be null");
    }
    this.d = this.e;
    this.e = 2;
    return this.a.a(CoordUtil.ll2point(paramReverseGeoCodeOption.a));
  }
  
  public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener paramOnGetGeoCoderResultListener)
  {
    this.b = paramOnGetGeoCoderResultListener;
  }
  
  private class a
    implements com.baidu.platform.comapi.search.b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((GeoCoder.a(GeoCoder.this)) || (GeoCoder.b(GeoCoder.this) == null)) {
        return;
      }
      SearchResult.ERRORNO localERRORNO = null;
      switch (paramInt)
      {
      }
      while (localERRORNO != null) {
        switch (GeoCoder.c(GeoCoder.this))
        {
        default: 
          return;
        case 1: 
          GeoCoder.b(GeoCoder.this).onGetGeoCodeResult(new GeoCodeResult(localERRORNO));
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
        }
      }
      GeoCoder.b(GeoCoder.this).onGetReverseGeoCodeResult(new ReverseGeoCodeResult(localERRORNO));
    }
    
    public void a(String paramString) {}
    
    public void b(String paramString) {}
    
    public void c(String paramString) {}
    
    public void d(String paramString) {}
    
    public void e(String paramString) {}
    
    public void f(String paramString) {}
    
    public void g(String paramString) {}
    
    public void h(String paramString) {}
    
    public void i(String paramString) {}
    
    public void j(String paramString)
    {
      if ((GeoCoder.a(GeoCoder.this)) || (GeoCoder.b(GeoCoder.this) == null) || (paramString == null) || (paramString.length() <= 0)) {
        return;
      }
      switch (GeoCoder.c(GeoCoder.this))
      {
      default: 
        return;
      case 1: 
        GeoCoder.b(GeoCoder.this).onGetGeoCodeResult(b.b(paramString));
        return;
      }
      GeoCoder.b(GeoCoder.this).onGetReverseGeoCodeResult(b.a(paramString));
    }
    
    public void k(String paramString) {}
    
    public void l(String paramString) {}
    
    public void m(String paramString) {}
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/GeoCoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */