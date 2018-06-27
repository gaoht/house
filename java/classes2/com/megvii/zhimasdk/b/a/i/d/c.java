package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.m;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class c
  implements com.megvii.zhimasdk.b.a.f.a, m, Serializable, Cloneable
{
  private final String a;
  private Map<String, String> b;
  private String c;
  private String d;
  private String e;
  private Date f;
  private String g;
  private boolean h;
  private int i;
  
  public c(String paramString1, String paramString2)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString1, "Name");
    this.a = paramString1;
    this.b = new HashMap();
    this.c = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return (String)this.b.get(paramString);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(Date paramDate)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramDate, "Date");
    return (this.f != null) && (this.f.getTime() <= paramDate.getTime());
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(Date paramDate)
  {
    this.f = paramDate;
  }
  
  public boolean b(String paramString)
  {
    return this.b.get(paramString) != null;
  }
  
  public Date c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public Object clone()
  {
    c localc = (c)super.clone();
    localc.b = new HashMap(this.b);
    return localc;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void d(String paramString)
  {
    if (paramString != null)
    {
      this.e = paramString.toLowerCase(Locale.ENGLISH);
      return;
    }
    this.e = null;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public int[] f()
  {
    return null;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[version: ");
    localStringBuilder.append(Integer.toString(this.i));
    localStringBuilder.append("]");
    localStringBuilder.append("[name: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    localStringBuilder.append("[value: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    localStringBuilder.append("[domain: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    localStringBuilder.append("[path: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    localStringBuilder.append("[expiry: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */