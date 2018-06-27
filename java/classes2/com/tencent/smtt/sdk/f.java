package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

final class f
  extends Thread
{
  f(Context paramContext, ah paramah, Handler paramHandler) {}
  
  public void run()
  {
    if (ai.a().a(true, this.a) == 0) {
      ai.a().b(this.a, true);
    }
    k.a(true).a(this.a, false, false, null);
    bg localbg = bg.b();
    localbg.a(this.a, this.b);
    boolean bool = localbg.c();
    this.c.sendEmptyMessage(3);
    if (!bool)
    {
      this.c.sendEmptyMessage(2);
      return;
    }
    this.c.sendEmptyMessage(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */