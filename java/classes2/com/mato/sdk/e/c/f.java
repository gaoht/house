package com.mato.sdk.e.c;

import android.content.Context;
import android.text.TextUtils;
import com.mato.sdk.b.h;
import com.mato.sdk.b.j;
import com.mato.sdk.d.j.a;
import com.mato.sdk.d.k;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.g.b;
import com.mato.sdk.g.i;
import com.mato.sdk.proxy.a;
import com.mato.sdk.proxy.q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String a = com.mato.sdk.b.g.b("");
  private static final int b = 0;
  private final Context c;
  private final com.mato.sdk.proxy.g d;
  private int e = 0;
  private List<c> f;
  private k g;
  private final q h;
  private a.1 i;
  private String j;
  private ScheduledExecutorService k;
  
  public f(Context paramContext, q paramq)
  {
    this.c = paramContext;
    this.d = com.mato.sdk.proxy.g.a(this.c);
    this.h = paramq;
  }
  
  private static long a(long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis() / 1000L;
    if (paramLong1 == 0L) {}
    do
    {
      return 0L;
      if (l < paramLong1) {
        return paramLong1 - l;
      }
    } while ((paramLong1 <= l) && (l < paramLong2));
    return -1L;
  }
  
  private static List<d> a(String paramString)
  {
    localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(paramString);
        int m = 0;
        while (m < paramString.length())
        {
          d locald = d.a(paramString.getJSONObject(m));
          if (locald.f()) {
            localArrayList.add(locald);
          }
          m += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString) {}
    }
  }
  
  private void a(final c paramc)
  {
    for (;;)
    {
      long l1 = paramc.c();
      long l2 = paramc.d();
      long l3 = System.currentTimeMillis() / 1000L;
      if (l1 == 0L)
      {
        l1 = 0L;
        if (l1 < 0L) {
          break label117;
        }
        paramc = new Runnable()
        {
          public final void run()
          {
            f.a(f.this, paramc);
          }
        };
        if (this.k == null) {
          this.k = Executors.newScheduledThreadPool(2);
        }
        this.k.schedule(paramc, l1, TimeUnit.SECONDS);
      }
      label117:
      int m;
      do
      {
        return;
        if (l3 < l1)
        {
          l1 -= l3;
          break;
        }
        if ((l1 <= l3) && (l3 < l2))
        {
          l1 = 0L;
          break;
        }
        l1 = -1L;
        break;
        m = this.e + 1;
        this.e = m;
      } while (m >= this.f.size());
      paramc = (c)this.f.get(this.e);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject2 = a(paramString2);
    if (j.a.a((List)localObject2)) {
      return;
    }
    Object localObject1 = this.d;
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d locald = (d)((Iterator)localObject2).next();
      localArrayList.add(c.a(com.mato.sdk.c.b.c.a(locald), locald, (com.mato.sdk.proxy.g)localObject1));
    }
    this.f = localArrayList;
    localObject1 = this.d.i();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      d(this.d.f((String)localObject1));
      this.d.g((String)localObject1 + "_config");
    }
    this.d.d(paramString1 + "_config", paramString2);
    this.d.d("precache_md5", paramString1);
    this.e = 0;
    a((c)this.f.get(this.e));
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      b(paramList);
    }
    int m = this.e + 1;
    this.e = m;
    if (m < this.f.size()) {
      a((c)this.f.get(this.e));
    }
  }
  
  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.getBoolean("success")) {
      paramJSONObject.optString("errorMsg", "");
    }
    String str;
    do
    {
      return;
      paramJSONObject = paramJSONObject.optString("configuration", "");
      str = this.g.a();
      localObject2 = a(paramJSONObject);
    } while (j.a.a((List)localObject2));
    Object localObject1 = this.d;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d locald = (d)((Iterator)localObject2).next();
      localArrayList.add(c.a(com.mato.sdk.c.b.c.a(locald), locald, (com.mato.sdk.proxy.g)localObject1));
    }
    this.f = localArrayList;
    localObject1 = this.d.i();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      d(this.d.f((String)localObject1));
      this.d.g((String)localObject1 + "_config");
    }
    this.d.d(str + "_config", paramJSONObject);
    this.d.d("precache_md5", str);
    this.e = 0;
    a((c)this.f.get(this.e));
  }
  
  private static long b(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length()));
      return l;
    }
    catch (Throwable paramString) {}
    return -1L;
  }
  
  private void b(c paramc)
  {
    try
    {
      long l3 = paramc.d();
      long l2 = paramc.a();
      int m = paramc.b();
      long l1 = System.currentTimeMillis() / 1000L;
      if (l2 == 0L) {}
      for (l2 = l3 + m * 60;; l2 = l3)
      {
        paramc = e.a(this.g.b(), paramc, l1, l2, this.j);
        if ((paramc != null) && (!paramc.isEmpty())) {
          b(paramc);
        }
        m = this.e + 1;
        this.e = m;
        if (m < this.f.size()) {
          a((c)this.f.get(this.e));
        }
        return;
        l3 = l2 + m * 60;
        l1 = l2;
      }
      return;
    }
    catch (Throwable paramc) {}
  }
  
  private void b(String paramString1, String paramString2)
  {
    String str1 = this.d.i();
    if (!TextUtils.isEmpty(str1))
    {
      Iterator localIterator = a(this.d.f(str1)).iterator();
      while (localIterator.hasNext())
      {
        String str2 = com.mato.sdk.c.b.c.a((d)localIterator.next());
        this.d.g(str2);
      }
      this.d.g(str1 + "_config");
    }
    this.d.d(paramString1 + "_config", paramString2);
    this.d.d("precache_md5", paramString1);
  }
  
  private boolean b()
  {
    String str = i.n(this.c);
    if (str == null)
    {
      str = this.c.getCacheDir().getAbsolutePath();
      if (str == null) {
        return false;
      }
    }
    for (str = String.format(Locale.US, "%s/%s/precache/", new Object[] { str, "com.maa.sdk" });; str = String.format(Locale.US, "%s/%s/%s/precache/", new Object[] { str, "com.maa.sdk", i.g(this.c) }))
    {
      File localFile = new File(str);
      if ((localFile.exists()) || (localFile.mkdirs())) {
        break;
      }
      return false;
    }
    this.j = str;
    str = this.j;
    return true;
  }
  
  private boolean b(List<String> paramList)
  {
    try
    {
      String[] arrayOfString = new String[paramList.size()];
      this.h.b((String[])paramList.toArray(arrayOfString));
      return true;
    }
    catch (j paramList) {}
    return false;
  }
  
  private void c()
  {
    this.i = new a.1().c(this.g.a()).a(a.b().h().a()).b(this.g.c()).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        f.a();
      }
    }).a(new h.b()
    {
      private void a(JSONObject paramAnonymousJSONObject)
      {
        try
        {
          f.a(f.this, paramAnonymousJSONObject);
          return;
        }
        catch (JSONException paramAnonymousJSONObject)
        {
          com.mato.sdk.c.b.f.b().a(paramAnonymousJSONObject);
          f.a();
        }
      }
    });
    a.b().a(this.i.a());
  }
  
  private void c(String paramString)
  {
    paramString = a(paramString);
    if (j.a.a(paramString)) {}
    do
    {
      return;
      Object localObject = this.d;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramString.iterator();
      if (localIterator.hasNext())
      {
        paramString = (d)localIterator.next();
        String str1 = com.mato.sdk.c.b.c.a(paramString);
        String str2 = ((com.mato.sdk.proxy.g)localObject).b(str1, null);
        if (str2 == null) {}
        for (paramString = c.a(str1, paramString, (com.mato.sdk.proxy.g)localObject);; paramString = c.a(str1, str2, paramString, (com.mato.sdk.proxy.g)localObject))
        {
          localArrayList.add(paramString);
          break;
        }
      }
      localArrayList.size();
      this.f = new ArrayList();
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject = (c)paramString.next();
        if (System.currentTimeMillis() / 1000L < ((c)localObject).d()) {
          this.f.add(localObject);
        }
      }
    } while (this.f.isEmpty());
    this.e = 0;
    a((c)this.f.get(this.e));
  }
  
  private ScheduledExecutorService d()
  {
    if (this.k == null) {
      this.k = Executors.newScheduledThreadPool(2);
    }
    return this.k;
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString).iterator();
    while (paramString.hasNext())
    {
      String str = com.mato.sdk.c.b.c.a((d)paramString.next());
      this.d.g(str);
    }
  }
  
  private void e()
  {
    File[] arrayOfFile = new File(this.j).listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {}
    ArrayList localArrayList;
    label86:
    do
    {
      return;
      localArrayList = new ArrayList();
      int m = 0;
      if (m < arrayOfFile.length)
      {
        String str;
        long l;
        if (!arrayOfFile[m].isDirectory())
        {
          str = arrayOfFile[m].getName();
          l = b(str);
          if (l != -1L) {
            break label86;
          }
        }
        for (;;)
        {
          m += 1;
          break;
          if (l <= System.currentTimeMillis() / 1000L) {
            arrayOfFile[m].delete();
          } else {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.isEmpty());
    b(localArrayList);
  }
  
  private boolean f()
  {
    Object localObject = new File(this.j);
    if (!((File)localObject).exists()) {}
    do
    {
      return false;
      localObject = ((File)localObject).listFiles();
    } while (localObject == null);
    int n = localObject.length;
    int m = 0;
    if (m < n)
    {
      File localFile = localObject[m];
      if (localFile.isDirectory()) {}
      do
      {
        try
        {
          b.e(localFile);
          m += 1;
        }
        catch (IOException localIOException) {}
      } while (localFile.delete());
      return false;
    }
    return true;
    return false;
  }
  
  public final boolean a(k paramk)
  {
    this.g = paramk;
    String str = i.n(this.c);
    int m;
    if (str == null)
    {
      str = this.c.getCacheDir().getAbsolutePath();
      if (str == null) {
        m = 0;
      }
    }
    while (m == 0)
    {
      return false;
      for (str = String.format(Locale.US, "%s/%s/precache/", new Object[] { str, "com.maa.sdk" });; str = String.format(Locale.US, "%s/%s/%s/precache/", new Object[] { str, "com.maa.sdk", i.g(this.c) }))
      {
        File localFile = new File(str);
        if ((localFile.exists()) || (localFile.mkdirs())) {
          break label132;
        }
        m = 0;
        break;
      }
      label132:
      this.j = str;
      str = this.j;
      m = 1;
    }
    for (;;)
    {
      try
      {
        this.h.b(true);
        this.h.a(this.j);
        str = this.d.i();
        if (!paramk.a().equals(str))
        {
          f();
          this.i = new a.1().c(this.g.a()).a(a.b().h().a()).b(this.g.c()).a(new h.a()
          {
            public final void a(Throwable paramAnonymousThrowable)
            {
              f.a();
            }
          }).a(new h.b()
          {
            private void a(JSONObject paramAnonymousJSONObject)
            {
              try
              {
                f.a(f.this, paramAnonymousJSONObject);
                return;
              }
              catch (JSONException paramAnonymousJSONObject)
              {
                com.mato.sdk.c.b.f.b().a(paramAnonymousJSONObject);
                f.a();
              }
            }
          });
          a.b().a(this.i.a());
          return true;
        }
      }
      catch (j paramk)
      {
        return false;
      }
      e();
      c(this.d.f(str));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */