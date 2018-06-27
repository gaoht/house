package com.mato.sdk.c;

import com.mato.sdk.b.g;
import java.io.InputStream;
import java.util.Map;

public final class a
{
  private static final String a = g.b("");
  private static final int b = 2;
  private String c = "file";
  private String d;
  private String e = "gzip";
  private InputStream f;
  private c.b g;
  private Map<String, String> h;
  private c.a i;
  private int j = 1;
  
  private static boolean a(int paramInt)
  {
    return paramInt <= 2;
  }
  
  private void b()
  {
    if (this.g != null) {
      this.g.a();
    }
  }
  
  private void c()
  {
    int k = this.j + 1;
    this.j = k;
    if (k <= 2)
    {
      k = 1;
      if (k == 0) {
        break label47;
      }
      k = this.j;
      com.mato.sdk.proxy.a.b().a(this.i.a());
    }
    label47:
    while (this.g == null)
    {
      return;
      k = 0;
      break;
    }
    this.g.b();
  }
  
  public final void a()
  {
    this.i = new c.a();
    this.i.b(this.d);
    this.i.c(this.e);
    this.i.a(this.c);
    this.i.a(this.h);
    this.i.a(this.f);
    this.i.a(new c.b()
    {
      public final void a()
      {
        a.a(a.this);
      }
      
      public final void b()
      {
        a.b(a.this);
      }
    });
    com.mato.sdk.proxy.a.b().a(this.i.a());
  }
  
  public final void a(c.b paramb)
  {
    this.g = paramb;
  }
  
  public final void a(InputStream paramInputStream)
  {
    this.f = paramInputStream;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.h = paramMap;
  }
  
  public final void b(String paramString)
  {
    this.d = paramString;
  }
  
  public final void c(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */