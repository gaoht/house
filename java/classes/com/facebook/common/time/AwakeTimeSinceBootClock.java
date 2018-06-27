package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class AwakeTimeSinceBootClock
  implements MonotonicClock
{
  @DoNotStrip
  private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();
  
  @DoNotStrip
  public static AwakeTimeSinceBootClock get()
  {
    return INSTANCE;
  }
  
  @DoNotStrip
  public long now()
  {
    return SystemClock.uptimeMillis();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/time/AwakeTimeSinceBootClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */