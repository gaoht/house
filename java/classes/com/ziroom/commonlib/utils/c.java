package com.ziroom.commonlib.utils;

import com.ziroom.commonlib.a.a;
import com.ziroom.commonlib.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  public static String a = "北京";
  public static String b = "110000";
  public static String c;
  public static String d = "ziroom";
  public static int e = 100003;
  private static List<b> f = new ArrayList();
  private static List<b> g = new ArrayList();
  private static b h = new a();
  private static b i = new com.ziroom.commonlib.a.c();
  private static b j = h;
  private static p k = p.getInstance("citylocation");
  
  private static void a(String paramString)
  {
    b localb = b(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = h;
    }
    setCurrentCity(paramString);
    a = paramString.getName();
    b = paramString.getCode();
  }
  
  private static b b(String paramString)
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramString.equals(localb.getCode())) {
        return localb;
      }
    }
    return null;
  }
  
  public static String getCurrentCityCode()
  {
    return k.getString("current_city_code");
  }
  
  public static String getMIN_SU_CITY_CODE()
  {
    return c;
  }
  
  public static void initCity()
  {
    String str = getCurrentCityCode();
    if (!r.isEmpty(str))
    {
      j = b(str);
      a(str);
    }
  }
  
  public static void setCurrentCity(b paramb)
  {
    if (paramb != null)
    {
      j = paramb;
      k.putString("current_city_code", paramb.getCode());
    }
  }
  
  public static void setMIN_SU_CITY_CODE(String paramString) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlib/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */