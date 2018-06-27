package com.ziroom.ziroomcustomer.ziroomstation.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.a.c;
import com.freelxl.baselibrary.f.a.d;
import com.freelxl.baselibrary.f.h;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.model.BedCountPost;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateUserEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StayPersonPost;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  public static Map<String, Object> buildApplyRefund(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    if (!ae.isNull(paramString1)) {
      localHashMap.put("refundAmount", paramString1);
    }
    localHashMap.put("refundWay", paramString2);
    localHashMap.put("refundReason", Integer.valueOf(paramInt));
    localHashMap.put("remark", paramString3);
    localHashMap.put("bankName", paramString4);
    localHashMap.put("bankNo", paramString5);
    localHashMap.put("orderBid", paramString6);
    localHashMap.put("name", paramString7);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildBookOrderInfo(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("uuid", paramString2);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> buildCalander(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("originalStartDate", paramString1);
    localHashMap.put("houseTypeBid", paramString2);
    paramContext = signMethod(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap));
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildCancelOrder(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildEvaluatedSucc(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildGetBaseData(Context paramContext)
  {
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, new HashMap());
  }
  
  public static Map<String, Object> buildGetEvaluateInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channelCode", paramString4);
    localHashMap.put("beEvaluatorId", paramString3);
    localHashMap.put("beEvaluatorType", paramString2);
    localHashMap.put("questionType", paramString1);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetOrderDetail(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetRefundWayInfo(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildGetZraEvaluate(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("questionType", paramString);
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("size", Integer.valueOf(paramInt2));
    localHashMap.put("isPic", Integer.valueOf(paramInt3));
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> buildGetZryEvaluate(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("questionType", paramString);
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("size", paramInt2 + "");
    localHashMap.put("isPic", paramInt3 + "");
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> buildGroupChatUserInfo(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    localHashMap.put("hide", "0");
    paramContext = signMethod(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap));
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildHeaderImg(Context paramContext, String paramString)
  {
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, new HashMap());
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoClear(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString1);
    localHashMap.put("htBid", paramString2);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoLabelList(Context paramContext)
  {
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, new HashMap());
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoLockingBed(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, int paramInt, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString1);
    localHashMap.put("houseTypeBid", paramString2);
    localHashMap.put("startDate", paramString3);
    localHashMap.put("endDate", paramString4);
    localHashMap.put("areaBedBid", paramString5);
    localHashMap.put("areaBid", paramString6);
    localHashMap.put("labels", paramArrayOfString);
    localHashMap.put("sex", Integer.valueOf(paramInt));
    localHashMap.put("name", paramString7);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoPayCash(Context paramContext, String paramString1, String paramString2, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("orderBid", paramString2);
    localHashMap.put("depositSum", Double.valueOf(paramDouble));
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoPaySuccessText(Context paramContext)
  {
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, new HashMap());
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildIntoScheme(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildOrderMoney(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, StationCoupon.DataEntity paramDataEntity, List<StationOrderCreateHouseEntity> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("arriveTime", paramString2);
    localHashMap.put("startDate", paramString3);
    localHashMap.put("endDate", paramString4);
    localHashMap.put("uuid", paramString5);
    if ((paramDataEntity != null) && (!TextUtils.isEmpty(paramDataEntity.getTicketBid()))) {
      localHashMap.put("coupons", paramDataEntity.getTicketBid());
    }
    paramString1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((StationOrderCreateHouseEntity)paramList.get(i)).getSize() > 0) {
        paramString1.add(new BedCountPost(((StationOrderCreateHouseEntity)paramList.get(i)).getHouseTypeId(), ((StationOrderCreateHouseEntity)paramList.get(i)).getSize()));
      }
      i += 1;
    }
    localHashMap.put("bedCount", paramString1);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildPayOrder(Context paramContext, String paramString1, String paramString2, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("payChannel", paramString1);
    localHashMap.put("orderCode", paramString2);
    localHashMap.put("payAmount", Double.valueOf(paramDouble));
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, String> buildProjectDetail(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString);
    paramContext = signMethod(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap));
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildProjectInfo(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildPutEvaluateInfo(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tokenId", paramString1);
    localHashMap.put("evaluateMsg", paramString2);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(localHashMap, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, Object> buildRedeTicket(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uuid", paramString1);
    localHashMap.put("redeemCode", paramString2);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildRoomPassword(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, String> buildRules(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("ruleType", paramString2);
    paramContext = signMethod(com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap));
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildStationList(Context paramContext, String paramString)
  {
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, new HashMap());
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildStationOrderList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uuid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> buildStationRoomPrice(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("startDate", paramString2);
    localHashMap.put("endDate", paramString3);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return signMethod(paramContext);
  }
  
  public static Map<String, Object> buildStationRooms(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("startDate", paramString2);
    localHashMap.put("endDate", paramString3);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildStationTickets(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, List<StationOrderCreateHouseEntity> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("uuid", paramString2);
    localHashMap.put("startDate", paramString3);
    localHashMap.put("endDate", paramString4);
    paramString1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramString1.add(new BedCountPost(((StationOrderCreateHouseEntity)paramList.get(i)).getHouseTypeId(), ((StationOrderCreateHouseEntity)paramList.get(i)).getSize()));
      i += 1;
    }
    localHashMap.put("bedCount", paramString1);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildStationUnEvaluateOrderList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uuid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, Object> buildStationUnPayOrderList(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uuid", paramString);
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> buildStationUserInfo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    localHashMap.put("hide", paramInt + "");
    paramContext = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertorByString(paramContext, localHashMap);
    u.e("Http HeaderImg json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return signMethod(paramContext);
  }
  
  public static Map<String, Object> buildSubmitOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, StationCoupon.DataEntity paramDataEntity, String paramString9, float paramFloat, List<StationOrderCreateHouseEntity> paramList, List<StationOrderCreateUserEntity> paramList1)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectBid", paramString1);
    localHashMap.put("arriveTime", paramString2);
    localHashMap.put("startDate", paramString3);
    localHashMap.put("endDate", paramString4);
    localHashMap.put("orderName", paramString5);
    localHashMap.put("phone", paramString6);
    localHashMap.put("mail", paramString7);
    localHashMap.put("uuid", paramString8);
    if ((paramDataEntity != null) && (!TextUtils.isEmpty(paramDataEntity.getTicketBid()))) {
      localHashMap.put("coupons", paramDataEntity.getTicketBid());
    }
    localHashMap.put("preOrderBid", paramString9);
    localHashMap.put("amount", Float.valueOf(paramFloat));
    paramString1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((StationOrderCreateHouseEntity)paramList.get(i)).getSize() > 0) {
        paramString1.add(new BedCountPost(((StationOrderCreateHouseEntity)paramList.get(i)).getHouseTypeId(), ((StationOrderCreateHouseEntity)paramList.get(i)).getSize()));
      }
      i += 1;
    }
    localHashMap.put("bedCount", paramString1);
    paramString1 = new ArrayList();
    int j = 0;
    if (j < paramList1.size())
    {
      i = 0;
      if (((StationOrderCreateUserEntity)paramList1.get(j)).getCredentialsStyle().contains("身份"))
      {
        i = 1;
        label323:
        if (!((StationOrderCreateUserEntity)paramList1.get(j)).getSex().equals("女")) {
          break label452;
        }
      }
      label452:
      for (byte b = 2;; b = 1)
      {
        paramString1.add(new StayPersonPost(((StationOrderCreateUserEntity)paramList1.get(j)).getName(), ((StationOrderCreateUserEntity)paramList1.get(j)).getHouseTypeBid(), i, ((StationOrderCreateUserEntity)paramList1.get(j)).getCredentials(), b));
        j += 1;
        break;
        if (!((StationOrderCreateUserEntity)paramList1.get(j)).getCredentialsStyle().contains("护照")) {
          break label323;
        }
        i = 2;
        break label323;
      }
    }
    localHashMap.put("stayPersonInfo", paramString1);
    return com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, localHashMap);
  }
  
  public static Map<String, Object> buildUpdatePic(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    paramString = new File(paramString).getName();
    u.e("Http before filename:", paramString);
    paramString = paramString.substring(0, paramString.lastIndexOf(".")) + ".jpg";
    ((Map)localObject).put("filename", paramString);
    u.e("Http after filename:", paramString);
    localObject = com.ziroom.ziroomcustomer.ziroomstation.utils.a.convertor(paramContext, (Map)localObject);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(localObject, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    paramContext = new HashMap();
    paramString = c.createEncryption("DES").encrypt(com.alibaba.fastjson.a.toJSONString(localObject), "vpRZ1kmU", "ZiR00mYi");
    localObject = h.toMd5(com.alibaba.fastjson.a.toJSONString(localObject).getBytes());
    paramContext.put("p", paramString);
    paramContext.put("sign", localObject);
    u.e("Http StationList json map:", com.alibaba.fastjson.a.toJSONString(paramContext, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return paramContext;
  }
  
  public static Map<String, String> signMethod(Map<String, String> paramMap)
  {
    String str = c.createEncryption("DES").encrypt(com.alibaba.fastjson.a.toJSONString(paramMap), "vpRZ1kmU", "ZiR00mYi");
    paramMap = h.toMd5(com.alibaba.fastjson.a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("p", str);
    localHashMap.put("sign", paramMap);
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */