package com.megvii.zhimasdk.b.a.f;

import com.megvii.zhimasdk.b.a.l.e;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class k
  implements com.megvii.zhimasdk.b.a.d.a<j>
{
  private final ConcurrentHashMap<String, i> a = new ConcurrentHashMap();
  
  public h a(String paramString, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Name");
    i locali = (i)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
    if (locali != null) {
      return locali.a(parame);
    }
    throw new IllegalStateException("Unsupported cookie spec: " + paramString);
  }
  
  public j a(String paramString)
  {
    return new k.1(this, paramString);
  }
  
  public void a(String paramString, i parami)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Name");
    com.megvii.zhimasdk.b.a.o.a.a(parami, "Cookie spec factory");
    this.a.put(paramString.toLowerCase(Locale.ENGLISH), parami);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */