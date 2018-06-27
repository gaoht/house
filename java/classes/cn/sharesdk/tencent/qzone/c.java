package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.d;
import org.json.JSONObject;

public class c
  extends d
{
  private String d;
  private String e;
  
  public c(cn.sharesdk.framework.authorize.c paramc)
  {
    super(paramc);
  }
  
  public void a()
  {
    do
    {
      Intent localIntent;
      do
      {
        try
        {
          PackageInfo localPackageInfo = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
          if (localPackageInfo == null)
          {
            this.a.finish();
            if (this.c != null) {
              this.c.onFailed(new TencentSSOClientNotInstalledException());
            }
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
          do
          {
            this.a.finish();
          } while (this.c == null);
          this.c.onFailed(new TencentSSOClientNotInstalledException());
          return;
        }
        localIntent = new Intent();
        localIntent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
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
      catch (Throwable localThrowable2)
      {
        this.a.finish();
      }
    } while (this.c == null);
    this.c.onFailed(localThrowable2);
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
      for (;;)
      {
        return;
        if (paramIntent == null)
        {
          if (this.c != null) {
            this.c.onFailed(new Throwable("response is empty"));
          }
        }
        else
        {
          paramIntent = paramIntent.getExtras();
          if (paramIntent == null)
          {
            if (this.c != null) {
              this.c.onFailed(new Throwable("response is empty"));
            }
          }
          else if (!paramIntent.containsKey("key_response"))
          {
            if (this.c != null) {
              this.c.onFailed(new Throwable("response is empty"));
            }
          }
          else
          {
            paramIntent = paramIntent.getString("key_response");
            if ((paramIntent == null) || (paramIntent.length() <= 0))
            {
              if (this.c != null) {
                this.c.onFailed(new Throwable("response is empty"));
              }
            }
            else {
              try
              {
                paramIntent = new JSONObject(paramIntent);
                Bundle localBundle = new Bundle();
                localBundle.putInt("ret", paramIntent.optInt("ret"));
                localBundle.putString("pay_token", paramIntent.optString("pay_token"));
                localBundle.putString("pf", paramIntent.optString("pf"));
                localBundle.putString("open_id", paramIntent.optString("openid"));
                localBundle.putString("expires_in", paramIntent.optString("expires_in"));
                localBundle.putString("pfkey", paramIntent.optString("pfkey"));
                localBundle.putString("msg", paramIntent.optString("msg"));
                localBundle.putString("access_token", paramIntent.optString("access_token"));
                if (this.c != null)
                {
                  this.c.onComplete(localBundle);
                  return;
                }
              }
              catch (Throwable paramIntent) {}
            }
          }
        }
      }
    } while (this.c == null);
    this.c.onFailed(paramIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.e = paramString2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qzone/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */