package com.superrtc.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.superrtc.call.Logging;
import java.util.Arrays;
import java.util.List;

public final class b
{
  private static final String[] a = new String[0];
  private static final String[] b = { "D6503", "ONE A2005" };
  private static final String[] c = { "Nexus 10", "Nexus 9" };
  private static final String[] d = { "Nexus 10", "Nexus 9", "ONE A2005" };
  private static int e = 16000;
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  public static boolean deviceIsBlacklistedForOpenSLESUsage()
  {
    return Arrays.asList(a).contains(Build.MODEL);
  }
  
  public static List<String> getBlackListedModelsForAecUsage()
  {
    return Arrays.asList(b);
  }
  
  public static List<String> getBlackListedModelsForAgcUsage()
  {
    return Arrays.asList(c);
  }
  
  public static List<String> getBlackListedModelsForNsUsage()
  {
    return Arrays.asList(d);
  }
  
  public static int getDefaultSampleRateHz()
  {
    try
    {
      int j = e;
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getThreadInfo()
  {
    return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  public static boolean isDefaultSampleRateOverridden()
  {
    try
    {
      boolean bool = f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void logDeviceInfo(String paramString)
  {
    Logging.d(paramString, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
  }
  
  public static boolean runningOnEmulator()
  {
    return (Build.HARDWARE.equals("goldfish")) && (Build.BRAND.startsWith("generic_"));
  }
  
  public static boolean runningOnGingerBreadOrHigher()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean runningOnJellyBeanMR1OrHigher()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean runningOnJellyBeanMR2OrHigher()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean runningOnJellyBeanOrHigher()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean runningOnLollipopOrHigher()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static void setDefaultSampleRateHz(int paramInt)
  {
    try
    {
      f = true;
      e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setWebRtcBasedAcousticEchoCanceler(boolean paramBoolean)
  {
    try
    {
      g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setWebRtcBasedAutomaticGainControl(boolean paramBoolean)
  {
    try
    {
      h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setWebRtcBasedNoiseSuppressor(boolean paramBoolean)
  {
    try
    {
      i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean useWebRtcBasedAcousticEchoCanceler()
  {
    try
    {
      if (g) {
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC AEC!");
      }
      boolean bool = g;
      return bool;
    }
    finally {}
  }
  
  public static boolean useWebRtcBasedAutomaticGainControl()
  {
    try
    {
      if (h) {
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC AGC!");
      }
      boolean bool = h;
      return bool;
    }
    finally {}
  }
  
  public static boolean useWebRtcBasedNoiseSuppressor()
  {
    try
    {
      if (i) {
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC NS!");
      }
      boolean bool = i;
      return bool;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */