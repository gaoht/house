package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bf
  extends Thread
{
  public void run()
  {
    if (WebView.f() == null) {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
    }
    k localk;
    int i;
    int j;
    do
    {
      return;
      localk = k.a(true);
      if (k.a)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      ad localad = ad.a(WebView.f());
      i = localad.c();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        localk.a(String.valueOf(localad.b()));
        localk.b(true);
        return;
      }
      j = localad.b("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        localk.a(String.valueOf(localad.c("copy_core_ver")));
        localk.b(true);
        return;
      }
    } while ((bg.b().c()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    localk.a(String.valueOf(k.d()));
    localk.b(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */