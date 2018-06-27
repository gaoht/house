package com.megvii.zhimasdk;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.KeyEvent;
import com.megvii.livenessdetection.LivenessLicenseManager;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.d.g;
import com.megvii.zhimasdk.d.i;
import com.megvii.zhimasdk.d.m;
import java.util.HashMap;
import org.json.JSONObject;

public class MGLoadActivity
  extends Activity
{
  private String a;
  private String b;
  private i c;
  private m d;
  private boolean e = false;
  
  private void a()
  {
    this.c = new i();
    this.a = getIntent().getStringExtra("bizno");
    this.b = getIntent().getStringExtra("merchantid");
    this.d = ((m)getIntent().getSerializableExtra("extParamsMap"));
    HashMap localHashMap = this.d.a();
    i locali;
    if ((localHashMap != null) && (localHashMap.get("DisableGravity") != null))
    {
      locali = this.c;
      if (!localHashMap.get("DisableGravity").equals("True")) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      locali.r = bool;
      return;
    }
  }
  
  private void a(int paramInt, e[] paramArrayOfe, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    if (paramInt >= 500)
    {
      this.c.j = "INTERNAL_SERVER_ERROR";
      a("failed", 12, 1);
    }
    for (;;)
    {
      finish();
      return;
      if ((paramInt >= 400) && (paramInt < 500))
      {
        try
        {
          paramArrayOfe = new JSONObject(new String(paramArrayOfByte)).getString("err_msg");
          this.c.j = paramArrayOfe;
          if (!paramArrayOfe.equals("UNSUPPORTED_VERSION")) {
            break label95;
          }
          g();
          return;
        }
        catch (Exception paramArrayOfe)
        {
          paramArrayOfe.printStackTrace();
        }
        continue;
        label95:
        a(paramArrayOfe);
      }
      else
      {
        this.c.j = "NETWORK_ERROR";
        h();
      }
    }
  }
  
  private void a(String paramString)
  {
    if (paramString.equals("INVALID_BUNDLEID"))
    {
      a("failed", 10, 1);
      return;
    }
    if (paramString.equals("TOO_MANY_RETRIES"))
    {
      a("failed", 1, 1);
      return;
    }
    if (paramString.equals("CANNOT_GET_MERCHANT_INFO"))
    {
      a("failed", 9, 1);
      return;
    }
    if (paramString.equals("UNMATCHED_MERCHANT_ID"))
    {
      a("failed", 13, 1);
      return;
    }
    if (paramString.equals("USERINFO_FORMAT_ERROR"))
    {
      a("failed", 15, 1);
      return;
    }
    if ((paramString.equals("USER_GLOBAL_BIZNO_LIMIT_EXCEED")) || (paramString.equals("USER_MERCHANT_BIZNO_LIMIT_EXCEED")))
    {
      a("failed", 16, 1);
      return;
    }
    if (paramString.equals("UNKNOWN_BIZNO"))
    {
      a("failed", 9, 1);
      return;
    }
    a("failed", 10, 1);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    b(paramString, paramInt1, paramInt2);
  }
  
  private void b()
  {
    if (!com.megvii.zhimasdk.c.a.a(this))
    {
      h();
      return;
    }
    com.megvii.zhimasdk.c.b.a().a(new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        if ((paramAnonymousInt == 200) && (paramAnonymousArrayOfByte != null))
        {
          MGLoadActivity.a(MGLoadActivity.this).l = new String(paramAnonymousArrayOfByte);
          MGLoadActivity.b(MGLoadActivity.this);
          return;
        }
        MGLoadActivity.c(MGLoadActivity.this);
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGLoadActivity.c(MGLoadActivity.this);
      }
    });
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    if (this.e) {
      return;
    }
    com.megvii.zhimasdk.d.c.a(this.c, paramString, paramInt1, paramInt2);
    startActivity(new Intent(this, MGWebViewActivity.class).putExtra("infobean", this.c));
    overridePendingTransition(R.anim.mg_slide_in_left, R.anim.mg_slide_out_left);
    finish();
  }
  
  private void c()
  {
    com.megvii.zhimasdk.c.b.a().b(new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        if ((paramAnonymousInt == 200) && (paramAnonymousArrayOfByte != null))
        {
          MGLoadActivity.a(MGLoadActivity.this).m = new String(paramAnonymousArrayOfByte);
          MGLoadActivity.d(MGLoadActivity.this);
          return;
        }
        MGLoadActivity.c(MGLoadActivity.this);
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGLoadActivity.c(MGLoadActivity.this);
      }
    });
  }
  
  private void d()
  {
    PackageManager localPackageManager = getPackageManager();
    if ((!localPackageManager.hasSystemFeature("android.hardware.camera")) && (!localPackageManager.hasSystemFeature("android.hardware.camera.front")))
    {
      a("failed", 2, 1);
      return;
    }
    e();
  }
  
  private void e()
  {
    this.c.h = this.a;
    this.c.i = this.b;
    com.h.a.getInstance();
    final LivenessLicenseManager localLivenessLicenseManager = new LivenessLicenseManager(this);
    String str = localLivenessLicenseManager.getContext(com.megvii.zhimasdk.d.b.b(this));
    com.megvii.zhimasdk.c.b.a().a(this.a, this.b, str, new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          paramAnonymousArrayOfe = new String(paramAnonymousArrayOfByte);
          g.a("init onSuccess: successData", paramAnonymousArrayOfe);
          paramAnonymousArrayOfe = new JSONObject(paramAnonymousArrayOfe);
          paramAnonymousArrayOfByte = paramAnonymousArrayOfe.getString("state");
          if (paramAnonymousArrayOfByte.equals("PASSED"))
          {
            MGLoadActivity.a(MGLoadActivity.this, "success", 0, 1);
            return;
          }
          if (paramAnonymousArrayOfByte.equals("AUTH_FAILED"))
          {
            MGLoadActivity.a(MGLoadActivity.this).j = paramAnonymousArrayOfe.getString("failure_reason");
            MGLoadActivity.a(MGLoadActivity.this, MGLoadActivity.a(MGLoadActivity.this).j);
            return;
          }
        }
        catch (Exception paramAnonymousArrayOfe)
        {
          paramAnonymousArrayOfe.printStackTrace();
          MGLoadActivity.a(MGLoadActivity.this, "failed", 11, 1);
          return;
        }
        paramAnonymousArrayOfByte = paramAnonymousArrayOfe.getString("sdk_auth");
        MGLoadActivity.a(MGLoadActivity.this).f = paramAnonymousArrayOfe.getJSONObject("identity_param").getString("cert_name");
        MGLoadActivity.a(MGLoadActivity.this).g = paramAnonymousArrayOfe.getJSONObject("identity_param").getString("cert_no");
        MGLoadActivity.a(MGLoadActivity.this).k = paramAnonymousArrayOfe.getInt("remaining_retry_count");
        i locali = MGLoadActivity.a(MGLoadActivity.this);
        if (paramAnonymousArrayOfe.has("meglive_config")) {}
        for (paramAnonymousArrayOfe = paramAnonymousArrayOfe.getString("meglive_config");; paramAnonymousArrayOfe = null)
        {
          locali.s = paramAnonymousArrayOfe;
          localLivenessLicenseManager.setLicense(paramAnonymousArrayOfByte);
          if (localLivenessLicenseManager.checkCachedLicense() > 0L)
          {
            MGLoadActivity.a(MGLoadActivity.this, "failed", 0, 0);
            return;
          }
          MGLoadActivity.e(MGLoadActivity.this);
          return;
        }
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGLoadActivity.a(MGLoadActivity.this, paramAnonymousInt, paramAnonymousArrayOfe, paramAnonymousArrayOfByte, paramAnonymousThrowable);
      }
    });
  }
  
  private void f()
  {
    a("failed", 10, 1);
  }
  
  private void g()
  {
    com.h.a.getInstance().onFinish(false, false, 14);
    finish();
  }
  
  private void h()
  {
    com.h.a.getInstance().onFinish(false, false, 8);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(R.layout.mg_network_layout);
    com.megvii.zhimasdk.d.c.a(true);
    a();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.e = true;
      com.h.a.getInstance().onFinish(true, false, 17);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/MGLoadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */