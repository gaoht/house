package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;

class cq
  implements Runnable
{
  cq(db paramdb, a parama, String paramString1, String paramString2, Map paramMap) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("service", this.a);
      locala.a.put("apiType", Integer.valueOf(2));
      locala.a.put("eventId", z.a(this.b));
      HashMap localHashMap = locala.a;
      if (this.c == null) {}
      for (Object localObject = null;; localObject = z.a(this.c))
      {
        localHashMap.put("eventLabel", localObject);
        locala.a.put("map", this.d);
        locala.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        Message.obtain(db.c(), 102, locala).sendToTarget();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */