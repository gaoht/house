package com.ziroom.ziroomcustomer.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlibrary.f.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs.ParamBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class HomeWebActivity
  extends BaseActivity
{
  protected BridgeWebView a;
  private d b;
  private String c;
  private String d = "";
  private String e = "";
  private String f = "";
  private TextView g;
  private ImageView r;
  private ImageView s;
  private String t;
  private boolean u = false;
  private String v;
  private String w;
  private PlatformActionListener x = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      HomeWebActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      HomeWebActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  private void a()
  {
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.b = new d(this);
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    if (!(localObject1 instanceof WebView))
    {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      localObject1 = this.a.getSettings().getUserAgentString();
      this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
      this.r = ((ImageView)findViewById(2131689781));
      this.g = ((TextView)findViewById(2131689782));
      this.s = ((ImageView)findViewById(2131691042));
      this.f = getIntent().getStringExtra("ziru");
      this.c = getIntent().getStringExtra("url");
      this.d = getIntent().getStringExtra("title");
      this.e = getIntent().getStringExtra("content");
      this.t = getIntent().getStringExtra("pic");
      this.v = getIntent().getStringExtra("shareUrl");
      this.w = getIntent().getStringExtra("shareTitle");
      com.freelxl.baselibrary.f.d.d("sjdgkl", "======   " + this.c + "     shareUrl=== " + this.v);
      if ((!"ziroomupin".equals(this.f)) && (!"recommendedhouse".equals(this.f))) {
        break label499;
      }
      this.s.setVisibility(0);
      d("房源尚未加载完成");
      label304:
      if (TextUtils.isEmpty(this.t)) {
        this.t = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
      }
      if (!"serviceOrderShare".equals(this.f)) {
        break label648;
      }
      this.g.setText("");
      localObject1 = new WebChromeClient()
      {
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          com.freelxl.baselibrary.f.d.d("ANDROID_LAB", "======TITLE=" + paramAnonymousString);
          HomeWebActivity.a(HomeWebActivity.this).setText(paramAnonymousString);
        }
      };
      localObject2 = this.a;
      if ((localObject2 instanceof WebView)) {
        break label637;
      }
      ((BridgeWebView)localObject2).setWebChromeClient((WebChromeClient)localObject1);
      label367:
      this.d = this.g.getText().toString();
      label383:
      this.r.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("finish_web".equals(HomeWebActivity.b(HomeWebActivity.this))) {
            if ((TextUtils.isEmpty(HomeWebActivity.this.a.getUrl())) || (!HomeWebActivity.this.a.getUrl().contains("app_action")) || (!HomeWebActivity.a(HomeWebActivity.this, "finish_web"))) {}
          }
          do
          {
            return;
            if (HomeWebActivity.this.a.canGoBack())
            {
              HomeWebActivity.this.a.goBack();
              return;
            }
            HomeWebActivity.this.finish();
            return;
            if (!"serviceOrderShare".equals(HomeWebActivity.b(HomeWebActivity.this))) {
              break;
            }
          } while ((!TextUtils.isEmpty(HomeWebActivity.this.a.getUrl())) && (HomeWebActivity.this.a.getUrl().contains("app_action")) && (HomeWebActivity.a(HomeWebActivity.this, "finish_web")));
          if (HomeWebActivity.this.a.canGoBack())
          {
            HomeWebActivity.this.a.goBack();
            return;
          }
          HomeWebActivity.this.finish();
          return;
          if ("advertisement".equals(HomeWebActivity.b(HomeWebActivity.this)))
          {
            paramAnonymousView = new Intent(HomeWebActivity.this, MainActivity.class);
            HomeWebActivity.this.startActivity(paramAnonymousView);
          }
          HomeWebActivity.this.finish();
        }
      });
      if (!TextUtils.isEmpty(this.c))
      {
        if (!this.c.contains("?")) {
          break label694;
        }
        this.c += "&app_version=5.6.0";
        label446:
        localObject1 = this.a;
        localObject2 = this.c;
        if ((localObject1 instanceof WebView)) {
          break label724;
        }
        ((BridgeWebView)localObject1).loadUrl((String)localObject2);
      }
    }
    for (;;)
    {
      this.a.setWebViewClient(new a(this.a));
      return;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break;
      label499:
      if ("homeService".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        this.u = true;
        break label304;
      }
      if ("finish_web".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        this.u = true;
        break label304;
      }
      if ("advertisement".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        break label304;
      }
      if ("signed_move_preferential".equals(this.f))
      {
        this.s.setVisibility(8);
        this.u = true;
        break label304;
      }
      this.s.setVisibility(8);
      break label304;
      label637:
      VdsAgent.setWebChromeClient((WebView)localObject2, (WebChromeClient)localObject1);
      break label367;
      label648:
      if (TextUtils.isEmpty(this.d)) {
        this.e = "自如APP";
      }
      if (TextUtils.isEmpty(this.e)) {
        this.e = "自如APP";
      }
      this.g.setText(this.d);
      break label383;
      label694:
      this.c += "?app_version=5.6.0";
      break label446;
      label724:
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
    }
  }
  
  private void b()
  {
    new b().toHouseDetail(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        Intent localIntent = new Intent(HomeWebActivity.this, RentHouseDetailActivity.class);
        localIntent.putExtra("id", paramAnonymousParamBean.getHouse_code());
        localIntent.putExtra("house_id", paramAnonymousParamBean.getHouse_id());
        HomeWebActivity.this.startActivity(localIntent);
      }
    });
    new b().toMoreHouseList(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        SearchCondition localSearchCondition = new SearchCondition();
        if ("1".equals(paramAnonymousParamBean.getHouseType()))
        {
          localSearchCondition.setHouse_type("合租");
          localSearchCondition.setHouseType("1");
        }
        for (;;)
        {
          paramAnonymousParamBean = new Intent(HomeWebActivity.this, HouseListActivity.class);
          paramAnonymousParamBean.putExtra("searchCondition", localSearchCondition);
          HomeWebActivity.this.startActivity(paramAnonymousParamBean);
          return;
          if ("2".equals(paramAnonymousParamBean.getHouseType()))
          {
            localSearchCondition.setHouse_type("整租");
            localSearchCondition.setHouseType("2");
          }
        }
      }
    });
    new b().toGoodsShelf(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        Intent localIntent = new Intent(HomeWebActivity.this, HomeWebActivity.class);
        localIntent.putExtra("ziru", "ziroomupin");
        localIntent.putExtra("title", "自如优品");
        if (paramAnonymousParamBean.getUrl().contains("?")) {
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "&app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
        }
        for (;;)
        {
          HomeWebActivity.this.startActivity(localIntent);
          return;
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "?app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
        }
      }
    });
    new b().toPhone(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        ah.callPhone(HomeWebActivity.this, paramAnonymousParamBean.getTel());
      }
    });
    new b().toActivity(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        paramAnonymousObject = (String)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          return;
        }
        int i = -1;
        switch (((String)paramAnonymousObject).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
          case 0: 
            new o(HomeWebActivity.this).toDownloadCertificate(0);
            return;
            if (((String)paramAnonymousObject).equals("1"))
            {
              i = 0;
              continue;
              if (((String)paramAnonymousObject).equals("2"))
              {
                i = 1;
                continue;
                if (((String)paramAnonymousObject).equals("3")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        paramAnonymousObject = new Intent(HomeWebActivity.this, SignerAptitudeActivity.class);
        ((Intent)paramAnonymousObject).putExtra("activityName", "AccountInfoActivity");
        HomeWebActivity.this.startActivity((Intent)paramAnonymousObject);
        return;
        paramAnonymousObject = new Intent(HomeWebActivity.this, EducationActivity.class);
        HomeWebActivity.this.startActivity((Intent)paramAnonymousObject);
      }
    });
    if (this.u) {
      new b().toServiceActivity(this.a);
    }
    new b().toServiceShare(this.a, new b.a()
    {
      public void onJsLinkCallBack(String paramAnonymousString)
      {
        u.d("sdjgkjg", "===== zhixingle ..1");
        if ("evalshare_share".equals(paramAnonymousString))
        {
          com.freelxl.baselibrary.f.d.d("sjdgkl", "====== " + HomeWebActivity.h(HomeWebActivity.this));
          a.getInstance().setPaltFormShowFlag(10);
          a.setLocalIcon(2130839951);
          a.getInstance().shareFromCenter(HomeWebActivity.this, HomeWebActivity.h(HomeWebActivity.this), HomeWebActivity.i(HomeWebActivity.this), HomeWebActivity.e(HomeWebActivity.this), HomeWebActivity.f(HomeWebActivity.this), HomeWebActivity.g(HomeWebActivity.this));
        }
      }
    });
  }
  
  private void d(final String paramString)
  {
    this.s.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = HomeWebActivity.d(HomeWebActivity.this);
        if (paramAnonymousView != null) {
          if (paramAnonymousView.contains("?"))
          {
            paramAnonymousView = paramAnonymousView + "&plat=web";
            a.getInstance().shareFromCenter(HomeWebActivity.this, paramAnonymousView, HomeWebActivity.c(HomeWebActivity.this), HomeWebActivity.e(HomeWebActivity.this), HomeWebActivity.f(HomeWebActivity.this), HomeWebActivity.g(HomeWebActivity.this));
          }
        }
        while (TextUtils.isEmpty(paramString)) {
          for (;;)
          {
            return;
            paramAnonymousView = paramAnonymousView + "?plat=web";
          }
        }
        g.textToast(HomeWebActivity.this, paramString, 0);
      }
    });
  }
  
  private boolean e(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    Object localObject;
    int j;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.getUrl() != null)
      {
        localObject = this.a.getUrl().split("\\?");
        bool1 = bool2;
        if (localObject.length > 1)
        {
          j = localObject[1].indexOf("app_action");
          if (!localObject[1].contains("&")) {
            break label171;
          }
          int k = localObject[1].indexOf("&", j);
          localObject = localObject[1].substring(j + "app_action=".length(), k);
          if (!((String)localObject).contains(paramString)) {
            break label210;
          }
        }
      }
    }
    label148:
    label150:
    label171:
    label210:
    for (bool1 = true;; bool1 = false)
    {
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        return bool1;
        localObject = localObject[1].substring(j + "app_action=".length());
        break;
        if (!paramString.equals("finish_web")) {
          break label148;
        }
        break label150;
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.a.canGoBack()) && (this.a.getUrl() != null) && (!this.a.getUrl().contains("app_action"))) {
      this.a.goBack();
    }
    while ((this.a.getUrl() != null) && (this.a.getUrl().contains("app_action")) && (e("finish_web"))) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903376);
    a();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && ("advertisement".equals(this.f)))
    {
      startActivity(new Intent(this, MainActivity.class));
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.a.reload();
  }
  
  class a
    extends com.freelxl.baselibrary.webview.c
  {
    public a(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (ae.isNull(HomeWebActivity.c(HomeWebActivity.this))) {
        HomeWebActivity.a(HomeWebActivity.this).setText(paramWebView.getTitle());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/HomeWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */