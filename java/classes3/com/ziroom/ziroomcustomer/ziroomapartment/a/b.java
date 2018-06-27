package com.ziroom.ziroomcustomer.ziroomapartment.a;

import android.content.Context;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.util.Map;

public class b
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private static final String f = b.class.getSimpleName();
  
  public static Map<String, Object> convertor(Context paramContext, Map<String, Object> paramMap)
  {
    if (paramContext == null) {
      return paramMap;
    }
    paramContext = paramContext.getApplicationContext();
    if (a == null) {
      a = i.getIMEI(paramContext);
    }
    if (b == null) {
      b = i.getPhoneModel();
    }
    if (c == null) {
      c = i.getLanguage();
    }
    if (d == null) {
      d = "5.6.0";
    }
    if (e == null) {
      e = i.getSysVersion();
    }
    paramMap.put("timestamp", i.getTimeStamp());
    paramMap.put("source", "android");
    paramMap.put("l", c);
    paramMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramMap.put("imei", a);
    paramMap.put("phoneModel", b);
    paramMap.put("appVersionStr", d);
    paramMap.put("sysVersionStr", e);
    paramMap.put("systemCode", "0101");
    return paramMap;
  }
  
  public static Map<String, String> convertorStr(Context paramContext, Map<String, String> paramMap)
  {
    if (paramContext == null) {
      return paramMap;
    }
    paramContext = paramContext.getApplicationContext();
    if (a == null) {
      a = i.getIMEI(paramContext);
    }
    if (b == null) {
      b = i.getPhoneModel();
    }
    if (c == null) {
      c = i.getLanguage();
    }
    if (d == null) {
      d = "5.6.0";
    }
    if (e == null) {
      e = i.getSysVersion();
    }
    paramMap.put("timestamp", i.getTimeStamp());
    paramMap.put("source", "android");
    paramMap.put("l", c);
    paramMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramMap.put("imei", a);
    paramMap.put("phoneModel", b);
    paramMap.put("appVersionStr", d);
    paramMap.put("sysVersionStr", e);
    paramMap.put("systemCode", "0101");
    return paramMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */