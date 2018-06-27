package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.data.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
public class FullScreenView
  extends LinearLayout
{
  private static final String TAG;
  public static cn.jpush.android.d.a.f webViewHelper;
  private static final String[] z;
  private View.OnClickListener btnBackClickListener = new a(this);
  private ImageButton imgBtnBack;
  private final Context mContext;
  private WebView mWebView;
  private ProgressBar pushPrograssBar;
  private RelativeLayout rlTitleBar;
  private TextView tvTitle;
  
  static
  {
    String[] arrayOfString = new String[11];
    int j = 0;
    Object localObject2 = "O>s\fZj9z\005g_\"z\027";
    int i = 10;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    localObject2 = arrayOfChar;
    int i3 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label69:
      n = m;
      label72:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 9;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label72;
        TAG = (String)localObject1;
        localObject2 = "e$~\004\\{'%";
        i = -1;
        j = i3;
        localObject1 = localObject3;
        break;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i3 = j;
      localObject2 = localObject1;
      i4 = i2;
      i2 = i4;
      localObject1 = localObject2;
      j = i3;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label69;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i4)
      {
      case 10: 
      default: 
        localObject3[i3] = localObject1;
        j = 1;
        localObject2 = "`/";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i3] = localObject1;
        j = 2;
        localObject2 = "C\033j\023a^.}";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i3] = localObject1;
        j = 3;
        localObject2 = "y>l\bY{$x\022hz8]\001{";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i3] = localObject1;
        j = 4;
        localObject2 = "z.~\022ja\tp\030Ch=~\"{`/x\005V";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i3] = localObject1;
        j = 5;
        localObject2 = "Y'z\001zlkj\023l)/z\006h|'k@jf/z@`gku\020|z#@\027lk=v\005~V'~\031f|?1\030dej";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i3] = localObject1;
        j = 6;
        localObject2 = "o>s\f^l)I\tl~";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i3] = localObject1;
        j = 7;
        localObject2 = "`&x2`j#o\025za\tk\016Kh(t";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i3] = localObject1;
        j = 8;
        localObject2 = "}=M\tja;j\023a]\"k\fl";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i3] = localObject1;
        j = 9;
        localObject2 = "{'M\tja;j\023a]\"k\flK*m";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i3] = localObject1;
        j = 10;
        localObject2 = "x>v\024O|'s3j{.z\016)l9m\016f";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i3] = localObject1;
        z = arrayOfString;
        webViewHelper = null;
        return;
        i = 9;
        continue;
        i = 75;
        continue;
        i = 31;
        continue;
        i = 96;
      }
    }
  }
  
  public FullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void quitFullScreen()
  {
    try
    {
      WindowManager.LayoutParams localLayoutParams = ((Activity)this.mContext).getWindow().getAttributes();
      localLayoutParams.flags &= 0xFBFF;
      ((Activity)this.mContext).getWindow().setAttributes(localLayoutParams);
      ((Activity)this.mContext).getWindow().clearFlags(512);
      return;
    }
    catch (Exception localException)
    {
      cn.jpush.android.c.f.g(TAG, z[10]);
    }
  }
  
  public void destory()
  {
    removeAllViews();
    if (this.mWebView != null)
    {
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
      this.mWebView = null;
    }
  }
  
  public void initModule(Context paramContext, cn.jpush.android.data.c paramc)
  {
    Object localObject = (h)paramc;
    String str = ((h)localObject).H;
    setFocusable(true);
    this.mWebView = ((WebView)findViewById(getResources().getIdentifier(z[6], z[1], paramContext.getPackageName())));
    this.rlTitleBar = ((RelativeLayout)findViewById(getResources().getIdentifier(z[9], z[1], paramContext.getPackageName())));
    this.tvTitle = ((TextView)findViewById(getResources().getIdentifier(z[8], z[1], paramContext.getPackageName())));
    this.imgBtnBack = ((ImageButton)findViewById(getResources().getIdentifier(z[7], z[1], paramContext.getPackageName())));
    this.pushPrograssBar = ((ProgressBar)findViewById(getResources().getIdentifier(z[3], z[1], paramContext.getPackageName())));
    if ((this.mWebView == null) || (this.rlTitleBar == null) || (this.tvTitle == null) || (this.imgBtnBack == null))
    {
      cn.jpush.android.c.f.j(TAG, z[5]);
      ((Activity)this.mContext).finish();
    }
    if (1 == ((h)localObject).J)
    {
      this.rlTitleBar.setVisibility(8);
      ((Activity)paramContext).getWindow().setFlags(1024, 1024);
      this.mWebView.setScrollbarFadingEnabled(true);
      this.mWebView.setScrollBarStyle(33554432);
      cn.jpush.android.c.a.a(this.mWebView.getSettings());
      webViewHelper = new cn.jpush.android.d.a.f(paramContext, paramc);
      if (Build.VERSION.SDK_INT >= 11) {
        this.mWebView.removeJavascriptInterface(z[4]);
      }
      paramContext = this.mWebView;
      localObject = new cn.jpush.android.d.a.a(z[2], cn.jpush.android.d.a.b.class, this.pushPrograssBar, this.tvTitle);
      if ((paramContext instanceof WebView)) {
        break label406;
      }
      paramContext.setWebChromeClient((WebChromeClient)localObject);
    }
    for (;;)
    {
      this.mWebView.setWebViewClient(new c(paramc));
      cn.jpush.android.d.a.b.setWebViewHelper(webViewHelper);
      return;
      this.tvTitle.setText(str);
      this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
      break;
      label406:
      VdsAgent.setWebChromeClient((WebView)paramContext, (WebChromeClient)localObject);
    }
  }
  
  public void loadUrl(String paramString)
  {
    WebView localWebView;
    if (this.mWebView != null)
    {
      cn.jpush.android.c.f.c(TAG, z[0] + paramString);
      localWebView = this.mWebView;
      if (!(localWebView instanceof WebView)) {
        localWebView.loadUrl(paramString);
      }
    }
    else
    {
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localWebView, paramString);
  }
  
  public void pause()
  {
    if ((this.mWebView != null) && (Build.VERSION.SDK_INT >= 11)) {
      this.mWebView.onPause();
    }
  }
  
  public void resume()
  {
    if (this.mWebView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.mWebView.onResume();
      }
      cn.jpush.android.d.a.b.setWebViewHelper(webViewHelper);
    }
  }
  
  public void showTitleBar()
  {
    if ((this.rlTitleBar != null) && (this.rlTitleBar.getVisibility() == 8))
    {
      this.rlTitleBar.setVisibility(0);
      quitFullScreen();
      this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
      if (this.mWebView != null) {
        this.mWebView.postDelayed(new b(this), 1000L);
      }
    }
  }
  
  public boolean webviewCanGoBack()
  {
    if (this.mWebView != null) {
      return this.mWebView.canGoBack();
    }
    return false;
  }
  
  public void webviewGoBack()
  {
    if (this.mWebView != null) {
      this.mWebView.goBack();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/FullScreenView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */