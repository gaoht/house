package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.tools.FakeActivity;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob.OnSubscribe;
import com.mob.tools.RxMob.Subscribable;
import com.mob.tools.RxMob.Subscriber;
import com.mob.tools.RxMob.Thread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import org.json.JSONObject;

public class d
  extends FakeActivity
  implements View.OnClickListener
{
  private AuthorizeListener a;
  private String b;
  private String c;
  private String d;
  private int e;
  private cn.sharesdk.sina.weibo.sdk.a.a f;
  private LinearLayout g;
  private TextView h;
  private WebView i;
  private Button j;
  
  private void a()
  {
    this.h = this.f.b();
    this.i = this.f.c();
    this.g = this.f.d();
    this.j = this.f.a();
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    if (ShareSDK.isRemoveCookieOnAuthorize())
    {
      CookieSyncManager.createInstance(this.activity);
      CookieManager.getInstance().removeAllCookie();
    }
    this.i.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (d.a(d.this) == -1)
        {
          d.b(d.this).setVisibility(0);
          d.c(d.this).setVisibility(8);
        }
        d.a(d.this, 0);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        paramAnonymousWebView = paramAnonymousWebView.getUrl();
        if ((TextUtils.isEmpty(paramAnonymousWebView)) || (TextUtils.isEmpty(paramAnonymousString2))) {}
        do
        {
          return;
          paramAnonymousWebView = Uri.parse(paramAnonymousWebView);
          paramAnonymousString1 = Uri.parse(paramAnonymousString2);
        } while ((!paramAnonymousWebView.getHost().equals(paramAnonymousString1.getHost())) || (!paramAnonymousWebView.getScheme().equals(paramAnonymousString1.getScheme())));
        d.a(d.this, -1);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith(d.d(d.this)))
        {
          if (d.e(d.this) != null) {
            d.a(d.this, paramAnonymousString);
          }
          return true;
        }
        return false;
      }
    });
    c();
  }
  
  private void a(String paramString)
  {
    Bundle localBundle = ResHelper.urlToBundle(paramString);
    if (localBundle.containsKey("access_token")) {
      this.a.onComplete(localBundle);
    }
    while (!localBundle.containsKey("error"))
    {
      finish();
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!localBundle.containsKey("error_uri")) {
          break label187;
        }
        paramString = localBundle.getString("error_uri");
        localJSONObject.put("error_uri:", paramString);
        if (!localBundle.containsKey("error")) {
          break label199;
        }
        paramString = localBundle.getString("error");
        localJSONObject.put("error:", paramString);
        if (!localBundle.containsKey("error_description")) {
          break label205;
        }
        paramString = localBundle.getString("error_description");
        localJSONObject.put("error_description:", paramString);
        if (!localBundle.containsKey("error_code")) {
          break label193;
        }
        paramString = localBundle.getString("error_code");
        localJSONObject.put("error_code:", paramString);
        this.a.onError(new Throwable(localJSONObject.toString()));
      }
      catch (Throwable paramString)
      {
        e.b().e(paramString);
        this.a.onError(paramString);
      }
      break;
      label187:
      paramString = "";
      continue;
      label193:
      paramString = "";
      continue;
      label199:
      paramString = "";
      continue;
      label205:
      paramString = "";
    }
  }
  
  private String b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("client_id", this.b));
    localArrayList.add(new KVPair("response_type", "code"));
    localArrayList.add(new KVPair("redirect_uri", this.c));
    localArrayList.add(new KVPair("packagename", this.activity.getPackageName()));
    localArrayList.add(new KVPair("response_type", "code"));
    localArrayList.add(new KVPair("luicode", "10000360"));
    if ((this.d != null) && (!TextUtils.isEmpty(this.d)))
    {
      localArrayList.add(new KVPair("trans_token", this.d));
      localArrayList.add(new KVPair("trans_access_token", this.d));
    }
    localArrayList.add(new KVPair("key_hash", cn.sharesdk.sina.weibo.sdk.a.a(getContext(), this.activity.getPackageName())));
    localArrayList.add(new KVPair("version", "0041005000"));
    localArrayList.add(new KVPair("scope", "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write"));
    localArrayList.add(new KVPair("display", "mobile"));
    return "https://open.weibo.cn/oauth2/authorize?" + ResHelper.encodeUrl(localArrayList);
  }
  
  private String c()
  {
    RxMob.Subscribable localSubscribable = RxMob.create(new RxMob.OnSubscribe()
    {
      public void call(RxMob.Subscriber<String> paramAnonymousSubscriber)
      {
        WebView localWebView = d.c(d.this);
        String str = d.f(d.this);
        if (!(localWebView instanceof WebView)) {
          localWebView.loadUrl(str);
        }
        for (;;)
        {
          paramAnonymousSubscriber.onCompleted();
          return;
          WebviewInstrumentation.loadUrl((WebView)localWebView, str);
        }
      }
    });
    localSubscribable.subscribeOn(RxMob.Thread.UI_THREAD);
    localSubscribable.observeOn(RxMob.Thread.UI_THREAD);
    localSubscribable.subscribe(new RxMob.Subscriber()
    {
      public void onCompleted()
      {
        super.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        e.b().d(paramAnonymousThrowable);
      }
    });
    return null;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    this.a = paramAuthorizeListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if ((paramView == this.h) && (this.a != null))
    {
      this.a.onCancel();
      finish();
    }
    while (paramView != this.j) {
      return;
    }
    this.g.setVisibility(8);
    this.i.setVisibility(0);
    c();
  }
  
  public void onCreate()
  {
    this.f = new cn.sharesdk.sina.weibo.sdk.a.a(getContext());
    int k = ResHelper.getStringRes(getContext(), "ssdk_sina_web_login_title");
    this.activity.setContentView(this.f.a(k));
    a();
  }
  
  public void onDestroy()
  {
    if (this.i != null) {
      this.i.setFocusable(false);
    }
  }
  
  public boolean onFinish()
  {
    if (this.a != null) {
      this.a = null;
    }
    return super.onFinish();
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (this.a != null) {
        this.a.onCancel();
      }
      finish();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */