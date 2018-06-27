package com.megvii.zhimasdk.b.a.f;

import com.megvii.zhimasdk.b.a.o.a;
import java.util.Locale;

public final class e
{
  private final String a;
  private final int b;
  private final String c;
  private final boolean d;
  
  public e(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    a.b(paramString1, "Host");
    a.b(paramInt, "Port");
    a.a(paramString2, "Path");
    this.a = paramString1.toLowerCase(Locale.ENGLISH);
    this.b = paramInt;
    if (paramString2.trim().length() != 0) {}
    for (this.c = paramString2;; this.c = "/")
    {
      this.d = paramBoolean;
      return;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (this.d) {
      localStringBuilder.append("(secure)");
    }
    localStringBuilder.append(this.a);
    localStringBuilder.append(':');
    localStringBuilder.append(Integer.toString(this.b));
    localStringBuilder.append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */