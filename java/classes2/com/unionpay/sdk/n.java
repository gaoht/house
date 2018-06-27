package com.unionpay.sdk;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;

public class n
{
  private static volatile n b = null;
  private Context a = null;
  private final int c = 250;
  private final int d = 18;
  private long e = 0L;
  private final int f = 5;
  private SensorManager g;
  private a h = null;
  private Handler i = new bb(this, Looper.getMainLooper());
  private SensorEventListener j = new bc(this);
  
  private n(Context paramContext)
  {
    try
    {
      this.a = paramContext;
      this.g = ((SensorManager)paramContext.getSystemService("sensor"));
      this.g.registerListener(this.j, this.g.getDefaultSensor(1), 1);
      this.i.sendEmptyMessageDelayed(10, 10000L);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static n a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new n(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public void registerTestDeviceListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */