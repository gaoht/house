package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.a.c;
import com.megvii.zhimasdk.b.a.a.h;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.b.e.a;
import com.megvii.zhimasdk.b.a.b.q;
import com.megvii.zhimasdk.b.a.j;
import com.megvii.zhimasdk.b.a.n.e;
import java.security.Principal;
import javax.net.ssl.SSLSession;

public class p
  implements q
{
  public static final p a = new p();
  
  private static Principal a(h paramh)
  {
    c localc = paramh.c();
    if ((localc != null) && (localc.d()) && (localc.c()))
    {
      paramh = paramh.d();
      if (paramh != null) {
        return paramh.a();
      }
    }
    return null;
  }
  
  public Object a(e parame)
  {
    a locala = a.a(parame);
    parame = null;
    Object localObject = locala.i();
    if (localObject != null)
    {
      localObject = a((h)localObject);
      parame = (e)localObject;
      if (localObject == null) {
        parame = a(locala.j());
      }
    }
    if (parame == null)
    {
      localObject = locala.l();
      if ((((j)localObject).c()) && ((localObject instanceof com.megvii.zhimasdk.b.a.e.p)))
      {
        localObject = ((com.megvii.zhimasdk.b.a.e.p)localObject).m();
        if (localObject != null) {
          return ((SSLSession)localObject).getLocalPrincipal();
        }
      }
    }
    return parame;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */