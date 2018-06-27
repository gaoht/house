package com.mato.sdk.b;

import com.mato.sdk.g.a.a;
import com.mato.sdk.g.a.b;
import com.mato.sdk.g.a.c;
import java.util.HashMap;
import java.util.Map;

public final class l<T>
{
  private static final String a = g.b("");
  private final Map<String, b<T>> b = new HashMap();
  private a<T> c;
  
  private void a(String paramString, int paramInt)
  {
    b localb = (b)this.b.get(paramString);
    if (localb != null)
    {
      if (paramInt >= localb.c) {
        break label48;
      }
      if (this.c != null) {
        this.c.a(localb.a, paramString);
      }
    }
    label48:
    do
    {
      return;
      c(paramString);
    } while (this.c == null);
    this.c.a(paramString);
  }
  
  private boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  private void c(String paramString)
  {
    paramString = (b)this.b.remove(paramString);
    if (paramString != null) {
      paramString.b.b();
    }
  }
  
  public final void a(a<T> parama)
  {
    this.c = parama;
  }
  
  public final void a(String paramString)
  {
    c(paramString);
  }
  
  public final void a(String paramString, T paramT, int paramInt1, int paramInt2)
  {
    if (!this.b.containsKey(paramString))
    {
      Object localObject = new c(paramString, 120000);
      localObject = a.b().a((c)localObject);
      this.b.put(paramString, new b(paramT, (b)localObject, 6));
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(T paramT, String paramString);
    
    public abstract void a(String paramString);
  }
  
  static final class b<T>
  {
    public final T a;
    public final b b;
    public final int c;
    
    public b(T paramT, b paramb, int paramInt)
    {
      this.b = paramb;
      this.a = paramT;
      this.c = paramInt;
    }
  }
  
  final class c
    extends c
  {
    private final String a;
    private final int b;
    private int c;
    
    public c(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = 0;
    }
    
    protected final long a()
    {
      return this.b;
    }
    
    protected final void b()
    {
      l locall = l.this;
      String str = this.a;
      int i = this.c + 1;
      this.c = i;
      l.a(locall, str, i);
    }
    
    protected final long c()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */