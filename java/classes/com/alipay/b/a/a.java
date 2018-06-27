package com.alipay.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.b.d.e;
import com.alipay.b.f.g;
import com.alipay.b.f.h;
import com.alipay.b.f.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public final class a
{
  private Context a;
  private com.alipay.b.b.a b = com.alipay.b.b.a.a();
  private int c = 4;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static String a(Context paramContext)
  {
    String str2 = b(paramContext);
    String str1 = str2;
    if (com.alipay.c.a.a.a.a.a(str2)) {
      str1 = h.f(paramContext);
    }
    return str1;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      String str = i.a(paramString);
      if (!com.alipay.c.a.a.a.a.a(str)) {
        return str;
      }
      paramContext = g.a(paramContext, paramString);
      i.a(paramString, paramContext);
      boolean bool = com.alipay.c.a.a.a.a.a(paramContext);
      if (!bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
    return paramContext;
  }
  
  private static boolean a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int j = (int)(Math.random() * 24.0D * 60.0D * 60.0D);
    int i = 0;
    while (i < 2) {
      try
      {
        Object localObject = new String[] { "2016-11-10 2016-11-11", "2016-12-11 2016-12-12" }[i].split(" ");
        if ((localObject != null) && (localObject.length == 2))
        {
          Date localDate1 = new Date();
          Date localDate2 = localSimpleDateFormat.parse(localObject[0] + " 00:00:00");
          localObject = localSimpleDateFormat.parse(localObject[1] + " 23:59:59");
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.setTime((Date)localObject);
          localCalendar.add(13, j * 1);
          localObject = localCalendar.getTime();
          if (localDate1.after(localDate2))
          {
            boolean bool = localDate1.before((Date)localObject);
            if (bool) {
              return true;
            }
          }
        }
        i += 1;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  private boolean a(Map<String, String> paramMap, String paramString)
  {
    long l2 = 0L;
    if (a())
    {
      if (com.alipay.c.a.a.a.a.a(a(this.a, paramString))) {}
      while (com.alipay.c.a.a.a.a.a(b(this.a))) {
        return true;
      }
      return false;
    }
    e.a();
    int i;
    label62:
    String str;
    if (!com.alipay.c.a.a.a.a.a(e.b(this.a, paramMap), i.c()))
    {
      i = 1;
      if (i != 0) {
        break label217;
      }
      str = h.b(this.a);
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
      }
      catch (Throwable localThrowable1)
      {
        long l3;
        label217:
        long l1 = 0L;
      }
      try
      {
        com.alipay.c.a.a.b.b.a();
        l3 = Long.parseLong(com.alipay.c.a.a.b.b.o());
        l2 = l3;
        i = 0;
        if ((Math.abs(l2 - l1) > 3000L) || (i != 0)) {
          break;
        }
        str = com.alipay.c.a.a.a.a.a(paramMap, "tid", "");
        paramMap = com.alipay.c.a.a.a.a.a(paramMap, "utdid", "");
        if (((com.alipay.c.a.a.a.a.b(str)) && (!com.alipay.c.a.a.a.a.a(str, i.d()))) || ((com.alipay.c.a.a.a.a.b(paramMap)) && (!com.alipay.c.a.a.a.a.a(paramMap, i.e()))) || (!i.a(this.a, paramString)) || (com.alipay.c.a.a.a.a.a(a(this.a, paramString))) || (com.alipay.c.a.a.a.a.a(b(this.a)))) {
          break;
        }
        return false;
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
      i = 0;
      break label62;
      break;
      i = 1;
    }
  }
  
  private com.alipay.c.a.a.c.a.c b(Map<String, String> paramMap)
  {
    try
    {
      Context localContext = this.a;
      com.alipay.c.a.a.c.a.d locald = new com.alipay.c.a.a.c.a.d();
      Object localObject1 = a(localContext, com.alipay.c.a.a.a.a.a(paramMap, "appName", ""));
      Object localObject2 = com.alipay.b.e.a.a();
      Object localObject3 = h.e(localContext);
      locald.c = ((String)localObject1);
      locald.d = ((String)localObject2);
      locald.e = ((String)localObject3);
      locald.a = "android";
      Object localObject5 = "";
      localObject2 = "";
      localObject1 = "";
      Object localObject6 = "";
      localObject3 = com.alipay.b.f.d.c(localContext);
      if (localObject3 != null)
      {
        localObject2 = ((com.alipay.b.f.c)localObject3).a;
        localObject1 = ((com.alipay.b.f.c)localObject3).c;
      }
      Object localObject4 = localObject1;
      localObject3 = localObject2;
      if (com.alipay.c.a.a.a.a.a((String)localObject2))
      {
        localObject7 = com.alipay.b.f.a.c(localContext);
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (localObject7 != null)
        {
          localObject3 = ((com.alipay.b.f.b)localObject7).a;
          localObject4 = ((com.alipay.b.f.b)localObject7).c;
        }
      }
      Object localObject7 = com.alipay.b.f.d.b();
      localObject1 = localObject6;
      localObject2 = localObject5;
      if (localObject7 != null)
      {
        localObject2 = ((com.alipay.b.f.c)localObject7).a;
        localObject1 = ((com.alipay.b.f.c)localObject7).c;
      }
      localObject6 = localObject1;
      localObject5 = localObject2;
      if (com.alipay.c.a.a.a.a.a((String)localObject2))
      {
        localObject7 = com.alipay.b.f.a.b();
        localObject6 = localObject1;
        localObject5 = localObject2;
        if (localObject7 != null)
        {
          localObject5 = ((com.alipay.b.f.b)localObject7).a;
          localObject6 = ((com.alipay.b.f.b)localObject7).c;
        }
      }
      locald.h = ((String)localObject3);
      locald.g = ((String)localObject5);
      if (com.alipay.c.a.a.a.a.a((String)localObject3)) {
        locald.b = ((String)localObject5);
      }
      for (locald.i = ((String)localObject6);; locald.i = ((String)localObject4))
      {
        locald.f = e.a(localContext, paramMap);
        return com.alipay.c.a.a.c.d.a(this.a, this.b.b()).a(locald);
        locald.b = ((String)localObject3);
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      com.alipay.b.c.a.a(paramMap);
    }
  }
  
  private static String b(Context paramContext)
  {
    Object localObject;
    try
    {
      localObject = i.b();
      if (!com.alipay.c.a.a.a.a.a((String)localObject)) {
        return (String)localObject;
      }
      localObject = com.alipay.b.f.d.b(paramContext);
      if (localObject != null)
      {
        i.a((com.alipay.b.f.c)localObject);
        String str = ((com.alipay.b.f.c)localObject).a;
        localObject = str;
        if (com.alipay.c.a.a.a.a.b(str)) {
          return localObject;
        }
      }
      paramContext = com.alipay.b.f.a.b(paramContext);
      if (paramContext != null)
      {
        i.a(paramContext);
        localObject = paramContext.a;
        boolean bool = com.alipay.c.a.a.a.a.b((String)localObject);
        if (bool) {
          return localObject;
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
    return (String)localObject;
  }
  
  public final int a(Map<String, String> paramMap)
  {
    j = 2;
    for (;;)
    {
      try
      {
        com.alipay.b.c.a.a(this.a, com.alipay.c.a.a.a.a.a(paramMap, "tid", ""), com.alipay.c.a.a.a.a.a(paramMap, "utdid", ""), a(this.a));
        localObject2 = com.alipay.c.a.a.a.a.a(paramMap, "appName", "");
        b(this.a);
        a(this.a, (String)localObject2);
        i.a();
        boolean bool = a(paramMap, (String)localObject2);
        localObject1 = this.a;
        com.alipay.c.a.a.b.b.a();
        h.b((Context)localObject1, String.valueOf(com.alipay.c.a.a.b.b.o()));
        if (bool) {
          continue;
        }
        i = 0;
        this.c = i;
        localObject1 = com.alipay.c.a.a.c.d.a(this.a, this.b.b());
        localObject2 = this.a;
        paramMap = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
        if (paramMap == null) {
          continue;
        }
        paramMap = paramMap.getActiveNetworkInfo();
      }
      catch (Exception paramMap)
      {
        Object localObject2;
        com.alipay.c.a.a.c.a.c localc;
        com.alipay.b.c.a.a(paramMap);
        continue;
        int i = j;
        if (!"APPKEY_ERROR".equals(localc.b)) {
          continue;
        }
        i = 3;
        continue;
        h.a(this.a, "1".equals(localc.e));
        Context localContext = this.a;
        if (localc.f != null) {
          continue;
        }
        Object localObject1 = "0";
        h.d(localContext, (String)localObject1);
        h.e(this.a, localc.g);
        h.a(this.a, localc.h);
        h.f(this.a, localc.i);
        i.c(e.b(this.a, paramMap));
        i.a((String)localObject2, localc.d);
        i.b(localc.c);
        i.d(localc.j);
        localObject1 = com.alipay.c.a.a.a.a.a(paramMap, "tid", "");
        if ((!com.alipay.c.a.a.a.a.b((String)localObject1)) || (com.alipay.c.a.a.a.a.a((String)localObject1, i.d()))) {
          continue;
        }
        i.e((String)localObject1);
        i.e((String)localObject1);
        paramMap = com.alipay.c.a.a.a.a.a(paramMap, "utdid", "");
        if ((!com.alipay.c.a.a.a.a.b(paramMap)) || (com.alipay.c.a.a.a.a.a(paramMap, i.e()))) {
          continue;
        }
        i.f(paramMap);
        i.f(paramMap);
        i.a();
        paramMap = i.g();
        com.alipay.b.f.d.a(this.a, paramMap);
        com.alipay.b.f.d.a();
        com.alipay.b.f.a.a(this.a, new com.alipay.b.f.b(i.b(), i.c(), i.f()));
        com.alipay.b.f.a.a();
        paramMap = i.a((String)localObject2);
        g.a(this.a, (String)localObject2, paramMap);
        g.a();
        h.a(this.a, (String)localObject2, System.currentTimeMillis());
        continue;
        localObject1 = localc.f;
        continue;
        localObject1 = i.d();
        continue;
        paramMap = i.e();
        continue;
        com.alipay.b.c.a.a("Server error, returned null");
        continue;
        i = 0;
        continue;
        paramMap = null;
        continue;
        switch (i)
        {
        case 2: 
        case 1: 
        default: 
          continue;
          i = 0;
          break;
        case 3: 
          i = 1;
          continue;
        }
      }
      if ((paramMap == null) || (!paramMap.isConnected()) || (paramMap.getType() != 1)) {
        continue;
      }
      i = 1;
      if ((i != 0) && (h.d((Context)localObject2))) {
        new Thread(new com.alipay.c.a.a.e.c(new com.alipay.c.a.a.e.b(((Context)localObject2).getFilesDir().getAbsolutePath() + "/log/ap", (com.alipay.c.a.a.c.b.a)localObject1))).start();
      }
      return this.c;
      new com.alipay.b.c.b();
      i = com.alipay.b.b.a.a().a;
      com.alipay.b.e.a.b();
      localc = b(paramMap);
      i = j;
      if (localc == null) {
        continue;
      }
      if (!localc.a) {
        continue;
      }
      i = j;
      if (com.alipay.c.a.a.a.a.a(localc.c)) {
        continue;
      }
      i = 1;
      continue;
      if (localc == null) {
        continue;
      }
      com.alipay.b.c.a.a("Server error, result:" + localc.b);
      if (!com.alipay.c.a.a.a.a.a(a(this.a, (String)localObject2))) {
        continue;
      }
      i = 4;
      a(this.a, (String)localObject2);
      h.f(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */