package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ad;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.v;
import java.util.Locale;

public class h
  extends a
  implements s
{
  private af c;
  private ac d;
  private int e;
  private String f;
  private k g;
  private final ad h;
  private Locale i;
  
  public h(af paramaf, ad paramad, Locale paramLocale)
  {
    this.c = ((af)com.megvii.zhimasdk.b.a.o.a.a(paramaf, "Status line"));
    this.d = paramaf.a();
    this.e = paramaf.b();
    this.f = paramaf.c();
    this.h = paramad;
    this.i = paramLocale;
  }
  
  public af a()
  {
    Object localObject;
    int j;
    if (this.c == null)
    {
      if (this.d == null) {
        break label55;
      }
      localObject = this.d;
      j = this.e;
      if (this.f == null) {
        break label62;
      }
    }
    label55:
    label62:
    for (String str = this.f;; str = a(this.e))
    {
      this.c = new n((ac)localObject, j, str);
      return this.c;
      localObject = v.c;
      break;
    }
  }
  
  protected String a(int paramInt)
  {
    if (this.h != null)
    {
      ad localad = this.h;
      if (this.i != null) {}
      for (Locale localLocale = this.i;; localLocale = Locale.getDefault()) {
        return localad.a(paramInt, localLocale);
      }
    }
    return null;
  }
  
  public void a(k paramk)
  {
    this.g = paramk;
  }
  
  public k b()
  {
    return this.g;
  }
  
  public ac d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a);
    if (this.g != null)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(this.g);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */