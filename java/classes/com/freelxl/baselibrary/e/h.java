package com.freelxl.baselibrary.e;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

public class h
{
  public Map<String, Object> a;
  public Map<String, Object> b;
  private final int c;
  private final String d;
  private Object e;
  private final int f;
  private l g;
  private Object h;
  
  public h(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
    setRetryPolicy(new b());
    if (TextUtils.isEmpty(paramString)) {}
    for (paramInt = 0;; paramInt = Uri.parse(paramString).getHost().hashCode())
    {
      this.f = paramInt;
      return;
    }
  }
  
  public h(String paramString)
  {
    this(-1, paramString);
  }
  
  protected Map<String, Object> a()
  {
    return this.b;
  }
  
  protected Map<String, Object> b()
  {
    return this.a;
  }
  
  public int getMethod()
  {
    return this.c;
  }
  
  public Object getObj()
  {
    return this.h;
  }
  
  public l getRetryPolicy()
  {
    return this.g;
  }
  
  public Object getTag()
  {
    return this.e;
  }
  
  public final int getTimeoutMs()
  {
    return this.g.getCurrentTimeout();
  }
  
  public int getTrafficStatsTag()
  {
    return this.f;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public void setHeaders(Map<String, Object> paramMap)
  {
    this.b = paramMap;
  }
  
  public void setObj(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public void setParams(Map<String, Object> paramMap)
  {
    this.a = paramMap;
  }
  
  public void setRetryPolicy(l paraml)
  {
    this.g = paraml;
  }
  
  public void setTag(Object paramObject)
  {
    this.e = paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */