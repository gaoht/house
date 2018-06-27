package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.u;

public final class i
  implements g
{
  private final r[] a;
  private final u[] b;
  
  public i(r[] paramArrayOfr, u[] paramArrayOfu)
  {
    int i;
    if (paramArrayOfr != null)
    {
      i = paramArrayOfr.length;
      this.a = new r[i];
      System.arraycopy(paramArrayOfr, 0, this.a, 0, i);
    }
    while (paramArrayOfu != null)
    {
      i = paramArrayOfu.length;
      this.b = new u[i];
      System.arraycopy(paramArrayOfu, 0, this.b, 0, i);
      return;
      this.a = new r[0];
    }
    this.b = new u[0];
  }
  
  public void a(q paramq, e parame)
  {
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      arrayOfr[i].a(paramq, parame);
      i += 1;
    }
  }
  
  public void a(s params, e parame)
  {
    u[] arrayOfu = this.b;
    int j = arrayOfu.length;
    int i = 0;
    while (i < j)
    {
      arrayOfu[i].a(params, parame);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */