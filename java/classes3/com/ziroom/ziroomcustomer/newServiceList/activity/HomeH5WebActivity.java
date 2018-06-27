package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
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
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.b.a;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class HomeH5WebActivity
  extends BaseActivity
  implements PlatformActionListener
{
  protected BridgeWebView a;
  private com.ziroom.ziroomcustomer.webview.d b;
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
  private String x;
  
  private void a()
  {
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.b = new com.ziroom.ziroomcustomer.webview.d(this);
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
      this.x = getIntent().getStringExtra("ziru_back");
      if ("not_show".equals(getIntent().getStringExtra("isEnCity"))) {
        af.showToast(this, "精致搬家暂不支持" + com.ziroom.ziroomcustomer.base.b.c + "用户预约，敬请期待");
      }
      com.freelxl.baselibrary.f.d.d("sjdgkl", "======   " + this.c + "     shareUrl=== " + this.v);
      if ((!"ziroomupin".equals(this.f)) && (!"recommendedhouse".equals(this.f))) {
        break label559;
      }
      this.s.setVisibility(0);
      d("房源尚未加载完成");
      label364:
      if (TextUtils.isEmpty(this.t)) {
        this.t = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
      }
      if (!"serviceOrderShare".equals(this.f)) {
        break label742;
      }
      this.g.setText("");
      localObject1 = new WebChromeClient()
      {
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          com.freelxl.baselibrary.f.d.d("ANDROID_LAB", "======TITLE=" + paramAnonymousString);
          HomeH5WebActivity.a(HomeH5WebActivity.this).setText(paramAnonymousString);
        }
      };
      localObject2 = this.a;
      if ((localObject2 instanceof WebView)) {
        break label731;
      }
      ((BridgeWebView)localObject2).setWebChromeClient((WebChromeClient)localObject1);
      label427:
      this.d = this.g.getText().toString();
      label443:
      this.r.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("finish_web".equals(HomeH5WebActivity.b(HomeH5WebActivity.this))) {
            if ((TextUtils.isEmpty(HomeH5WebActivity.this.a.getUrl())) || (!HomeH5WebActivity.this.a.getUrl().contains("app_action")) || (!HomeH5WebActivity.a(HomeH5WebActivity.this, "finish_web"))) {}
          }
          do
          {
            return;
            if (HomeH5WebActivity.this.a.canGoBack())
            {
              HomeH5WebActivity.this.a.goBack();
              return;
            }
            if ("ziru_back_main".equals(HomeH5WebActivity.c(HomeH5WebActivity.this)))
            {
              paramAnonymousView = new Intent(HomeH5WebActivity.this, MainActivity.class);
              HomeH5WebActivity.this.startActivity(paramAnonymousView);
              HomeH5WebActivity.this.finish();
              return;
            }
            HomeH5WebActivity.this.finish();
            return;
            if (!"serviceOrderShare".equals(HomeH5WebActivity.b(HomeH5WebActivity.this))) {
              break;
            }
          } while ((!TextUtils.isEmpty(HomeH5WebActivity.this.a.getUrl())) && (HomeH5WebActivity.this.a.getUrl().contains("app_action")) && (HomeH5WebActivity.a(HomeH5WebActivity.this, "finish_web")));
          if (HomeH5WebActivity.this.a.canGoBack())
          {
            HomeH5WebActivity.this.a.goBack();
            return;
          }
          HomeH5WebActivity.this.finish();
          return;
          if ("advertisement".equals(HomeH5WebActivity.b(HomeH5WebActivity.this)))
          {
            paramAnonymousView = new Intent(HomeH5WebActivity.this, MainActivity.class);
            HomeH5WebActivity.this.startActivity(paramAnonymousView);
          }
          HomeH5WebActivity.this.finish();
        }
      });
      if (!TextUtils.isEmpty(this.c))
      {
        if (!this.c.contains("?")) {
          break label790;
        }
        this.c += "&app_version=5.6.0";
        label506:
        localObject1 = this.a;
        localObject2 = this.c;
        if ((localObject1 instanceof WebView)) {
          break label820;
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
      label559:
      if ("homeService".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        this.u = true;
        break label364;
      }
      if ("finish_web".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        this.u = true;
        break label364;
      }
      if ("advertisement".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        break label364;
      }
      if ("finish_web_main".equals(this.f))
      {
        this.s.setVisibility(0);
        d("");
        break label364;
      }
      if ("signed_move_preferential".equals(this.f))
      {
        this.s.setVisibility(8);
        this.u = true;
        break label364;
      }
      this.s.setVisibility(8);
      break label364;
      label731:
      VdsAgent.setWebChromeClient((WebView)localObject2, (WebChromeClient)localObject1);
      break label427;
      label742:
      if (TextUtils.isEmpty(this.d)) {
        this.e = "自如APP";
      }
      if (TextUtils.isEmpty(this.e)) {
        this.e = "自如APP";
      }
      this.g.setText(this.d);
      break label443;
      label790:
      this.c += "?app_version=5.6.0";
      break label506;
      label820:
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
    }
  }
  
  private void b()
  {
    new com.ziroom.ziroomcustomer.webview.b().toHouseDetail(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        Intent localIntent = new Intent(HomeH5WebActivity.this, RentHouseDetailActivity.class);
        localIntent.putExtra("id", paramAnonymousParamBean.getHouse_code());
        localIntent.putExtra("house_id", paramAnonymousParamBean.getHouse_id());
        HomeH5WebActivity.this.startActivity(localIntent);
      }
    });
    new com.ziroom.ziroomcustomer.webview.b().toMoreHouseList(this.a, new b.a()
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
          paramAnonymousParamBean = new Intent(HomeH5WebActivity.this, HouseListActivity.class);
          paramAnonymousParamBean.putExtra("searchCondition", localSearchCondition);
          HomeH5WebActivity.this.startActivity(paramAnonymousParamBean);
          return;
          if ("2".equals(paramAnonymousParamBean.getHouseType()))
          {
            localSearchCondition.setHouse_type("整租");
            localSearchCondition.setHouseType("2");
          }
        }
      }
    });
    new com.ziroom.ziroomcustomer.webview.b().toGoodsShelf(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        Intent localIntent = new Intent(HomeH5WebActivity.this, HomeWebActivity.class);
        localIntent.putExtra("ziru", "ziroomupin");
        localIntent.putExtra("title", "自如优品");
        if (paramAnonymousParamBean.getUrl().contains("?")) {
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "&app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
        }
        for (;;)
        {
          HomeH5WebActivity.this.startActivity(localIntent);
          return;
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "?app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
        }
      }
    });
    new com.ziroom.ziroomcustomer.webview.b().toPhone(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        ah.callPhone(HomeH5WebActivity.this, paramAnonymousParamBean.getTel());
      }
    });
    new com.ziroom.ziroomcustomer.webview.b().toActivity(this.a, new b.a()
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
            new o(HomeH5WebActivity.this).toDownloadCertificate(0);
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
        paramAnonymousObject = new Intent(HomeH5WebActivity.this, SignerAptitudeActivity.class);
        ((Intent)paramAnonymousObject).putExtra("activityName", "AccountInfoActivity");
        HomeH5WebActivity.this.startActivity((Intent)paramAnonymousObject);
        return;
        paramAnonymousObject = new Intent(HomeH5WebActivity.this, EducationActivity.class);
        HomeH5WebActivity.this.startActivity((Intent)paramAnonymousObject);
      }
    });
    if (this.u) {
      new com.ziroom.ziroomcustomer.webview.b().toServiceActivity(this.a);
    }
    new com.ziroom.ziroomcustomer.webview.b().toServiceShare(this.a, new b.a()
    {
      public void onJsLinkCallBack(String paramAnonymousString)
      {
        u.d("sdjgkjg", "===== zhixingle ..1");
        if ("evalshare_share".equals(paramAnonymousString))
        {
          com.freelxl.baselibrary.f.d.d("sjdgkl", "====== " + HomeH5WebActivity.h(HomeH5WebActivity.this));
          a.getInstance().setPaltFormShowFlag(10);
          a.setLocalIcon(2130839951);
          a.getInstance().shareFromCenter(HomeH5WebActivity.this, HomeH5WebActivity.h(HomeH5WebActivity.this), HomeH5WebActivity.i(HomeH5WebActivity.this), HomeH5WebActivity.f(HomeH5WebActivity.this), HomeH5WebActivity.g(HomeH5WebActivity.this));
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
        paramAnonymousView = HomeH5WebActivity.e(HomeH5WebActivity.this);
        if (paramAnonymousView != null) {
          if (paramAnonymousView.contains("?"))
          {
            paramAnonymousView = paramAnonymousView + "&plat=web";
            a.getInstance().shareFromCenter(HomeH5WebActivity.this, paramAnonymousView, HomeH5WebActivity.d(HomeH5WebActivity.this), HomeH5WebActivity.f(HomeH5WebActivity.this), HomeH5WebActivity.g(HomeH5WebActivity.this));
          }
        }
        while (TextUtils.isEmpty(paramString)) {
          for (;;)
          {
            return;
            paramAnonymousView = paramAnonymousView + "?plat=web";
          }
        }
        paramAnonymousView = Toast.makeText(HomeH5WebActivity.this, paramString, 0);
        if (!(paramAnonymousView instanceof Toast))
        {
          paramAnonymousView.show();
          return;
        }
        VdsAgent.showToast((Toast)paramAnonymousView);
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
            break label211;
          }
        }
      }
    }
    label148:
    label150:
    label171:
    label211:
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
    if ("ziru_back_main".equals(this.x))
    {
      startActivity(new Intent(this, MainActivity.class));
      finish();
    }
    for (;;)
    {
      super.onBackPressed();
      return;
      finish();
    }
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    new Message();
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903236);
    a();
    b();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    showToast("分享失败");
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
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
      if (ae.isNull(HomeH5WebActivity.d(HomeH5WebActivity.this))) {
        HomeH5WebActivity.a(HomeH5WebActivity.this).setText(paramWebView.getTitle());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/HomeH5WebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */