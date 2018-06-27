package com.unionpay;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONObject;

final class l
  implements ab
{
  l(UPPayWapActivity paramUPPayWapActivity) {}
  
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
        if (paramac == null) {
          break label188;
        }
        Object localObject1 = this.a;
        paramac.a(UPPayWapActivity.a("1", paramString.getMessage(), null));
        return;
      }
      for (;;)
      {
        try
        {
          paramString = (String)((JSONObject)localObject1).get("url");
        }
        catch (Exception localException2)
        {
          paramString = (String)localObject2;
          break;
        }
        try
        {
          localObject1 = (String)((JSONObject)localObject1).get("title");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("waptype", "new_page");
          ((Bundle)localObject2).putString("wapurl", paramString);
          ((Bundle)localObject2).putString("waptitle", (String)localObject1);
          paramString = new Intent();
          paramString.putExtras((Bundle)localObject2);
          paramString.setClass(this.a, UPPayWapActivity.class);
          this.a.startActivity(paramString);
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
    label188:
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */