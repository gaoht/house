package com.ziroom.commonlib.utils;

import android.text.TextUtils;
import com.ziroom.commonlib.a.d;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class q
{
  private static p a = p.getInstance("othercase_key");
  private static p b = p.getInstance("USER");
  private static p c = p.getInstance("login_info");
  private static p d = p.getInstance("Web_gateway_difftime");
  private static p e = p.getInstance("you_pin");
  private static p f = p.getInstance("Web_Type");
  private static p g = p.getInstance("push_last_sync_time");
  
  public static void clearUser()
  {
    b.remove("uid");
    b.remove("loginName");
    b.remove("loginName");
  }
  
  public static long getGateWayDiffTime()
  {
    return d.getLong("gateway_difftime", 0L);
  }
  
  public static long getLastSyncTime()
  {
    long l = g.getLong("push_last_sync_time", -1L);
    if (-1L != l) {
      return l;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -7);
    return localCalendar.getTimeInMillis();
  }
  
  public static Map<String, String> getLocation()
  {
    String str1 = c.getString("location_info_latitude", "");
    String str2 = c.getString("location_info_longitude", "");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", str1);
      localHashMap.put("longitude", str2);
      return localHashMap;
    }
    return null;
  }
  
  public static String getOtherString(String paramString)
  {
    return a.getString(paramString);
  }
  
  public static d getUser()
  {
    d locald = new d();
    locald.setUid(b.getString("uid", ""));
    locald.setPhone(b.getString("loginName", ""));
    return locald;
  }
  
  public static int getWebType()
  {
    return f.getInt("webType", 0);
  }
  
  public static String getYouPinCityCodeString(String paramString1, String paramString2)
  {
    return e.getString("currentYouPinCityCode");
  }
  
  public static String getYouPinCityNameString(String paramString1, String paramString2)
  {
    return e.getString("currentYouPinCityName");
  }
  
  public static void putGateWayDiffTime(long paramLong)
  {
    d.putLong("gateway_difftime", paramLong);
  }
  
  public static void putLastSyncTime(long paramLong)
  {
    g.putLong("push_last_sync_time", paramLong);
  }
  
  public static void putOtherString(String paramString1, String paramString2)
  {
    a.putString(paramString1, paramString2);
  }
  
  public static void putWebType(int paramInt)
  {
    f.putInt("webType", paramInt);
  }
  
  public static void putYouPinCityCodeString(String paramString)
  {
    e.putString("currentYouPinCityCode", paramString);
  }
  
  public static void putYouPinCityNameString(String paramString)
  {
    e.putString("currentYouPinCityName", paramString);
  }
  
  public static void saveLocation(double paramDouble1, double paramDouble2)
  {
    c.putString("location_info_latitude", paramDouble1 + "");
    c.putString("location_info_longitude", paramDouble2 + "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlib/utils/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */