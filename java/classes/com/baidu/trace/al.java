package com.baidu.trace;

import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.LocationManager;
import android.os.Build.VERSION;

final class al
  implements GpsStatus.Listener
{
  al(ak paramak) {}
  
  public final void onGpsStatusChanged(int paramInt)
  {
    GpsStatus localGpsStatus;
    if (Build.VERSION.SDK_INT < 24)
    {
      localGpsStatus = ak.a(this.a).getGpsStatus(null);
      ak.a(this.a, paramInt, localGpsStatus);
      return;
    }
    try
    {
      localGpsStatus = ak.a(this.a).getGpsStatus(null);
      ak.a(this.a, paramInt, localGpsStatus);
      return;
    }
    catch (Exception localException)
    {
      ak.a(this.a, 1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */