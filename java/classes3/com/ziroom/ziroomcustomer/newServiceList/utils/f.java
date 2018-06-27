package com.ziroom.ziroomcustomer.newServiceList.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.t;
import com.ziroom.ziroomcustomer.newclean.d.x;
import com.ziroom.ziroomcustomer.newrepair.utils.c;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.k;
import com.ziroom.ziroomcustomer.util.u;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class f
{
  public static String a = "";
  
  public static e buildBedroomCreateGOrder(t paramt, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("address", paramt.getAddress());
    locale.put("addressId", paramt.getAddressId());
    locale.put("appointDate", paramt.getAppointDate());
    locale.put("linkPhone", paramt.getLinkPhone());
    locale.put("price", Double.valueOf(paramt.getPrice()));
    locale.put("promoCodeId", paramt.getPromoCodeId());
    locale.put("remark", paramt.getRemark());
    locale.put("serviceInfoId", paramt.getServiceInfoId());
    locale.put("servicePmId", paramt.getServicePmId());
    locale.put("timePeroidId", paramt.getTimePeroidId());
    locale.put("uid", paramt.getUid());
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("goods", com.alibaba.fastjson.a.toJSON(paramt.getGoods()));
    locale.put("appointTime", paramt.getAppointTime());
    locale.put("channelCode", paramString1);
    locale.put("operatorMan", paramString2);
    locale.put("employeeLogicCode", paramString3);
    locale.put("version", "V1.4");
    locale.put("whether", Integer.valueOf(paramInt));
    return locale;
  }
  
  public static e buildNewCleanCostEstimates(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, List<x> paramList, String paramString20)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("serviceInfoId", paramString2);
    locale.put("uid", paramString1);
    locale.put("serviceInfoName", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("servicePmName", paramString5);
    locale.put("appointDate", paramString6);
    locale.put("timePeroidId", paramString7);
    locale.put("timePeroid", paramString8);
    locale.put("addressId", paramString9);
    locale.put("address", paramString10);
    locale.put("addressXY", paramString11);
    locale.put("remark", paramString12);
    locale.put("dataSource", Integer.valueOf(paramInt));
    locale.put("linkMan", paramString13);
    locale.put("linkPhone", paramString14);
    locale.put("promoCodeId", paramString15);
    locale.put("price", paramString16);
    locale.put("servicePrice", paramString17);
    locale.put("discountPrice", paramString18);
    locale.put("goodsPrice", paramString19);
    locale.put("goods", com.alibaba.fastjson.a.toJSON(paramList));
    locale.put("appointTime", paramString20);
    locale.put("version", "V1.4");
    return locale;
  }
  
  public static e buildNewCreateGOrder(t paramt, String paramString1, String paramString2, String paramString3)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("address", paramt.getAddress());
    locale.put("addressId", paramt.getAddressId());
    locale.put("appointDate", paramt.getAppointDate());
    locale.put("linkPhone", paramt.getLinkPhone());
    locale.put("price", Double.valueOf(paramt.getPrice()));
    locale.put("promoCodeId", paramt.getPromoCodeId());
    locale.put("remark", paramt.getRemark());
    locale.put("serviceInfoId", paramt.getServiceInfoId());
    locale.put("servicePmId", paramt.getServicePmId());
    locale.put("timePeroidId", paramt.getTimePeroidId());
    locale.put("uid", paramt.getUid());
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("goods", com.alibaba.fastjson.a.toJSON(paramt.getGoods()));
    locale.put("appointTime", paramt.getAppointTime());
    locale.put("channelCode", paramString1);
    locale.put("operatorMan", paramString2);
    locale.put("employeeLogicCode", paramString3);
    locale.put("version", "V1.4");
    return locale;
  }
  
  public static Map<String, String> createRepairEncode(e parame)
  {
    HashMap localHashMap = new HashMap();
    if (parame == null) {
      localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(""));
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.g.InternalRepairBaseParams(localHashMap);
      u.d("createRepairEncode", "========   params=" + com.alibaba.fastjson.a.toJSONString(localHashMap));
      localHashMap.put("sign", c.signParams(localHashMap));
      return localHashMap;
      localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(parame));
    }
  }
  
  public static Map<String, String> createYouPinEncode(Map<String, String> paramMap, Context paramContext)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    long l1 = System.currentTimeMillis();
    long l2 = ApplicationEx.c.getTimeDiff();
    ((Map)localObject).put("timestamp", l1 - l2 + "");
    ((Map)localObject).put("dataSource", "12");
    ((Map)localObject).put("osType", "2");
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.minsu.f.aa.getString(paramContext, "currentYouPinCityCode", "000000"));
    ((Map)localObject).put("dataSourceVersion", ah.getAppVersion(ApplicationEx.c));
    paramMap = ApplicationEx.c.getUser();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getLogin_name_mobile());
    }
    d.d("HandlerParser", "=====优品入参:" + com.alibaba.fastjson.a.toJSONString(localObject));
    return (Map<String, String>)localObject;
  }
  
  public static e getCleanCommon(Context paramContext)
  {
    paramContext = new e();
    paramContext.put("versionNum", "1.0");
    paramContext.put("dataSource", Integer.valueOf(12));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    return paramContext;
  }
  
  public static Map<String, String> getGateWayHeader(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    long l1 = System.currentTimeMillis();
    long l2 = ad.getGateWayDiffTime(paramContext.getApplicationContext());
    String str2 = ah.getDeviceId(paramContext.getApplicationContext());
    String str1;
    if (str2 == null) {
      str1 = "";
    }
    for (;;)
    {
      String str4 = ah.getAppVersion(paramContext.getApplicationContext());
      String str5 = Build.VERSION.RELEASE;
      try
      {
        str2 = URLEncoder.encode(Build.MODEL, "UTF-8");
        if (ApplicationEx.c.isLoginState())
        {
          paramContext = com.ziroom.commonlibrary.login.a.getToken(paramContext.getApplicationContext());
          localHashMap.put("timeStamp", l2 + l1 + "");
          localHashMap.put("appType", "1");
          localHashMap.put("osType", "android");
          localHashMap.put("imei", str1);
          localHashMap.put("appVersion", str4);
          localHashMap.put("osVersion", str5);
          localHashMap.put("phoneName", str2);
          localHashMap.put("Content-Type", "application/json");
          localHashMap.put("token", paramContext);
          localHashMap.put("Client-Version", str4);
          localHashMap.put("Sys", "app");
          localHashMap.put("Request-Id", com.ziroom.commonlibrary.g.b.buildRequestId());
          localHashMap.put("Accept", "application/json");
          return localHashMap;
          str1 = str2;
          if (!str2.startsWith("0000000")) {
            continue;
          }
          str1 = UUID.randomUUID().toString();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str3 = "";
          continue;
          paramContext = "";
        }
      }
    }
  }
  
  public static String getGateWayParam(e parame)
  {
    parame = com.alibaba.fastjson.a.toJSONString(parame);
    d.d("jkljkl", "======加密前请求:" + parame);
    parame = k.encrypt(parame);
    d.d("jkj ", "=====加密后请求:" + parame);
    return parame;
  }
  
  public static e getMvCommon(Context paramContext)
  {
    e locale = new e();
    if (!TextUtils.isEmpty(ah.getDeviceId(paramContext.getApplicationContext()))) {
      locale.put("uuid", ah.getDeviceId(paramContext.getApplicationContext()));
    }
    for (;;)
    {
      locale.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      if (TextUtils.isEmpty(a)) {
        a = ah.getVersion(paramContext.getApplicationContext());
      }
      locale.put("appVersion", a);
      locale.put("interfaceVesion", Integer.valueOf(1));
      locale.put("dataSource", Integer.valueOf(12));
      locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      return locale;
      locale.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
  }
  
  public static String getRasParam(e parame)
  {
    try
    {
      parame = com.alibaba.fastjson.a.toJSONString(parame, new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
      u.d("buildgetRentList jsonParams", "======  " + parame);
      PublicKey localPublicKey = com.ziroom.ziroomcustomer.util.aa.loadPublicKey(com.ziroom.ziroomcustomer.util.aa.a);
      parame = URLEncoder.encode(com.ziroom.ziroomcustomer.util.g.encode(com.ziroom.ziroomcustomer.util.aa.encrypt(parame.getBytes("UTF-8"), localPublicKey)), "utf-8");
      return parame;
    }
    catch (Exception parame)
    {
      parame.printStackTrace();
    }
    return null;
  }
  
  public static String getRasParam(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = com.alibaba.fastjson.a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
      u.d("buildgetRentList jsonParams", "======  " + paramMap);
      PublicKey localPublicKey = com.ziroom.ziroomcustomer.util.aa.loadPublicKey(com.ziroom.ziroomcustomer.util.aa.a);
      paramMap = URLEncoder.encode(com.ziroom.ziroomcustomer.util.g.encode(com.ziroom.ziroomcustomer.util.aa.encrypt(paramMap.getBytes("UTF-8"), localPublicKey)), "utf-8");
      return paramMap;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
    return null;
  }
  
  public static String getRasResult(String paramString)
  {
    try
    {
      PublicKey localPublicKey = com.ziroom.ziroomcustomer.util.aa.loadPublicKey(com.ziroom.ziroomcustomer.util.aa.a);
      paramString = new String(com.ziroom.ziroomcustomer.util.aa.decrypt(com.ziroom.ziroomcustomer.util.g.decode(paramString), localPublicKey));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */