package com.superrtc.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;

public final class c
{
  public static void assertIsTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError("Expected condition to be true");
    }
  }
  
  public static String getThreadInfo()
  {
    return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
  }
  
  public static void logDeviceInfo(String paramString)
  {
    Log.d(paramString, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
  }
  
  public static class a
  {
    private final Long a = Long.valueOf(Thread.currentThread().getId());
    
    public boolean calledOnValidThread()
    {
      return this.a.equals(Long.valueOf(Thread.currentThread().getId()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */