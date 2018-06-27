package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.b;
import com.baidu.platform.comapi.search.d;

public class SuggestionSearch
  extends g
{
  private d a = null;
  private OnGetSuggestionResultListener b = null;
  private boolean c = false;
  
  SuggestionSearch()
  {
    this.a.a(new a(null));
  }
  
  public static SuggestionSearch newInstance()
  {
    BMapManager.init();
    return new SuggestionSearch();
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
  
  public boolean requestSuggestion(SuggestionSearchOption paramSuggestionSearchOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramSuggestionSearchOption == null) || (paramSuggestionSearchOption.b == null) || (paramSuggestionSearchOption.a == null)) {
      throw new IllegalArgumentException("option or keyword or city can not be null");
    }
    return this.a.a(paramSuggestionSearchOption.b, 0, paramSuggestionSearchOption.a, null, 12, CoordUtil.ll2point(paramSuggestionSearchOption.c));
  }
  
  public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener paramOnGetSuggestionResultListener)
  {
    this.b = paramOnGetSuggestionResultListener;
  }
  
  private class a
    implements b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((SuggestionSearch.a(SuggestionSearch.this)) || (SuggestionSearch.b(SuggestionSearch.this) == null)) {}
      for (;;)
      {
        return;
        SearchResult.ERRORNO localERRORNO = null;
        switch (paramInt)
        {
        }
        while (localERRORNO != null)
        {
          SuggestionSearch.b(SuggestionSearch.this).onGetSuggestionResult(new SuggestionResult(localERRORNO));
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
    
    public void l(String paramString)
    {
      if ((SuggestionSearch.a(SuggestionSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (SuggestionSearch.b(SuggestionSearch.this) == null)) {
        return;
      }
      SuggestionSearch.b(SuggestionSearch.this).onGetSuggestionResult(c.a(paramString));
    }
    
    public void m(String paramString) {}
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/SuggestionSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */