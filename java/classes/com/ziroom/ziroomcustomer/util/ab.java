package com.ziroom.ziroomcustomer.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class ab
{
  static ab a = null;
  private static String b = "ZiroomerHCSPLightweightDB_1";
  private static SharedPreferences c = null;
  private static SharedPreferences.Editor d = null;
  private static final Object e = new Object();
  
  private ab()
  {
    c = ApplicationEx.c.getSharedPreferences(b, 0);
    d = c.edit();
  }
  
  private void a(String paramString, long paramLong)
  {
    d.putLong(paramString, paramLong).apply();
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return d.putString(paramString1, paramString2).commit();
  }
  
  private long b(String paramString, long paramLong)
  {
    return c.getLong(paramString, paramLong);
  }
  
  private String b(String paramString1, String paramString2)
  {
    return c.getString(paramString1, paramString2);
  }
  
  public static ab getInstance()
  {
    if (c == null) {}
    synchronized (e)
    {
      if (c == null) {
        a = new ab();
      }
      return a;
    }
  }
  
  public void callDestroy()
  {
    if (b != null) {
      b = null;
    }
    if (c != null) {
      c = null;
    }
    if (d != null) {
      d = null;
    }
  }
  
  public void clearAll()
  {
    d.clear().apply();
  }
  
  public long getAppResetTime()
  {
    return b("resetTime", -1L);
  }
  
  public String getPeriodCleanCheckIn()
  {
    return b("PeriodCleanCheckIn", "");
  }
  
  public String getStationCheckIn()
  {
    return b("StationCheckIn", "");
  }
  
  public void remove(String paramString)
  {
    d.remove(paramString).apply();
  }
  
  public void saveAppResetTime(long paramLong)
  {
    a("resetTime", paramLong);
  }
  
  public void setPeriodCleanCheckIn(String paramString)
  {
    a("PeriodCleanCheckIn", paramString);
  }
  
  public void setStationCheckIn(String paramString)
  {
    a("StationCheckIn", paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */