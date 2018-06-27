package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class cl
  implements Runnable
{
  cl(db paramdb, a parama, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(8));
      locala.a.put("service", this.a);
      locala.a.put("domain", "iap");
      locala.a.put("action", "viewItem");
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("id", this.b);
      localTreeMap.put("category", this.c);
      localTreeMap.put("name", this.d);
      localTreeMap.put("unitPrice", Integer.valueOf(this.e));
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */