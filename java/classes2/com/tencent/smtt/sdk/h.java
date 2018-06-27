package com.tencent.smtt.sdk;

import android.content.Context;

final class h
  implements TbsDownloader.TbsDownloaderCallback
{
  h(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((TbsShareManager.findCoreForThirdPartyApp(this.a) == 0) && (!TbsShareManager.getCoreDisabled()))
    {
      TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
      return;
    }
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */