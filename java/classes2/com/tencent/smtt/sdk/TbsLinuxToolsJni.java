package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static boolean a = false;
  private static boolean b = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    a(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (b) {
          return;
        }
        b = true;
      }
      finally {}
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label94;
        }
        paramContext = new File(TbsShareManager.b(paramContext));
        if (paramContext != null)
        {
          System.load(paramContext.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
          a = true;
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        label94:
        paramContext.printStackTrace();
        a = false;
        continue;
      }
      return;
      paramContext = ai.a().g(paramContext);
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsLinuxToolsJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */