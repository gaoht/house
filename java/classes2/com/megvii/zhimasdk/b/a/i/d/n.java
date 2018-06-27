package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.h;
import com.megvii.zhimasdk.b.a.f.i;
import com.megvii.zhimasdk.b.a.f.j;
import java.util.Collection;

public class n
  implements i, j
{
  private final String[] a;
  private final a b;
  
  public n()
  {
    this(null, a.a);
  }
  
  public n(String[] paramArrayOfString, a parama)
  {
    this.a = paramArrayOfString;
    this.b = parama;
  }
  
  public h a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    if (parame != null)
    {
      parame = (Collection)parame.a("http.protocol.cookie-datepatterns");
      if (parame == null) {
        break label65;
      }
    }
    label65:
    for (parame = (String[])parame.toArray(new String[parame.size()]);; parame = null)
    {
      return new m(parame, this.b);
      return new m(null, this.b);
    }
  }
  
  public h a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    return new m(this.a);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */