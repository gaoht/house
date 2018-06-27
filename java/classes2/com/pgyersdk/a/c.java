package com.pgyersdk.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.pgyersdk.g.f;
import com.pgyersdk.i.e;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

final class c
  extends f
{
  HttpURLConnection a = null;
  HashMap b = new HashMap();
  
  c(Context paramContext) {}
  
  protected HashMap a(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("agKey", com.pgyersdk.b.a.l);
        localHashMap.put("deviceId", com.pgyersdk.b.a.i);
        localHashMap.put("osType", "2");
        localHashMap.put("deviceName", com.pgyersdk.b.a.g);
        localHashMap.put("osVersion", com.pgyersdk.b.a.e);
        localHashMap.put("sdkVersion", com.pgyersdk.b.a.k);
        localHashMap.put("_api_key", "305092bc73c180b55c26012a94809131");
        localHashMap.put("versionCode", com.pgyersdk.b.a.b);
        localHashMap.put("version", com.pgyersdk.b.a.d);
        localHashMap.put("deviceModel", com.pgyersdk.b.a.f);
        localHashMap.put("resolution", com.pgyersdk.b.a.j);
        if (!com.pgyersdk.b.a.a()) {
          continue;
        }
        paramVarArgs = "1";
        localHashMap.put("jailBroken", paramVarArgs);
        paramVarArgs = com.pgyersdk.e.a.a();
        localHashMap.put("freeSpace", paramVarArgs[1] + " / " + paramVarArgs[0]);
        if (com.pgyersdk.e.a.c())
        {
          paramVarArgs = com.pgyersdk.e.a.b();
          localHashMap.put("freeSdc", paramVarArgs[1] + " / " + paramVarArgs[0]);
        }
        Object localObject = com.pgyersdk.e.a.b(this.c);
        paramVarArgs = "";
        if (localObject.length == 2) {
          paramVarArgs = localObject[1] + " / " + localObject[0];
        }
        localHashMap.put("freeRam", paramVarArgs);
        localHashMap.put("battery", com.pgyersdk.e.a.g(this.c));
        localHashMap.put("protrait", this.c.getResources().getConfiguration().orientation + "");
        paramVarArgs = "";
        localObject = com.pgyersdk.e.a.a(this.c);
        if (((Map)localObject).containsKey("network_type")) {
          paramVarArgs = (String)((Map)localObject).get("network_type");
        }
        localHashMap.put("network", paramVarArgs);
        this.a = new e("http://www.pgyer.com/apiv1/sdkstat/launch").a("POST").a(localHashMap, this.c, null, null).a();
        this.a.connect();
        this.b.put("status", String.valueOf(this.a.getResponseCode()));
        this.b.put("response", a(this.a));
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        if (this.a == null) {
          continue;
        }
        this.a.disconnect();
        continue;
      }
      finally
      {
        if (this.a == null) {
          continue;
        }
        this.a.disconnect();
      }
      return this.b;
      paramVarArgs = "2";
    }
  }
  
  protected void a(HashMap paramHashMap)
  {
    super.onPostExecute(paramHashMap);
    com.pgyersdk.e.a.f(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */