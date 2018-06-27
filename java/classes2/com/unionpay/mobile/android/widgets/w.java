package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

final class w
  implements TextWatcher
{
  w(u paramu) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (u.a(this.a) == null) {
      return;
    }
    if ((u.b(this.a)) && (u.c(this.a).isFocused()))
    {
      u.a(this.a).setVisibility(0);
      return;
    }
    u.a(this.a).setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */