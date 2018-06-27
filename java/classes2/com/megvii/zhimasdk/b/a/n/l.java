package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import com.megvii.zhimasdk.b.a.v;
import java.net.InetAddress;

public class l
  implements r
{
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    Object localObject = f.b(parame);
    ac localac = paramq.h().b();
    if ((paramq.h().a().equalsIgnoreCase("CONNECT")) && (localac.c(v.b))) {
      break label56;
    }
    label56:
    while (paramq.a("Host")) {
      return;
    }
    parame = ((f)localObject).o();
    if (parame == null)
    {
      localObject = ((f)localObject).l();
      if (!(localObject instanceof o)) {
        break label180;
      }
      InetAddress localInetAddress = ((o)localObject).f();
      int i = ((o)localObject).g();
      if (localInetAddress == null) {
        break label180;
      }
      parame = new n(localInetAddress.getHostName(), i);
    }
    label180:
    for (;;)
    {
      localObject = parame;
      if (parame == null)
      {
        if (localac.c(v.b)) {
          break;
        }
        throw new ab("Target host missing");
        localObject = parame;
      }
      paramq.a("Host", ((n)localObject).e());
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */