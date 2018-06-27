package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.ResHelper;
import java.io.File;

public class c
{
  public static File a(String paramString)
  {
    try
    {
      paramString = ResHelper.getCacheRootFile(MobSDK.getContext(), paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a(File paramFile, LockAction paramLockAction)
  {
    return a(paramFile, true, paramLockAction);
  }
  
  private static boolean a(File arg0, boolean paramBoolean, LockAction paramLockAction)
  {
    try
    {
      if (!???.getParentFile().exists()) {
        ???.getParentFile().mkdirs();
      }
      if (!???.exists()) {
        ???.createNewFile();
      }
      String str = ???.getAbsolutePath();
      synchronized (b(str))
      {
        FileLocker localFileLocker = new FileLocker();
        localFileLocker.setLockFile(str);
        if (localFileLocker.lock(paramBoolean))
        {
          if (!paramLockAction.run(localFileLocker)) {
            localFileLocker.release();
          }
        }
        else {
          return false;
        }
      }
      return true;
    }
    catch (Throwable ???)
    {
      MobLog.getInstance().w(???);
    }
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith("comm/locks/.globalLock")) {
        break label23;
      }
      str = "comm/locks/.globalLock";
    }
    label23:
    do
    {
      return str;
      if (paramString.endsWith("comm/locks/.dhlock")) {
        return "comm/locks/.dhlock";
      }
      if (paramString.endsWith("comm/locks/.mrlock")) {
        return "comm/locks/.mrlock";
      }
      if (paramString.endsWith("comm/locks/.rc_lock")) {
        return "comm/locks/.rc_lock";
      }
      if (paramString.endsWith("comm/locks/.artc_lock")) {
        return "comm/locks/.artc_lock";
      }
      if (paramString.endsWith("comm/locks/.lesd_lock")) {
        return "comm/locks/.lesd_lock";
      }
      if (paramString.endsWith("comm/locks/.dic_lock")) {
        return "comm/locks/.dic_lock";
      }
      if (paramString.endsWith("comm/locks/.pkg_lock")) {
        return "comm/locks/.pkg_lock";
      }
      str = paramString;
    } while (!paramString.endsWith("comm/locks/.ss_lock"));
    return "comm/locks/.ss_lock";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */