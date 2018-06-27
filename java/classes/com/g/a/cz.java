package com.g.a;

import android.os.Message;
import java.util.HashMap;

final class cz
  implements Runnable
{
  cz(a parama) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(10));
      locala.a.put("occurTime", Long.valueOf(System.currentTimeMillis()));
      locala.a.put("service", this.a);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */