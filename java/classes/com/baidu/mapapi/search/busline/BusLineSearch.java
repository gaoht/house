package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.d;

public class BusLineSearch
  extends g
{
  private d a = null;
  private OnGetBusLineSearchResultListener b = null;
  private boolean c = false;
  
  BusLineSearch()
  {
    this.a.a(new a(null));
  }
  
  public static BusLineSearch newInstance()
  {
    BMapManager.init();
    return new BusLineSearch();
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
  
  public boolean searchBusLine(BusLineSearchOption paramBusLineSearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramBusLineSearchOption == null) || (paramBusLineSearchOption.b == null) || (paramBusLineSearchOption.a == null)) {
      throw new IllegalArgumentException("option or city or uid can not be null");
    }
    return this.a.a(paramBusLineSearchOption.b, paramBusLineSearchOption.a);
  }
  
  public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener paramOnGetBusLineSearchResultListener)
  {
    this.b = paramOnGetBusLineSearchResultListener;
  }
  
  private class a
    implements com.baidu.platform.comapi.search.b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((BusLineSearch.a(BusLineSearch.this)) || (BusLineSearch.b(BusLineSearch.this) == null)) {}
      for (;;)
      {
        return;
        SearchResult.ERRORNO localERRORNO = null;
        switch (paramInt)
        {
        }
        while (localERRORNO != null)
        {
          BusLineSearch.b(BusLineSearch.this).onGetBusLineResult(new BusLineResult(localERRORNO));
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
    
    public void j(String paramString) {}
    
    public void k(String paramString)
    {
      if ((BusLineSearch.a(BusLineSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (BusLineSearch.b(BusLineSearch.this) == null)) {
        return;
      }
      BusLineSearch.b(BusLineSearch.this).onGetBusLineResult(b.a(paramString));
    }
    
    public void l(String paramString) {}
    
    public void m(String paramString) {}
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/busline/BusLineSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */