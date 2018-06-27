package com.baidu.platform.comapi.search;

import android.os.Handler;
import android.os.Message;

class e
  extends Handler
{
  e(d paramd) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (d.a(this.a) == 0L) {}
    while ((d.a(this.a) != ((Long)paramMessage.obj).longValue()) || (d.b(this.a) == null)) {
      return;
    }
    d.b(this.a).a(paramMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/search/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */