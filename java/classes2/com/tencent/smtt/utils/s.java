package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class s
  extends Handler
{
  s(r paramr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        Object[] arrayOfObject1;
        localException.printStackTrace();
        continue;
        Object[] arrayOfObject2 = (Object[])paramMessage.obj;
        r.a(this.a, (Context)arrayOfObject2[0]);
        continue;
        arrayOfObject2 = (Object[])paramMessage.obj;
        r.a(this.a, (Context)arrayOfObject2[0], (String)arrayOfObject2[1]);
        continue;
      }
      super.handleMessage(paramMessage);
      return;
      arrayOfObject1 = (Object[])paramMessage.obj;
      r.b((Context)arrayOfObject1[0], (String)arrayOfObject1[1]);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */