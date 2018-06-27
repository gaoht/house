package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.aa;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.Serializable;

public class p
  implements com.megvii.zhimasdk.b.a.d, Serializable, Cloneable
{
  private final String a;
  private final com.megvii.zhimasdk.b.a.o.d b;
  private final int c;
  
  public p(com.megvii.zhimasdk.b.a.o.d paramd)
  {
    a.a(paramd, "Char array buffer");
    int i = paramd.c(58);
    if (i == -1) {
      throw new aa("Invalid header: " + paramd.toString());
    }
    String str = paramd.b(0, i);
    if (str.length() == 0) {
      throw new aa("Invalid header: " + paramd.toString());
    }
    this.b = paramd;
    this.a = str;
    this.c = (i + 1);
  }
  
  public com.megvii.zhimasdk.b.a.o.d a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
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
    return this.b.b(this.c, this.b.c());
  }
  
  public com.megvii.zhimasdk.b.a.f[] e()
  {
    u localu = new u(0, this.b.c());
    localu.a(this.c);
    return f.b.a(this.b, localu);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */