package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

final class ac
  implements TextWatcher
{
  ac(aa paramaa) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.a.a(paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.b.hasFocus()) && (TextUtils.isEmpty(this.a.b.b()))) {
      this.a.a(this.a.c, this.a.v() + this.a.d());
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (aa.a(this.a) != null) {
      aa.a(this.a).a(this.a.b, paramCharSequence.toString());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */