package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class cn
  implements Runnable
{
  cn(db paramdb, String paramString, a parama) {}
  
  public void run()
  {
    try
    {
      bm.a().setDeepLink(this.a);
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(8));
      locala.a.put("service", this.b);
      locala.a.put("domain", "app");
      locala.a.put("action", "deeplink");
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("link", this.a);
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */