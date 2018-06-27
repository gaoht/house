package com.megvii.zhimasdk.b.a.a;

import com.megvii.zhimasdk.b.a.o.g;
import java.io.Serializable;
import java.security.Principal;

public class p
  implements m, Serializable
{
  private final q a;
  private final String b;
  private final String c;
  
  public Principal a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a.b();
  }
  
  public String d()
  {
    return this.a.a();
  }
  
  public String e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof p)) {
        break;
      }
      paramObject = (p)paramObject;
    } while ((g.a(this.a, ((p)paramObject).a)) && (g.a(this.c, ((p)paramObject).c)));
    return false;
  }
  
  public int hashCode()
  {
    return g.a(g.a(17, this.a), this.c);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][workstation: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */