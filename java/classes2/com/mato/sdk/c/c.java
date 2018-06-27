package com.mato.sdk.c;

import com.mato.sdk.f.d;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends b
{
  private final String b;
  private final InputStream c;
  private final Map<String, String> d;
  
  private c(String paramString1, String paramString2, String paramString3, InputStream paramInputStream, Map<String, String> paramMap, h.b<d> paramb, h.a parama)
  {
    super(paramString1, paramString2, paramb, parama);
    this.b = paramString3;
    this.c = paramInputStream;
    this.d = paramMap;
  }
  
  public final Map<String, String> a()
  {
    return new HashMap();
  }
  
  protected final Map<String, String> d()
  {
    return this.d;
  }
  
  protected final String e()
  {
    return this.b;
  }
  
  protected final InputStream f()
  {
    return this.c;
  }
  
  public static final class a
  {
    private String a;
    private String b;
    private String c;
    private InputStream d;
    private c.b e;
    private Map<String, String> f;
    
    public final a a(c.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public final a a(InputStream paramInputStream)
    {
      this.d = paramInputStream;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public final a a(Map<String, String> paramMap)
    {
      this.f = paramMap;
      return this;
    }
    
    public final c a()
    {
      h.a local2 = null;
      if (this.f == null) {
        this.f = Collections.emptyMap();
      }
      h.b local1;
      if (this.e != null)
      {
        local1 = new h.b()
        {
          private void a(d paramAnonymousd)
          {
            if (paramAnonymousd.a == 200)
            {
              c.a.a(c.a.this).a();
              return;
            }
            c.a.a(c.a.this).b();
          }
        };
        local2 = new h.a()
        {
          public final void a(Throwable paramAnonymousThrowable)
          {
            c.a.a(c.a.this).b();
          }
        };
      }
      for (;;)
      {
        return new c(this.b, this.c, this.a, this.d, this.f, local1, local2, (byte)0);
        local1 = null;
      }
    }
    
    public final a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public final a c(String paramString)
    {
      this.c = paramString;
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */