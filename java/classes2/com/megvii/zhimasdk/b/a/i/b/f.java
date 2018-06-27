package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.a.g;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.b.i;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
  implements i
{
  private final ConcurrentHashMap<g, m> a = new ConcurrentHashMap();
  
  private static m a(Map<g, m> paramMap, g paramg)
  {
    m localm = (m)paramMap.get(paramg);
    Object localObject2 = localm;
    Object localObject1;
    if (localm == null)
    {
      int i = -1;
      localObject1 = null;
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (g)localIterator.next();
        int j = paramg.a((g)localObject2);
        if (j <= i) {
          break label107;
        }
        i = j;
        localObject1 = localObject2;
      }
    }
    label107:
    for (;;)
    {
      break;
      localObject2 = localm;
      if (localObject1 != null) {
        localObject2 = (m)paramMap.get(localObject1);
      }
      return (m)localObject2;
    }
  }
  
  public m a(g paramg)
  {
    a.a(paramg, "Authentication scope");
    return a(this.a, paramg);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */