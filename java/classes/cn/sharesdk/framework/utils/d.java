package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

public abstract class d
  implements Handler.Callback
{
  protected final Handler a = MobHandlerThread.newHandler(this);
  
  public void a()
  {
    a(0, 0, null);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = -1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    this.a.sendMessage(localMessage);
  }
  
  protected void a(Message paramMessage) {}
  
  protected abstract void b(Message paramMessage);
  
  protected void c(Message paramMessage) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      b(paramMessage);
    }
    for (;;)
    {
      return false;
      a(paramMessage);
      continue;
      c(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */