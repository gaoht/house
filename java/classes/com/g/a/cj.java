package com.g.a;

import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

class cj
  implements Runnable
{
  cj(db paramdb, a parama, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, com.tendcloud.appcpa.a parama1) {}
  
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("orderId", this.g.getString("keyOrderId"));
      localJSONObject.put("amount", this.g.getInt("keyTotalPrice"));
      localJSONObject.put("currencyType", this.g.getString("keyCurrencyType"));
      if (this.g.has("keyOrderDetail"))
      {
        JSONArray localJSONArray = this.g.getJSONArray("keyOrderDetail");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          localJSONObject.put("items", localJSONArray);
        }
      }
      localTreeMap.put("order", localJSONObject);
      locala.a.put("data", localTreeMap);
      Message.obtain(db.c(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */