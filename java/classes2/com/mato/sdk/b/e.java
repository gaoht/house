package com.mato.sdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.mato.sdk.g.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e
{
  private static Class<?> o;
  private final Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private int m;
  private int n;
  
  e() {}
  
  public e(Context paramContext)
  {
    this.a = i.m(paramContext);
    this.g = i.g(paramContext);
    this.d = this.g;
    this.c = i.f(paramContext);
    this.b = i.e(paramContext);
    this.e = i.d(paramContext);
    this.f = i.c(paramContext);
    this.h = i.l(paramContext);
    if (this.h == null) {
      this.h = "";
    }
    this.i = Build.MODEL;
    this.j = Build.MANUFACTURER;
    this.k = i.b(paramContext, "unknown");
    this.l = i.a(paramContext, "unknown");
    paramContext = i.i(paramContext);
    if (paramContext != null)
    {
      this.m = paramContext.widthPixels;
      this.n = paramContext.heightPixels;
      return;
    }
    this.m = 0;
    this.n = 0;
  }
  
  private void a(Context paramContext)
  {
    this.g = i.g(paramContext);
    this.d = this.g;
    this.c = i.f(paramContext);
    this.b = i.e(paramContext);
    this.e = i.d(paramContext);
    this.f = i.c(paramContext);
    this.h = i.l(paramContext);
    if (this.h == null) {
      this.h = "";
    }
  }
  
  private void b(Context paramContext)
  {
    this.i = Build.MODEL;
    this.j = Build.MANUFACTURER;
    this.k = i.b(paramContext, "unknown");
    this.l = i.a(paramContext, "unknown");
    paramContext = i.i(paramContext);
    if (paramContext != null)
    {
      this.m = paramContext.widthPixels;
      this.n = paramContext.heightPixels;
      return;
    }
    this.m = 0;
    this.n = 0;
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android/");
    localStringBuilder.append(Build.VERSION.RELEASE);
    return localStringBuilder.toString();
  }
  
  public static Class<?> m()
    throws ClassNotFoundException
  {
    if (o == null) {
      o = Class.forName("android.webkit.WebViewFactory");
    }
    return o;
  }
  
  public static Object n()
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException
  {
    Method localMethod = m().getDeclaredMethod("getProvider", new Class[0]);
    if (!localMethod.isAccessible()) {
      localMethod.setAccessible(true);
    }
    return localMethod.invoke(null, new Object[0]);
  }
  
  private Context o()
  {
    return this.a;
  }
  
  private String p()
  {
    return this.b;
  }
  
  private String q()
  {
    return this.f;
  }
  
  private String r()
  {
    return this.h;
  }
  
  public final String a()
  {
    return this.i;
  }
  
  public final void a(String paramString)
  {
    this.d = paramString;
  }
  
  public final String b()
  {
    return this.j;
  }
  
  public final String d()
  {
    return this.k;
  }
  
  public final String e()
  {
    return this.l;
  }
  
  public final String f()
  {
    return this.m + "*" + this.n;
  }
  
  public final int g()
  {
    return this.m;
  }
  
  public final int h()
  {
    return this.n;
  }
  
  public final String i()
  {
    return this.c;
  }
  
  public final String j()
  {
    return this.d;
  }
  
  public final String k()
  {
    return this.g;
  }
  
  public final String l()
  {
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */