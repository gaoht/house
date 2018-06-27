package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

final class j
  implements Runnable
{
  j(Activity paramActivity, StringBuilder paramStringBuilder, a parama) {}
  
  public final void run()
  {
    try
    {
      localObject3 = new com.alipay.sdk.f.a.a();
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject3;
      Object localObject1;
      label28:
      label236:
      return;
    }
    finally
    {
      if (i.a() != null) {
        i.a().b();
      }
    }
    try
    {
      localObject3 = ((com.alipay.sdk.f.a.a)localObject3).a(this.a, this.b.toString());
      localObject1 = localObject3;
    }
    catch (Throwable localThrowable)
    {
      break label28;
    }
    if (i.a() != null)
    {
      i.a().b();
      i.b();
    }
    if (localObject1 == null)
    {
      i.a(this.c.getRedirectUri() + "?resultCode=202");
      i.a(this.a, i.c());
      if (i.a() != null) {
        i.a().b();
      }
    }
    do
    {
      return;
      localObject1 = com.alipay.sdk.g.b.a(((com.alipay.sdk.f.b)localObject1).a().optJSONObject("form").optJSONObject("onload"));
      int i = 0;
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          if (((com.alipay.sdk.g.b)((List)localObject1).get(i)).a == com.alipay.sdk.g.a.b) {
            i.a(((com.alipay.sdk.g.b)localObject1.get(i)).b[0]);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(i.c())) {
            break label236;
          }
          i.a(this.c.getRedirectUri() + "?resultCode=202");
          i.a(this.a, i.c());
          if (i.a() == null) {
            break;
          }
          i.a().b();
          return;
        }
        i += 1;
      }
      localObject1 = new Intent(this.a, AuthActivity.class);
      ((Intent)localObject1).putExtra("params", i.c());
      ((Intent)localObject1).putExtra("redirectUri", this.c.getRedirectUri());
      this.a.startActivity((Intent)localObject1);
    } while (i.a() == null);
    i.a().b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */