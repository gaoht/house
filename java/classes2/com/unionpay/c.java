package com.unionpay;

import android.os.Handler;
import android.os.Message;

final class c
  extends Thread
{
  public final void run()
  {
    UPPayAssistEx.m().sendEmptyMessageDelayed(1001, 300L);
    Object localObject = new com.unionpay.a.c(UPPayAssistEx.n(), UPPayAssistEx.c());
    ((com.unionpay.a.c)localObject).a();
    localObject = ((com.unionpay.a.c)localObject).b();
    if (UPPayAssistEx.m() != null)
    {
      Message localMessage = UPPayAssistEx.m().obtainMessage();
      localMessage.what = 1002;
      localMessage.obj = localObject;
      UPPayAssistEx.m().removeMessages(1001);
      UPPayAssistEx.m().sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */