package com.megvii.zhimasdk.b.a.a;

import com.megvii.zhimasdk.b.a.n;
import java.util.Locale;

public class g
{
  public static final String a = null;
  public static final String b = null;
  public static final String c = null;
  public static final g d = new g(a, -1, b, c);
  private final String e;
  private final String f;
  private final String g;
  private final int h;
  
  public g(n paramn, String paramString1, String paramString2)
  {
    this(paramn.a(), paramn.b(), paramString1, paramString2);
  }
  
  public g(String paramString, int paramInt)
  {
    this(paramString, paramInt, b, c);
  }
  
  public g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      paramString1 = a;
      this.g = paramString1;
      int i = paramInt;
      if (paramInt < 0) {
        i = -1;
      }
      this.h = i;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = b;
      }
      this.f = paramString1;
      if (paramString3 != null) {
        break label74;
      }
    }
    label74:
    for (paramString1 = c;; paramString1 = paramString3.toUpperCase(Locale.ENGLISH))
    {
      this.e = paramString1;
      return;
      paramString1 = paramString1.toLowerCase(Locale.ENGLISH);
      break;
    }
  }
  
  public int a(g paramg)
  {
    int j = 0;
    int i;
    if (com.megvii.zhimasdk.b.a.o.g.a(this.e, paramg.e))
    {
      i = 1;
      if (!com.megvii.zhimasdk.b.a.o.g.a(this.f, paramg.f)) {
        break label98;
      }
      j = i + 2;
      label36:
      if (this.h != paramg.h) {
        break label124;
      }
      i = j + 4;
      label51:
      if (!com.megvii.zhimasdk.b.a.o.g.a(this.g, paramg.g)) {
        break label146;
      }
      j = i + 8;
    }
    label98:
    label124:
    label146:
    do
    {
      do
      {
        return j;
        i = j;
        if (this.e == c) {
          break;
        }
        i = j;
        if (paramg.e == c) {
          break;
        }
        return -1;
        j = i;
        if (this.f == b) {
          break label36;
        }
        j = i;
        if (paramg.f == b) {
          break label36;
        }
        return -1;
        i = j;
        if (this.h == -1) {
          break label51;
        }
        i = j;
        if (paramg.h == -1) {
          break label51;
        }
        return -1;
        j = i;
      } while (this.g == a);
      j = i;
    } while (paramg.g == a);
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      if (!(paramObject instanceof g)) {
        return super.equals(paramObject);
      }
      paramObject = (g)paramObject;
      if ((!com.megvii.zhimasdk.b.a.o.g.a(this.g, ((g)paramObject).g)) || (this.h != ((g)paramObject).h) || (!com.megvii.zhimasdk.b.a.o.g.a(this.f, ((g)paramObject).f))) {
        break;
      }
      bool1 = bool2;
    } while (com.megvii.zhimasdk.b.a.o.g.a(this.e, ((g)paramObject).e));
    return false;
  }
  
  public int hashCode()
  {
    return com.megvii.zhimasdk.b.a.o.g.a(com.megvii.zhimasdk.b.a.o.g.a(com.megvii.zhimasdk.b.a.o.g.a(com.megvii.zhimasdk.b.a.o.g.a(17, this.g), this.h), this.f), this.e);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.e != null)
    {
      localStringBuilder.append(this.e.toUpperCase(Locale.ENGLISH));
      localStringBuilder.append(' ');
    }
    if (this.f != null)
    {
      localStringBuilder.append('\'');
      localStringBuilder.append(this.f);
      localStringBuilder.append('\'');
    }
    for (;;)
    {
      if (this.g != null)
      {
        localStringBuilder.append('@');
        localStringBuilder.append(this.g);
        if (this.h >= 0)
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.h);
        }
      }
      return localStringBuilder.toString();
      localStringBuilder.append("<any realm>");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */