package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.d;
import org.json.JSONObject;

public class c
  extends d
{
  private String d;
  private String e;
  private String f;
  
  public c(cn.sharesdk.framework.authorize.c paramc)
  {
    super(paramc);
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.f)) || (this.f.equals("com.tencent.qqlite")))
    {
      this.c.onFailed(new TencentSSOClientNotInstalledException());
      this.a.finish();
    }
    do
    {
      Intent localIntent;
      do
      {
        return;
        localIntent = new Intent();
        localIntent.setClassName(this.f, "com.tencent.open.agent.AgentActivity");
        if (this.a.getContext().getPackageManager().resolveActivity(localIntent, 0) != null) {
          break;
        }
        this.a.finish();
      } while (this.c == null);
      this.c.onFailed(new TencentSSOClientNotInstalledException());
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("scope", this.e);
      localBundle.putString("client_id", this.d);
      localBundle.putString("pf", "openmobile_android");
      localBundle.putString("need_pay", "1");
      localIntent.putExtra("key_params", localBundle);
      localIntent.putExtra("key_request_code", this.b);
      localIntent.putExtra("key_action", "action_login");
      try
      {
        this.a.startActivityForResult(localIntent, this.b);
        return;
      }
      catch (Throwable localThrowable)
      {
        this.a.finish();
      }
    } while (this.c == null);
    this.c.onFailed(localThrowable);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.finish();
    if (paramInt2 == 0) {
      if (this.c != null) {
        this.c.onCancel();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramIntent != null) {
                  break;
                }
              } while (this.c == null);
              this.c.onFailed(new Throwable("response is empty"));
              return;
              paramIntent = paramIntent.getExtras();
              if (paramIntent != null) {
                break;
              }
            } while (this.c == null);
            this.c.onFailed(new Throwable("response is empty"));
            return;
            if (paramIntent.containsKey("key_response")) {
              break;
            }
          } while (this.c == null);
          this.c.onFailed(new Throwable("response is empty"));
          return;
          paramIntent = paramIntent.getString("key_response");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            break;
          }
        } while (this.c == null);
        this.c.onFailed(new Throwable("response is empty"));
        return;
        try
        {
          Object localObject = new JSONObject(paramIntent);
          paramIntent = new Bundle();
          paramIntent.putInt("ret", ((JSONObject)localObject).optInt("ret"));
          paramIntent.putString("pay_token", ((JSONObject)localObject).optString("pay_token"));
          paramIntent.putString("pf", ((JSONObject)localObject).optString("pf"));
          paramIntent.putString("open_id", ((JSONObject)localObject).optString("openid"));
          paramIntent.putString("expires_in", ((JSONObject)localObject).optString("expires_in"));
          paramIntent.putString("pfkey", ((JSONObject)localObject).optString("pfkey"));
          paramIntent.putString("msg", ((JSONObject)localObject).optString("msg"));
          paramIntent.putString("access_token", ((JSONObject)localObject).optString("access_token"));
          localObject = ((JSONObject)localObject).optString("msg");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.c == null)) {
            break;
          }
          this.c.onFailed(new Throwable((String)localObject));
          return;
        }
        catch (Throwable paramIntent) {}
      } while (this.c == null);
      this.c.onFailed(paramIntent);
      return;
    } while (this.c == null);
    this.c.onComplete(paramIntent);
    this.c = null;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */