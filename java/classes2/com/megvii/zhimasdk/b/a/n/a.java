package com.megvii.zhimasdk.b.a.n;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements e
{
  private final e a;
  private final Map<String, Object> b = new ConcurrentHashMap();
  
  public a()
  {
    this(null);
  }
  
  public a(e parame)
  {
    this.a = parame;
  }
  
  public Object a(String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Id");
    Object localObject2 = this.b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = this.a.a(paramString);
      }
    }
    return localObject1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Id");
    if (paramObject != null)
    {
      this.b.put(paramString, paramObject);
      return;
    }
    this.b.remove(paramString);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */