package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;

final class e
  implements Runnable
{
  e(String paramString1, String paramString2, Context paramContext) {}
  
  public final void run()
  {
    new c(new d(1, this.a, this.b.getBytes()), this.c).a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */