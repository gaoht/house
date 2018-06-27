package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

class bb
  implements WebView.FindListener
{
  bb(WebView paramWebView, IX5WebViewBase.FindListener paramFindListener) {}
  
  public void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */