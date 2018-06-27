package com.g.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bh
  extends Handler
{
  bh(bf parambf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 5: 
          this.a.a();
          return;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        av.postSDKError(paramMessage);
        return;
      }
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof a)))
      {
        paramMessage = (a)paramMessage.obj;
        bf.a(this.a, paramMessage);
        continue;
        Message.obtain(bf.a(this.a), 5, paramMessage.obj).sendToTarget();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */