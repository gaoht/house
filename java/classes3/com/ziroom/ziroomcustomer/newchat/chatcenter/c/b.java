package com.ziroom.ziroomcustomer.newchat.chatcenter.c;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;

public class b
  extends WebChromeClient
{
  public ValueCallback<Uri> b;
  public ValueCallback<Uri[]> c;
  Activity d;
  
  public b(Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  private void a(ValueCallback<Uri> paramValueCallback)
  {
    this.b = paramValueCallback;
    paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback.addCategory("android.intent.category.OPENABLE");
    paramValueCallback.setType("image/*");
    this.d.startActivityForResult(Intent.createChooser(paramValueCallback, "完成操作需要使用"), 1);
  }
  
  public ValueCallback<Uri> getUploadMsg()
  {
    return this.b;
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.c = paramValueCallback;
    if ((paramFileChooserParams.getAcceptTypes() != null) && (paramFileChooserParams.getAcceptTypes().length > 0) && (paramFileChooserParams.getAcceptTypes()[0].length() > 0))
    {
      paramWebView = new Intent("android.media.action.IMAGE_CAPTURE");
      if (Build.VERSION.SDK_INT >= 24) {
        paramWebView.addFlags(1);
      }
      this.d.startActivityForResult(paramWebView, 2);
      return true;
    }
    paramWebView = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    this.d.startActivityForResult(paramWebView, 1);
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
    this.b = paramValueCallback;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */