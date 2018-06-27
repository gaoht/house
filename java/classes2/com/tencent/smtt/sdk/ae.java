package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class ae
  extends Handler
{
  ae(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        bool = TbsDownloader.a(true, false);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool);
          if ((!bool) || (i != 0)) {
            ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
          }
        }
        if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.a())) || (!bool)) {
          break;
        }
        TbsDownloader.startDownload(TbsDownloader.a());
        return;
      }
    case 101: 
      Object localObject1 = null;
      Object localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
      FileOutputStream localFileOutputStream = j.b(TbsDownloader.a(), false, (String)localObject2);
      if (localFileOutputStream != null)
      {
        localObject2 = j.a(TbsDownloader.a(), localFileOutputStream);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65333);
        }
      }
      else if (j.a(TbsDownloader.a()))
      {
        TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65332);
        return;
      }
      if (paramMessage.arg1 == 1)
      {
        paramMessage = TbsDownloadConfig.getInstance(TbsDownloader.a());
        if (!TbsDownloader.a(false, bool)) {
          break label426;
        }
        if ((!bool) || (!ai.a().a(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
          break label376;
        }
        QbSdk.j.onDownloadFinish(122);
        paramMessage.setDownloadInterruptCode(65323);
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "------freeFileLock called :");
        j.a((FileLock)localObject1, localFileOutputStream);
        return;
        bool = false;
        break;
        if (paramMessage.mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65321);
          TbsDownloader.b().a(bool);
        }
        else
        {
          QbSdk.j.onDownloadFinish(110);
          continue;
          QbSdk.j.onDownloadFinish(110);
        }
      }
    case 102: 
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
      if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
      for (i = TbsShareManager.a(TbsDownloader.a(), false);; i = ai.a().e(TbsDownloader.a()))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
        TbsDownloader.b().a(i);
        TbsLogReport.a(TbsDownloader.a()).b();
        return;
      }
    case 104: 
      label376:
      label426:
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
      TbsLogReport.a(TbsDownloader.a()).a();
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
    if (paramMessage.arg1 == 0)
    {
      ai.a().a((Context)paramMessage.obj, true);
      return;
    }
    ai.a().a((Context)paramMessage.obj, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */