package com.ziroom.ziroomcustomer.service;

import android.content.Context;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
{
  public static String a = "ZRK_APP";
  public static String b = "MINSU_APP";
  public static String c = "XMTS";
  public static String d = "GT";
  public static String e = "HWTS";
  public static String f = "JGTS";
  
  public static Map<String, String> buildBroadCastDeal(Context paramContext, String paramString1, List<String> paramList, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString1);
    localHashMap.put("msgIds", paramList);
    localHashMap.put("channel", e.getChannelCurrName(paramContext));
    localHashMap.put("zrDevToken", paramString2);
    localHashMap.put("hasUid", Integer.valueOf(paramInt));
    localHashMap.put("uid", paramString3);
    localHashMap.put("alias", paramString4);
    return c.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, String> buildBroadCastRece(Context paramContext, String paramString1, List<String> paramList, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString1);
    localHashMap.put("msgIds", paramList);
    localHashMap.put("channel", e.getChannelCurrName(paramContext));
    localHashMap.put("zrDevToken", paramString2);
    localHashMap.put("hasUid", Integer.valueOf(paramInt));
    localHashMap.put("uid", paramString3);
    localHashMap.put("alias", paramString4);
    return c.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildDeleteMsgs(Context paramContext, String paramString, List<String> paramList)
  {
    paramContext = new HashMap();
    paramContext.put("msgIds", paramList);
    paramContext.put("alias", paramString);
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> buildFeedbackDeal(Context paramContext, String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString);
    localHashMap.put("msgIds", paramList);
    localHashMap.put("channel", e.getChannelCurrName(paramContext));
    return c.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, String> buildFeedbackRece(Context paramContext, String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString);
    localHashMap.put("msgIds", paramList);
    localHashMap.put("channel", e.getChannelCurrName(paramContext));
    return c.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetSupportList(Context paramContext, String paramString)
  {
    paramContext = new HashMap();
    paramContext.put("app", paramString);
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetUnreadNum(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = new HashMap();
    paramContext.put("app", paramString1);
    paramContext.put("alias", paramString2);
    paramContext.put("from", Long.valueOf(paramLong));
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> buildSendDeviceInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10, String paramString11, double paramDouble1, double paramDouble2, String paramString12, String paramString13, String paramString14)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("zrDevToken", paramString1);
    localHashMap.put("deviceBrand", paramString2);
    localHashMap.put("deviceModel", paramString3);
    localHashMap.put("sysVersion", paramString4);
    localHashMap.put("imei", paramString5);
    localHashMap.put("sysLanguage", paramString6);
    localHashMap.put("app", paramString7);
    localHashMap.put("appVersion", paramString8);
    localHashMap.put("channel", paramString9);
    localHashMap.put("hasUid", Integer.valueOf(paramInt));
    localHashMap.put("uid", paramString10);
    localHashMap.put("alias", paramString11);
    localHashMap.put("lng", Double.valueOf(paramDouble1));
    localHashMap.put("lat", Double.valueOf(paramDouble2));
    localHashMap.put("bizCity", paramString12);
    localHashMap.put("geoCity", paramString13);
    localHashMap.put("address", paramString14);
    u.i("PushFeedBackMap", a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return c.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildSetHuaWeiBind(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = new HashMap();
    paramContext.put("platform", paramString1);
    paramContext.put("app", paramString2);
    paramContext.put("token", paramString3);
    paramContext.put("alias", paramString4);
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildSetHuaWeiUnbind(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new HashMap();
    paramContext.put("platform", paramString1);
    paramContext.put("app", paramString2);
    paramContext.put("token", paramString3);
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildSyncMessages(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramContext = new HashMap();
    paramContext.put("app", paramString1);
    paramContext.put("alias", paramString2);
    paramContext.put("page", paramInt1 + "");
    paramContext.put("size", paramInt2 + "");
    u.i("PushFeedBackMap", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */