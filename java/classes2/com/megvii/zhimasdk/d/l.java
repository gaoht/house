package com.megvii.zhimasdk.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class l
  implements SensorEventListener
{
  public float a;
  private SensorManager b;
  private Sensor c;
  
  public l(Context paramContext)
  {
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = ((SensorManager)paramContext.getSystemService("sensor"));
    this.c = this.b.getDefaultSensor(1);
    if (this.c != null) {
      this.b.registerListener(this, this.c, 3);
    }
  }
  
  public void a()
  {
    if ((this.c != null) && (this.b != null)) {
      this.b.unregisterListener(this);
    }
  }
  
  public boolean b()
  {
    return this.a >= 9.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.a = paramSensorEvent.values[1];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */