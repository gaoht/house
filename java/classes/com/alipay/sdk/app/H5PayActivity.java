package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class H5PayActivity
  extends Activity
{
  private WebView a;
  private WebViewClient b;
  
  public void a()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void finish()
  {
    a();
    super.finish();
  }
  
  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      if (((c)this.b).c)
      {
        j localj = j.a(j.d.h);
        i.a = i.a(localj.h, localj.i, "");
        finish();
      }
      return;
    }
    i.a = i.a();
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokespecial 89	android/app/Activity:requestWindowFeature	(I)Z
    //   5: pop
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 91	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   11: aload_0
    //   12: invokevirtual 95	com/alipay/sdk/app/H5PayActivity:getIntent	()Landroid/content/Intent;
    //   15: invokevirtual 101	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 103
    //   22: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: invokestatic 114	com/alipay/sdk/j/k:b	(Ljava/lang/String;)Z
    //   30: ifne +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 74	com/alipay/sdk/app/H5PayActivity:finish	()V
    //   37: return
    //   38: aload_2
    //   39: ldc 116
    //   41: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_0
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: invokestatic 119	com/alipay/sdk/j/k:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Landroid/webkit/WebView;
    //   52: putfield 33	com/alipay/sdk/app/H5PayActivity:a	Landroid/webkit/WebView;
    //   55: aload_0
    //   56: new 43	com/alipay/sdk/app/c
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 122	com/alipay/sdk/app/c:<init>	(Landroid/app/Activity;)V
    //   64: putfield 41	com/alipay/sdk/app/H5PayActivity:b	Landroid/webkit/WebViewClient;
    //   67: aload_0
    //   68: getfield 33	com/alipay/sdk/app/H5PayActivity:a	Landroid/webkit/WebView;
    //   71: aload_0
    //   72: getfield 41	com/alipay/sdk/app/H5PayActivity:b	Landroid/webkit/WebViewClient;
    //   75: invokevirtual 126	android/webkit/WebView:setWebViewClient	(Landroid/webkit/WebViewClient;)V
    //   78: return
    //   79: astore_1
    //   80: ldc -128
    //   82: ldc -126
    //   84: aload_1
    //   85: invokestatic 135	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: invokevirtual 74	com/alipay/sdk/app/H5PayActivity:finish	()V
    //   92: return
    //   93: astore_1
    //   94: aload_0
    //   95: invokevirtual 74	com/alipay/sdk/app/H5PayActivity:finish	()V
    //   98: return
    //   99: astore_2
    //   100: goto -94 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	H5PayActivity
    //   0	103	1	paramBundle	android.os.Bundle
    //   18	31	2	localObject	Object
    //   99	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	78	79	java/lang/Throwable
    //   11	37	93	java/lang/Exception
    //   38	45	93	java/lang/Exception
    //   0	6	99	java/lang/Throwable
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.removeAllViews();
      ((ViewGroup)this.a.getParent()).removeAllViews();
    }
    try
    {
      this.a.destroy();
      this.a = null;
      if (this.b != null)
      {
        c localc = (c)this.b;
        localc.b = null;
        localc.a = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/app/H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */