package com.unionpay;

import org.json.JSONObject;

final class v
  implements ab
{
  v(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ac paramac)
  {
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString);
        str3 = "";
      }
      catch (Exception paramString)
      {
        Object localObject2;
        String str3;
        Object localObject3;
        if (paramac != null)
        {
          localObject1 = this.a;
          paramac.a(UPPayWapActivity.a("1", paramString.getMessage(), null));
          return;
        }
        return;
      }
      try
      {
        paramString = (String)((JSONObject)localObject2).get("url");
      }
      catch (Exception localException5)
      {
        localObject1 = "";
        str2 = "";
        str1 = "";
        paramString = "";
        continue;
      }
      try
      {
        str2 = (String)((JSONObject)localObject2).get("app");
      }
      catch (Exception localException1)
      {
        str2 = "";
        str1 = "";
        localObject3 = "";
        localObject1 = paramString;
        paramString = (String)localObject3;
        continue;
      }
      try
      {
        str1 = (String)((JSONObject)localObject2).get("title");
      }
      catch (Exception localException2)
      {
        str1 = "";
        localObject3 = "";
        localObject1 = paramString;
        paramString = (String)localObject3;
        continue;
      }
      try
      {
        localObject1 = (String)((JSONObject)localObject2).get("desp");
      }
      catch (Exception localException3)
      {
        localObject3 = "";
        localObject1 = paramString;
        paramString = (String)localObject3;
        continue;
      }
      try
      {
        localObject2 = (String)((JSONObject)localObject2).get("md5");
        UPPayAssistEx.a(this.a, paramString, str2, str1, (String)localObject1, (String)localObject2);
        return;
      }
      catch (Exception localException4)
      {
        localObject3 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject3;
        continue;
      }
      if (paramac != null)
      {
        localObject3 = this.a;
        paramac.a(UPPayWapActivity.a("1", ((Exception)localObject2).getMessage(), null));
      }
      localObject2 = localObject1;
      localObject1 = paramString;
      paramString = (String)localObject2;
      localObject2 = str3;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */