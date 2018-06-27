package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.unionpay.mobile.android.utils.j;

final class aw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aw(UPWidget paramUPWidget) {}
  
  public final void onGlobalLayout()
  {
    j.a("uppay", "onGlobalLayout() +++");
    int i = UPWidget.a(this.a).getRootView().getHeight() - UPWidget.a(this.a).getHeight();
    if ((i <= UPWidget.m()) && (i <= UPWidget.m())) {
      this.a.l();
    }
    j.a("uppay", "onGlobalLayout() ---");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */