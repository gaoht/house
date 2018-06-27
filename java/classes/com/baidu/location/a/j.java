package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.baidu.location.c.a;
import com.baidu.location.f;

public class j
  implements SensorEventListener
{
  private static j d;
  private float[] a;
  private float[] b;
  private SensorManager c;
  private float e;
  private double f = Double.MIN_VALUE;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private float j = 0.0F;
  private long k = 0L;
  private boolean l = false;
  private long m = 0L;
  
  private j()
  {
    try
    {
      if (this.c == null) {
        this.c = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      }
      if (this.c.getDefaultSensor(6) != null) {
        this.i = true;
      }
      return;
    }
    catch (Exception localException)
    {
      this.i = false;
    }
  }
  
  public static j a()
  {
    try
    {
      if (d == null) {
        d = new j();
      }
      j localj = d;
      return localj;
    }
    finally {}
  }
  
  private void k()
  {
    if (this.c != null)
    {
      Sensor localSensor = this.c.getDefaultSensor(6);
      if (localSensor != null) {
        this.c.registerListener(d, localSensor, 3);
      }
      a.a().postDelayed(new k(this), 2000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/baidu/location/a/j:l	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 38	com/baidu/location/a/j:g	Z
    //   18: ifne +10 -> 28
    //   21: aload_0
    //   22: getfield 40	com/baidu/location/a/j:h	Z
    //   25: ifeq -14 -> 11
    //   28: aload_0
    //   29: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   32: ifnonnull +18 -> 50
    //   35: aload_0
    //   36: invokestatic 58	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   39: ldc 60
    //   41: invokevirtual 66	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: checkcast 68	android/hardware/SensorManager
    //   47: putfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   50: aload_0
    //   51: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   54: ifnull +67 -> 121
    //   57: aload_0
    //   58: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   61: bipush 11
    //   63: invokevirtual 72	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +21 -> 89
    //   71: aload_0
    //   72: getfield 38	com/baidu/location/a/j:g	Z
    //   75: ifeq +14 -> 89
    //   78: aload_0
    //   79: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_3
    //   85: invokevirtual 82	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   93: bipush 6
    //   95: invokevirtual 72	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +21 -> 121
    //   103: aload_0
    //   104: getfield 40	com/baidu/location/a/j:h	Z
    //   107: ifeq +14 -> 121
    //   110: aload_0
    //   111: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   114: aload_0
    //   115: aload_2
    //   116: iconst_3
    //   117: invokevirtual 82	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   120: pop
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 48	com/baidu/location/a/j:l	Z
    //   126: goto -115 -> 11
    //   129: astore_2
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	j
    //   6	2	1	bool	boolean
    //   66	50	2	localSensor	Sensor
    //   129	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	129	finally
    //   14	28	129	finally
    //   28	50	129	finally
    //   50	67	129	finally
    //   71	89	129	finally
    //   89	99	129	finally
    //   103	121	129	finally
    //   121	126	129	finally
  }
  
  public void b(boolean paramBoolean) {}
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/baidu/location/a/j:l	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   18: ifnull +16 -> 34
    //   21: aload_0
    //   22: getfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   25: aload_0
    //   26: invokevirtual 105	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;)V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 52	com/baidu/location/a/j:c	Landroid/hardware/SensorManager;
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 48	com/baidu/location/a/j:l	Z
    //   39: aload_0
    //   40: fconst_0
    //   41: putfield 44	com/baidu/location/a/j:j	F
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	j
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	34	47	finally
    //   34	44	47	finally
  }
  
  public void d()
  {
    if ((!this.h) && (this.i) && (System.currentTimeMillis() - this.m > 60000L))
    {
      this.m = System.currentTimeMillis();
      k();
    }
  }
  
  public float e()
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.i)
    {
      f1 = f2;
      if (this.k > 0L)
      {
        f1 = f2;
        if (Math.abs(System.currentTimeMillis() - this.k) < 5000L)
        {
          f1 = f2;
          if (this.j > 0.0F) {
            f1 = this.j;
          }
        }
      }
    }
    return f1;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public float h()
  {
    return this.e;
  }
  
  public double i()
  {
    return this.f;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  @SuppressLint({"NewApi"})
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
    case 11: 
      do
      {
        return;
        this.a = ((float[])paramSensorEvent.values.clone());
      } while (this.a == null);
      paramSensorEvent = new float[9];
      for (;;)
      {
        try
        {
          SensorManager.getRotationMatrixFromVector(paramSensorEvent, this.a);
          float[] arrayOfFloat = new float[3];
          SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
          this.e = ((float)Math.toDegrees(arrayOfFloat[0]));
          if (this.e >= 0.0F)
          {
            d1 = this.e;
            this.e = ((float)Math.floor(d1));
            return;
          }
        }
        catch (Exception paramSensorEvent)
        {
          this.e = 0.0F;
          return;
        }
        float f1 = this.e;
        double d1 = f1 + 360.0F;
      }
    }
    try
    {
      this.b = ((float[])paramSensorEvent.values.clone());
      this.j = this.b[0];
      this.k = System.currentTimeMillis();
      this.f = SensorManager.getAltitude(1013.25F, this.b[0]);
      return;
    }
    catch (Exception paramSensorEvent) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */