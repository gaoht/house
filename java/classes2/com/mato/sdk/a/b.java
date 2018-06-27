package com.mato.sdk.a;

import com.mato.sdk.b.h;

public final class b
{
  private static final String a = com.mato.sdk.b.g.b("");
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private final e e;
  private final com.mato.sdk.proxy.g f;
  
  public b(com.mato.sdk.proxy.g paramg)
  {
    this.f = paramg;
    this.e = new e(paramg);
  }
  
  private void a(int paramInt, final a parama)
  {
    a locala = new a();
    locala.a(this.e.c());
    locala.a(paramInt);
    locala.c(this.f.a("app_exist_time", 0));
    locala.b(this.f.a("app_url_counts", 0));
    locala.b(com.mato.sdk.proxy.a.b().h().a());
    locala.a(new a.a()
    {
      public final void a(a paramAnonymousa)
      {
        b.b();
        b.a(b.this).e();
        parama.a(paramAnonymousa.a());
      }
      
      public final void b(a paramAnonymousa)
      {
        b.b();
        b.a(b.this).a(paramAnonymousa.c());
        parama.b(paramAnonymousa.b());
      }
    });
    com.mato.sdk.b.a.a();
    com.mato.sdk.b.a.c();
    locala.d();
  }
  
  public final void a(a parama)
  {
    a(0, parama);
  }
  
  public final boolean a()
  {
    return this.e.b() == 2;
  }
  
  public final boolean a(long paramLong)
  {
    long l = this.e.d();
    int i = this.e.b();
    return (e.a(paramLong, l)) || (i != 0);
  }
  
  public final void b(a parama)
  {
    a(1, parama);
  }
  
  public final void c(a parama)
  {
    a(2, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */