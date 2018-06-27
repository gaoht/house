package com.ziroom.ziroomcustomer.e.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.k;
import com.ziroom.ziroomcustomer.util.u;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.Callback;

public class b
{
  public static Map<String, String> getHeader(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    long l1 = System.currentTimeMillis();
    long l2 = ad.getGateWayDiffTime(ApplicationEx.c);
    String str1 = ah.getDeviceId(ApplicationEx.c);
    if (str1 == null) {
      paramContext = "";
    }
    for (;;)
    {
      String str4 = Build.VERSION.RELEASE;
      try
      {
        str1 = URLEncoder.encode(Build.MODEL, "UTF-8");
        if (ApplicationEx.c.isLoginState())
        {
          str3 = com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
          localHashMap.put("timeStamp", l2 + l1 + "");
          localHashMap.put("appType", "1");
          localHashMap.put("osType", "android");
          localHashMap.put("imei", paramContext);
          localHashMap.put("appVersion", "5.6.0");
          localHashMap.put("osVersion", str4);
          localHashMap.put("phoneName", str1);
          localHashMap.put("Content-Type", "application/json");
          localHashMap.put("token", str3);
          localHashMap.put("Client-Version", "5.6.0");
          localHashMap.put("Sys", "app");
          localHashMap.put("Request-Id", com.ziroom.commonlibrary.g.b.buildRequestId());
          localHashMap.put("Accept", "application/json");
          u.d("header", com.alibaba.fastjson.a.toJSONString(localHashMap));
          return localHashMap;
          paramContext = str1;
          if (!str1.startsWith("0000000")) {
            continue;
          }
          paramContext = UUID.randomUUID().toString();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = "";
          continue;
          String str3 = "";
        }
      }
    }
  }
  
  public static String getParam(e parame)
  {
    parame = com.alibaba.fastjson.a.toJSONString(parame);
    d.d("GatewayUtil", "======加密前请求:" + parame);
    parame = k.encrypt(parame);
    d.d("GatewayUtil ", "=====加密后请求:" + parame);
    return parame;
  }
  
  public static String getParam(Map<String, String> paramMap)
  {
    paramMap = com.alibaba.fastjson.a.toJSONString(paramMap);
    d.d("GatewayUtil", "======加密前请求:" + paramMap);
    paramMap = k.encrypt(paramMap);
    d.d("GatewayUtil ", "=====加密后请求:" + paramMap);
    return paramMap;
  }
  
  public static void requestGateWay(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    Map localMap = getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", getParam(parame)).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */