package com.megvii.zhimasdk.b.a.a;

import com.megvii.zhimasdk.b.a.o.g;
import java.io.Serializable;
import java.security.Principal;

public class q
  implements Serializable, Principal
{
  private final String a;
  private final String b;
  private final String c;
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        break;
      }
      paramObject = (q)paramObject;
    } while ((g.a(this.a, ((q)paramObject).a)) && (g.a(this.b, ((q)paramObject).b)));
    return false;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    return g.a(g.a(17, this.a), this.b);
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */