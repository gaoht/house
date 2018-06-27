package com.xiaomi.push.service.module;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class c
{
  private String a;
  private String b;
  private String c;
  private int d = 0;
  private ClassLoader e;
  private Object f;
  
  public c(String paramString1, String paramString2, ClassLoader paramClassLoader, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramClassLoader;
    this.d = paramInt;
    this.c = paramString3;
    try
    {
      if (!TextUtils.isEmpty(paramString3)) {
        this.f = this.e.loadClass(paramString3).newInstance();
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public ClassLoader a()
  {
    return this.e;
  }
  
  public void a(Context paramContext)
  {
    if (this.f != null) {}
    try
    {
      this.e.loadClass(this.c).getMethod("onCreate", new Class[] { Context.class, String.class }).invoke(this.f, new Object[] { paramContext, this.b });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/module/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */