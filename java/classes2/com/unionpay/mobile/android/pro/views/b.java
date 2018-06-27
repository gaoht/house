package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.upviews.a.a;
import org.json.JSONException;
import org.json.JSONObject;

final class b
  implements Handler.Callback
{
  b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a.a(this.a).removeMessages(2006);
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null) {
        if (paramMessage.getBoolean("success"))
        {
          paramMessage = com.unionpay.mobile.android.hce.a.a(paramMessage.getString("result"), a.b(this.a).f());
          try
          {
            paramMessage = new JSONObject(paramMessage);
            a locala = this.a;
            if (!a.d(paramMessage))
            {
              a.b(this.a, a.d(this.a).ap);
              return false;
            }
          }
          catch (JSONException paramMessage)
          {
            a.a(this.a, a.c(this.a).ap);
            paramMessage.printStackTrace();
            return false;
          }
          a.a(this.a, a.e(this.a).a().b, a.f(this.a));
        }
        else
        {
          a.c(this.a, a.g(this.a).ap);
          continue;
          a.d(this.a, a.h(this.a).ap);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */