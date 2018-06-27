package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import com.unionpay.mobile.android.nocard.views.b;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.SEService.CallBack;

public final class k
  implements SEService.CallBack
{
  private static SEService b = null;
  private Context a;
  private b c;
  private Handler.Callback d = new l(this);
  private Handler e = new Handler(this.d);
  
  public k() {}
  
  public k(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.c = paramb;
    if (b == null) {
      try
      {
        b = new SEService(this.a, this);
        new m(this).start();
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        j.c("uppay", " service ERROR!!!");
        this.e.sendEmptyMessage(2);
        return;
      }
    }
    ((com.unionpay.mobile.android.nocard.views.l)this.c).u();
  }
  
  public static SEService a()
  {
    return b;
  }
  
  public final void serviceConnected(SEService paramSEService)
  {
    j.c("uppay", "se service connected");
    j.c("uppay", "mSEService:" + b);
    j.c("uppay", "mSEService.isConnected:" + b.isConnected());
    this.e.sendEmptyMessage(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */