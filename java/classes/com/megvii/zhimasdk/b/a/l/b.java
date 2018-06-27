package com.megvii.zhimasdk.b.a.l;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class b
  extends a
  implements Serializable, Cloneable
{
  private final Map<String, Object> a = new ConcurrentHashMap();
  
  public e a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return this;
    }
    if (paramObject != null)
    {
      this.a.put(paramString, paramObject);
      return this;
    }
    this.a.remove(paramString);
    return this;
  }
  
  public Object a(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public void a(e parame)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      parame.a((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Object clone()
  {
    b localb = (b)super.clone();
    a(localb);
    return localb;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */