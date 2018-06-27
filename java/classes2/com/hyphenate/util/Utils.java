package com.hyphenate.util;

import android.os.Build.VERSION;

public class Utils
{
  public static boolean isSdk14()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean isSdk21()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */