package com.pgyersdk.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  private static String a = "Utils";
  private static m b = null;
  
  public static m a()
  {
    if (b == null) {
      b = new m();
    }
    return b;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches();
  }
  
  public String a(long paramLong)
  {
    String str = "B";
    float f1;
    if (paramLong >= 1000L)
    {
      str = "KB";
      f2 = (float)(paramLong / 1000L);
      f1 = f2;
      if (f2 >= 1000.0F)
      {
        str = "MB";
        f1 = f2 / 1000.0F;
      }
      f2 = f1;
      if (f1 >= 1000.0F) {
        str = "GB";
      }
    }
    for (float f2 = f1 / 1000.0F;; f2 = (float)paramLong)
    {
      StringBuilder localStringBuilder = new StringBuilder(new DecimalFormat("#0.0").format(f2));
      if (str != null) {
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
  }
  
  public void a(String paramString, Exception paramException)
  {
    Log.e(paramString, Log.getStackTraceString(paramException));
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      a().a(a, paramContext);
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */