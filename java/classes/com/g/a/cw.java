package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class cw
  implements Runnable
{
  cw(db paramdb, a parama, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(8));
      locala.a.put("service", this.a);
      locala.a.put("domain", "iap");
      locala.a.put("action", "recharge");
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("accountId", this.b);
      localTreeMap.put("orderId", this.c);
      localTreeMap.put("amount", Integer.valueOf(this.d));
      localTreeMap.put("currencyType", this.e);
      localTreeMap.put("payType", this.f);
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */