package com.tencent.smtt.sdk;

final class i
  implements TbsListener
{
  public void onDownloadFinish(int paramInt)
  {
    TbsDownloader.a = false;
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadFinish(paramInt);
    }
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadFinish(paramInt);
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadProgress(paramInt);
    }
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadProgress(paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.a = false;
    if (QbSdk.c() != null) {
      QbSdk.c().onInstallFinish(paramInt);
    }
    if (QbSdk.d() != null) {
      QbSdk.d().onInstallFinish(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */