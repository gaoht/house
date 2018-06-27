package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m.a;

final class af
  implements m.a
{
  af(boolean paramBoolean, TbsDownloadConfig paramTbsDownloadConfig) {}
  
  public void a(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramInt);
    if (paramInt >= 300)
    {
      if (this.a) {
        this.b.setDownloadInterruptCode(-107);
      }
    }
    else {
      return;
    }
    this.b.setDownloadInterruptCode(65329);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */