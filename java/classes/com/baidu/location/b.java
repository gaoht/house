package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class b
  implements ServiceConnection
{
  b(LocationClient paramLocationClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LocationClient.access$102(this.a, new Messenger(paramIBinder));
    if (LocationClient.access$100(this.a) == null) {}
    for (;;)
    {
      return;
      LocationClient.access$202(this.a, true);
      Log.d("baidu_location_client", "baidu location connected ...");
      if (LocationClient.access$300(this.a))
      {
        LocationClient.access$400(this.a).obtainMessage(2).sendToTarget();
        return;
      }
      try
      {
        paramComponentName = Message.obtain(null, 11);
        paramComponentName.replyTo = LocationClient.access$500(this.a);
        paramComponentName.setData(LocationClient.access$600(this.a));
        LocationClient.access$100(this.a).send(paramComponentName);
        LocationClient.access$202(this.a, true);
        if (LocationClient.access$700(this.a) != null)
        {
          if (LocationClient.access$800(this.a).booleanValue()) {}
          LocationClient.access$400(this.a).obtainMessage(4).sendToTarget();
          return;
        }
      }
      catch (Exception paramComponentName) {}
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LocationClient.access$102(this.a, null);
    LocationClient.access$202(this.a, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */