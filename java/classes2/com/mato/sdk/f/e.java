package com.mato.sdk.f;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class e<T>
{
  public final long a;
  private final int b = 1;
  private final String c;
  private final h.a d;
  private String e;
  private int f;
  
  public e(int paramInt, String paramString, h.a parama)
  {
    this.c = paramString;
    this.d = parama;
    this.a = System.currentTimeMillis();
  }
  
  private static Throwable b(Throwable paramThrowable)
  {
    return paramThrowable;
  }
  
  protected abstract h<T> a(d paramd);
  
  public Map<String, String> a()
  {
    return Collections.emptyMap();
  }
  
  protected abstract void a(T paramT);
  
  public final void a(String paramString, int paramInt)
  {
    this.e = paramString;
    this.f = paramInt;
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (this.d != null) {
      this.d.a(paramThrowable);
    }
  }
  
  public boolean a(e<?> parame)
  {
    if (parame == null) {
      return false;
    }
    return this.c.equalsIgnoreCase(parame.c);
  }
  
  public a b()
  {
    return null;
  }
  
  public g c()
  {
    return null;
  }
  
  public final int g()
  {
    return this.b;
  }
  
  public final String h()
  {
    return this.c;
  }
  
  public final boolean i()
  {
    return (!TextUtils.isEmpty(this.e)) && (this.f > 0);
  }
  
  public final String j()
  {
    return this.e;
  }
  
  public final int k()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */