package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
  implements Serializable
{
  private static final long a = 1L;
  private Map<List<String>, i> b = new HashMap();
  private long c = 0L;
  
  private void a(f paramf, l paraml, List<String> paramList)
  {
    if (a(paramList))
    {
      a(paramf, paraml);
      return;
    }
    a(paramf, paramList, paraml);
  }
  
  private void a(i parami1, i parami2)
  {
    parami2.c(parami2.g() + parami1.g());
    parami2.b(parami2.f() + parami1.f());
    parami2.a(parami2.e() + parami1.e());
    int i = 0;
    while (i < parami1.d().size())
    {
      parami2.a((String)parami1.d().get(i));
      i += 1;
    }
  }
  
  private void b(Map<List<String>, i> paramMap)
  {
    new ArrayList();
    new ArrayList();
    paramMap = this.b.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      List localList = (List)localEntry.getKey();
      Iterator localIterator = this.b.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (List)localEntry.getKey();
        if (!localList.equals(localObject2))
        {
          this.b.put(localObject2, ((Map.Entry)localObject1).getValue());
        }
        else
        {
          localObject2 = (i)localEntry.getValue();
          localObject1 = (i)((Map.Entry)localObject1).getValue();
          a((i)localObject2, (i)localObject1);
          this.b.remove(localList);
          this.b.put(localList, localObject1);
        }
      }
    }
  }
  
  public Map<List<String>, i> a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(f paramf)
  {
    Iterator localIterator = this.b.keySet().iterator();
    for (;;)
    {
      List localList;
      if (localIterator.hasNext())
      {
        localList = (List)localIterator.next();
        if (!paramf.a()) {}
      }
      else
      {
        return;
      }
      paramf.a(this.b.get(localList), false);
    }
  }
  
  public void a(final f paramf, l paraml)
  {
    try
    {
      if (a(paraml.a()))
      {
        i locali = (i)this.b.get(paraml.a());
        if (locali != null)
        {
          locali.a(new f()
          {
            public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
            {
              paramAnonymousObject = (i)paramAnonymousObject;
              h.a(h.this).remove(((i)paramAnonymousObject).a());
              h.a(h.this).put(((i)paramAnonymousObject).b(), paramAnonymousObject);
              paramf.a(this, false);
            }
          }, paraml);
          return;
        }
        a(paramf, paraml.a(), paraml);
        return;
      }
    }
    catch (Exception paramf)
    {
      by.e("aggregated faild!");
      return;
    }
    a(paramf, paraml.a(), paraml);
  }
  
  public void a(f paramf, l paraml, List<String> paramList1, List<String> paramList2)
  {
    for (;;)
    {
      try
      {
        if (paramList1.size() < 1) {
          break;
        }
        if (paramList1.size() == 1)
        {
          if (!a(paramList2, paramList1))
          {
            paramf.a(Boolean.valueOf(false), false);
            return;
          }
          a(paramf, paraml, paramList1);
          return;
        }
      }
      catch (Exception paramf)
      {
        by.e("overFlowAggregated faild");
        return;
      }
      if (a(paramList2, paramList1))
      {
        a(paramf, paraml, paramList1);
        return;
      }
      paramList1.remove(paramList1.size() - 1);
    }
  }
  
  public void a(f paramf, List<String> paramList, l paraml)
  {
    i locali = new i();
    locali.a(paraml);
    this.b.put(paramList, locali);
    paramf.a(this, false);
  }
  
  public void a(Map<List<String>, i> paramMap)
  {
    if (this.b.size() <= 0)
    {
      this.b = paramMap;
      return;
    }
    b(paramMap);
  }
  
  public boolean a(List<?> paramList)
  {
    return (this.b != null) && (this.b.containsKey(paramList));
  }
  
  public boolean a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) || (paramList1.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList1.size() - 1)
      {
        localArrayList.add(d.b((String)paramList1.get(i)));
        i += 1;
      }
    } while ((paramList1 == null) || (paramList1.size() == 0));
    return localArrayList.contains(paramList2);
  }
  
  public long b()
  {
    return this.c;
  }
  
  public int c()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public void d()
  {
    this.b.clear();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */