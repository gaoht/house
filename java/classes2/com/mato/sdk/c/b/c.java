package com.mato.sdk.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mato.sdk.d.m;
import com.mato.sdk.e.c.d;
import com.mato.sdk.proxy.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
{
  private static final String a = "WSPXCrashPreference";
  private final Context b;
  
  public c() {}
  
  public c(Context paramContext)
  {
    this.b = paramContext;
  }
  
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
  
  public static List<com.mato.sdk.e.c.c> a(List<d> paramList, g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (d)localIterator.next();
      String str1 = a(paramList);
      String str2 = paramg.b(str1, null);
      if (str2 == null) {}
      for (paramList = com.mato.sdk.e.c.c.a(str1, paramList, paramg);; paramList = com.mato.sdk.e.c.c.a(str1, str2, paramList, paramg))
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return localArrayList;
  }
  
  private int b()
  {
    return this.b.getSharedPreferences("WSPXCrashPreference", 0).getAll().size();
  }
  
  public static List<com.mato.sdk.e.c.c> b(List<d> paramList, g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      localArrayList.add(com.mato.sdk.e.c.c.a(a(locald), locald, paramg));
    }
    return localArrayList;
  }
  
  private void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.b.getSharedPreferences("WSPXCrashPreference", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    finally {}
  }
  
  public final List<a> a()
  {
    Object localObject1 = this.b.getSharedPreferences("WSPXCrashPreference", 0);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getAll();
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof String)) {
          try
          {
            localArrayList.add(a.b((String)localObject2));
          }
          catch (Exception localException) {}
        }
      }
      return localList;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.b.getSharedPreferences("WSPXCrashPreference", 0).edit();
      localEditor.putString(parama.c(), parama.i());
      localEditor.commit();
      if ((parama.d()) && (!parama.e()) && (!parama.a())) {
        g.a(this.b).b(true);
      }
      return;
    }
    finally {}
  }
  
  public final void b(a parama)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.b.getSharedPreferences("WSPXCrashPreference", 0).edit();
      localEditor.remove(parama.c());
      localEditor.commit();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */