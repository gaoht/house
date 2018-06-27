package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j
{
  private static Context a;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext.getApplicationContext();
  }
  
  public static String b()
  {
    String str2 = e.c(a);
    String str1 = str2;
    if (str2 == null) {
      str1 = e.e(a);
    }
    if (str1 != null) {
      try
      {
        str1 = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(str1.getBytes()), 8).substring(0, 16);
        return str1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        b.a(localNoSuchAlgorithmException);
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      if ((i & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
  
  public static int c()
  {
    try
    {
      Class localClass = Class.forName("miui.os.Build");
      if (localClass.getField("IS_STABLE_VERSION").getBoolean(null)) {
        return 3;
      }
      boolean bool = localClass.getField("IS_DEVELOPMENT_VERSION").getBoolean(null);
      if (bool) {
        return 2;
      }
      return 1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static boolean d()
  {
    return TextUtils.equals((String)a.a("android.os.SystemProperties", "get", new Object[] { "sys.boot_completed" }), "1");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */