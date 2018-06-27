package com.g.a;

import android.os.Message;
import java.util.HashMap;

class cp
  implements Runnable
{
  cp(db paramdb, String paramString1, String paramString2, a parama) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        as.a();
        db.a locala = new db.a();
        locala.a.put("apiType", Integer.valueOf(1));
        HashMap localHashMap = locala.a;
        if (this.a != null)
        {
          String str1 = this.a;
          localHashMap.put("appId", str1);
          localHashMap = locala.a;
          if (this.b != null)
          {
            str1 = this.b;
            localHashMap.put("channelId", str1);
            locala.a.put("service", this.c);
            locala.a.put("action", "init");
            Message.obtain(db.c(), 101, locala).sendToTarget();
            at.a();
            return;
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */