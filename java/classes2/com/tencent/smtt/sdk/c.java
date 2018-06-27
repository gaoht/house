package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class c
  extends Thread
{
  c(Context paramContext, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    bg localbg = bg.b();
    localbg.a(this.a, null);
    boolean bool = false;
    if (localbg.c()) {
      bool = localbg.d().a(this.a, this.b);
    }
    new Handler(Looper.getMainLooper()).post(new d(this, bool));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */