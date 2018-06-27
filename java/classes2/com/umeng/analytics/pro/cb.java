package com.umeng.analytics.pro;

public abstract class cb
  implements Runnable
{
  public abstract void a();
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */