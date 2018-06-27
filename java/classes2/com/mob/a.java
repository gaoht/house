package com.mob;

import com.mob.tools.log.NLog;

public class a
  extends NLog
{
  public static final int a;
  public static final String b;
  
  static
  {
    Object localObject = "1.0.0";
    int i = 1;
    try
    {
      String str = "2018-05-23".replace("-", ".");
      localObject = str;
      int j = Integer.parseInt("2018-05-23".replace("-", ""));
      i = j;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    a = i;
    b = (String)localObject;
  }
  
  private a()
  {
    setCollector("MOBSDK", new MobSDKLog.1(this));
    try
    {
      d("===============================", new Object[0]);
      d("MobCommons name: " + b + ", code: " + a, new Object[0]);
      d("===============================", new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static NLog a()
  {
    return new a();
  }
  
  protected String getSDKTag()
  {
    return "MOBSDK";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */