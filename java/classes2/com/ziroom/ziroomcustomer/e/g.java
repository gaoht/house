package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.model.ActiveMessage;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.f;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class g
{
  private static Map<String, Object> a;
  
  public static Map<String, Object> ConfrimContract(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("jsonString", paramString1);
    localHashMap.put("verificationCode", paramString2);
    localHashMap.put("contractCode", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> InternalRepairBaseParams(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appVersionStr", ah.getVersion(ApplicationEx.c));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramMap = ApplicationEx.c.getUser();
    if (paramMap != null) {
      ((Map)localObject).put("uid", paramMap.getUid());
    }
    ((Map)localObject).put("versionNumberStr", "1.0.0");
    ((Map)localObject).put("appVersion", ah.getVersion(ApplicationEx.c));
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> SubmitContractInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("jsonString", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  private static void a(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    String str;
    if ("keywords".equals(paramString2))
    {
      str = paramString1;
      paramMap.put("keywords", str);
      if (!"bizcircle".equals(paramString2)) {
        break label111;
      }
      str = paramString1;
      label32:
      paramMap.put("bizcircle", str);
      if (!"subway".equals(paramString2)) {
        break label117;
      }
      str = paramString1;
      label53:
      paramMap.put("subway", str);
      if (!"resblock_id".equals(paramString2)) {
        break label123;
      }
    }
    for (;;)
    {
      paramMap.put("resblock_id", paramString1);
      paramMap.put("clng", "");
      paramMap.put("clat", "");
      return;
      str = "";
      break;
      label111:
      str = "";
      break label32;
      label117:
      str = "";
      break label53;
      label123:
      paramString1 = "";
    }
  }
  
  public static void appendCommenParams(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("source", Integer.valueOf(1));
      long l = System.currentTimeMillis() - ApplicationEx.c.getTimeDiff();
      paramMap.put("timestamp", Long.valueOf(l));
      String str = com.ziroom.commonlib.utils.b.getAppId();
      if (ae.isNull(str)) {
        ApplicationEx.c.getHttpAppID();
      }
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
  
  public static void appendCommenParamsString(Map<String, String> paramMap)
  {
    long l;
    String str2;
    if (paramMap != null)
    {
      paramMap.put("source", "1");
      l = System.currentTimeMillis() - ApplicationEx.c.getTimeDiff();
      paramMap.put("timestamp", l + "");
      str2 = com.ziroom.commonlib.utils.b.getAppId();
      if (ae.isNull(str2)) {
        ApplicationEx.c.getHttpAppID();
      }
      paramMap.put("appId", str2);
      paramMap.put("appType", "2");
      if (ah.getDeviceId(ApplicationEx.c) != null) {
        break label222;
      }
    }
    label222:
    for (String str1 = "";; str1 = ah.getDeviceId(ApplicationEx.c))
    {
      paramMap.put("imei", str1);
      paramMap.put("uuid", str2 + "_" + l);
      paramMap.put("osType", "2");
      paramMap.put("appVersionStr", ah.getVersion(ApplicationEx.c));
      paramMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      if (paramMap.containsKey("sign")) {
        paramMap.remove("sign");
      }
      paramMap.put("sign", toMD5String(paramMap));
      return;
    }
  }
  
  public static Map<String, String> boundParams(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    d.d("HandlerParser", "=====优品入参:" + com.alibaba.fastjson.a.toJSONString(localObject));
    long l1 = System.currentTimeMillis();
    long l2 = ApplicationEx.c.getTimeDiff();
    ((Map)localObject).put("timestamp", l1 - l2 + "");
    ((Map)localObject).put("dataSource", "12");
    ((Map)localObject).put("osType", "2");
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("dataSourceVersion", ah.getAppVersion(ApplicationEx.c));
    paramMap = ApplicationEx.c.getUser();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getLogin_name_mobile());
    }
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> buildAddActiveMessageList(ActiveMessage paramActiveMessage)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramActiveMessage.getUid());
    localHashMap.put("building_code", paramActiveMessage.getBuilding_code());
    localHashMap.put("building_name", paramActiveMessage.getBuilding_name());
    localHashMap.put("for_where", paramActiveMessage.getFor_where());
    localHashMap.put("create_name", paramActiveMessage.getCreate_name());
    localHashMap.put("cate", paramActiveMessage.getCate());
    localHashMap.put("fanwei", paramActiveMessage.getFanwei());
    localHashMap.put("activity_name", paramActiveMessage.getActivity_name());
    localHashMap.put("img", paramActiveMessage.getImg());
    localHashMap.put("addr", paramActiveMessage.getAddr());
    localHashMap.put("begin_time", paramActiveMessage.getBegin_time());
    localHashMap.put("end_time", paramActiveMessage.getEnd_time());
    localHashMap.put("xd_number", Integer.valueOf(paramActiveMessage.getXd_number()));
    localHashMap.put("introduce", paramActiveMessage.getIntroduce());
    localHashMap.put("create_time", paramActiveMessage.getCreate_time());
    return localHashMap;
  }
  
  public static Map<String, Object> buildAddCards(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", Integer.valueOf(600001));
    localHashMap.put("bank_area", paramString1);
    localHashMap.put("bank_code", paramString2);
    localHashMap.put("card_code", paramString3);
    localHashMap.put("bank_name", paramString4);
    localHashMap.put("mobile", paramString5);
    localHashMap.put("app", ah.getVersion(ApplicationEx.c));
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildAppID(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appType", "2");
    localHashMap.put("imei", paramString);
    localHashMap.put("source", "1");
    return localHashMap;
  }
  
  public static Map<String, Object> buildAppoint(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("userName", paramString2);
    localHashMap.put("userPhone", paramString3);
    localHashMap.put("houseId", paramString4);
    localHashMap.put("houseCode", paramString5);
    localHashMap.put("houseType", paramString6);
    localHashMap.put("villageId", paramString7);
    localHashMap.put("prepareSoruce", Integer.valueOf(0));
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildBalance()
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", Integer.valueOf(600001));
    localHashMap.put("app", ah.getVersion(ApplicationEx.c));
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildBillChildGroupMeter(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString);
    localHashMap.put("page", paramInt2 + "");
    localHashMap.put("size", paramInt3 + "");
    localHashMap.put("payStatus", paramInt1 + "");
    paramString = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramString = localUserInfo.getUid();
    }
    localHashMap.put("clientCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildBillInfo(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("payType", paramString1);
    localMap.put("period", paramString2);
    localMap.put("uniqueCode", paramString3);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildBizcircleList(String paramString1, String paramString2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("city_id", paramString1);
    localMap.put("district_name", paramString2);
    return localMap;
  }
  
  public static Map<String, Object> buildBizcircleListNew(SearchCondition paramSearchCondition)
  {
    int i = 0;
    Map localMap = getHouseSign(new HashMap());
    Object localObject;
    if (paramSearchCondition != null)
    {
      localObject = paramSearchCondition.getMoneyStr();
      if (!ae.isNull((String)localObject))
      {
        if (!"3000元以下".equals(localObject)) {
          break label467;
        }
        paramSearchCondition.setMin_rentfee("0");
        paramSearchCondition.setMax_rentfee("3000");
      }
      localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
      localMap.put("min_lng", paramSearchCondition.getMin_lng());
      localMap.put("max_lng", paramSearchCondition.getMax_lng());
      localMap.put("min_lat", paramSearchCondition.getMin_lat());
      localMap.put("max_lat", paramSearchCondition.getMax_lat());
      localMap.put("min_rentfee", paramSearchCondition.getMin_rentfee());
      localMap.put("max_rentfee", paramSearchCondition.getMax_rentfee());
      localMap.put("min_area", paramSearchCondition.getMin_area());
      localMap.put("max_area", paramSearchCondition.getMax_area());
      localMap.put("huxing", paramSearchCondition.getHuxing());
      localMap.put("heating", paramSearchCondition.getHeating());
      localMap.put("house_tags[0]", Integer.valueOf(paramSearchCondition.getHouse_tags_0()));
      localMap.put("house_tags[1]", Integer.valueOf(paramSearchCondition.getHouse_tags_1()));
      localMap.put("house_tags[2]", Integer.valueOf(paramSearchCondition.getHouse_tags_2()));
      localMap.put("house_tags[3]", Integer.valueOf(paramSearchCondition.getHouse_tags_3()));
      localMap.put("house_tags[4]", Integer.valueOf(paramSearchCondition.getHouse_tags_4()));
      localMap.put("house_tags[6]", Integer.valueOf(paramSearchCondition.getHouse_tags_6()));
      if (!paramSearchCondition.getHouse_type().equals("合租")) {
        break label617;
      }
    }
    for (;;)
    {
      localMap.put("house_tags[5]", Integer.valueOf(i));
      localMap.put("heating", "0");
      localMap.put("is_commute", paramSearchCondition.getIs_commute());
      localMap.put("commute_name", paramSearchCondition.getCommute_name());
      localMap.put("work_time", paramSearchCondition.getWork_time());
      localMap.put("tran_sport", paramSearchCondition.getTran_sport());
      localMap.put("longitude_and_latitude", paramSearchCondition.getLongitude_and_latitude());
      localMap.put("style_code", paramSearchCondition.getStyle_code());
      localMap.put("can_sign", Integer.valueOf(paramSearchCondition.getCan_sign()));
      localMap.put("is_reserve", Integer.valueOf(paramSearchCondition.getIs_reserve()));
      return localMap;
      label467:
      if ("7000元以上".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("7000");
        paramSearchCondition.setMax_rentfee("0");
        break;
      }
      if ("1500元以下".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("0");
        paramSearchCondition.setMax_rentfee("1500");
        break;
      }
      if ("3500元以上".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("3500");
        paramSearchCondition.setMax_rentfee("0");
        break;
      }
      if ("租金".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("");
        paramSearchCondition.setMax_rentfee("");
        break;
      }
      localObject = ((String)localObject).split("-");
      if (localObject.length < 2) {
        break;
      }
      paramSearchCondition.setMin_rentfee(localObject[0].replace("元", ""));
      paramSearchCondition.setMax_rentfee(localObject[1].replace("元", ""));
      break;
      label617:
      i = 1;
    }
  }
  
  public static Map<String, Object> buildBuildingHouseList(String paramString, SearchCondition paramSearchCondition, int paramInt1, int paramInt2)
  {
    Map localMap = getHouseSign(new HashMap());
    String str;
    if (paramSearchCondition != null)
    {
      str = paramSearchCondition.getSubWayStr();
      if (ae.isNull(str)) {
        break label505;
      }
      str = str.trim().replace("+", ",");
      localMap.put("building_code", paramString);
      localMap.put("min_lng", paramSearchCondition.getMin_lng());
      localMap.put("max_lng", paramSearchCondition.getMax_lng());
      localMap.put("min_lat", paramSearchCondition.getMin_lat());
      localMap.put("max_lat", paramSearchCondition.getMax_lat());
      localMap.put("subway_station_name", str);
      localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
      localMap.put("min_rentfee", paramSearchCondition.getMin_rentfee());
      localMap.put("max_rentfee", paramSearchCondition.getMax_rentfee());
      localMap.put("min_area", paramSearchCondition.getMin_area());
      localMap.put("max_area", paramSearchCondition.getMax_area());
      localMap.put("huxing", paramSearchCondition.getHuxing());
      localMap.put("heating", paramSearchCondition.getHeating());
      localMap.put("house_tags[0]", Integer.valueOf(paramSearchCondition.getHouse_tags_0()));
      localMap.put("house_tags[1]", Integer.valueOf(paramSearchCondition.getHouse_tags_1()));
      localMap.put("house_tags[2]", Integer.valueOf(paramSearchCondition.getHouse_tags_2()));
      localMap.put("house_tags[3]", Integer.valueOf(paramSearchCondition.getHouse_tags_3()));
      localMap.put("house_tags[4]", Integer.valueOf(paramSearchCondition.getHouse_tags_4()));
      localMap.put("house_tags[6]", Integer.valueOf(paramSearchCondition.getHouse_tags_6()));
      if (!paramSearchCondition.getHouse_type().equals("合租")) {
        break label512;
      }
    }
    label505:
    label512:
    for (int i = 0;; i = 1)
    {
      localMap.put("house_type", Integer.valueOf(i));
      localMap.put("house_tags[5]", Integer.valueOf(i));
      localMap.put("style_code", paramSearchCondition.getStyle_code());
      localMap.put("style_codes", paramSearchCondition.getStyle_codes());
      localMap.put("version_id", paramSearchCondition.getVersion_id());
      localMap.put("can_sign", Integer.valueOf(paramSearchCondition.getCan_sign()));
      localMap.put("is_reserve", Integer.valueOf(paramSearchCondition.getIs_reserve()));
      localMap.put("start", Integer.valueOf(paramInt1));
      localMap.put("end", Integer.valueOf(paramInt2));
      return localMap;
      str = "";
      break;
    }
  }
  
  public static Map<String, Object> buildBuildingList(SearchCondition paramSearchCondition)
  {
    Map localMap = getHouseSign(new HashMap());
    String str;
    Object localObject;
    if (paramSearchCondition != null)
    {
      str = paramSearchCondition.getSubWayStr();
      if (ae.isNull(str)) {
        break label563;
      }
      str = str.trim().replace("+", ",");
      localObject = paramSearchCondition.getMoneyStr();
      if (!ae.isNull((String)localObject))
      {
        if (!"3000元以下".equals(localObject)) {
          break label569;
        }
        paramSearchCondition.setMin_rentfee("0");
        paramSearchCondition.setMax_rentfee("3000");
      }
      label79:
      localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
      localMap.put("min_lng", paramSearchCondition.getMin_lng());
      localMap.put("max_lng", paramSearchCondition.getMax_lng());
      localMap.put("min_lat", paramSearchCondition.getMin_lat());
      localMap.put("max_lat", paramSearchCondition.getMax_lat());
      localMap.put("subway_station_name", str);
      localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
      localMap.put("min_rentfee", paramSearchCondition.getMin_rentfee());
      localMap.put("max_rentfee", paramSearchCondition.getMax_rentfee());
      localMap.put("min_area", paramSearchCondition.getMin_area());
      localMap.put("max_area", paramSearchCondition.getMax_area());
      localMap.put("huxing", paramSearchCondition.getHuxing());
      localMap.put("heating", paramSearchCondition.getHeating());
      localMap.put("house_tags[0]", Integer.valueOf(paramSearchCondition.getHouse_tags_0()));
      localMap.put("house_tags[1]", Integer.valueOf(paramSearchCondition.getHouse_tags_1()));
      localMap.put("house_tags[2]", Integer.valueOf(paramSearchCondition.getHouse_tags_2()));
      localMap.put("house_tags[3]", Integer.valueOf(paramSearchCondition.getHouse_tags_3()));
      localMap.put("house_tags[4]", Integer.valueOf(paramSearchCondition.getHouse_tags_4()));
      localMap.put("house_tags[6]", Integer.valueOf(paramSearchCondition.getHouse_tags_6()));
      if (!"合租".equals(paramSearchCondition.getHouse_type())) {
        break label728;
      }
    }
    label563:
    label569:
    label728:
    for (int i = 0;; i = 1)
    {
      localMap.put("house_type", Integer.valueOf(i));
      localMap.put("house_tags[5]", Integer.valueOf(i));
      localMap.put("heating", "0");
      localMap.put("is_commute", paramSearchCondition.getIs_commute());
      localMap.put("commute_name", paramSearchCondition.getCommute_name());
      localMap.put("work_time", paramSearchCondition.getWork_time());
      localMap.put("tran_sport", paramSearchCondition.getTran_sport());
      localMap.put("longitude_and_latitude", paramSearchCondition.getLongitude_and_latitude());
      localMap.put("style_code", paramSearchCondition.getStyle_code());
      localMap.put("style_codes", paramSearchCondition.getStyle_codes());
      localMap.put("version_id", paramSearchCondition.getVersion_id());
      localMap.put("can_sign", Integer.valueOf(paramSearchCondition.getCan_sign()));
      localMap.put("is_reserve", Integer.valueOf(paramSearchCondition.getIs_reserve()));
      return localMap;
      str = "";
      break;
      if ("7000元以上".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("7000");
        paramSearchCondition.setMax_rentfee("0");
        break label79;
      }
      if ("1500元以下".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("0");
        paramSearchCondition.setMax_rentfee("1500");
        break label79;
      }
      if ("3500元以上".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("3500");
        paramSearchCondition.setMax_rentfee("0");
        break label79;
      }
      if ("租金".equals(localObject))
      {
        paramSearchCondition.setMin_rentfee("");
        paramSearchCondition.setMax_rentfee("");
        break label79;
      }
      localObject = ((String)localObject).split("-");
      if (localObject.length < 2) {
        break label79;
      }
      paramSearchCondition.setMin_rentfee(localObject[0].replace("元", ""));
      paramSearchCondition.setMax_rentfee(localObject[1].replace("元", ""));
      break label79;
    }
  }
  
  public static Map<String, Object> buildCancelOpenInvoice(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("applyCode", paramString2);
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildCaptchaImage(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("contractCode", paramString);
    return localHashMap;
  }
  
  public static String buildChangPwd(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("old password", paramString3);
    localHashMap.put("new password", paramString2);
    paramString1 = com.alibaba.fastjson.a.toJSON(localHashMap).toString();
    try
    {
      paramString2 = new SecretKeySpec(SignKeyUtil.getKey().getBytes(), "DESede");
      paramString3 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      paramString3.init(1, paramString2);
      paramString1 = f.encode(paramString3.doFinal(paramString1.getBytes("UTF-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, Object> buildChangePswByCode(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("phone", paramString1);
    localMap.put("new_password", paramString3);
    localMap.put("sms_code", paramString2);
    return localMap;
  }
  
  public static Map<String, Object> buildCheckCanPay(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("checkBusinessType", paramString1);
    localHashMap.put("contractCode", paramString2);
    localHashMap.put("period", Integer.valueOf(paramInt));
    localHashMap.put("billNumList", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildCheckHasEvaluate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("requesterId", paramString1);
    localHashMap.put("requesterType", paramString2);
    localHashMap.put("beEvaluatorId", paramString3);
    localHashMap.put("beEvaluatorType", paramString4);
    localHashMap.put("questionType", paramString5);
    localHashMap.put("orderCode", paramString6);
    localHashMap.put("channelCode", "app");
    return localHashMap;
  }
  
  public static Map<String, Object> buildCheckScan(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildCommunityData(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5((1 + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("uid", Integer.valueOf(1));
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", "110000");
    if (paramInt == 4)
    {
      localHashMap.put("id", "2329");
      localHashMap.put("city_code", "110000");
    }
    return localHashMap;
  }
  
  public static Map<String, Object> buildCompetencyApply(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("companyName", paramString2);
    localHashMap.put("phone", paramString3);
    localHashMap.put("tradeNum", paramString4);
    localHashMap.put("bankNum", paramString5);
    localHashMap.put("bank", paramString6);
    localHashMap.put("address", paramString7);
    localHashMap.put("taxIdfa", paramString8);
    localHashMap.put("taxRegNum", paramString9);
    localHashMap.put("accountLicense", paramString10);
    localHashMap.put("orgCode", paramString11);
    localHashMap.put("businessLicense", paramString12);
    appendCommenParams(localHashMap);
    u.e("FInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildContractCodeState(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("oldContractCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildContractExtension(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("oldContractCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildContractSummary(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    localMap.put("contractCode", paramString4);
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramString3);
    localMap.put("activities", paramString6);
    localMap.put("countMoney", paramString5);
    return localMap;
  }
  
  public static Map<String, Object> buildContractTerms(String paramString)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("clauseType", paramString);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildCouponSelect(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString2);
    localMap.put("couponCode", paramString1);
    localMap.put("page", paramInt1 + "");
    localMap.put("pageNum", paramInt2 + "");
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildCrmSignGetSecretInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    paramContext = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramContext = localUserInfo.getUid();
    }
    localHashMap.put("uid", paramContext);
    localHashMap.put("ra_code", paramString1);
    localHashMap.put("ra_type", paramString2);
    localHashMap.put("house_source_code", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildCrmSignVerify(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    paramContext = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramContext = localUserInfo.getUid();
    }
    localHashMap.put("uid", paramContext);
    localHashMap.put("ra_code", paramString1);
    localHashMap.put("ra_type", paramString2);
    localHashMap.put("password", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildDistrictList(String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("city_id", paramString);
    return localMap;
  }
  
  public static Map<String, String> buildEntrust()
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildErrorLog(String paramString1, String paramString2, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Throwable localThrowable = new RuntimeException().fillInStackTrace();
    localStringBuffer.append("手机信息:" + ah.getPhoneInfo());
    localStringBuffer.append("错误信息:" + paramString2);
    localStringBuffer.append("堆栈信息:" + Log.getStackTraceString(localThrowable));
    paramString2 = new HashMap();
    paramString2.put("type", paramString1);
    paramString2.put("info", localStringBuffer.toString());
    paramString2.put("device", "android");
    paramString2.put("version", ah.getAppVersion(paramContext));
    paramString1 = "0";
    paramContext = ApplicationEx.c.getUser();
    if (paramContext != null) {
      paramString1 = paramContext.getUid();
    }
    paramString2.put("uid", paramString1);
    appendCommenParams(paramString2);
    return paramString2;
  }
  
  public static Map<String, Object> buildEvaluateHistoryDetail(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("evaluateSource", Integer.valueOf(paramInt));
    localHashMap.put("userId", paramString1);
    localHashMap.put("keeperId", paramString2);
    localHashMap.put("orderNum", paramString3);
    localHashMap.put("orderDtlId", Long.valueOf(paramLong));
    localHashMap.put("requesterId", paramString4);
    localHashMap.put("tokenId", paramString5);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildEvaluateIsExpired(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", paramString1);
    localHashMap.put("keeperId", paramString2);
    localHashMap.put("orderNum", paramString3);
    localHashMap.put("orderDtlId", Long.valueOf(paramLong));
    localHashMap.put("evaluateSource", Integer.valueOf(paramInt));
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildExtendInfo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString2);
    localHashMap.put("cert_id", Integer.valueOf(paramInt1));
    localHashMap.put("social_proof", paramString1);
    localHashMap.put("house_code", paramString3);
    localHashMap.put("house_id", paramString4);
    localHashMap.put("house_type", paramString5);
    localHashMap.put("work_name", paramString6);
    localHashMap.put("work_address", paramString7);
    localHashMap.put("certifier_name", paramString8);
    localHashMap.put("certifier_phone", paramString9);
    localHashMap.put("urgency_name", paramString10);
    localHashMap.put("urgency_phone", paramString11);
    localHashMap.put("urgency_relation", paramString12);
    localHashMap.put("is_newsign", Integer.valueOf(paramInt2));
    return getPassportSign(ad.ConvertObjMap2String(localHashMap));
  }
  
  public static Map<String, Object> buildFInvoiceList(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramString3 = new HashMap();
    paramString3.put("contractCode", paramString1);
    paramString3.put("source", paramString2);
    paramString3.put("busType", Integer.valueOf(paramInt));
    paramString3.put("statusCode", Integer.valueOf(0));
    appendCommenParams(paramString3);
    u.e("FInvoiceMap:", com.alibaba.fastjson.a.toJSONString(paramString3, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramString3;
  }
  
  public static Map<String, Object> buildGameData(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5((1 + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("uid", Integer.valueOf(1));
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", "110000");
    if (paramInt == 4)
    {
      localHashMap.put("id", "2274");
      localHashMap.put("city_code", "110000");
    }
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetBillInfo(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString1);
    localHashMap.put("childBillCodeList", paramString2);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetBookingOrderText(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("templateCode", paramString4);
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramString3);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, String> buildGetContract(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    appendCommenParamsString(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetEstimateDoneInfo(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("r", "gujia/get-house");
    localMap.put("type", paramString1);
    localMap.put("resblock_id", paramString2);
    localMap.put("city_name", paramString3);
    return localMap;
  }
  
  public static Map<String, Object> buildGetEvaluateProblems(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new HashMap();
    paramContext.put("channelCode", "app");
    paramContext.put("beEvaluatorId", paramString1);
    paramContext.put("beEvaluatorType", paramString2);
    paramContext.put("questionType", paramString3);
    return paramContext;
  }
  
  public static Map<String, Object> buildGetPhone(String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetRentAgentCode(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    paramContext = "0";
    paramString = ApplicationEx.c.getUser();
    if (paramString != null) {
      paramContext = paramString.getUid();
    }
    localHashMap.put("uid", paramContext);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildGetServerPhone(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    appendCommenParamsString(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetSubletBookingOrderText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramString3);
    localMap.put("subletCode", paramString4);
    localMap.put("reserveSecurityCode", paramString5);
    localMap.put("reserveType", paramString6);
    localMap.put("templateCode", paramString7);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetSubletReservationInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramString3);
    localMap.put("subletCode", paramString4);
    localMap.put("reserveSecurityCode", paramString5);
    localMap.put("reserveType", paramString6);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetreserveCloseOrder(String paramString)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("orderCode", paramString);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetreserveData(String paramString)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("reserveCode", paramString);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetreserveOrderList(int paramInt1, int paramInt2)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("pageNum", Integer.valueOf(paramInt1));
    localMap.put("pageSize", Integer.valueOf(paramInt2));
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGetreservePayData(String paramString)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("reserveCode", paramString);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildGroupPayMonth(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString);
    paramString = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramString = localUserInfo.getUid();
    }
    localHashMap.put("clientCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGuanJiaMap(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("villageId", paramString1);
    localHashMap.put("isLogin", paramString2);
    localHashMap.put("uid", paramString3);
    localHashMap.put("userPhone", paramString4);
    localHashMap.put("userName", paramString5);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildHomeBigLogData(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5((1 + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("uid", Integer.valueOf(1));
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", "110000");
    if (paramInt == 4)
    {
      localHashMap.put("id", "2245");
      localHashMap.put("city_code", "110000");
    }
    return localHashMap;
  }
  
  public static Map<String, Object> buildHomePageData()
  {
    HashMap localHashMap = new HashMap();
    getHouseSign(localHashMap);
    return getHomePageMap(localHashMap);
  }
  
  public static Map<String, Object> buildHotSearchWords()
  {
    return getHouseSign(new HashMap());
  }
  
  public static Map<String, Object> buildHouseCondition(SearchCondition paramSearchCondition, int paramInt1, int paramInt2, String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    String str;
    int i;
    if (paramSearchCondition != null)
    {
      str = paramSearchCondition.getSubWayStr();
      if (!ae.isNull(str))
      {
        str = str.trim().replace("+", ",");
        localMap.put("min_lng", paramSearchCondition.getMin_lng());
        localMap.put("max_lng", paramSearchCondition.getMax_lng());
        localMap.put("min_lat", paramSearchCondition.getMin_lat());
        localMap.put("max_lat", paramSearchCondition.getMax_lat());
        localMap.put("subway_station_name", str);
        localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
        localMap.put("min_rentfee", paramSearchCondition.getMin_rentfee());
        localMap.put("max_rentfee", paramSearchCondition.getMax_rentfee());
        localMap.put("min_area", paramSearchCondition.getMin_area());
        localMap.put("max_area", paramSearchCondition.getMax_area());
        localMap.put("huxing", paramSearchCondition.getHuxing());
        localMap.put("sort", Integer.valueOf(paramSearchCondition.getSort_type()));
        localMap.put("heating", paramSearchCondition.getHeating());
        localMap.put("house_tags[0]", Integer.valueOf(paramSearchCondition.getHouse_tags_0()));
        localMap.put("house_tags[1]", Integer.valueOf(paramSearchCondition.getHouse_tags_1()));
        localMap.put("house_tags[2]", Integer.valueOf(paramSearchCondition.getHouse_tags_2()));
        localMap.put("house_tags[3]", Integer.valueOf(paramSearchCondition.getHouse_tags_3()));
        localMap.put("house_tags[4]", Integer.valueOf(paramSearchCondition.getHouse_tags_4()));
        localMap.put("house_tags[6]", Integer.valueOf(paramSearchCondition.getHouse_tags_6()));
        if (!paramSearchCondition.getHouse_type().equals("合租")) {
          break label638;
        }
        i = 0;
        label366:
        localMap.put("house_type", Integer.valueOf(i));
        localMap.put("house_tags[5]", Integer.valueOf(i));
        localMap.put("style_code", paramSearchCondition.getStyle_code());
        localMap.put("style_codes", paramSearchCondition.getStyle_codes());
        localMap.put("version_id", paramSearchCondition.getVersion_id());
        localMap.put("can_sign", Integer.valueOf(paramSearchCondition.getCan_sign()));
        localMap.put("is_reserve", Integer.valueOf(paramSearchCondition.getIs_reserve()));
      }
    }
    for (;;)
    {
      localMap.put("start", Integer.valueOf(paramInt1));
      localMap.put("length", Integer.valueOf(paramInt2));
      localMap.put("keywords", paramString);
      paramSearchCondition = localMap.get("keywords").toString();
      paramString = localMap.get("bizcircle_code").toString();
      str = localMap.get("subway_station_name").toString();
      if ((!TextUtils.isEmpty(paramSearchCondition)) || (!TextUtils.isEmpty(paramString)) || (!TextUtils.isEmpty(str)))
      {
        localMap.remove("min_lng");
        localMap.remove("max_lng");
        localMap.remove("min_lat");
        localMap.remove("max_lat");
      }
      return localMap;
      str = "";
      break;
      label638:
      i = 1;
      break label366;
      localMap.put("house_type", Integer.valueOf(0));
    }
  }
  
  public static Map<String, Object> buildHouseCondition2(SearchCondition paramSearchCondition, int paramInt1, int paramInt2, String paramString)
  {
    Map localMap = getCRMCode2(new HashMap());
    String str;
    int i;
    if (paramSearchCondition != null)
    {
      str = paramSearchCondition.getSubWayStr();
      if (!ae.isNull(str))
      {
        str = str.trim().replace("+", ",");
        localMap.put("min_lng", paramSearchCondition.getMin_lng());
        localMap.put("max_lng", paramSearchCondition.getMax_lng());
        localMap.put("min_lat", paramSearchCondition.getMin_lat());
        localMap.put("max_lat", paramSearchCondition.getMax_lat());
        localMap.put("subway_station_name", str);
        localMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
        localMap.put("min_rentfee", paramSearchCondition.getMin_rentfee());
        localMap.put("max_rentfee", paramSearchCondition.getMax_rentfee());
        localMap.put("min_area", paramSearchCondition.getMin_area());
        localMap.put("max_area", paramSearchCondition.getMax_area());
        localMap.put("huxing", paramSearchCondition.getHuxing());
        localMap.put("heating", paramSearchCondition.getHeating());
        localMap.put("sort", Integer.valueOf(paramSearchCondition.getSort_type()));
        localMap.put("house_tags[0]", Integer.valueOf(paramSearchCondition.getHouse_tags_0()));
        localMap.put("house_tags[1]", Integer.valueOf(paramSearchCondition.getHouse_tags_1()));
        localMap.put("house_tags[2]", Integer.valueOf(paramSearchCondition.getHouse_tags_2()));
        localMap.put("house_tags[3]", Integer.valueOf(paramSearchCondition.getHouse_tags_3()));
        localMap.put("house_tags[4]", Integer.valueOf(paramSearchCondition.getHouse_tags_4()));
        localMap.put("house_tags[6]", Integer.valueOf(paramSearchCondition.getHouse_tags_6()));
        if (!paramSearchCondition.getHouse_type().equals("合租")) {
          break label449;
        }
        i = 0;
        label366:
        localMap.put("house_type", Integer.valueOf(i));
        localMap.put("house_tags[5]", Integer.valueOf(i));
      }
    }
    for (;;)
    {
      localMap.put("start", Integer.valueOf(paramInt1));
      localMap.put("length", Integer.valueOf(paramInt2));
      localMap.put("keywords", paramString);
      return localMap;
      str = "";
      break;
      label449:
      i = 1;
      break label366;
      localMap.put("house_type", Integer.valueOf(0));
    }
  }
  
  public static Map<String, Object> buildHouseDetailHZ(String paramString1, String paramString2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("house_code", paramString1);
    localMap.put("house_id", paramString2);
    return localMap;
  }
  
  public static Map<String, Object> buildHouseDetailPayWay(String paramString1, String paramString2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("id", paramString1);
    localMap.put("house_type", paramString2);
    return localMap;
  }
  
  public static Map<String, Object> buildHouseDetailRecommend(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("building_code", paramString1);
    localMap.put("show_house_code", paramString2);
    localMap.put("start", Integer.valueOf(paramInt1));
    localMap.put("length", Integer.valueOf(paramInt2));
    return localMap;
  }
  
  public static Map<String, Object> buildHouseDetailZZ(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("house_number", paramString);
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildHouseList(SearchCondition paramSearchCondition, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramSearchCondition.getKeywords())) {
      localHashMap.put("keywords", paramSearchCondition.getKeywords());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getType())) {
      localHashMap.put("type", paramSearchCondition.getType());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSubway())) {
      localHashMap.put("subway_station_code", paramSearchCondition.getSubway());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSubway_line())) {
      localHashMap.put("subway_code", paramSearchCondition.getSubway_line());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getDistrict())) {
      localHashMap.put("district_code", paramSearchCondition.getDistrict());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getBizcircle_code())) {
      localHashMap.put("bizcircle_code", paramSearchCondition.getBizcircle_code());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getResblock_id())) {
      localHashMap.put("resblock_id", paramSearchCondition.getResblock_id());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getClng())) {
      localHashMap.put("clng", paramSearchCondition.getClng());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getClat())) {
      localHashMap.put("clat", paramSearchCondition.getClat());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getBedroom().getValue() + "")) {
      localHashMap.put("bedroom", paramSearchCondition.getBedroom().getValue() + "");
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getLeasetype())) {
      localHashMap.put("leasetype", paramSearchCondition.getLeasetype());
    }
    String str1 = paramSearchCondition.getMinPrice() + "";
    String str2 = paramSearchCondition.getMaxPrice() + "";
    if (paramSearchCondition.getMinPrice() == 0) {
      str1 = "";
    }
    if (paramSearchCondition.getMaxPrice() == 0) {
      str2 = "";
    }
    localHashMap.put("price", str1 + "," + str2);
    if (!TextUtils.isEmpty(paramSearchCondition.getSort())) {
      localHashMap.put("sort", paramSearchCondition.getSort());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFace())) {
      localHashMap.put("face", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRface())) {
      localHashMap.put("rface", paramSearchCondition.getRface());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getHface())) {
      localHashMap.put("hface", paramSearchCondition.getHface());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getVersion())) {
      localHashMap.put("version", paramSearchCondition.getVersion());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getStyle())) {
      localHashMap.put("style", paramSearchCondition.getStyle());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFeature())) {
      localHashMap.put("feature", paramSearchCondition.getFeature());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getAround())) {
      localHashMap.put("around", paramSearchCondition.getAround());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getArea())) {
      localHashMap.put("area", paramSearchCondition.getArea());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getTags())) {
      localHashMap.put("tag", paramSearchCondition.getTags());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getLive())) {
      localHashMap.put("live", paramSearchCondition.getLive());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_type())) {
      localHashMap.put("suggestion_type", paramSearchCondition.getSuggestion_type());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_value())) {
      localHashMap.put("suggestion_value", paramSearchCondition.getSuggestion_value());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getCheckin_date())) {
      localHashMap.put("checkin_date", paramSearchCondition.getCheckin_date());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRapid())) {
      localHashMap.put("rapid", paramSearchCondition.getRapid());
    }
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("size", paramInt2 + "");
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildHouseListDuanZu(int paramInt1, int paramInt2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("start", Integer.valueOf(paramInt1));
    localMap.put("length", Integer.valueOf(paramInt2));
    return localMap;
  }
  
  public static Map<String, Object> buildHouseListDuanZuScreening(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("subwayline", paramString1);
    localMap.put("min_price", paramString2);
    localMap.put("max_price", paramString3);
    localMap.put("min_days", paramString4);
    localMap.put("max_days", paramString5);
    localMap.put("start", Integer.valueOf(paramInt1));
    localMap.put("length", Integer.valueOf(paramInt2));
    localMap.put("house_type", Integer.valueOf(paramInt3));
    return localMap;
  }
  
  public static Map<String, Object> buildHouseListRecommend(int paramInt1, int paramInt2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("start", Integer.valueOf(paramInt1));
    localMap.put("length", Integer.valueOf(paramInt2));
    return localMap;
  }
  
  public static Map<String, Object> buildHouseListSearch(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("keywords", paramString);
    localMap.put("start", Integer.valueOf(paramInt1));
    localMap.put("length", Integer.valueOf(paramInt2));
    return localMap;
  }
  
  public static Map<String, String> buildHouseMapList(SearchCondition paramSearchCondition, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramSearchCondition.getType())) {
      localHashMap.put("type", paramSearchCondition.getType());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getResblock_id())) {
      localHashMap.put("resblock_id", paramSearchCondition.getResblock_id());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getBedroom().getValue() + "")) {
      localHashMap.put("bedroom", paramSearchCondition.getBedroom().getValue() + "");
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getLeasetype())) {
      localHashMap.put("leasetype", paramSearchCondition.getLeasetype());
    }
    String str1 = paramSearchCondition.getMinPrice() + "";
    String str2 = paramSearchCondition.getMaxPrice() + "";
    if (paramSearchCondition.getMinPrice() == 0) {
      str1 = "";
    }
    if (paramSearchCondition.getMaxPrice() == 0) {
      str2 = "";
    }
    localHashMap.put("price", str1 + "," + str2);
    if (!TextUtils.isEmpty(paramSearchCondition.getSort())) {
      localHashMap.put("sort", paramSearchCondition.getSort());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFace())) {
      localHashMap.put("face", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRface())) {
      localHashMap.put("rface", paramSearchCondition.getRface());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getHface())) {
      localHashMap.put("hface", paramSearchCondition.getHface());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getVersion())) {
      localHashMap.put("version", paramSearchCondition.getVersion());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getStyle())) {
      localHashMap.put("style", paramSearchCondition.getStyle());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFeature())) {
      localHashMap.put("feature", paramSearchCondition.getFeature());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getTags())) {
      localHashMap.put("tag", paramSearchCondition.getTags());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getAround())) {
      localHashMap.put("around", paramSearchCondition.getAround());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getArea())) {
      localHashMap.put("area", paramSearchCondition.getArea());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_type())) {
      localHashMap.put("suggestion_type", paramSearchCondition.getSuggestion_type());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_value())) {
      localHashMap.put("suggestion_value", paramSearchCondition.getSuggestion_value());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRapid())) {
      localHashMap.put("rapid", paramSearchCondition.getRapid());
    }
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("size", paramInt2 + "");
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static String buildIdentity(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("login_name", paramString);
    paramString = com.alibaba.fastjson.a.toJSON(localObject).toString();
    try
    {
      localObject = new SecretKeySpec(SignKeyUtil.getKey().getBytes(), "DESede");
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(1, (Key)localObject);
      paramString = f.encode(localCipher.doFinal(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, Object> buildIndex()
  {
    return getHouseSign(new HashMap());
  }
  
  public static Map<String, Object> buildInvoiceBeforeOpen(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    localHashMap.put("beautyContractCode", paramString3);
    localHashMap.put("feeCode", paramString4);
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildInvoiceDetail(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("applyCode", paramString2);
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildInvoiceList(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("beautyContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildLease(int paramInt)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    localMap.put("ignoreCity", Integer.valueOf(1));
    localMap.put("contractsType", Integer.valueOf(paramInt));
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildLeaseInfo(String paramString1, String paramString2)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString1);
    localMap.put("sysContractId", paramString2);
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildLeaseMyData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("contractCode", paramString);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("source", Integer.valueOf(1));
    localHashMap.put("appType", Integer.valueOf(2));
    return localHashMap;
  }
  
  public static Map<String, Object> buildLocation()
  {
    HashMap localHashMap = new HashMap();
    getHouseSign(localHashMap);
    return getHouseSign_location(localHashMap);
  }
  
  public static String buildLogin(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("login_name", paramString1);
    ((Map)localObject).put("password", paramString2);
    paramString1 = com.alibaba.fastjson.a.toJSON(localObject).toString();
    try
    {
      paramString2 = new SecretKeySpec(SignKeyUtil.getKey().getBytes(), "DESede");
      localObject = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      ((Cipher)localObject).init(1, paramString2);
      paramString1 = f.encode(((Cipher)localObject).doFinal(paramString1.getBytes("UTF-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      u.e("buildLogin", paramString1.getMessage());
    }
    return null;
  }
  
  public static Map<String, Object> buildLoginByCode(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_name", paramString1);
    localHashMap.put("sms_code", paramString2);
    localHashMap.put("appType", Integer.valueOf(2));
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildLoginCode(String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("phone", paramString);
    return localMap;
  }
  
  public static Map<String, Object> buildMakeOrder(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sys_contract_id", Integer.valueOf(paramInt1));
    localHashMap.put("money", Integer.valueOf(paramInt2));
    localHashMap.put("periods", Integer.valueOf(paramInt3));
    localHashMap.put("uid", paramString1);
    localHashMap.put("source", paramString2);
    paramString1 = "";
    paramString2 = paramString1;
    if (paramList != null)
    {
      paramString2 = paramString1;
      if (paramList.size() > 0)
      {
        paramInt1 = 0;
        paramString2 = paramString1;
        if (paramInt1 < paramList.size())
        {
          if (paramInt1 == 0) {}
          for (paramString1 = (String)paramList.get(0);; paramString1 = paramString1 + "," + (String)paramList.get(paramInt1))
          {
            paramInt1 += 1;
            break;
          }
        }
      }
    }
    localHashMap.put("card_codes", paramString2);
    localHashMap.put("order_type", paramString3);
    return localHashMap;
  }
  
  public static Map<String, Object> buildModifyContractState(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString1);
    localMap.put("houseCode", paramString2);
    localMap.put("houseId", paramString3);
    localMap.put("houseType", paramString4);
    localMap.put("optionCode", paramString5);
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    return localMap;
  }
  
  public static Map<String, Object> buildMyEvaluatePros(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("evaluateSource", Integer.valueOf(paramInt));
    localHashMap.put("userId", paramString1);
    localHashMap.put("keeperId", paramString2);
    localHashMap.put("channelCode", paramString3);
    localHashMap.put("beEvaluatorId", paramString4);
    localHashMap.put("beEvaluatorType", paramString5);
    localHashMap.put("questionType", paramString6);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewLogin(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("login_name", paramString1);
    ((Map)localObject).put("password", paramString2);
    localObject = getHouseSign((Map)localObject);
    ((Map)localObject).put("appType", Integer.valueOf(2));
    ((Map)localObject).put("login_name", paramString1);
    ((Map)localObject).put("password", paramString2);
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, Object> buildNewPayWYStateList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNotPay()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNotPaybadgeUrl()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCConfirmContract(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", getToken());
    localHashMap.put("hireContractCode", paramString);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCConfirmContractContinue(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    localHashMap.put("handphone", paramString3);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCConfirmDeliever(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCContractDetail(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> buildOCContractList(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("handphone", paramString2);
    localHashMap.put("pageNum", paramInt + "");
    if (!ae.isNull(paramString3)) {
      localHashMap.put("lastPageValue", paramString3);
    }
    getCommonHouseSign(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCContractNeedConfirm(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCDelieverDetail(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCDelieverNeedConfirm(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOCLoanContractNeedConfirm(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(paramContext));
    localHashMap.put("loanOrderNo", paramString);
    appendCommenParams(localHashMap);
    u.e("OwnerContractNative map：", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildOpenInvoice(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("hireContractCode", paramString2);
    localHashMap.put("beautyContractCode", paramString3);
    localHashMap.put("titleType", Integer.valueOf(paramInt1));
    localHashMap.put("taxCode", paramString4);
    localHashMap.put("receivePhone", paramString5);
    localHashMap.put("feeCode", paramString6);
    localHashMap.put("invoiceType", Integer.valueOf(paramInt2));
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildPayContract(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat1, float paramFloat2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString8 = getHouseSign(new HashMap());
    paramString8.put("mac", ah.getMac(paramContext));
    if ("0".equals(paramString6))
    {
      paramString8.put("activities", paramString4);
      paramString8.put("couponCodeList", paramString10);
      paramString8.put("countMoney", Float.valueOf(paramFloat2));
      paramString8.put("isRenew", paramString6);
      paramString8.put("verificationCode", paramString7);
      paramString8.put("houseCode", paramString1);
      paramString8.put("houseId", paramString2);
      paramString8.put("houseType", paramString3);
      paramString8.put("contractCode", paramString5);
      return paramString8;
    }
    paramContext = "0";
    paramString1 = ApplicationEx.c.getUser();
    if (paramString1 != null) {
      paramContext = paramString1.getUid();
    }
    paramString8.put("oldContractCode", paramString9);
    paramString8.put("uid", paramContext);
    paramString8.put("couponCodeList", paramString10);
    paramString8.put("activities", paramString4);
    paramString8.put("verificationCode", paramString7);
    paramString8.put("countMoney", Float.valueOf(paramFloat2));
    paramString8.put("isRenew", paramString6);
    appendCommenParams(paramString8);
    return paramString8;
  }
  
  public static Map<String, Object> buildPayData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Map localMap = getHouseSign(new HashMap());
    if ("0".equals(paramString4))
    {
      localMap.put("activities", paramString7);
      localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      localMap.put("source", Integer.valueOf(1));
      localMap.put("appType", Integer.valueOf(2));
      localMap.put("isRenew", paramString4);
      localMap.put("houseCode", paramString1);
      localMap.put("houseId", paramString2);
      localMap.put("houseType", paramString3);
      localMap.put("contractCode", paramString6);
      localMap.put("couponCodeList", paramString8);
      return localMap;
    }
    paramString1 = "0";
    paramString2 = ApplicationEx.c.getUser();
    if (paramString2 != null) {
      paramString1 = paramString2.getUid();
    }
    localMap.put("oldContractCode", paramString5);
    localMap.put("activities", paramString7);
    localMap.put("uid", paramString1);
    localMap.put("couponCodeList", paramString8);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildPayDetailInfo(String paramString1, String paramString2, int paramInt)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString1);
    localMap.put("sysContractId", paramString2);
    localMap.put("periods", Integer.valueOf(paramInt));
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    return localMap;
  }
  
  public static Map<String, Object> buildPayDetails(String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("contractCode", paramString);
    return localMap;
  }
  
  public static Map<String, Object> buildPayKims(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString2 = getHouseSign(new HashMap());
    paramString2.put("couponCode", paramString1);
    paramString2.put("contractCode", paramString7);
    return paramString2;
  }
  
  public static Map<String, Object> buildPayPartStateList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildPayServiceData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Map localMap = getHouseSign(new HashMap());
    if ("0".equals(paramString4))
    {
      localMap.put("isRenew", paramString4);
      localMap.put("houseCode", paramString1);
      localMap.put("houseId", paramString2);
      localMap.put("houseType", paramString3);
      localMap.put("contractCode", paramString6);
      return localMap;
    }
    paramString1 = "0";
    paramString2 = ApplicationEx.c.getUser();
    if (paramString2 != null) {
      paramString1 = paramString2.getUid();
    }
    localMap.put("oldContractCode", paramString5);
    localMap.put("uid", paramString1);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildPayWYStateList(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", paramString1);
    if (ae.notNull(paramString2)) {
      localHashMap.put("orderType", paramString2);
    }
    if (ae.notNull(paramString3)) {
      localHashMap.put("companyCode", paramString3);
    }
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildPayWay(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("house_code", paramString1);
    localMap.put("house_id", paramString2);
    localMap.put("house_type", paramString3);
    localMap.put("sign_date", paramString4);
    localMap.put("sotp_date", paramString5);
    localMap.put("price", paramString6);
    localMap.put("tenancy_type", paramString7);
    localMap.put("is_short", paramString8);
    return localMap;
  }
  
  public static Map<String, Object> buildPayment(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("money", Integer.valueOf(paramInt1));
    localHashMap.put("orderType", paramString2);
    localHashMap.put("paySource", paramString3);
    localHashMap.put("uid", paramString4);
    localHashMap.put("mac", paramString5);
    localHashMap.put("balance", Integer.valueOf(paramInt2));
    localHashMap.put("couponCode", paramString6);
    localHashMap.put("couponValue", Integer.valueOf(paramInt3));
    localHashMap.put("couponCostValue", paramString7);
    localHashMap.put("zWhiteCouponCostValue", paramString13);
    localHashMap.put("smsOrderId", paramString8 + "");
    localHashMap.put("smsOrderValue", paramString9 + "");
    localHashMap.put("smsOrderDate", paramString10 + "");
    localHashMap.put("sumPayMoney", paramString11);
    localHashMap.put("isCheckCoupon", paramString12);
    return localHashMap;
  }
  
  public static Map<String, Object> buildPenaltySubmitOrderApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("sysContractId", paramString1);
    localHashMap.put("sysPenaltyId", paramString2);
    localHashMap.put("money", paramString3);
    localHashMap.put("period", paramString4);
    localHashMap.put("uid", str);
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("payType", paramString5);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("smsOrderId", paramString6);
    localHashMap.put("smsOrderValue", paramString7);
    localHashMap.put("smsOrderDate", paramString8);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildPriceList(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("beautyContractCode", paramString2);
    localHashMap.put("feeCode", paramString3);
    u.e("BeautyInvoiceMap:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildPutEvaluateContent(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new HashMap();
    paramContext.put("tokenId", paramString1);
    paramContext.put("evaluateMsg", paramString2);
    return paramContext;
  }
  
  public static Map<String, Object> buildReconmandData(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5((1 + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("uid", Integer.valueOf(1));
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", "110000");
    if (paramInt == 5)
    {
      localHashMap.put("id", "2305");
      localHashMap.put("city_code", "110000");
    }
    return localHashMap;
  }
  
  public static Map<String, Object> buildRegisterByCode(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_name", paramString1);
    localHashMap.put("sms_code", paramString2);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildRegisterCode(String paramString)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("phone", paramString);
    return localMap;
  }
  
  public static Map<String, Object> buildRemoveAlternateList(List<AlternateListing> paramList)
  {
    Map localMap = getHouseSign(new HashMap());
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AlternateListing localAlternateListing = (AlternateListing)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("house_code", localAlternateListing.getId());
      localHashMap.put("house_id", localAlternateListing.getHouse_id());
      localHashMap.put("house_type", Integer.valueOf(localAlternateListing.getHouse_type()));
      localArrayList.add(localHashMap);
    }
    localMap.put("collect", com.alibaba.fastjson.b.toJSONString(localArrayList));
    return localMap;
  }
  
  public static Map<String, String> buildRent()
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildRent(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("ab_type", paramInt + "");
    localHashMap.put("module", paramString);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildRentZOEvaluateAvailable(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("requesterId", paramString1);
    localHashMap.put("requesterType", paramString2);
    localHashMap.put("beEvaluatorId", paramString3);
    localHashMap.put("beEvaluatorType", paramString4);
    localHashMap.put("questionType", paramString5);
    localHashMap.put("orderCode", paramString6);
    localHashMap.put("channelCode", paramString7);
    paramString1 = new HashMap();
    paramString2 = new ArrayList();
    paramString2.add(localHashMap);
    paramString1.put("requestJSONStr", com.alibaba.fastjson.a.toJSONString(paramString2, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    u.e("Http ZO Evaluate Available json:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    paramString1.put("evaluateSource", Integer.valueOf(paramInt));
    appendCommenParams(paramString1);
    u.e("Http ZO Evaluate Available final json:", com.alibaba.fastjson.a.toJSONString(paramString1, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramString1;
  }
  
  public static Map<String, Object> buildReserveImage(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("houseCode", paramString1);
    localMap.put("houseType", paramString2);
    localMap.put("houseId", paramString3);
    return localMap;
  }
  
  public static Map<String, Object> buildReserveImageByType(String paramString1, String paramString2)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("houseId", paramString1);
    localMap.put("securityCodeType", paramString2);
    return localMap;
  }
  
  public static Map<String, Object> buildSaveAlternateList(List<AlternateListing> paramList)
  {
    Map localMap = getHouseSign(new HashMap());
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AlternateListing localAlternateListing = (AlternateListing)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("house_code", localAlternateListing.getId());
      localHashMap.put("house_id", localAlternateListing.getHouse_id());
      localHashMap.put("house_type", localAlternateListing.getHouse_type() + "");
      localHashMap.put("add_time", localAlternateListing.getAdd_time());
      localArrayList.add(localHashMap);
    }
    localMap.put("collect", com.alibaba.fastjson.b.toJSONString(localArrayList));
    return localMap;
  }
  
  public static Map<String, Object> buildSetPayWay(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    Map localMap = getHouseSign(new HashMap());
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramString3);
    localMap.put("payment", Integer.valueOf(paramInt1));
    localMap.put("isBlank", Integer.valueOf(paramInt2));
    localMap.put("signDate", paramString4);
    localMap.put("stopDate", paramString5);
    localMap.put("tenancyType", paramString6);
    localMap.put("isShort", Integer.valueOf(paramInt3));
    localMap.put("price", paramString7);
    localMap.put("priceUnit", paramString8);
    localMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localMap.put("source", Integer.valueOf(1));
    localMap.put("appType", Integer.valueOf(2));
    localMap.put("isZWhite", paramString9);
    localMap.put("isOnline", paramString12);
    localMap.put("loanType", paramString10);
    localMap.put("loanCode", paramString11);
    localMap.put("tenancyChoice", paramString13);
    return localMap;
  }
  
  public static Map<String, Object> buildSetShareInformationList(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("haveJointRent", paramString2);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSetShareInformationList(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("jointRentName", paramString2);
    localHashMap.put("jointRentSex", Integer.valueOf(paramInt1));
    localHashMap.put("jointRentPhone", paramString3);
    localHashMap.put("jointRentCertType", Integer.valueOf(paramInt2));
    localHashMap.put("jointRentCertNum", paramString4);
    localHashMap.put("jointRentCertPic1", paramString5);
    localHashMap.put("jointRentCertPic2", paramString6);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSetreserveData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("reserveCode", paramString1);
    localMap.put("userPhone", paramString2);
    localMap.put("userName", paramString3);
    localMap.put("certType", paramString4);
    localMap.put("certNum", paramString5);
    localMap.put("securityCode", paramString6);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildShareInformationList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSignedUserCreditResult(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("realNameFlag", paramString1);
    localHashMap.put("zhimaParams", paramString2);
    localHashMap.put("zhimaSign", paramString3);
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> buildSignedUserGetSchooling(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildSignedUserInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cert_id", Integer.valueOf(paramInt1));
    localHashMap.put("token", paramString1);
    localHashMap.put("house_type", paramString8);
    localHashMap.put("real_name", paramString2);
    localHashMap.put("gender", Integer.valueOf(paramInt2));
    localHashMap.put("phone", paramString3);
    localHashMap.put("cert_type", Integer.valueOf(paramInt3));
    localHashMap.put("cert_num", paramString4);
    localHashMap.put("user_cert1", paramString5);
    localHashMap.put("user_cert2", paramString6);
    localHashMap.put("user_cert3", paramString7);
    localHashMap.put("is_newsign", paramInt4 + "");
    return getPassportSign(ad.ConvertObjMap2String(localHashMap));
  }
  
  public static Map<String, String> buildSignedUserSetSchooling(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("graduation_year", paramString2);
    localHashMap.put("enrollment_year", paramString3);
    localHashMap.put("school", paramString4);
    localHashMap.put("education_type", paramString5);
    localHashMap.put("education", paramString6);
    return localHashMap;
  }
  
  public static Map<String, String> buildSublet(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramString1);
    localHashMap.put("type", paramString2);
    localHashMap.put("captcha", paramString3);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSubmitOrderAPP(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("childBillCode", paramString2);
    localHashMap.put("totalFee", paramString3);
    localHashMap.put("payType", paramString4);
    paramString1 = "0";
    paramString2 = ApplicationEx.c.getUser();
    if (paramString2 != null) {
      paramString1 = paramString2.getUid();
    }
    localHashMap.put("uid", paramString1);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSundHandleConfirm(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString1);
    localHashMap.put("confirm_state", paramString2);
    paramString1 = getHouseSign(localHashMap);
    appendCommenParams(paramString1);
    return paramString1;
  }
  
  public static Map<String, Object> buildSundHandleList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString);
    paramString = getHouseSign(localHashMap);
    appendCommenParams(paramString);
    return paramString;
  }
  
  public static Map<String, Object> buildSundHouseStatus(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildSundHouseType(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildTenancyInfo(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseCode", paramString1);
    localHashMap.put("houseId", paramString2);
    localHashMap.put("houseType", paramString3);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("source", Integer.valueOf(1));
    localHashMap.put("appType", Integer.valueOf(2));
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildTerms(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Map localMap = getHouseSign(new HashMap());
    if (paramString5 == null)
    {
      localMap.put("house_id", paramString1);
      localMap.put("house_code", paramString2);
      localMap.put("house_type", paramString3);
      localMap.put("contractCode", paramString4);
    }
    for (;;)
    {
      appendCommenParams(localMap);
      return localMap;
      localMap.put("oldContractCode", paramString5);
    }
  }
  
  public static Map<String, Object> buildToSee(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = new HashMap();
    paramString6.put("uid", paramString1);
    paramString6.put("user_name", paramString2);
    paramString6.put("user_phone", paramString3);
    paramString6.put("user_sex", paramString4);
    paramString6.put("house_code", str);
    paramString6.put("house_id", paramString5);
    paramString6.put("house_type", paramString7);
    return getHouseSign(paramString6);
  }
  
  public static Map<String, Object> buildToSeeConfirm(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("user_account", paramString2);
    localHashMap.put("house_code", paramString3);
    localHashMap.put("look_id", paramString4);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildToSeeList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildToSeeStatu(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("house_code", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildTurnSignTerms(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCodes", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildTurnSignText()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("who", Integer.valueOf(1));
    return localHashMap;
  }
  
  public static Map<String, Object> buildUid()
  {
    return getHouseSign(new HashMap());
  }
  
  public static Map<String, Object> buildUpdateTenancy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("house_code", paramString1);
    localHashMap.put("house_id", paramString2);
    localHashMap.put("house_type", paramString3);
    localHashMap.put("sign_date", paramString4);
    localHashMap.put("stop_date", paramString5);
    localHashMap.put("price", paramString6);
    localHashMap.put("tenancy_type", paramString7);
    localHashMap.put("is_short", Integer.valueOf(paramInt));
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, Object> buildUpinMap(String paramString1, String paramString2)
  {
    paramString2 = getHouseSign(new HashMap());
    paramString2.put("style_code", paramString1);
    return paramString2;
  }
  
  public static Map<String, Object> buildUserInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("myUid", paramString);
    return getHouseSign(localHashMap);
  }
  
  public static Map<String, String> buildWithdraw(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("auth_code", "600001");
    localHashMap.put("money", paramString);
    localHashMap.put("app", ah.getVersion(ApplicationEx.c));
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("os_type", "android");
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildZOSubmitEvaluatePros(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("evaluateSource", Integer.valueOf(paramInt));
    localHashMap.put("userId", paramString1);
    localHashMap.put("keeperId", paramString2);
    localHashMap.put("orderNum", paramString3);
    localHashMap.put("orderDtlId", Long.valueOf(paramLong));
    localHashMap.put("tokenId", paramString4);
    localHashMap.put("evaluateMsg", paramString5);
    appendCommenParams(localHashMap);
    u.e("Http evaluate json map:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildZZBizcirle()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildZZHouseList(SearchCondition paramSearchCondition, int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("size", Integer.valueOf(paramInt2));
    if (paramSearchCondition == null)
    {
      paramSearchCondition = paramString;
      if (paramString == null) {
        paramSearchCondition = "";
      }
      localHashMap.put("keywords", paramSearchCondition);
      return localHashMap;
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getResblock_id())) {
      a(localHashMap, paramSearchCondition.getResblock_id(), "resblock_id");
    }
    for (;;)
    {
      localHashMap.put("bedroom", paramSearchCondition.getBedroom().getValue());
      localHashMap.put("price", paramSearchCondition.getPrice().getValue());
      localHashMap.put("sort", paramSearchCondition.getSort());
      localHashMap.put("face", paramSearchCondition.getFace());
      localHashMap.put("style", paramSearchCondition.getStyle());
      localHashMap.put("configs", paramSearchCondition.getConfigs());
      localHashMap.put("tags", paramSearchCondition.getTags());
      getNewHouseSign(localHashMap);
      return localHashMap;
      if (!TextUtils.isEmpty(paramString))
      {
        a(localHashMap, paramString, "keywords");
      }
      else if ((paramSearchCondition.getBizcircle() != null) && (!TextUtils.isEmpty(paramSearchCondition.getBizcircle().getValue())))
      {
        a(localHashMap, paramSearchCondition.getBizcircle().getValue(), "bizcircle");
      }
      else if (!TextUtils.isEmpty(paramSearchCondition.getSubway()))
      {
        a(localHashMap, paramSearchCondition.getSubway(), "subway");
      }
      else if ((!TextUtils.isEmpty(paramSearchCondition.getClat())) && (!TextUtils.isEmpty(paramSearchCondition.getClng())))
      {
        localHashMap.put("clng", paramSearchCondition.getClng());
        localHashMap.put("clat", paramSearchCondition.getClat());
      }
    }
  }
  
  public static Map<String, Object> buildZZPayway(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("house_number", paramString);
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildZZRecommend(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("house_number", paramString);
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("size", Integer.valueOf(paramInt2));
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildZZSearchCondition(SearchCondition paramSearchCondition)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("min_lng", paramSearchCondition.getMin_lng());
    localHashMap.put("max_lng", paramSearchCondition.getMax_lng());
    localHashMap.put("min_lat", paramSearchCondition.getMin_lat());
    localHashMap.put("max_lat", paramSearchCondition.getMax_lat());
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    if ((paramSearchCondition.getSubway() != null) && (!TextUtils.isEmpty(paramSearchCondition.getSubway()))) {
      localHashMap.put("subway", paramSearchCondition.getSubway());
    }
    if ((paramSearchCondition.getBizcircle() != null) && (!TextUtils.isEmpty(paramSearchCondition.getBizcircle().getValue()))) {
      localHashMap.put("bizcircle", paramSearchCondition.getBizcircle().getValue());
    }
    if ((paramSearchCondition.getKeywords() != null) && (!TextUtils.isEmpty(paramSearchCondition.getKeywords()))) {
      localHashMap.put("keywords", paramSearchCondition.getKeywords());
    }
    if ((paramSearchCondition.getBedroom() != null) && (!TextUtils.isEmpty(paramSearchCondition.getBedroom().getValue()))) {
      localHashMap.put("bedroom", paramSearchCondition.getBedroom().getValue());
    }
    if ((paramSearchCondition.getPrice() != null) && (!TextUtils.isEmpty(paramSearchCondition.getPrice().getValue()))) {
      localHashMap.put("price", paramSearchCondition.getPrice().getValue());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSort())) {
      localHashMap.put("sort", paramSearchCondition.getSort());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFace())) {
      localHashMap.put("face", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getStyle())) {
      localHashMap.put("style", paramSearchCondition.getStyle());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getConfigs())) {
      localHashMap.put("configs", paramSearchCondition.getConfigs());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getTags())) {
      localHashMap.put("tags", paramSearchCondition.getTags());
    }
    getNewHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildZkCancel(String paramString1, String paramString2)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("reserveCode", paramString1);
    localMap.put("reserveStatus", paramString2);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> buildcheckWhole(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildgetRaSignInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("is_renew", paramString4);
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    if ("0".equals(paramString4))
    {
      localHashMap.put("house_code", paramString1);
      localHashMap.put("house_id", paramString2);
      localHashMap.put("house_type", paramString3);
    }
    for (;;)
    {
      appendCommenParams(localHashMap);
      return localHashMap;
      localHashMap.put("house_code", "");
      localHashMap.put("house_id", "");
      localHashMap.put("house_type", "");
      localHashMap.put("old_contract_code", paramString5);
    }
  }
  
  public static Map<String, Object> buildgetRaSignature(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("is_renew", paramString5);
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    if ("0".equals(paramString5))
    {
      localHashMap.put("house_code", paramString1);
      localHashMap.put("house_id", paramString2);
      localHashMap.put("house_type", paramString3);
    }
    for (;;)
    {
      localHashMap.put("password", paramString4);
      appendCommenParams(localHashMap);
      return localHashMap;
      localHashMap.put("house_code", "");
      localHashMap.put("house_id", "");
      localHashMap.put("house_type", "");
      localHashMap.put("old_contract_code", paramString6);
    }
  }
  
  public static Map<String, Object> buildgetRaTurnSignature(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signInfos", paramString);
    paramString = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramString = localUserInfo.getUid();
    }
    localHashMap.put("uid", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildgetTurnRaSignInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCodes", paramString);
    paramString = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      paramString = localUserInfo.getUid();
    }
    localHashMap.put("uid", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> buildreservePay(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("reserveCode", paramString1);
    localMap.put("payType", Integer.valueOf(paramInt1));
    localMap.put("payMoney", Integer.valueOf(paramInt2));
    localMap.put("osType", paramString2);
    localMap.put("mac", paramString3);
    localMap.put("imei", paramString4);
    localMap.put("smsOrderId", paramString5 + "");
    localMap.put("smsOrderValue", paramString6 + "");
    localMap.put("smsOrderDate", paramString7 + "");
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> checkPhone(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> combineParams(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("timestamp", Long.valueOf(System.currentTimeMillis() - ApplicationEx.c.getTimeDiff()));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("osType", Integer.valueOf(2));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("dataSourceVersion", ah.getAppVersion(ApplicationEx.c));
    paramMap = ApplicationEx.c.getUser();
    if (paramMap != null)
    {
      ((Map)localObject).put("uid", paramMap.getUid());
      ((Map)localObject).put("userPhone", paramMap.getLogin_name_mobile());
    }
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, Object> getAddBackRentOrder(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("expectDate", paramString2);
    localHashMap.put("uid", str);
    localHashMap.put("from", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getAddErrorMsg(String paramString1, String paramString2, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = "0";
    Object localObject2 = ApplicationEx.c.getUser();
    if (localObject2 != null) {
      localObject1 = ((UserInfo)localObject2).getUid();
    }
    localHashMap.put("uid", localObject1);
    localObject1 = new StringBuffer();
    localObject2 = new RuntimeException().fillInStackTrace();
    ((StringBuffer)localObject1).append("手机信息:" + ah.getPhoneInfo());
    ((StringBuffer)localObject1).append("错误信息:" + paramString2);
    ((StringBuffer)localObject1).append("堆栈信息:" + Log.getStackTraceString((Throwable)localObject2));
    localHashMap.put("type", paramString1);
    localHashMap.put("info", ((StringBuffer)localObject1).toString());
    localHashMap.put("device", "android");
    localHashMap.put("version", ah.getAppVersion(paramContext));
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getAddRentBackSignInfo(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("backRentOrderCode", paramString2);
    localHashMap.put("password", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getCRMCode(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap != null)
    {
      localObject = getHouseSign(paramMap);
      ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      ((Map)localObject).put("source", Integer.valueOf(1));
      ((Map)localObject).put("appType", Integer.valueOf(2));
      ((Map)localObject).remove("sign");
      appendCommenParams((Map)localObject);
    }
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, Object> getCRMCode2(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap != null)
    {
      localObject = getHouseSign_location(paramMap);
      ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      ((Map)localObject).put("source", Integer.valueOf(1));
      ((Map)localObject).put("appType", Integer.valueOf(2));
    }
    return (Map<String, Object>)localObject;
  }
  
  public static Map<String, String> getCRMCodeString(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap != null)
    {
      localObject = getCommonHouseSign(paramMap);
      ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      ((Map)localObject).put("source", "1");
      ((Map)localObject).put("appType", "2");
      ((Map)localObject).remove("sign");
      appendCommenParamsString((Map)localObject);
    }
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> getCancelBackRendOrder(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("backRentOrderCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getCheckSignButton(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("houseId", paramString1);
    localHashMap.put("houseCode", paramString2);
    localHashMap.put("houseType", paramString3);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getCommonHouseSign(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str = "0";
      UserInfo localUserInfo = ApplicationEx.c.getUser();
      if (localUserInfo != null) {
        str = localUserInfo.getUid();
      }
      u.e("time", m.TimeS2L(m.GetNowDateTime(), m.c) + "");
      paramMap.put("timestamp", String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10));
      paramMap.put("uid", str);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", ah.getIpAddress(ApplicationEx.c));
      paramMap.put("network", ah.getNetWorkType(ApplicationEx.c));
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("app_version", ah.getVersion(ApplicationEx.c));
      paramMap.put("sign_open", "1");
      paramMap.put("sign", toCommonPHPMD5(paramMap));
    }
    u.e("getCommonHouseSign json map:", com.alibaba.fastjson.a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramMap;
  }
  
  public static Map<String, String> getCommonMapFilter(SearchCondition paramSearchCondition)
  {
    return getCommonMapFilter(null, paramSearchCondition);
  }
  
  public static Map<String, String> getCommonMapFilter(Map<String, String> paramMap, SearchCondition paramSearchCondition)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("min_lng", paramSearchCondition.getMin_lng());
    ((Map)localObject).put("max_lng", paramSearchCondition.getMax_lng());
    ((Map)localObject).put("min_lat", paramSearchCondition.getMin_lat());
    ((Map)localObject).put("max_lat", paramSearchCondition.getMax_lat());
    if (!TextUtils.isEmpty(paramSearchCondition.getType())) {
      ((Map)localObject).put("type", paramSearchCondition.getType());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getBedroom().getValue() + "")) {
      ((Map)localObject).put("bedroom", paramSearchCondition.getBedroom().getValue() + "");
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFace())) {
      ((Map)localObject).put("face", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRface())) {
      ((Map)localObject).put("rface", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getHface())) {
      ((Map)localObject).put("hface", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getLeasetype())) {
      ((Map)localObject).put("leasetype", paramSearchCondition.getLeasetype());
    }
    paramMap = paramSearchCondition.getMinPrice() + "";
    String str = paramSearchCondition.getMaxPrice() + "";
    if (paramSearchCondition.getMinPrice() == 0) {
      paramMap = "";
    }
    if (paramSearchCondition.getMaxPrice() == 0) {
      str = "";
    }
    ((Map)localObject).put("price", paramMap + "," + str);
    if (!TextUtils.isEmpty(paramSearchCondition.getFace())) {
      ((Map)localObject).put("face", paramSearchCondition.getFace());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getVersion())) {
      ((Map)localObject).put("version", paramSearchCondition.getVersion());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getStyle())) {
      ((Map)localObject).put("style", paramSearchCondition.getStyle());
    }
    if (TextUtils.isEmpty(paramSearchCondition.getVersion())) {
      ((Map)localObject).put("style", "");
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getFeature())) {
      ((Map)localObject).put("feature", paramSearchCondition.getFeature());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getAround())) {
      ((Map)localObject).put("around", paramSearchCondition.getAround());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getArea())) {
      ((Map)localObject).put("area", paramSearchCondition.getArea());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getTags())) {
      ((Map)localObject).put("tag", paramSearchCondition.getTags());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_type())) {
      ((Map)localObject).put("suggestion_type", paramSearchCondition.getSuggestion_type());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getSuggestion_value())) {
      ((Map)localObject).put("suggestion_value", paramSearchCondition.getSuggestion_value());
    }
    if (!TextUtils.isEmpty(paramSearchCondition.getRapid())) {
      ((Map)localObject).put("rapid", paramSearchCondition.getRapid());
    }
    getCommonHouseSign((Map)localObject);
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> getConfirmBackRentUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getContractTenancy(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("jsonString", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getEstimatedBackRentFee(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("expectDate", paramString2);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getFeeDetailUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getHomePageMap(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      getHouseSign(paramMap);
      str2 = ah.toMd5((com.ziroom.ziroomcustomer.base.b.d + str1 + str2).getBytes());
      paramMap.put("timestamp", str1);
      paramMap.put("sign", str2);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    }
    return paramMap;
  }
  
  public static Map<String, String> getHouseListFilter(Map<String, String> paramMap, String paramString)
  {
    paramMap.put("type", "");
    getCommonHouseSign(paramMap);
    return paramMap;
  }
  
  public static Map<String, Object> getHouseSign(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = "0";
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        str1 = ((UserInfo)localObject).getUid();
      }
      if ((!"0".equals(str1)) && (!"".equals(str1)))
      {
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "1";
      }
      u.e("time", m.TimeS2L(m.GetNowDateTime(), m.c) + "");
      str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      str2 = ah.toMd5(((String)localObject + str1 + str2).getBytes());
      paramMap.put("timestamp", str1);
      paramMap.put("uid", localObject);
      paramMap.put("sign", str2);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("app", ah.getVersion(ApplicationEx.c));
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", ah.getIpAddress(ApplicationEx.c));
      paramMap.put("network", ah.getNetWorkType(ApplicationEx.c));
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("app_version", ah.getVersion(ApplicationEx.c));
    }
    return paramMap;
  }
  
  public static Map<String, Object> getHouseSign_location(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        ((UserInfo)localObject).getUid();
      }
      localObject = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str = SignKeyUtil.getHouseKey();
      getHouseSign(paramMap);
      str = ah.toMd5((com.ziroom.ziroomcustomer.base.b.d + (String)localObject + str).getBytes());
      paramMap.put("timestamp", localObject);
      paramMap.put("sign", str);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    }
    return paramMap;
  }
  
  public static Map<String, Object> getLifeSign(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        ((UserInfo)localObject).getUid();
      }
      localObject = com.ziroom.ziroomcustomer.base.b.d;
      String str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      str2 = ah.toMd5(((String)localObject + str1 + str2).getBytes());
      paramMap.put("timestamp", str1);
      paramMap.put("sign", str2);
      paramMap.put("city_code", localObject);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("app", ah.getVersion(ApplicationEx.c));
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
    }
    return paramMap;
  }
  
  public static Map<String, String> getMBSSign(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("source", "1");
    paramMap = com.ziroom.commonlib.utils.b.getAppId();
    if (ae.isNull(paramMap)) {
      ApplicationEx.c.getHttpAppID();
    }
    ((Map)localObject).put("appId", paramMap);
    ((Map)localObject).put("appType", "2");
    ((Map)localObject).put("imei", ah.getDeviceId(ApplicationEx.c));
    ((Map)localObject).put("osType", "2");
    ((Map)localObject).put("timestamp", ("" + System.currentTimeMillis()).substring(0, 10));
    ((Map)localObject).put("appVersionStr", ah.getVersion(ApplicationEx.c));
    ((Map)localObject).put("sign", toCommonMBSMD5((Map)localObject));
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> getMakeOrcer(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Map localMap = getCRMCode(new HashMap());
    localMap.put("contractId", Integer.valueOf(paramInt1));
    localMap.put("money", Integer.valueOf(paramInt2));
    localMap.put("cardMoney", paramString4);
    localMap.put("period", Integer.valueOf(paramInt3));
    localMap.put("userId", paramString1);
    localMap.put("cardsString", paramString2);
    localMap.put("payType", paramString3);
    localMap.put("smsOrderId", paramString5);
    localMap.put("smsOrderValue", paramString6);
    localMap.put("smsOrderDate", paramString7);
    appendCommenParams(localMap);
    return localMap;
  }
  
  public static Map<String, Object> getMemberCount()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getMemberInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("packCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getNewHouseSign(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = "0";
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        str1 = ((UserInfo)localObject).getUid();
      }
      u.e("time", m.TimeS2L(m.GetNowDateTime(), m.c) + "");
      localObject = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      ah.toMd5((str1 + (String)localObject + str2).getBytes());
      paramMap.put("timestamp", localObject);
      paramMap.put("uid", str1);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", ah.getIpAddress(ApplicationEx.c));
      paramMap.put("network", ah.getNetWorkType(ApplicationEx.c));
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("app_version", ah.getVersion(ApplicationEx.c));
      paramMap.put("sign_open", "1");
      paramMap.put("sign", toPHPMD5(paramMap));
    }
    return paramMap;
  }
  
  public static Map<String, String> getOldHouseSignString(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = "0";
      Object localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        str1 = ((UserInfo)localObject).getUid();
      }
      if ((!"0".equals(str1)) && (!"".equals(str1)))
      {
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "1";
      }
      u.e("time", m.TimeS2L(m.GetNowDateTime(), m.c) + "");
      str1 = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      str2 = ah.toMd5(((String)localObject + str1 + str2).getBytes());
      paramMap.put("timestamp", str1);
      paramMap.put("uid", localObject);
      paramMap.put("sign", str2);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("app", ah.getVersion(ApplicationEx.c));
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", ah.getIpAddress(ApplicationEx.c));
      paramMap.put("network", ah.getNetWorkType(ApplicationEx.c));
      paramMap.put("imei", ah.getDeviceId(ApplicationEx.c));
      paramMap.put("app_version", ah.getVersion(ApplicationEx.c));
    }
    return paramMap;
  }
  
  public static Map<String, String> getOwnerBaseInfo(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getOwnerContract(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getOwnerEntrustSchedule(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    getCommonHouseSign(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getPackList()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getPassportSign(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("auth_code", "600001");
    ((Map)localObject).put("timestamp", ("" + System.currentTimeMillis()).substring(0, 10));
    ((Map)localObject).put("app", ah.getVersion(ApplicationEx.c));
    ((Map)localObject).put("os_type", "Android");
    ((Map)localObject).put("os_version", Build.VERSION.RELEASE);
    ((Map)localObject).put("sign", toCommonPassportPHPMD5((Map)localObject));
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> getPayCount(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ContractCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getPaymentUrlUrl(String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("mac", ah.getMac(paramContext));
    localHashMap.put("balance", Integer.valueOf(paramInt3));
    localHashMap.put("money", Integer.valueOf(paramInt2));
    localHashMap.put("payType", Integer.valueOf(paramInt1));
    localHashMap.put("backRentOrderCode", paramString2);
    localHashMap.put("uid", str);
    localHashMap.put("smsOrderId", paramString3 + "");
    localHashMap.put("smsOrderValue", paramString4 + "");
    localHashMap.put("smsOrderDate", paramString5 + "");
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getPhpUploadImg(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("file_type", paramString);
    paramString = getSocalPassportSign(localHashMap);
    u.e("getPhpUploadImg:", com.alibaba.fastjson.a.toJSONString(paramString, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramString;
  }
  
  public static Map<String, Object> getRaConfig()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getRaSignFlag(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("contractCode", paramString);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getRejectedBackRenderContractUrl(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString1);
    localHashMap.put("reason", paramString2);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getRentBackSignInfo(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("backRentOrderCode", paramString2);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, String> getRentConditionParams(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    getCommonHouseSign((Map)localObject);
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, String> getSocalPassportSign(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("timestamp", ("" + System.currentTimeMillis()).substring(0, 10));
    ((Map)localObject).put("app_version", ah.getVersion(ApplicationEx.c));
    ((Map)localObject).put("os", "android");
    ((Map)localObject).put("imei", ah.getDeviceId(ApplicationEx.c));
    ((Map)localObject).put("sign", toCommonPassportPHPMD5((Map)localObject));
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, Object> getToBackRent(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static String getToken()
  {
    return com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
  }
  
  public static Map<String, Object> getTurnSign()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("Client-Type", "android");
    localHashMap.put("who", Integer.valueOf(1));
    return localHashMap;
  }
  
  public static String getUid()
  {
    return com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c);
  }
  
  public static Map<String, Object> getViewBackRenderContractUrl(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("uid", str);
    localHashMap.put("mode", paramString2);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getViewBackRentRemend(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getViewPropertyExpendsUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getViewPropertyGoosUrl(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("contractCode", paramString1);
    if (paramString2 != null) {
      localHashMap.put("backRentOrderCode", paramString2);
    }
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> getViewPropertyKeyUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("backRentOrderCode", paramString);
    localHashMap.put("uid", str);
    appendCommenParams(localHashMap);
    return localHashMap;
  }
  
  public static Map<String, Object> setTurnSign(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    localHashMap.put("who", Integer.valueOf(1));
    localHashMap.put("Client-Type", "android");
    localHashMap.put("signStatus", paramString1);
    localHashMap.put("readStatus", paramString2);
    return localHashMap;
  }
  
  public static String toCommonMBSMD5(Map<String, String> paramMap)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + (String)paramMap.get(arrayOfString[j]) + "");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=");
      }
    }
    localStringBuffer.append(q.N);
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toCommonPHPMD5(e parame)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[parame.size()];
    parame.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < parame.size())
    {
      if (parame.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + parame.get(arrayOfString[j]) + "&");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(q.K);
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toCommonPHPMD5(Map<String, String> paramMap)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + (String)paramMap.get(arrayOfString[j]) + "&");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(q.K);
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toCommonPassportPHPMD5(Map<String, String> paramMap)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + (String)paramMap.get(arrayOfString[j]) + "&");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(q.P);
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toMD5(Map<String, Object> paramMap)
  {
    int k = 0;
    a = paramMap;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + paramMap.get(arrayOfString[j]) + "");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=");
      }
    }
    localStringBuffer.append(SignKeyUtil.getHouseKey());
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toMD5String(Map<String, String> paramMap)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + (String)paramMap.get(arrayOfString[j]) + "");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=");
      }
    }
    localStringBuffer.append(SignKeyUtil.getHouseKey());
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
  
  public static String toPHPMD5(Map<String, Object> paramMap)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap.keySet().toArray(arrayOfString);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfString.length) {
        break;
      }
      j = 0;
      while (j < arrayOfString.length - i - 1)
      {
        if (arrayOfString[j].compareTo(arrayOfString[(j + 1)]) > 0)
        {
          String str = arrayOfString[j];
          arrayOfString[j] = arrayOfString[(j + 1)];
          arrayOfString[(j + 1)] = str;
        }
        j += 1;
      }
      i += 1;
    }
    if (j < paramMap.size())
    {
      if (paramMap.get(arrayOfString[j]) != null) {
        localStringBuffer.append(arrayOfString[j] + "=" + paramMap.get(arrayOfString[j]) + "&");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(arrayOfString[j] + "=&");
      }
    }
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(q.K);
    u.e("sign加密", localStringBuffer.toString());
    return ah.toMd5(localStringBuffer.toString().getBytes());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */