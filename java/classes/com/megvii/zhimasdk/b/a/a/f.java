package com.megvii.zhimasdk.b.a.a;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class f
  implements com.megvii.zhimasdk.b.a.d.a<e>
{
  private final ConcurrentHashMap<String, d> a = new ConcurrentHashMap();
  
  public c a(String paramString, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Name");
    d locald = (d)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
    if (locald != null) {
      return locald.a(parame);
    }
    throw new IllegalStateException("Unsupported authentication scheme: " + paramString);
  }
  
  public e a(String paramString)
  {
    return new f.1(this, paramString);
  }
  
  public void a(String paramString, d paramd)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Name");
    com.megvii.zhimasdk.b.a.o.a.a(paramd, "Authentication scheme factory");
    this.a.put(paramString.toLowerCase(Locale.ENGLISH), paramd);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */