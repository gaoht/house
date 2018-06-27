package com.umeng.analytics.pro;

import android.content.Context;

public final class ar
  implements au
{
  private static ar c;
  private au a;
  private Context b;
  
  private ar(Context paramContext)
  {
    this.b = paramContext;
    this.a = new aq(this.b);
  }
  
  public static ar b(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new ar(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public aq a(Context paramContext)
  {
    try
    {
      paramContext = (aq)this.a;
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a()
  {
    bz.b(new cb()
    {
      public void a()
      {
        ar.a(ar.this).a();
      }
    });
  }
  
  public void a(au paramau)
  {
    this.a = paramau;
  }
  
  public void a(final Object paramObject)
  {
    bz.b(new cb()
    {
      public void a()
      {
        ar.a(ar.this).a(paramObject);
      }
    });
  }
  
  public void b()
  {
    bz.c(new cb()
    {
      public void a()
      {
        ar.a(ar.this).b();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */