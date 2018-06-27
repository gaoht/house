package com.unionpay.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.Log;

final class bc
  implements SensorEventListener
{
  private int b = 0;
  
  bc(n paramn) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      long l = System.currentTimeMillis();
      int i = paramSensorEvent.sensor.getType();
      if (l - n.c(this.a) > 250L)
      {
        if (i != 1) {
          return;
        }
        n.a(this.a, l);
        paramSensorEvent = paramSensorEvent.values;
        Log.i("", "values[0] = " + paramSensorEvent[0]);
        if ((Math.abs(paramSensorEvent[0]) > 18.0F) || (Math.abs(paramSensorEvent[1]) > 18.0F) || (Math.abs(paramSensorEvent[2]) > 18.0F)) {
          this.b += 1;
        }
        if (this.b >= 5)
        {
          if (n.d(this.a) != null)
          {
            if (r.b(n.e(this.a), "android.permission.VIBRATE")) {
              ((Vibrator)n.e(this.a).getSystemService("vibrator")).vibrate(100L);
            }
            n.d(this.a).a();
            if (n.a(this.a) != null) {
              n.a(this.a).unregisterListener(n.b(this.a));
            }
          }
          this.b = 0;
          return;
        }
      }
    }
    catch (Throwable paramSensorEvent) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */