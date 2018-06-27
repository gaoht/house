package com.xiaomi.metok.geofencing;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

class b
  implements ServiceConnection
{
  b(a parama) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Log.v("GeoFencingServiceWrapper", "*** GeoFencingService connected (yay!)");
    a.a(this.a, c.a.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.v("GeoFencingServiceWrapper", "*** GeoFencingService disconnected (boo!)");
    a.a(this.a, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/metok/geofencing/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */