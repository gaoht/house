package cn.jiguang.c.f;

import android.os.PowerManager.WakeLock;

public final class e
{
  private static e a = null;
  private PowerManager.WakeLock b = null;
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public final void a(PowerManager.WakeLock paramWakeLock)
  {
    this.b = paramWakeLock;
  }
  
  public final PowerManager.WakeLock b()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */