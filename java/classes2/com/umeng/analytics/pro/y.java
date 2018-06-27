package com.umeng.analytics.pro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class y
{
  private final int a = 10;
  private final int b = 20;
  private final String c;
  private List<bk> d;
  private bl e;
  
  public y(String paramString)
  {
    this.c = paramString;
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    Object localObject3 = this.e;
    Object localObject1;
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label218;
      }
    }
    label218:
    for (int i = 0;; i = ((bl)localObject3).i())
    {
      String str = a(f());
      boolean bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(localObject1))
        {
          Object localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new bl();
          }
          ((bl)localObject2).a(str);
          ((bl)localObject2).a(System.currentTimeMillis());
          ((bl)localObject2).a(i + 1);
          localObject3 = new bk();
          ((bk)localObject3).a(this.c);
          ((bk)localObject3).c(str);
          ((bk)localObject3).b((String)localObject1);
          ((bk)localObject3).a(((bl)localObject2).f());
          if (this.d == null) {
            this.d = new ArrayList(2);
          }
          this.d.add(localObject3);
          if (this.d.size() > 10) {
            this.d.remove(0);
          }
          this.e = ((bl)localObject2);
          bool1 = true;
        }
      }
      return bool1;
      localObject1 = ((bl)localObject3).c();
      break;
    }
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.trim();
    } while ((paramString.length() == 0) || ("0".equals(paramString)) || ("unknown".equals(paramString.toLowerCase(Locale.US))));
    return paramString;
  }
  
  public void a(bl parambl)
  {
    this.e = parambl;
  }
  
  public void a(bm parambm)
  {
    this.e = ((bl)parambm.d().get(this.c));
    parambm = parambm.i();
    if ((parambm != null) && (parambm.size() > 0))
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      parambm = parambm.iterator();
      while (parambm.hasNext())
      {
        bk localbk = (bk)parambm.next();
        if (this.c.equals(localbk.a)) {
          this.d.add(localbk);
        }
      }
    }
  }
  
  public void a(List<bk> paramList)
  {
    this.d = paramList;
  }
  
  public boolean a()
  {
    return g();
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return (this.e == null) || (this.e.i() <= 20);
  }
  
  public bl d()
  {
    return this.e;
  }
  
  public List<bk> e()
  {
    return this.d;
  }
  
  public abstract String f();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */