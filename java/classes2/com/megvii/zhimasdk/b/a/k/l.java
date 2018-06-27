package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import com.megvii.zhimasdk.b.a.y;
import java.io.Serializable;

public class l
  implements y, Serializable, Cloneable
{
  private final String a;
  private final String b;
  
  public l(String paramString1, String paramString2)
  {
    this.a = ((String)a.a(paramString1, "Name"));
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof y)) {
        break;
      }
      paramObject = (l)paramObject;
    } while ((this.a.equals(((l)paramObject).a)) && (g.a(this.b, ((l)paramObject).b)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return g.a(g.a(17, this.a), this.b);
  }
  
  public String toString()
  {
    if (this.b == null) {
      return this.a;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.a.length() + 1 + this.b.length());
    localStringBuilder.append(this.a);
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */