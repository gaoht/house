package com.ziroom.ziroomcustomer.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;

public class d
  extends WebChromeClient
{
  public ValueCallback<Uri> a;
  public ValueCallback<Uri[]> b;
  Activity c;
  
  public d(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  private void a(ValueCallback<Uri> paramValueCallback)
  {
    this.a = paramValueCallback;
    paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback.addCategory("android.intent.category.OPENABLE");
    paramValueCallback.setType("image/*");
    this.c.startActivityForResult(Intent.createChooser(paramValueCallback, "完成操作需要使用"), 1);
  }
  
  public ValueCallback<Uri> getUploadMsg()
  {
    return this.a;
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.b = paramValueCallback;
    paramWebView = new Intent("android.intent.action.GET_CONTENT");
    paramWebView.addCategory("android.intent.category.OPENABLE");
    paramWebView.setType("*/*");
    this.c.startActivityForResult(Intent.createChooser(paramWebView, "File Chooser"), 1);
    return true;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    a(paramValueCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    a(paramValueCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    a(paramValueCallback);
  }
  
  public void setUploadMsg(ValueCallback<Uri> paramValueCallback)
  {
    this.a = paramValueCallback;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */