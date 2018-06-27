package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class p
{
  private static p a = null;
  private Context b;
  private j c = new j();
  
  private p(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
  }
  
  public static p a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new p(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public String a()
  {
    try
    {
      String str = this.b.getSharedPreferences("mipush_extra", 0).getString("enable_disable_sync_status", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.c == null) {
        this.c = new j();
      }
      this.c.a = 0;
      this.c.b = paramString;
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      if (this.c == null) {
        this.c = new j();
      }
      int i = this.c.a;
      this.c.a = (i + 1);
      this.c.b = paramString;
      return;
    }
    finally {}
  }
  
  public int c(String paramString)
  {
    try
    {
      if ((this.c != null) && (this.c.b.equals(paramString)))
      {
        int i = this.c.a;
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public void d(String paramString)
  {
    try
    {
      if ((this.c != null) && (this.c.b.equals(paramString))) {
        this.c = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean e(String paramString)
  {
    try
    {
      return (this.c != null) && (this.c.b.equals(paramString));
    }
    finally {}
  }
  
  public void f(String paramString)
  {
    try
    {
      this.b.getSharedPreferences("mipush_extra", 0).edit().putString("enable_disable_sync_status", paramString).commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */