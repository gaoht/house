package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f;

class e
  extends Handler
{
  e(d paramd) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!f.isServing) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        d.a(this.a, (Location)paramMessage.obj);
        return;
      }
    } while (d.a(this.a) == null);
    d.a(this.a).a((String)paramMessage.obj);
    return;
    d.a(this.a, "&og=1", (Location)paramMessage.obj);
    return;
    d.a(this.a, "&og=2", (Location)paramMessage.obj);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */