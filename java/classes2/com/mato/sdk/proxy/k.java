package com.mato.sdk.proxy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.mato.sdk.g.j;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class k
{
  private static final String a = "com.chinanetcenter.www";
  private final SharedPreferences b;
  private final SharedPreferences.Editor c;
  private final Lock d = new ReentrantLock();
  
  public k(Context paramContext, String paramString)
  {
    this.b = paramContext.getSharedPreferences(paramString, 0);
    this.c = this.b.edit();
  }
  
  private float a(String paramString, float paramFloat)
  {
    try
    {
      float f = Float.parseFloat(a(paramString));
      return f;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  private String a(String paramString)
  {
    paramString = this.b.getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return j.b(paramString, "com.chinanetcenter.www");
  }
  
  private static String b(String paramString)
  {
    return j.a(paramString, "com.chinanetcenter.www");
  }
  
  private boolean b(String paramString, float paramFloat)
  {
    return d(paramString, String.valueOf(paramFloat));
  }
  
  private static String c(String paramString)
  {
    return j.b(paramString, "com.chinanetcenter.www");
  }
  
  public final int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(a(paramString));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public final long a(String paramString, long paramLong)
  {
    try
    {
      paramLong = Long.parseLong(a(paramString));
      return paramLong;
    }
    catch (NumberFormatException paramString) {}
    return 100L;
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Boolean.parseBoolean(paramString);
  }
  
  public final String b(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final boolean b(String paramString, int paramInt)
  {
    return d(paramString, String.valueOf(paramInt));
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    return d(paramString, String.valueOf(paramLong));
  }
  
  public final boolean b(String paramString, boolean paramBoolean)
  {
    return d(paramString, String.valueOf(paramBoolean));
  }
  
  public final boolean c(String paramString1, String paramString2)
  {
    this.d.lock();
    try
    {
      this.c.putString(paramString1, paramString2);
      boolean bool = this.c.commit();
      return bool;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  public final boolean d(String paramString1, String paramString2)
  {
    paramString2 = j.a(paramString2, "com.chinanetcenter.www");
    if (paramString2 == null) {
      return false;
    }
    return c(paramString1, paramString2);
  }
  
  public final boolean g(String paramString)
  {
    this.d.lock();
    try
    {
      this.c.remove(paramString);
      boolean bool = this.c.commit();
      return bool;
    }
    finally
    {
      this.d.unlock();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */