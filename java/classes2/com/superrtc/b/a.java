package com.superrtc.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.superrtc.sdk.e;
import com.superrtc.sdk.e.a;

public class a
{
  private static boolean a = false;
  private static boolean b = false;
  private static int c = 16000;
  private static int d = 7;
  private static e e;
  private static final String[] f = { "MODE_NORMAL", "MODE_RINGTONE", "MODE_IN_CALL", "MODE_IN_COMMUNICATION" };
  private final Context g;
  
  private boolean a()
  {
    return (b()) && (this.g.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency"));
  }
  
  private static boolean b()
  {
    return b.runningOnGingerBreadOrHigher();
  }
  
  public static int getCallAudioSource()
  {
    return d;
  }
  
  public static void openMicFail()
  {
    if (e != null) {
      e.onError(e.a.b);
    }
  }
  
  public static void setAudioSampleRate(int paramInt)
  {
    if ((paramInt == 8000) || (paramInt == 11025) || (paramInt == 22050) || (paramInt == 16000) || (paramInt == 32000) || (paramInt == 44100) || (paramInt == 48000)) {
      c = paramInt;
    }
  }
  
  public static void setBlacklistDeviceForOpenSLESUsage(boolean paramBoolean)
  {
    try
    {
      b = true;
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setCallAudioSource(int paramInt)
  {
    d = paramInt;
  }
  
  public static void setRtcListener(e parame)
  {
    e = parame;
  }
  
  public boolean isLowLatencyInputSupported()
  {
    return (b.runningOnLollipopOrHigher()) && (a());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */