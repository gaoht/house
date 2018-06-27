package com.pgyersdk.views;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class m
  extends TimerTask
{
  int a = 0;
  
  m(g paramg) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 20003;
    localMessage.obj = Integer.valueOf(this.a);
    g.d(this.b).sendMessage(localMessage);
    this.a += 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */