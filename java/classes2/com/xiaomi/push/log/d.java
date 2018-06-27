package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.h.b;
import java.util.concurrent.ConcurrentLinkedQueue;

class d
  extends h.b
{
  h.b a;
  
  d(b paramb) {}
  
  public void b()
  {
    b.b localb = (b.b)b.b(this.b).peek();
    if ((localb != null) && (localb.d()))
    {
      this.a = ((h.b)b.b(this.b).remove());
      this.a.b();
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/log/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */