package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.f.a;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.y;

public class o
  extends f.a
{
  private Context a;
  
  public o(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void run()
  {
    Object localObject = ah.a(this.a);
    y localy = new y();
    localy.a(ai.a((ah)localObject, f.a));
    localy.b(ai.a((ah)localObject, f.b));
    localObject = new ae("-1", false);
    ((ae)localObject).c(com.xiaomi.xmpush.thrift.o.p.N);
    ((ae)localObject).a(aq.a(localy));
    u.a(this.a).a((org.apache.thrift.a)localObject, com.xiaomi.xmpush.thrift.a.i, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */