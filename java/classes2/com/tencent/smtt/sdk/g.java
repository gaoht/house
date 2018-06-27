package com.tencent.smtt.sdk;

import android.content.Context;

final class g
  implements TbsListener
{
  g(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onDownloadFinish(int paramInt) {}
  
  public void onDownloadProgress(int paramInt) {}
  
  public void onInstallFinish(int paramInt)
  {
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */