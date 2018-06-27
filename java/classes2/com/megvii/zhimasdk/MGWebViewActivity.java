package com.megvii.zhimasdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.d.g;
import com.megvii.zhimasdk.d.i;
import com.megvii.zhimasdk.d.j;
import com.megvii.zhimasdk.d.l;
import com.megvii.zhimasdk.view.ADWebView;
import org.json.JSONObject;

public class MGWebViewActivity
  extends Activity
  implements View.OnClickListener
{
  public i a;
  private ADWebView b;
  private com.h.a c;
  private RelativeLayout d;
  private l e;
  private RelativeLayout f;
  private boolean g = false;
  
  private void a()
  {
    this.a = ((i)getIntent().getSerializableExtra("infobean"));
    this.f = ((RelativeLayout)findViewById(R.id.mg_webview_layout_barRel));
    this.e = new l(this);
    this.c = com.h.a.getInstance();
    this.b = ((ADWebView)findViewById(R.id.mg_webview_layout_webView));
    this.d = ((RelativeLayout)findViewById(R.id.mg_title_layout_returnRel));
    this.d.setOnClickListener(this);
    ((TextView)findViewById(R.id.mg_title_layout_titleText)).setText("芝麻认证");
  }
  
  private void a(int paramInt)
  {
    this.a.p = 1;
    com.megvii.zhimasdk.d.c.a(this.a, "failed", paramInt, 1);
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt >= 500)
    {
      a(12);
      return;
    }
    if ((paramInt >= 400) && (paramInt < 500))
    {
      a(9);
      return;
    }
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramArrayOfByte)).getString("err_msg");
        if (paramArrayOfByte.equals("INVALID_BUNDLEID"))
        {
          a(10);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    do
    {
      a(8);
      return;
      if (paramArrayOfByte.equals("CANNOT_GET_MERCHANT_INFO"))
      {
        a(9);
        return;
      }
    } while (!paramArrayOfByte.equals("UNMATCHED_MERCHANT_ID"));
    a(13);
  }
  
  private void b()
  {
    if (this.a.b == 0)
    {
      com.megvii.zhimasdk.d.a.a(this.a, "ENTER_FIRST_PAGE");
      this.d.setVisibility(0);
      this.b.a(this.a.l);
      return;
    }
    com.megvii.zhimasdk.d.a.a(this.a, "ENTER_LAST_PAGE");
    this.b.a(this.a.m);
    this.d.setVisibility(8);
    String str = this.a.a;
    i locali = this.a;
    if (str.equals("success"))
    {
      com.megvii.zhimasdk.d.a.a(this.a, "PASS_ZMCERT");
      return;
    }
    if (this.a.c == 5) {
      this.a.j = "no_camera_permission";
    }
    for (;;)
    {
      com.megvii.zhimasdk.d.a.a(this.a, com.megvii.zhimasdk.d.a.a(this.a));
      return;
      if (this.a.c == 6) {
        this.a.j = "no_sensor_permission";
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      com.megvii.zhimasdk.d.c.a(this.a, "failed", 5, 1);
    }
    for (;;)
    {
      b();
      return;
      com.megvii.zhimasdk.d.c.a(this.a, "failed", 6, 1);
    }
  }
  
  private void c()
  {
    com.megvii.zhimasdk.c.b.a().b(this.a.h, this.a.i, this.a.o, new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          paramAnonymousArrayOfe = new String(paramAnonymousArrayOfByte);
          String str = new JSONObject(paramAnonymousArrayOfe).getString("result");
          g.a("checkUserAgreement +++ successData", paramAnonymousArrayOfe);
          if (str.equals("MISS"))
          {
            MGWebViewActivity.b(MGWebViewActivity.this);
            return;
          }
          MGWebViewActivity.this.a.p = 0;
          MGWebViewActivity.c(MGWebViewActivity.this);
          return;
        }
        catch (Exception paramAnonymousArrayOfe)
        {
          paramAnonymousArrayOfe.printStackTrace();
          MGWebViewActivity.a(MGWebViewActivity.this, paramAnonymousInt, paramAnonymousArrayOfByte);
        }
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGWebViewActivity.a(MGWebViewActivity.this, paramAnonymousInt, paramAnonymousArrayOfByte);
      }
    });
  }
  
  private void d()
  {
    com.megvii.zhimasdk.c.b.a().a(this, this.a.h, this.a.i, this.a.n, new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          paramAnonymousArrayOfe = new String(paramAnonymousArrayOfByte);
          g.a("recordUserAgreement +++ successData", paramAnonymousArrayOfe);
          paramAnonymousArrayOfe = new JSONObject(paramAnonymousArrayOfe).getString("hash");
          MGWebViewActivity.this.a.o = paramAnonymousArrayOfe;
          MGWebViewActivity.this.a.p = 0;
          MGWebViewActivity.c(MGWebViewActivity.this);
          return;
        }
        catch (Exception paramAnonymousArrayOfe)
        {
          for (;;)
          {
            paramAnonymousArrayOfe.printStackTrace();
          }
        }
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGWebViewActivity.a(MGWebViewActivity.this, paramAnonymousInt, paramAnonymousArrayOfByte);
      }
    });
  }
  
  private void e()
  {
    if (this.g)
    {
      if (this.a.p == -1) {
        runOnUiThread(new Runnable()
        {
          public void run()
          {
            MGWebViewActivity.d(MGWebViewActivity.this).setVisibility(0);
          }
        });
      }
    }
    else {
      return;
    }
    if (this.a.p == 0)
    {
      f();
      return;
    }
    startActivity(new Intent(this, MGWebViewActivity.class).putExtra("infobean", this.a));
    overridePendingTransition(R.anim.mg_slide_in_left, R.anim.mg_slide_out_left);
    finish();
  }
  
  private void f()
  {
    g();
  }
  
  private void g()
  {
    if (!j.b()) {
      h();
    }
    for (;;)
    {
      this.e.a();
      return;
      if (this.e.a != 0.0F) {
        h();
      } else {
        b(false);
      }
    }
  }
  
  private void h()
  {
    this.a.q = false;
    startActivity(new Intent(this, MGLivenessDetectActivity.class).putExtra("infobean", this.a));
    overridePendingTransition(R.anim.mg_slide_in_left, R.anim.mg_slide_out_left);
    if (this.a.b == 0) {
      com.megvii.zhimasdk.d.a.a(this.a, "START_LIVENESS");
    }
    for (;;)
    {
      finish();
      return;
      com.megvii.zhimasdk.d.a.a(this.a, "RETRY_ZMCERT");
    }
  }
  
  private void i()
  {
    if ((this.a.b == 0) && (!this.b.c()))
    {
      com.megvii.zhimasdk.d.a.a(this.a, "CANCEL_ZMCERT");
      this.c.onFinish(true, false, 17);
      finish();
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.p == 0) {
      return;
    }
    com.megvii.zhimasdk.c.b.a().a(paramString, new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        if ((paramAnonymousArrayOfByte != null) && (paramAnonymousInt == 200))
        {
          MGWebViewActivity.this.a.n = paramAnonymousArrayOfByte;
          MGWebViewActivity.this.a.o = com.megvii.zhimasdk.d.b.a(MGWebViewActivity.this.a.n);
          MGWebViewActivity.a(MGWebViewActivity.this);
          return;
        }
        MGWebViewActivity.a(MGWebViewActivity.this, 8);
      }
      
      public void a(int paramAnonymousInt, e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        MGWebViewActivity.a(MGWebViewActivity.this, 8);
      }
    });
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      com.megvii.zhimasdk.d.a.a(this.a, "EXIT_ZMCERT");
      locala = this.c;
      if (this.a.a.equals("success"))
      {
        paramBoolean = bool;
        locala.onFinish(false, paramBoolean, this.a.c);
        finish();
      }
    }
    while (this.g) {
      for (;;)
      {
        com.h.a locala;
        return;
        paramBoolean = false;
      }
    }
    this.g = true;
    e();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.mg_title_layout_returnRel) {
      i();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(R.layout.mg_webview_layout);
    a();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      i();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.g = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/MGWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */