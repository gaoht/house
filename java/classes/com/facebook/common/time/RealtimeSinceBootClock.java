package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class RealtimeSinceBootClock
  implements MonotonicClock
{
  private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();
  
  @DoNotStrip
  public static RealtimeSinceBootClock get()
  {
    return INSTANCE;
  }
  
  public long now()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/time/RealtimeSinceBootClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */