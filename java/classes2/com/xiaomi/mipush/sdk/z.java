package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.k.a;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.o;
import java.util.HashMap;
import java.util.Map;

public class z
  implements k.a
{
  public z(Context paramContext)
  {
    k.a(paramContext).a(this);
  }
  
  private void b(String paramString, Context paramContext)
  {
    ae localae = new ae();
    localae.c(o.i.N);
    localae.b(a.a(paramContext).c());
    localae.a(MiPushClient.generatePacketID());
    HashMap localHashMap = new HashMap();
    h.a(localHashMap, "miid", paramString);
    localae.a(localHashMap);
    int i = com.xiaomi.channel.commonutils.android.e.b();
    if (i >= 0) {
      localae.i().put("space_id", Integer.toString(i));
    }
    u.a(paramContext).a(localae, com.xiaomi.xmpush.thrift.a.i, true, null);
  }
  
  public void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    long l1 = localSharedPreferences.getLong("last_sync_miid_time", -1L);
    long l2 = System.currentTimeMillis() / 1000L;
    int i = ah.a(paramContext).a(com.xiaomi.xmpush.thrift.e.I.a(), 21600);
    if (l1 == -1L) {
      localSharedPreferences.edit().putLong("last_sync_miid_time", l2).commit();
    }
    while (Math.abs(l2 - l1) <= i) {
      return;
    }
    f.a(paramContext).a(new aa(paramContext), i);
    localSharedPreferences.edit().putLong("last_sync_miid_time", l2).commit();
  }
  
  public void a(String paramString, Context paramContext)
  {
    b(paramString, paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */