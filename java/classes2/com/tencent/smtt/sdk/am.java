package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.File;

class am
  extends Thread
{
  am(ai paramai, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      File localFile1 = this.c.g(this.a);
      File localFile2 = this.c.g(this.b);
      j.a(localFile1, localFile2, new an(this));
      j.a(localFile1, localFile2, new ao(this));
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */