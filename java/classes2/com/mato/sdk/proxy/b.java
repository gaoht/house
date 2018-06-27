package com.mato.sdk.proxy;

import java.util.Locale;

public class b
{
  private String a = null;
  private ProxyOptions b;
  private String c = null;
  private String d = null;
  private String e = null;
  private boolean f = false;
  private final boolean g;
  
  private void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public static boolean a()
  {
    return true;
  }
  
  private void b(String paramString)
  {
    this.a = paramString;
  }
  
  private void c(String paramString)
  {
    this.d = paramString;
  }
  
  private String e()
  {
    return this.a;
  }
  
  private String f()
  {
    return this.c;
  }
  
  private boolean g()
  {
    return this.f;
  }
  
  public final void a(ProxyOptions paramProxyOptions)
  {
    this.b = paramProxyOptions;
  }
  
  public final void a(String paramString)
  {
    this.e = paramString;
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.d = String.format(Locale.US, "%s/access.log", new Object[] { paramString });
    this.e = String.format(Locale.US, "%s/debug.log", new Object[] { paramString });
    this.f = paramBoolean;
  }
  
  public final ProxyOptions b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final String d()
  {
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */