package com.ziroom.datacenter.c;

import android.os.Build;
import android.os.Build.VERSION;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlib.utils.e;
import com.ziroom.commonlib.utils.f;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.utils.m;
import com.ziroom.commonlib.utils.n;
import java.util.HashMap;
import java.util.Map;

public class c
{
  public static Map<String, Object> buildUid()
  {
    return getHouseSign(new HashMap());
  }
  
  public static Map<String, Object> getHouseSign(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = m.getUid();
      l.e("time", Long.valueOf(e.string2Long(e.getCurrentTime(), e.c)));
      String str2 = String.valueOf(e.string2Long(e.getCurrentTime(), e.c)).substring(0, 10);
      String str3 = SignKeyUtil.getHouseKey();
      str3 = b.signToMd5(str1 + str2 + str3);
      paramMap.put("timestamp", str2);
      paramMap.put("uid", str1);
      paramMap.put("sign", str3);
      paramMap.put("city_code", com.ziroom.commonlib.utils.c.b);
      paramMap.put("app", f.getVersion());
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", n.getIp());
      paramMap.put("network", n.GetNetworkType());
      paramMap.put("imei", f.getDeviceId());
      paramMap.put("app_version", f.getVersion());
    }
    return paramMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */