package com.unionpay.sdk;

import android.content.Context;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

final class ai
  implements Runnable
{
  ai(String paramString1, String paramString2, Map paramMap, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("onEvent being called! eventId: ");
      ((StringBuffer)localObject).append(this.a);
      ((StringBuffer)localObject).append(", eventLabel: ");
      ((StringBuffer)localObject).append(this.b);
      ((StringBuffer)localObject).append(", eventMap: ");
      HashMap localHashMap;
      if (this.c == null)
      {
        str = "null";
        ((StringBuffer)localObject).append(str);
        k.a(((StringBuffer)localObject).toString());
        localObject = new ag.a();
        ((ag.a)localObject).a.put("context", this.d);
        ((ag.a)localObject).a.put("apiType", Integer.valueOf(4));
        ((ag.a)localObject).a.put("eventId", r.a(this.a));
        localHashMap = ((ag.a)localObject).a;
        if (this.b != null) {
          break label222;
        }
      }
      label222:
      for (String str = this.b;; str = r.a(this.b))
      {
        localHashMap.put("eventLabel", str);
        ((ag.a)localObject).a.put("map", this.c);
        ((ag.a)localObject).a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        Message.obtain(bk.a(), 102, localObject).sendToTarget();
        return;
        str = "mapSize: " + String.valueOf(this.c.size());
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (UPAgent.LOG_ON) {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */