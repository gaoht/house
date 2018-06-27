package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class m
{
  private static final int i = 48;
  private static final int j = 49;
  private static Context k;
  private h a = null;
  private o b = null;
  private p c = null;
  private boolean d = false;
  private boolean e = false;
  private long f = 0L;
  private final String g = "main_fest_mode";
  private final String h = "main_fest_timestamp";
  private List<String> l = new ArrayList();
  private a m = null;
  private final Thread n = new Thread(new Runnable()
  {
    public void run()
    {
      
      if (m.a(m.this) == null) {
        m.a(m.this, new m.a(m.this));
      }
      m.b(m.this);
    }
  });
  
  private m()
  {
    if (k != null)
    {
      if (this.a == null) {
        this.a = new h();
      }
      if (this.b == null) {
        this.b = o.a(k);
      }
      if (this.c == null) {
        this.c = new p();
      }
    }
    this.n.start();
  }
  
  public static final m a(Context paramContext)
  {
    k = paramContext;
    return b.a();
  }
  
  private void a(l paraml, List<String> paramList)
  {
    this.a.a(new f()
    {
      public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousObject instanceof h)) {
          m.a(m.this, (h)paramAnonymousObject);
        }
        while (!(paramAnonymousObject instanceof Boolean)) {
          return;
        }
        m.i(m.this);
      }
    }, paraml, paramList, this.l);
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    this.m.sendEmptyMessageDelayed(48, q.c(l1));
    this.m.sendEmptyMessageDelayed(49, q.d(l1));
  }
  
  private boolean i()
  {
    return this.l.size() < n.a().d();
  }
  
  private void j()
  {
    Object localObject = ba.a(k);
    if (!((SharedPreferences)localObject).getBoolean("main_fest_mode", false))
    {
      this.e = true;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("main_fest_mode", true);
      ((SharedPreferences.Editor)localObject).putLong("main_fest_timestamp", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  private void k()
  {
    SharedPreferences.Editor localEditor = ba.a(k).edit();
    localEditor.putBoolean("main_fest_mode", false);
    localEditor.putLong("main_fest_timestamp", 0L);
    localEditor.commit();
    this.e = false;
  }
  
  private void l()
  {
    SharedPreferences localSharedPreferences = ba.a(k);
    this.e = localSharedPreferences.getBoolean("main_fest_mode", false);
    this.f = localSharedPreferences.getLong("main_fest_timestamp", 0L);
  }
  
  private void m()
  {
    Iterator localIterator = this.a.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)((Map.Entry)localIterator.next()).getKey();
      if (!this.l.contains(localList)) {
        this.l.add(d.a(localList));
      }
    }
    if (this.l.size() > 0) {
      this.b.a(new f(), this.l);
    }
  }
  
  private void n()
  {
    this.c.a(new f()
    {
      public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        m.a(m.this, (p)paramAnonymousObject);
      }
    }, "__ag_of");
  }
  
  private void o()
  {
    try
    {
      if (this.a.a().size() > 0) {
        this.b.c(new f()
        {
          public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousObject instanceof String)) {
              m.e(m.this).d();
            }
          }
        }, this.a.a());
      }
      if (this.c.a().size() > 0) {
        this.b.b(new f()
        {
          public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousObject instanceof String)) {
              m.j(m.this).b();
            }
          }
        }, this.c.a());
      }
      if (this.l.size() > 0) {
        this.b.a(new f(), this.l);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      by.b("converyMemoryToDataTable happen error: " + localThrowable.toString());
    }
  }
  
  private void p()
  {
    try
    {
      if (this.a.a().size() > 0) {
        this.b.a(new f()
        {
          public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean) {}
        }, this.a.a());
      }
      if (this.c.a().size() > 0) {
        this.b.b(new f()
        {
          public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousObject instanceof String)) {
              m.j(m.this).b();
            }
          }
        }, this.c.a());
      }
      if (this.l.size() > 0) {
        this.b.a(new f(), this.l);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      by.b("convertMemoryToCacheTable happen error: " + localThrowable.toString());
    }
  }
  
  private void q()
  {
    List localList = this.b.b();
    if (localList != null) {
      this.l = localList;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    this.b.a(new f()
    {
      public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousObject.equals("success")) {}
      }
    }, paramString, paramLong1, paramLong2);
  }
  
  public void a(final f paramf)
  {
    if (this.d) {
      return;
    }
    bz.b(new cb()
    {
      public void a()
      {
        try
        {
          m.f(m.this).a(new f()
          {
            public void a(Object paramAnonymous2Object, boolean paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Object instanceof Map))
              {
                paramAnonymous2Object = (Map)paramAnonymous2Object;
                m.e(m.this).a((Map)paramAnonymous2Object);
              }
              for (;;)
              {
                m.a(m.this, true);
                return;
                if (((paramAnonymous2Object instanceof String)) || (!(paramAnonymous2Object instanceof Boolean))) {}
              }
            }
          });
          m.g(m.this);
          m.h(m.this);
          paramf.a("success", false);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  public void a(final f paramf, Map<List<String>, l> paramMap)
  {
    paramMap = (l)paramMap.values().toArray()[0];
    List localList = paramMap.a();
    if ((this.l.size() > 0) && (this.l.contains(d.a(localList))))
    {
      this.a.a(new f()
      {
        public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousObject instanceof h)) {
            m.a(m.this, (h)paramAnonymousObject);
          }
          paramf.a("success", false);
        }
      }, paramMap);
      return;
    }
    if (this.e)
    {
      a(paramMap, localList);
      return;
    }
    if (i())
    {
      paramf = d.a(localList);
      if (!this.l.contains(paramf)) {
        this.l.add(paramf);
      }
      this.a.a(new f()
      {
        public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          m.a(m.this, (h)paramAnonymousObject);
        }
      }, localList, paramMap);
      return;
    }
    a(paramMap, localList);
    j();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = this.b.a();
    JSONObject localJSONObject2 = new JSONObject();
    if ((localJSONObject1 == null) || (localJSONObject1.length() <= 0)) {
      return null;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localJSONObject1.has(str)) {
        try
        {
          localJSONObject2.put(str, localJSONObject1.opt(str));
        }
        catch (Exception localException) {}
      }
    }
    return localJSONObject2;
  }
  
  public void b(f paramf)
  {
    boolean bool = false;
    if (this.e)
    {
      if (this.f == 0L) {
        l();
      }
      bool = q.a(System.currentTimeMillis(), this.f);
    }
    if (!bool)
    {
      k();
      this.l.clear();
    }
    this.c.b();
    this.b.a(new f()
    {
      public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousObject.equals("success")) {
          m.k(m.this);
        }
      }
    }, bool);
  }
  
  public JSONObject c()
  {
    if (this.c.a().size() > 0) {
      this.b.b(new f()
      {
        public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousObject instanceof String)) {
            m.j(m.this).b();
          }
        }
      }, this.c.a());
    }
    return this.b.b(new f());
  }
  
  public void d()
  {
    p();
  }
  
  public void e()
  {
    p();
  }
  
  public void f()
  {
    p();
  }
  
  private static class a
    extends Handler
  {
    private final WeakReference<m> a;
    
    public a(m paramm)
    {
      this.a = new WeakReference(paramm);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.a != null) {}
      switch (paramMessage.what)
      {
      default: 
        return;
      case 48: 
        sendEmptyMessageDelayed(48, q.c(System.currentTimeMillis()));
        m.c(m.a(m.g()));
        return;
      }
      sendEmptyMessageDelayed(49, q.d(System.currentTimeMillis()));
      m.d(m.a(m.g()));
    }
  }
  
  private static class b
  {
    private static final m a = new m(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */