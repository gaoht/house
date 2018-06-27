package com.baidu.trace;

import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.lbsapi.auth.tracesdk.LBSAuthManager;
import com.baidu.trace.c.e;

public final class q
{
  protected static String a;
  protected static String b;
  protected static String c;
  protected static String d;
  private static boolean e = false;
  
  protected static void a(Context paramContext, LBSAuthManager paramLBSAuthManager)
  {
    if (e) {
      return;
    }
    a = "android" + Build.VERSION.RELEASE;
    b = "3.0.7";
    c = paramLBSAuthManager.getCUID();
    d = e.c(paramContext);
    paramLBSAuthManager.getKey();
    paramLBSAuthManager.getMCode();
    e = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */