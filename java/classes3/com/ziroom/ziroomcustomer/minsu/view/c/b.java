package com.ziroom.ziroomcustomer.minsu.view.c;

import android.content.Context;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;

public class b
  extends WebChromeClient
{
  private Context a;
  private d b;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    com.freelxl.baselibrary.f.d.d("lanzhihong", "newProgress==" + paramInt);
    if (paramInt == 100) {
      ((MinsuWebActivity)this.a).dismissProgress();
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if (this.b != null) {
      this.b.onReceiverTitle(paramString);
    }
  }
  
  public void setTitleListener(d paramd)
  {
    this.b = paramd;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */