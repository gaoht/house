package com.unionpay.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.File;

public class a
{
  private static volatile a a = null;
  private PackageInfo b = null;
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private boolean i(Context paramContext)
  {
    try
    {
      if (this.b == null) {
        this.b = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      }
      bool = true;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
        boolean bool = false;
      }
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
    return bool;
  }
  
  public String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    i(paramContext);
    return paramContext.getPackageName();
  }
  
  public int b(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return -1;
      try
      {
        if (i(paramContext))
        {
          int i = this.b.versionCode;
          return i;
        }
      }
      catch (Throwable paramContext) {}
    }
    return -1;
  }
  
  public String c(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    try
    {
      if (!i(paramContext)) {
        return "unknown";
      }
      paramContext = this.b.versionName;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "unknown";
  }
  
  public long d(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return -1L;
      try
      {
        if ((i(paramContext)) && (r.a(9)))
        {
          long l = this.b.firstInstallTime;
          return l;
        }
      }
      catch (Throwable paramContext) {}
    }
    return -1L;
  }
  
  public long e(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return -1L;
      try
      {
        if ((i(paramContext)) && (r.a(9)))
        {
          long l = this.b.lastUpdateTime;
          return l;
        }
      }
      catch (Throwable paramContext) {}
    }
    return -1L;
  }
  
  public long f(Context paramContext)
  {
    if (paramContext == null) {
      return -1L;
    }
    try
    {
      i(paramContext);
      long l = new File(paramContext.getApplicationInfo().sourceDir).length();
      return l;
    }
    catch (Throwable paramContext) {}
    return -1L;
  }
  
  public String g(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (i(paramContext))
        {
          paramContext = this.b.signatures;
          if (paramContext.length > 0)
          {
            StringBuffer localStringBuffer = new StringBuffer();
            localStringBuffer.append(paramContext[0].toCharsString());
            paramContext = localStringBuffer.toString();
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  public String h(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      i(paramContext);
      paramContext = paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */