package com.mato.sdk.a;

import com.mato.sdk.b.g;
import com.mato.sdk.proxy.k;
import java.util.Date;

public final class e
{
  private static final String a = g.b("");
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static final String e = "auth_result";
  private static final String f = "auth_fail_time";
  private static final String g = "auth_time";
  private final k h;
  
  public e(k paramk)
  {
    this.h = paramk;
  }
  
  private void a(long paramLong)
  {
    String str = c() + "," + paramLong;
    this.h.d("auth_fail_time", str);
  }
  
  private void a(String paramString)
  {
    this.h.d("auth_fail_time", paramString);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {}
    while ((new Date().getTime() - paramLong2) / 1000L > 86400L * paramLong1) {
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.h.b("auth_result", paramInt);
  }
  
  private void f()
  {
    long l = new Date().getTime();
    this.h.d("auth_time", String.valueOf(l));
  }
  
  private void g()
  {
    this.h.c("auth_fail_time", "");
  }
  
  public final void a(int paramInt)
  {
    f();
    switch (paramInt)
    {
    default: 
      new StringBuilder("Invalid auth failure type: ").append(paramInt);
      return;
    case 2: 
      b(paramInt);
      g();
      return;
    }
    b(paramInt);
    long l = new Date().getTime();
    String str = c() + "," + l;
    this.h.d("auth_fail_time", str);
  }
  
  public final boolean a()
  {
    return b() == 2;
  }
  
  public final int b()
  {
    return this.h.a("auth_result", 2);
  }
  
  public final String c()
  {
    return this.h.b("auth_fail_time", "");
  }
  
  public final long d()
  {
    return this.h.a("auth_time", 100L);
  }
  
  public final void e()
  {
    f();
    b(0);
    g();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */