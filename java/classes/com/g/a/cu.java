package com.g.a;

import android.os.Message;
import java.util.HashMap;

class cu
  implements Runnable
{
  cu(db paramdb, a parama) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(9));
      locala.a.put("domain", "account");
      locala.a.put("action", "logout");
      locala.a.put("service", this.a);
      locala.a.put("accountId", "");
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */