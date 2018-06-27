package com.umeng.analytics.pro;

import android.content.Context;
import org.json.JSONObject;

public class bh
  implements az
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final long e = 14400000L;
  private static final long f = 28800000L;
  private static final long g = 86400000L;
  private static bh j = null;
  private int h = 0;
  private final long i = 60000L;
  
  public static bh a(Context paramContext)
  {
    try
    {
      if (j == null)
      {
        j = new bh();
        int k = af.a(paramContext).b().a(0);
        j.a(k);
      }
      paramContext = j;
      return paramContext;
    }
    finally {}
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      long l = System.currentTimeMillis();
      localJSONObject.put("id", bd.a());
      localJSONObject.put("start_time", l);
      localJSONObject.put("end_time", l + 60000L);
      localJSONObject.put("duration", 60000L);
      return localJSONObject;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3)) {
      this.h = paramInt;
    }
  }
  
  public void a(af.a parama)
  {
    a(parama.a(0));
  }
  
  public void a(JSONObject paramJSONObject, Context paramContext)
  {
    if (this.h == 1)
    {
      paramJSONObject.remove("error");
      paramJSONObject.remove("ekv");
      paramJSONObject.remove("gkv");
      paramJSONObject.remove("cc");
      w.a(paramContext).a(false, true);
      m.a(paramContext).b(new f());
    }
    for (;;)
    {
      return;
      if (this.h == 2) {
        paramJSONObject.remove("sessions");
      }
      try
      {
        paramJSONObject.put("sessions", a());
        paramJSONObject.remove("error");
        paramJSONObject.remove("ekv");
        paramJSONObject.remove("gkv");
        paramJSONObject.remove("cc");
        w.a(paramContext).a(false, true);
        m.a(paramContext).b(new f());
        return;
        if (this.h != 3) {
          continue;
        }
        paramJSONObject.remove("sessions");
        paramJSONObject.remove("error");
        paramJSONObject.remove("ekv");
        paramJSONObject.remove("gkv");
        paramJSONObject.remove("cc");
        w.a(paramContext).a(false, true);
        m.a(paramContext).b(new f());
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public long b()
  {
    switch (this.h)
    {
    default: 
      return 0L;
    case 1: 
      return 14400000L;
    case 2: 
      return 28800000L;
    }
    return 86400000L;
  }
  
  public long c()
  {
    if (this.h == 0) {
      return 0L;
    }
    return 300000L;
  }
  
  public boolean d()
  {
    return this.h != 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */