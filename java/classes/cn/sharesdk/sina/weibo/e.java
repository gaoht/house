package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.graphics.Bitmap;
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
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
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
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.sina.weibo.sdk.api.ImageObject;
import java.util.ArrayList;
import java.util.HashMap;

public class e
  extends FakeActivity
  implements View.OnClickListener
{
  private String a;
  private String b;
  private Platform.ShareParams c;
  private AuthorizeListener d;
  private cn.sharesdk.sina.weibo.sdk.a.a e;
  private LinearLayout f;
  private TextView g;
  private WebView h;
  private Button i;
  private int j;
  
  private void a()
  {
    this.g = this.e.b();
    this.h = this.e.c();
    this.f = this.e.d();
    this.i = this.e.a();
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    if (ShareSDK.isRemoveCookieOnAuthorize())
    {
      CookieSyncManager.createInstance(this.activity);
      CookieManager.getInstance().removeAllCookie();
    }
    this.h.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (e.a(e.this) == -1)
        {
          e.b(e.this).setVisibility(0);
          e.c(e.this).setVisibility(8);
        }
        e.a(e.this, 0);
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
        e.a(e.this, -1);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith("sinaweibo://browser/close"))
        {
          if (e.d(e.this) != null) {
            e.a(e.this, paramAnonymousString);
          }
          return true;
        }
        return false;
      }
    });
    b();
  }
  
  private void a(String paramString)
  {
    paramString = ResHelper.urlToBundle(paramString);
    String str1 = paramString.getString("code");
    String str2 = paramString.getString("msg");
    if (TextUtils.isEmpty(str1)) {
      this.d.onCancel();
    }
    for (;;)
    {
      finish();
      return;
      if ("0".equals(str1)) {
        this.d.onComplete(paramString);
      } else {
        this.d.onError(new Throwable(str2));
      }
    }
  }
  
  private String b()
  {
    RxMob.Subscribable localSubscribable = RxMob.create(new RxMob.OnSubscribe()
    {
      public void call(RxMob.Subscriber<String> paramAnonymousSubscriber)
      {
        paramAnonymousSubscriber.onNext(e.e(e.this));
      }
    });
    localSubscribable.subscribeOn(RxMob.Thread.NEW_THREAD);
    localSubscribable.observeOn(RxMob.Thread.UI_THREAD);
    localSubscribable.subscribe(new RxMob.Subscriber()
    {
      public void a(String paramAnonymousString)
      {
        WebView localWebView = e.c(e.this);
        paramAnonymousString = e.b(e.this, paramAnonymousString);
        if (!(localWebView instanceof WebView))
        {
          localWebView.loadUrl(paramAnonymousString);
          return;
        }
        WebviewInstrumentation.loadUrl((WebView)localWebView, paramAnonymousString);
      }
      
      public void onCompleted()
      {
        super.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        cn.sharesdk.framework.utils.e.b().w(paramAnonymousThrowable);
        paramAnonymousThrowable = e.c(e.this);
        String str = e.b(e.this, null);
        if (!(paramAnonymousThrowable instanceof WebView))
        {
          paramAnonymousThrowable.loadUrl(str);
          return;
        }
        WebviewInstrumentation.loadUrl((WebView)paramAnonymousThrowable, str);
      }
      
      public void onStart()
      {
        super.onStart();
      }
    });
    return null;
  }
  
  private String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("title", this.c.getText()));
    localArrayList.add(new KVPair("source", this.a));
    localArrayList.add(new KVPair("access_token", this.b));
    localArrayList.add(new KVPair("packagename", this.activity.getPackageName()));
    localArrayList.add(new KVPair("picinfo", paramString));
    localArrayList.add(new KVPair("luicode", "10000360"));
    localArrayList.add(new KVPair("key_hash", cn.sharesdk.sina.weibo.sdk.a.a(getContext(), this.activity.getPackageName())));
    localArrayList.add(new KVPair("lfid", "OP_" + this.a));
    localArrayList.add(new KVPair("version", "0041005000"));
    return "http://service.weibo.com/share/mobilesdk.php?" + ResHelper.encodeUrl(localArrayList);
  }
  
  private String c()
  {
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject3 = this.c.getImageData();
        if ((localObject3 == null) && (!TextUtils.isEmpty(this.c.getImagePath())))
        {
          localObject1 = BitmapHelper.getBitmap(this.c.getImagePath());
          if (localObject1 == null) {
            break label350;
          }
          localObject3 = new ImageObject();
          ((ImageObject)localObject3).setImageObject((Bitmap)localObject1);
          if ((((ImageObject)localObject3).imageData == null) || (((ImageObject)localObject3).imageData.length <= 0)) {
            break label350;
          }
          localObject1 = new String(cn.sharesdk.sina.weibo.sdk.a.a(((ImageObject)localObject3).imageData));
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return null;
          }
        }
        else
        {
          localObject1 = localObject3;
          if (localObject3 != null) {
            continue;
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty(this.c.getImageUrl())) {
            continue;
          }
          localObject1 = BitmapHelper.getBitmap(getContext(), this.c.getImageUrl());
          continue;
        }
        localObject3 = new NetworkHelper();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new KVPair("img", localObject1));
        localArrayList.add(new KVPair("oauth_timestamp", String.valueOf(System.currentTimeMillis() / 1000L)));
        Object localObject1 = new StringBuilder();
        if (!TextUtils.isEmpty(this.b)) {
          ((StringBuilder)localObject1).append(this.b);
        }
        if (!TextUtils.isEmpty(this.a)) {
          ((StringBuilder)localObject1).append(this.a);
        }
        localObject1 = ((NetworkHelper)localObject3).httpPost("http://service.weibo.com/share/mobilesdk_uppic.php", localArrayList, null, null, null);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject3 = new Hashon().fromJson((String)localObject1);
        if ((localObject3 == null) || (!((HashMap)localObject3).containsKey("code")) || (!((HashMap)localObject3).containsKey("data"))) {
          break label357;
        }
        localObject1 = String.valueOf(((HashMap)localObject3).get("code"));
        localObject3 = String.valueOf(((HashMap)localObject3).get("data"));
        if ("1".equals(localObject1))
        {
          boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
          if (!bool) {
            break;
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
        return null;
      }
      label350:
      Object localObject2 = null;
    }
    return (String)localObject3;
    label357:
    return null;
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    this.c = paramShareParams;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    this.d = paramAuthorizeListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView == this.g)
    {
      this.d.onCancel();
      finish();
    }
    while (paramView != this.i) {
      return;
    }
    this.f.setVisibility(8);
    this.h.setVisibility(0);
    b();
  }
  
  public void onCreate()
  {
    this.e = new cn.sharesdk.sina.weibo.sdk.a.a(getContext());
    int k = ResHelper.getStringRes(getContext(), "ssdk_sina_web_title");
    this.activity.setContentView(this.e.a(k));
    a();
  }
  
  public void onDestroy()
  {
    if (this.h != null) {
      this.h.setFocusable(false);
    }
  }
  
  public boolean onFinish()
  {
    if (this.d != null) {
      this.d = null;
    }
    return super.onFinish();
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (this.d != null) {
        this.d.onCancel();
      }
      finish();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */