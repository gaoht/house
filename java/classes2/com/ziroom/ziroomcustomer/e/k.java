package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.ziroom.ziroomcustomer.e.b.b;
import com.ziroom.ziroomcustomer.newServiceList.utils.f;
import java.util.Map;
import okhttp3.Callback;

public class k
{
  public static void request(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).tag(paramContext).params(paramMap).enqueue(parama);
  }
  
  public static void request(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void requestClean(Context paramContext, String paramString, e parame, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).params(m.createPostEncodeString(parame.toJSONString())).enqueue(parama);
  }
  
  public static void requestFluxClean(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).params(m.createPostEncodeString(parame.toJSONString())).enqueue(paramCallback);
  }
  
  public static void requestForUser(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).tag(paramContext).addHeader("Accept", "application/json; version=1").params(paramMap).enqueue(parama);
  }
  
  public static void requestGateWayCommonService(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    Map localMap = b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(parame)).enqueue(paramCallback);
  }
  
  public static void requestGateWayInterface(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    Map localMap = b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(parame)).enqueue(paramCallback);
  }
  
  public static void requestGateWayService(Context paramContext, String paramString, e parame, Map<String, String> paramMap, Callback paramCallback, boolean paramBoolean)
  {
    Map localMap = b.getHeader(paramContext);
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localMap.putAll(paramMap);
    }
    if (paramBoolean) {
      localMap.put("needToken", "true");
    }
    for (;;)
    {
      com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(parame)).enqueue(paramCallback);
      return;
      localMap.put("needToken", "false");
    }
  }
  
  public static void requestGateWayService(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    requestGateWayService(paramContext, paramString, parame, paramCallback, true);
  }
  
  public static void requestGateWayService(Context paramContext, String paramString, e parame, Callback paramCallback, boolean paramBoolean)
  {
    requestGateWayService(paramContext, paramString, parame, null, paramCallback, paramBoolean);
  }
  
  public static void requestGateWayServiceNotLogin(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    requestGateWayService(paramContext, paramString, parame, paramCallback, false);
  }
  
  public static void requestJson(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).tag(paramContext).setBodyString(com.alibaba.fastjson.a.toJSONString(paramMap)).enqueue(parama);
  }
  
  public static void requestJsonOBJ(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).tag(paramContext).setBodyString(com.alibaba.fastjson.a.toJSONString(paramMap)).enqueue(parama);
  }
  
  public static void requestOkService(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).params(m.createPostEncodeString(parame.toJSONString())).enqueue(paramCallback);
  }
  
  public static void requestRepair(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).params(f.createRepairEncode(parame)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void requestYouPin(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).params(f.createYouPinEncode(paramMap, paramContext)).tag(paramContext).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */