package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class e
  extends Handler
{
  e(Looper paramLooper, QbSdk.PreInitCallback paramPreInitCallback, Context paramContext, ah paramah)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        this.a.onViewInitFinished(false);
        return;
        paramMessage = bg.b().d();
        if (paramMessage != null) {
          paramMessage.a(this.b);
        }
      } while (this.a == null);
      this.a.onViewInitFinished(true);
      return;
      this.c.a("init_all", (byte)2);
      this.c.a(7, "tbs://preinit");
    } while (this.a == null);
    this.a.onCoreInitFinished();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */