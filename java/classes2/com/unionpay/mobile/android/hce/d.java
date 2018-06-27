package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;

public final class d
{
  private String a;
  private String b;
  private String c;
  private boolean d;
  private boolean e;
  private ServiceConnection f;
  
  public d(String paramString)
  {
    this.a = paramString;
    this.b = null;
    this.c = null;
    this.d = false;
    this.e = false;
    this.f = null;
  }
  
  public final void a(ServiceConnection paramServiceConnection)
  {
    this.f = paramServiceConnection;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final boolean b()
  {
    return this.e;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final ServiceConnection d()
  {
    return this.f;
  }
  
  public final void e()
  {
    this.d = true;
  }
  
  public final void f()
  {
    this.e = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */