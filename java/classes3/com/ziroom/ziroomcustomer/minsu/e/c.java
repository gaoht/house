package com.ziroom.ziroomcustomer.minsu.e;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.newServiceList.utils.f;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.Map;
import okhttp3.Callback;

public class c
{
  public static String getUid()
  {
    return com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c);
  }
  
  public static void requestGateWay(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    parame = getUid();
    Map localMap = f.getGateWayHeader(paramContext);
    localMap.put("needToken", "true");
    localMap.put("User-Agent", ad.getUserAgent(paramContext));
    localMap.put("Client-Type", "1");
    localMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    if (ae.notNull(parame)) {
      localMap.put("uid", parame);
    }
    localMap.put("traceInfo", e.toJSONString(new e(ad.getPhoneInfo2()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(locale)).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */