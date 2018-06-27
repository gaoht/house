package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class d
  extends FakeActivity
{
  private String a;
  private boolean b;
  private PlatformActionListener c;
  private RegisterView d;
  private WebView e;
  private String f;
  private boolean g;
  private boolean h;
  private QZoneWebShareAdapter i;
  
  private QZoneWebShareAdapter b()
  {
    try
    {
      Object localObject = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("QZoneWebShareAdapter");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = Class.forName((String)localObject).newInstance();
        if (!(localObject instanceof QZoneWebShareAdapter)) {
          return null;
        }
        localObject = (QZoneWebShareAdapter)localObject;
        return (QZoneWebShareAdapter)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      e.b().d(localThrowable);
      return null;
    }
    return null;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {}
    for (String str1 = "";; str1 = new String(paramString))
    {
      paramString = ResHelper.urlToBundle(paramString);
      if (paramString != null) {
        break;
      }
      this.h = true;
      finish();
      this.c.onError(null, 0, new Throwable("failed to parse callback uri: " + str1));
      return;
    }
    String str2 = paramString.getString("action");
    if ((!"share".equals(str2)) && (!"shareToQzone".equals(str2)))
    {
      this.h = true;
      finish();
      this.c.onError(null, 0, new Throwable("action error: " + str1));
      return;
    }
    str2 = paramString.getString("result");
    if ("cancel".equals(str2))
    {
      finish();
      this.c.onCancel(null, 0);
      return;
    }
    if (!"complete".equals(str2))
    {
      this.h = true;
      finish();
      this.c.onError(null, 0, new Throwable("operation failed: " + str1));
      return;
    }
    paramString = paramString.getString("response");
    if (TextUtils.isEmpty(paramString))
    {
      this.h = true;
      finish();
      this.c.onError(null, 0, new Throwable("response empty" + str1));
      return;
    }
    this.g = true;
    finish();
    this.c.onComplete(null, 0, new Hashon().fromJson(paramString));
  }
  
  private void c()
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.a));
      localIntent.putExtra("pkg_name", this.activity.getPackageName());
      this.activity.startActivityForResult(localIntent, 100);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (this.c == null) {}
      this.c.onError(null, 0, localThrowable);
    }
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    try
    {
      paramString = this.activity.getPackageManager().queryIntentActivities(localIntent, 1);
      if ((paramString != null) && (paramString.size() > 0)) {
        startActivity(localIntent);
      }
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        e.b().d(paramString);
        paramString = null;
      }
    }
  }
  
  private void d()
  {
    this.d = a();
    try
    {
      int j = ResHelper.getStringRes(getContext(), "ssdk_share_to_qzone");
      if (j > 0) {
        this.d.c().getTvTitle().setText(j);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.b().d(localThrowable);
        this.d.c().setVisibility(8);
      }
      WebView localWebView = this.d.b();
      String str = this.a;
      if ((localWebView instanceof WebView)) {
        break label196;
      }
      localWebView.loadUrl(str);
      return;
      WebviewInstrumentation.loadUrl((WebView)localWebView, str);
    }
    this.i.setBodyView(this.d.d());
    this.i.setWebView(this.d.b());
    this.i.setTitleView(this.d.c());
    this.i.onCreate();
    this.activity.setContentView(this.d);
    if ("none".equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic()))
    {
      this.h = true;
      finish();
      this.c.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
      return;
    }
    label196:
  }
  
  protected RegisterView a()
  {
    RegisterView localRegisterView = new RegisterView(this.activity);
    int j = localRegisterView.c().getChildCount();
    localRegisterView.c().getChildAt(j - 1).setVisibility(8);
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
              e.b().d(localThrowable);
              d.this.finish();
              d.a(d.this).onCancel(null, 0);
            }
          }
        }.start();
      }
    });
    this.e = localRegisterView.b();
    WebSettings localWebSettings = this.e.getSettings();
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(this.activity.getDir("database", 0).getPath());
    localWebSettings.setSavePassword(false);
    this.e.setVerticalScrollBarEnabled(false);
    this.e.setHorizontalScrollBarEnabled(false);
    this.e.setWebViewClient(new cn.sharesdk.framework.d()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith(d.b(d.this)))) {
          d.a(d.this, paramAnonymousString);
        }
        for (;;)
        {
          return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mqzone://"))) {
            d.b(d.this, paramAnonymousString);
          }
        }
      }
    });
    return localRegisterView;
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    this.c = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.f = ("tencent" + paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 100) && (paramInt2 == 0)) {
      this.c.onCancel(null, 9);
    }
    finish();
  }
  
  public void onCreate()
  {
    try
    {
      Class localClass = Class.forName("cn.sharesdk.tencent.qq.ReceiveActivity");
      localClass.getMethod("setUriScheme", new Class[] { String.class }).invoke(null, new Object[] { this.f });
      localClass.getMethod("setPlatformActionListener", new Class[] { PlatformActionListener.class }).invoke(null, new Object[] { this.c });
      if (this.b)
      {
        c();
        return;
      }
      d();
      return;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ReceiveActivity.a(this.f);
        ReceiveActivity.a(this.c);
        if (this.b)
        {
          c();
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        this.activity.finish();
        if (this.c != null)
        {
          this.c.onError(null, 9, localThrowable2);
          return;
          d();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if ((!this.b) && (!this.h) && (!this.g)) {
      this.c.onCancel(null, 0);
    }
    if (this.e != null) {
      this.e.setFocusable(false);
    }
    if (this.i != null) {
      this.i.onDestroy();
    }
  }
  
  public boolean onFinish()
  {
    if (this.i != null) {
      return this.i.onFinish();
    }
    return super.onFinish();
  }
  
  public void onPause()
  {
    if (this.i != null) {
      this.i.onPause();
    }
  }
  
  public void onRestart()
  {
    if (this.i != null) {
      this.i.onRestart();
    }
  }
  
  public void onResume()
  {
    if (this.i != null) {
      this.i.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.i != null) {
      this.i.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.i != null) {
      this.i.onStop();
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    super.setActivity(paramActivity);
    if (this.i == null)
    {
      this.i = b();
      if (this.i == null) {
        this.i = new QZoneWebShareAdapter();
      }
    }
    this.i.setActivity(paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qzone/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */