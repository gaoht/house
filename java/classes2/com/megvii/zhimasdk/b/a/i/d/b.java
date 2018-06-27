package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.h;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class b
  implements h
{
  private final Map<String, c> a = new HashMap(10);
  
  protected c a(String paramString)
  {
    return (c)this.a.get(paramString);
  }
  
  public void a(String paramString, c paramc)
  {
    a.a(paramString, "Attribute name");
    a.a(paramc, "Attribute handler");
    this.a.put(paramString, paramc);
  }
  
  protected Collection<c> c()
  {
    return this.a.values();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */