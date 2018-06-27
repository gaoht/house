package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import java.util.Collection;
import java.util.Iterator;

public class f
  implements r
{
  private final Collection<? extends com.megvii.zhimasdk.b.a.e> a;
  
  public f()
  {
    this(null);
  }
  
  public f(Collection<? extends com.megvii.zhimasdk.b.a.e> paramCollection)
  {
    this.a = paramCollection;
  }
  
  public void a(q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    a.a(paramq, "HTTP request");
    if (paramq.h().a().equalsIgnoreCase("CONNECT")) {}
    for (;;)
    {
      return;
      Collection localCollection = (Collection)paramq.g().a("http.default-headers");
      parame = localCollection;
      if (localCollection == null) {
        parame = this.a;
      }
      if (parame != null)
      {
        parame = parame.iterator();
        while (parame.hasNext()) {
          paramq.a((com.megvii.zhimasdk.b.a.e)parame.next());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */