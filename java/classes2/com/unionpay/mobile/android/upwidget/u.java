package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class u
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  u(UPScrollView paramUPScrollView) {}
  
  public final void onGlobalLayout()
  {
    UPScrollView.a(this.a).sendMessageDelayed(UPScrollView.a(this.a).obtainMessage(), 5L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */