package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.misc.h.b;
import com.xiaomi.push.service.at;
import com.xiaomi.smack.util.e;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile b c = null;
  private final ConcurrentLinkedQueue<b> a = new ConcurrentLinkedQueue();
  private Context b;
  
  private b(Context paramContext)
  {
    this.b = paramContext;
    this.a.add(new a());
    b(0L);
  }
  
  public static b a(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new b(paramContext);
      }
      c.b = paramContext;
      return c;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    b localb = (b)this.a.peek();
    if ((localb != null) && (localb.d())) {
      b(paramLong);
    }
  }
  
  private void b()
  {
    if ((com.xiaomi.channel.commonutils.file.c.b()) || (com.xiaomi.channel.commonutils.file.c.a())) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new File(this.b.getExternalFilesDir(null) + "/.logcache");
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          continue;
        }
        localObject = ((File)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
        return;
      }
      catch (NullPointerException localNullPointerException) {}
    }
  }
  
  private void b(long paramLong)
  {
    if (!this.a.isEmpty()) {
      e.a(new d(this), paramLong);
    }
  }
  
  private void c()
  {
    while ((!this.a.isEmpty()) && ((((b)this.a.peek()).e()) || (this.a.size() > 6)))
    {
      com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
      this.a.remove();
    }
  }
  
  public void a()
  {
    c();
    a(0L);
  }
  
  public void a(String paramString1, String paramString2, Date paramDate1, Date paramDate2, int paramInt, boolean paramBoolean)
  {
    this.a.add(new c(this, paramInt, paramDate1, paramDate2, paramString1, paramString2, paramBoolean));
    b(0L);
  }
  
  class a
    extends b.b
  {
    a()
    {
      super();
    }
    
    public void b()
    {
      b.c(b.this);
    }
  }
  
  class b
    extends h.b
  {
    long i = System.currentTimeMillis();
    
    b() {}
    
    public void b() {}
    
    public boolean d()
    {
      return true;
    }
    
    final boolean e()
    {
      return System.currentTimeMillis() - this.i > 172800000L;
    }
  }
  
  class c
    extends b.b
  {
    String a;
    String b;
    File c;
    int d;
    boolean e;
    boolean f;
    
    c(String paramString1, String paramString2, File paramFile, boolean paramBoolean)
    {
      super();
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramFile;
      this.f = paramBoolean;
    }
    
    private boolean f()
    {
      SharedPreferences localSharedPreferences = b.a(b.this).getSharedPreferences("log.timestamp", 0);
      Object localObject = localSharedPreferences.getString("log.requst", "");
      long l2 = System.currentTimeMillis();
      long l1 = l2;
      int j;
      try
      {
        localObject = new JSONObject((String)localObject);
        l1 = l2;
        l2 = ((JSONObject)localObject).getLong("time");
        l1 = l2;
        i = ((JSONObject)localObject).getInt("times");
        l1 = l2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          int i = 0;
        }
        l1 = System.currentTimeMillis();
        j = 0;
        label108:
        localJSONObject = new JSONObject();
      }
      if (System.currentTimeMillis() - l1 < 86400000L)
      {
        j = i;
        if (i <= 10) {
          break label108;
        }
        return false;
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("time", l1);
        localJSONObject.put("times", j + 1);
        localSharedPreferences.edit().putString("log.requst", localJSONObject.toString()).commit();
        return true;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + localJSONException1.getMessage());
        }
      }
    }
    
    public void b()
    {
      try
      {
        if (f())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("uid", at.e());
          localHashMap.put("token", this.b);
          localHashMap.put("net", com.xiaomi.channel.commonutils.network.d.k(b.a(b.this)));
          com.xiaomi.channel.commonutils.network.d.a(this.a, localHashMap, this.c, "file");
        }
        this.e = true;
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public void c()
    {
      if (!this.e)
      {
        this.d += 1;
        if (this.d < 3) {
          b.b(b.this).add(this);
        }
      }
      if ((this.e) || (this.d >= 3)) {
        this.c.delete();
      }
      b.a(b.this, (1 << this.d) * 1000);
    }
    
    public boolean d()
    {
      return (com.xiaomi.channel.commonutils.network.d.f(b.a(b.this))) || ((this.f) && (com.xiaomi.channel.commonutils.network.d.d(b.a(b.this))));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/log/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */