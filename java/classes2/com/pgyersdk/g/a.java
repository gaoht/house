package com.pgyersdk.g;

import android.app.Activity;
import android.content.Context;
import com.pgyersdk.i.e;
import com.pgyersdk.i.i;
import com.pgyersdk.i.k;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends f
{
  protected static String d;
  protected String a = null;
  protected String b = null;
  protected com.pgyersdk.h.b c;
  private Context e = null;
  private long f = 0L;
  private Context g;
  
  public a(Activity paramActivity, String paramString1, String paramString2, com.pgyersdk.h.b paramb)
  {
    this.b = paramString2;
    this.a = paramString1;
    this.c = paramb;
    this.g = null;
    if (paramActivity != null) {
      this.g = paramActivity;
    }
    if (this.g != null)
    {
      this.e = this.g.getApplicationContext();
      com.pgyersdk.b.a.a(this.g);
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    com.pgyersdk.i.b.a(new h(paramActivity, paramString, new b(paramActivity, paramString)));
  }
  
  protected HashMap a(Void... paramVarArgs)
  {
    Object localObject2 = null;
    HttpURLConnection localHttpURLConnection2 = null;
    localHashMap1 = new HashMap();
    localHttpURLConnection1 = localHttpURLConnection2;
    paramVarArgs = (Void[])localObject2;
    try
    {
      HashMap localHashMap2 = new HashMap();
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = (Void[])localObject2;
      localHashMap2.put("agKey", com.pgyersdk.b.a.l);
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = (Void[])localObject2;
      localHashMap2.put("versionNo", com.pgyersdk.b.a.b);
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = (Void[])localObject2;
      localHashMap2.put("buildNo", i.a(this.e, "buildNo"));
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = (Void[])localObject2;
      localHashMap2.put("_api_key", "305092bc73c180b55c26012a94809131");
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = (Void[])localObject2;
      localHttpURLConnection2 = new e("http://www.pgyer.com/apiv1/update/check").a("POST").a(localHashMap2, this.e, null, null).a();
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = localHttpURLConnection2;
      localHttpURLConnection2.connect();
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = localHttpURLConnection2;
      localHashMap1.put("status", String.valueOf(localHttpURLConnection2.getResponseCode()));
      localHttpURLConnection1 = localHttpURLConnection2;
      paramVarArgs = localHttpURLConnection2;
      localHashMap1.put("response", a(localHttpURLConnection2));
    }
    catch (Exception localException)
    {
      paramVarArgs = localHttpURLConnection1;
      localException.printStackTrace();
      return localHashMap1;
    }
    finally
    {
      if (paramVarArgs == null) {
        break label220;
      }
      paramVarArgs.disconnect();
    }
    return localHashMap1;
  }
  
  public void a()
  {
    this.e = null;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity != null) {}
    for (;;)
    {
      if (paramActivity != null)
      {
        this.e = paramActivity.getApplicationContext();
        com.pgyersdk.b.a.a(paramActivity);
      }
      return;
      paramActivity = null;
    }
  }
  
  protected void a(HashMap paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("response");
    if ((!k.a(paramHashMap)) && (paramHashMap.contains("releaseNote"))) {
      if (this.c != null) {
        this.c.onUpdateAvailable(paramHashMap);
      }
    }
    try
    {
      paramHashMap = new JSONObject(paramHashMap);
      if ("0".equals(paramHashMap.getString("code")))
      {
        paramHashMap = paramHashMap.getJSONObject("data");
        if (paramHashMap.has("lastBuild")) {
          d = paramHashMap.getString("lastBuild");
        }
      }
      if (k.a(i.a(this.g, "buildNo"))) {
        i.a(this.e, "buildNo", d);
      }
      return;
    }
    catch (JSONException paramHashMap)
    {
      do
      {
        for (;;)
        {
          paramHashMap.printStackTrace();
        }
      } while (this.c == null);
      this.c.onNoUpdateAvailable();
      return;
    }
    catch (Exception paramHashMap)
    {
      for (;;) {}
    }
  }
  
  protected void b()
  {
    this.a = null;
    this.b = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */