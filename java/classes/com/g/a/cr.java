package com.g.a;

import android.os.Message;
import java.util.HashMap;

class cr
  implements Runnable
{
  cr(db paramdb, String paramString, a parama) {}
  
  public void run()
  {
    db.a locala = new db.a();
    locala.a.put("apiType", Integer.valueOf(9));
    locala.a.put("domain", "account");
    locala.a.put("action", "roleCreate");
    locala.a.put("parameter", this.a);
    locala.a.put("service", this.b);
    Message.obtain(db.c(), 102, locala).sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */