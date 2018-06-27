package com.baidu.trace.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.baidu.trace.am;
import com.baidu.trace.c.f.a;

public final class d
{
  private static int k = Integer.MIN_VALUE;
  private static boolean l = false;
  private static long m = 0L;
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private Handler d = null;
  private Context e = null;
  private f f = null;
  private h g = null;
  private g h = null;
  private am i = null;
  private i j = null;
  
  public static d a()
  {
    return a.a();
  }
  
  public static void a(long paramLong)
  {
    m = paramLong;
  }
  
  public static void a(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  protected static boolean a(int paramInt)
  {
    return paramInt != k;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        com.baidu.trace.a.a("BaiduTraceSDK", "current network is not available");
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        boolean bool = paramContext.isAvailable();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      com.baidu.trace.a.a("BaiduTraceSDK", "current network is not available");
      return false;
    }
    finally {}
    return false;
  }
  
  public static void b(int paramInt)
  {
    k = paramInt;
  }
  
  public static boolean h()
  {
    return l;
  }
  
  public static long i()
  {
    return m;
  }
  
  public final void a(Handler paramHandler, Context paramContext)
  {
    this.d = paramHandler;
    this.e = paramContext;
  }
  
  public final void a(String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.i != null) {
      this.i = null;
    }
    this.i = new am(0, paramString);
    this.i.start();
  }
  
  public final void a(byte[] paramArrayOfByte, f.a parama)
  {
    if (this.j != null) {
      this.j = null;
    }
    this.j = new i(this.e, this.d, paramArrayOfByte, parama);
    this.j.start();
  }
  
  public final void b()
  {
    this.j = null;
    if (this.a)
    {
      this.a = false;
      if (this.f != null)
      {
        this.f.a();
        this.f = null;
      }
    }
    if (this.b)
    {
      this.b = false;
      if (this.h != null) {
        this.h.a();
      }
    }
    a.e();
  }
  
  public final void c()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    if (this.f != null) {
      this.f = null;
    }
    this.f = new f(this.e, this.d);
    this.f.start();
  }
  
  protected final void d()
  {
    if (this.g != null) {
      this.g = null;
    }
    this.g = new h(this.d);
    this.g.start();
  }
  
  public final void e()
  {
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
    }
  }
  
  public final void f()
  {
    this.c = false;
  }
  
  public final boolean g()
  {
    if (this.b) {
      return true;
    }
    if (a.b() == null)
    {
      if (this.d != null) {
        this.d.obtainMessage(4).sendToTarget();
      }
      return false;
    }
    this.b = true;
    this.h = new g(this.e, this.d);
    this.h.start();
    return true;
  }
  
  static final class a
  {
    private static d a = new d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */