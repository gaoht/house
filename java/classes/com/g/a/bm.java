package com.g.a;

import java.net.URLEncoder;
import org.json.JSONObject;

public class bm
  extends br
{
  static bm a;
  
  public static bm a()
  {
    try
    {
      if (a == null) {
        a = new bm();
      }
      bm localbm = a;
      return localbm;
    }
    finally {}
  }
  
  public void setAccount(JSONObject paramJSONObject)
  {
    a("account", paramJSONObject);
  }
  
  public void setAntiCheatingstatus(int paramInt)
  {
    a("antiCheating", Integer.valueOf(paramInt));
  }
  
  public void setCurrentPageName(String paramString)
  {
    a("page", paramString);
  }
  
  public void setDeepLink(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      a("deeplink", paramString);
      i.setDeepLink(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public void setPageStartTime(long paramLong)
  {
    a("pageStartTime", Long.valueOf(paramLong));
  }
  
  public void setPushInfo(String paramString)
  {
    a("push", paramString);
  }
  
  public void setSessionId(String paramString)
  {
    a("sessionId", paramString);
  }
  
  public void setSessionStartTime(long paramLong)
  {
    a("sessionStartTime", Long.valueOf(paramLong));
  }
  
  public void setSubaccount(JSONObject paramJSONObject)
  {
    a("subaccount", paramJSONObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */