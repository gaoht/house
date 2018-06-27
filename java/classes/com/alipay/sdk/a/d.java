package com.alipay.sdk.a;

import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements Runnable
{
  d(c paramc, a parama) {}
  
  public final void run()
  {
    c localc = this.b;
    a locala = this.a;
    Object localObject;
    String str;
    if ((locala != null) && ("toast".equals(locala.c)))
    {
      localObject = locala.e;
      str = ((JSONObject)localObject).optString("content");
      if (((JSONObject)localObject).optInt("duration") >= 2500) {
        break label142;
      }
    }
    label142:
    for (int i = 0;; i = 1)
    {
      localObject = Toast.makeText(localc.b, str, i);
      if (!(localObject instanceof Toast)) {
        ((Toast)localObject).show();
      }
      for (;;)
      {
        new Timer().schedule(new e(localc, locala), i);
        i = a.a.a;
        if (i != a.a.a) {}
        try
        {
          this.b.a(this.a.a, i);
          return;
        }
        catch (JSONException localJSONException)
        {
          return;
        }
        VdsAgent.showToast((Toast)localObject);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */