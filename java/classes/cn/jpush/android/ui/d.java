package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.data.c;

final class d
  extends Handler
{
  d(PushActivity paramPushActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    c localc = (c)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.setRequestedOrientation(1);
      PushActivity.a(this.a, localc);
      return;
    }
    this.a.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */