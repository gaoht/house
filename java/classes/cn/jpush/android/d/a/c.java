package cn.jpush.android.d.a;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
public class c
  extends WebChromeClient
{
  private static final String[] z;
  private final String a = z[1];
  private d b;
  private boolean c;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "N<;~\rbr;hN<%~\034p32~Nu=<k\002s&4w\0276=?;\036d=6i\013e!q";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 27;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "'x84x\032s6\022s\034y?4X\0027?o";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 110;
        break label99;
        i = 22;
        break label99;
        i = 82;
        break label99;
        i = 81;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public c(String paramString, Class paramClass)
  {
    this.b = new d(paramString, paramClass);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramJsResult.confirm();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramJsPromptResult.confirm(this.b.a(paramWebView, paramString2));
    return true;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt <= 25) {
      this.c = false;
    }
    while (this.c)
    {
      super.onProgressChanged(paramWebView, paramInt);
      return;
    }
    String str = this.b.a();
    if (!(paramWebView instanceof WebView)) {
      paramWebView.loadUrl(str);
    }
    for (;;)
    {
      this.c = true;
      Log.d(z[1], z[0] + paramInt);
      break;
      WebviewInstrumentation.loadUrl((WebView)paramWebView, str);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */