package com.baidu.trace;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.trace.a.a;
import com.baidu.trace.a.f;
import com.baidu.trace.a.h;
import com.baidu.trace.a.i;
import com.baidu.trace.c.e;

public final class bc
{
  private static final bc b = new bc();
  private Handler a;
  
  protected static bc a()
  {
    return b;
  }
  
  protected static void a(h paramh)
  {
    e.d = e.a();
    aw.b(paramh.a);
  }
  
  protected static void b() {}
  
  protected final void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    Message localMessage = this.a.obtainMessage(32);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  protected final void a(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  protected final void a(a parama)
  {
    e.d = e.a();
    b.a = parama.a;
    if (this.a != null)
    {
      parama = this.a.obtainMessage(141);
      parama.arg1 = 141;
      parama.sendToTarget();
    }
  }
  
  protected final void a(com.baidu.trace.a.d paramd)
  {
    e.d = e.a();
    if (this.a != null)
    {
      if (1 == paramd.a) {
        this.a.obtainMessage(28).sendToTarget();
      }
    }
    else {
      return;
    }
    paramd = this.a.obtainMessage(30);
    paramd.arg1 = 1241;
    paramd.sendToTarget();
  }
  
  protected final void a(f paramf)
  {
    z.n = paramf.a;
    z.o = paramf.i;
    z.w = paramf.j;
    z.q = paramf.c;
    if ((Trace.a == 5) && (z.w > ar.c)) {
      ar.b = z.w * 1000;
    }
    if ((Trace.b == 30) && (z.q * 1000 >= ar.b)) {
      bd.i = z.q * 1000;
    }
    if (paramf.b >= 5) {
      z.p = paramf.b;
    }
    z.r = paramf.d;
    z.s = paramf.e;
    z.t = paramf.f;
    z.u = paramf.g;
    z.v = paramf.h;
    e.d = e.a();
    if (1 == z.n) {
      if (this.a != null) {
        this.a.obtainMessage(29).sendToTarget();
      }
    }
    while (this.a == null) {
      return;
    }
    paramf = this.a.obtainMessage(30);
    paramf.arg1 = 1241;
    paramf.sendToTarget();
  }
  
  protected final void a(i parami, long paramLong)
  {
    e.d = e.a();
    Object localObject = com.baidu.trace.c.d.a(parami.a);
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= ay.c.length) {
        break;
      }
      k = i;
      if (j >= localObject.length) {
        break;
      }
      ay.c[j] = localObject[j];
      i += 1;
      j += 1;
    }
    while (k < ay.c.length)
    {
      ay.c[k] = 0;
      k += 1;
    }
    ay.d = parami.c;
    ay.e = parami.d;
    ay.b = parami.b;
    ay.a = 1;
    if (ay.d == 1)
    {
      r.a(ay.e);
      ay.e = null;
    }
    if (this.a != null)
    {
      parami = this.a.obtainMessage(161);
      localObject = new Bundle();
      ((Bundle)localObject).putByteArray("ak", ay.c);
      ((Bundle)localObject).putInt("pushId", ay.b);
      ((Bundle)localObject).putLong("timeStamp", paramLong);
      ((Bundle)localObject).putByte("infoType", ay.d);
      ((Bundle)localObject).putString("infoContent", ay.e);
      parami.setData((Bundle)localObject);
      parami.sendToTarget();
    }
  }
  
  protected final boolean c()
  {
    if (this.a == null) {
      return false;
    }
    g.b();
    this.a.obtainMessage(31).sendToTarget();
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */