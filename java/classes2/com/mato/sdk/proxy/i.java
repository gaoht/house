package com.mato.sdk.proxy;

import android.text.TextUtils;
import com.mato.android.matoid.service.mtunnel.b;
import com.mato.sdk.b.h;
import com.mato.sdk.e.a.a;
import java.util.concurrent.atomic.AtomicReference;

final class i
  extends b
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final d b;
  
  public i(d paramd)
  {
    this.b = paramd;
  }
  
  public final int a(int paramInt, String paramString)
  {
    this.b.u().a(paramInt, paramString);
    return 0;
  }
  
  public final int a(String paramString1, String paramString2)
  {
    com.mato.sdk.e.b.d.a(paramString1, paramString2);
    return 0;
  }
  
  public final void a(String paramString)
  {
    super.a(paramString);
    this.b.p().a(true);
    this.b.p().a("ndk_crash_mark", false);
    if (this.b.r()) {
      this.b.s();
    }
  }
  
  public final int b()
  {
    int j = this.b.h().c();
    int i = j;
    if (j == -1) {
      i = 3;
    }
    return i;
  }
  
  public final int b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    try
    {
      paramString2 = paramString2.split(";");
      this.b.b.set(new com.mato.sdk.b.f(paramString1, paramString2[0]));
      return 0;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public final void b(int paramInt)
  {
    this.b.p().b("app_url_counts", paramInt);
  }
  
  public final void b(String paramString)
  {
    a.a();
    a.a(paramString);
  }
  
  public final void c(int paramInt)
  {
    try
    {
      if (this.b.r()) {
        this.b.s();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.mato.sdk.c.b.f.b().a(localThrowable, "onHttpHandlerExit:" + paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */