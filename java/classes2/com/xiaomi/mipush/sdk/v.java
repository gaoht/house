package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class v
  extends Handler
{
  v(u paramu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    label148:
    for (;;)
    {
      try
      {
        if (p.a(u.a(this.a)).e(str))
        {
          if (p.a(u.a(this.a)).c(str) >= 10) {
            break label148;
          }
          if ((1 == i) && ("disable_syncing".equals(p.a(u.a(this.a)).a())))
          {
            u.a(this.a, str, true);
            p.a(u.a(this.a)).b(str);
          }
        }
        else
        {
          return;
        }
        if ((i == 0) && ("enable_syncing".equals(p.a(u.a(this.a)).a())))
        {
          u.a(this.a, str, false);
          continue;
          p.a(u.a(this.a)).d(str);
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */