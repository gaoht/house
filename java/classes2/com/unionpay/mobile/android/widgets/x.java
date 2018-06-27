package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

final class x
  implements View.OnFocusChangeListener
{
  x(u paramu) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((u.b(this.a)) && (u.a(this.a) != null)) {
        u.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      if (u.d(this.a) != null) {
        u.d(this.a).a(paramBoolean);
      }
      if (u.e(this.a) != null) {
        u.e(this.a).a(paramBoolean);
      }
      paramView = this.a;
      u.g();
      this.a.invalidate();
      return;
      if ((u.b(this.a)) && (u.a(this.a) != null)) {
        u.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */