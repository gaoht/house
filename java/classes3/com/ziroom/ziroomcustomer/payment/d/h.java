package com.ziroom.ziroomcustomer.payment.d;

import android.app.Activity;
import com.alibaba.fastjson.b;
import com.freelxl.baselibrary.d.b.c;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Callback;

public class h
{
  private static Map<String, String> a(Map<String, Object> paramMap)
  {
    d.e("yangxj", b.toJSONString(paramMap));
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((localEntry.getValue() instanceof String)) {
        localHashMap.put(localEntry.getKey(), (String)localEntry.getValue());
      } else if ((localEntry.getValue() instanceof Integer)) {
        localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
      } else if (localEntry.getValue() == null) {
        localHashMap.put(localEntry.getKey(), "");
      } else {
        localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
      }
    }
    return localHashMap;
  }
  
  public static String getToken()
  {
    return com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
  }
  
  public static String getUid()
  {
    return com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c);
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap, Callback paramCallback)
  {
    f.appendCommenParams(paramMap);
    u.e("yangxj---url", paramString1 + paramString2);
    paramMap = a(paramMap);
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).params(paramMap).tag(paramActivity).enqueue(paramCallback);
  }
  
  public static void request(Activity paramActivity, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    f.appendCommenParams(paramMap);
    u.e("yangxj---url", com.ziroom.ziroomcustomer.payment.c.a.a + paramString);
    paramMap = a(paramMap);
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.payment.c.a.a + paramString).params(paramMap).tag(paramActivity).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */