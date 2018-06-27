package com.megvii.zhimasdk.b.a.e.c;

import com.megvii.zhimasdk.b.a.o.a;
import java.util.Locale;

@Deprecated
public final class e
{
  private final String a;
  private final j b;
  private final int c;
  private final boolean d;
  private String e;
  
  public e(String paramString, int paramInt, j paramj)
  {
    a.a(paramString, "Scheme name");
    if ((paramInt > 0) && (paramInt <= 65535)) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Port is invalid");
      a.a(paramj, "Socket factory");
      this.a = paramString.toLowerCase(Locale.ENGLISH);
      this.c = paramInt;
      if (!(paramj instanceof f)) {
        break;
      }
      this.d = true;
      this.b = paramj;
      return;
    }
    if ((paramj instanceof b))
    {
      this.d = true;
      this.b = new h((b)paramj);
      return;
    }
    this.d = false;
    this.b = paramj;
  }
  
  @Deprecated
  public e(String paramString, l paraml, int paramInt)
  {
    a.a(paramString, "Scheme name");
    a.a(paraml, "Socket factory");
    boolean bool;
    if ((paramInt > 0) && (paramInt <= 65535))
    {
      bool = true;
      a.a(bool, "Port is invalid");
      this.a = paramString.toLowerCase(Locale.ENGLISH);
      if (!(paraml instanceof c)) {
        break label88;
      }
      this.b = new g((c)paraml);
    }
    for (this.d = true;; this.d = false)
    {
      this.c = paramInt;
      return;
      bool = false;
      break;
      label88:
      this.b = new k(paraml);
    }
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.c;
    }
    return i;
  }
  
  public final j b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.a;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        break;
      }
      paramObject = (e)paramObject;
    } while ((this.a.equals(((e)paramObject).a)) && (this.c == ((e)paramObject).c) && (this.d == ((e)paramObject).d));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return com.megvii.zhimasdk.b.a.o.g.a(com.megvii.zhimasdk.b.a.o.g.a(com.megvii.zhimasdk.b.a.o.g.a(17, this.c), this.a), this.d);
  }
  
  public final String toString()
  {
    if (this.e == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.c));
      this.e = localStringBuilder.toString();
    }
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */