package com.ziroom.commonlib.utils;

import java.util.Map;

public class k
{
  private static double a;
  private static double b;
  private static Map<String, String> c;
  
  public static double getLatitude()
  {
    if (a < 1.0D)
    {
      if (c == null) {
        break label37;
      }
      a = Double.parseDouble((String)c.get("latitude"));
    }
    for (;;)
    {
      return a;
      label37:
      c = q.getLocation();
      if (c != null) {
        a = Double.parseDouble((String)c.get("latitude"));
      }
    }
  }
  
  public static double getLongitude()
  {
    if (b < 1.0D)
    {
      if (c == null) {
        break label37;
      }
      b = Double.parseDouble((String)c.get("longitude"));
    }
    for (;;)
    {
      return b;
      label37:
      c = q.getLocation();
      if (c != null) {
        b = Double.parseDouble((String)c.get("longitude"));
      }
    }
  }
  
  public static void setLocation(double paramDouble1, double paramDouble2)
  {
    a = paramDouble1;
    b = paramDouble2;
    q.saveLocation(paramDouble1, paramDouble2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */