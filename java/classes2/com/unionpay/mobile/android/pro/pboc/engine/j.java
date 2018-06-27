package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.d;
import java.util.ArrayList;

final class j
  implements Runnable
{
  j(b paramb) {}
  
  public final void run()
  {
    synchronized (this.a)
    {
      com.unionpay.mobile.android.utils.j.c("UPCardEngine", " se_return : 8");
      if (com.unionpay.mobile.android.model.b.bl) {
        if (b.a(this.a) != null)
        {
          localObject1 = b.a(this.a).obtainMessage(8, new ArrayList());
          b.a(this.a).sendMessage((Message)localObject1);
        }
      }
      do
      {
        do
        {
          return;
        } while (b.f(this.a) == null);
        localObject1 = b.f(this.a).b();
      } while ((b.a(this.a, "com.unionpay.tsmservice")) || (b.a(this.a) == null));
      Object localObject1 = b.a(this.a).obtainMessage(8, localObject1);
      b.a(this.a).sendMessage((Message)localObject1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */