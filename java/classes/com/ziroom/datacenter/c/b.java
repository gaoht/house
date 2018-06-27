package com.ziroom.datacenter.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ziroom.commonlib.a.d;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlib.utils.f;
import com.ziroom.commonlib.utils.g;
import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlib.utils.k;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlib.utils.m;
import com.ziroom.commonlib.utils.n;
import com.ziroom.commonlib.utils.p;
import com.ziroom.commonlib.utils.q;
import com.ziroom.commonlib.utils.r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class b
{
  public static String a = "ZRK_APP";
  public static String b = "MINSU_APP";
  public static String c = "XMTS";
  public static String d = "GT";
  public static String e = "HWTS";
  public static String f = "JGTS";
  private static String g;
  private static String h;
  private static String i;
  private static int j = 1;
  private static String k;
  
  private static String a(String paramString)
  {
    return g.toMd5(('c' + paramString + 'b').getBytes());
  }
  
  private static Map<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool3 = TextUtils.isEmpty(paramString3);
    if ((bool1) && (bool2) && (bool3)) {
      throw new RuntimeException("手机号，邮箱，用户名需要存在一个！");
    }
    HashMap localHashMap = new HashMap();
    if (!bool1) {
      localHashMap.put("phone", paramString1);
    }
    do
    {
      return localHashMap;
      if (!bool2)
      {
        localHashMap.put("email", paramString2);
        return localHashMap;
      }
    } while (bool3);
    localHashMap.put("username", paramString3);
    return localHashMap;
  }
  
  public static void appendCommenParams(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("source", Integer.valueOf(1));
      long l = System.currentTimeMillis() - com.ziroom.commonlib.utils.b.getTimeDiff();
      paramMap.put("timestamp", Long.valueOf(l));
      String str = com.ziroom.commonlib.utils.b.getAppId();
      if (TextUtils.isEmpty(str)) {
        com.ziroom.commonlib.utils.b.getAppId();
      }
      paramMap.put("appId", str);
      paramMap.put("appType", Integer.valueOf(2));
      paramMap.put("imei", f.getDeviceId());
      paramMap.put("uuid", str + "_" + l);
      paramMap.put("osType", Integer.valueOf(2));
      paramMap.put("appVersionStr", f.getVersion());
      paramMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
      if (paramMap.containsKey("sign")) {
        paramMap.remove("sign");
      }
      paramMap.put("sign", toMD5(paramMap));
    }
  }
  
  public static Map<String, String> boundParams(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    l.d("HandlerParser", "=====优品入参:" + a.toJSONString(localObject));
    long l1 = System.currentTimeMillis();
    long l2 = com.ziroom.commonlib.utils.b.getTimeDiff();
    ((Map)localObject).put("timestamp", l1 - l2 + "");
    ((Map)localObject).put("dataSource", "12");
    ((Map)localObject).put("osType", "2");
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    ((Map)localObject).put("dataSourceVersion", f.getAppVersion());
    paramMap = com.ziroom.commonlib.utils.b.getUserInfo();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getPhone());
    }
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> buildAddCards(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    String str1 = m.getUid();
    String str2 = m.getToken();
    if (r.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (r.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", Integer.valueOf(600001));
    localHashMap.put("bank_area", paramString1);
    localHashMap.put("bank_code", paramString2);
    localHashMap.put("card_code", paramString3);
    localHashMap.put("bank_name", paramString4);
    localHashMap.put("mobile", paramString5);
    localHashMap.put("app", f.getVersion());
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  @Deprecated
  public static Map<String, Object> buildBalance()
  {
    HashMap localHashMap = new HashMap();
    String str1 = m.getUid();
    String str2 = m.getToken();
    if (r.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (r.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", Integer.valueOf(600001));
    localHashMap.put("app", f.getVersion());
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildBalance(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    paramMap = m.getUid();
    String str = m.getToken();
    if (r.notNull(paramMap)) {
      ((Map)localObject).put("uid", paramMap);
    }
    if (r.notNull(str)) {
      ((Map)localObject).put("token", str);
    }
    ((Map)localObject).put("auth_code", Integer.valueOf(600001));
    ((Map)localObject).put("app", f.getVersion());
    ((Map)localObject).put("os_version", Build.VERSION.RELEASE);
    ((Map)localObject).put("os_type", "android");
    getNewHouseSign((Map)localObject);
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, Object> buildCleanCardLeft(Context paramContext, String paramString)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("uid", paramString);
    paramContext.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static Map<String, Object> buildCleanDataTime(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", Long.valueOf(System.currentTimeMillis()));
    ((Map)localObject).put("serviceInfoId", paramString1);
    ((Map)localObject).put("servicePmId", paramString2);
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramString1 = g.desEncrypt(a.toJSONString(localObject));
    paramString2 = g.toMd5(a.toJSONString(localObject).getBytes());
    localObject = f.getAppVersion();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, String> buildCommonHeader(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context不能为空");
    }
    if (TextUtils.isEmpty(g)) {
      g = f.getVersion();
    }
    if (TextUtils.isEmpty(h)) {
      h = f.getDeviceId(paramContext.getApplicationContext());
    }
    if (TextUtils.isEmpty(i)) {
      i = Build.MANUFACTURER + "#" + Build.MODEL + "#" + h;
    }
    paramContext = new HashMap();
    paramContext.put("Client-Version", g);
    paramContext.put("Accept", "application/json");
    paramContext.put("Sys", "app");
    paramContext.put("Client-Type", j + "");
    paramContext.put("User-Agent", i);
    paramContext.put("Request-Id", r.buildRequestId());
    paramContext.put("IMEI", h);
    paramContext.put("longitude", k.getLongitude() + "");
    paramContext.put("latitude", k.getLatitude() + "");
    return paramContext;
  }
  
  public static Map<String, String> buildCommonHeaderWithToken(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("token不能为空");
    }
    paramContext = buildCommonHeader(paramContext);
    paramContext.put("token", paramString);
    return paramContext;
  }
  
  public static Map<String, String> buildGetAppIDMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appType", "2");
    localHashMap.put("imei", f.getDeviceId(paramContext));
    localHashMap.put("source", "1");
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetRepairEngineer()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("city_code", com.ziroom.commonlib.utils.c.b);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("params", a.toJSONString(localHashMap1));
    return localHashMap2;
  }
  
  public static Map<String, Object> buildGetRepairScore(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairTime(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("empTypeId", paramString);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairType(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static com.alibaba.fastjson.e buildGetUnreadNum(com.alibaba.fastjson.e parame, long paramLong)
  {
    com.alibaba.fastjson.e locale = null;
    if (parame == null) {
      locale = new com.alibaba.fastjson.e();
    }
    locale.put("app", a);
    parame = "0";
    d locald = com.ziroom.commonlib.utils.b.getUserInfo();
    if (locald != null) {
      parame = locald.getUid();
    }
    locale.put("alias", g.toMd5(parame.getBytes()));
    locale.put("from", Long.valueOf(paramLong));
    l.i("PushFeedBackMap", a.toJSONString(locale, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return locale;
  }
  
  public static Map<String, Object> buildGetUnreadNum(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app", a);
    String str = "0";
    d locald = com.ziroom.commonlib.utils.b.getUserInfo();
    if (locald != null) {
      str = locald.getUid();
    }
    localHashMap.put("alias", g.toMd5(str.getBytes()));
    localHashMap.put("from", Long.valueOf(paramLong));
    l.i("PushFeedBackMap", a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> buildLoginV2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramString4)) {
      throw new IllegalArgumentException("密码不能为空！");
    }
    paramString1 = a(paramString1, paramString2, paramString3);
    paramString1.put("password", a(paramString4));
    if (!TextUtils.isEmpty(paramString5)) {
      paramString1.put("imgId", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramString1.put("imgVValue", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramString1.put("imgVid", paramString7);
    }
    return paramString1;
  }
  
  public static Map<String, Object> buildMHService()
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, String> buildMoveDates(Context paramContext, String paramString)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("serviceItemCode", paramString);
    return createPostEncode(paramContext);
  }
  
  public static Map<String, String> buildMoveTimes(Context paramContext, String paramString, long paramLong)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("serviceItemCode", paramString);
    paramContext.put("bookableDate", Long.valueOf(paramLong));
    return createPostEncode(paramContext);
  }
  
  public static Map<String, Object> buildNewCleanGoods(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.commonlib.utils.e.string2Long(com.ziroom.commonlib.utils.e.getCurrentTime(), com.ziroom.commonlib.utils.e.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    ((Map)localObject).put("serviceInfoId", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = g.desEncrypt(a.toJSONString(localObject));
    paramString = g.toMd5(a.toJSONString(localObject).getBytes());
    localObject = f.getAppVersion();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static com.alibaba.fastjson.e buildNewCreateGOrder(com.ziroom.datacenter.remote.responsebody.financial.clean.e parame, String paramString1, String paramString2, String paramString3)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("address", parame.getAddress());
    locale.put("addressId", parame.getAddressId());
    locale.put("appointDate", parame.getAppointDate());
    locale.put("linkPhone", parame.getLinkPhone());
    locale.put("price", Double.valueOf(parame.getPrice()));
    locale.put("promoCodeId", parame.getPromoCodeId());
    locale.put("remark", parame.getRemark());
    locale.put("serviceInfoId", parame.getServiceInfoId());
    locale.put("servicePmId", parame.getServicePmId());
    locale.put("timePeroidId", parame.getTimePeroidId());
    locale.put("uid", parame.getUid());
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("goods", a.toJSON(parame.getGoods()));
    locale.put("appointTime", parame.getAppointTime());
    locale.put("channelCode", paramString1);
    locale.put("operatorMan", paramString2);
    locale.put("employeeLogicCode", paramString3);
    locale.put("version", "V1.4");
    return locale;
  }
  
  public static Map<String, Object> buildNewGeneralAList(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.commonlib.utils.e.string2Long(com.ziroom.commonlib.utils.e.getCurrentTime(), com.ziroom.commonlib.utils.e.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    ((Map)localObject).put("uid", m.getUid());
    ((Map)localObject).put("version", "V1.4");
    paramContext = g.desEncrypt(a.toJSONString(localObject));
    localObject = g.toMd5(a.toJSONString(localObject).getBytes());
    String str = f.getAppVersion();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, String> buildRent(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = m.getToken();
    if (r.notNull(str)) {
      localHashMap.put("token", str);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    localHashMap.put("ab_type", paramInt + "");
    localHashMap.put("module", paramString);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildWithdraw(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str1 = m.getUid();
    String str2 = m.getToken();
    if (r.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (r.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("money", paramString);
    localHashMap.put("app", f.getVersion());
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildselectCleanerList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("appointDateTime", paramString2);
    localHashMap.put("serviceInfoId", paramString3);
    localHashMap.put("servicePmId", paramString4);
    localHashMap.put("addressId", paramString5);
    localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("versionNum", paramString6);
    l.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> combineParams(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("timestamp", Long.valueOf(System.currentTimeMillis() + q.getGateWayDiffTime()));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("osType", Integer.valueOf(2));
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    ((Map)localObject).put("dataSourceVersion", f.getAppVersion());
    paramMap = com.ziroom.commonlib.utils.b.getUserInfo();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getPhone());
    }
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, String> convertObjMap2String(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if ((paramMap.getValue() instanceof String))
      {
        localHashMap.put(paramMap.getKey(), (String)paramMap.getValue());
      }
      else if ((paramMap.getValue() instanceof Integer))
      {
        localHashMap.put(paramMap.getKey(), String.valueOf(paramMap.getValue()));
      }
      else if (paramMap.getValue() == null)
      {
        localHashMap.put(paramMap.getKey(), "");
        l.e("yangxj", "Utils.ConvertObjMap2String=== null");
      }
      else
      {
        localHashMap.put(paramMap.getKey(), String.valueOf(paramMap.getValue()));
        if ("Utils.ConvertObjMap2String===" + paramMap.getValue() + "======" + paramMap.getValue() == null) {}
        for (paramMap = "null";; paramMap = paramMap.getValue().getClass())
        {
          l.e("yangxj", paramMap);
          break;
        }
      }
    }
    return localHashMap;
  }
  
  public static Map<String, Object> createPostEncode(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", g.toMd5(paramString.getBytes()));
    localHashMap.put("2y5QfvAy", g.desEncrypt(paramString));
    l.e("createPostEncode", "======= json" + paramString);
    l.e("createPostEncode", "======= json" + a.toJSONString(localHashMap));
    return localHashMap;
  }
  
  public static Map<String, String> createPostEncode(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", g.toMd5(a.toJSONString(paramMap).getBytes()));
    localHashMap.put("2y5QfvAy", g.desEncrypt(a.toJSONString(paramMap)));
    return localHashMap;
  }
  
  public static Map<String, String> createPostEncodeString(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", g.toMd5(paramString.getBytes()));
    localHashMap.put("2y5QfvAy", g.desEncrypt(paramString));
    localHashMap.put("v", f.getVersion());
    l.d("dgdgg", "==== " + a.toJSON(paramString));
    l.d("dgdgg", "==== " + a.toJSON(localHashMap));
    return localHashMap;
  }
  
  public static Map<String, String> createRepairEncode(com.alibaba.fastjson.e parame)
  {
    HashMap localHashMap = new HashMap();
    if (parame == null) {
      localHashMap.put("json", a.toJSONString(""));
    }
    for (;;)
    {
      internalRepairBaseParams(localHashMap);
      l.d("createRepairEncode", "========   params=" + a.toJSONString(localHashMap));
      localHashMap.put("sign", signParams(localHashMap));
      return localHashMap;
      localHashMap.put("json", a.toJSONString(parame));
    }
  }
  
  public static Map<String, String> createYouPinEncode(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    long l1 = System.currentTimeMillis();
    long l2 = com.ziroom.commonlib.utils.b.getTimeDiff();
    ((Map)localObject).put("timestamp", l1 - l2 + "");
    ((Map)localObject).put("dataSource", "12");
    ((Map)localObject).put("osType", "2");
    ((Map)localObject).put("cityCode", p.getInstance().getString("currentYouPinCityCode", "000000"));
    ((Map)localObject).put("dataSourceVersion", f.getAppVersion());
    paramMap = com.ziroom.commonlib.utils.b.getUserInfo();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getPhone());
    }
    l.d("HandlerParser", "=====优品入参:" + a.toJSONString(localObject));
    return (Map<String, String>)localObject;
  }
  
  public static String encodeGetParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject;
      if (paramMap.get(str3) == null) {
        localObject = "";
      }
      for (;;)
      {
        try
        {
          str1 = URLEncoder.encode(str3, "utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          String str2;
          String str1 = str3;
        }
        try
        {
          str2 = URLEncoder.encode((String)localObject, "utf-8");
          localObject = str2;
          localStringBuilder.append("&" + str1 + "=" + (String)localObject);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;) {}
        }
        localObject = ((String)paramMap.get(str3)).toString();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    localStringBuilder.deleteCharAt(0);
    return localStringBuilder.toString();
  }
  
  public static Map<String, Object> getCardCommon(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(f.getDeviceId(paramContext.getApplicationContext()))) {
      localHashMap.put("uuid", f.getDeviceId(paramContext.getApplicationContext()));
    }
    for (;;)
    {
      localHashMap.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      localHashMap.put("appVersion", f.getVersion());
      localHashMap.put("interfaceVesion", Integer.valueOf(1));
      localHashMap.put("dataSource", Integer.valueOf(12));
      localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
      localHashMap.put("timestamp", String.valueOf(com.ziroom.commonlib.utils.e.string2Long(com.ziroom.commonlib.utils.e.getCurrentTime(), com.ziroom.commonlib.utils.e.c)).substring(0, 10));
      return localHashMap;
      localHashMap.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
  }
  
  public static Map<String, String> getCommonHouseSign(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str = "0";
      d locald = com.ziroom.commonlib.utils.b.getUserInfo();
      if (locald != null) {
        str = locald.getUid();
      }
      paramMap.put("timestamp", String.valueOf(com.ziroom.commonlib.utils.e.string2Long(com.ziroom.commonlib.utils.e.getCurrentTime(), com.ziroom.commonlib.utils.e.c)).substring(0, 10));
      paramMap.put("uid", str);
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", n.getIp());
      paramMap.put("network", n.GetNetworkType());
      paramMap.put("imei", f.getDeviceId());
      paramMap.put("app_version", f.getVersion());
      paramMap.put("sign_open", "1");
      paramMap.put("sign", toCommonPHPMD5(paramMap));
    }
    return paramMap;
  }
  
  public static String getGateWayParam(Object paramObject)
  {
    paramObject = a.toJSONString(paramObject);
    l.d("jkljkl", "======加密前请求:" + (String)paramObject);
    paramObject = g.desEncrypt((String)paramObject);
    l.d("jkj ", "=====加密后请求:" + (String)paramObject);
    return (String)paramObject;
  }
  
  public static Map<String, String> getHeader(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    long l1 = System.currentTimeMillis();
    long l2 = q.getGateWayDiffTime();
    String str1 = f.getDeviceId();
    if (str1 == null) {
      paramContext = "";
    }
    for (;;)
    {
      String str4 = f.getVersion();
      String str5 = Build.VERSION.RELEASE;
      try
      {
        str1 = URLEncoder.encode(Build.MODEL, "UTF-8");
        if (m.getLoginState())
        {
          str3 = m.getToken();
          localHashMap.put("timeStamp", l2 + l1 + "");
          localHashMap.put("appType", "1");
          localHashMap.put("osType", "android");
          localHashMap.put("imei", paramContext);
          localHashMap.put("appVersion", str4);
          localHashMap.put("osVersion", str5);
          localHashMap.put("phoneName", str1);
          localHashMap.put("Content-Type", "application/json");
          localHashMap.put("token", str3);
          localHashMap.put("Client-Version", str4);
          localHashMap.put("Sys", "app");
          localHashMap.put("Request-Id", r.buildRequestId());
          localHashMap.put("Accept", "application/json");
          l.d("header", a.toJSONString(localHashMap));
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
  
  public static com.alibaba.fastjson.e getMvCommon(Context paramContext)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    if (!TextUtils.isEmpty(f.getDeviceId(paramContext.getApplicationContext()))) {
      locale.put("uuid", f.getDeviceId(paramContext.getApplicationContext()));
    }
    for (;;)
    {
      locale.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      if (TextUtils.isEmpty(k)) {
        k = f.getVersion();
      }
      locale.put("appVersion", k);
      locale.put("interfaceVesion", Integer.valueOf(1));
      locale.put("dataSource", Integer.valueOf(12));
      locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
      locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      return locale;
      locale.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
  }
  
  public static HashMap<String, String> getMvCommon(Context paramContext, Map<String, String> paramMap)
  {
    HashMap localHashMap = null;
    if (paramMap == null) {
      localHashMap = new HashMap();
    }
    if (!TextUtils.isEmpty(f.getDeviceId(paramContext.getApplicationContext()))) {
      localHashMap.put("uuid", f.getDeviceId(paramContext.getApplicationContext()));
    }
    for (;;)
    {
      localHashMap.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      if (TextUtils.isEmpty(k)) {
        k = f.getVersion();
      }
      localHashMap.put("appVersion", k);
      localHashMap.put("interfaceVesion", "1");
      localHashMap.put("dataSource", "12");
      localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
      localHashMap.put("timestamp", System.currentTimeMillis() + "");
      return localHashMap;
      localHashMap.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
  }
  
  public static Map<String, Object> getNewHouseSign(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str = "0";
      d locald = com.ziroom.commonlib.utils.b.getUserInfo();
      if (locald != null) {
        str = locald.getUid();
      }
      paramMap.put("timestamp", String.valueOf(com.ziroom.commonlib.utils.e.string2Long(com.ziroom.commonlib.utils.e.getCurrentTime(), com.ziroom.commonlib.utils.e.c)).substring(0, 10));
      paramMap.put("uid", str);
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", n.getIp());
      paramMap.put("network", n.GetNetworkType());
      paramMap.put("imei", f.getDeviceId());
      paramMap.put("app_version", f.getVersion());
      paramMap.put("sign_open", "1");
      paramMap.put("sign", toPHPMD5(paramMap));
    }
    return paramMap;
  }
  
  public static String getParam(Map<String, String> paramMap)
  {
    paramMap = a.toJSONString(paramMap);
    l.d("GatewayUtil", "======加密前请求:" + paramMap);
    paramMap = g.desEncrypt(paramMap);
    l.d("GatewayUtil ", "=====加密后请求:" + paramMap);
    return paramMap;
  }
  
  public static Map<String, String> getPassportSign(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("auth_code", "600001");
    ((Map)localObject).put("timestamp", ("" + System.currentTimeMillis()).substring(0, 10));
    ((Map)localObject).put("app", f.getVersion());
    ((Map)localObject).put("os_type", "Android");
    ((Map)localObject).put("os_version", Build.VERSION.RELEASE);
    ((Map)localObject).put("sign", toCommonPassportPHPMD5((Map)localObject));
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, String> internalRepairBaseParams(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appVersionStr", f.getVersion());
    ((Map)localObject).put("cityCode", com.ziroom.commonlib.utils.c.b);
    ((Map)localObject).put("uid", m.getUid());
    ((Map)localObject).put("versionNumberStr", "1.0.0");
    ((Map)localObject).put("appVersion", f.getVersion());
    return (Map<String, String>)localObject;
  }
  
  public static String signParams(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Collections.sort(localArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    if (m < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(m);
      if ("sign".equals(str1)) {}
      for (;;)
      {
        m += 1;
        break;
        String str2 = (String)paramMap.get(str1);
        localStringBuilder.append(str1).append("=").append(str2);
        localStringBuilder.append("&");
      }
    }
    if (4 == h.getsEnvironment()) {}
    for (paramMap = SignKeyUtil.getSignKey();; paramMap = "d2a57dc1d883fd21fb9951699df71cc7")
    {
      localStringBuilder.append(paramMap);
      return signToMd5(localStringBuilder.toString()).toUpperCase();
    }
  }
  
  public static String signToMd5(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer("");
      int m = 0;
      while (m < paramString.length)
      {
        int i1 = paramString[m];
        int n = i1;
        if (i1 < 0) {
          n = i1 + 256;
        }
        if (n < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(n));
        m += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String toCommonPHPMD5(Map<String, String> paramMap)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= arrayOfString.length) {
        break;
      }
      n = 0;
      while (n < arrayOfString.length - m - 1)
      {
        if (arrayOfString[n].compareTo(arrayOfString[(n + 1)]) > 0)
        {
          String str = arrayOfString[n];
          arrayOfString[n] = arrayOfString[(n + 1)];
          arrayOfString[(n + 1)] = str;
        }
        n += 1;
      }
      m += 1;
    }
    if (n < paramMap.size())
    {
      if (paramMap.get(arrayOfString[n]) != null) {
        localStringBuffer.append(arrayOfString[n] + "=" + (String)paramMap.get(arrayOfString[n]) + "&");
      }
      for (;;)
      {
        n += 1;
        break;
        localStringBuffer.append(arrayOfString[n] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(com.ziroom.datacenter.remote.f.c.a);
    return g.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toCommonPassportPHPMD5(Map<String, String> paramMap)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= arrayOfString.length) {
        break;
      }
      n = 0;
      while (n < arrayOfString.length - m - 1)
      {
        if (arrayOfString[n].compareTo(arrayOfString[(n + 1)]) > 0)
        {
          String str = arrayOfString[n];
          arrayOfString[n] = arrayOfString[(n + 1)];
          arrayOfString[(n + 1)] = str;
        }
        n += 1;
      }
      m += 1;
    }
    if (n < paramMap.size())
    {
      if (paramMap.get(arrayOfString[n]) != null) {
        localStringBuffer.append(arrayOfString[n] + "=" + (String)paramMap.get(arrayOfString[n]) + "&");
      }
      for (;;)
      {
        n += 1;
        break;
        localStringBuffer.append(arrayOfString[n] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(com.ziroom.datacenter.remote.f.c.b);
    l.e("sign加密", localStringBuffer.toString());
    return g.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toMD5(Map<String, Object> paramMap)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= arrayOfString.length) {
        break;
      }
      n = 0;
      while (n < arrayOfString.length - m - 1)
      {
        if (arrayOfString[n].compareTo(arrayOfString[(n + 1)]) > 0)
        {
          String str = arrayOfString[n];
          arrayOfString[n] = arrayOfString[(n + 1)];
          arrayOfString[(n + 1)] = str;
        }
        n += 1;
      }
      m += 1;
    }
    if (n < paramMap.size())
    {
      if (paramMap.get(arrayOfString[n]) != null) {
        localStringBuffer.append(arrayOfString[n] + "=" + paramMap.get(arrayOfString[n]) + "");
      }
      for (;;)
      {
        n += 1;
        break;
        localStringBuffer.append(arrayOfString[n] + "=");
      }
    }
    return g.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toMD5ForNetworkHelper(Map<String, String> paramMap)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= arrayOfString.length) {
        break;
      }
      n = 0;
      while (n < arrayOfString.length - m - 1)
      {
        if (arrayOfString[n].compareTo(arrayOfString[(n + 1)]) > 0)
        {
          String str = arrayOfString[n];
          arrayOfString[n] = arrayOfString[(n + 1)];
          arrayOfString[(n + 1)] = str;
        }
        n += 1;
      }
      m += 1;
    }
    if (n < paramMap.size())
    {
      if (paramMap.get(arrayOfString[n]) != null) {
        localStringBuffer.append(arrayOfString[n] + "=" + (String)paramMap.get(arrayOfString[n]) + "");
      }
      for (;;)
      {
        n += 1;
        break;
        localStringBuffer.append(arrayOfString[n] + "=");
      }
    }
    return g.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toPHPMD5(Map<String, Object> paramMap)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= arrayOfString.length) {
        break;
      }
      n = 0;
      while (n < arrayOfString.length - m - 1)
      {
        if (arrayOfString[n].compareTo(arrayOfString[(n + 1)]) > 0)
        {
          String str = arrayOfString[n];
          arrayOfString[n] = arrayOfString[(n + 1)];
          arrayOfString[(n + 1)] = str;
        }
        n += 1;
      }
      m += 1;
    }
    if (n < paramMap.size())
    {
      if (paramMap.get(arrayOfString[n]) != null) {
        localStringBuffer.append(arrayOfString[n] + "=" + paramMap.get(arrayOfString[n]) + "&");
      }
      for (;;)
      {
        n += 1;
        break;
        localStringBuffer.append(arrayOfString[n] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(com.ziroom.datacenter.remote.f.c.a);
    l.e("sign加密", localStringBuffer.toString());
    return g.toMd5(localStringBuffer.toString().getBytes());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */