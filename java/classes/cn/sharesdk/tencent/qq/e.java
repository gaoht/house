package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;

@com.maa.android.agent.instrumentation.Instrumented
public class e
  extends FakeActivity
{
  private String a;
  private PlatformActionListener b;
  private String c;
  private QQWebShareAdapter d;
  private RegisterView e;
  private WebView f;
  private boolean g;
  private boolean h;
  
  private QQWebShareAdapter b()
  {
    try
    {
      Object localObject = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("QQWebShareAdapter");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = Class.forName((String)localObject).newInstance();
        if (!(localObject instanceof QQWebShareAdapter)) {
          return null;
        }
        localObject = (QQWebShareAdapter)localObject;
        return (QQWebShareAdapter)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
      return null;
    }
    return null;
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {}
    for (String str1 = "";; str1 = new String(paramString))
    {
      paramString = ResHelper.urlToBundle(paramString);
      if (paramString != null) {
        break;
      }
      this.g = true;
      finish();
      this.b.onError(null, 0, new Throwable("failed to parse callback uri: " + str1));
      return;
    }
    String str2 = paramString.getString("action");
    if ((!"share".equals(str2)) && (!"shareToQQ".equals(str2)))
    {
      this.g = true;
      finish();
      this.b.onError(null, 0, new Throwable("action error: " + str1));
      return;
    }
    str2 = paramString.getString("result");
    if ("cancel".equals(str2))
    {
      finish();
      this.b.onCancel(null, 0);
      return;
    }
    if (!"complete".equals(str2))
    {
      this.g = true;
      finish();
      this.b.onError(null, 0, new Throwable("operation failed: " + str1));
      return;
    }
    paramString = paramString.getString("response");
    if (TextUtils.isEmpty(paramString))
    {
      this.g = true;
      finish();
      this.b.onError(null, 0, new Throwable("response empty" + str1));
      return;
    }
    this.h = true;
    finish();
    this.b.onComplete(null, 0, new Hashon().fromJson(paramString));
  }
  
  protected RegisterView a()
  {
    RegisterView localRegisterView = new RegisterView(this.activity);
    int i = localRegisterView.c().getChildCount();
    localRegisterView.c().getChildAt(i - 1).setVisibility(8);
    localRegisterView.a().setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        new Thread()
        {
          public void run()
          {
            try
            {
              new Instrumentation().sendKeyDownUpSync(4);
              return;
            }
            catch (Throwable localThrowable)
            {
              cn.sharesdk.framework.utils.e.b().d(localThrowable);
              e.this.finish();
              e.a(e.this).onCancel(null, 0);
            }
          }
        }.start();
      }
    });
    this.f = localRegisterView.b();
    WebSettings localWebSettings = this.f.getSettings();
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setDatabasePath(this.activity.getDir("database", 0).getPath());
    this.f.setVerticalScrollBarEnabled(false);
    this.f.setHorizontalScrollBarEnabled(false);
    this.f.setWebViewClient(new d()
    {
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("wtloginmqq://")))
        {
          int i = ResHelper.getStringRes(e.e(e.this), "ssdk_use_login_button");
          if (i > 0)
          {
            paramAnonymousWebView = Toast.makeText(e.f(e.this), i, 0);
            if (!(paramAnonymousWebView instanceof Toast)) {
              paramAnonymousWebView.show();
            }
          }
          else
          {
            return;
          }
          VdsAgent.showToast((Toast)paramAnonymousWebView);
          return;
        }
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith(e.b(e.this)))) {
          e.a(e.this, paramAnonymousString);
        }
        do
        {
          for (;;)
          {
            return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
            if ((paramAnonymousString == null) || (!paramAnonymousString.startsWith("http://www.myapp.com/down/"))) {
              break;
            }
            e.a(e.this, true);
          }
        } while ((paramAnonymousString == null) || (!paramAnonymousString.startsWith("wtloginmqq://")));
        int i = ResHelper.getStringRes(e.c(e.this), "ssdk_use_login_button");
        if (i > 0)
        {
          paramAnonymousWebView = Toast.makeText(e.d(e.this), i, 0);
          if ((paramAnonymousWebView instanceof Toast)) {
            break label114;
          }
          paramAnonymousWebView.show();
        }
        for (;;)
        {
          return true;
          label114:
          VdsAgent.showToast((Toast)paramAnonymousWebView);
        }
      }
    });
    return localRegisterView;
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    this.b = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString)
  {
    this.c = ("tencent" + paramString);
  }
  
  public void onCreate()
  {
    this.e = a();
    try
    {
      int i = ResHelper.getStringRes(getContext(), "ssdk_share_to_qq");
      if (i > 0) {
        this.e.c().getTvTitle().setText(i);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
        this.e.c().setVisibility(8);
      }
      WebView localWebView = this.e.b();
      String str = this.a;
      if ((localWebView instanceof WebView)) {
        break label202;
      }
      localWebView.loadUrl(str);
      return;
      WebviewInstrumentation.loadUrl((WebView)localWebView, str);
    }
    this.d.setBodyView(this.e.d());
    this.d.setWebView(this.e.b());
    this.d.setTitleView(this.e.c());
    this.d.onCreate();
    disableScreenCapture();
    this.activity.setContentView(this.e);
    if ("none".equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic()))
    {
      this.g = true;
      finish();
      this.b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
      return;
    }
    label202:
  }
  
  public void onDestroy()
  {
    if ((!this.g) && (!this.h)) {
      this.b.onCancel(null, 0);
    }
    if (this.f != null) {
      this.f.setFocusable(false);
    }
    if (this.d != null) {
      this.d.onDestroy();
    }
  }
  
  public boolean onFinish()
  {
    if (this.d != null) {
      return this.d.onFinish();
    }
    return super.onFinish();
  }
  
  public void onPause()
  {
    if (this.d != null) {
      this.d.onPause();
    }
  }
  
  public void onRestart()
  {
    if (this.d != null) {
      this.d.onRestart();
    }
  }
  
  public void onResume()
  {
    if (this.d != null) {
      this.d.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.d != null) {
      this.d.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.d != null) {
      this.d.onStop();
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    super.setActivity(paramActivity);
    if (this.d == null)
    {
      this.d = b();
      if (this.d == null) {
        this.d = new QQWebShareAdapter();
      }
    }
    this.d.setActivity(paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */