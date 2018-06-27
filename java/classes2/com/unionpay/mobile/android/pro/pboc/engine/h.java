package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.j;

final class h
  implements Runnable
{
  h(b paramb) {}
  
  public final void run()
  {
    synchronized (this.a)
    {
      j.c("UPCardEngine", " cmcc_return : 2");
      Object localObject1 = b.d(this.a).b();
      if (b.a(this.a) != null)
      {
        localObject1 = b.a(this.a).obtainMessage(2, localObject1);
        b.a(this.a).sendMessage((Message)localObject1);
      }
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */