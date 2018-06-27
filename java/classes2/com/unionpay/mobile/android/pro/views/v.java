package com.unionpay.mobile.android.pro.views;

import android.os.Handler.Callback;
import android.os.Message;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;

final class v
  implements Handler.Callback
{
  v(u paramu) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null)
      {
        paramMessage = (a)paramMessage.obj;
        if (paramMessage != null) {
          u.a(this.a, paramMessage);
        }
      }
      else
      {
        u.a(this.a, u.a(this.a).ap);
        continue;
        if ("1003100020".equalsIgnoreCase((String)paramMessage.obj))
        {
          if (b.bl) {
            u.b(this.a);
          }
        }
        else if (b.bl) {
          u.a(this.a, u.c(this.a).ap, "fail");
        } else {
          u.b(this.a, u.d(this.a).ap);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */