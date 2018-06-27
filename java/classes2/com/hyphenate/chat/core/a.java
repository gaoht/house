package com.hyphenate.chat.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.hyphenate.chat.EMClient;

public class a
{
  private static final String a = "hyphenate.sdk.pref";
  private static SharedPreferences b;
  private static SharedPreferences.Editor c;
  private static a d;
  private static String e = "shared_key_ddversion";
  private static String f = "shared_key_ddxml";
  private static String g = "shared_key_ddtime";
  private static String h = "valid_before";
  private static String i = "scheduled_logout_time";
  private static String j = "shared_key_gcm_id";
  private static String k = "shared_key_fcm_id";
  private static String l = "push_flag";
  private static String m = "huawei_app_id";
  private long n = 0L;
  
  @SuppressLint({"CommitPrefEdits"})
  private a(Context paramContext)
  {
    b = paramContext.getSharedPreferences("hyphenate.sdk.pref", 0);
    c = b.edit();
  }
  
  public static a a()
  {
    try
    {
      if (d == null) {
        d = new a(EMClient.getInstance().getContext());
      }
      a locala = d;
      return locala;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    c.putLong(g, paramLong);
    c.commit();
  }
  
  public void a(String paramString)
  {
    c.putString(e, paramString);
    c.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null))
    {
      c.remove("debugIM");
      c.remove("debugRest");
    }
    for (;;)
    {
      c.commit();
      return;
      c.putString("debugIM", paramString1);
      c.putString("debugRest", paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c.putString("debugMode", String.valueOf(paramBoolean));
    c.commit();
  }
  
  public long b()
  {
    return b.getLong(h, -1L);
  }
  
  public void b(long paramLong)
  {
    c.putLong(h, paramLong);
    c.commit();
  }
  
  public void b(String paramString)
  {
    c.putString(f, paramString);
    c.commit();
  }
  
  public String c()
  {
    return b.getString(e, "");
  }
  
  public void c(long paramLong)
  {
    this.n = paramLong;
    c.putLong(i, paramLong);
    c.commit();
  }
  
  public void c(String paramString)
  {
    c.putString("debugAppkey", paramString);
    c.commit();
  }
  
  public String d()
  {
    return b.getString(f, "");
  }
  
  public void d(String paramString)
  {
    c.putString(j, paramString);
    c.commit();
  }
  
  public long e()
  {
    return b.getLong(g, -1L);
  }
  
  public void e(String paramString)
  {
    c.putString(k, paramString);
    c.commit();
  }
  
  public void f(String paramString)
  {
    c.putString(l, paramString);
    c.commit();
  }
  
  public boolean f()
  {
    if (this.n != 0L) {
      return true;
    }
    return b.contains(i);
  }
  
  public long g()
  {
    if (this.n != 0L) {
      return this.n;
    }
    this.n = b.getLong(i, -1L);
    return this.n;
  }
  
  public void g(String paramString)
  {
    c.putString(m, paramString);
    c.commit();
  }
  
  public void h()
  {
    if (f())
    {
      this.n = 0L;
      c.remove(i);
      c.commit();
    }
  }
  
  public String i()
  {
    return b.getString("debugIM", null);
  }
  
  public String j()
  {
    return b.getString("debugRest", null);
  }
  
  public String k()
  {
    return b.getString("debugAppkey", null);
  }
  
  public String l()
  {
    return b.getString("debugMode", null);
  }
  
  public String m()
  {
    return b.getString(j, null);
  }
  
  public String n()
  {
    return b.getString(k, null);
  }
  
  public String o()
  {
    return b.getString(l, null);
  }
  
  public String p()
  {
    return b.getString(m, null);
  }
  
  public static class a
  {
    String a;
    long b;
    
    public a() {}
    
    public a(String paramString, long paramLong)
    {
      this.a = paramString;
      this.b = paramLong;
    }
    
    public a a(long paramLong)
    {
      this.b = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public String a()
    {
      if (this.b <= 0L) {
        this.a = null;
      }
      return this.a;
    }
    
    public long b()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */