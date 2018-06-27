package com.ziroom.ziroomcustomer.webview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.d.b;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;

@com.maa.android.agent.instrumentation.Instrumented
public class JsBridgeWebActivity
  extends BaseActivity
  implements PlatformActionListener
{
  private String A;
  private String B;
  private String C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G = true;
  private boolean H;
  private boolean I;
  private boolean J;
  private int K;
  private int L = 0;
  private a M;
  private BroadcastReceiver N = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = 1;
      int j;
      if (paramAnonymousIntent != null)
      {
        j = paramAnonymousIntent.getIntExtra("code", -1);
        if (j != 1) {
          break label50;
        }
        i = 0;
      }
      for (;;)
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("message");
        paramAnonymousIntent.getStringExtra("resultType");
        JsBridgeWebActivity.a(JsBridgeWebActivity.this).sendResultOfPaymentToH5(i, paramAnonymousContext);
        return;
        label50:
        if (j != 0) {
          if (j == 2) {
            i = 3;
          } else {
            i = j;
          }
        }
      }
    }
  };
  private View.OnClickListener O = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (JsBridgeWebActivity.p(JsBridgeWebActivity.this))
      {
        paramAnonymousView = new Intent(JsBridgeWebActivity.this, MainActivity.class);
        paramAnonymousView.putExtra("FRAGMENT_TYPE", JsBridgeWebActivity.q(JsBridgeWebActivity.this));
        JsBridgeWebActivity.this.startActivityAndFinish(paramAnonymousView);
        return;
      }
      JsBridgeWebActivity.this.finish();
    }
  };
  private PlatformActionListener P = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      JsBridgeWebActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      JsBridgeWebActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private View.OnClickListener Q = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (JsBridgeWebActivity.this.a != null)
      {
        if (!JsBridgeWebActivity.this.a.canGoBack()) {
          break label57;
        }
        if (JsBridgeWebActivity.r(JsBridgeWebActivity.this)) {
          JsBridgeWebActivity.this.finish();
        }
      }
      else
      {
        return;
      }
      JsBridgeWebActivity.this.a.goBack();
      return;
      label57:
      if (JsBridgeWebActivity.p(JsBridgeWebActivity.this))
      {
        paramAnonymousView = new Intent(JsBridgeWebActivity.this, MainActivity.class);
        paramAnonymousView.putExtra("FRAGMENT_TYPE", JsBridgeWebActivity.q(JsBridgeWebActivity.this));
        JsBridgeWebActivity.this.startActivityAndFinish(paramAnonymousView);
        return;
      }
      JsBridgeWebActivity.this.finish();
    }
  };
  private BroadcastReceiver R = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      paramAnonymousIntent.getIntExtra("status", 0);
      if (i == 17) {
        JsBridgeWebActivity.a(JsBridgeWebActivity.this).sendLoginInfo();
      }
    }
  };
  protected BridgeWebView a;
  private final int b = 1;
  private final int c = 3;
  private final int d = 2;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private ImageView r;
  private ProgressBar s;
  private String t;
  private String u;
  private boolean v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    registerReceiver(this.N, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
  }
  
  private void b()
  {
    this.a = ((BridgeWebView)findViewById(2131689545));
    Object localObject1 = this.a.getSettings().getUserAgentString();
    this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
    this.f = ((ImageView)findViewById(2131689492));
    this.g = ((ImageView)findViewById(2131690588));
    this.e = ((TextView)findViewById(2131689541));
    this.r = ((ImageView)findViewById(2131690673));
    this.s = ((ProgressBar)findViewById(2131690674));
    if (getIntent() != null)
    {
      this.t = getIntent().getStringExtra("url");
      u.d("jdskgjfkl", "======= mUrl  " + this.t);
      this.u = getIntent().getStringExtra("title");
      this.v = getIntent().getBooleanExtra("isShowShareLocal", false);
      localObject1 = getIntent().getStringExtra("isShowShare");
      if (!com.ziroom.commonlib.utils.r.isEmpty((String)localObject1)) {
        this.v = "1".equals(localObject1);
      }
      this.w = getIntent().getStringExtra("shareContent");
      this.x = getIntent().getStringExtra("shareImg");
      this.D = getIntent().getBooleanExtra("isWebViewGoBack", false);
      this.E = getIntent().getBooleanExtra("isBackMain", false);
      this.F = getIntent().getBooleanExtra("isRefresh", false);
      this.I = getIntent().getBooleanExtra("isZoom", false);
      this.J = getIntent().getBooleanExtra("isGetH5Data", false);
      this.K = getIntent().getIntExtra("mainType", 0);
      this.L = getIntent().getIntExtra("isUniCode ", 0);
    }
    if (this.L == 1) {
      this.t = toURLDecoded(this.t);
    }
    Object localObject2;
    if (this.v)
    {
      this.r.setVisibility(0);
      if (TextUtils.isEmpty(this.w)) {
        this.w = "自如";
      }
      if (TextUtils.isEmpty(this.x)) {
        this.x = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
      }
      this.e.setText(this.u);
      this.f.setOnClickListener(this.Q);
      this.r.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((JsBridgeWebActivity.b(JsBridgeWebActivity.this)) && (!TextUtils.isEmpty(JsBridgeWebActivity.c(JsBridgeWebActivity.this))) && (!TextUtils.isEmpty(JsBridgeWebActivity.d(JsBridgeWebActivity.this))) && (!TextUtils.isEmpty(JsBridgeWebActivity.e(JsBridgeWebActivity.this))) && (!TextUtils.isEmpty(JsBridgeWebActivity.f(JsBridgeWebActivity.this)))) {
            com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(JsBridgeWebActivity.this, JsBridgeWebActivity.a(JsBridgeWebActivity.this, JsBridgeWebActivity.c(JsBridgeWebActivity.this)), JsBridgeWebActivity.d(JsBridgeWebActivity.this), JsBridgeWebActivity.e(JsBridgeWebActivity.this), JsBridgeWebActivity.f(JsBridgeWebActivity.this), JsBridgeWebActivity.g(JsBridgeWebActivity.this));
          }
          while ((TextUtils.isEmpty(JsBridgeWebActivity.h(JsBridgeWebActivity.this))) || (JsBridgeWebActivity.i(JsBridgeWebActivity.this) == null)) {
            return;
          }
          com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(JsBridgeWebActivity.this, JsBridgeWebActivity.a(JsBridgeWebActivity.this, JsBridgeWebActivity.h(JsBridgeWebActivity.this)), JsBridgeWebActivity.i(JsBridgeWebActivity.this).getText().toString(), JsBridgeWebActivity.j(JsBridgeWebActivity.this), JsBridgeWebActivity.k(JsBridgeWebActivity.this), JsBridgeWebActivity.g(JsBridgeWebActivity.this));
        }
      });
      this.a.getSettings().setJavaScriptEnabled(true);
      if (this.I)
      {
        this.a.getSettings().setSupportZoom(true);
        this.a.getSettings().setBuiltInZoomControls(true);
        this.a.getSettings().setDisplayZoomControls(false);
      }
      this.a.setWebViewClient(new b(this.a));
      localObject1 = this.a;
      localObject2 = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          if ((!JsBridgeWebActivity.this.isFinishing()) && (JsBridgeWebActivity.l(JsBridgeWebActivity.this) != null))
          {
            if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
            {
              JsBridgeWebActivity.l(JsBridgeWebActivity.this).setProgress(paramAnonymousInt);
              JsBridgeWebActivity.l(JsBridgeWebActivity.this).setVisibility(0);
            }
          }
          else {
            return;
          }
          JsBridgeWebActivity.l(JsBridgeWebActivity.this).setVisibility(8);
        }
        
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          if ((!JsBridgeWebActivity.this.isFinishing()) && (JsBridgeWebActivity.i(JsBridgeWebActivity.this) != null) && (TextUtils.isEmpty(JsBridgeWebActivity.m(JsBridgeWebActivity.this)))) {
            JsBridgeWebActivity.i(JsBridgeWebActivity.this).setText(paramAnonymousString);
          }
        }
      };
      if ((localObject1 instanceof WebView)) {
        break label699;
      }
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      label560:
      this.M = new a()
      {
        protected void a()
        {
          super.a();
          Intent localIntent = new Intent(JsBridgeWebActivity.this, MainActivity.class);
          localIntent.putExtra("FRAGMENT_TYPE", 7);
          JsBridgeWebActivity.this.startActivityAndFinish(localIntent);
        }
        
        protected void a(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.a(paramAnonymouse);
          if (paramAnonymouse != null)
          {
            paramAnonymouse.getDouble("radio").doubleValue();
            int i = paramAnonymouse.getInteger("scale_w").intValue();
            int j = paramAnonymouse.getInteger("scale_h").intValue();
            if ((j != 0) && (i != 0))
            {
              int k = j * 600 / i;
              paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(JsBridgeWebActivity.this, false, 1, true, 600, k, i, j);
            }
          }
          for (;;)
          {
            JsBridgeWebActivity.this.startActivityForResult(paramAnonymouse, 3);
            return;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(JsBridgeWebActivity.this, false, 1, false, 0, 0);
            continue;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(JsBridgeWebActivity.this, false, 1, false, 0, 0);
          }
        }
        
        protected void b(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.b(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(JsBridgeWebActivity.this, false, 1, true, 600, 600);
          JsBridgeWebActivity.this.startActivityForResult(paramAnonymouse, 1);
        }
        
        protected void c(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.c(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(JsBridgeWebActivity.this, false, 1, false, 0, 0);
          JsBridgeWebActivity.this.startActivityForResult(paramAnonymouse, 2);
        }
        
        protected void d(com.alibaba.fastjson.e paramAnonymouse)
        {
          if (paramAnonymouse != null)
          {
            JsBridgeWebActivity.b(JsBridgeWebActivity.this, paramAnonymouse.getString("shareUrl"));
            JsBridgeWebActivity.c(JsBridgeWebActivity.this, paramAnonymouse.getString("shareTitle"));
            JsBridgeWebActivity.d(JsBridgeWebActivity.this, paramAnonymouse.getString("pic"));
            JsBridgeWebActivity.e(JsBridgeWebActivity.this, paramAnonymouse.getString("shareContent"));
            JsBridgeWebActivity.f(JsBridgeWebActivity.this, paramAnonymouse.getString("pageTitle"));
            if ((JsBridgeWebActivity.b(JsBridgeWebActivity.this)) && (!TextUtils.isEmpty(JsBridgeWebActivity.n(JsBridgeWebActivity.this)))) {
              JsBridgeWebActivity.i(JsBridgeWebActivity.this).setText(JsBridgeWebActivity.n(JsBridgeWebActivity.this));
            }
          }
        }
        
        protected void e(final com.alibaba.fastjson.e paramAnonymouse)
        {
          super.e(paramAnonymouse);
          if (paramAnonymouse != null)
          {
            String str = paramAnonymouse.getString("title");
            JsBridgeWebActivity.i(JsBridgeWebActivity.this).setText(str);
            if (!paramAnonymouse.containsKey("shareParam")) {
              break label91;
            }
            paramAnonymouse = paramAnonymouse.getJSONObject("shareParam");
            if (paramAnonymouse != null)
            {
              JsBridgeWebActivity.o(JsBridgeWebActivity.this).setVisibility(0);
              JsBridgeWebActivity.o(JsBridgeWebActivity.this).setOnClickListener(new View.OnClickListener()
              {
                @com.growingio.android.sdk.instrumentation.Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  if (paramAnonymouse != null)
                  {
                    paramAnonymous2View = paramAnonymouse.getString("linkUrl");
                    String str1 = paramAnonymouse.getString("title");
                    String str2 = paramAnonymouse.getString("content");
                    String str3 = paramAnonymouse.getString("imageUrl");
                    com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(JsBridgeWebActivity.this, paramAnonymous2View, str1, str2, str3, JsBridgeWebActivity.g(JsBridgeWebActivity.this));
                  }
                }
              });
            }
          }
          else
          {
            return;
          }
          JsBridgeWebActivity.o(JsBridgeWebActivity.this).setVisibility(8);
          return;
          label91:
          JsBridgeWebActivity.o(JsBridgeWebActivity.this).setVisibility(8);
        }
        
        protected void f()
        {
          super.f();
          HashSet localHashSet = new HashSet();
          localHashSet.add(Integer.valueOf(1));
          Intent localIntent = new Intent(JsBridgeWebActivity.this, HouseListActivity.class);
          SearchCondition localSearchCondition = new SearchCondition();
          localSearchCondition.setType("1");
          localSearchCondition.setTypeName("合租");
          localSearchCondition.setTypeSet(localHashSet);
          localSearchCondition.setVersion("5");
          localIntent.putExtra("searchCondition", localSearchCondition);
          localIntent.putExtra("isSpecified", true);
          JsBridgeWebActivity.this.startActivity(localIntent);
        }
        
        protected void z(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.z(paramAnonymouse);
          if (paramAnonymouse != null)
          {
            paramAnonymouse = paramAnonymouse.getString("projectId");
            com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(JsBridgeWebActivity.this, paramAnonymouse);
          }
        }
      };
      this.M.init(this, this.a);
      if (!TextUtils.isEmpty(this.t))
      {
        if (!this.t.contains("?")) {
          break label710;
        }
        localObject1 = this.t + "&app_version=" + "5.6.0" + "&os=android";
        label642:
        localObject2 = this.a;
        if ((localObject2 instanceof WebView)) {
          break label748;
        }
        ((BridgeWebView)localObject2).loadUrl((String)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.R, (IntentFilter)localObject1);
      a();
      return;
      this.r.setVisibility(8);
      break;
      label699:
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break label560;
      label710:
      localObject1 = this.t + "?app_version=" + "5.6.0" + "&os=android";
      break label642;
      label748:
      WebviewInstrumentation.loadUrl((WebView)localObject2, (String)localObject1);
    }
  }
  
  private String d(String paramString)
  {
    if (paramString.contains("?")) {
      return paramString + "&plat=web&shareFlag=2";
    }
    return paramString + "?plat=web&shareFlag=2";
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2)
  {
    start(paramContext, paramString1, paramString2, false, "", "", false, false, false, false, 0);
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    start(paramContext, paramString1, paramString2, true, paramString3, paramString4, false, false, false, paramBoolean, 0);
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    start(paramContext, paramString1, paramString2, false, "", "", paramBoolean, false, false, false, 0);
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2)
  {
    start(paramContext, paramString1, paramString2, paramBoolean1, paramString3, paramString4, paramBoolean2, false, false, false, 0);
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    start(paramContext, paramString1, paramString2, paramBoolean1, paramString3, paramString4, paramBoolean2, paramBoolean3, false, false, 0);
  }
  
  public static void start(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, JsBridgeWebActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("isShowShareLocal", paramBoolean1);
    localIntent.putExtra("shareContent", paramString3);
    localIntent.putExtra("shareImg", paramString4);
    localIntent.putExtra("isBackMain", paramBoolean2);
    localIntent.putExtra("isRefresh", paramBoolean3);
    localIntent.putExtra("isZoom", paramBoolean4);
    localIntent.putExtra("isGetH5Data", paramBoolean5);
    localIntent.putExtra("mainType", paramInt);
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void start(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    start(paramContext, "", paramString, false, "", "", paramBoolean, false, false, false, paramInt);
  }
  
  public static void start(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    start(paramContext, paramString1, paramString2, false, "", "", false, false, paramBoolean, false, 0);
  }
  
  public void dismissProgress()
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    File localFile = null;
    Object localObject2 = null;
    Object localObject1 = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    label234:
    label436:
    label630:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null));
                showProgress("");
                paramIntent = paramIntent.getStringExtra("path");
              } while (TextUtils.isEmpty(paramIntent));
              u.d("JsBridgeWebActivity", "=========path:" + paramIntent);
              localFile = new File(paramIntent);
              if ((localFile.isFile()) && (localFile.exists()))
              {
                try
                {
                  paramIntent = com.ziroom.ziroomcustomer.util.r.zoomImageWithQuality(com.ziroom.ziroomcustomer.util.r.zoomImageByRatio(paramIntent, 800.0F, 800.0F), 2048);
                  localObject1 = paramIntent;
                  if (paramIntent != null) {
                    break label234;
                  }
                  dismissProgress();
                  return;
                }
                catch (FileNotFoundException paramIntent)
                {
                  paramIntent.printStackTrace();
                }
                catch (IOException paramIntent)
                {
                  paramIntent.printStackTrace();
                }
                finally
                {
                  if (0 == 0)
                  {
                    dismissProgress();
                    return;
                  }
                }
              }
              else
              {
                com.freelxl.baselibrary.f.g.textToast(this, "当前图片不存在！");
                dismissProgress();
                return;
              }
              n.phpUploadImg(this, com.ziroom.ziroomcustomer.e.g.getPhpUploadImg("ei"), (File)localObject1, new com.ziroom.ziroomcustomer.e.a.c(this, new q(String.class))
              {
                public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
                {
                  super.onSuccess(paramAnonymousInt, paramAnonymousString);
                  u.i("PHP Upload Image resp:", paramAnonymousString);
                  paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
                  String str = paramAnonymousString.getString("url");
                  paramAnonymousString.getString("status");
                  com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
                  if (ae.notNull(str))
                  {
                    locale.put("url", paramAnonymousString.getString("url"));
                    locale.put("message", "success");
                  }
                  for (;;)
                  {
                    JsBridgeWebActivity.a(JsBridgeWebActivity.this).doCallH5("commonUploadImgResultUrl", locale);
                    dismissProgress();
                    return;
                    locale.put("url", "");
                    locale.put("message", "系统错误");
                  }
                }
              });
              return;
            } while ((paramInt2 != -1) || (paramIntent == null));
            showProgress("");
            paramIntent = paramIntent.getStringExtra("path");
          } while (TextUtils.isEmpty(paramIntent));
          u.d("JsBridgeWebActivity", "=========path:" + paramIntent);
          localObject1 = new File(paramIntent);
          if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
          {
            try
            {
              paramIntent = com.ziroom.ziroomcustomer.util.r.zoomImageWithQuality(new File(paramIntent), 2048);
              localObject1 = paramIntent;
              if (paramIntent != null) {
                break label436;
              }
              dismissProgress();
              return;
            }
            catch (FileNotFoundException paramIntent)
            {
              paramIntent.printStackTrace();
              localObject1 = localFile;
            }
            catch (IOException paramIntent)
            {
              paramIntent.printStackTrace();
              localObject1 = localFile;
            }
            finally
            {
              if (0 == 0)
              {
                dismissProgress();
                return;
              }
            }
          }
          else
          {
            com.freelxl.baselibrary.f.g.textToast(this, "当前图片不存在！");
            dismissProgress();
            return;
          }
          j.hyUploadImg(this, (File)localObject1, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
          {
            public void onFailure(Throwable paramAnonymousThrowable)
            {
              super.onFailure(paramAnonymousThrowable);
              com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
              locale.put("url", "");
              locale.put("message", paramAnonymousThrowable.getMessage());
              JsBridgeWebActivity.a(JsBridgeWebActivity.this).doCallH5("hyUploadImgResultUrl", locale);
              JsBridgeWebActivity.this.dismissProgress();
            }
            
            public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
              if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("url")))
              {
                locale.put("url", paramAnonymouse.getString("url"));
                locale.put("message", "success");
              }
              for (;;)
              {
                JsBridgeWebActivity.a(JsBridgeWebActivity.this).doCallH5("hyUploadImgResultUrl", locale);
                JsBridgeWebActivity.this.dismissProgress();
                return;
                locale.put("url", "");
                locale.put("message", "系统错误");
              }
            }
          });
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        showProgress("");
        paramIntent = paramIntent.getStringExtra("path");
      } while (TextUtils.isEmpty(paramIntent));
      u.d("JsBridgeWebActivity", "=========path:" + paramIntent);
      localObject1 = new File(paramIntent);
      if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
      {
        try
        {
          paramIntent = com.ziroom.ziroomcustomer.util.r.zoomImage(new File(paramIntent), 2048);
          localObject1 = paramIntent;
          if (paramIntent != null) {
            break label630;
          }
          dismissProgress();
          return;
        }
        catch (FileNotFoundException paramIntent)
        {
          paramIntent.printStackTrace();
          localObject1 = localObject2;
        }
        catch (IOException paramIntent)
        {
          paramIntent.printStackTrace();
          localObject1 = localObject2;
        }
        finally
        {
          if (0 == 0)
          {
            dismissProgress();
            return;
          }
        }
      }
      else
      {
        com.freelxl.baselibrary.f.g.textToast(this, "当前图片不存在！");
        dismissProgress();
        return;
      }
      j.hyUploadStuIdCard(this, (File)localObject1, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
          locale.put("url", "");
          locale.put("message", paramAnonymousThrowable.getMessage());
          JsBridgeWebActivity.a(JsBridgeWebActivity.this).doCallH5("hyUploadStuIdCardResultUrl", locale);
          JsBridgeWebActivity.this.dismissProgress();
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("url")))
          {
            locale.put("url", paramAnonymouse.getString("url"));
            locale.put("message", "success");
          }
          for (;;)
          {
            JsBridgeWebActivity.a(JsBridgeWebActivity.this).doCallH5("hyUploadStuIdCardResultUrl", locale);
            JsBridgeWebActivity.this.dismissProgress();
            return;
            locale.put("url", "");
            locale.put("message", "系统错误");
          }
        }
      });
      return;
    } while (((paramInt2 != 17) && (paramInt2 != -1)) || (this.M == null));
    this.M.sendResultOfPaymentToH5(2, "支付取消");
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903237);
    b();
  }
  
  protected void onDestroy()
  {
    if (this.N != null) {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.N);
    }
    if (this.R != null) {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.R);
    }
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    super.onDestroy();
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
    if (paramInt == 4)
    {
      if (this.a.canGoBack()) {
        this.a.goBack();
      }
      for (;;)
      {
        return true;
        if (this.E)
        {
          paramKeyEvent = new Intent(this, MainActivity.class);
          paramKeyEvent.putExtra("FRAGMENT_TYPE", this.K);
          startActivityAndFinish(paramKeyEvent);
        }
        else
        {
          finish();
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((this.F) && (this.G)) {
      this.a.reload();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public boolean showProgress(String paramString)
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
    com.freelxl.baselibrary.widget.a.show(this, paramString, false, true);
    return true;
  }
  
  public String toURLDecoded(String paramString)
  {
    if (ae.isNull(paramString)) {
      return "";
    }
    try
    {
      String str = URLDecoder.decode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      u.e("yangxj======", "toURLEncoded error:" + paramString + localException);
    }
    return "";
  }
  
  public static class a
  {
    private String a = "";
    private String b;
    private String c;
    private String d;
    private boolean e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private int j;
    private Context k;
    
    public a(Context paramContext, String paramString)
    {
      this.k = paramContext;
      this.a = paramString;
    }
    
    public a backMain(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public a getDataFromH5(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
    
    public a mainType(int paramInt)
    {
      this.j = paramInt;
      return this;
    }
    
    public a refresh(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public a shareContent(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a shareImg(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a showShare(boolean paramBoolean)
    {
      this.e = paramBoolean;
      u.d("#########", "isShow+++++++++" + this.e);
      return this;
    }
    
    public void starJsBridgeActivity()
    {
      Intent localIntent = new Intent(this.k, JsBridgeWebActivity.class);
      localIntent.putExtra("title", this.b);
      localIntent.putExtra("url", this.a);
      localIntent.putExtra("isShowShareLocal", this.e);
      localIntent.putExtra("shareContent", this.c);
      localIntent.putExtra("shareImg", this.d);
      localIntent.putExtra("isBackMain", this.f);
      localIntent.putExtra("isRefresh", this.g);
      localIntent.putExtra("isZoom", this.h);
      localIntent.putExtra("isGetH5Data", this.i);
      localIntent.putExtra("mainType", this.j);
      if (!(this.k instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      this.k.startActivity(localIntent);
    }
    
    public a supportZoom(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
    
    public a title(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
  
  @com.maa.android.agent.instrumentation.Instrumented
  class b
    extends com.freelxl.baselibrary.webview.c
  {
    public b(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((JsBridgeWebActivity.this.a.canGoBack()) && (!JsBridgeWebActivity.r(JsBridgeWebActivity.this)))
      {
        JsBridgeWebActivity.s(JsBridgeWebActivity.this).setVisibility(0);
        JsBridgeWebActivity.s(JsBridgeWebActivity.this).setOnClickListener(JsBridgeWebActivity.t(JsBridgeWebActivity.this));
      }
      for (;;)
      {
        paramWebView = JsBridgeWebActivity.this.a;
        if ((paramWebView instanceof WebView)) {
          break;
        }
        paramWebView.loadUrl("javascript:(function() { var videos = document.getElementsByTagName('video'); for(var i=0;i<videos.length;i++){videos[i].play();}})()");
        return;
        JsBridgeWebActivity.s(JsBridgeWebActivity.this).setVisibility(4);
      }
      WebviewInstrumentation.loadUrl((WebView)paramWebView, "javascript:(function() { var videos = document.getElementsByTagName('video'); for(var i=0;i<videos.length;i++){videos[i].play();}})()");
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!TextUtils.isEmpty(paramString)) {}
      label89:
      for (;;)
      {
        try
        {
          paramWebView = Uri.parse(paramString);
          if (paramWebView != null)
          {
            paramString = paramWebView.getQueryParameter("autoRefresh");
            paramBitmap = JsBridgeWebActivity.this;
            if (TextUtils.isEmpty(paramString)) {
              break label89;
            }
            if (!"false".equals(paramString))
            {
              break label89;
              JsBridgeWebActivity.a(paramBitmap, bool);
              JsBridgeWebActivity.b(JsBridgeWebActivity.this, "true".equals(paramWebView.getQueryParameter("disableAppBack")));
            }
          }
          else
          {
            return;
          }
          boolean bool = false;
          continue;
          bool = true;
        }
        catch (Exception paramWebView)
        {
          return;
        }
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (paramSslError.getPrimaryError() == 5)
      {
        if (b.isSSLCertOk(paramSslError.getCertificate(), b.a)) {
          paramSslErrorHandler.proceed();
        }
        paramWebView = Uri.parse(JsBridgeWebActivity.h(JsBridgeWebActivity.this));
        if ((paramWebView != null) && (paramWebView.getHost() != null) && (!paramWebView.getHost().contains("ziroom.com"))) {
          paramSslErrorHandler.proceed();
        }
        return;
      }
      paramSslErrorHandler.cancel();
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
      if (paramWebResourceRequest.getUrl().toString().endsWith("WebViewJavascriptBridge.js")) {
        try
        {
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", JsBridgeWebActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
          return paramWebResourceRequest;
        }
        catch (IOException paramWebResourceRequest)
        {
          paramWebResourceRequest.printStackTrace();
        }
      }
      return paramWebView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/JsBridgeWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */