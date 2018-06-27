package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;

final class ag
  implements TextWatcher
{
  private boolean b = true;
  private int c;
  private boolean d = false;
  
  ag(af paramaf) {}
  
  private String a(CharSequence paramCharSequence, int paramInt)
  {
    int k = 0;
    int m = paramCharSequence.length();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < m)
    {
      char c1 = paramCharSequence.charAt(i);
      int j = k;
      if (c1 != ' ')
      {
        k += 1;
        j = k;
        if (i != 0)
        {
          j = k;
          if ((k & 0x3) == 1)
          {
            localStringBuffer.append(' ');
            j = k;
          }
        }
      }
      if (i == paramInt) {
        this.c = localStringBuffer.length();
      }
      if (c1 != ' ') {
        localStringBuffer.append(c1);
      }
      i += 1;
      k = j;
    }
    if (paramInt == m) {
      this.c = localStringBuffer.length();
    }
    return localStringBuffer.toString();
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 1) && (paramInt3 == 0) && (paramCharSequence.charAt(paramInt1) == ' ')) {
      this.d = true;
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.b) {
      return;
    }
    Object localObject;
    if (this.d)
    {
      CharSequence localCharSequence = paramCharSequence.subSequence(0, paramInt1 - 1);
      localObject = localCharSequence;
      if (paramInt1 < paramCharSequence.length()) {
        localObject = localCharSequence.toString() + paramCharSequence.subSequence(paramInt1, paramCharSequence.length());
      }
      paramInt1 -= 1;
      this.d = false;
    }
    for (;;)
    {
      this.b = false;
      paramCharSequence = a((CharSequence)localObject, paramInt1 + paramInt3);
      this.a.b.c(paramCharSequence);
      paramCharSequence = this.a.b;
      if (this.c <= 23) {}
      for (paramInt1 = this.c;; paramInt1 = 23)
      {
        paramCharSequence.b(paramInt1);
        this.b = true;
        return;
      }
      localObject = paramCharSequence;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */