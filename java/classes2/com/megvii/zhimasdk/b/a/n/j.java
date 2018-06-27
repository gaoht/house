package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import com.megvii.zhimasdk.b.a.v;

public class j
  implements r
{
  private final boolean a;
  
  public j()
  {
    this(false);
  }
  
  public j(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    if ((paramq instanceof l))
    {
      if (!this.a) {
        break label74;
      }
      paramq.d("Transfer-Encoding");
      paramq.d("Content-Length");
    }
    k localk;
    label74:
    do
    {
      parame = paramq.h().b();
      localk = ((l)paramq).c();
      if (localk != null) {
        break;
      }
      paramq.a("Content-Length", "0");
      return;
      if (paramq.a("Transfer-Encoding")) {
        throw new ab("Transfer-encoding header already present");
      }
    } while (!paramq.a("Content-Length"));
    throw new ab("Content-Length header already present");
    if ((localk.e()) || (localk.b() < 0L))
    {
      if (parame.c(v.b)) {
        throw new ab("Chunked transfer encoding not allowed for " + parame);
      }
      paramq.a("Transfer-Encoding", "chunked");
    }
    for (;;)
    {
      if ((localk.h() != null) && (!paramq.a("Content-Type"))) {
        paramq.a(localk.h());
      }
      if ((localk.g() == null) || (paramq.a("Content-Encoding"))) {
        break;
      }
      paramq.a(localk.g());
      return;
      paramq.a("Content-Length", Long.toString(localk.b()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */