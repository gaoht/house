package com.ziroom.ziroomcustomer.e;

import android.os.Handler;
import android.os.Message;

public class i
{
  private Handler a = null;
  private Object b;
  
  public i(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private void a(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public static void sendMessage(Handler paramHandler, int paramInt, Object paramObject)
  {
    if (paramHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      paramHandler.sendMessage(localMessage);
    }
  }
  
  public Handler getHandler()
  {
    return this.a;
  }
  
  public Object getResult()
  {
    return this.b;
  }
  
  public void sendHandlerMessage(int paramInt, Object paramObject)
  {
    if (this.a != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      this.a.sendMessage(localMessage);
    }
    a(paramObject);
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.a = paramHandler;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */