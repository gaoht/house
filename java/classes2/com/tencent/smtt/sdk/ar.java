package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m.a;

class ar
  implements m.a
{
  ar(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramInt);
    if (paramInt < 300) {
      TbsLogReport.a(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */