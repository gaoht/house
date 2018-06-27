package com.unionpay;

import org.json.JSONObject;

final class j
  implements ab
{
  j(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ac paramac)
  {
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        localObject2 = "";
      }
      catch (Exception paramString)
      {
        UPPayWapActivity localUPPayWapActivity;
        if (paramac == null) {
          break label139;
        }
        Object localObject1 = this.a;
        paramac.a(UPPayWapActivity.a("1", paramString.getMessage(), null));
        return;
      }
      for (;;)
      {
        try
        {
          paramString = (String)((JSONObject)localObject1).get("resultCode");
        }
        catch (Exception localException2)
        {
          paramString = (String)localObject2;
          break;
        }
        try
        {
          localObject1 = (String)((JSONObject)localObject1).get("resultData");
          localObject2 = this.a;
          localUPPayWapActivity = this.a;
          UPPayWapActivity.a((UPPayWapActivity)localObject2, paramString, (String)localObject1);
          if (paramac == null) {
            continue;
          }
          paramString = this.a;
          paramac.a(UPPayWapActivity.a("0", "success", null));
          return;
        }
        catch (Exception localException1)
        {
          break;
        }
      }
      if (paramac != null)
      {
        localObject2 = this.a;
        paramac.a(UPPayWapActivity.a("1", ((Exception)localObject1).getMessage(), null));
      }
      localObject1 = "";
    }
    label139:
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */