package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.v;

public class g
  extends a
  implements q
{
  private final String c;
  private final String d;
  private ae e;
  
  public g(ae paramae)
  {
    this.e = ((ae)com.megvii.zhimasdk.b.a.o.a.a(paramae, "Request line"));
    this.c = paramae.a();
    this.d = paramae.c();
  }
  
  public g(String paramString1, String paramString2, ac paramac)
  {
    this(new m(paramString1, paramString2, paramac));
  }
  
  public ac d()
  {
    return h().b();
  }
  
  public ae h()
  {
    if (this.e == null) {
      this.e = new m(this.c, this.d, v.c);
    }
    return this.e;
  }
  
  public String toString()
  {
    return this.c + ' ' + this.d + ' ' + this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */