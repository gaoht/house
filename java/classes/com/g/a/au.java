package com.g.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class au
  extends Handler
{
  au(at paramat, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      at.a(this.a);
      return;
    case 2: 
      at.b(this.a);
      return;
    case 1: 
      at.c(this.a);
      return;
    }
    at.a(this.a);
    at.c(this.a);
    this.a.a(2, 600000L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */