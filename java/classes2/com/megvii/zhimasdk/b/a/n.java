package com.megvii.zhimasdk.b.a;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;

public final class n
  implements Serializable, Cloneable
{
  protected final String a;
  protected final String b;
  protected final int c;
  protected final String d;
  protected final InetAddress e;
  
  public n(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public n(String paramString1, int paramInt, String paramString2)
  {
    this.a = ((String)a.b(paramString1, "Host name"));
    this.b = paramString1.toLowerCase(Locale.ENGLISH);
    if (paramString2 != null) {}
    for (this.d = paramString2.toLowerCase(Locale.ENGLISH);; this.d = "http")
    {
      this.c = paramInt;
      this.e = null;
      return;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("://");
    localStringBuilder.append(this.a);
    if (this.c != -1)
    {
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.c));
    }
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    if (this.c != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.a.length() + 6);
      localStringBuilder.append(this.a);
      localStringBuilder.append(":");
      localStringBuilder.append(Integer.toString(this.c));
      return localStringBuilder.toString();
    }
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof n)) {
        break;
      }
      paramObject = (n)paramObject;
    } while ((this.b.equals(((n)paramObject).b)) && (this.c == ((n)paramObject).c) && (this.d.equals(((n)paramObject).d)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return g.a(g.a(g.a(17, this.b), this.c), this.d);
  }
  
  public String toString()
  {
    return d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */