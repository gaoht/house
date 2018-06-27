package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.cc;

public class c
{
  private static String[] a = new String[2];
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a[0] = paramString1;
    a[1] = paramString2;
    if (paramContext != null) {
      cc.a(paramContext).a(paramString1, paramString2);
    }
  }
  
  public static String[] a(Context paramContext)
  {
    if ((!TextUtils.isEmpty(a[0])) && (!TextUtils.isEmpty(a[1]))) {
      return a;
    }
    if (paramContext != null)
    {
      paramContext = cc.a(paramContext).a();
      if (paramContext != null)
      {
        a[0] = paramContext[0];
        a[1] = paramContext[1];
        return a;
      }
    }
    return null;
  }
  
  public static void b(Context paramContext)
  {
    a[0] = null;
    a[1] = null;
    if (paramContext != null) {
      cc.a(paramContext).b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */