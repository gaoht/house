package com.mato.sdk.e.a;

import com.mato.sdk.b.g;
import com.mato.sdk.b.j;
import com.mato.sdk.d.e;
import com.mato.sdk.g.a.c;
import com.mato.sdk.proxy.q;

public final class a
{
  private static final String a = g.b("");
  private static a e = new a();
  private q b;
  private e c;
  private com.mato.sdk.g.a.b d;
  
  public static a a()
  {
    return e;
  }
  
  public static void a(String paramString)
  {
    b.a(paramString);
  }
  
  public final void a(e parame)
  {
    this.c = parame;
  }
  
  public final void a(q paramq)
  {
    this.b = paramq;
  }
  
  public final void b()
  {
    if ((this.c == null) || (this.b == null)) {}
    String[] arrayOfString;
    do
    {
      return;
      arrayOfString = this.c.b();
    } while (arrayOfString == null);
    c();
    long l = this.c.a() * 60000;
    this.d = com.mato.sdk.g.a.a.b().a(new a(this.b, l, arrayOfString));
  }
  
  public final void c()
  {
    if (this.d != null)
    {
      this.d.b();
      this.d = null;
    }
  }
  
  static final class a
    extends c
  {
    private final long a;
    private final String[] b;
    private final q c;
    
    public a(q paramq, long paramLong, String[] paramArrayOfString)
    {
      this.c = paramq;
      this.a = paramLong;
      this.b = paramArrayOfString;
    }
    
    protected final long a()
    {
      return this.a;
    }
    
    protected final void b()
    {
      try
      {
        this.c.a(this.b);
        return;
      }
      catch (j localj)
      {
        a.d().c();
      }
    }
    
    protected final long c()
    {
      return 0L;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */