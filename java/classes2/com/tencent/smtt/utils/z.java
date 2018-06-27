package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class z
{
  private static File a = null;
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      if (a == null) {
        try
        {
          if (paramContext.getApplicationInfo().processName.contains("com.tencent.mm"))
          {
            paramContext = paramContext.getDir("tbs", 0);
            if ((paramContext != null) && (paramContext.isDirectory()))
            {
              paramContext = new File(paramContext, "share");
              if (paramContext != null)
              {
                if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
                  continue;
                }
                a = paramContext;
                paramContext.setExecutable(true, false);
                return true;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */