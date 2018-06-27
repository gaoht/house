package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.d;

public class DistrictSearch
  extends g
{
  private d a = null;
  private boolean b = false;
  private OnGetDistricSearchResultListener c;
  
  DistrictSearch()
  {
    this.a.a(new a(null));
  }
  
  public static DistrictSearch newInstance()
  {
    BMapManager.init();
    return new DistrictSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.c = null;
    this.a.a();
    this.a = null;
    BMapManager.destroy();
  }
  
  public boolean searchDistrict(DistrictSearchOption paramDistrictSearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramDistrictSearchOption == null) || (paramDistrictSearchOption.a == null)) {
      throw new IllegalArgumentException("option or city name can not be null");
    }
    return this.a.c(paramDistrictSearchOption.a, paramDistrictSearchOption.b);
  }
  
  public void setOnDistrictSearchListener(OnGetDistricSearchResultListener paramOnGetDistricSearchResultListener)
  {
    this.c = paramOnGetDistricSearchResultListener;
  }
  
  private class a
    implements com.baidu.platform.comapi.search.b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((DistrictSearch.a(DistrictSearch.this)) || (DistrictSearch.b(DistrictSearch.this) == null)) {}
      for (;;)
      {
        return;
        SearchResult.ERRORNO localERRORNO = null;
        switch (paramInt)
        {
        }
        while (localERRORNO != null)
        {
          DistrictSearch.b(DistrictSearch.this).onGetDistrictResult(new DistrictResult(localERRORNO));
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
    
    public void k(String paramString) {}
    
    public void l(String paramString) {}
    
    public void m(String paramString)
    {
      if ((DistrictSearch.a(DistrictSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (DistrictSearch.b(DistrictSearch.this) == null)) {
        return;
      }
      DistrictSearch.b(DistrictSearch.this).onGetDistrictResult(b.a(paramString));
    }
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/district/DistrictSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */