package com.tencent.smtt.sdk;

import android.graphics.Picture;

class bd
  implements android.webkit.WebView.PictureListener
{
  bd(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    this.b.a(paramWebView);
    this.a.onNewPicture(this.b, paramPicture);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */