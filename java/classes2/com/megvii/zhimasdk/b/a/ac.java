package com.megvii.zhimasdk.b.a;

import com.megvii.zhimasdk.b.a.o.a;
import java.io.Serializable;

public class ac
  implements Serializable, Cloneable
{
  protected final String d;
  protected final int e;
  protected final int f;
  
  public ac(String paramString, int paramInt1, int paramInt2)
  {
    this.d = ((String)a.a(paramString, "Protocol name"));
    this.e = a.b(paramInt1, "Protocol minor version");
    this.f = a.b(paramInt2, "Protocol minor version");
  }
  
  public ac a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.e) && (paramInt2 == this.f)) {
      return this;
    }
    return new ac(this.d, paramInt1, paramInt2);
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public boolean a(ac paramac)
  {
    return (paramac != null) && (this.d.equals(paramac.d));
  }
  
  public final int b()
  {
    return this.e;
  }
  
  public int b(ac paramac)
  {
    a.a(paramac, "Protocol version");
    a.a(this.d.equals(paramac.d), "Versions for different protocols cannot be compared: %s %s", new Object[] { this, paramac });
    int j = b() - paramac.b();
    int i = j;
    if (j == 0) {
      i = c() - paramac.c();
    }
    return i;
  }
  
  public final int c()
  {
    return this.f;
  }
  
  public final boolean c(ac paramac)
  {
    return (a(paramac)) && (b(paramac) <= 0);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ac)) {
        return false;
      }
      paramObject = (ac)paramObject;
    } while ((this.d.equals(((ac)paramObject).d)) && (this.e == ((ac)paramObject).e) && (this.f == ((ac)paramObject).f));
    return false;
  }
  
  public final int hashCode()
  {
    return this.d.hashCode() ^ this.e * 100000 ^ this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('/');
    localStringBuilder.append(Integer.toString(this.e));
    localStringBuilder.append('.');
    localStringBuilder.append(Integer.toString(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */