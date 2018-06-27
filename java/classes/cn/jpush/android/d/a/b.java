package cn.jpush.android.d.a;

import android.webkit.WebView;

public class b
{
  private static final String TAG;
  private static f mWebViewHelper;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    int m = 0;
    Object localObject1 = arrayOfString;
    Object localObject2 = "b_\036EmYc\016^WO";
    int i = 1;
    int j;
    int k;
    Object localObject4;
    int n;
    int i1;
    for (;;)
    {
      localObject2 = ((String)localObject2).toCharArray();
      j = localObject2.length;
      if (j > 1) {
        break label283;
      }
      k = 0;
      localObject4 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = i;
      label50:
      m = k;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 39;
          label99:
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label142;
          }
          k = j;
        }
      }
      TAG = (String)localObject1;
      localObject2 = "}U\017gNOG%TKZU\037";
      i = -1;
      m = i2;
      localObject1 = localObject3;
    }
    label142:
    i = j;
    Object localObject3 = localObject4;
    int i2 = n;
    localObject2 = localObject1;
    int i3 = i1;
    for (;;)
    {
      i1 = i3;
      localObject1 = localObject2;
      n = i2;
      localObject4 = localObject3;
      j = i;
      k = m;
      if (i > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      case 1: 
      default: 
        localObject3[i2] = localObject1;
        localObject2 = "GC\ne^ZUMWUE]MFBH\nM";
        m = 1;
        localObject1 = arrayOfString;
        i = 0;
        break;
      case 0: 
        localObject3[i2] = localObject1;
        z = arrayOfString;
        return;
        i = 42;
        break label99;
        i = 48;
        break label99;
        i = 109;
        break label99;
        i = 49;
        break label99;
        label283:
        k = 0;
        i3 = i;
        i2 = m;
        localObject3 = localObject1;
        i = j;
        m = k;
      }
    }
  }
  
  public static void click(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.b(paramString1, paramString2, paramString3);
  }
  
  public static void close(WebView paramWebView)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.a();
  }
  
  public static void createShortcut(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.a(paramString1, paramString2, paramString3);
  }
  
  public static void download(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.c(paramString);
  }
  
  public static void download(WebView paramWebView, String paramString1, String paramString2)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.c(paramString1, paramString2);
  }
  
  public static void download(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (mWebViewHelper == null) {
      return;
    }
    paramWebView = mWebViewHelper;
    cn.jpush.android.c.f.a(z[0], z[1] + paramString3);
    paramWebView.c(paramString1, paramString2);
  }
  
  public static void executeMsgMessage(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.e(paramString);
  }
  
  public static void setWebViewHelper(f paramf)
  {
    if (paramf == null) {
      return;
    }
    mWebViewHelper = paramf;
  }
  
  public static void showTitleBar(WebView paramWebView)
  {
    if (mWebViewHelper != null) {
      mWebViewHelper.b();
    }
  }
  
  public static void showToast(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.d(paramString);
  }
  
  public static void startActivityByIntent(WebView paramWebView, String paramString1, String paramString2)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.b(paramString1, paramString2);
  }
  
  public static void startActivityByName(WebView paramWebView, String paramString1, String paramString2)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.a(paramString1, paramString2);
  }
  
  public static void startActivityByNameWithSystemAlert(WebView paramWebView, String paramString1, String paramString2)
  {
    if (cn.jpush.android.api.e.a == null) {
      return;
    }
    cn.jpush.android.api.e.a.a(paramString1, paramString2);
  }
  
  public static void startMainActivity(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.b(paramString);
  }
  
  public static void startPushActivity(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper != null) {
      mWebViewHelper.f(paramString);
    }
  }
  
  public static void triggerNativeAction(WebView paramWebView, String paramString)
  {
    if (mWebViewHelper == null) {
      return;
    }
    mWebViewHelper.a(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */