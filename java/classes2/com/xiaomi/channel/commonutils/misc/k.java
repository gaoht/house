package com.xiaomi.channel.commonutils.misc;

import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.b;

public class k
{
  public static void a()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      throw new RuntimeException("can't do this on ui thread");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((Looper.getMainLooper().getThread() == Thread.currentThread()) && (paramBoolean)) {
      throw new RuntimeException("can't do this on ui thread when debug_switch:" + paramBoolean);
    }
    if ((Looper.getMainLooper().getThread() == Thread.currentThread()) && (!paramBoolean)) {
      b.a("can't do this on ui thread when debug_switch:" + paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */