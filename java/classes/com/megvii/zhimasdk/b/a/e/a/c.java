package com.megvii.zhimasdk.b.a.e.a;

import com.megvii.zhimasdk.b.a.o.a;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class c
  implements b
{
  private final ConcurrentHashMap<com.megvii.zhimasdk.b.a.e.b.b, Integer> a = new ConcurrentHashMap();
  private volatile int b;
  
  public c()
  {
    this(2);
  }
  
  public c(int paramInt)
  {
    a(paramInt);
  }
  
  public int a(com.megvii.zhimasdk.b.a.e.b.b paramb)
  {
    a.a(paramb, "HTTP route");
    paramb = (Integer)this.a.get(paramb);
    if (paramb != null) {
      return paramb.intValue();
    }
    return this.b;
  }
  
  public void a(int paramInt)
  {
    a.a(paramInt, "Defautl max per route");
    this.b = paramInt;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */