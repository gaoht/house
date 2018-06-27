package com.ziroom.ziroomcustomer.service;

import android.content.Context;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.h;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.util.HashMap;
import java.util.Map;

public class c
{
  public static String a;
  
  public static Map<String, String> convertor(Context paramContext, Map<String, Object> paramMap)
  {
    if (a == null) {
      a = "android";
    }
    paramMap.put("timestamp", i.getTimeStampMilli() + "");
    paramMap.put("platform", a);
    paramContext = new HashMap();
    paramContext.put("data", a.toJSONString(paramMap));
    paramMap = h.toMd5((a.toJSONString(paramMap) + "cm9vdDp4O").getBytes());
    paramContext.put("p", paramMap.substring(paramMap.length() - 8, paramMap.length()));
    u.i("push json map", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */