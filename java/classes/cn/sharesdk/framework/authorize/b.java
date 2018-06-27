package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.d;

public abstract class b
  extends d
{
  protected e activity;
  protected AuthorizeListener listener;
  protected String redirectUri;
  
  public b(e parame)
  {
    this.activity = parame;
    parame = parame.a();
    this.redirectUri = parame.getRedirectUri();
    this.listener = parame.getAuthorizeListener();
  }
  
  protected abstract void onComplete(String paramString);
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.stopLoading();
    paramWebView = this.activity.a().getAuthorizeListener();
    this.activity.finish();
    if (paramWebView != null) {
      paramWebView.onError(new Throwable(paramString1 + " (" + paramInt + "): " + paramString2));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */