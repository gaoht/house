package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class p
  implements Serializable
{
  private static final long a = 1L;
  private Map<String, k> b = new HashMap();
  
  private void b(k paramk)
  {
    k localk = ((k)this.b.get(paramk.c())).a(paramk);
    this.b.put(paramk.c(), localk);
  }
  
  private void b(String paramString)
  {
    k localk = new k(paramString, System.currentTimeMillis(), 1L);
    this.b.put(paramString, localk);
  }
  
  private void c(String paramString)
  {
    k localk = ((k)this.b.get(paramString)).a();
    this.b.put(paramString, localk);
  }
  
  public Map<String, k> a()
  {
    return this.b;
  }
  
  public void a(f paramf, String paramString)
  {
    if (this.b.containsKey(paramString)) {
      c(paramString);
    }
    for (;;)
    {
      paramf.a(this, false);
      return;
      b(paramString);
    }
  }
  
  public void a(k paramk)
  {
    if (a(paramk.c()))
    {
      b(paramk);
      return;
    }
    this.b.put(paramk.c(), paramk);
  }
  
  public void a(Map<String, k> paramMap)
  {
    this.b = paramMap;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((String)((Map.Entry)localIterator.next()).getKey()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.b.clear();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */