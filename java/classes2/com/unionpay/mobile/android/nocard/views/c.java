package com.unionpay.mobile.android.nocard.views;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;

final class c
  implements ViewTreeObserver.OnPreDrawListener
{
  c(b paramb) {}
  
  public final boolean onPreDraw()
  {
    b.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    b.a(this.a, b.a(this.a).getMeasuredHeight());
    b.b(this.a, b.a(this.a).getTop());
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */