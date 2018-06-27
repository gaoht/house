package com.megvii.zhimasdk.b.a.a;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.io.Serializable;
import java.security.Principal;

public class r
  implements m, Serializable
{
  private final j a;
  private final String b;
  
  public r(String paramString)
  {
    a.a(paramString, "Username:password string");
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      this.a = new j(paramString.substring(0, i));
      this.b = paramString.substring(i + 1);
      return;
    }
    this.a = new j(paramString);
    this.b = null;
  }
  
  public Principal a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof r)) {
        break;
      }
      paramObject = (r)paramObject;
    } while (g.a(this.a, ((r)paramObject).a));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */