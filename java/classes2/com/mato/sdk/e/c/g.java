package com.mato.sdk.e.c;

import com.mato.sdk.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public static String a(d paramd)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramd.a());
    localStringBuffer.append(paramd.b());
    localStringBuffer.append(paramd.c());
    localStringBuffer.append(paramd.e());
    paramd = paramd.d();
    int i = 0;
    while (i < paramd.size())
    {
      localStringBuffer.append((String)paramd.get(i));
      i += 1;
    }
    return m.a(localStringBuffer.toString());
  }
  
  public static List<c> a(List<d> paramList, com.mato.sdk.proxy.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (d)localIterator.next();
      String str1 = com.mato.sdk.c.b.c.a(paramList);
      String str2 = paramg.b(str1, null);
      if (str2 == null) {}
      for (paramList = c.a(str1, paramList, paramg);; paramList = c.a(str1, str2, paramList, paramg))
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return localArrayList;
  }
  
  public static List<c> b(List<d> paramList, com.mato.sdk.proxy.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      localArrayList.add(c.a(com.mato.sdk.c.b.c.a(locald), locald, paramg));
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */