package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.d;
import java.util.ArrayList;
import java.util.List;

public class p
{
  private static p a = null;
  private Context b;
  private List<String> c = new ArrayList();
  private final List<String> d = new ArrayList();
  private final List<String> e = new ArrayList();
  
  private p(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    paramContext = this.b.getSharedPreferences("mipush_app_info", 0);
    String[] arrayOfString = paramContext.getString("unregistered_pkg_names", "").split(",");
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (TextUtils.isEmpty(str)) {
        this.c.add(str);
      }
      i += 1;
    }
    arrayOfString = paramContext.getString("disable_push_pkg_names", "").split(",");
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      str = arrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        this.d.add(str);
      }
      i += 1;
    }
    paramContext = paramContext.getString("disable_push_pkg_names_cache", "").split(",");
    k = paramContext.length;
    i = j;
    while (i < k)
    {
      arrayOfString = paramContext[i];
      if (!TextUtils.isEmpty(arrayOfString)) {
        this.e.add(arrayOfString);
      }
      i += 1;
    }
  }
  
  public static p a(Context paramContext)
  {
    if (a == null) {
      a = new p(paramContext);
    }
    return a;
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.c)
    {
      boolean bool = this.c.contains(paramString);
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    synchronized (this.d)
    {
      boolean bool = this.d.contains(paramString);
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    synchronized (this.e)
    {
      boolean bool = this.e.contains(paramString);
      return bool;
    }
  }
  
  public void d(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramString))
      {
        this.c.add(paramString);
        paramString = d.a(this.c, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", paramString).commit();
      }
      return;
    }
  }
  
  public void e(String paramString)
  {
    synchronized (this.d)
    {
      if (!this.d.contains(paramString))
      {
        this.d.add(paramString);
        paramString = d.a(this.d, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", paramString).commit();
      }
      return;
    }
  }
  
  public void f(String paramString)
  {
    synchronized (this.e)
    {
      if (!this.e.contains(paramString))
      {
        this.e.add(paramString);
        paramString = d.a(this.e, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", paramString).commit();
      }
      return;
    }
  }
  
  public void g(String paramString)
  {
    synchronized (this.c)
    {
      if (this.c.contains(paramString))
      {
        this.c.remove(paramString);
        paramString = d.a(this.c, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", paramString).commit();
      }
      return;
    }
  }
  
  public void h(String paramString)
  {
    synchronized (this.d)
    {
      if (this.d.contains(paramString))
      {
        this.d.remove(paramString);
        paramString = d.a(this.d, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", paramString).commit();
      }
      return;
    }
  }
  
  public void i(String paramString)
  {
    synchronized (this.e)
    {
      if (this.e.contains(paramString))
      {
        this.e.remove(paramString);
        paramString = d.a(this.e, ",");
        this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", paramString).commit();
      }
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */