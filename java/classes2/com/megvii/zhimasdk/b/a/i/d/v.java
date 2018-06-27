package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.h;
import com.megvii.zhimasdk.b.a.f.i;
import com.megvii.zhimasdk.b.a.f.j;
import java.util.Collection;

public class v
  implements i, j
{
  private final String[] a;
  
  public v()
  {
    this(null);
  }
  
  public v(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public h a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    if (parame != null)
    {
      parame = (Collection)parame.a("http.protocol.cookie-datepatterns");
      if (parame == null) {
        break label56;
      }
    }
    label56:
    for (parame = (String[])parame.toArray(new String[parame.size()]);; parame = null)
    {
      return new u(parame);
      return new u();
    }
  }
  
  public h a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    return new u(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */