package com.ziroom.datacenter.c;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.ziroomhttp.b.c;
import java.util.Map;
import okhttp3.Callback;

public class a
{
  public static void requestAPIHOSTSTransferUnion(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    b.appendCommenParams(paramMap);
    paramMap = b.convertObjMap2String(paramMap);
    requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.v + "api/invoke", paramMap, paramCallback);
  }
  
  public static void requestCommonAccountByGet(Context paramContext, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    b.buildBalance(paramMap);
    paramMap = b.convertObjMap2String(paramMap);
    l.d("=====qianjin_tag=====", "==账号get请求url==" + com.ziroom.datacenter.remote.f.b.m + paramString);
    com.ziroom.commonlib.ziroomhttp.a.get(com.ziroom.datacenter.remote.f.b.m + paramString).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void requestCommonAccountByGet(Context paramContext, String paramString, Callback paramCallback)
  {
    requestCommonAccountByGet(paramContext, paramString, null, paramCallback);
  }
  
  public static void requestCommonCleanWithEncode(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(b.createPostEncodeString(parame.toJSONString())).enqueue(paramCallback);
  }
  
  public static void requestCommonCleanWithEncode(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(b.createPostEncodeString(com.alibaba.fastjson.a.toJSONString(paramMap))).enqueue(paramCallback);
  }
  
  public static void requestCommonGet(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.get(paramString).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void requestCommonMove(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    parame = b.createPostEncode(parame.toJSONString());
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(b.convertObjMap2String(parame)).enqueue(paramCallback);
  }
  
  public static void requestCommonMove(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    paramMap = b.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(b.convertObjMap2String(paramMap)).enqueue(paramCallback);
  }
  
  public static void requestCommonPost(Context paramContext, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    requestCommonPostV2(paramContext, paramString, b.convertObjMap2String(paramMap), paramCallback);
  }
  
  public static void requestCommonPostV2(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void requestCommonRepairWithEncode(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(b.createRepairEncode(parame)).enqueue(paramCallback);
  }
  
  public static void requestCommonUnion(Context paramContext, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    b.appendCommenParams(paramMap);
    requestCommonPostV2(paramContext, paramString, b.convertObjMap2String(paramMap), paramCallback);
  }
  
  public static void requestCommonYouPinAllCityByPost(Context paramContext, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    b.combineParams(paramMap);
    paramMap = b.convertObjMap2String(paramMap);
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.o + paramString).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void requestCommonYouPinPost(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    b.createYouPinEncode(paramMap);
    requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.w + paramString, paramMap, paramCallback);
  }
  
  public static void requestCommonYouPinPost(Context paramContext, String paramString, Callback paramCallback)
  {
    requestCommonYouPinPost(paramContext, paramString, null, paramCallback);
  }
  
  public static void requestGateWayCommonService(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    Map localMap = b.getHeader(paramContext);
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", b.getGateWayParam(parame)).enqueue(paramCallback);
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
      com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", b.getGateWayParam(parame)).enqueue(paramCallback);
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
  
  public static void requestJson(Context paramContext, String paramString, e parame, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).setBodyString(parame.toJSONString()).enqueue(paramCallback);
  }
  
  public static void requestJson(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).setBodyString(com.alibaba.fastjson.a.toJSONString(paramMap)).enqueue(paramCallback);
  }
  
  public static void requestJsonWithParams(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).params(paramMap).setBodyString(com.alibaba.fastjson.a.toJSONString(paramMap)).enqueue(paramCallback);
  }
  
  public static void requestWithHeaderByPost(Context paramContext, String paramString, Map<String, Object> paramMap, Callback paramCallback)
  {
    paramMap = b.convertObjMap2String(paramMap);
    com.ziroom.commonlib.ziroomhttp.a.post(paramString).tag(paramContext).addHeader("Accept", "application/json; version=2").params(paramMap).enqueue(paramCallback);
  }
  
  public static void requestWithHeaderV1ByGet(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.get(paramString).tag(paramContext).addHeader("Accept", "application/json; version=1").params(paramMap).enqueue(paramCallback);
  }
  
  public static void requestWithHeaderV2ByGet(Context paramContext, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.get(paramString).tag(paramContext).params(paramMap2).headers(paramMap1).enqueue(paramCallback);
  }
  
  public static void requestWithHeaderV2ByGet(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    com.ziroom.commonlib.ziroomhttp.a.get(paramString).tag(paramContext).headers(paramMap).enqueue(paramCallback);
  }
  
  public static void requestZRFNHOSTSTransferUnion(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    b.appendCommenParams(paramMap);
    paramMap = b.convertObjMap2String(paramMap);
    requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.u + "api/invoke", paramMap, paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */