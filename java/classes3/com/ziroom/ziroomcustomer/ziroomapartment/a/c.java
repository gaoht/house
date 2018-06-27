package com.ziroom.ziroomcustomer.ziroomapartment.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.a.d;
import com.freelxl.baselibrary.f.h;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.model.EvaluateMsg;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c
{
  static String a = c.class.getSimpleName();
  
  public static Map<String, Object> buildCommitApply(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uuid", paramString1);
    localHashMap.put("name", paramString2);
    localHashMap.put("phone", paramString3);
    localHashMap.put("message", paramString4);
    localHashMap.put("projectId", paramString5);
    localHashMap.put("htId", paramString6);
    localHashMap.put("expectTime", paramString7);
    u.i(a, "map：" + a.toJSONString(b.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildExchangeCoupon(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("redeemCode", paramString2);
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildFirstGetProjectList(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    u.i(a, "map：" + a.toJSONString(b.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetBillDetail(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billFid", paramString);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetBillDetailV2(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("billFid", paramString2);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetContractBillList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetContractDetail(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetContractList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetEvaHistoryDetail(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("requesterId", paramString1);
    localHashMap.put("tokenId", paramString2);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetEvaluatePros(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channelCode", paramString1);
    localHashMap.put("beEvaluatorId", paramString2);
    localHashMap.put("beEvaluatorType", paramString3);
    localHashMap.put("questionType", paramString4);
    u.i(a, "map：" + a.toJSONString(b.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetHouseType(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseTypeId", paramString);
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetOrderDetail(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetPayWayList(Context paramContext, String paramString1, String paramString2, double paramDouble, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billFid", paramString1);
    localHashMap.put("billNum", paramString2);
    localHashMap.put("payAmount", Double.valueOf(paramDouble));
    localHashMap.put("uid", paramString3);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetPayWayListV2(Context paramContext, String paramString1, String paramString2, double paramDouble, String paramString3, int paramInt, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billFid", paramString1);
    localHashMap.put("billNum", paramString2);
    localHashMap.put("payAmount", Double.valueOf(paramDouble));
    localHashMap.put("uid", paramString3);
    localHashMap.put("billType", Integer.valueOf(paramInt));
    localHashMap.put("cardCouponCodes", paramList);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetProjectList(Context paramContext, ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    paramZryuSearchConditionResult = buildSearchMap(paramZryuSearchConditionResult);
    u.i(a, "map：" + a.toJSONString(b.convertor(paramContext, paramZryuSearchConditionResult), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return b.convertor(paramContext, paramZryuSearchConditionResult);
  }
  
  public static Map<String, Object> buildGetRoom(Context paramContext, String paramString1, String paramString2, Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("houseTypeId", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("roomNumber", paramString2);
    }
    paramString1 = new HashMap();
    if (paramDouble1 != null) {
      paramString1.put("minPrice", paramDouble1);
    }
    if (paramDouble2 != null) {
      paramString1.put("maxPrice", paramDouble2);
    }
    if (!paramString1.isEmpty()) {
      localHashMap.put("price", paramString1);
    }
    paramString1 = new HashMap();
    if (paramDouble3 != null) {
      paramString1.put("minArea", paramDouble3);
    }
    if (paramDouble4 != null) {
      paramString1.put("maxArea", paramDouble4);
    }
    if (!paramString1.isEmpty()) {
      localHashMap.put("area", paramString1);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("checkInTime", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("floor", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("direction", paramString5);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("checkInTime", paramString3);
    }
    localHashMap.put("pageNum", Integer.valueOf(paramInt1));
    localHashMap.put("pageSize", Integer.valueOf(paramInt2));
    return b.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetWillPayList(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("requesterId", paramString1);
    localHashMap.put("tokenId", paramString2);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildHouseTypeList(Context paramContext, String paramString, ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    paramZryuSearchConditionResult = buildSearchMap(paramZryuSearchConditionResult);
    paramZryuSearchConditionResult.put("projectId", paramString);
    u.i(a, "map：" + a.toJSONString(b.convertor(paramContext, paramZryuSearchConditionResult), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return b.convertor(paramContext, paramZryuSearchConditionResult);
  }
  
  public static Map<String, String> buildNoPayList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    return encryptPost(b.convertorStr(paramContext, localHashMap));
  }
  
  public static Map<String, Object> buildPayOrder(Context paramContext, String paramString1, String paramString2, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("payChannel", paramString1);
    localHashMap.put("paymentNum", paramString2);
    localHashMap.put("payAmount", Double.valueOf(paramDouble));
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildSearchConditionsV2(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (!ae.isNull(paramString1)) {
      localHashMap.put("city", paramString1);
    }
    localHashMap.put("minPrice", Double.valueOf(paramDouble1));
    localHashMap.put("maxPrice", Double.valueOf(paramDouble2));
    if (!ae.isNull(paramString2)) {
      localHashMap.put("checkInTime", paramString2);
    }
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildSearchMap(ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    HashMap localHashMap = new HashMap();
    if (paramZryuSearchConditionResult != null)
    {
      if (!ae.isNull(paramZryuSearchConditionResult.getRoomNumber())) {
        localHashMap.put("roomNumber", paramZryuSearchConditionResult.getRoomNumber());
      }
      if (paramZryuSearchConditionResult.getPrice() != null) {
        localHashMap.put("price", paramZryuSearchConditionResult.getPrice());
      }
      if (paramZryuSearchConditionResult.getArea() != null) {
        localHashMap.put("area", paramZryuSearchConditionResult.getArea());
      }
      if (!ae.isNull(paramZryuSearchConditionResult.getFloor())) {
        localHashMap.put("floor", paramZryuSearchConditionResult.getFloor());
      }
      if (!ae.isNull(paramZryuSearchConditionResult.getCheckInTime())) {
        localHashMap.put("checkInTime", paramZryuSearchConditionResult.getCheckInTime());
      }
      if (!ae.isNull(paramZryuSearchConditionResult.getDirection())) {
        localHashMap.put("direction", paramZryuSearchConditionResult.getDirection());
      }
      if (!ae.isNull(paramZryuSearchConditionResult.getCity())) {
        localHashMap.put("city", paramZryuSearchConditionResult.getCity());
      }
    }
    return localHashMap;
  }
  
  public static Map<String, Object> buildSubmitEvaluatePros(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, EvaluateMsg paramEvaluateMsg)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channelCode", paramString1);
    localHashMap.put("beEvaluatorType", paramString3);
    localHashMap.put("questionType", paramString4);
    localHashMap.put("beEvaluatorId", paramString2);
    localHashMap.put("businessBid", paramString5);
    localHashMap.put("tokenId", paramString6);
    localHashMap.put("evaluateMsg", paramEvaluateMsg);
    paramContext = b.convertor(paramContext, localHashMap);
    u.e("Http zryu json map:", a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> encryptPost(Map<String, String> paramMap)
  {
    u.e("Http apartment json map:", a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    String str = com.freelxl.baselibrary.f.a.c.createEncryption("DES").encrypt(a.toJSONString(paramMap), "vpRZ1kmU", "ZiR00mYi");
    paramMap = h.toMd5(a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("p", str);
    localHashMap.put("sign", paramMap);
    u.e("Http apartment secret map:", a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> encryptPostObj(Map<String, Object> paramMap)
  {
    u.e("Http apartment json map:", a.toJSONString(paramMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    String str = com.freelxl.baselibrary.f.a.c.createEncryption("DES").encrypt(a.toJSONString(paramMap), "vpRZ1kmU", "ZiR00mYi");
    paramMap = h.toMd5(a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("p", str);
    localHashMap.put("sign", paramMap);
    u.e("Http apartment secret map:", a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */