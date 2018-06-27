package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.c;
import com.xiaomi.xmpush.thrift.o;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class av
{
  private static String a = com.xiaomi.channel.commonutils.string.d.a(5) + "-";
  private static AtomicLong b = new AtomicLong(0L);
  
  public static String a()
  {
    return a + b.incrementAndGet();
  }
  
  public static ArrayList<ae> a(ArrayList<b> paramArrayList, String paramString1, String paramString2)
  {
    if (paramArrayList == null)
    {
      b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
      return null;
    }
    if (paramArrayList.size() == 0)
    {
      b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new c();
    int j = 0;
    int i = 0;
    if (j < paramArrayList.size())
    {
      b localb = (b)paramArrayList.get(j);
      int k = i;
      Object localObject2 = localObject1;
      if (localb != null)
      {
        if (localb.c != null) {
          break label111;
        }
        localObject2 = localObject1;
        k = i;
      }
      for (;;)
      {
        j += 1;
        i = k;
        localObject1 = localObject2;
        break;
        label111:
        int m = aq.a(localb.c).length;
        if (m > 30720)
        {
          b.d("TinyData is too big, ignore upload request." + localb.toString());
          k = i;
          localObject2 = localObject1;
        }
        else
        {
          k = i;
          localObject2 = localObject1;
          if (i + m > 30720)
          {
            localObject2 = new ae(a(), false);
            ((ae)localObject2).d(paramString1);
            ((ae)localObject2).b(paramString2);
            ((ae)localObject2).c(o.B.N);
            ((ae)localObject2).a(com.xiaomi.channel.commonutils.file.a.a(aq.a((org.apache.thrift.a)localObject1)));
            localArrayList.add(localObject2);
            localObject2 = new c();
            k = 0;
          }
          ((c)localObject2).a(localb.c);
          k += m;
        }
      }
    }
    if (((c)localObject1).a() != 0)
    {
      paramArrayList = new ae(a(), false);
      paramArrayList.d(paramString1);
      paramArrayList.b(paramString2);
      paramArrayList.c(o.B.N);
      paramArrayList.a(com.xiaomi.channel.commonutils.file.a.a(aq.a((org.apache.thrift.a)localObject1)));
      localArrayList.add(paramArrayList);
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (paramString1 == null)
    {
      b.a("Value of parameter category can not be null.");
      return true;
    }
    if (paramString2 == null)
    {
      b.a("Value of parameter Name can not be null");
      return true;
    }
    if (!com.xiaomi.channel.commonutils.string.d.d(paramString1))
    {
      b.a("Value of parameter catetory invalid, can only contain ascii char.");
      return true;
    }
    if (!com.xiaomi.channel.commonutils.string.d.d(paramString2))
    {
      b.a("Value of parameter name invalid, can only contain ascii char.");
      return true;
    }
    if ((paramString3 != null) && (paramString3.length() > 10240))
    {
      b.a("Parameter data is too large(" + paramString3.length() + "), max size for data is " + 10240);
      return true;
    }
    return false;
  }
  
  public static class a
    implements aw.b
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void a(ArrayList<av.b> paramArrayList) {}
    
    public boolean a(av.b paramb)
    {
      return com.xiaomi.channel.commonutils.network.d.d(this.a);
    }
  }
  
  public static class b
  {
    public String a;
    public int b;
    public com.xiaomi.xmpush.thrift.d c = new com.xiaomi.xmpush.thrift.d();
    
    public String toString()
    {
      return "TinyDataRequest:{id:" + this.a + ", uploadHint:" + this.b + ", channel:" + this.c.a + ", category:" + this.c.g + ", name:" + this.c.c + ", counter: " + this.c.d + ", data: " + this.c.b + ", fromSDK:" + this.c.f + ",  }";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */