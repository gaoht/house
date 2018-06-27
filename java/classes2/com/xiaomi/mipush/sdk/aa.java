package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.misc.f.a;
import com.xiaomi.push.service.k;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.o;
import java.util.HashMap;
import java.util.Map;

public class aa
  extends f.a
{
  private Context a;
  
  public aa(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public int a()
  {
    return 13;
  }
  
  public void run()
  {
    ae localae = new ae(MiPushClient.generatePacketID(), false);
    Object localObject = a.a(this.a);
    localae.c(o.A.N);
    localae.b(((a)localObject).c());
    localae.d(this.a.getPackageName());
    localObject = new HashMap();
    h.a((Map)localObject, "miid", k.a(this.a).c());
    localae.h = ((Map)localObject);
    u.a(this.a).a(localae, com.xiaomi.xmpush.thrift.a.i, true, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */