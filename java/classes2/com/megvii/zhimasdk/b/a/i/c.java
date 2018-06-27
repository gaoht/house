package com.megvii.zhimasdk.b.a.i;

import com.megvii.zhimasdk.b.a.ad;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.k.h;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.t;
import java.util.Locale;

public class c
  implements t
{
  public static final c a = new c();
  protected final ad b;
  
  public c()
  {
    this(d.a);
  }
  
  public c(ad paramad)
  {
    this.b = ((ad)a.a(paramad, "Reason phrase catalog"));
  }
  
  public s a(af paramaf, e parame)
  {
    a.a(paramaf, "Status line");
    return new h(paramaf, this.b, a(parame));
  }
  
  protected Locale a(e parame)
  {
    return Locale.getDefault();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */