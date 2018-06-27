package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class q
  extends WebChromeClient.FileChooserParams
{
  q(m paramm, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */