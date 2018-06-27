package com.g.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

final class ax
  extends Handler
{
  ax(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = (a)paramMessage.obj;
      if (i.d(paramMessage).equals("1"))
      {
        db.c().removeMessages(103);
        db.a locala = new db.a();
        locala.a.put("apiType", Integer.valueOf(11));
        locala.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        locala.a.put("sessionEnd", Integer.valueOf(1));
        locala.a.put("service", paramMessage);
        Message.obtain(db.c(), 102, locala).sendToTarget();
        i.b("2", paramMessage);
      }
      return;
    }
    catch (Exception paramMessage)
    {
      av.postSDKError(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */