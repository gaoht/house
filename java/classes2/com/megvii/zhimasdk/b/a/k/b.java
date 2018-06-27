package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.d;
import java.io.Serializable;

public class b
  implements e, Serializable, Cloneable
{
  private final String a;
  private final String b;
  
  public b(String paramString1, String paramString2)
  {
    this.a = ((String)a.a(paramString1, "Name"));
    this.b = paramString2;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String d()
  {
    return this.b;
  }
  
  public com.megvii.zhimasdk.b.a.f[] e()
  {
    if (this.b != null) {
      return f.a(this.b, null);
    }
    return new com.megvii.zhimasdk.b.a.f[0];
  }
  
  public String toString()
  {
    return i.b.a(null, this).toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */