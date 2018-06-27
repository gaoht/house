package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class i
  extends Handler
{
  i(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    h.b localb = (h.b)paramMessage.obj;
    if (paramMessage.what == 0) {
      localb.a();
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 1) {
        localb.c();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */