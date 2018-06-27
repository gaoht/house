package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;

public abstract class LogsCollector
  implements LogCollector, ProtectedMemberKeeper, PublicMemberKeeper
{
  private c a = c.a();
  private boolean b;
  
  public LogsCollector()
  {
    this.a.a(getSDKVersion(), getSDKTag());
    try
    {
      if (MobSDK.getContext().getPackageManager().getPackageInfo("cn.sharesdk.log", 64) != null) {
        this.b = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      this.b = false;
    }
  }
  
  final int a(int paramInt, String paramString)
  {
    if ((MobSDK.getContext() != null) && (this.b)) {}
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("cn.sharesdk.log");
      String str = MobSDK.getContext().getPackageName();
      localIntent.putExtra("package", str);
      localIntent.putExtra("priority", paramInt);
      localIntent.putExtra("msg", Data.AES128Encode(str, paramString));
      MobSDK.getContext().sendBroadcast(localIntent);
      return 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramString);
      }
    }
  }
  
  protected abstract String getSDKTag();
  
  protected abstract int getSDKVersion();
  
  public final void log(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    a(paramInt1, paramString3);
    if ((paramString1 == null) || (!paramString1.equals(getSDKTag()))) {}
    do
    {
      do
      {
        return;
      } while (("SHARESDK".equals(paramString1)) && ((!paramString3.contains("com.mob.")) || (!paramString3.contains("cn.sharesdk."))));
      if (paramInt2 == 1)
      {
        this.a.b(getSDKVersion(), paramInt2, paramString1, paramString3);
        return;
      }
      if (paramInt2 == 2)
      {
        this.a.a(getSDKVersion(), paramInt2, paramString1, paramString3);
        return;
      }
    } while (paramInt1 != 5);
    this.a.a(getSDKVersion(), paramInt2, paramString1, paramString3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/logcollector/LogsCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */