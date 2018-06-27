package com.pgyersdk.views;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.LinearLayout;
import java.util.Date;

class h
  extends Handler
{
  h(g paramg) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 20004: 
    default: 
      return;
    case 20003: 
      i = Integer.valueOf(paramMessage.obj.toString()).intValue();
      this.a.k.a(i % 3 + 1);
      return;
    case 20005: 
      i = Integer.valueOf(paramMessage.obj.toString()).intValue();
      g.a(this.a, new Date().getTime());
      Log.i("duration", (g.a(this.a) - g.b(this.a)) / 1000L + " " + (g.c(this.a) - 10000) / 1000);
      if ((g.a(this.a) - g.b(this.a)) / 1000L >= (g.c(this.a) - 10000) / 1000)
      {
        this.a.n.a(-1, (int)(g.c(this.a) - (g.a(this.a) - g.b(this.a))) / 1000);
        g.d(this.a).removeMessages(20005);
        g.d(this.a).sendEmptyMessageDelayed(20006, 1000L);
        return;
      }
      this.a.n.a(i, -1);
      g.e(this.a);
      return;
    }
    g.a(this.a, new Date().getTime());
    int i = (int)(g.c(this.a) - (g.a(this.a) - g.b(this.a))) / 1000;
    if (i <= 0)
    {
      g.f(this.a);
      g.g(this.a).setVisibility(8);
      g.h(this.a).setVisibility(0);
      g.a(this.a, g.g(this.a));
    }
    for (;;)
    {
      this.a.n.a(-1, i);
      return;
      g.d(this.a).sendEmptyMessageDelayed(20006, 1000L);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */