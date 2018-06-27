package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;

class ck
  implements Runnable
{
  ck(db paramdb, a parama, String paramString, com.tendcloud.appcpa.a parama1) {}
  
  public void run()
  {
    try
    {
      db.a locala = new db.a();
      locala.a.put("apiType", Integer.valueOf(8));
      locala.a.put("service", this.a);
      locala.a.put("domain", "iap");
      locala.a.put("action", "placeOrder");
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("accountId", this.b);
      localTreeMap.put("orderId", this.c.getString("keyOrderId"));
      localTreeMap.put("amount", Integer.valueOf(this.c.getInt("keyTotalPrice")));
      localTreeMap.put("currencyType", this.c.getString("keyCurrencyType"));
      if (this.c.has("keyOrderDetail"))
      {
        JSONArray localJSONArray = this.c.getJSONArray("keyOrderDetail");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          localTreeMap.put("items", localJSONArray);
        }
      }
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */