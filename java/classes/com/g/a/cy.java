package com.g.a;

import android.os.Message;
import java.util.HashMap;

final class cy
  implements Runnable
{
  cy(a parama) {}
  
  public void run()
  {
    db.a locala = new db.a();
    locala.a.put("apiType", Integer.valueOf(1));
    locala.a.put("action", "sendInit");
    locala.a.put("service", this.a);
    Message.obtain(db.c(), 102, locala).sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */