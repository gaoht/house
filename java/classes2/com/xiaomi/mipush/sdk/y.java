package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.o;
import java.util.HashMap;

final class y
  implements Runnable
{
  y(Context paramContext, boolean paramBoolean) {}
  
  public void run()
  {
    com.xiaomi.channel.commonutils.logger.b.a("do sync info");
    ae localae = new ae(MiPushClient.generatePacketID(), false);
    Object localObject = a.a(this.a);
    localae.c(o.v.N);
    localae.b(((a)localObject).c());
    localae.d(this.a.getPackageName());
    localae.h = new HashMap();
    h.a(localae.h, "app_version", com.xiaomi.channel.commonutils.android.b.a(this.a, this.a.getPackageName()));
    h.a(localae.h, "app_version_code", Integer.toString(com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName())));
    h.a(localae.h, "push_sdk_vn", "3_2_3");
    h.a(localae.h, "push_sdk_vc", Integer.toString(30203));
    h.a(localae.h, "token", ((a)localObject).d());
    h.a(localae.h, "imei_md5", d.a(e.c(this.a)));
    h.a(localae.h, "reg_id", ((a)localObject).e());
    h.a(localae.h, "reg_secret", ((a)localObject).f());
    localObject = MiPushClient.getAcceptTime(this.a).replace(",", "-");
    h.a(localae.h, "accept_time", (String)localObject);
    if (this.b)
    {
      h.a(localae.h, "aliases_md5", x.a(MiPushClient.getAllAlias(this.a)));
      h.a(localae.h, "topics_md5", x.a(MiPushClient.getAllTopic(this.a)));
      h.a(localae.h, "accounts_md5", x.a(MiPushClient.getAllUserAccount(this.a)));
    }
    for (;;)
    {
      u.a(this.a).a(localae, com.xiaomi.xmpush.thrift.a.i, false, null);
      return;
      h.a(localae.h, "aliases", x.b(MiPushClient.getAllAlias(this.a)));
      h.a(localae.h, "topics", x.b(MiPushClient.getAllTopic(this.a)));
      h.a(localae.h, "user_accounts", x.b(MiPushClient.getAllUserAccount(this.a)));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */