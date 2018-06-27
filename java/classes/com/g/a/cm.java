package com.g.a;

import android.os.Message;
import com.tendcloud.appcpa.b;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class cm
  implements Runnable
{
  cm(db paramdb, a parama, b paramb) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(8));
      locala.a.put("service", this.a);
      locala.a.put("domain", "iap");
      locala.a.put("action", "viewItems");
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("items", this.b);
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */