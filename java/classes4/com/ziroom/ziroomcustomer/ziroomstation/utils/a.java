package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.content.Context;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.base.d;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Map;

public class a
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private static final String f = a.class.getSimpleName();
  
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
      d = i.getAppVersion(paramContext);
    }
    if (e == null) {
      e = i.getSysVersion();
    }
    paramMap.put("timestamp", i.getTimeStamp());
    paramMap.put("source", "android");
    paramMap.put("l", c);
    paramMap.put("cityCode", b.d);
    paramMap.put("imei", a);
    paramMap.put("phoneModel", b);
    paramMap.put("appVersionStr", d);
    paramMap.put("sysVersionStr", e);
    paramMap.put("systemCode", "0101");
    paramMap.put("stationVersionCode", Integer.valueOf(d.b));
    u.i("json map", com.alibaba.fastjson.a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramMap;
  }
  
  public static Map<String, String> convertorByString(Context paramContext, Map<String, String> paramMap)
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
      d = i.getAppVersion(paramContext);
    }
    if (e == null) {
      e = i.getSysVersion();
    }
    paramMap.put("timestamp", i.getTimeStamp());
    paramMap.put("source", "android");
    paramMap.put("l", c);
    paramMap.put("cityCode", b.d);
    paramMap.put("imei", a);
    paramMap.put("phoneModel", b);
    paramMap.put("appVersionStr", d);
    paramMap.put("sysVersionStr", e);
    paramMap.put("systemCode", "0101");
    paramMap.put("stationVersionCode", String.valueOf(d.b));
    u.i("json map", com.alibaba.fastjson.a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */