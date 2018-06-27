package cn.jpush.android.d.a;

import android.text.TextUtils.TruncateAt;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class a
  extends c
{
  private ProgressBar a;
  private TextView b;
  
  public a(String paramString, Class paramClass, ProgressBar paramProgressBar, TextView paramTextView)
  {
    super(paramString, paramClass);
    this.a = paramProgressBar;
    this.b = paramTextView;
    if (this.a != null) {
      this.a.setMax(100);
    }
    if (this.b != null)
    {
      this.b.setSingleLine(true);
      this.b.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (this.a != null)
    {
      if (100 != paramInt) {
        break label71;
      }
      this.a.setVisibility(8);
    }
    for (;;)
    {
      if ((this.b != null) && (paramWebView.getTitle() != null) && (!paramWebView.getTitle().equals(this.b.getText()))) {
        this.b.setText(paramWebView.getTitle());
      }
      return;
      label71:
      this.a.setVisibility(0);
      this.a.setProgress(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */