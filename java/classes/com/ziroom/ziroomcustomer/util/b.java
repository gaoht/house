package com.ziroom.ziroomcustomer.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;

public class b
{
  public static String getEmuiVersion()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "ro.build.version.emui" });
      Log.d("AndroidRomUtil", "get EMUI version is:" + (String)localObject);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {
        return (String)localObject;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("AndroidRomUtil", " getEmuiVersion wrong, ClassNotFoundException");
      return "";
    }
    catch (LinkageError localLinkageError)
    {
      for (;;)
      {
        Log.e("AndroidRomUtil", " getEmuiVersion wrong, LinkageError");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("AndroidRomUtil", " getEmuiVersion wrong, NoSuchMethodException");
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Log.e("AndroidRomUtil", " getEmuiVersion wrong, NullPointerException");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("AndroidRomUtil", " getEmuiVersion wrong");
      }
    }
  }
  
  public static int getPushChannel()
  {
    if (isMIUI()) {
      return 2;
    }
    return 1;
  }
  
  public static boolean isEMUI()
  {
    return !"".equals(getEmuiVersion());
  }
  
  public static boolean isFlyme()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isMIUI()
  {
    boolean bool = false;
    try
    {
      Object localObject = i.newInstance();
      if ((((i)localObject).getProperty("ro.miui.ui.version.code", null) == null) && (((i)localObject).getProperty("ro.miui.ui.version.name", null) == null))
      {
        localObject = ((i)localObject).getProperty("ro.miui.internal.storage", null);
        if (localObject == null) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  public static boolean isXiaoMi()
  {
    return "Xiaomi".equals(Build.MANUFACTURER);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */