package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;

@com.maa.android.agent.instrumentation.Instrumented
public class e
  extends a
  implements Handler.Callback, ResizeLayout.OnResizeListener
{
  protected AuthorizeListener b;
  private AuthorizeAdapter c;
  private RegisterView d;
  private WebView e;
  
  private AuthorizeAdapter c()
  {
    try
    {
      ActivityInfo localActivityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128);
      if ((localActivityInfo.metaData != null) && (!localActivityInfo.metaData.isEmpty()))
      {
        String str = localActivityInfo.metaData.getString("AuthorizeAdapter");
        if (str != null)
        {
          localObject = str;
          if (str.length() > 0) {}
        }
        else
        {
          str = localActivityInfo.metaData.getString("Adapter");
          if (str == null) {
            break label127;
          }
          localObject = str;
          if (str.length() <= 0) {
            break label127;
          }
        }
        Object localObject = Class.forName((String)localObject).newInstance();
        if (!(localObject instanceof AuthorizeAdapter)) {
          return null;
        }
        localObject = (AuthorizeAdapter)localObject;
        return (AuthorizeAdapter)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().w(localThrowable);
      return null;
    }
    return null;
    label127:
    return null;
  }
  
  public void OnResize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c != null) {
      this.c.onResize(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    this.b = paramAuthorizeListener;
  }
  
  protected RegisterView b()
  {
    RegisterView localRegisterView = new RegisterView(this.activity);
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
              cn.sharesdk.framework.utils.e.b().w(localThrowable);
              AuthorizeListener localAuthorizeListener = e.this.a.getAuthorizeListener();
              if (localAuthorizeListener != null) {
                localAuthorizeListener.onCancel();
              }
              e.this.finish();
            }
          }
        }.start();
      }
    });
    this.e = localRegisterView.b();
    Object localObject = this.e.getSettings();
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setSavePassword(false);
    this.e.setVerticalScrollBarEnabled(false);
    this.e.setHorizontalScrollBarEnabled(false);
    b localb = this.a.getAuthorizeWebviewClient(this);
    localObject = "";
    if (localb != null) {
      localObject = localb.getClass().getSimpleName();
    }
    if (((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("GooglePlusAuthorizeWebviewClient"))) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("GooglePlus"))) || (((String)localObject).equals("YoutubeAuthorizeWebviewClient")))
    {
      localObject = "Mozilla/5.0 (Linux; Android 5.1; m2 note Build/LMY47D) " + "AppleWebKit/537.36 (KHTML, like Gecko) ";
      localObject = (String)localObject + "Version/4.0 ";
      localObject = (String)localObject + "Chrome/40.0.2214.127 ";
      localObject = (String)localObject + "Mobile Safari/537.36";
      this.e.getSettings().setUserAgentString((String)localObject);
    }
    this.e.setWebViewClient(localb);
    new Thread()
    {
      public void run()
      {
        try
        {
          Message localMessage = new Message();
          localMessage.what = 2;
          if ("none".equals(DeviceHelper.getInstance(e.a(e.this)).getDetailNetworkTypeForStatic()))
          {
            localMessage.arg1 = 1;
            UIHandler.sendMessage(localMessage, e.this);
            return;
          }
          if (ShareSDK.isRemoveCookieOnAuthorize())
          {
            CookieSyncManager.createInstance(e.b(e.this));
            CookieManager.getInstance().removeAllCookie();
          }
          localMessage.obj = e.this.a.getAuthorizeUrl();
          UIHandler.sendMessage(localMessage, e.this);
          return;
        }
        catch (Throwable localThrowable)
        {
          cn.sharesdk.framework.utils.e.b().w(localThrowable);
        }
      }
    }.start();
    return localRegisterView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (paramMessage.arg1 == 1)
      {
        paramMessage = this.a.getAuthorizeListener();
        if (paramMessage != null) {
          paramMessage.onError(new Throwable("Network error (platform: " + this.a.getPlatform().getName() + ")"));
        }
      }
      else
      {
        paramMessage = (String)paramMessage.obj;
        if (TextUtils.isEmpty(paramMessage))
        {
          finish();
          paramMessage = this.a.getAuthorizeListener();
          if (paramMessage != null) {
            paramMessage.onError(new Throwable("Authorize URL is empty (platform: " + this.a.getPlatform().getName() + ")"));
          }
        }
        else
        {
          WebView localWebView = this.e;
          if (!(localWebView instanceof WebView)) {
            localWebView.loadUrl(paramMessage);
          } else {
            WebviewInstrumentation.loadUrl((WebView)localWebView, paramMessage);
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    Object localObject;
    String str;
    if (this.d == null)
    {
      this.d = b();
      this.d.a(this);
      this.d.a(this.c.isNotitle());
      this.c.setBodyView(this.d.d());
      this.c.setWebView(this.d.b());
      localObject = this.d.c();
      this.c.setTitleView((TitleLayout)localObject);
      str = this.a.getPlatform().getName();
      this.c.setPlatformName(this.a.getPlatform().getName());
    }
    try
    {
      i = ResHelper.getStringRes(getContext(), "ssdk_" + str.toLowerCase());
      ((TitleLayout)localObject).getTvTitle().setText(i);
      this.c.onCreate();
      if ((this.c != null) && (!this.c.isPopUpAnimationDisable()))
      {
        localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject).setDuration(550L);
        ((ScaleAnimation)localObject).setInterpolator(new a(null));
        this.d.setAnimation((Animation)localObject);
      }
      disableScreenCapture();
      this.activity.setContentView(this.d);
      return;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          int i = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
          ((TitleLayout)localObject).getTvTitle().setText(i);
        }
        catch (Throwable localThrowable1)
        {
          cn.sharesdk.framework.utils.e.b().w(localThrowable2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.onDestroy();
    }
    if (this.e != null) {
      this.e.setFocusable(false);
    }
  }
  
  public boolean onFinish()
  {
    if (this.c != null) {
      return this.c.onFinish();
    }
    if (this.e != null)
    {
      this.e.destroy();
      this.e.removeAllViews();
    }
    if (this.activity != null) {
      ((ViewGroup)this.activity.getWindow().getDecorView()).removeAllViews();
    }
    return super.onFinish();
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.c != null) {
      bool = this.c.onKeyEvent(paramInt, paramKeyEvent);
    }
    if ((!bool) && (paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      AuthorizeListener localAuthorizeListener = this.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onCancel();
      }
    }
    if (bool) {
      return true;
    }
    return super.onKeyEvent(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    if (this.c != null) {
      this.c.onPause();
    }
  }
  
  public void onRestart()
  {
    if (this.c != null) {
      this.c.onRestart();
    }
  }
  
  public void onResume()
  {
    if (this.c != null) {
      this.c.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.c != null) {
      this.c.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.c != null) {
      this.c.onStop();
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    super.setActivity(paramActivity);
    if (this.c == null)
    {
      this.c = c();
      if (this.c == null) {
        this.c = new AuthorizeAdapter();
      }
    }
    this.c.setActivity(paramActivity);
  }
  
  private static class a
    implements Interpolator
  {
    private float[] a = { 0.0F, 0.02692683F, 0.053847015F, 0.080753915F, 0.10764089F, 0.13450131F, 0.16132854F, 0.18811597F, 0.21485697F, 0.24154496F, 0.26817337F, 0.2947356F, 0.3212251F, 0.34763536F, 0.37395984F, 0.40019205F, 0.42632553F, 0.4523538F, 0.47827047F, 0.50406915F, 0.52974343F, 0.555287F, 0.5806936F, 0.60595685F, 0.6310707F, 0.65602875F, 0.68082494F, 0.70545316F, 0.72990733F, 0.75418144F, 0.7782694F, 0.8021654F, 0.8258634F, 0.8493577F, 0.8726424F, 0.89571184F, 0.9185602F, 0.94118196F, 0.9635715F, 0.9857233F, 1.0076319F, 1.0292919F, 1.0506978F, 1.0718446F, 1.0927268F, 1.1133395F, 1.1336775F, 1.1537358F, 1.1735094F, 1.1929934F, 1.1893399F, 1.1728106F, 1.1565471F, 1.1405534F, 1.1248333F, 1.1093911F, 1.0942302F, 1.0793544F, 1.0647675F, 1.050473F, 1.0364745F, 1.0227754F, 1.0093791F, 0.99628896F, 0.9835081F, 0.9710398F, 0.958887F, 0.9470527F, 0.93553996F, 0.9243516F, 0.91349024F, 0.90295863F, 0.90482706F, 0.9114033F, 0.91775465F, 0.9238795F, 0.9297765F, 0.93544406F, 0.9408808F, 0.94608533F, 0.95105654F, 0.955793F, 0.9602937F, 0.9645574F, 0.96858317F, 0.9723699F, 0.97591674F, 0.97922283F, 0.9822872F, 0.9851093F, 0.98768836F, 0.9900237F, 0.9921147F, 0.993961F, 0.99556196F, 0.9969173F, 0.9980267F, 0.99888986F, 0.99950653F, 0.9998766F, 1.0F };
    
    public float getInterpolation(float paramFloat)
    {
      int j = 100;
      int k = (int)(100.0F * paramFloat);
      int i = k;
      if (k < 0) {
        i = 0;
      }
      if (i > 100) {
        i = j;
      }
      for (;;)
      {
        return this.a[i];
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */