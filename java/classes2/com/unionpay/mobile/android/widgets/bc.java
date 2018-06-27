package com.unionpay.mobile.android.widgets;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import com.unionpay.mobile.android.global.a;

final class bc
  implements PopupWindow.OnDismissListener
{
  bc(bb parambb) {}
  
  public final void onDismiss()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)bb.a(this.a).getLayoutParams();
    localMarginLayoutParams.bottomMargin = a.b;
    localMarginLayoutParams.height = bb.b(this.a);
    bb.a(this.a).setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */