package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.ae;
import java.util.HashMap;
import java.util.Map;

final class m
  implements Runnable
{
  public void run()
  {
    if (e.c(MiPushClient.access$000()) != null)
    {
      ae localae = new ae();
      localae.b(a.a(MiPushClient.access$000()).c());
      localae.c("client_info_update");
      localae.a(MiPushClient.generatePacketID());
      localae.a(new HashMap());
      localae.i().put("imei_md5", d.a(e.c(MiPushClient.access$000())));
      int i = e.b();
      if (i >= 0) {
        localae.i().put("space_id", Integer.toString(i));
      }
      u.a(MiPushClient.access$000()).a(localae, com.xiaomi.xmpush.thrift.a.i, false, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */