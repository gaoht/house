package com.mato.sdk.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class d
  extends Handler
{
  private final a.1 a;
  
  public d(Looper paramLooper, a.1 param1)
  {
    super(paramLooper);
    this.a = param1;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      a.1.a(this.a, (String)paramMessage.obj);
      return;
    case 101: 
      a.1.a(this.a, (b)paramMessage.obj);
      return;
    }
    a.1.b(this.a, (b)paramMessage.obj);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */