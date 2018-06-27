package com.unionpay.mobile.android.pro.views;

import android.os.Handler;
import com.unionpay.mobile.android.model.b;
import java.util.HashMap;

final class r
  implements Runnable
{
  r(k paramk, String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    Object localObject1 = this.c;
    Object localObject2 = this.a;
    Object localObject3 = k.x(this.c).p;
    localObject1 = ((k)localObject1).a((String)localObject2, this.b);
    localObject2 = k.y(this.c);
    localObject3 = k.y(this.c);
    if (localObject1 != null) {}
    for (;;)
    {
      ((Handler)localObject2).sendMessage(((Handler)localObject3).obtainMessage(0, localObject1));
      return;
      localObject1 = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */