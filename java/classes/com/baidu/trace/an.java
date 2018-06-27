package com.baidu.trace;

final class an
  extends Thread
{
  public final void run()
  {
    if (am.b() != null) {
      return;
    }
    try
    {
      am.a(am.c().getWritableDatabase());
      return;
    }
    catch (Exception localException)
    {
      am.a(null);
      return;
    }
    finally
    {
      am.b(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */