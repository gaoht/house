package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.module.c;
import com.xiaomi.push.service.module.d;
import com.xiaomi.push.service.module.e;
import java.lang.reflect.Method;

final class l
  implements Runnable
{
  public void run()
  {
    c localc = d.a(MiPushClient.access$000()).a(e.a);
    if (localc != null) {}
    try
    {
      localc.a().loadClass("com.xiaomi.push.mpcd.MpcdPlugin").getMethod("main", new Class[] { Context.class }).invoke(null, new Object[] { MiPushClient.access$000() });
      return;
    }
    catch (Exception localException)
    {
      b.a("plugin load fail");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */