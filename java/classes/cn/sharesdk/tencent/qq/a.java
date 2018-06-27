package cn.sharesdk.tencent.qq;

import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.tools.log.NLog;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;

@Instrumented
public class a
  extends cn.sharesdk.framework.authorize.b
{
  public a(cn.sharesdk.framework.authorize.e parame)
  {
    super(parame);
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("access_token");
    String str2 = (String)paramHashMap.get("expires_in");
    Object localObject1 = (String)paramHashMap.get("error");
    Object localObject2 = (String)paramHashMap.get("error_description");
    String str3 = (String)paramHashMap.get("pf");
    String str4 = (String)paramHashMap.get("pfkey");
    paramHashMap = (String)paramHashMap.get("pay_token");
    if (!TextUtils.isEmpty(str1))
    {
      try
      {
        localObject1 = b.a(this.activity.a().getPlatform()).c(str1);
        if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0))
        {
          if (this.listener == null) {
            return;
          }
          this.listener.onError(new Throwable());
          return;
        }
        if (((HashMap)localObject1).containsKey("openid")) {
          break label192;
        }
        if (this.listener == null) {
          return;
        }
        this.listener.onError(new Throwable());
        return;
      }
      catch (Throwable paramHashMap)
      {
        if (this.listener == null) {
          return;
        }
      }
      this.listener.onError(paramHashMap);
      return;
      label192:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("access_token", str1);
      ((Bundle)localObject2).putString("open_id", String.valueOf(((HashMap)localObject1).get("openid")));
      ((Bundle)localObject2).putString("expires_in", str2);
      ((Bundle)localObject2).putString("pf", str3);
      ((Bundle)localObject2).putString("pfkey", str4);
      ((Bundle)localObject2).putString("pay_token", paramHashMap);
      if (this.listener != null) {
        this.listener.onComplete((Bundle)localObject2);
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramHashMap = (String)localObject2 + " (" + (String)localObject1 + ")";
      if (this.listener != null) {
        this.listener.onError(new Throwable(paramHashMap));
      }
    }
    else
    {
      this.listener.onError(new Throwable());
    }
  }
  
  protected void onComplete(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith(this.redirectUri)) {
      localObject = paramString.substring(paramString.indexOf('#') + 1);
    }
    localObject = ((String)localObject).split("&");
    HashMap localHashMap = new HashMap();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString = localObject[i].split("=");
      if (paramString.length < 2)
      {
        localHashMap.put(URLDecoder.decode(paramString[0]), "");
        i += 1;
      }
      else
      {
        String str = URLDecoder.decode(paramString[0]);
        if (paramString[1] == null) {}
        for (paramString = "";; paramString = paramString[1])
        {
          localHashMap.put(str, URLDecoder.decode(paramString));
          break;
        }
      }
    }
    a(localHashMap);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    try
    {
      paramWebView = paramSslErrorHandler.getClass().getMethod("proceed", new Class[0]);
      paramWebView.setAccessible(true);
      paramWebView.invoke(paramSslErrorHandler, new Object[0]);
      return;
    }
    catch (Throwable paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, final String paramString)
  {
    if (paramString.startsWith(this.redirectUri))
    {
      paramWebView.setVisibility(4);
      paramWebView.stopLoading();
      this.activity.finish();
      new Thread()
      {
        public void run()
        {
          try
          {
            a.this.onComplete(paramString);
            return;
          }
          catch (Throwable localThrowable)
          {
            cn.sharesdk.framework.utils.e.b().d(localThrowable);
          }
        }
      }.start();
      return true;
    }
    if (!(paramWebView instanceof WebView))
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
    WebviewInstrumentation.loadUrl((WebView)paramWebView, paramString);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */