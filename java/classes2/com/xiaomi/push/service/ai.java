package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.b;
import com.xiaomi.xmpush.thrift.ac;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.n;
import com.xiaomi.xmpush.thrift.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ai
{
  public static int a(ah paramah, f paramf)
  {
    int j = 0;
    String str = a(paramf);
    int i = j;
    switch (aj.a[paramf.ordinal()])
    {
    }
    for (i = j;; i = 1) {
      return paramah.a.getInt(str, i);
    }
  }
  
  private static String a(f paramf)
  {
    return "oc_version_" + paramf.a();
  }
  
  private static List<Pair<Integer, Object>> a(List<p> paramList, boolean paramBoolean)
  {
    if (b.a(paramList)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (p)localIterator.next();
      int i = paramList.a();
      g localg = g.a(paramList.c());
      if (localg != null) {
        if ((paramBoolean) && (paramList.c))
        {
          localArrayList.add(new Pair(Integer.valueOf(i), null));
        }
        else
        {
          switch (aj.b[localg.ordinal()])
          {
          default: 
            paramList = null;
          }
          for (;;)
          {
            localArrayList.add(paramList);
            break;
            paramList = new Pair(Integer.valueOf(i), Integer.valueOf(paramList.f()));
            continue;
            paramList = new Pair(Integer.valueOf(i), Long.valueOf(paramList.h()));
            continue;
            paramList = new Pair(Integer.valueOf(i), paramList.j());
            continue;
            paramList = new Pair(Integer.valueOf(i), Boolean.valueOf(paramList.l()));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(ah paramah, ac paramac)
  {
    paramah.b(a(paramac.a(), true));
  }
  
  public static void a(ah paramah, ad paramad)
  {
    paramad = paramad.a().iterator();
    while (paramad.hasNext())
    {
      n localn = (n)paramad.next();
      if (localn.a() > a(paramah, localn.d()))
      {
        a(paramah, localn.d(), localn.a());
        paramah.a(a(localn.b, false));
      }
    }
  }
  
  public static void a(ah paramah, f paramf, int paramInt)
  {
    paramf = a(paramf);
    paramah.a.edit().putInt(paramf, paramInt).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */