package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.Commodity;
import com.ziroom.ziroomcustomer.model.MHNeedLike;
import com.ziroom.ziroomcustomer.model.OrderDate;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.x;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCommitInfo;
import com.ziroom.ziroomcustomer.util.aa;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.k;
import com.ziroom.ziroomcustomer.util.u;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class m
{
  public static Map<String, Object> buildBuyCleanCard(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("valueCardTypeId", Integer.valueOf(paramInt));
    paramContext.put("uid", paramString1);
    paramContext.put("phone", paramString2);
    paramContext.put("name", paramString3);
    paramContext.put("sourceCityCode", com.ziroom.ziroomcustomer.base.b.d);
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.put("recommendUserMobile", paramString4);
    }
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static Map<String, Object> buildBuyCleanStoredCard(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Map localMap = getCardCommon(paramContext);
    localMap.put("valueCardTypeId", Integer.valueOf(paramInt));
    localMap.put("uid", paramString1);
    localMap.put("phone", paramString2);
    localMap.put("name", paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      localMap.put("recommendUserMobile", paramString4);
    }
    localMap.put("clientCode", ah.getDeviceId(paramContext));
    localMap.put("sourceType", "android");
    localMap.put("sourceVersion", ah.getVersion(paramContext));
    localMap.put("sourceCityCode", com.ziroom.ziroomcustomer.base.b.d);
    return createPostEncode(a.toJSONString(localMap));
  }
  
  public static Map<String, Object> buildCanBuyCleanCard(Context paramContext)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static Map<String, Object> buildCanBuyCleanStoredCard(Context paramContext, String paramString, int paramInt)
  {
    Map localMap = getCardCommon(paramContext);
    localMap.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    localMap.put("uid", paramString);
    localMap.put("clientCode", ah.getDeviceId(paramContext));
    localMap.put("sourceType", "android");
    localMap.put("sourceVersion", "");
    localMap.put("amountType", Integer.valueOf(paramInt));
    return createPostEncode(a.toJSONString(localMap));
  }
  
  public static Map<String, Object> buildChangeClean(String paramString1, String paramString2, String paramString3, String paramString4, OrderDate paramOrderDate1, OrderDate paramOrderDate2, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("loginPhone", paramString2);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("contactName", paramString3);
    localHashMap.put("leaseContract", paramString5);
    localHashMap.put("roomNum", paramString6);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("contactTel", paramString4);
    paramString2 = new ArrayList();
    paramString3 = new HashMap();
    paramString3.put("orderTime", paramOrderDate1.getOrderTime());
    paramString3.put("orderTimePeriod", Integer.valueOf(paramOrderDate1.getOrderTimePeriod()));
    if (ae.isNull(paramOrderDate1.getWorkBillId())) {}
    for (paramString1 = "";; paramString1 = paramOrderDate1.getWorkBillId())
    {
      paramString3.put("workBillId", paramString1);
      paramString1 = new ArrayList();
      paramString4 = paramOrderDate1.getValueAddedList().iterator();
      while (paramString4.hasNext())
      {
        paramOrderDate1 = (String)paramString4.next();
        paramString5 = new HashMap();
        paramString5.put("vasbId", paramOrderDate1);
        paramString1.add(paramString5);
      }
    }
    paramString3.put("valueAddedList", paramString1);
    paramString2.add(paramString3);
    if (paramInt1 == 2)
    {
      paramString3 = new HashMap();
      paramString3.put("orderTime", paramOrderDate2.getOrderTime());
      paramString3.put("orderTimePeriod", Integer.valueOf(paramOrderDate2.getOrderTimePeriod()));
      if (ae.isNull(paramOrderDate2.getWorkBillId())) {}
      for (paramString1 = "";; paramString1 = paramOrderDate2.getWorkBillId())
      {
        paramString3.put("workBillId", paramString1);
        paramString1 = new ArrayList();
        paramString4 = paramOrderDate2.getValueAddedList().iterator();
        while (paramString4.hasNext())
        {
          paramOrderDate1 = (String)paramString4.next();
          paramOrderDate2 = new HashMap();
          paramOrderDate2.put("vasbId", paramOrderDate1);
          paramString1.add(paramOrderDate2);
        }
      }
      paramString3.put("valueAddedList", paramString1);
      paramString2.add(paramString3);
    }
    localHashMap.put("orderDate", paramString2);
    localHashMap.put("isConfirm", Integer.valueOf(paramInt2));
    localHashMap.put("dataSource", Integer.valueOf(paramInt3));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildChatNums(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clickType", paramString);
    return localHashMap;
  }
  
  public static Map<String, Object> buildChatSuggestion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("complainObj", paramString1);
    localHashMap.put("complainType", paramString2);
    localHashMap.put("complainContent", paramString3);
    localHashMap.put("linkPhone", paramString4);
    localHashMap.put("rentContractCode", paramString5);
    localHashMap.put("houseSourceCode", paramString6);
    localHashMap.put("address", paramString7);
    localHashMap.put("customerName", paramString8);
    localHashMap.put("uid", paramString9);
    localHashMap.put("source", paramString10);
    localHashMap.put("pictures", a.toJSON(paramList));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    return localHashMap;
  }
  
  public static Map<String, Object> buildCleanCardFollowInfo(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("uid", paramString);
    paramContext.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    paramContext.put("pageNum", Integer.valueOf(paramInt1));
    paramContext.put("pageSize", Integer.valueOf(paramInt2));
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static Map<String, Object> buildCleanCardLeft(Context paramContext, String paramString)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("uid", paramString);
    paramContext.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static Map<String, Object> buildCleanCardList(Context paramContext, String paramString)
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
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = k.encrypt(a.toJSONString(localObject));
    paramString2 = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildCleanServicePriceItem(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceInfoId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    return new HashMap();
  }
  
  public static Map<String, Object> buildCleanServicePriceSheet(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceInfoId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildCleanServicesTime(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("city_code", paramString1);
    localHashMap.put("serviceType", paramString2);
    localHashMap.put("serviceItemId", paramString3);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildCleanerCapacity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("cleanerId", paramString2);
    localHashMap.put("appointDate", paramString3);
    localHashMap.put("serviceInfoId", paramString4);
    localHashMap.put("servicePmId", paramString5);
    localHashMap.put("addressId", paramString6);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("versionNum", paramString7);
    localHashMap.put("userOrderCode", paramString8);
    u.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildCleanerEvalInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cleanerId", paramString1);
    localHashMap.put("hasContent", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("pageSize", Integer.valueOf(paramInt3));
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("versionNum", paramString2);
    u.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildCleanerInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("cleanId", paramString2);
    localHashMap.put("appointDateTime", paramString3);
    localHashMap.put("serviceInfoId", paramString4);
    localHashMap.put("servicePmId", paramString5);
    localHashMap.put("addressId", paramString6);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("dataSource", Integer.valueOf(12));
    u.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildCommonCleanCapacity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("appointDate", paramString2);
    localHashMap.put("serviceInfoId", paramString3);
    localHashMap.put("servicePmId", paramString4);
    localHashMap.put("addressId", paramString5);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("dataSource", Integer.valueOf(12));
    u.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildDialyCleanBook(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    HashMap localHashMap = new HashMap();
    String str = String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("servicePmId", paramString2);
    localHashMap.put("price", Integer.valueOf(paramInt1));
    localHashMap.put("appointDate", paramString3);
    localHashMap.put("address", paramString4);
    localHashMap.put("remark", paramString5);
    localHashMap.put("uid", paramString6);
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("houseSource", paramString7);
    localHashMap.put("signature", ah.toMd5((paramString6 + str + SignKeyUtil.getHouseKey()).getBytes()));
    localHashMap.put("rentContract", paramString8);
    localHashMap.put("hireContract", paramString9);
    localHashMap.put("linkman", paramString10);
    localHashMap.put("linkPhone", paramString11);
    localHashMap.put("timestamp", str);
    localHashMap.put("appointTime", Integer.valueOf(paramInt2));
    localHashMap.put("promoCodeId", paramString12);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildDialyCleanOrderBook(String paramString1, String paramString2, double paramDouble1, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, double paramDouble2)
  {
    HashMap localHashMap = new HashMap();
    String str = String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("servicePmId", paramString2);
    localHashMap.put("price", Double.valueOf(paramDouble1));
    localHashMap.put("appointDate", paramString3);
    localHashMap.put("address", paramString4);
    localHashMap.put("remark", paramString5);
    localHashMap.put("uid", paramString6);
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("houseSource", paramString7);
    localHashMap.put("signature", ah.toMd5((paramString6 + str + SignKeyUtil.getHouseKey()).getBytes()));
    localHashMap.put("rentContract", paramString8);
    localHashMap.put("hireContract", paramString9);
    localHashMap.put("linkman", paramString10);
    localHashMap.put("linkPhone", paramString11);
    localHashMap.put("timestamp", str);
    localHashMap.put("appointTime", Integer.valueOf(paramInt));
    localHashMap.put("promoCodeId", paramString12);
    localHashMap.put("addressXY", paramString13);
    localHashMap.put("discountPrice", Double.valueOf(paramDouble2));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildDialyCleanOrderListMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildDialyCleanPay(String paramString1, String paramString2, float paramFloat, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("terminalType", paramString2);
    localHashMap.put("money", Float.valueOf(paramFloat));
    localHashMap.put("payWay", Integer.valueOf(paramInt));
    localHashMap.put("orderId", paramString3);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("terminalVersion", ah.getVersion(ApplicationEx.c));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildDialyCleanPriceList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceInfoId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildDialyMsg(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildFinishAcceptance(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("workOrderId", paramString);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildGeneralCleanPay(Context paramContext, String paramString1, float paramFloat, String paramString2)
  {
    Map localMap = getCardCommon(paramContext);
    localMap.put("terminalType", "android");
    localMap.put("terminalVersion", ah.getVersion(paramContext));
    localMap.put("orderId", paramString1);
    localMap.put("money", Float.valueOf(paramFloat));
    localMap.put("uid", paramString2);
    return createPostEncode(a.toJSONString(localMap));
  }
  
  public static Map<String, Object> buildGeneralTimePoint(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("serviceInfoId", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    String str = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetAcceptConfirm(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("orderAscription", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetCleanList(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("expand", paramString3);
    localHashMap.put("curPageNo", Integer.valueOf(paramInt1));
    localHashMap.put("pageSize", Integer.valueOf(paramInt2));
    localHashMap.put("billNo", paramString2);
    localHashMap.put("pageSize", Integer.valueOf(paramInt2));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildGetEvalInfo(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("orderAscription", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("servicerCode", paramString5);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetExterRepairCancleOrder(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("orderAscription", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("cancelReasonExplain", paramString5);
    localHashMap.put("cancelReason", paramString6);
    localHashMap.put("cancelRemark", paramString7);
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetExterRepairOrderTag(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("orderAscription", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetKJZTXM(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("czhth", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairArticle(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString1);
    localHashMap.put("ztCode", paramString2);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildGetRepairCapacity(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("empTypeId", paramString1);
    localHashMap.put("startDate", paramString2);
    localHashMap.put("endDate", paramString3);
    localHashMap.put("itemSize", Integer.valueOf(paramInt));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildGetRepairEngineer()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("params", a.toJSONString(localHashMap1));
    return localHashMap2;
  }
  
  public static Map<String, Object> buildGetRepairList(String paramString1, Long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("pageSize", Integer.valueOf(paramInt3));
    localHashMap.put("visitType", Integer.valueOf(paramInt4));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetRepairListDetail(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("loginPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("billNo", paramString4);
    localHashMap.put("orderAscription", paramString5);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("findType", Integer.valueOf(0));
    localHashMap.put("status", Integer.valueOf(-1));
    return localHashMap;
  }
  
  public static Map<String, Object> buildGetRepairProgress(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairReason(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("xmCode", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairRecord(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("wxxmId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairScore(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairTime(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("empTypeId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetRepairType(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildGetSysBanner(String paramString)
  {
    paramString = new HashMap();
    paramString.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    return getHouseSign(paramString);
  }
  
  public static Map<String, Object> buildGetSysItem(String paramString)
  {
    paramString = new HashMap();
    paramString.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    return getHouseSign(paramString);
  }
  
  public static Map<String, Object> buildHotQuestions(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("classId", paramString1);
    localHashMap.put("itemId", paramString2);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("pageSize", Integer.valueOf(paramInt));
    return localHashMap;
  }
  
  public static Map<String, Object> buildHotQuestions_2(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mapperClassId", paramString);
    localHashMap.put("clientMark", "ZIROOM_APP");
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("pageSize", Integer.valueOf(paramInt1));
    localHashMap.put("pageNumber", Integer.valueOf(paramInt2));
    return localHashMap;
  }
  
  public static Map<String, Object> buildLockRepairCapacity(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loginPhone", paramString2);
    localHashMap.put("signDate", paramString1);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("empTypeId", paramString3);
    localHashMap.put("orderTime", paramString4);
    localHashMap.put("orderTimePeriod", Integer.valueOf(paramInt1));
    localHashMap.put("oldOrderTime", paramString5);
    localHashMap.put("oldOrderTimePeriod", paramString6);
    localHashMap.put("supEmpId", paramString7);
    localHashMap.put("itemSize", Integer.valueOf(paramInt2));
    localHashMap.put("lockType", Integer.valueOf(paramInt3));
    localHashMap.put("rentContractCode", paramString8);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHAddEstimate(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString5, long paramLong)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    if ((paramMap1 != null) && (paramMap1.size() > 0)) {
      localHashMap.put("evaluatePositiveTag", paramMap1);
    }
    if ((paramMap2 != null) && (paramMap2.size() > 0)) {
      localHashMap.put("evaluateNegativeTag", paramMap2);
    }
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      localHashMap.put("content", paramString4);
    }
    localHashMap.put("userId", paramString1);
    localHashMap.put("workOrderId", paramString2);
    localHashMap.put("timestamp", Long.valueOf(paramLong));
    localHashMap.put("scroe", paramString3);
    localHashMap.put("cityCode", paramString5);
    localHashMap.put("evaluateSource", Integer.valueOf(12));
    u.e("serviceMh:", a.toJSONString(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHCancelOrder(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    if (paramMap.size() > 0) {
      localHashMap.put("cancelTag", paramMap);
    }
    if (paramString1.length() > 0) {
      localHashMap.put("cancelRemark", paramString1);
    }
    localHashMap.put("cancelerId", paramString2);
    localHashMap.put("workOrderId", paramString3);
    localHashMap.put("timestamp", Long.valueOf(paramLong));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHCapacity(String paramString1, Long paramLong1, Long paramLong2, Long paramLong3, String paramString2)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString1);
    localHashMap.put("orderStartTime", paramLong1);
    localHashMap.put("orderEndTime", paramLong2);
    localHashMap.put("timestamp", paramLong3);
    localHashMap.put("serviceInfoId", paramString2);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHComment(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("scroe", Integer.valueOf(paramInt));
    localHashMap.put("content", paramString2);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("signature", ah.toMd5((SignKeyUtil.getSignKey() + paramString1).getBytes()));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHCommodityListMap(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    localHashMap.put("page", Integer.valueOf(paramInt));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildMHCostEstimates(String paramString1, String paramString2, double paramDouble1, long paramLong1, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, Context paramContext)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("chooseGoods", paramString1);
    localHashMap.put("cityCode", paramString2);
    localHashMap.put("distance", Double.valueOf(paramDouble1));
    localHashMap.put("moveDate", Long.valueOf(paramLong1));
    localHashMap.put("orderEndArea", paramString4);
    localHashMap.put("orderStartArea", paramString3);
    if ((paramString5 != null) && (paramString5.length() > 0)) {
      localHashMap.put("promoCodeId", paramString5);
    }
    localHashMap.put("serviceInfoId", paramString6);
    localHashMap.put("timestamp", Long.valueOf(paramLong2));
    localHashMap.put("moveOutFloorsFee", Double.valueOf(paramDouble2));
    localHashMap.put("moveInFloorsFee", Double.valueOf(paramDouble3));
    localHashMap.put("startAddressLat", Double.valueOf(paramDouble4));
    localHashMap.put("startAddressLon", Double.valueOf(paramDouble5));
    localHashMap.put("endAddressLat", Double.valueOf(paramDouble6));
    localHashMap.put("endAddressLon", Double.valueOf(paramDouble7));
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("appVersion", ah.getVersion(paramContext.getApplicationContext()));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHCreateOrder(MHCommitInfo paramMHCommitInfo, String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    if (paramNotNull(paramMHCommitInfo.getCharacterIds())) {
      localHashMap.put("characterIds", paramMHCommitInfo.getCharacterIds());
    }
    if (paramNotNull(paramMHCommitInfo.getChooseGoods())) {
      localHashMap.put("chooseGoods", paramMHCommitInfo.getChooseGoods());
    }
    localHashMap.put("cityCode", paramMHCommitInfo.getCityCode());
    localHashMap.put("connectPhone", paramMHCommitInfo.getConnectPhone());
    localHashMap.put("distance", Double.valueOf(paramMHCommitInfo.getDistance()));
    localHashMap.put("endArea", paramMHCommitInfo.getEndArea());
    localHashMap.put("startArea", paramMHCommitInfo.getStartArea());
    localHashMap.put("endCoordinate", paramMHCommitInfo.getEndCoordinate());
    localHashMap.put("startCoordinate", paramMHCommitInfo.getStartCoordinate());
    localHashMap.put("moveDate", Long.valueOf(paramMHCommitInfo.getMoveDate()));
    if (paramNotNull(paramMHCommitInfo.getPromoCodeId())) {
      localHashMap.put("promoCodeId", paramMHCommitInfo.getPromoCodeId());
    }
    if (paramNotNull(paramMHCommitInfo.getRemark())) {
      localHashMap.put("remark", paramMHCommitInfo.getRemark());
    }
    localHashMap.put("serviceInfoId", paramMHCommitInfo.getServiceInfoId());
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("startAreaPoint", paramMHCommitInfo.getStartAreaPoint());
    localHashMap.put("endAreaPoint", paramMHCommitInfo.getEndAreaPoint());
    if (paramNotNull(paramMHCommitInfo.getUuid())) {
      localHashMap.put("uuid", paramMHCommitInfo.getUuid());
    }
    String str = "当前信息: " + Build.MODEL + " , " + Build.VERSION.RELEASE + " , ID:" + Build.ID + " , MoveDate: " + paramMHCommitInfo.getMoveDate();
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("appVersion", ah.getVersion(paramContext.getApplicationContext()));
    localHashMap.put("versionNum", str);
    localHashMap.put("channelCode", paramString1);
    localHashMap.put("operatorMan", paramString2);
    localHashMap.put("clientVersion", paramString3);
    if ((paramMHCommitInfo.getMoveInElevator() > -1) && (paramMHCommitInfo.getMoveInFloors() > -1))
    {
      localHashMap.put("moveInElevator", Integer.valueOf(paramMHCommitInfo.getMoveInElevator()));
      localHashMap.put("moveInFloors", Integer.valueOf(paramMHCommitInfo.getMoveInFloors()));
      localHashMap.put("moveInFloorsFee", Double.valueOf(paramMHCommitInfo.getMoveInFloorsFee()));
    }
    if ((paramMHCommitInfo.getMoveOutElevator() > -1) && (paramMHCommitInfo.getMoveOutFloors() > -1))
    {
      localHashMap.put("moveOutElevator", Integer.valueOf(paramMHCommitInfo.getMoveOutElevator()));
      localHashMap.put("moveOutFloors", Integer.valueOf(paramMHCommitInfo.getMoveOutFloors()));
      localHashMap.put("moveOutFloorsFee", Double.valueOf(paramMHCommitInfo.getMoveOutFloorsFee()));
    }
    localHashMap.put("moveDateTime", Long.valueOf(paramMHCommitInfo.getMoveDateTime()));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHDetailMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billId", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildMHDicTag(String paramString, long paramLong)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("dicType", paramString);
    localHashMap.put("timestamp", Long.valueOf(paramLong));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHFloorsFeeList(String paramString)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("serviceInfoId", paramString);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHGetSysDate()
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHMakeOrderMap(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, List<MHNeedLike> paramList, List<Commodity> paramList1, String paramString12, String paramString13, float paramFloat, int paramInt, String paramString14, String paramString15)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("startaddress", paramString1);
    localHashMap.put("endaddress", paramString2);
    localHashMap.put("s_log_lat", paramString3);
    localHashMap.put("e_log_lat", paramString4);
    localHashMap.put("date", paramString5);
    localHashMap.put("house_code", paramString6);
    localHashMap.put("contract", paramString7);
    localHashMap.put("uid", paramString8);
    localHashMap.put("name", paramString9);
    localHashMap.put("phone", paramString10);
    localHashMap.put("version", paramString11);
    localHashMap.put("note", paramString12);
    localHashMap.put("modeid", paramString13);
    localHashMap.put("timeId", Integer.valueOf(paramInt));
    localHashMap.put("miles", Float.valueOf(paramFloat));
    localHashMap.put("serviceInfoId", paramString14);
    localHashMap.put("promoCodeId", paramString15);
    localHashMap.put("signature", ah.toMd5((SignKeyUtil.getSignKey() + paramString5 + paramString8 + paramString10).getBytes()));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      paramString2 = paramList.iterator();
    }
    for (;;)
    {
      if (paramString2.hasNext())
      {
        paramString3 = (MHNeedLike)paramString2.next();
        if (paramString3 != null) {}
      }
      else
      {
        paramString2 = new ArrayList();
        if (paramList1 == null) {
          break;
        }
        paramString3 = paramList1.iterator();
        while (paramString3.hasNext())
        {
          paramString4 = (Commodity)paramString3.next();
          paramString5 = new HashMap();
          paramString5.put("id", paramString4.getItemId());
          paramString5.put("number", Integer.valueOf(paramString4.getNum()));
          paramString2.add(paramString5);
        }
      }
      paramString4 = new HashMap();
      paramString4.put("id", Integer.valueOf(paramString3.getId()));
      paramString4.put("name", paramString3.getDetail());
      paramString1.add(paramString4);
    }
    localHashMap.put("items", paramString2);
    localHashMap.put("demands", paramString1);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHMakeOrderSecendMap(String paramString, List<Commodity> paramList)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("billId", paramString);
    localHashMap1.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Commodity localCommodity = (Commodity)paramList.next();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("id", localCommodity.getItemId());
      localHashMap2.put("num", Integer.valueOf(localCommodity.getNum()));
      paramString.add(localHashMap2);
    }
    localHashMap1.put("goodsList", paramString);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap1));
    return paramString;
  }
  
  public static Map<String, Object> buildMHOrderDetail(Long paramLong, String paramString)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("workOrderId", paramString);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHOrderListMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildMHPayOrder(String paramString1, String paramString2, float paramFloat, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("terminalType", paramString2);
    localHashMap.put("money", Float.valueOf(paramFloat));
    localHashMap.put("payway", Integer.valueOf(paramInt));
    localHashMap.put("billid", paramString3);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("terminalVersion", ah.getVersion(ApplicationEx.c));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHPayOrder(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("contract", paramString2);
    localHashMap.put("billid", paramString3);
    localHashMap.put("money", Integer.valueOf(paramInt));
    localHashMap.put("terminal", paramString4);
    localHashMap.put("payway", paramString5);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHRegularMap(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("miles", paramString1);
    localHashMap.put("serviceInfoId", paramString2);
    localHashMap.put("uid", paramString3);
    localHashMap.put("appointDate", paramString4);
    localHashMap.put("signature", ah.toMd5((paramString1 + SignKeyUtil.getSignKey()).getBytes()));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildMHService()
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHService(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceTypeCode", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildMHServiceTime(String paramString1, String paramString2)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString1);
    localHashMap.put("serviceInfoId", paramString2);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHSuccessHint(String paramString1, String paramString2, String paramString3)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("fserviceinfoid", paramString1);
    localHashMap.put("fversion", paramString2);
    localHashMap.put("fcityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("docType", paramString3);
    }
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMHToolList(String paramString1, String paramString2, int paramInt)
  {
    new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString1);
    localHashMap.put("serviceInfoId", paramString2);
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> buildMakeCleanOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, double paramDouble, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("rentContractCode", paramString2);
    localHashMap.put("roomNo", paramString3);
    localHashMap.put("terminalType", paramString4);
    localHashMap.put("workBillId", paramString5);
    localHashMap.put("money", Double.valueOf(paramDouble));
    localHashMap.put("payWay", Integer.valueOf(paramInt));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildModifyContact(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString1);
    localHashMap.put("clientTel", paramString2);
    localHashMap.put("ownerId", paramString3);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
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
  
  public static Map<String, Object> buildMySuggests(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNetPhone(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseSourceCode", paramString);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewCleanCapacity(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("date", paramString2);
    localHashMap.put("timeperoid", paramString3);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramString2);
    paramString3.put("v", paramContext);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewCleanCostEstimates(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, List<x> paramList, String paramString20)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("serviceInfoId", paramString2);
    localHashMap.put("uid", paramString1);
    localHashMap.put("serviceInfoName", paramString3);
    localHashMap.put("servicePmId", paramString4);
    localHashMap.put("servicePmName", paramString5);
    localHashMap.put("appointDate", paramString6);
    localHashMap.put("timePeroidId", paramString7);
    localHashMap.put("timePeroid", paramString8);
    localHashMap.put("addressId", paramString9);
    localHashMap.put("address", paramString10);
    localHashMap.put("addressXY", paramString11);
    localHashMap.put("remark", paramString12);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("linkMan", paramString13);
    localHashMap.put("linkPhone", paramString14);
    localHashMap.put("promoCodeId", paramString15);
    localHashMap.put("price", paramString16);
    localHashMap.put("servicePrice", paramString17);
    localHashMap.put("discountPrice", paramString18);
    localHashMap.put("goodsPrice", paramString19);
    localHashMap.put("goods", a.toJSON(paramList));
    localHashMap.put("appointTime", paramString20);
    localHashMap.put("version", "V1.4");
    u.e("费用评估： ", a.toJSONString(localHashMap));
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramString2);
    paramString3.put("v", paramContext);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewCleanGoods(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("serviceInfoId", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", paramContext);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewCleanList(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("uid", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", paramContext);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewComplainDetail(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("complainId", paramString);
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewComplainHistoryList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("rent", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewComplainOngingList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("rent", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, String> buildNewCoupon(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("uid", paramString2);
    localHashMap.put("promoCode", paramString3);
    localHashMap.put("ignoreServiceInfo", paramString4);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramString2);
    paramString3.put("v", paramContext);
    return paramString3;
  }
  
  public static Map<String, String> buildNewCouponList(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("uid", paramString2);
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("pageSize", Integer.valueOf(paramInt2));
    localHashMap.put("version", "V1.4");
    u.e("dskjglkfds", a.toJSONString(localHashMap));
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", paramContext);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewCreateGOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, double paramDouble, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt, List<x> paramList, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    paramContext = new HashMap();
    paramContext.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("address", paramString1);
    paramContext.put("addressId", paramString2);
    paramContext.put("appointDate", paramString3);
    paramContext.put("linkPhone", paramString4);
    paramContext.put("price", Double.valueOf(paramDouble));
    paramContext.put("promoCodeId", paramString5);
    paramContext.put("remark", paramString6);
    paramContext.put("serviceInfoId", paramString7);
    paramContext.put("servicePmId", paramString8);
    paramContext.put("timePeroidId", paramString9);
    paramContext.put("uid", paramString10);
    paramContext.put("dataSource", Integer.valueOf(paramInt));
    paramContext.put("goods", a.toJSON(paramList));
    paramContext.put("appointTime", paramString11);
    paramContext.put("channelCode", paramString12);
    paramContext.put("operatorMan", paramString13);
    paramContext.put("employeeLogicCode", paramString14);
    paramContext.put("version", "V1.4");
    paramString1 = k.encrypt(a.toJSONString(paramContext));
    paramContext = ah.toMd5(a.toJSONString(paramContext).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramContext);
    paramString3.put("v", paramString2);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewDialyCleanTimePeriod(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("serviceInfoId", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    String str = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralAAddList(Context paramContext, String paramString1, String paramString2, double paramDouble1, String paramString3, double paramDouble2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramContext = new HashMap();
    paramContext.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("detAddress", paramString1);
    paramContext.put("grade", paramString2);
    paramContext.put("latitude", Double.valueOf(paramDouble1));
    paramContext.put("linkPhone", paramString3);
    paramContext.put("longitude", Double.valueOf(paramDouble2));
    paramContext.put("provinceCode", paramString4);
    paramContext.put("userId", paramString5);
    paramContext.put("userName", paramString6);
    paramContext.put("userAccount", paramString7);
    paramContext.put("village", paramString8);
    u.e("buildNewGeneralAAddList", a.toJSONString(paramContext));
    paramString1 = k.encrypt(a.toJSONString(paramContext));
    paramContext = ah.toMd5(a.toJSONString(paramContext).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramContext);
    paramString3.put("v", paramString2);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewGeneralAList(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    ((Map)localObject).put("uid", paramString);
    ((Map)localObject).put("version", "V1.4");
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralAModifyList(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    paramContext = new HashMap();
    paramContext.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("detAddress", paramString1);
    paramContext.put("grade", paramString3);
    paramContext.put("latitude", paramString4);
    paramContext.put("linkPhone", paramString5);
    paramContext.put("longitude", paramString6);
    paramContext.put("provinceCode", paramString7);
    paramContext.put("userId", paramString8);
    paramContext.put("village", paramString9);
    paramContext.put("fid", paramString2);
    paramContext.put("isSuggest", Integer.valueOf(paramInt1));
    paramContext.put("isValid", Integer.valueOf(paramInt2));
    u.e("buildNewGeneralAModifyList", a.toJSONString(paramContext));
    paramString1 = k.encrypt(a.toJSONString(paramContext));
    paramContext = ah.toMd5(a.toJSONString(paramContext).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramContext);
    paramString3.put("v", paramString2);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewGeneralCancle(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new HashMap();
    paramContext.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("cleanId", paramString1);
    paramContext.put("uid", paramString2);
    paramContext.put("reason", paramString3);
    paramString1 = k.encrypt(a.toJSONString(paramContext));
    paramContext = ah.toMd5(a.toJSONString(paramContext).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramContext);
    paramString3.put("v", paramString2);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewGeneralCancleView(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("cleanId", paramString1);
    localHashMap.put("uid", paramString2);
    paramContext = k.encrypt(a.toJSONString(localHashMap));
    paramString1 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString1);
    localHashMap.put("v", paramString2);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralDetail(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("cleanId", paramString);
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralInfo(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("cleanId", paramString);
    ((Map)localObject).put("orderState", Integer.valueOf(paramInt1));
    ((Map)localObject).put("page", Integer.valueOf(paramInt2));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt3));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralList(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("uid", paramString);
    ((Map)localObject).put("visitState", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageNum", Integer.valueOf(paramInt2));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt3));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewGeneralWorkerInfo(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("empId", paramString1);
    localHashMap.put("cleanId", paramString2);
    paramContext = k.encrypt(a.toJSONString(localHashMap));
    paramString1 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString1);
    localHashMap.put("v", paramString2);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewMHHistoryList(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("userId", paramString1);
    localHashMap.put("queryStatus", paramString2);
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localHashMap));
    paramString1 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString2 = ApplicationEx.c.getVersionCode();
    localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString1);
    localHashMap.put("v", paramString2);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewRentDetail(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("serviceProjectId", paramString);
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewRentHistoryList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("mobile", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewRentInfo(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("serviceProjectId", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewRentOngoingList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("mobile", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewSOrderInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("uid", paramString2);
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("zhengZu", paramString3);
    localHashMap.put("version", "V1.4");
    u.e("skdjg", a.toJSONString(localHashMap));
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    paramString3 = new HashMap();
    paramString3.put("2y5QfvAy", paramString1);
    paramString3.put("hPtJ39Xs", paramString2);
    paramString3.put("v", paramContext);
    return paramString3;
  }
  
  public static Map<String, Object> buildNewSOrderNums(Context paramContext, List<String> paramList, String paramString1, String paramString2)
  {
    paramContext = new HashMap();
    paramContext.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    paramContext.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.put("uid", paramString2);
    paramContext.put("expands", a.toJSON(paramList));
    paramContext.put("loginPhone", paramString1);
    paramList = k.encrypt(a.toJSONString(paramContext));
    paramContext = ah.toMd5(a.toJSONString(paramContext).getBytes());
    paramString1 = ApplicationEx.c.getVersionCode();
    paramString2 = new HashMap();
    paramString2.put("2y5QfvAy", paramList);
    paramString2.put("hPtJ39Xs", paramContext);
    paramString2.put("v", paramString1);
    return paramString2;
  }
  
  public static Map<String, Object> buildNewTimeP(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    ((Map)localObject).put("serviceInfoId", paramString);
    u.e("服务类型时间： ", a.toJSONString(localObject));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekCleanDetail(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("monthCleanId", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    String str = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekCleanOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, String paramString8, long paramLong2, int paramInt1, int paramInt2, String paramString9)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("billId", paramString2);
    localHashMap.put("loginPhone", paramString3);
    localHashMap.put("contactName", paramString4);
    localHashMap.put("contactTel", paramString5);
    localHashMap.put("datePlan", Long.valueOf(paramLong1));
    localHashMap.put("czhth", paramString6);
    localHashMap.put("contractCode", paramString7);
    localHashMap.put("expand", paramString8);
    localHashMap.put("construction", Long.valueOf(paramLong2));
    localHashMap.put("timePerod", Integer.valueOf(paramInt1));
    localHashMap.put("dataSource", Integer.valueOf(paramInt2));
    localHashMap.put("roomNum", paramString9);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString3 = ApplicationEx.c.getVersionCode();
    paramString4 = new HashMap();
    paramString4.put("2y5QfvAy", paramString1);
    paramString4.put("hPtJ39Xs", paramString2);
    paramString4.put("v", paramString3);
    return paramString4;
  }
  
  public static Map<String, Object> buildNewWeekCleanTimeInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("uid", paramString2);
    localHashMap.put("czhth", paramString3);
    localHashMap.put("expand", paramString4);
    localHashMap.put("isOverAll", Integer.valueOf(paramInt1));
    localHashMap.put("deepOrderDate", Long.valueOf(paramLong));
    localHashMap.put("flag", Integer.valueOf(paramInt2));
    localHashMap.put("cityCode", paramString5);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString3 = ApplicationEx.c.getVersionCode();
    paramString4 = new HashMap();
    paramString4.put("2y5QfvAy", paramString1);
    paramString4.put("hPtJ39Xs", paramString2);
    paramString4.put("v", paramString3);
    return paramString4;
  }
  
  public static Map<String, Object> buildNewWeekCleanTimePeriod(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("contractCode", paramString1);
    ((Map)localObject).put("expand", paramString2);
    paramString1 = k.encrypt(a.toJSONString(localObject));
    paramString2 = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekCleanerInfo(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("cleanerId", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    String str = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekEvaluate(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("cleanId", paramString1);
    localHashMap.put("score", Integer.valueOf(paramInt));
    localHashMap.put("uid", paramString2);
    localHashMap.put("tags", paramString3);
    localHashMap.put("remark", paramString4);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString3 = ApplicationEx.c.getVersionCode();
    paramString4 = new HashMap();
    paramString4.put("2y5QfvAy", paramString1);
    paramString4.put("hPtJ39Xs", paramString2);
    paramString4.put("v", paramString3);
    return paramString4;
  }
  
  public static Map<String, Object> buildNewWeekEvaluateInfo(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("cleanerId", paramString1);
    ((Map)localObject).put("evaluateId", paramString2);
    paramString1 = k.encrypt(a.toJSONString(localObject));
    paramString2 = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekFollowInfo(String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("dataSource", Integer.valueOf(12));
    ((Map)localObject).put("monthCleanId", paramString);
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    String str = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", str);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekHistoryList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("expand", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildNewWeekOngoingList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    ((Map)localObject).put("expand", paramString);
    ((Map)localObject).put("page", Integer.valueOf(paramInt1));
    ((Map)localObject).put("pageSize", Integer.valueOf(paramInt2));
    paramContext = k.encrypt(a.toJSONString(localObject));
    paramString = ah.toMd5(a.toJSONString(localObject).getBytes());
    localObject = ApplicationEx.c.getVersionCode();
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramContext);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("v", localObject);
    return localHashMap;
  }
  
  public static Map<String, Object> buildReminder(String paramString)
    throws Exception
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("projectId", paramString);
    u.e("buildRentFeedBack json map", a.toJSONString(localHashMap1, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    paramString = aa.loadPublicKey(aa.a);
    localHashMap2.put("body", com.ziroom.ziroomcustomer.util.g.encode(aa.encrypt(a.toJSONString(localHashMap1, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }).getBytes("UTF-8"), paramString)));
    return localHashMap2;
  }
  
  public static Map<String, Object> buildRentEvaluate(String paramString1, int paramInt, String paramString2)
    throws Exception
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("workOrderId", paramString1);
    localHashMap1.put("star", Integer.valueOf(paramInt));
    localHashMap1.put("content", paramString2);
    u.e("buildRentFeedBack json map", a.toJSONString(localHashMap1, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    paramString1 = aa.loadPublicKey(aa.a);
    localHashMap2.put("body", com.ziroom.ziroomcustomer.util.g.encode(aa.encrypt(a.toJSONString(localHashMap1, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }).getBytes("UTF-8"), paramString1)));
    return localHashMap2;
  }
  
  public static Map<String, Object> buildRepairPeriod(String paramString)
  {
    paramString = new HashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", a.toJSONString(paramString));
    return localHashMap;
  }
  
  public static Map<String, Object> buildReserveClean(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, OrderDate paramOrderDate1, OrderDate paramOrderDate2, int paramInt1, String paramString8, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("loginPhone", paramString2);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("contactName", paramString3);
    localHashMap.put("contactTel", paramString4);
    localHashMap.put("hireRentContractCode", paramString5);
    localHashMap.put("leaseContract", paramString6);
    localHashMap.put("roomNum", paramString7);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new ArrayList();
    paramString2 = new HashMap();
    paramString2.put("orderTime", paramOrderDate1.getOrderTime());
    paramString2.put("orderTimePeriod", Integer.valueOf(paramOrderDate1.getOrderTimePeriod()));
    paramString3 = new ArrayList();
    paramString4 = paramOrderDate1.getValueAddedList().iterator();
    while (paramString4.hasNext())
    {
      paramString5 = (String)paramString4.next();
      paramString6 = new HashMap();
      paramString6.put("vasbId", paramString5);
      paramString3.add(paramString6);
    }
    paramString2.put("valueAddedList", paramString3);
    paramString1.add(paramString2);
    paramString2 = new HashMap();
    paramString2.put("orderTime", paramOrderDate2.getOrderTime());
    paramString2.put("orderTimePeriod", Integer.valueOf(paramOrderDate2.getOrderTimePeriod()));
    paramString3 = new ArrayList();
    paramString4 = paramOrderDate2.getValueAddedList().iterator();
    while (paramString4.hasNext())
    {
      paramString5 = (String)paramString4.next();
      paramString6 = new HashMap();
      paramString6.put("vasbId", paramString5);
      paramString3.add(paramString6);
    }
    paramString2.put("valueAddedList", paramString3);
    paramString1.add(paramString2);
    localHashMap.put("orderDate", paramString1);
    localHashMap.put("expand", paramString8);
    localHashMap.put("isConfirm", Integer.valueOf(paramInt2));
    localHashMap.put("dataSource", Integer.valueOf(paramInt3));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildReviseOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billId", paramString1);
    localHashMap.put("contactName", paramString2);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString4 + paramString6).getBytes()));
    localHashMap.put("contactTel", paramString3);
    localHashMap.put("loginPhone", paramString4);
    localHashMap.put("orderTime", paramString5);
    localHashMap.put("orderTimePeriod", Integer.valueOf(paramInt));
    localHashMap.put("signDate", paramString6);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildRevokeRepair(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("loginPhone", paramString2);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("wxxmId", paramString3);
    localHashMap.put("desc", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSaveEvalInfo(String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger, String paramString7, String paramString8)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("timestamp", paramLong);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("dataSource", Integer.valueOf(paramInt));
    localHashMap.put("maintainOrderCode", paramString3);
    localHashMap.put("orderAscription", paramString4);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("evaluateContent", paramString5);
    localHashMap.put("evaluateProjectCode", paramString6);
    localHashMap.put("evaluateScore", paramInteger);
    localHashMap.put("strPositiveLabels", paramString7);
    localHashMap.put("strNegativeLabels", paramString8);
    return localHashMap;
  }
  
  public static String buildServeCarouselPic(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&timestamp=");
    long l = System.currentTimeMillis() / 1000L;
    localStringBuilder.append(l);
    localStringBuilder.append("&uid=");
    localStringBuilder.append(paramString1);
    paramString1 = ah.toMd5((paramString1 + l + "7srzT88FcNiRQA3n").getBytes());
    localStringBuilder.append("&sign=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&id=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&city_code=");
    localStringBuilder.append(com.ziroom.ziroomcustomer.base.b.d);
    return localStringBuilder.toString();
  }
  
  public static Map<String, Object> buildServiceList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceTypeCode", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("param", a.toJSONString(localHashMap));
    return paramString;
  }
  
  public static Map<String, Object> buildServicePay(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong)
  {
    Map localMap = getCardCommon(paramContext);
    localMap.put("terminalType", "android");
    localMap.put("terminalVersion", ah.getVersion(paramContext));
    localMap.put("uid", paramString1);
    localMap.put("billId", paramString2);
    localMap.put("payWay", Integer.valueOf(paramInt1));
    localMap.put("payKind", Integer.valueOf(paramInt2));
    localMap.put("money", Long.valueOf(paramLong));
    return createPostEncode(a.toJSONString(localMap));
  }
  
  public static Map<String, Object> buildServicePeopleImage()
  {
    HashMap localHashMap = new HashMap();
    String str1 = String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5(("110000" + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", "110000");
    return localHashMap;
  }
  
  public static Map<String, Object> buildSetAddCleanScore(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("billId", paramString2);
    localHashMap.put("leaseContract", paramString3);
    localHashMap.put("valueAddedScore", Integer.valueOf(paramInt));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSetCleanEvaluation(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString1);
    localHashMap.put("score", Integer.valueOf(paramInt));
    localHashMap.put("feedback", paramString2);
    localHashMap.put("uid", paramString3);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSetCleanScore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, String paramString6, String paramString7, int paramInt2, List<Map<String, Object>> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("loginPhone", paramString3);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString2 + paramString1).getBytes()));
    localHashMap.put("billId", paramString2);
    localHashMap.put("score", Integer.valueOf(paramInt1));
    localHashMap.put("idea", paramString6);
    localHashMap.put("reason", paramString7);
    localHashMap.put("customerName", paramString4);
    localHashMap.put("roomNum", paramString5);
    localHashMap.put("source", Integer.valueOf(paramInt2));
    localHashMap.put("dealCode", "0");
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("scoreList", a.toJSON(paramList));
    paramString1 = new HashMap();
    paramString1.put("param", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSetRepairScore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, List<RepairScore> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString1);
    localHashMap.put("loginPhone", paramString3);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString3 + paramString1).getBytes()));
    localHashMap.put("fid", paramString2);
    localHashMap.put("customerName", paramString4);
    localHashMap.put("idea", paramString5);
    localHashMap.put("returnWay", Integer.valueOf(paramInt));
    localHashMap.put("roomNum", paramString6);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new ArrayList();
    paramString2 = paramList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (RepairScore)paramString2.next();
      paramString4 = new HashMap();
      paramString4.put("SCOREITEM", paramString3.getFID());
      paramString4.put("SCOREVALUE", paramString3.getVALUE());
      paramString1.add(paramString4);
    }
    localHashMap.put("scoreList", paramString1);
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSubmitRepair(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, List<RepairWork> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", paramString2);
    localHashMap.put("loginPhone", paramString1);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + paramString1 + paramString2).getBytes()));
    localHashMap.put("contactName", paramString3);
    localHashMap.put("contactTel", paramString4);
    localHashMap.put("rentContractCode", paramString5);
    localHashMap.put("address", paramString6);
    localHashMap.put("isConfirm", Integer.valueOf(paramInt1));
    localHashMap.put("dataSource", Integer.valueOf(paramInt2));
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString3 = paramList.iterator();
    while (paramString3.hasNext())
    {
      paramString1 = (RepairWork)paramString3.next();
      paramString1.setSupEmpId(paramString1.getLockSupEmpId());
      paramString1.setSupplierId(paramString1.getLockSupplierId());
      paramString4 = paramString1.getWxxmList().iterator();
      while (paramString4.hasNext())
      {
        paramString5 = (RepairWorkItem)paramString4.next();
        if ((ae.isNull(paramString5.getPic())) && (paramString5.getUrl() != null))
        {
          paramString2 = "";
          paramInt1 = 0;
          if (paramInt1 < paramString5.getUrl().length)
          {
            paramString1 = paramString2;
            if (ae.notNull(paramString5.getUrl()[paramInt1])) {
              if (!ae.isNull(paramString2)) {
                break label312;
              }
            }
            label312:
            for (paramString1 = paramString5.getUrl()[paramInt1];; paramString1 = paramString2 + "," + paramString5.getUrl()[paramInt1])
            {
              paramInt1 += 1;
              paramString2 = paramString1;
              break;
            }
          }
          paramString5.setPic(paramString2);
          paramString5.setImage(null);
          paramString5.setUrl(null);
        }
      }
    }
    localHashMap.put("workBillList", a.toJSON(paramList));
    paramString1 = new HashMap();
    paramString1.put("json", a.toJSONString(localHashMap));
    return paramString1;
  }
  
  public static Map<String, Object> buildSubmitTag(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    localHashMap.put("fcityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("fserviceinfoid", paramString1);
    localHashMap.put("docType", paramString2);
    localHashMap.put("fversion", paramString3);
    u.e("des", a.toJSONString(localHashMap));
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString3 = ApplicationEx.c.getVersionCode();
    localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString1);
    localHashMap.put("hPtJ39Xs", paramString2);
    localHashMap.put("v", paramString3);
    return localHashMap;
  }
  
  public static Map<String, Object> buildSuggestCommit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.alibaba.fastjson.b paramb)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("suggestType", paramString1);
    localHashMap.put("suggestContent", paramString2);
    localHashMap.put("linkPhone", paramString3);
    localHashMap.put("customerName", paramString4);
    localHashMap.put("uid", paramString5);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("source", "01");
    localHashMap.put("pictures", paramb);
    return localHashMap;
  }
  
  public static Map<String, Object> buildUid()
  {
    return getHouseSign(new HashMap());
  }
  
  public static Map<String, String> buildUser(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("myUid", paramString);
    String str1 = String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10);
    String str2 = SignKeyUtil.getHouseKey();
    str2 = ah.toMd5((paramString + str1 + str2).getBytes());
    localHashMap.put("timestamp", str1);
    localHashMap.put("uid", paramString);
    localHashMap.put("sign", str2);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("app", ah.getVersion(ApplicationEx.c));
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("os", "android:" + Build.VERSION.RELEASE);
    localHashMap.put("ip", ah.getIpAddress(ApplicationEx.c));
    localHashMap.put("network", ah.getNetWorkType(ApplicationEx.c));
    return localHashMap;
  }
  
  public static Map<String, String> buildUserInfoList(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    localHashMap.put("hide", paramInt + "");
    return g.getPassportSign(localHashMap);
  }
  
  public static Map<String, Object> buildUserTypeIsNew(Context paramContext, String paramString)
  {
    Map localMap = getCardCommon(paramContext);
    localMap.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    localMap.put("uid", paramString);
    localMap.put("clientCode", ah.getDeviceId(paramContext));
    return createPostEncode(a.toJSONString(localMap));
  }
  
  public static Map<String, Object> buildZuAddressList(Context paramContext, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
    ((Map)localObject).put("uid", paramString);
    ((Map)localObject).put("page", Integer.valueOf(1));
    ((Map)localObject).put("pageSize", Integer.valueOf(100));
    u.e("dsjfk", a.toJSONString(localObject));
    paramString = k.encrypt(a.toJSONString(localObject));
    localObject = ah.toMd5(a.toJSONString(localObject).getBytes());
    paramContext = ah.getAppVersion(paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", paramString);
    localHashMap.put("hPtJ39Xs", localObject);
    localHashMap.put("v", paramContext);
    return localHashMap;
  }
  
  public static Map<String, Object> buildactiviteCleanCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramContext = getCardCommon(paramContext);
    paramContext.put("cardNumber", paramString1);
    paramContext.put("password", paramString2);
    paramContext.put("uid", paramString3);
    paramContext.put("name", paramString4);
    paramContext.put("phone", paramString5);
    u.e("jskdjfk", a.toJSON(paramContext));
    return createPostEncode(a.toJSONString(paramContext));
  }
  
  public static String buildgetRentList(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("customerPhone", paramString);
      ((Map)localObject).put("listType", Integer.valueOf(paramInt1));
      ((Map)localObject).put("page", Integer.valueOf(paramInt2));
      ((Map)localObject).put("pageSize", Integer.valueOf(paramInt3));
      paramString = a.toJSONString(localObject, new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
      u.e("buildgetRentList jsonParams", paramString);
      localObject = aa.loadPublicKey(aa.a);
      paramString = URLEncoder.encode(com.ziroom.ziroomcustomer.util.g.encode(aa.encrypt(paramString.getBytes("UTF-8"), (PublicKey)localObject)), "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, Object> buildsaveGeneralEvaluate(String paramString1, float paramFloat, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("feedback", paramString1);
    localHashMap.put("score", Float.valueOf(paramFloat));
    localHashMap.put("uid", paramString2);
    localHashMap.put("orderId", paramString3);
    localHashMap.put("evaPosiLabel", paramString4);
    localHashMap.put("evaNegaLabel", paramString5);
    paramString1 = k.encrypt(a.toJSONString(localHashMap));
    paramString2 = ah.toMd5(a.toJSONString(localHashMap).getBytes());
    paramString3 = ApplicationEx.c.getVersionCode();
    paramString4 = new HashMap();
    paramString4.put("2y5QfvAy", paramString1);
    paramString4.put("hPtJ39Xs", paramString2);
    paramString4.put("v", paramString3);
    return paramString4;
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
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("dataSource", Integer.valueOf(12));
    localHashMap.put("versionNum", paramString6);
    u.e("sdfsd", a.toJSON(localHashMap));
    return createPostEncode(a.toJSONString(localHashMap));
  }
  
  public static Map<String, Object> createPostEncode(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", ah.toMd5(paramString.getBytes()));
    localHashMap.put("2y5QfvAy", k.encrypt(paramString));
    u.e("createPostEncode", "======= json" + paramString);
    u.e("createPostEncode", "======= json" + a.toJSONString(localHashMap));
    return localHashMap;
  }
  
  public static Map<String, String> createPostEncode(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", ah.toMd5(a.toJSONString(paramMap).getBytes()));
    localHashMap.put("2y5QfvAy", k.encrypt(a.toJSONString(paramMap)));
    return localHashMap;
  }
  
  public static Map<String, String> createPostEncodeString(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hPtJ39Xs", ah.toMd5(paramString.getBytes()));
    localHashMap.put("2y5QfvAy", k.encrypt(paramString));
    localHashMap.put("v", "5.6.0");
    d.d("dgdgg", "==== " + a.toJSON(paramString));
    d.d("dgdgg", "==== " + a.toJSON(localHashMap));
    return localHashMap;
  }
  
  public static Map<String, Object> getCardCommon(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(ah.getDeviceId(paramContext.getApplicationContext()))) {
      localHashMap.put("uuid", ah.getDeviceId(paramContext.getApplicationContext()));
    }
    for (;;)
    {
      localHashMap.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      localHashMap.put("appVersion", ah.getVersion(paramContext.getApplicationContext()));
      localHashMap.put("interfaceVesion", Integer.valueOf(1));
      localHashMap.put("dataSource", Integer.valueOf(12));
      localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      localHashMap.put("timestamp", String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10));
      return localHashMap;
      localHashMap.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
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
      localObject = String.valueOf(com.ziroom.ziroomcustomer.util.m.TimeS2L(com.ziroom.ziroomcustomer.util.m.GetNowDateTime(), com.ziroom.ziroomcustomer.util.m.c)).substring(0, 10);
      String str2 = SignKeyUtil.getHouseKey();
      str2 = ah.toMd5((str1 + (String)localObject + str2).getBytes());
      paramMap.put("timestamp", localObject);
      paramMap.put("uid", str1);
      paramMap.put("sign", str2);
      paramMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      paramMap.put("app", ah.getVersion(ApplicationEx.c));
      paramMap.put("model", Build.MODEL);
      paramMap.put("os", "android:" + Build.VERSION.RELEASE);
      paramMap.put("ip", ah.getIpAddress(ApplicationEx.c));
      paramMap.put("network", ah.getNetWorkType(ApplicationEx.c));
    }
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
    ((Map)localObject).put("app", ah.getVersion(ApplicationEx.c));
    ((Map)localObject).put("os_type", "Android");
    ((Map)localObject).put("os_version", Build.VERSION.RELEASE);
    ((Map)localObject).put("sign", toCommonPassportPHPMD5((Map)localObject));
    return (Map<String, String>)localObject;
  }
  
  public static boolean paramNotNull(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */