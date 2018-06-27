package com.mato.sdk.b;

import com.mato.sdk.g.a.c;
import com.mato.sdk.proxy.g;

public final class d
  extends c
{
  private static final short b = 10;
  private final g a;
  private int c = 0;
  
  public d(g paramg)
  {
    this.a = paramg;
  }
  
  protected final long a()
  {
    return 10000L;
  }
  
  protected final void b()
  {
    this.c += 10;
    this.a.b("app_exist_time", this.c);
  }
  
  protected final long c()
  {
    return 10000L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */