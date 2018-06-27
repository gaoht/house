package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    if (j.a(this.a) != null)
    {
      Sensor localSensor = j.a(this.a).getDefaultSensor(6);
      j.a(this.a).unregisterListener(j.j(), localSensor);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */