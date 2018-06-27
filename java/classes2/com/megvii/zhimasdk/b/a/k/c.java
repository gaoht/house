package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import com.megvii.zhimasdk.b.a.y;

public class c
  implements f, Cloneable
{
  private final String a;
  private final String b;
  private final y[] c;
  
  public c(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public c(String paramString1, String paramString2, y[] paramArrayOfy)
  {
    this.a = ((String)a.a(paramString1, "Name"));
    this.b = paramString2;
    if (paramArrayOfy != null)
    {
      this.c = paramArrayOfy;
      return;
    }
    this.c = new y[0];
  }
  
  public y a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public y a(String paramString)
  {
    a.a(paramString, "Name");
    y[] arrayOfy = this.c;
    int j = arrayOfy.length;
    int i = 0;
    while (i < j)
    {
      y localy = arrayOfy[i];
      if (localy.a().equalsIgnoreCase(paramString)) {
        return localy;
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public y[] c()
  {
    return (y[])this.c.clone();
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int d()
  {
    return this.c.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        break;
      }
      paramObject = (c)paramObject;
    } while ((this.a.equals(((c)paramObject).a)) && (g.a(this.b, ((c)paramObject).b)) && (g.a(this.c, ((c)paramObject).c)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    int j = g.a(g.a(17, this.a), this.b);
    y[] arrayOfy = this.c;
    int k = arrayOfy.length;
    int i = 0;
    while (i < k)
    {
      j = g.a(j, arrayOfy[i]);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    if (this.b != null)
    {
      localStringBuilder.append("=");
      localStringBuilder.append(this.b);
    }
    y[] arrayOfy = this.c;
    int j = arrayOfy.length;
    int i = 0;
    while (i < j)
    {
      y localy = arrayOfy[i];
      localStringBuilder.append("; ");
      localStringBuilder.append(localy);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */