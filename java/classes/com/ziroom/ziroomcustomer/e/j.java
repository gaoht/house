package com.ziroom.ziroomcustomer.e;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.account.model.AccountDetails;
import com.ziroom.ziroomcustomer.account.model.Balance;
import com.ziroom.ziroomcustomer.account.model.BankList;
import com.ziroom.ziroomcustomer.account.model.BindedCard;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.BestGoodsListAc.a;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinAc.b;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinListActivity.a;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsAc.a;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo;
import com.ziroom.ziroomcustomer.model.AlternateAddCollect;
import com.ziroom.ziroomcustomer.model.AlternateAddCollect.AlternateCollection;
import com.ziroom.ziroomcustomer.model.AlternateDelCollect;
import com.ziroom.ziroomcustomer.model.AlternateDelCollect.Collection;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.BizcircleDetail;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.SubWayLineDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.f;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Callback;

public class j
{
  public static final ExecutorService a = Executors.newFixedThreadPool(5);
  
  public static void InternalRepairGetDesc(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.F;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void PayGoodsOrder(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.p;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void PayOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = q.m + e.l.i;; localObject = q.m + e.l.h)
    {
      g.combineParams(paramMap);
      localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
      ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
      new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
      return;
    }
  }
  
  private static com.alibaba.fastjson.e a(Map<String, Object> paramMap)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      locale.put((String)localEntry.getKey(), localEntry.getValue());
    }
    return locale;
  }
  
  public static void acCity(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.o.e;
    Map localMap1 = g.getCommonHouseSign(new HashMap());
    Map localMap2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localMap1)).enqueue(paramCallback);
  }
  
  public static void acEnrollAskForLeave(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.o.i;
    Object localObject = new HashMap();
    ((Map)localObject).put("activity_code", paramString);
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void acEnrollCancel(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.o.a;
    Object localObject = new HashMap();
    ((Map)localObject).put("activity_code", paramString);
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void acEnrollData(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.o.c;
    Object localObject = new HashMap();
    if (!TextUtils.isEmpty(paramString)) {
      ((Map)localObject).put("activity_code", paramString);
    }
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void acEnrollList(Context paramContext, int paramInt1, int paramInt2, int paramInt3, Callback paramCallback)
  {
    String str = q.o + e.o.b;
    Object localObject = new HashMap();
    ((Map)localObject).put("page", paramInt1 + "");
    ((Map)localObject).put("length", paramInt2 + "");
    ((Map)localObject).put("status", paramInt3 + "");
    localObject = g.getCommonHouseSign((Map)localObject);
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    localMap.put("version", "2");
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam((Map)localObject)).enqueue(paramCallback);
  }
  
  public static void acEnrollSubmit(Context paramContext, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, String paramString5, Callback paramCallback)
  {
    String str = q.o + e.o.d;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_code", paramString1);
    localHashMap.put("username", paramString2);
    localHashMap.put("phone", paramString3);
    localHashMap.put("weixin", paramString4);
    localHashMap.put("life_photo", paramString5);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = new com.alibaba.fastjson.b();
      paramString2 = paramList.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (String)paramString2.next();
        paramList = new com.alibaba.fastjson.e();
        paramList.put("answer", paramString3);
        paramString1.add(paramList);
      }
      localHashMap.put("answer", paramString1.toJSONString());
    }
    paramString1 = g.getCommonHouseSign(localHashMap);
    paramString2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString1)).enqueue(paramCallback);
  }
  
  public static void acMainPage(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.o.f;
    Object localObject = new HashMap();
    ((Map)localObject).put("activity_city_code", paramString);
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void activiteRepairCard(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.p;
    g.combineParams(paramMap);
    paramMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    paramMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void autoCodeForLogin(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new j.3(paramString1, paramString2, paramHandler));
  }
  
  public static void bankBindFailToast(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("questionType", "robot");
    k.requestGateWayService(paramContext, q.o + e.h.N, a(localHashMap), paramCallback, false);
  }
  
  public static void bindCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "17");
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("uid", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("idNumber", paramString2);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      localHashMap.put("phoneNum", paramString7);
    }
    localHashMap.put("userBankPhoneNum", paramString8);
    localHashMap.put("userBankNo", paramString6);
    localHashMap.put("outcontractCode", paramString4);
    localHashMap.put("bankCode", paramString5);
    localHashMap.put("userName", paramString3);
    localHashMap.put("uniqueNo", UUID.randomUUID().toString());
    localHashMap.put("smsCode", paramString9);
    localHashMap.put("type", paramString10);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenStringParams(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.S + e.n.Y).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void bindingGoodsCoupon(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.k;
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void boundCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "35");
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("uid", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("idNumber", paramString2);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      localHashMap.put("phoneNum", paramString7);
    }
    localHashMap.put("userBankPhoneNum", paramString8);
    localHashMap.put("userBankNo", paramString6);
    localHashMap.put("outcontractCode", paramString4);
    localHashMap.put("bankCode", paramString5);
    localHashMap.put("userName", paramString3);
    localHashMap.put("uniqueNo", UUID.randomUUID().toString());
    localHashMap.put("smsCode", paramString9);
    localHashMap.put("type", paramString10);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static String buildGetUrl(String paramString, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramString.contains("?")) {
      localStringBuilder.append("&");
    }
    while (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Map.Entry)paramString.next();
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        localStringBuilder.append(paramMap).append("=").append(localObject).append("&");
      }
      localStringBuilder.append("?");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public static void buyRepairCard(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.m;
    g.combineParams(paramMap);
    paramMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    paramMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void cancelFInvoiceApply(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ah, a(paramMap), paramCallback, false);
  }
  
  public static void cancelInternalRepairOrder(Context paramContext, String paramString, Callback paramCallback, List<String> paramList)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getLogin_name_mobile();
    String str = com.ziroom.ziroomcustomer.util.m.GetNowDate();
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", str);
    localHashMap.put("loginPhone", localObject);
    localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + (String)localObject + str).getBytes()));
    int j = paramList.size();
    if (j == 1) {
      localHashMap.put("wxxmId", paramList.get(0));
    }
    for (;;)
    {
      localHashMap.put("desc", paramString);
      paramString = new HashMap();
      paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
      g.InternalRepairBaseParams(paramString);
      paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
      com.freelxl.baselibrary.d.a.post(q.i + e.l.s).params(paramString).tag(paramContext).enqueue(paramCallback);
      return;
      localObject = "";
      int i = 0;
      if (i < j)
      {
        if (i != j - 1) {}
        for (localObject = (String)localObject + (String)paramList.get(i) + "|";; localObject = (String)localObject + (String)paramList.get(i))
        {
          i += 1;
          break;
        }
      }
      localHashMap.put("wxxmId", localObject);
    }
  }
  
  public static void cancelLoan(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/loan/cancel";
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void cancelMyAppointOrder(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.s.N);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void cancelOpenInvoice(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.aa, a(paramMap), paramCallback, false);
  }
  
  public static void changeBankCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("outcontractCode", paramString3);
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("idNumber", paramString1);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localHashMap.put("phoneNum", paramString6);
    }
    localHashMap.put("userBankPhoneNum", paramString7);
    localHashMap.put("userBankNo", paramString5);
    localHashMap.put("bankCode", paramString4);
    localHashMap.put("userName", paramString2);
    localHashMap.put("smsCode", paramString8);
    localHashMap.put("uniqueNo", UUID.randomUUID().toString());
    localHashMap.put("interfaceId", Integer.valueOf(19));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void changeIntellectPwdState(Context paramContext, HashMap<String, Object> paramHashMap, i.a<String> parama, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramHashMap);
    paramString = new com.freelxl.baselibrary.e.h(1, q.v + paramString);
    paramString.setParams(paramHashMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void changePassword(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    a.execute(new j.12(paramString1, paramString2, paramString3, paramHandler));
  }
  
  public static void checkContractHasPay(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.s + e.n.ae;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void checkExistReserveOrder(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("subletCode", paramString2);
    localHashMap.put("reserveType", paramString3);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.q).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void checkHasEvaluate(Handler paramHandler, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new j.13(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void checkReserveCanSign(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.C;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void checkSign(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString1);
    localHashMap.put("interfaceId", Integer.valueOf(33));
    localHashMap.put("encypt", paramString2);
    localHashMap.put("code", paramString3);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void checkSkin(Context paramContext, String paramString, Callback paramCallback)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("ppiType", paramString);
    ((Map)localObject).put("osType", "android");
    ((Map)localObject).put("appVersionStr", ah.getVersion(ApplicationEx.c));
    paramString = q.o + e.h.J;
    localObject = g.getCommonHouseSign((Map)localObject);
    paramContext = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    paramContext.put("Accept", "application/json; version=2");
    com.freelxl.baselibrary.d.a.post(paramString).headers(paramContext).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam((Map)localObject)).enqueue(paramCallback);
  }
  
  public static void checkSubletCode(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    paramString1 = ah.encodeGetParams(g.buildSublet(paramString1, paramString3, paramString2));
    com.freelxl.baselibrary.d.a.get(q.I + e.j.o + "?" + paramString1).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void confirmGoodsOrder(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.o;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void confirmInternalRepairPlan(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.z;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void confirmLoanContract(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.o + e.s.aE;
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramMap)).enqueue(paramCallback);
  }
  
  public static void confirmSubletReservation(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.m.f;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void contractPaymentDetail(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.s;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void contractZryuLeaseInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.r;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void createThreeUser(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("head_img", paramString2);
    localHashMap.put("nickname", paramString3);
    com.freelxl.baselibrary.d.a.post(q.O + e.i.d).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(parama);
  }
  
  public static void crmSignGetSecretInfo(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.z;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void crmSignVerify(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.A;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void delAlternate(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.a + e.b.R;
    HashMap localHashMap = new HashMap();
    localHashMap.put("delete", paramString);
    g.getOldHouseSignString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void delGestureLock(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    paramString1 = com.ziroom.commonlibrary.d.b.buildCommonHeaderWithToken(paramContext, paramString1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("password", ah.MD5Encode('c' + paramString2 + 'b'));
    com.freelxl.baselibrary.d.a.delete(q.V + "gestures/v1").tag(paramContext).headers(paramString1).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void delMyFinishedAppointBatch(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.s.M);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void deleteCard(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("outcontractCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(34));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void deleteContract(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.v.a;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("type", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void errorLog(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a.execute(new j.10(paramString1, paramString2, paramContext));
  }
  
  public static void getAcHistory(Context paramContext, String paramString, int paramInt1, int paramInt2, Callback paramCallback)
  {
    String str = q.o + e.o.h;
    Object localObject = new HashMap();
    ((Map)localObject).put("activity_city_code", paramString);
    ((Map)localObject).put("page", String.valueOf(paramInt1));
    ((Map)localObject).put("length", String.valueOf(paramInt2));
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void getAcList(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.o.g;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_city_code", paramString1);
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("length", paramInt2 + "");
    localHashMap.put("status", paramInt3 + "");
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("from", paramString2);
    }
    paramString1 = g.getCommonHouseSign(localHashMap);
    paramString2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString1)).enqueue(paramCallback);
  }
  
  public static void getAccountCards(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    String str = q.H + e.j.j;
    paramMap = ah.ConvertObjMap2String(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, str + "?" + ah.encodeGetParams(paramMap)), paramBoolean, BindedCard.class, parama).request();
  }
  
  public static void getAccountDetails(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    String str = q.H + e.j.i;
    paramMap = ah.ConvertObjMap2String(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, str + "?" + ah.encodeGetParams(paramMap)), paramBoolean, AccountDetails.class, parama).request();
  }
  
  public static void getAd(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.h.E;
    Object localObject = new HashMap();
    ((Map)localObject).put("type", paramString);
    ((Map)localObject).put("_p", "api_mobile");
    ((Map)localObject).put("_a", "getCarouselFigure");
    paramString = g.getOldHouseSignString((Map)localObject);
    u.d("tag", "=====params：" + paramString);
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    u.d("tag", "=====header：" + localObject);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void getAddBackRentOrder(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void getAdvertisement(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    Object localObject = q.a + e.h.D;
    if (2 == com.ziroom.commonlib.utils.h.getsEnvironment()) {
      localObject = q.X + e.h.D;
    }
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, paramBoolean, null, parama).request();
  }
  
  public static void getAlternateList(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.a + e.b.T;
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", paramString);
    g.getOldHouseSignString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getAppId(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.c.b);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getAppointInfo(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("house_id", paramString2);
    localHashMap.put("uid", paramString3);
    g.getCommonHouseSign(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.b + e.b.ag).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getAppointTips(Context paramContext, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.ak + e.b.ai).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getBalanceSums(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    String str = q.H + e.j.h;
    paramMap = ah.ConvertObjMap2String(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, str + "?" + ah.encodeGetParams(paramMap)), paramBoolean, Balance.class, parama).request();
  }
  
  public static void getBankList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, buildGetUrl(q.O + e.j.m, paramMap)), paramBoolean, BankList.class, parama).request();
  }
  
  public static void getBankList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "14");
    localHashMap.put("uid", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("rentContractCode", paramString2);
    }
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenStringParams(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.S + e.n.Y).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getBestGoodsAddressList(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.l.c;
    f.createYouPinEncode(paramMap, paramContext);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getBillCheckCanPay(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.j.c).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getBillInfo(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    String str = q.o + e.v.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("billType", paramString3);
    localHashMap.put("contractId", paramString1);
    localHashMap.put("period", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void getBillList(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("contractCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(26));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void getBindCards(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.H + e.j.k);
    localh.setParams(paramMap);
    Map localMap = localh.b;
    paramMap = localMap;
    if (localMap == null) {
      paramMap = new HashMap();
    }
    paramMap.put("Accept", "application/json;version=2");
    localh.setHeaders(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
  
  public static void getBizcircleList(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new j.4(paramContext, paramString1, paramString2, paramHandler));
  }
  
  public static void getBizcircleListDetail_new(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.a + e.b.r);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, BizcircleDetail.class, parama).request();
  }
  
  public static void getBookText(Context paramContext, String paramString1, String paramString2, int paramInt, Callback paramCallback)
  {
    Map localMap = g.getCRMCodeString(new HashMap());
    localMap.put("houseCode", paramString1);
    localMap.put("houseId", paramString2);
    localMap.put("houseType", paramInt + "");
    g.appendCommenParamsString(localMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.m.a).params(localMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getBoundCard(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "16");
    localHashMap.put("uid", paramString1);
    localHashMap.put("rentContractCode", paramString2);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenStringParams(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.S + e.n.Y).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getBoundCardState(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("outcontractCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(21));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void getCanBuyRepairCard(Context paramContext, i.a<String> parama)
  {
    Object localObject = q.m + e.l.l;
    Map localMap = g.combineParams(null);
    localMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    localMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(localMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(localMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getCertInfo(Context paramContext, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    localHashMap.put("is_newsign", paramInt + "");
    com.freelxl.baselibrary.d.a.get(q.O + e.i.b).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(parama);
  }
  
  public static void getCertList(Context paramContext, Callback paramCallback)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("osType", "android");
    ((Map)localObject).put("appVersionStr", ah.getVersion(ApplicationEx.c));
    String str = q.o + e.h.K;
    localObject = g.getCommonHouseSign((Map)localObject);
    paramContext = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    paramContext.put("Accept", "application/json; version=2");
    com.freelxl.baselibrary.d.a.post(str).headers(paramContext).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam((Map)localObject)).enqueue(paramCallback);
  }
  
  public static void getCityList(Context paramContext, Callback paramCallback)
  {
    Map localMap1 = g.getCommonHouseSign(new HashMap());
    String str = q.o + e.b.aj;
    Map localMap2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localMap1)).enqueue(paramCallback);
  }
  
  public static void getCollect(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.a + e.b.S;
    HashMap localHashMap = new HashMap();
    localHashMap.put("house_code", paramString);
    g.getOldHouseSignString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getCommonJson(Context paramContext, String paramString, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getCommonJsonGate(Context paramContext, String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    paramMap = g.getCommonHouseSign(paramMap);
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    localMap.put("Accept", "application/json; version=2");
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramMap)).enqueue(paramCallback);
  }
  
  public static void getCommonJsonGate(Context paramContext, String paramString, Callback paramCallback)
  {
    getCommonJsonGate(paramContext, paramString, new HashMap(), paramCallback);
  }
  
  public static void getCommuteConfig(Context paramContext, Callback paramCallback)
  {
    Map localMap1 = g.getCommonHouseSign(new HashMap());
    String str = q.o + e.b.ae;
    Map localMap2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localMap1)).enqueue(paramCallback);
  }
  
  public static void getCommuteSearch(Context paramContext, Object paramObject, String paramString1, String paramString2, double paramDouble1, double paramDouble2, String paramString3, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    paramObject = new HashMap();
    ((Map)paramObject).put("transport", paramString1);
    ((Map)paramObject).put("minute", paramString2);
    ((Map)paramObject).put("clng", paramDouble1 + "");
    ((Map)paramObject).put("clat", paramDouble2 + "");
    ((Map)paramObject).put("zoom", paramString3);
    paramObject = g.getCommonMapFilter((Map)paramObject, paramSearchCondition);
    paramString1 = q.o + e.b.af;
    paramString2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(paramString1).tag(paramContext).headers(paramString2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam((Map)paramObject)).enqueue(paramCallback);
  }
  
  public static void getCommuteSearch(Context paramContext, String paramString1, String paramString2, double paramDouble1, double paramDouble2, String paramString3, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    getCommuteSearch(paramContext, paramContext, paramString1, paramString2, paramDouble1, paramDouble2, paramString3, paramSearchCondition, paramCallback);
  }
  
  public static void getCompetencyApply(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ai, a(paramMap), paramCallback, false);
  }
  
  public static void getCompetencyRecord(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.al, a(paramMap), paramCallback, false);
  }
  
  public static void getContactHousekeeper(Context paramContext, i.a<String> parama, String paramString, boolean paramBoolean)
  {
    paramString = ah.encodeGetParams(g.buildGetServerPhone(paramString));
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, q.s + e.e.i + paramString), paramBoolean, null, parama).request();
  }
  
  public static void getContract(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new j.18(paramString, paramContext, paramHandler));
  }
  
  public static void getCouponList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap1, Map<String, Object> paramMap2, boolean paramBoolean, String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      if ("service_move_cleaning".equals(paramString)) {
        paramString = q.z + e.s.D;
      }
      while (paramString != null)
      {
        u.d("newDataService", "====:" + paramString);
        u.d("newDataService", "====param:" + paramMap2);
        paramString = new com.freelxl.baselibrary.e.h(1, paramString);
        if (paramMap1 != null) {
          paramString.setHeaders(paramMap1);
        }
        if (paramMap2 != null) {
          paramString.setParams(paramMap2);
        }
        new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
        return;
        if ("service_repair".equals(paramString)) {
          paramString = q.A + e.s.E;
        } else if ("yi".equals(paramString)) {
          paramString = q.B + e.s.F;
        } else if ("ms".equals(paramString)) {
          paramString = q.C + e.s.G;
        } else {
          paramString = null;
        }
      }
    }
  }
  
  public static void getCouponList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.e;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getCouponListYp(Context paramContext, String paramString, Callback paramCallback)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("status", paramString);
    ((Map)localObject).put("osType", "2");
    paramString = g.getPassportSign((Map)localObject);
    localObject = q.o + e.s.J;
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    localMap.put("Accept", "application/json; version=1");
    com.freelxl.baselibrary.d.a.post((String)localObject).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void getDeliverRegion(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    paramMap = q.n + e.t.q;
    Map localMap = g.boundParams(null);
    com.freelxl.baselibrary.d.a.post(paramMap).params(localMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, localMap, paramMap);
  }
  
  public static void getEstimateLastInfo(Context paramContext, com.freelxl.baselibrary.d.c.a<String> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + e.s.aC, a(paramMap), parama, false);
  }
  
  public static void getEstimatedBackRentFee(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void getEvaluateHistoryDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.s.R).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getEvaluateIsExpired(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.s.T).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getEvaluateResultsConditions(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    locale.put("orderCode", paramString1);
    locale.put("evaluateType", paramString2);
    locale.put("dataSource", "2");
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    paramString1.put("Accept", "application/json; version=1");
    com.freelxl.baselibrary.d.a.post(q.o + e.s.Z).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(locale)).enqueue(paramCallback);
  }
  
  public static void getFInvoiceApplyNature(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.an, a(paramMap), paramCallback, false);
  }
  
  public static void getFInvoiceBeforeOpen(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.am, a(paramMap), paramCallback, false);
  }
  
  public static void getFInvoiceComputePrice(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ap, a(paramMap), paramCallback, false);
  }
  
  public static void getFInvoiceDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.aj, a(paramMap), paramCallback, false);
  }
  
  public static void getFInvoiceList(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ak, a(paramMap), paramCallback, false);
  }
  
  public static void getFInvoiceOpen(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ao, a(paramMap), paramCallback, false);
  }
  
  public static void getFinishedMyAppointList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.s.L);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getGestureLock(Context paramContext, String paramString, Callback paramCallback)
  {
    paramString = com.ziroom.commonlibrary.d.b.buildCommonHeaderWithToken(paramContext, paramString);
    com.freelxl.baselibrary.d.a.get(q.V + "gestures/v1").tag(paramContext).headers(paramString).enqueue(paramCallback);
  }
  
  public static void getGoodsCoupon(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.j;
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getGoodsCouponList(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.l;
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getGoodsDetailData(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.f;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getGoodsEvalList(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.n;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getGoodsPropertyV2(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.h;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getGuanJiaInfo(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.h.C);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getHomeBigLog(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.a + e.c.d);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, HomePageBannerInfo.class, parama).request();
  }
  
  public static void getHomeRentChild(Context paramContext, int paramInt, String paramString, Callback paramCallback)
  {
    u.d("NewDataService", "=====getHomeRentChild:" + paramInt);
    paramString = ah.encodeGetParams(g.buildRent(paramInt, paramString));
    paramString = q.b + e.c.e + "?" + paramString;
    u.e("httpUrl", paramString);
    com.freelxl.baselibrary.d.a.get(paramString).tag(paramContext).addHeader("Accept", "application/json;version=4").enqueue(paramCallback);
  }
  
  public static void getHotSearch(Context paramContext, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.a + e.b.e + "&" + ah.encodeGetParams(g.getOldHouseSignString(new HashMap()))).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getHouseType(Handler paramHandler, String paramString)
  {
    a.execute(new j.7(paramString, paramHandler));
  }
  
  public static void getImgUrl(Handler paramHandler, String paramString)
  {
    a.execute(new j.14(paramString, paramHandler));
  }
  
  public static void getIndex(Handler paramHandler)
  {
    a.execute(new j.5(paramHandler));
  }
  
  public static void getInternalOrderDetail(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    paramMap = q.i + e.l.w;
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(paramMap).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getInternalOrderList(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.m + p.f.c;
    g.InternalRepairBaseParams(paramMap);
    paramMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramMap));
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getInternalRepairEvalList(Context paramContext, Callback paramCallback)
  {
    String str = q.i + e.l.u;
    Map localMap = g.InternalRepairBaseParams(null);
    localMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localMap));
    com.freelxl.baselibrary.d.a.post(str).params(localMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getInternalRepairPlanDetail(Context paramContext, String paramString, Callback paramCallback)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localObject));
    localObject = q.i + e.l.y;
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post((String)localObject).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getInternalRepairTime(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("zhutiCode", paramString1);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("goodsId", paramString2);
    localHashMap.put("tagId", paramString3);
    paramString1 = new HashMap();
    paramString1.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString1);
    paramString1.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString1));
    com.freelxl.baselibrary.d.a.post(q.i + e.l.C).params(paramString1).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getInvoiceBeforeOpen(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ac, a(paramMap), paramCallback, false);
  }
  
  public static void getInvoiceDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.af, a(paramMap), paramCallback, false);
  }
  
  public static void getInvoiceList(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ae, a(paramMap), paramCallback, false);
  }
  
  public static void getLeaseWebText(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    a.execute(new j.16(paramMap, paramContext, parama));
  }
  
  public static void getLifeDetails(Handler paramHandler, String paramString, Context paramContext)
  {
    a.execute(new j.15(paramString, paramContext, paramHandler));
  }
  
  public static void getLoanData(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/loan/loanTrial";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("rentContractCode", paramString2);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getLoanInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("rentContractCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(25));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void getLoanstatus(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/loan/searchLoanStatus";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("rentContractCode", paramString2);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getLockPwdInfo(Context paramContext, HashMap<String, Object> paramHashMap, i.a<String> parama, boolean paramBoolean)
  {
    g.appendCommenParams(paramHashMap);
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.v + "passwordCus/getPasswordInfo");
    localh.setParams(paramHashMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getLockRoomInfo(Context paramContext, HashMap<String, Object> paramHashMap, i.a<String> parama, boolean paramBoolean)
  {
    g.appendCommenParams(paramHashMap);
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.v + "passwordCus/getContractHasPassword");
    localh.setParams(paramHashMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getMapHouseList(Context paramContext, int paramInt1, int paramInt2, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    new HashMap();
    com.freelxl.baselibrary.d.a.get(q.b + e.b.U + "?" + ah.encodeGetParams(g.buildHouseMapList(paramSearchCondition, paramInt1, paramInt2))).tag(paramContext).addHeader("Accept", "application/json;version=6").enqueue(paramCallback);
  }
  
  public static void getMapHouseList(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    new HashMap();
    com.freelxl.baselibrary.d.a.get(q.b + e.b.U + "?" + ah.encodeGetParams(g.getRentConditionParams(paramMap))).tag(paramContext).addHeader("Accept", "application/json;version=6").enqueue(paramCallback);
  }
  
  public static void getMeeTaApartDtl(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.g.a, a(paramMap), paramCallback, false);
  }
  
  public static void getMyAppointingList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.s.K);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getMyEvaluatePros(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.s.S).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getMyUserType(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    k.requestGateWayService(paramContext, q.o + e.h.I, a(localHashMap), paramCallback, false);
  }
  
  public static void getNetPicConfig(Context paramContext, Callback paramCallback)
  {
    String str = q.o + "contentful/ziruke-app/v1/cdn/index.json";
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("app_version", "5.6.0");
    locale.put("os", "android");
    locale.put("imei", ah.getDeviceId(paramContext));
    locale.put("timestamp", System.currentTimeMillis() + "");
    locale.put("sign", g.toCommonPHPMD5(locale));
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(locale)).enqueue(paramCallback);
  }
  
  public static void getNewCoupon(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.f;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getNewSignEvaluateConditions(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    locale.put("orderCode", paramString1);
    locale.put("dataSource", "2");
    locale.put("sceneCode", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    paramString1.put("Accept", "application/json; version=1");
    com.freelxl.baselibrary.d.a.post(q.o + e.s.W).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(locale)).enqueue(paramCallback);
  }
  
  public static void getOCConfirmContract(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ax, a(paramMap), paramCallback, false);
  }
  
  public static void getOCConfirmContractContinue(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ay, a(paramMap), paramCallback, false);
  }
  
  public static void getOCConfirmDeliever(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.az, a(paramMap), paramCallback, false);
  }
  
  public static void getOCContractDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ar, a(paramMap), paramCallback, false);
  }
  
  public static void getOCContractList(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.c + e.s.as, a(paramMap), paramCallback, false);
  }
  
  public static void getOCContractNeedConfirm(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.at, a(paramMap), paramCallback, false);
  }
  
  public static void getOCDelieverDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.aB, a(paramMap), paramCallback, false);
  }
  
  public static void getOCDelieverNeedConfirm(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.aA, a(paramMap), paramCallback, false);
  }
  
  public static void getOCLoanContractNeedConfirm(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.au, a(paramMap), paramCallback, false);
  }
  
  public static void getOrderLeaseText(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void getOwnerBaseInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    paramString = ah.encodeGetParams(g.getOwnerBaseInfo(paramString));
    com.freelxl.baselibrary.d.a.get(q.c + e.s.P + "?" + paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getOwnerContract(Context paramContext, String paramString, Callback paramCallback)
  {
    paramString = ah.encodeGetParams(g.getOwnerContract(paramString));
    com.freelxl.baselibrary.d.a.get(q.c + e.s.O + "?" + paramString).addHeader("Accept", "application/json;version=2").tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getOwnerEntrustSchedule(Context paramContext, String paramString, Callback paramCallback)
  {
    paramString = ah.encodeGetParams(g.getOwnerEntrustSchedule(paramString));
    com.freelxl.baselibrary.d.a.get(q.c + e.s.Q + "?" + paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getOwnerVerifyCode(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.o + e.s.aD;
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramMap)).enqueue(paramCallback);
  }
  
  public static void getPayType(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("house_id", paramString2);
    paramString1 = ah.encodeGetParams(g.getCommonHouseSign(localHashMap));
    com.freelxl.baselibrary.d.a.get(q.h + e.b.P + "?" + paramString1).addHeader("Accept", "application/json;version=2").tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getPreBoundCard(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "13");
    localHashMap.put("uid", paramString);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenStringParams(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.S + e.n.Y).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getPriceList(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ad, a(paramMap), paramCallback, false);
  }
  
  public static void getProjectMap(Context paramContext, Callback paramCallback)
  {
    Map localMap1 = g.getCommonHouseSign(new HashMap());
    String str = q.o + e.g.d;
    Map localMap2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localMap1)).enqueue(paramCallback);
  }
  
  public static void getRaConfig(Context paramContext, Handler paramHandler)
  {
    a.execute(new j.8(paramHandler));
  }
  
  public static void getRecommedList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("house_id", paramString2);
    localHashMap.put("page", "1");
    localHashMap.put("size", "4");
    paramString1 = ah.encodeGetParams(g.getCommonHouseSign(localHashMap));
    com.freelxl.baselibrary.d.a.get(q.h + e.b.N + "?" + paramString1).addHeader("Accept", "application/json;version=5").tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getReimbursement(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("pirord", paramString3);
    localHashMap.put("totalMoney", paramString2);
    localHashMap.put("interfaceId", Integer.valueOf(27));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getReimbursementStatus(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("serialNo", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(28));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void getRentCardList(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("coupon_base_id", paramString2);
    localHashMap.put("expired", paramString3);
    localHashMap.put("coupon_status", "0");
    localHashMap.put("pageNum", "1000");
    paramString1 = g.getPassportSign(localHashMap);
    paramString2 = q.o + e.s.I;
    paramString3 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    paramString3.put("Accept", "application/json; version=1");
    com.freelxl.baselibrary.d.a.post(paramString2).tag(paramContext).headers(paramString3).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString1)).enqueue(paramCallback);
  }
  
  public static void getRentEvaluateList(Context paramContext, Callback paramCallback)
  {
    Map localMap1 = g.getCommonHouseSign(new HashMap());
    String str = q.o + e.s.Y;
    Map localMap2 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localMap1)).enqueue(paramCallback);
  }
  
  public static void getRentHouseDetail(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("house_id", paramString2);
    paramString1 = ah.encodeGetParams(g.getCommonHouseSign(localHashMap));
    com.freelxl.baselibrary.d.a.get(q.h + e.b + "?" + paramString1).addHeader("Accept", "application/json;version=3").tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRentHouseKeeper(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("userPhone", paramString2);
    localHashMap.put("userName", paramString3);
    localHashMap.put("isLogin", paramString4);
    localHashMap.put("villageId", paramString5);
    localHashMap.put("houseId", paramString6);
    localHashMap.put("roomId", paramString7);
    localHashMap.put("houseType", paramInt + "");
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.h.C).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRentZOEvaluateStatus(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.s.U).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRepairArticle(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString1);
    localHashMap.put("ztCode", paramString2);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString1 = new HashMap();
    paramString1.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString1);
    paramString1.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString1));
    com.freelxl.baselibrary.d.a.post(q.i + p.f.w).params(paramString1).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRepairCardDetailInfo(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.k;
    g.combineParams(paramMap);
    paramMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    paramMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getRepairCardLeft(Context paramContext, i.a<String> parama)
  {
    Object localObject = q.m + e.l.q;
    Map localMap = g.combineParams(null);
    localMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    localMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(localMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(localMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getRepairCardList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.j;
    paramMap = g.combineParams(paramMap);
    paramMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    paramMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getRepairPlace(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("czhth", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post(q.i + p.f.u).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRepairRemark(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("itemCode", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post(q.i + e.l.x).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRepairTime(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("zhutiCode", paramString);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post(q.i + e.l.C).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getRepairType(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post(q.i + p.f.v).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getReservationOrderText(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void getRoomCountBizcircle(Context paramContext, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    getRoomCountBizcircle(paramContext, paramContext, paramSearchCondition, paramCallback);
  }
  
  public static void getRoomCountBizcircle(Context paramContext, Object paramObject, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.b + e.b.aa + "?" + ah.encodeGetParams(g.getCommonMapFilter(paramSearchCondition))).tag(paramObject).addHeader("Accept", "application/json;version=4").enqueue(paramCallback);
  }
  
  public static void getRoomCountBuilding(Context paramContext, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    getRoomCountBuilding(paramContext, paramContext, paramSearchCondition, paramCallback);
  }
  
  public static void getRoomCountBuilding(Context paramContext, Object paramObject, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.b + e.b.ab + "?" + ah.encodeGetParams(g.getCommonMapFilter(paramSearchCondition))).tag(paramObject).addHeader("Accept", "application/json;version=4").enqueue(paramCallback);
  }
  
  public static void getRoomCountDistrict(Context paramContext, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    getRoomCountDistrict(paramContext, paramContext, paramSearchCondition, paramCallback);
  }
  
  public static void getRoomCountDistrict(Context paramContext, Object paramObject, SearchCondition paramSearchCondition, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.b + e.b.Z + "?" + ah.encodeGetParams(g.getCommonMapFilter(paramSearchCondition))).tag(paramObject).addHeader("Accept", "application/json;version=4").enqueue(paramCallback);
  }
  
  public static void getRoomFilter(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get(q.b + e.b.Y + "?" + ah.encodeGetParams(g.getHouseListFilter(localHashMap, ""))).tag(paramContext).addHeader("Accept", "application/json;version=6").enqueue(paramCallback);
  }
  
  public static void getSKUInfo(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.i;
    f.createYouPinEncode(paramMap, paramActivity);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getSearchData(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("interfaceId", Integer.valueOf(32));
    localHashMap.put("rentContractCode", paramString2);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getServiceAddressList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.c;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getServiceData(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.a;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getServiceTimeList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.b;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("rentContractCode", paramString2);
    localHashMap.put("userBankNo", paramString1);
    localHashMap.put("phone", paramString3);
    localHashMap.put("bankName", paramString4);
    localHashMap.put("interfaceId", Integer.valueOf(29));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getSignInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract", paramString);
    g.getCommonHouseSign(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.b + e.b.ah).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getSubWayLineDetail_new(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.a + e.b.q);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, SubWayLineDetail.class, parama).request();
  }
  
  public static void getSubletInitiatorDetail(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("contract_code", paramString2);
    g.getCommonHouseSign(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.Q + e.q.p + "?" + ah.encodeGetParams(localHashMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getSubletReservationDetail(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.u;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void getSubletReservationInfo(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.m.d;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void getSuggestion(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("num", paramInt + "");
    localHashMap.put("query", paramString);
    com.freelxl.baselibrary.d.a.get(q.b + e.b.ac + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).addHeader("Accept", "application/json;version=2").tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getSundHandleList(Handler paramHandler, String paramString)
  {
    a.execute(new j.6(paramString, paramHandler));
  }
  
  public static void getSysTime(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.s + e.c.c);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getTempPwd(Context paramContext, HashMap<String, Object> paramHashMap, i.a<String> parama)
  {
    g.appendCommenParams(paramHashMap);
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.v + "passwordCus/getDynamicPassword");
    localh.setParams(paramHashMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, false, null, parama).request();
  }
  
  public static void getTerminationEvaluate(Context paramContext, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.aj).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getToBackRent(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void getUnbindCards(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new com.freelxl.baselibrary.e.h(0, buildGetUrl(q.H + e.j.l, paramMap)), paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
  
  public static void getUnlockList(Context paramContext, HashMap<String, Object> paramHashMap, i.a<String> parama, boolean paramBoolean)
  {
    g.appendCommenParams(paramHashMap);
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(1, q.v + "passwordCus/getPasswords");
    localh.setParams(paramHashMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getUserInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a<UserInfo> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    com.freelxl.baselibrary.d.a.get(q.O + e.i.a).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(parama);
  }
  
  public static void getValidateSms(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("outcontractCode", paramString2);
    localHashMap.put("userBankNo", paramString1);
    localHashMap.put("userBankPhoneNum", paramString3);
    localHashMap.put("bankCode", paramString4);
    localHashMap.put("userName", paramString5);
    localHashMap.put("interfaceId", Integer.valueOf(17));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void getYPBestGoodsList(Context paramContext, Map<String, String> paramMap, BestGoodsListAc.a parama)
  {
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(q.n + e.t.b).params(paramMap).tag(paramContext).enqueue(parama);
  }
  
  public static void getYPCouponList(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + e.t.m;
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void getYPHomePage(Context paramContext, Map<String, String> paramMap, YouPinAc.b paramb)
  {
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(q.n + e.t.a).params(paramMap).tag(paramContext).enqueue(paramb);
  }
  
  public static void getYPOrderDetailsAc(Context paramContext, Map<String, String> paramMap, YouPinOrderDetailsAc.a parama)
  {
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(q.n + e.t.d).params(paramMap).tag(paramContext).enqueue(parama);
  }
  
  public static void getYPOrderList(Context paramContext, Map<String, String> paramMap, YouPinListActivity.a parama)
  {
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(q.n + e.t.c).params(paramMap).tag(paramContext).enqueue(parama);
  }
  
  public static void getYouPinCoupon(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.n + e.l.f;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getYouPinServiceAddressList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.n + e.l.c;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void getZZBizcirle(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(0, q.b + e.b.W + "?" + ah.appendGetUrl(paramMap));
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getZZSubway(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    com.freelxl.baselibrary.e.h localh = new com.freelxl.baselibrary.e.h(0, q.b + e.b.X + "?" + ah.appendGetUrl(paramMap));
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getZwhiteLoanPayInfo(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Callback paramCallback)
  {
    String str = q.s + e.n.ab;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("contractCode", paramString2);
    if (!TextUtils.isEmpty(paramString3))
    {
      localHashMap.put("couponCode", paramString3);
      localHashMap.put("couponValue", paramInt + "");
    }
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getZwhiteLoanPayInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/loan/loanDetail";
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void giveUpInternalRepairPlan(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.B;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void hasSubletReservation(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.v;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void headImgUpload(Context paramContext, String paramString, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("token", paramString);
      paramString = g.getPassportSign((Map)localObject);
      paramContext = com.freelxl.baselibrary.d.a.post(q.O + e.i.e).tag(paramContext).addHeader("Accept", "application/json; version=1");
      localObject = paramString.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramContext.addFormDataPart(str, (String)paramString.get(str));
      }
      paramContext.addFormDataPart("file", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void headInvoiceImgUpload(Context paramContext, String paramString, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("token", paramString);
      paramString = g.getMBSSign((Map)localObject);
      paramContext = com.freelxl.baselibrary.d.a.post(q.M + e.s.aq).tag(paramContext).addHeader("Accept", "application/json; version=1");
      localObject = paramString.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramContext.addFormDataPart(str, (String)paramString.get(str));
      }
      paramContext.addFormDataPart("file", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void headSignerImgUpload(Context paramContext, String paramString, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("token", paramString);
      paramString = g.getPassportSign((Map)localObject);
      paramContext = com.freelxl.baselibrary.d.a.post(q.O + e.d.c).tag(paramContext).addHeader("Accept", "application/json; version=1");
      localObject = paramString.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramContext.addFormDataPart(str, (String)paramString.get(str));
      }
      paramContext.addFormDataPart("file", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void hyUploadImg(Context paramContext, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      paramContext = com.freelxl.baselibrary.d.a.post(q.an + "hy/activity/up-img").tag(paramContext).addFormDataPart("source", "2");
      paramContext.addFormDataPart("img", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void hyUploadStuIdCard(Context paramContext, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      paramContext = com.freelxl.baselibrary.d.a.post(q.an + "hy/activity/up-stu-id").tag(paramContext).addFormDataPart("source", "2");
      paramContext.addFormDataPart("img", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void iTrusRaConfig(Context paramContext, Callback paramCallback)
  {
    String str2 = q.s + e.a.q;
    HashMap localHashMap = new HashMap();
    String str1 = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str1 = localUserInfo.getUid();
    }
    localHashMap.put("uid", str1);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(str2).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void identifyAutoCode(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new j.2(paramString, paramHandler));
  }
  
  public static void loanConfirm(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "loan/LoanConfirm";
    HashMap localHashMap = new HashMap();
    localHashMap.put("rentContractCode", paramString);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void makeInternalRepairOrder(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.r;
    g.InternalRepairBaseParams(paramMap);
    paramMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramMap));
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void makeOrder(Context paramContext, Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    a.execute(new j.19(paramInt1, paramInt2, paramInt3, paramString1, paramList, paramString2, paramString3, paramHandler));
  }
  
  public static void modifYouPinAddressList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.n + e.l.d;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void modifyNickName(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("nick_name", paramString2);
    com.freelxl.baselibrary.d.a.post(q.O + e.i.c).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(parama);
  }
  
  public static void modifyServiceAddressList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.d;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void openInvoice(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    k.requestGateWayService(paramContext, q.o + e.s.ab, a(paramMap), paramCallback, false);
  }
  
  public static void ownerLoanSignatureQuery(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.s.av;
    HashMap localHashMap = new HashMap();
    localHashMap.put("loanOrderNo", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void ownerLoanSignatureVerify(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/invoke";
    HashMap localHashMap = new HashMap();
    localHashMap.put("loanOrderNo", paramString1);
    localHashMap.put("signMessage", paramString2);
    localHashMap.put("interfaceId", Integer.valueOf(39));
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void passInternalPlan(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.A;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void payByRepairCard(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.n;
    g.combineParams(paramMap);
    paramMap.put("serviceType", "2c9094833db58ad9013db58ddc290001");
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void payForInternalOrder(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.E;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void payRepairCard(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.o;
    g.combineParams(paramMap);
    String str = ah.getDeviceId(ApplicationEx.c);
    if (!TextUtils.isEmpty(str)) {
      paramMap.put("uuid", str);
    }
    for (;;)
    {
      paramMap.put("equipmentVesion", "android:" + Build.VERSION.RELEASE);
      paramMap.put("appVersion", ah.getVersion(ApplicationEx.c));
      paramMap.put("interfaceVesion", Integer.valueOf(1));
      paramMap.put("terminalType", "android");
      paramMap.put("terminalVersion", ah.getVersion(paramContext));
      paramMap = m.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramMap));
      localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
      ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
      new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
      return;
      paramMap.put("uuid", "sdjkfjdskgjklfjgkfjdkjklkl");
    }
  }
  
  public static void penaltyPay(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.execute(new j.20(paramString1, paramString2, paramString3, paramString4, paramString5, paramHandler));
  }
  
  public static void postDeviceInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    String str3 = q.ao + "SEM/activateuser/getidfa.do";
    HashMap localHashMap = new HashMap();
    String str2 = ah.getDeviceId(paramContext);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknown deviceId_" + System.currentTimeMillis();
    }
    localHashMap.put("idfa", str1);
    localHashMap.put("app_version", "5.6.0");
    localHashMap.put("os_version", Build.VERSION.RELEASE);
    localHashMap.put("phone_type", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("phone_network", ah.getNetWorkType(paramContext));
    localHashMap.put("active_city", paramString);
    localHashMap.put("device_system", "android");
    com.freelxl.baselibrary.d.a.post(str3).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void preBindCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", "15");
    localHashMap.put("uid", paramString1);
    localHashMap.put("bankName", paramString2);
    localHashMap.put("cardCode", paramString4);
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("phone", paramString5);
    }
    localHashMap.put("userBankPhoneNum", paramString6);
    localHashMap.put("zrBankCode", paramString3);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenStringParams(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.S + e.n.Y).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void promptInternalRepairOrder(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.i + e.l.t;
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    g.InternalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(paramString));
    com.freelxl.baselibrary.d.a.post(str).params(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void putCaseRecord(Context paramContext, String paramString, Callback paramCallback)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("renContractCode", paramString);
    paramString = g.getCommonHouseSign((Map)localObject);
    localObject = q.o + e.e.r;
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post((String)localObject).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramString)).enqueue(paramCallback);
  }
  
  public static void putCertInfo(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, String paramString11, int paramInt4, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString7.replace("\n", " ").replace("  ", " ");
    paramString7 = paramString3;
    if (paramString3.charAt(paramString3.length() - 1) == 'x') {
      paramString7 = paramString3.replace('x', 'X');
    }
    if (paramString11 != null) {
      localHashMap.put("house_type", paramString11);
    }
    localHashMap.put("token", paramString1);
    localHashMap.put("cert_id", paramString2 + "");
    localHashMap.put("cert_type", paramInt1 + "");
    localHashMap.put("cert_num", paramString7 + "");
    localHashMap.put("user_cert1", paramString4 + "");
    localHashMap.put("user_cert2", paramString5 + "");
    localHashMap.put("user_cert3", paramString6 + "");
    localHashMap.put("real_name", str + "");
    localHashMap.put("gender", paramString8 + "");
    localHashMap.put("phone", paramString9 + "");
    localHashMap.put("is_newsign", paramString10);
    localHashMap.put("user_type", paramInt2 + "");
    localHashMap.put("company_type", paramInt3 + "");
    localHashMap.put("sign_user_type", paramInt4 + "");
    paramString1 = g.getPassportSign(localHashMap);
    com.freelxl.baselibrary.f.d.e("url", q.O + e.n.q + paramString1);
    com.freelxl.baselibrary.d.a.post(q.O + e.n.q).tag(paramContext).addHeader("Accept", "application/json; version=3").params(paramString1).enqueue(parama);
  }
  
  public static void putLoanEasyPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    String str = q.s + e.n.ag;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.ziroomcustomer.pay.common.b.d.getUid());
    localHashMap.put("period", paramString2);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("loanType", paramString3);
    localHashMap.put("loanCode", paramString4);
    localHashMap.put("productCode", paramString5);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.f.d.e("okhttp", str + localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void queryWeChatLoginStatus(Context paramContext, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.o + e.s.aF;
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(paramMap)).enqueue(paramCallback);
  }
  
  public static void refreshSubletBookCode(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("turn_id", paramString2);
    g.getCommonHouseSign(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.Q + e.q.r + "?" + ah.encodeGetParams(localHashMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void register(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new j.1(paramString1, paramString2, paramHandler));
  }
  
  public static void resetPassword(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new j.17(paramString1, paramString2, paramHandler));
  }
  
  public static void saveAlternateListing(List<AlternateListing> paramList)
  {
    a.execute(new j.11(paramList));
  }
  
  public static void saveGoodsEval(Activity paramActivity, Map<String, String> paramMap, Callback paramCallback)
  {
    String str = q.n + p.f.h;
    g.boundParams(paramMap);
    com.freelxl.baselibrary.d.a.post(str).params(paramMap).tag(paramActivity).enqueue(paramCallback);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.ziroom.ziroomcustomer.bestgoods.c.c.printLog(paramActivity, paramMap, str);
  }
  
  public static void saveInternalRepairEval(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.i + e.l.v;
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramMap));
    g.InternalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.ziroomcustomer.newrepair.utils.c.signParams(localHashMap));
    com.freelxl.baselibrary.d.a.post(str).params(localHashMap).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void setGestureLock(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    paramString1 = com.ziroom.commonlibrary.d.b.buildCommonHeaderWithToken(paramContext, paramString1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("password", paramString2);
    com.freelxl.baselibrary.d.a.post(q.V + "gestures/v1").tag(paramContext).headers(paramString1).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void setGetSchooling(Context paramContext, Map<String, String> paramMap, boolean paramBoolean, String paramString, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(paramMap)).enqueue(paramCallback);
  }
  
  public static void setOrderLease(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void setReservationOrderText(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean, String paramString)
  {
    g.appendCommenParams(paramMap);
    paramString = new com.freelxl.baselibrary.e.h(1, paramString);
    paramString.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, paramString, paramBoolean, null, parama).request();
  }
  
  public static void setSetSchooling(Context paramContext, Map<String, String> paramMap, boolean paramBoolean, String paramString, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(paramMap)).enqueue(paramCallback);
  }
  
  public static void setSubletOrderLease(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.m.c;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void signature(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new j.9(paramString4, paramString1, paramString2, paramString3, paramString5, paramString6, paramHandler));
  }
  
  public static void subletInitiatorCancelReserve(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("reserveCode", paramString2);
    localHashMap.put("reserveStatus", paramString3);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.m).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void subletInitiatorCancelTenant(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("reserveCode", paramString2);
    localHashMap.put("reserveStatus", paramString3);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.s).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void subletInitiatorConfirmReserveOrder(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("reserveCode", paramString2);
    localHashMap.put("securityCode", paramString3);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.l).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void subletInitiatorConfirmTenantCancel(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("reserveCode", paramString2);
    localHashMap.put("reserveStatus", paramString3);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.o).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void subletInitiatorInvalidCancelReserve(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("reserveCode", paramString2);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.s + e.q.n).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void submitContract(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.v.c;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("contractTotalMoney", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void submitContractLoanInfo(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = com.ziroom.ziroomcustomer.payment.c.a.a + "api/loan/loanApply";
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("rentContractCode", paramString2);
    com.ziroom.ziroomcustomer.pay.common.b.c.appendCommenParams(localHashMap);
    paramString1 = ah.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void submitHouseCondition1(Handler paramHandler, SearchCondition paramSearchCondition, int paramInt1, int paramInt2, String paramString)
  {
    a.execute(new j.23(paramSearchCondition, paramInt1, paramInt2, paramString, paramHandler));
  }
  
  public static void submitNewSignEvaluateInfo(Context paramContext, com.alibaba.fastjson.e parame, Callback paramCallback)
  {
    com.alibaba.fastjson.e locale = parame;
    if (parame == null) {
      locale = new com.alibaba.fastjson.e();
    }
    parame = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    parame.put("Accept", "application/json; version=1");
    com.freelxl.baselibrary.d.a.post(q.o + e.s.X).tag(paramContext).headers(parame).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(locale)).enqueue(paramCallback);
  }
  
  public static void submitOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama)
  {
    Object localObject = q.m + e.l.g;
    g.combineParams(paramMap);
    localObject = new com.freelxl.baselibrary.e.h(1, (String)localObject);
    ((com.freelxl.baselibrary.e.h)localObject).setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, (com.freelxl.baselibrary.e.h)localObject, true, null, parama).request();
  }
  
  public static void submitZOEvaluate(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(q.s + e.s.V).params(ah.ConvertObjMap2String(paramMap)).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void updateRentHouseCollect(Context paramContext, boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (paramBoolean)
    {
      localObject = q.a + e.b.Q;
      AlternateAddCollect localAlternateAddCollect = new AlternateAddCollect();
      AlternateAddCollect.AlternateCollection localAlternateCollection = new AlternateAddCollect.AlternateCollection();
      localAlternateCollection.setHouse_code(paramString1);
      localAlternateCollection.setHouse_type(paramInt);
      localAlternateCollection.setCode(paramString2);
      localAlternateCollection.setStatus(paramString3);
      localAlternateCollection.setType("APP");
      localAlternateCollection.setAdd_time(System.currentTimeMillis());
      paramString1 = new ArrayList();
      paramString1.add(localAlternateCollection);
      localAlternateAddCollect.setCollect(paramString1);
      localHashMap.put("collect", com.alibaba.fastjson.b.toJSONString(paramString1));
      g.getOldHouseSignString(localHashMap);
    }
    for (paramString1 = (String)localObject;; paramString1 = paramString2)
    {
      com.freelxl.baselibrary.d.a.post(paramString1).params(localHashMap).tag(paramContext).enqueue(paramCallback);
      return;
      paramString2 = q.a + e.b.R;
      paramString3 = new AlternateDelCollect();
      localObject = new AlternateDelCollect.Collection();
      ((AlternateDelCollect.Collection)localObject).setDel_time(System.currentTimeMillis());
      ((AlternateDelCollect.Collection)localObject).setHouse_code(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      paramString3.setDelete(paramString1);
      localHashMap.put("delete", com.alibaba.fastjson.b.toJSONString(paramString1));
      g.getOldHouseSignString(localHashMap);
    }
  }
  
  public static void uploadHeadImage(Context paramContext, Handler paramHandler, String paramString, byte[] paramArrayOfByte)
  {
    a.execute(new j.22(paramString, paramArrayOfByte, paramHandler));
  }
  
  public static void uploadImage(Context paramContext, Handler paramHandler, String paramString, byte[] paramArrayOfByte)
  {
    a.execute(new j.21(paramString, paramArrayOfByte, paramHandler));
  }
  
  public static void uploadPhotoCommon(Context paramContext, String paramString, File paramFile, com.freelxl.baselibrary.d.c.a<com.alibaba.fastjson.e> parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("token", paramString);
      paramString = g.getPassportSign((Map)localObject);
      paramContext = com.freelxl.baselibrary.d.a.post(q.O + e.d.f).tag(paramContext).addHeader("Accept", "application/json; version=1");
      localObject = paramString.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramContext.addFormDataPart(str, (String)paramString.get(str));
      }
      paramContext.addFormDataPart("file", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void zkCancelReservation(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.w;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void zkConfirmCancel(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.y;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void zkInvalidCancel(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.s + e.q.x;
    paramMap = ah.ConvertObjMap2String(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void zryuCheckHasLivingBill(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.u;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractCard(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.v.k;
    HashMap localHashMap = new HashMap();
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractChoosePayStyle(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.p;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractList(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.v.l;
    HashMap localHashMap = new HashMap();
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractRoomInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.e;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractSavePayStyle(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    String str = q.o + e.v.q;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    localHashMap.put("payCode", paramInt + "");
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractSign(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.v.d;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("deCode", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractSubject(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.n;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractTerms(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.g;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractWebText(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      localObject = localUserInfo.getUid();
    }
    localHashMap.put("uid", localObject);
    localHashMap.put("contractId", paramString);
    paramString = q.o + "zraApi/contractsign/provision/v1";
    localObject = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(paramString).tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuContractsignValid(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.f;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuInvalidContractList(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.v.m;
    HashMap localHashMap = new HashMap();
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryCatalogItems(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.z;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryCertType(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.G;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryCheck(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.H;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryConfirmDelivery(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.F;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryDeleteSharer(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.v.E;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("fid", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryLifeBill(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.B;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryLifeFeeItems(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.A;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliveryPanle(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.y;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliverySaveOrUpdateSharer(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    String str = q.o + e.v.D;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("name", paramString3);
    localHashMap.put("certType", paramString4);
    localHashMap.put("certNo", paramString5);
    localHashMap.put("phone", paramString6);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuItemDeliverySharerList(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.C;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuMeetaCheckSwitch(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.g.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuMeetaOnOffSwitch(Context paramContext, Integer paramInteger, boolean paramBoolean, Callback paramCallback)
  {
    String str = q.o + e.g.c;
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("meetaShow", i + "");
      localHashMap.put("personId", paramInteger + "");
      paramInteger = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
      com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramInteger).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
      return;
    }
  }
  
  public static void zryuPaymentDetail(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    String str = q.o + e.v.i;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    localHashMap.put("period", paramInt + "");
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuPaymentItems(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    String str = q.o + e.v.h;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    localHashMap.put("type", paramInt + "");
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuPaymentItemsHistory(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.j;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuPendingPay(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.v.t;
    HashMap localHashMap = new HashMap();
    localHashMap.put("a", "a");
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdDelFeeBill(Context paramContext, Integer paramInteger, String paramString, Callback paramCallback)
  {
    String str = q.o + e.u.g;
    HashMap localHashMap = new HashMap();
    if (paramInteger != null) {
      localHashMap.put("documentAmount", paramInteger + "");
    }
    localHashMap.put("billNum", paramString);
    paramInteger = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramInteger).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdElectricityMeterDetail(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.u.c;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdElectricityMeterRecharge(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    String str = q.o + e.u.e;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    localHashMap.put("rechargeMoney", paramInt + "");
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdToPay(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4, Callback paramCallback)
  {
    String str = q.o + e.u.f;
    HashMap localHashMap = new HashMap();
    localHashMap.put("address", paramString1);
    localHashMap.put("contractId", paramString2);
    localHashMap.put("price", paramString3);
    localHashMap.put("rechargeMoney", paramInteger + "");
    localHashMap.put("rechargeReadings", paramString4);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdWaterBillList(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.u.h;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdWaterFeeBillDetail(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.u.d;
    HashMap localHashMap = new HashMap();
    localHashMap.put("billFid", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSdWaterMeterDetail(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.u.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSignSignatoryVerify(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.o;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSignatureErrorLog(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str = q.o + e.v.v;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString1);
    localHashMap.put("errMsg", paramString2);
    paramString1 = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString1).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSignatureQuery(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.o + e.v.w;
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractId", paramString);
    paramString = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(paramString).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
  
  public static void zryuSignatureVerify(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    String str2 = q.F + e.v.x;
    HashMap localHashMap = new HashMap();
    String str1 = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str1 = localUserInfo.getUid();
    }
    localHashMap.put("uid", str1);
    localHashMap.put("contractId", paramString1);
    localHashMap.put("signMessage", paramString2);
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertorStr(paramContext, localHashMap);
    paramString1 = com.ziroom.ziroomcustomer.ziroomapartment.a.c.encryptPost(localHashMap);
    com.freelxl.baselibrary.d.a.post(str2).tag(paramContext).params(paramString1).enqueue(paramCallback);
  }
  
  public static void zryuValidContractList(Context paramContext, Callback paramCallback)
  {
    String str = q.o + e.u.a;
    HashMap localHashMap = new HashMap();
    Map localMap = com.ziroom.ziroomcustomer.e.b.b.getHeader(paramContext);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).headers(localMap).setBodyString("application/json;charset=UTF-8", com.ziroom.ziroomcustomer.e.b.b.getParam(localHashMap)).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */