package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import java.util.ArrayList;
import java.util.Iterator;

class bj
  extends XMPushService.h
{
  bj(bi parambi, int paramInt, ArrayList paramArrayList)
  {
    super(paramInt);
  }
  
  public void a()
  {
    String str1 = this.c.a.getPackageName();
    String str2 = bi.a(this.c, str1);
    Object localObject1 = av.a(this.b, str1, str2);
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ae)((Iterator)localObject1).next();
        ((ae)localObject2).a("uploadWay", "longXMPushService");
        localObject2 = aq.a(aa.a(str1, str2, (org.apache.thrift.a)localObject2, com.xiaomi.xmpush.thrift.a.i));
        XMPushService.a(this.c.a, str1, (byte[])localObject2, true);
      }
    }
    b.d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in XMPushService.");
  }
  
  public String b()
  {
    return "Send tiny data.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */