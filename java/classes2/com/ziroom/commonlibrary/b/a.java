package com.ziroom.commonlibrary.b;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.ziroom.commonlibrary.g.c;
import java.util.Map;

public class a
{
  private static double a;
  private static double b;
  private static Map<String, String> c;
  private static BDLocation d;
  
  public static BDLocation getBDLocation(Context paramContext)
  {
    if (d == null) {
      d = c.getBDLocation(paramContext);
    }
    return d;
  }
  
  public static double getLatitude(Context paramContext)
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
      c = c.getLocation(paramContext);
      if (c != null) {
        a = Double.parseDouble((String)c.get("latitude"));
      }
    }
  }
  
  public static double getLongitude(Context paramContext)
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
      c = c.getLocation(paramContext);
      if (c != null) {
        b = Double.parseDouble((String)c.get("longitude"));
      }
    }
  }
  
  public static void setBDLocation(Context paramContext, BDLocation paramBDLocation)
  {
    if (paramBDLocation == null) {
      return;
    }
    d = paramBDLocation;
    c.saveBDLocation(paramContext, paramBDLocation);
  }
  
  public static void setLocation(Context paramContext, double paramDouble1, double paramDouble2)
  {
    a = paramDouble1;
    b = paramDouble2;
    c.saveLocation(paramContext, paramDouble1, paramDouble2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */