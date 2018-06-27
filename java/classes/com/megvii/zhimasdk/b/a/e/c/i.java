package com.megvii.zhimasdk.b.a.e.c;

import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class i
{
  private final ConcurrentHashMap<String, e> a = new ConcurrentHashMap();
  
  public final e a(e parame)
  {
    a.a(parame, "Scheme");
    return (e)this.a.put(parame.c(), parame);
  }
  
  public final e a(n paramn)
  {
    a.a(paramn, "Host");
    return a(paramn.c());
  }
  
  public final e a(String paramString)
  {
    e locale = b(paramString);
    if (locale == null) {
      throw new IllegalStateException("Scheme '" + paramString + "' not registered.");
    }
    return locale;
  }
  
  public final e b(String paramString)
  {
    a.a(paramString, "Scheme name");
    return (e)this.a.get(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */