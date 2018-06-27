package com.unionpay.mobile.android.pro.views;

import android.os.Handler;
import com.unionpay.mobile.android.model.b;
import java.util.HashMap;

final class g
  implements Runnable
{
  g(a parama, String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    Object localObject1 = this.c;
    Object localObject2 = this.a;
    Object localObject3 = a.w(this.c).p;
    localObject1 = ((a)localObject1).a((String)localObject2, this.b);
    localObject2 = a.x(this.c);
    localObject3 = a.x(this.c);
    if (localObject1 != null) {}
    for (;;)
    {
      ((Handler)localObject2).sendMessage(((Handler)localObject3).obtainMessage(0, localObject1));
      return;
      localObject1 = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */