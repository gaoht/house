package com.g.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class cg
  extends Handler
{
  cg(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bi.b();
    bf.b();
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof db.a))) {
      paramMessage = (db.a)paramMessage.obj;
    }
    try
    {
      ad.a().post(paramMessage);
      return;
    }
    catch (Throwable paramMessage) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */