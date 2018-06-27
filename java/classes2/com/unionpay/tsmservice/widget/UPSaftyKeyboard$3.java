package com.unionpay.tsmservice.widget;

import android.widget.PopupWindow.OnDismissListener;

final class UPSaftyKeyboard$3
  implements PopupWindow.OnDismissListener
{
  UPSaftyKeyboard$3(UPSaftyKeyboard paramUPSaftyKeyboard) {}
  
  public final void onDismiss()
  {
    if (UPSaftyKeyboard.b(this.a) != null) {
      UPSaftyKeyboard.b(this.a).onHide();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/widget/UPSaftyKeyboard$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */