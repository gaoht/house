package com.tencent.smtt.sdk;

import android.content.Intent;

class x
  extends WebChromeClient.FileChooserParams
{
  x(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.a.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.a.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.a.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.a.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.a.isCaptureEnabled();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */