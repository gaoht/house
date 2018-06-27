package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.av.b;
import com.xiaomi.push.service.aw.b;
import com.xiaomi.xmpush.thrift.ae;
import java.util.ArrayList;
import java.util.Iterator;

public class ab
  implements aw.b
{
  private Context a;
  
  public ab(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(ArrayList<av.b> paramArrayList)
  {
    if (paramArrayList == null) {
      b.d("[MiTinyDataClient]:requests is null, MiTinyDataClient upload by long connection failed.");
    }
    for (;;)
    {
      return;
      Object localObject = a.a(this.a).c();
      paramArrayList = av.a(paramArrayList, this.a.getPackageName(), (String)localObject);
      if (paramArrayList == null) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (ae)paramArrayList.next();
        ((ae)localObject).a("uploadWay", "longMiTinyClient");
        u.a(this.a).a((org.apache.thrift.a)localObject, com.xiaomi.xmpush.thrift.a.i, true, null);
      }
    }
    b.d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in MiPushClient.");
  }
  
  public boolean a(av.b paramb)
  {
    return d.d(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */