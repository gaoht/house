package com.ziroom.ziroomcustomer.pay.common.b;

import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class c
{
  public static void appendCommenParams(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("source", Integer.valueOf(1));
      long l = System.currentTimeMillis() - ApplicationEx.c.getTimeDiff();
      paramMap.put("timestamp", Long.valueOf(l));
      String str = com.ziroom.commonlib.utils.b.getAppId();
      paramMap.put("appId", str);
      paramMap.put("appType", Integer.valueOf(2));
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("uuid", str + "_" + l);
      paramMap.put("osType", Integer.valueOf(2));
      paramMap.put("appVersionStr", ah.getVersion(ApplicationEx.c));
      paramMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      if (paramMap.containsKey("sign")) {
        paramMap.remove("sign");
      }
      paramMap.put("sign", toMD5(paramMap));
    }
  }
  
  public static void appendCommenStringParams(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("source", "1");
      long l = System.currentTimeMillis() - ApplicationEx.c.getTimeDiff();
      paramMap.put("timestamp", l + "");
      String str = com.ziroom.commonlib.utils.b.getAppId();
      paramMap.put("appId", str);
      paramMap.put("appType", "2");
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("uuid", str + "_" + l);
      paramMap.put("osType", "2");
      paramMap.put("appVersionStr", ah.getVersion(ApplicationEx.c));
      paramMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      if (paramMap.containsKey("sign")) {
        paramMap.remove("sign");
      }
      paramMap.put("sign", toStringMD5(paramMap));
    }
  }
  
  public static String toMD5(Map<String, Object> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    Arrays.sort(arrayOfString);
    int i = 0;
    if (i < paramMap.size())
    {
      if (paramMap.get(arrayOfString[i]) == null) {
        localStringBuffer.append(arrayOfString[i] + "=");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(arrayOfString[i] + "=" + paramMap.get(arrayOfString[i]));
      }
    }
    localStringBuffer.append("fn7srzT88FcNiRQA3n");
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toStringMD5(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    Arrays.sort(arrayOfString);
    int i = 0;
    if (i < paramMap.size())
    {
      if (paramMap.get(arrayOfString[i]) == null) {
        localStringBuffer.append(arrayOfString[i] + "=");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(arrayOfString[i] + "=" + (String)paramMap.get(arrayOfString[i]));
      }
    }
    localStringBuffer.append("fn7srzT88FcNiRQA3n");
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/common/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */