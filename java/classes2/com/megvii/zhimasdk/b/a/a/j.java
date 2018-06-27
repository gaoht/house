package com.megvii.zhimasdk.b.a.a;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.io.Serializable;
import java.security.Principal;

public final class j
  implements Serializable, Principal
{
  private final String a;
  
  public j(String paramString)
  {
    a.a(paramString, "User name");
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof j)) {
        break;
      }
      paramObject = (j)paramObject;
    } while (g.a(this.a, ((j)paramObject).a));
    return false;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return g.a(17, this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */