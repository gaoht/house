package com.superrtc.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.util.Log;

public class b
  implements SensorEventListener
{
  private final c.a a = new c.a();
  private final Runnable b;
  private final SensorManager c;
  private Sensor d = null;
  private boolean e = false;
  
  private b(Context paramContext, Runnable paramRunnable)
  {
    Log.d("AppRTCProximitySensor", "AppRTCProximitySensor" + c.getThreadInfo());
    this.b = paramRunnable;
    this.c = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  static b a(Context paramContext, Runnable paramRunnable)
  {
    return new b(paramContext, paramRunnable);
  }
  
  private boolean a()
  {
    if (this.d != null) {
      return true;
    }
    this.d = this.c.getDefaultSensor(8);
    if (this.d == null) {
      return false;
    }
    b();
    return true;
  }
  
  private void b()
  {
    if (this.d == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Proximity sensor: ");
    localStringBuilder.append("name=" + this.d.getName());
    localStringBuilder.append(", vendor: " + this.d.getVendor());
    localStringBuilder.append(", power: " + this.d.getPower());
    localStringBuilder.append(", resolution: " + this.d.getResolution());
    localStringBuilder.append(", max range: " + this.d.getMaximumRange());
    if (Build.VERSION.SDK_INT >= 9) {
      localStringBuilder.append(", min delay: " + this.d.getMinDelay());
    }
    if (Build.VERSION.SDK_INT >= 20) {
      localStringBuilder.append(", type: " + this.d.getStringType());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localStringBuilder.append(", max delay: " + this.d.getMaxDelay());
      localStringBuilder.append(", reporting mode: " + this.d.getReportingMode());
      localStringBuilder.append(", isWakeUpSensor: " + this.d.isWakeUpSensor());
    }
    Log.d("AppRTCProximitySensor", localStringBuilder.toString());
  }
  
  private void c()
  {
    if (!this.a.calledOnValidThread()) {
      throw new IllegalStateException("Method is not called on valid thread");
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    c();
    if (paramSensor.getType() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      c.assertIsTrue(bool);
      if (paramInt == 0) {
        Log.e("AppRTCProximitySensor", "The values returned by this sensor cannot be trusted");
      }
      return;
    }
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    c();
    boolean bool;
    if (paramSensorEvent.sensor.getType() == 8)
    {
      bool = true;
      c.assertIsTrue(bool);
      if (paramSensorEvent.values[0] >= this.d.getMaximumRange()) {
        break label139;
      }
      Log.d("AppRTCProximitySensor", "Proximity sensor => NEAR state");
    }
    for (this.e = true;; this.e = false)
    {
      if (this.b != null) {
        this.b.run();
      }
      Log.d("AppRTCProximitySensor", "onSensorChanged" + c.getThreadInfo() + ": accuracy=" + paramSensorEvent.accuracy + ", timestamp=" + paramSensorEvent.timestamp + ", distance=" + paramSensorEvent.values[0]);
      return;
      bool = false;
      break;
      label139:
      Log.d("AppRTCProximitySensor", "Proximity sensor => FAR state");
    }
  }
  
  public boolean sensorReportsNearState()
  {
    c();
    return this.e;
  }
  
  public boolean start()
  {
    c();
    Log.d("AppRTCProximitySensor", "start" + c.getThreadInfo());
    if (!a()) {
      return false;
    }
    this.c.registerListener(this, this.d, 3);
    return true;
  }
  
  public void stop()
  {
    c();
    Log.d("AppRTCProximitySensor", "stop" + c.getThreadInfo());
    if (this.d == null) {
      return;
    }
    this.c.unregisterListener(this, this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */