package com.ziroom.ziroomcustomer.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.freelxl.baselibrary.e.h;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.model.ax;
import com.ziroom.ziroomcustomer.bestgoods.model.o;
import com.ziroom.ziroomcustomer.newServiceList.model.bh;
import com.ziroom.ziroomcustomer.newclean.d.ab;
import com.ziroom.ziroomcustomer.newclean.d.az;
import com.ziroom.ziroomcustomer.newclean.d.t;
import com.ziroom.ziroomcustomer.newclean.d.x;
import com.ziroom.ziroomcustomer.newmovehouse.model.Address;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Callback;

public class n
{
  public static void ChangeCleanGiftCardStatus(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cardNumber", paramString1);
    locale.put("giveState", paramString2);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/valuecard/present/changeGiveState", locale, parama);
  }
  
  public static void UploadPic(Activity paramActivity, String paramString, File paramFile, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    paramFile = com.ziroom.ziroomcustomer.social.b.b.saveImageToGallery(paramFile);
    if (a(paramFile) > 3145728L)
    {
      com.freelxl.baselibrary.f.g.textToast(paramActivity, "图片过大，上传失败");
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("is_head", paramInt + "");
    ((Map)localObject).put("token", paramString);
    paramString = g.getSocalPassportSign((Map)localObject);
    paramActivity = com.freelxl.baselibrary.d.a.post(q.ap + "/meet/image/upload.json").tag(paramActivity).addHeader("Accept", "application/json; version=1");
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramActivity.addFormDataPart(str, (String)paramString.get(str));
    }
    paramActivity.addFormDataPart("img", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
    paramActivity.enqueue(parama);
  }
  
  private static long a(File paramFile)
  {
    long l = 0L;
    if (paramFile.exists()) {}
    try
    {
      int i = new FileInputStream(paramFile).available();
      l = i;
      return l;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return 0L;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return 0L;
  }
  
  public static void activiteCleanCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildactiviteCleanCard(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new h(1, q.j + p.b.aG);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void addYouPinShoppingCart(Context paramContext, List<ax> paramList, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cartKey", com.alibaba.fastjson.a.toJSONString(paramList));
    k.requestYouPin(paramContext, q.n + e.t.B, localHashMap, paramCallback);
  }
  
  public static void addYouPinShoppingCartCheck(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.A, localHashMap, paramCallback);
  }
  
  public static void buyCleanCard(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildBuyCleanCard(paramContext, paramInt, paramString1, paramString2, paramString3, paramString4);
    paramString2 = new h(1, q.j + p.b.aJ);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, paramBoolean, null, parama).request();
  }
  
  public static void buyCleanGiftCard(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("valueCardTypeId", paramString1);
    locale.put("phone", paramString2);
    locale.put("name", paramString3);
    locale.put("recommendUserMobile", paramString4);
    locale.put("sourceCityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("cardStyleUrl", paramString5);
    locale.put("cardStyleNote", paramString6);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/valuecard/buy", locale, parama);
  }
  
  public static void buyCleanStoredCard(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildBuyCleanStoredCard(paramContext, paramInt, paramString1, paramString2, paramString3, paramString4);
    paramString2 = new h(1, q.j + p.b.aJ);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, paramBoolean, null, parama).request();
  }
  
  public static void createMvOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("channelCode", paramString4);
    locale.put("channelName", paramString5);
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/createOrder").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void createShareOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("orderCode", paramString1);
    locale.put("orderNumber", paramString2);
    locale.put("firstServiceTypeCode", paramString3);
    locale.put("employeeCode", paramString4);
    locale.put("userCode", paramString5);
    locale.put("userName", paramString6);
    locale.put("userPhone", paramString7);
    com.freelxl.baselibrary.d.a.post(q.j + p.g.i).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void deleteSocialZzFriend(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("be_uid", paramString2);
    k.requestGateWayService(paramContext, q.o + p.h.k, locale, paramCallback);
  }
  
  public static void getAcarusLKillingProject(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("serviceInfoId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "5.0");
    k.requestClean(paramContext, q.j + p.b.bw, locale, parama);
  }
  
  public static void getBiWeeklyOrderList(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("expand", paramString2);
    locale.put("uid", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    paramString2 = "";
    if ("orderOngoing".equals(paramString1)) {
      paramString2 = q.j + p.b.C;
    }
    for (;;)
    {
      com.freelxl.baselibrary.d.a.post(paramString2).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
      return;
      if ("orderDone".equals(paramString1)) {
        paramString2 = q.j + p.b.B;
      } else if ("orderEval".equals(paramString1)) {
        paramString2 = q.j + p.b.D;
      }
    }
  }
  
  public static void getBiweeklyCleanAllDate(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("workBillId", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aq).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanAllTime(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.ar).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getBiweeklyCleanContractValidate(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.al).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanDetail(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("workBillId", paramString4);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.av).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanListByMonth(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("monthDate", paramString4);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.am).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanModifyValidate(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("workBillId", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("hireContractCode", paramString4);
    locale.put("linkPhone", paramString5);
    locale.put("linkMan", paramString6);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.ap).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanMonthList(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.an).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanOrderState(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("workBillId", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aA).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanerAllEvalList(Context paramContext, String paramString, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aD).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanerBestEvalList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aB).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanerIdent(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aC).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanerInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.as).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBiweeklyCleanerInfoByContract(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.at).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getBusinessType(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    com.freelxl.baselibrary.d.a.post(q.k + p.a.a).tag(paramContext).setBodyString(locale.toJSONString()).enqueue(parama);
  }
  
  public static void getCanBuyCleanCard(Context paramContext, i.a<String> parama, boolean paramBoolean)
  {
    Map localMap = m.buildCanBuyCleanCard(paramContext);
    h localh = new h(1, q.j + p.b.aH);
    localh.setParams(localMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, true, null, parama).request();
  }
  
  public static void getCanBuyCleanStoredCard(Context paramContext, i.a<String> parama, String paramString, int paramInt)
  {
    paramString = m.buildCanBuyCleanStoredCard(paramContext, paramString, paramInt);
    h localh = new h(1, q.j + p.b.aH);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, true, null, parama).request();
  }
  
  public static void getChatContent(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get(q.k + p.b.bB).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getChatStatus(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get(q.k + "base/customer-service/" + paramString + "/status").tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getClassQueations(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("userUniqueKey", paramString1);
    localHashMap.put("clientMark", "ZIROOM_APP_RECOMMEND");
    localHashMap.put("index", paramString2);
    com.freelxl.baselibrary.d.a.post(q.k + p.b.bC).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void getClasssQueations(Context paramContext, int paramInt1, int paramInt2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("clientType", "ZIROOM_APP");
    locale.put("pageNum", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    k.requestGateWayService(paramContext, q.o + "zmcApi/lore/categories", locale, paramCallback);
  }
  
  public static void getCleanBottomCleaner(Context paramContext, double paramDouble1, double paramDouble2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("longitude", Double.valueOf(paramDouble1));
    locale.put("latitude", Double.valueOf(paramDouble2));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/findNearbyCleaner", locale, parama);
  }
  
  public static void getCleanBuyGiftCardInfo(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    locale.put("clientCode", ah.getDeviceId(ApplicationEx.c));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("sourceVersion", "5.6.0");
    locale.put("sourceType", "android");
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/valuecard/present/goods", locale, parama);
  }
  
  public static void getCleanCardFollowInfo(Context paramContext, String paramString, int paramInt1, int paramInt2, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildCleanCardFollowInfo(paramContext, paramString, paramInt1, paramInt2);
    h localh = new h(1, q.j + p.b.aF);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, false, null, parama).request();
  }
  
  public static void getCleanCardLeft(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildCleanCardLeft(paramContext, paramString);
    h localh = new h(1, q.j + p.b.aM);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, true, null, parama).request();
  }
  
  public static void getCleanCardList(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildCleanCardList(paramContext, paramString);
    h localh = new h(1, q.j + p.b.aE);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, false, null, parama).request();
  }
  
  public static void getCleanCommendCleaner(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("appointDateTime", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("addressId", paramString5);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", paramString6);
    k.requestFluxClean(paramContext, q.j + p.b.bg, locale, paramCallback);
  }
  
  public static void getCleanGiftCardList(Context paramContext, String paramString, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("serviceType", paramString);
    locale.put("pageNum", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/valuecard/present/card", locale, parama);
  }
  
  public static void getCleanGiftCardShapingLinks(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cardNumber", paramString);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/valuecard/present/sharingLinks", locale, parama);
  }
  
  public static void getCleanHistoryCleaner(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("appointDateTime", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("addressId", paramString5);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", paramString6);
    k.requestFluxClean(paramContext, q.j + p.b.bf, locale, paramCallback);
  }
  
  public static void getCleanHomeBanner(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + p.b.ca, locale, paramCallback);
  }
  
  public static void getCleanHomeCenterBanner(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + p.b.cb, locale, paramCallback);
  }
  
  public static void getCleanHomeLastOrder(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    k.requestGateWayCommonService(paramContext, q.o + p.b.bY, locale, paramCallback);
  }
  
  public static void getCleanHomeList(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + p.b.bZ, locale, paramCallback);
  }
  
  public static void getCleanList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    k.requestClean(paramContext, q.j + p.b.v, locale, parama);
  }
  
  public static void getCleanPayCardLeft(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("uid", paramString);
    locale.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    k.requestClean(paramContext, q.j + p.b.aM, locale, parama);
  }
  
  public static void getCleanTagNum(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("employeeCode", paramString);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/serviceEvaluate/evaluateNumber", locale, paramCallback);
  }
  
  public static void getCleanTimePoint(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("appointDate", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("addressId", paramString5);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    k.requestFluxClean(paramContext, q.j + p.b.aX, locale, paramCallback);
  }
  
  public static void getCleanTopLunBoPic(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/display/clean/slider", locale, parama);
  }
  
  public static void getCleanTyepList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/display/clean/products/v1", locale, parama);
  }
  
  public static void getCleanTypeList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "");
    locale.put("appVersion", "5.6.0");
    k.requestClean(paramContext, q.j + p.b.v, locale, parama);
  }
  
  public static void getCleanZuAddressList(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("uid", paramString);
    locale.put("page", Integer.valueOf(1));
    locale.put("pageSize", Integer.valueOf(100));
    k.requestFluxClean(paramContext, q.j + p.b.aW, locale, paramCallback);
  }
  
  public static void getCleanddressList(Context paramContext, String paramString, int paramInt1, int paramInt2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("uid", paramString);
    locale.put("version", "V1.4");
    k.requestFluxClean(paramContext, q.j + p.b.M, locale, paramCallback);
  }
  
  public static void getCleanerCapacity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, i.a<String> parama, boolean paramBoolean)
  {
    getCleanerCapacity(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null, parama, paramBoolean);
  }
  
  public static void getCleanerCapacity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildCleanerCapacity(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    paramString2 = new h(1, q.j + p.b.bb);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, true, null, parama).request();
  }
  
  public static void getCleanerEval(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("employeeCode", paramString1);
    locale.put("scoreType", paramString2);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/serviceEvaluate/evaluateList", locale, paramCallback);
  }
  
  public static void getCleanerEvalInfo(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildCleanerEvalInfo(paramString1, paramInt1, paramInt2, paramInt3, paramString2);
    paramString2 = new h(1, q.j + p.b.ba);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void getCleanerEvalInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("cleanId", paramString2);
    locale.put("appointDateTime", paramString3);
    locale.put("serviceInfoId", paramString4);
    locale.put("servicePmId", paramString5);
    locale.put("addressId", paramString6);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    k.requestFluxClean(paramContext, q.j + p.b.aZ, locale, paramCallback);
  }
  
  public static void getCleanerInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildCleanerInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    paramString2 = new h(1, q.j + p.b.aZ);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void getCommonCleanCapacity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildCommonCleanCapacity(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new h(1, q.j + p.b.aX);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, true, null, parama).request();
  }
  
  public static void getCommonCleanCapacity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildCommonCleanCapacity(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new h(1, q.j + p.b.aX);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, true, null, parama).request();
  }
  
  public static void getCommonDicTag(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dicType", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestClean(paramContext, q.j + "zrk/commons/dicTag", locale, parama);
  }
  
  public static void getCommonDicTag(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("dicType", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestOkService(paramContext, q.j + "zrk/commons/dicTag", locale, paramCallback);
  }
  
  public static void getCommonJson(Context paramContext, String paramString, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getCommonTemplate(Context paramContext, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("noteCode", paramInteger);
    k.requestGateWayServiceNotLogin(paramContext, q.o + "cleanApi/zrk/commons/template/get", locale, parama);
  }
  
  public static void getCommonTemplateOnCity(Context paramContext, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("noteCode", paramInteger);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/template/city", locale, parama);
  }
  
  public static void getCommonTemplateOnCityV2(Context paramContext, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("noteCode", paramInteger);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/template/city/v2", locale, parama);
  }
  
  public static void getComplainTime(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    k.requestJson(paramContext, q.k, p.b.br, null, parama);
  }
  
  public static void getComplainTips(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", paramString1);
    localHashMap.put("pageSize", paramString2);
    localHashMap.put("publicType", paramString3);
    k.requestJson(paramContext, q.k, p.b.bo, localHashMap, parama);
  }
  
  public static void getComplainTypeOne(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    k.requestJson(paramContext, q.k, p.b.bp, null, parama);
  }
  
  public static void getComplainTypeTwo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    k.requestJson(paramContext, q.k, p.b.bq, localHashMap, parama);
  }
  
  public static void getDicTag(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dicType", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + "zrk/commons/dicTag").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getExclusiveCleaner(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("hireContractCode", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "1.0");
    k.requestClean(paramContext, q.j + p.b.bK, locale, parama);
  }
  
  public static void getForCleaningBrdroom(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + p.b.bX, locale, paramCallback);
  }
  
  public static void getForCleaningData(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("workbillId", paramString);
    k.requestGateWayCommonService(paramContext, q.o + p.b.bT, locale, paramCallback);
  }
  
  public static void getForCleaningOrderByMonth(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("page", Integer.valueOf(paramInt));
    locale.put("rentContractCode", paramString2);
    locale.put("hireContractCode", paramString3);
    locale.put("monthDate", paramString4);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.am).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getForCleaningOrders(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("supplierWorkId", paramString1);
    locale.put("servicerId", paramString2);
    locale.put("appointDate", paramString3);
    k.requestGateWayCommonService(paramContext, q.o + p.b.bW, locale, paramCallback);
  }
  
  public static void getForCleaningTimePoint(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("workbillId", paramString1);
    locale.put("fconstruction", paramString2);
    k.requestGateWayCommonService(paramContext, q.o + p.b.bU, locale, paramCallback);
  }
  
  public static void getGataWayMoveList(Context paramContext, Integer paramInteger1, Integer paramInteger2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("page", paramInteger2);
    if (paramInteger1 == null)
    {
      k.requestGateWayService(paramContext, q.o + p.g.k, locale, parama);
      return;
    }
    locale.put("statusCode", paramInteger1);
    k.requestGateWayService(paramContext, q.o + p.g.j, locale, parama);
  }
  
  public static void getGataWayServiceList(Context paramContext, Integer paramInteger1, Integer paramInteger2, List<Integer> paramList, List<bh> paramList1, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("page", paramInteger2);
    locale.put("busiCode", paramList);
    locale.put("contracts", paramList1);
    if (paramInteger1 == null)
    {
      k.requestGateWayService(paramContext, q.o + p.g.k, locale, parama);
      return;
    }
    locale.put("statusCode", paramInteger1);
    k.requestGateWayService(paramContext, q.o + p.g.j, locale, parama);
  }
  
  public static void getGataWayServiceListNum(Context paramContext, List<Integer> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("busiCode", paramList);
    k.requestGateWayService(paramContext, q.o + p.g.l, locale, parama);
  }
  
  public static void getGeneralCleanData(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("serviceInfoId", paramString1);
    locale.put("servicePmId", paramString2);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestFluxClean(paramContext, q.j + p.b.ak, locale, paramCallback);
  }
  
  public static void getGeneralCleanFeeInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getCleanCommon(paramContext);
    locale.put("orderNum", paramString);
    k.requestClean(paramContext, q.j + p.b.bS, locale, parama);
  }
  
  public static void getGeneralCleanPay(Context paramContext, String paramString1, float paramFloat, String paramString2, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildGeneralCleanPay(paramContext, paramString1, paramFloat, paramString2);
    paramString2 = new h(1, q.j + p.b.aL);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void getGeneralCleanQuestion(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("workBillId", paramString);
    k.requestClean(paramContext, q.j + p.b.bP, locale, parama);
  }
  
  public static void getGeneralCleanerInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanerId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    k.requestClean(paramContext, q.j + p.b.bO, locale, parama);
  }
  
  public static void getGeneralCostEvaluation(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, List<x> paramList, String paramString20, Callback paramCallback)
  {
    paramString1 = com.ziroom.ziroomcustomer.newServiceList.utils.f.buildNewCleanCostEstimates(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramInt, paramString13, paramString14, paramString15, paramString16, paramString17, paramString18, paramString19, paramList, paramString20);
    k.requestFluxClean(paramContext, q.j + p.b.A, paramString1, paramCallback);
  }
  
  public static void getGeneralCreateOrder(Context paramContext, t paramt, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    paramt = com.ziroom.ziroomcustomer.newServiceList.utils.f.buildNewCreateGOrder(paramt, paramString1, paramString2, paramString3);
    k.requestFluxClean(paramContext, q.j + p.b.P, paramt, paramCallback);
  }
  
  public static void getGeneralDefaultMessage(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString2);
    locale.put("serviceInfoId", paramString1);
    if ("true".equals(paramString3)) {
      locale.put("zhengZu", paramString3);
    }
    locale.put("version", "V1.4");
    k.requestFluxClean(paramContext, q.j + p.b.K, locale, paramCallback);
  }
  
  public static void getGeneralDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestClean(paramContext, q.j + p.b.bN, locale, parama);
  }
  
  public static void getGeneralFollowInfo(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("cleanId", paramString);
    locale.put("orderState", Integer.valueOf(paramInt1));
    locale.put("page", Integer.valueOf(paramInt2));
    locale.put("pageSize", Integer.valueOf(paramInt3));
    k.requestClean(paramContext, q.j + p.b.R, locale, parama);
  }
  
  public static void getGeneralItem(Context paramContext, int paramInt1, int paramInt2, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("serviceInfoId", paramString);
    k.requestClean(paramContext, q.j + p.b.L, locale, parama);
  }
  
  public static void getGeneralOrderCancle(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("cleanId", paramString1);
    locale.put("uid", paramString2);
    locale.put("reason", paramString3);
    k.requestClean(paramContext, q.j + p.b.X, locale, parama);
  }
  
  public static void getGeneralOrderControl(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    k.requestClean(paramContext, q.j + p.b.bM, locale, parama);
  }
  
  public static void getGeneralOrderList(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("visitState", Integer.valueOf(paramInt1));
    locale.put("pageNum", Integer.valueOf(paramInt2));
    locale.put("pageSize", Integer.valueOf(paramInt3));
    u.d("dsgdg", "====  " + com.alibaba.fastjson.a.toJSONString(locale));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.I).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getGeneralOrderState(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("orderState", "");
    locale.put("page", Integer.valueOf(1));
    locale.put("pageSize", Integer.valueOf(50));
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    k.requestClean(paramContext, q.j + p.b.bL, locale, parama);
  }
  
  public static void getGeneralWorkerInfo(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("empId", paramString1);
    locale.put("cleanId", paramString2);
    k.requestClean(paramContext, q.j + p.b.V, locale, parama);
  }
  
  public static void getHotQuestionLabel(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("wordType", "HOTSPOT");
    localHashMap.put("hotspot", String.valueOf(true));
    com.freelxl.baselibrary.d.a.post(q.k + p.b.by).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void getHotQuestions(Context paramContext, String paramString1, String paramString2, int paramInt, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildHotQuestions(paramString1, paramString2, paramInt);
    paramString2 = new h(1, q.k + p.b.aO);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void getHouseKeeper(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(paramContext));
    com.freelxl.baselibrary.d.a.get(q.R + e.p.a).tag(paramContext).params(g.getCommonHouseSign(localHashMap)).enqueue(parama);
  }
  
  public static void getHouseKeeperDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    paramString = new HashMap();
    paramString.put("token", com.ziroom.commonlibrary.login.a.getToken(paramContext));
    com.freelxl.baselibrary.d.a.get(q.R + e.p.b).tag(paramContext).params(g.getCommonHouseSign(paramString)).enqueue(parama);
  }
  
  public static void getInternalRepairFaultTag(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("keywords", paramString1);
    locale.put("goodsCode", paramString2);
    k.requestRepair(paramContext, q.i + e.l.F, locale, paramCallback);
  }
  
  public static void getInternalRepairGoodList(Context paramContext, Callback paramCallback)
  {
    k.requestRepair(paramContext, q.i + e.l.H, null, paramCallback);
  }
  
  public static void getLataComInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    k.requestJson(paramContext, q.k, p.b.bn, localHashMap, parama);
  }
  
  public static void getLockRoomInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.post(q.w + "passwordCus/getContractHasPassword").tag(paramContext).params(localHashMap).enqueue(parama);
  }
  
  public static void getMHFloorsFeeList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("serviceInfoId", paramString);
    k.requestClean(paramContext, q.j + p.d.h, locale, parama);
  }
  
  public static void getMHServiceEntity(Context paramContext, i.a<String> parama, boolean paramBoolean)
  {
    Map localMap = m.buildMHService();
    h localh = new h(1, q.j + p.d.a);
    localh.setParams(localMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, false, null, parama).request();
  }
  
  public static void getMateCoupon(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceType", Integer.valueOf(paramInt));
    locale.put("adressId", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("serviceItemCode", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("startTime", paramString4);
    locale.put("uid", paramString5);
    k.requestFluxClean(paramContext, q.j + p.b.bE, locale, paramCallback);
  }
  
  public static void getMoveCouponFeeInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      locale.put("couponCode", paramString2);
    }
    locale.put("useCoupon", paramString3);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("versionNum", Integer.valueOf(2));
    locale.put("addressId", paramString4);
    k.requestGateWayService(paramContext, q.o + "smsApi/zrk/order/charges", locale, parama);
  }
  
  public static void getMoveDetail(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("useCoupon", paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      locale.put("couponCode", paramString4);
    }
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderDetail", locale, parama);
  }
  
  public static void getMoveFeeInfo(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderPayDetail", locale, parama);
  }
  
  public static void getMoveHousePreferential(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("uid", paramString1);
    locale.put("token", paramString2);
    locale.put("activityCode", paramString3);
    locale.put("mobile", paramString4);
    com.freelxl.baselibrary.d.a.post(q.j + "zrk/promotion/outer/encrypt/activity").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
    u.d("http ===", "http://smsapi.d.ziroom.com/zrk/promotion/outer/encrypt/activity" + locale.toString() + "     ===============         " + m.createPostEncodeString(locale.toJSONString()));
  }
  
  public static void getMoveOrderControl(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderActionControl", locale, parama);
  }
  
  public static void getMoveOrderList(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Integer paramInteger1, Integer paramInteger2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("userId", paramString1);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("queryStatus", paramString2);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("isPay", paramInteger1);
    locale.put("isEvaluate", paramInteger2);
    com.freelxl.baselibrary.d.a.post(q.j + p.c.o).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getMoveOrderState(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderOperateSteps", locale, parama);
  }
  
  public static void getMoveOrderSuccessTip(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/createSuccessNotice", locale, parama);
  }
  
  public static void getMoveSecondList(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/display/move/products/v1", locale, parama);
  }
  
  public static void getMoveTypeList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "");
    locale.put("appVersion", "5.6.0");
    k.requestClean(paramContext, q.j + p.d.a, locale, parama);
  }
  
  public static void getMovingCheckOrder(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/acceptOrder", locale, parama);
  }
  
  public static void getMovingVanData(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString);
    locale.put("serviceProductCode", "2c9085f248ba3f3a0148bb151aca0003");
    k.requestClean(paramContext, q.l + p.c.p, locale, parama);
  }
  
  public static void getMovingVanDetail(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + "zrk/move/customerOrder/orderDetail", locale, paramCallback);
  }
  
  public static void getMovingVanEvalInfo(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + "zrk/move/customerOrder/orderEvaluateInfo", locale, paramCallback);
  }
  
  public static void getMovingVanGoodsNum(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + p.b.bH, locale, paramCallback);
  }
  
  public static void getMovingVanOrderList(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, Integer paramInteger1, Integer paramInteger2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("queryStatus", Integer.valueOf(paramInt3));
    locale.put("uid", paramString2);
    locale.put("isPay", paramInteger1);
    locale.put("isEvaluate", paramInteger2);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderList", locale, parama);
  }
  
  public static void getMovingVanState(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + "zrk/move/customerOrder/orderLog", locale, paramCallback);
  }
  
  public static void getMovingVanTimeCityIsCan(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("interfaceVesion", "2.0");
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/isTimeBlocks", locale, parama);
  }
  
  public static void getMovingVanTimePeriod(Context paramContext, String paramString1, String paramString2, long paramLong, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("serviceProductCode", paramString1);
    locale.put("serviceItemCode", paramString2);
    locale.put("bookableDate", Long.valueOf(paramLong));
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/movingTimeBlocks", locale, parama);
  }
  
  public static void getMovingVanTimePoint(Context paramContext, String paramString, long paramLong, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString);
    locale.put("bookableDate", Long.valueOf(paramLong));
    locale.put("serviceProductCode", "2c9085f248ba3f3a0148bb151aca0003");
    k.requestClean(paramContext, q.l + p.c.q, locale, parama);
  }
  
  public static void getMvEstimateCost(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/estimateCost").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getMvGoodsList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/materielList").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getMvOrderActionControl(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + "zrk/move/customerOrder/orderActionControl", locale, paramCallback);
  }
  
  public static void getMvServiceList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/serviceItemList").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getMvToken(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("connectName", paramString3);
    locale.put("connectPhone", paramString4);
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/getShoppingCartToken").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getMyComplainList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString);
    com.freelxl.baselibrary.f.d.d("ServeNewService", "===getMyComplainList:" + locale.toJSONString());
    com.freelxl.baselibrary.d.a.post(q.k + p.b.aS).setBodyString(locale.toJSONString()).tag(paramContext).enqueue(parama);
  }
  
  public static void getNewCleanList(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildNewCleanList(paramContext, paramString);
    h localh = new h(1, q.j + p.b.v);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getNewGeneralAList(Context paramContext, int paramInt1, int paramInt2, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("uid", paramString);
    locale.put("version", "V1.4");
    k.requestFluxClean(paramContext, q.j + p.b.M, locale, paramCallback);
  }
  
  public static void getNewSOrderNums(Context paramContext, List<String> paramList, String paramString1, String paramString2, i.a<String> parama, boolean paramBoolean)
  {
    paramList = m.buildNewSOrderNums(paramContext, paramList, paramString1, paramString2);
    paramString1 = new h(1, q.j + p.b.J);
    paramString1.setParams(paramList);
    new com.freelxl.baselibrary.e.d(paramContext, paramString1, false, null, parama).request();
  }
  
  public static void getOrderMapStatus(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("orderCode", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayService(paramContext, q.o + "smsApi/zrk/move/customerOrder/isShowOrderMap", locale, paramCallback);
  }
  
  public static void getPaySuccessBanner(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/display/clean/chuZhiKaAdvertisement", locale, paramCallback);
  }
  
  public static void getPersonInfoTag(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("class_name", paramString);
    locale.put("class_id", Integer.valueOf(paramInt));
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/tag/list.json", locale, parama);
  }
  
  public static void getPublicNoticeList(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get("http://contentful.ziroom.com/online/fuwu/fuwuapp/b3e3e393c77e35a4a3f3cbd1e429b5dc.json").tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getQueationDetail(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("loreGroupId", paramString3);
    locale.put("uid", paramString1);
    locale.put("userType", "CUSTOMER");
    locale.put("cityCode", paramString2);
    locale.put("loreTrackSource", "ZIROOMER_APP_MAIN_PAGE_RECOMMEND");
    k.requestGateWayService(paramContext, q.o + "zmcApi/lore/detail", locale, paramCallback);
  }
  
  public static void getQueationDetailEvaluation(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Callback paramCallback)
  {
    e locale = new e();
    locale.put("loreLogicCode", paramString3);
    locale.put("trackCode", paramString2);
    locale.put("loreGroupId", paramString4);
    locale.put("evaluateType", paramString5);
    locale.put("uid", paramString1);
    locale.put("userType", "CUSTOMER");
    locale.put("uselessCause", paramString6);
    k.requestGateWayService(paramContext, q.o + "zmcApi/lore/evaluation", locale, paramCallback);
  }
  
  public static void getQueationEventAdd(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("clientType", "ZIROOM_APP");
    locale.put("eventType", "ZIROOM_APP_CONTACT_SERVICE");
    locale.put("uid", paramString1);
    locale.put("userType", "CUSTOMER");
    locale.put("loreLogicCode", paramString2);
    k.requestGateWayService(paramContext, q.o + "zmcApi/lore/event/add", locale, paramCallback);
  }
  
  public static void getQueryCityInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramString);
    k.requestYouPin(paramContext, q.n + e.t.t, localHashMap, paramCallback);
  }
  
  public static void getQuestionDetail(Context paramContext, String paramString1, String paramString2, String paramString3, i.a<String> parama, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new h(0, q.k + p.b.bk + paramString1 + "?userUniqueKey=" + paramString2 + "&knowledgeTrackSource=" + paramString3), paramBoolean, null, parama).request();
  }
  
  public static void getQuestionDetail(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get(q.k + p.b.bk + paramString1 + "?userUniqueKey=" + paramString2 + "&knowledgeTrackSource=" + paramString3).tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void getQuestionId(Context paramContext, i.a<String> parama, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new h(0, q.k + p.b.bh + "?cityCode=" + com.ziroom.ziroomcustomer.base.b.d + "&clientMark=ZIROOM_APP"), false, null, parama).request();
  }
  
  public static void getQuestionType(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("businessTypeId", paramString);
    com.freelxl.baselibrary.d.a.post(q.k + p.a.b).tag(paramContext).setBodyString(locale.toJSONString()).enqueue(parama);
  }
  
  public static void getQuestionnaire(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("workBillId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.ay).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getRecommendDuration(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString2);
    locale.put("serviceInfoId", paramString1);
    locale.put("zhengZu", paramString3);
    locale.put("addressId", paramString4);
    locale.put("version", "V1.4");
    k.requestClean(paramContext, q.j + p.b.bJ, locale, parama);
  }
  
  public static void getRentOrderList(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("customerPhone", paramString);
    localHashMap.put("listType", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("pageSize", Integer.valueOf(paramInt3));
    com.freelxl.baselibrary.d.a.get(q.k + p.e.a + com.ziroom.ziroomcustomer.newServiceList.utils.f.getRasParam(localHashMap)).tag(paramContext).addHeader("zmcsrc", "ANDROID").enqueue(parama);
  }
  
  public static void getRepairProduct(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "1.0");
    k.requestFluxClean(paramContext, q.m + e.l.I, locale, paramCallback);
  }
  
  public static void getRepairTypeList(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", ah.getAppVersion(ApplicationEx.c));
    locale.put("appVersion", "5.6.0");
    locale.put("interfaceVersion", "1.0");
    k.requestClean(paramContext, q.m + p.f.A, locale, parama);
  }
  
  public static void getRepairVideoTag(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tagName", paramString);
    k.request(paramContext, q.m, "constant/tags/urlInfo", localHashMap, paramCallback);
  }
  
  public static void getSelfForm(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("clientType", "ZIROOM_APP");
    k.requestGateWayService(paramContext, q.o + "zmcApi/lore/self/form", locale, paramCallback);
  }
  
  public static void getServeSuggest(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("productCode", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "1.0");
    k.requestGateWayCommonService(paramContext, q.o + p.b.cc, locale, paramCallback);
  }
  
  public static void getServiceBanner(Context paramContext, int paramInt, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    String str = System.currentTimeMillis() / 1000L + "";
    localHashMap.put("timestamp", str);
    localHashMap.put("uid", "1");
    localHashMap.put("sign", ah.toMd5((1 + str + "7srzT88FcNiRQA3n").getBytes()));
    localHashMap.put("id", paramInt + "");
    localHashMap.put("city_code", paramString);
    com.freelxl.baselibrary.d.a.get("http://interfaces.ziroom.com/?_p=api_mobile&_a=getLunBoDatas").tag(paramContext).params(localHashMap).enqueue(parama);
  }
  
  public static void getServiceCalendarTip(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("serviceType", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/timeToast", locale, parama);
  }
  
  public static void getServiceDic(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("dictionaryName", paramString);
    com.freelxl.baselibrary.d.a.post(q.l + "base/dictionary/dictionaryList").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void getServiceListNotReadNumber(Context paramContext, List<String> paramList, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString2);
    locale.put("expands", com.alibaba.fastjson.a.toJSON(paramList));
    locale.put("loginPhone", paramString1);
    k.requestClean(paramContext, q.j + p.b.J, locale, parama);
  }
  
  public static void getServicePageGains(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/historyRecords", locale, parama);
  }
  
  public static void getShareInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("employeeCode", paramString);
    com.freelxl.baselibrary.d.a.post(q.j + p.g.h).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getSkillGroupType(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("businessTypeId", paramString1);
    if (!com.freelxl.baselibrary.f.f.isNull(paramString2)) {
      locale.put("questionTypeId", paramString2);
    }
    com.freelxl.baselibrary.d.a.post(q.k + p.a.c).tag(paramContext).setBodyString(locale.toJSONString()).enqueue(parama);
  }
  
  public static void getSmallMoveCommonDicTag(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dictionaryName", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/base/dictionary/moveSpecialNeedList", locale, parama);
  }
  
  public static void getSmallMoveDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("workOrderId", paramString);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    com.freelxl.baselibrary.d.a.post(q.j + "zrk/move/workOrderDetail").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void getSmallMoveGoodsNum(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString1);
    locale.put("uid", paramString2);
    k.requestClean(paramContext, q.l + p.b.bG, locale, parama);
  }
  
  public static void getSocialZzComplainList(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    k.requestGateWayServiceNotLogin(paramContext, q.o + p.h.b, locale, paramCallback);
  }
  
  public static void getSocialZzFreezeInfo(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    k.requestGateWayService(paramContext, q.o + p.h.e, locale, paramCallback);
  }
  
  public static void getSocialZzIndexData(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", "2");
    k.requestGateWayService(paramContext, q.o + p.h.a, locale, localHashMap, paramCallback, true);
  }
  
  public static void getSortCouponList(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceType", Integer.valueOf(paramInt));
    locale.put("adressId", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("serviceItemCode", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("startTime", paramString4);
    locale.put("uid", paramString5);
    locale.put("version", "5.6.0");
    if (paramInteger.intValue() == 1) {
      locale.put("isAppoint", Boolean.valueOf(true));
    }
    k.requestClean(paramContext, q.j + p.b.bF, locale, parama);
  }
  
  public static void getSubmitTag(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("fcityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("fserviceinfoid", paramString1);
    locale.put("docType", paramString2);
    locale.put("fversion", paramString3);
    k.requestClean(paramContext, q.j + p.b.aj, locale, parama);
  }
  
  public static void getSugChildTypeList(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("complainTypeId", paramString);
    com.freelxl.baselibrary.d.a.post(q.k + p.b.bA).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void getSugTypeList(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.post(q.k + p.b.aU).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void getSuggestDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("consulltId", paramString);
    com.freelxl.baselibrary.f.d.d("ServeNewService", "===getSuggestDetail:" + localHashMap);
    k.requestJson(paramContext, q.k, p.b.bv, localHashMap, parama);
  }
  
  public static void getSystemTime(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(q.o + "/clock").tag(paramContext).enqueue(parama);
  }
  
  public static void getUrl2Bitmap(Context paramContext, String paramString, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(paramString).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void getUserHeaders(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uids", paramString);
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/im/head.json", locale, parama);
  }
  
  public static void getUserInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    paramString = m.buildUser(paramString);
    k.request(paramContext, q.a, e.s.r, paramString, parama);
  }
  
  public static void getUserInfoList(Context paramContext, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    paramString = m.buildUserInfoList(paramString, paramInt);
    k.requestForUser(paramContext, q.O, p.b.be, paramString, parama);
  }
  
  public static void getUserIsContont(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get("http://kefu.easemob.com/v1/webimplugin/tenant/" + paramString1 + "/visitors/" + paramString2 + "/CurrentServiceSession?techChannelInfo=" + URLEncoder.encode(paramString3)).tag(paramContext).enqueue(parama);
  }
  
  public static void getUserLocations(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", "2");
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/location.json", locale, localHashMap, parama, true);
  }
  
  public static void getUserMatchs(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/recommend.json", locale, parama);
  }
  
  public static void getUserTypeIsNew(Context paramContext, i.a<String> parama, String paramString)
  {
    paramString = m.buildUserTypeIsNew(paramContext, paramString);
    h localh = new h(1, q.j + p.b.aI);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, true, null, parama).request();
  }
  
  public static void getWeekCleanerInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("cleanerId", paramString);
    k.requestClean(paramContext, q.j + p.b.ae, locale, parama);
  }
  
  public static void getYouBackChangeGoodsInfo(Context paramContext, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    k.requestYouPin(paramContext, q.n + e.t.E, localHashMap, paramCallback);
  }
  
  public static void getYouBackOrderDetailsInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("retreatOrderCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.C, localHashMap, paramCallback);
  }
  
  public static void getYouPinAcceptConfirm(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("maintainOrderCode", paramString1);
    localHashMap.put("orderAscription", paramString2);
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    k.requestYouPin(paramContext, q.n + p.f.i, localHashMap, paramCallback);
  }
  
  public static void getYouPinCombinationInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.x, localHashMap, paramCallback);
  }
  
  public static void getYouPinDeliverAreaDesc(Context paramContext, Callback paramCallback)
  {
    k.requestYouPin(paramContext, q.n + e.t.w, null, paramCallback);
  }
  
  public static void getYouPinDeliverDesc(Context paramContext, Callback paramCallback)
  {
    k.requestYouPin(paramContext, q.n + e.t.q, null, paramCallback);
  }
  
  public static void getYouPinOrderDetailsInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("maintainOrderCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.e, localHashMap, paramCallback);
  }
  
  public static void getYouPinShoppingCartInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.D, localHashMap, paramCallback);
  }
  
  public static void getYoupinGoodsList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", paramString1);
    localHashMap.put("categoryClass", paramString2);
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    k.requestYouPin(paramContext, q.n + e.t.v, localHashMap, paramCallback);
  }
  
  public static void getYoupinGuidanceInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageStatus", paramString);
    k.requestYouPin(paramContext, q.n + e.t.s, localHashMap, paramCallback);
  }
  
  public static void getYoupinJumpInfo(Context paramContext, Callback paramCallback)
  {
    k.requestYouPin(paramContext, q.n + e.t.r, null, paramCallback);
  }
  
  public static void getYoupinProducList(Context paramContext, String paramString, Integer paramInteger, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    if (paramString == null)
    {
      localHashMap.put("styleCode", "");
      if (paramInteger != null) {
        break label116;
      }
      localHashMap.put("roomRegion", "");
    }
    for (;;)
    {
      localHashMap.put("page", "1");
      localHashMap.put("pageSize", "1000");
      k.requestYouPin(paramContext, q.n + e.t.b, localHashMap, paramCallback);
      return;
      localHashMap.put("styleCode", paramString);
      break;
      label116:
      localHashMap.put("roomRegion", String.valueOf(paramInteger));
    }
  }
  
  public static void getYoupinProducType(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("parentCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.u, localHashMap, paramCallback);
  }
  
  public static void getYoupinSkuInfo(Context paramContext, String paramString, List<o> paramList, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    localHashMap.put("properties", com.alibaba.fastjson.a.toJSONString(paramList));
    k.requestYouPin(paramContext, q.n + e.t.i, localHashMap, paramCallback);
  }
  
  public static void getZuAddressList(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildZuAddressList(paramContext, paramString);
    h localh = new h(1, q.j + p.b.aW);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, false, null, parama).request();
  }
  
  public static void get_SuggestType(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityId", com.ziroom.ziroomcustomer.base.b.d);
    k.requestJson(paramContext, q.k, p.b.bt, localHashMap, parama);
  }
  
  public static void getreCommendCleaner(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("appointDateTime", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("addressId", paramString5);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    k.requestClean(paramContext, q.j + p.b.bI, locale, parama);
  }
  
  public static void geyGeneralCleanDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestClean(paramContext, q.j + p.b.Q, locale, parama);
  }
  
  public static void mvEstimateCost(String paramString1, String paramString2, Callback paramCallback) {}
  
  public static void phpUploadImg(Context paramContext, Map<String, String> paramMap, File paramFile, com.freelxl.baselibrary.d.c.a parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      paramContext = com.freelxl.baselibrary.d.a.post(q.as + e.d.g).tag(paramContext).addHeader("Accept", "application/json; version=2");
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramContext.addFormDataPart(str, (String)paramMap.get(str));
      }
      paramContext.addFormDataPart("img", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void postBiweeklyCleanAdditionalEval(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("workBillId", paramString1);
    locale.put("userName", paramString3);
    locale.put("remark", paramString4);
    locale.put("satisfyRevisitId", paramString2);
    locale.put("uid", paramString5);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.ax).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void postBiweeklyCleanEval(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanId", paramString1);
    locale.put("remark", paramString2);
    locale.put("score", Integer.valueOf(paramInt));
    locale.put("tags", paramString3);
    locale.put("uid", paramString4);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.aw).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void postBiweeklyCleanModify(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("workBillId", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("hireContractCode", paramString4);
    locale.put("changeDate", paramString5);
    locale.put("linkPhone", paramString6);
    locale.put("linkMan", paramString7);
    locale.put("timePeriod", paramString8);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    com.freelxl.baselibrary.d.a.post(q.j + p.b.ao).tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(parama);
  }
  
  public static void postComplain(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, com.alibaba.fastjson.b paramb, Callback paramCallback)
  {
    e locale = new e();
    locale.put("complainObj", paramString1);
    locale.put("complainType", paramString2);
    locale.put("complainContent", paramString3);
    locale.put("linkPhone", paramString4);
    locale.put("rentContractCode", paramString5);
    locale.put("houseSourceCode", paramString6);
    locale.put("address", paramString7);
    locale.put("customerName", paramString8);
    locale.put("respondent", paramString10);
    locale.put("uid", paramString9);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("pictures", paramb);
    locale.put("source", "01");
    com.freelxl.baselibrary.f.d.d("ServeNewService", "=====postComplain:" + com.alibaba.fastjson.a.toJSON(locale));
    com.freelxl.baselibrary.d.a.post(q.k + p.b.bs).setBodyString(locale.toJSONString()).tag(paramContext).enqueue(paramCallback);
  }
  
  public static void postQuestionnaire(Context paramContext, String paramString, Map<String, Integer> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale1 = new e();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        e locale2 = new e();
        locale2.put("id", localEntry.getKey());
        locale2.put("score", localEntry.getValue());
        localb.add(locale2);
      }
      locale1.put("pointItems", localb);
    }
    locale1.put("workBillId", paramString);
    locale1.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale1.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale1.put("dataSource", Integer.valueOf(12));
    locale1.put("versionNum", "2");
    com.freelxl.baselibrary.d.a.post(q.j + p.b.az).tag(paramContext).params(m.createPostEncodeString(locale1.toJSONString())).enqueue(parama);
  }
  
  public static void refreshSocialZzLive(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    k.requestGateWayService(paramContext, q.o + p.h.j, locale, paramCallback);
  }
  
  public static void requestBedroomAddress(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uname", paramString1);
    locale.put("uid", paramString2);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/loadYouJiaAdressList", locale, paramCallback);
  }
  
  public static void requestCleanCardPay(Context paramContext, String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("terminalType", "android");
    locale.put("terminalVersion", ah.getVersion(paramContext));
    locale.put("orderId", paramString2);
    locale.put("money", Float.valueOf(paramFloat));
    locale.put("uid", paramString1);
    locale.put("payKind", Integer.valueOf(paramInt));
    locale.put("couponId", paramString3);
    locale.put("couponCode", paramString4);
    k.requestClean(paramContext, q.j + p.b.aL, locale, parama);
  }
  
  public static void requestCleanData(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = new e();
    locale.put("serviceInfoId", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("whether", Integer.valueOf(paramInt));
    locale.put("uid", paramString2);
    locale.put("houseCode", paramString3);
    locale.put("billId", paramString4);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/loadDate", locale, paramCallback);
  }
  
  public static void requestCleanTimePoint(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, az paramaz, Callback paramCallback)
  {
    e locale = new e();
    locale.put("whether", Integer.valueOf(paramInt));
    locale.put("uid", paramString1);
    locale.put("appointDate", paramString2);
    locale.put("serviceInfoId", paramString3);
    locale.put("servicePmId", paramString4);
    locale.put("addressId", paramString5);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    if (paramInt == 1)
    {
      locale.put("employeeCode", paramaz.getEmployeeCode());
      locale.put("supplierCode", paramaz.getSupplierCode());
      locale.put("isOccupyTransaction", Integer.valueOf(paramaz.getTransaction()));
      locale.put("transactionStartTime", paramaz.getServiceTransaction());
      locale.put("commonPlaceWorkHour", Integer.valueOf(paramaz.getServiceTime()));
    }
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/loadTimePoint", locale, paramCallback);
  }
  
  public static void requestCreateBedOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt1, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, List<x> paramList, String paramString20, String paramString21, String paramString22, String paramString23, int paramInt2, String paramString24, String paramString25, Callback paramCallback)
  {
    e locale = new e();
    locale.put("address", paramString10);
    locale.put("addressId", paramString9);
    locale.put("appointDate", paramString6);
    locale.put("cityCode", paramString25);
    if (paramList != null) {
      locale.put("goods", com.alibaba.fastjson.a.toJSON(paramList));
    }
    locale.put("linkPhone", paramString14);
    locale.put("price", paramString16);
    locale.put("promoCodeId", paramString15);
    locale.put("remark", paramString12);
    locale.put("serviceInfoId", paramString2);
    locale.put("servicePmId", paramString4);
    locale.put("timePeroidId", paramString7);
    locale.put("uid", paramString1);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("appointTime", paramString20);
    locale.put("channelCode", paramString21);
    locale.put("operatorMan", paramString22);
    locale.put("employeeLogicCode", paramString23);
    locale.put("whether", Integer.valueOf(paramInt2));
    locale.put("workBillId", paramString24);
    locale.put("serviceInfoName", paramString3);
    locale.put("servicePmName", paramString5);
    locale.put("timePeroid", paramString8);
    locale.put("addressXY", paramString11);
    locale.put("dataSource", Integer.valueOf(paramInt1));
    locale.put("linkMan", paramString13);
    locale.put("servicePrice", paramString17);
    locale.put("discountPrice", paramString18);
    locale.put("goodsPrice", paramString19);
    locale.put("version", "V1.4");
    k.requestFluxClean(paramContext, q.j + "/zrk/generalclean/bedroom/appointment", locale, paramCallback);
  }
  
  public static void requestDeleteCleanAddress(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("fid", paramString1);
    locale.put("uid", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", ah.getAppVersion(paramContext));
    k.requestClean(paramContext, q.j + p.b.bR, locale, parama);
  }
  
  public static void requestGetUserInfo(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("be_uid", paramString);
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/info.json", locale, parama);
  }
  
  public static void requestIsHaveGoingOrder(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("uid", paramString);
    k.requestGateWayService(paramContext, q.o + "smsApi/zrk/move/customerOrder/findGoingOrderList", locale, parama);
  }
  
  public static void requestIsHaveNoPay(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("interfaceVesion", Integer.valueOf(1));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayService(paramContext, q.o + "smsApi/zrk/move/customerOrder/noPayOrderList", locale, parama);
  }
  
  public static void requestIsUserInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    locale.put("uid", paramString);
    locale.put("clientCode", ah.getDeviceId(paramContext));
    k.requestClean(paramContext, q.j + p.b.aI, locale, parama);
  }
  
  public static void requestJudgePublicArea(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("uname", paramString2);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("houseCode", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "V1.0");
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/judgePublicArea", locale, paramCallback);
  }
  
  public static void requestLeftCardMoney(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("uid", paramString1);
    locale.put("serviceType", paramString2);
    locale.put("clientCode", ah.getDeviceId(ApplicationEx.c));
    k.requestClean(paramContext, q.j + p.b.aM, locale, parama);
  }
  
  public static void requestModifyBedroomPhone(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    e locale = new e();
    locale.put("fid", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("linkPhone", paramString2);
    locale.put("userId", paramString3);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/commonAdress/update", locale, paramCallback);
  }
  
  public static void requestMoveRecEntrance(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/display/move/products/recommend", locale, parama);
  }
  
  public static void requestMoveRecResult(Context paramContext, List<MoveRecResultRequestModel> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    if (paramList != null) {
      locale.put("itemContentList", com.alibaba.fastjson.a.toJSON(paramList));
    }
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/recommendProduct", locale, parama);
  }
  
  public static void requestMoveRecSub(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/getRecommendItem", locale, parama);
  }
  
  public static void requestPeriodToUrl(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("mobile", paramString);
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/promotion/outer/clean/week", locale, paramCallback);
  }
  
  public static void requestPublicAreaChange(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uname", paramString2);
    locale.put("uid", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("whether", Integer.valueOf(paramInt));
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("houseCode", paramString3);
    locale.put("serviceTime", paramString4);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/publicAreaChange", locale, paramCallback);
  }
  
  public static void requestServiceItem(Context paramContext, String paramString1, int paramInt, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("productCode", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("whether", Integer.valueOf(paramInt));
    locale.put("uid", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/loadServiceItem", locale, paramCallback);
  }
  
  public static void requestServicePageDynamicContent(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    k.requestGateWayInterface(paramContext, q.o + "cleanApi/zrk/home/1/dynamic", locale, paramCallback);
  }
  
  public static void requestServicePageReceiveCoupon(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("mobile", paramString);
    k.requestGateWayInterface(paramContext, q.o + "cleanApi/zrk/home/1/receive", locale, paramCallback);
  }
  
  public static void requestServicePageStaticContent(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayInterface(paramContext, q.o + "cleanApi/zrk/home/1/static", locale, paramCallback);
  }
  
  public static void requestServicePageSupport(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestGateWayInterface(paramContext, q.o + "cleanApi/zrk/home/1/support", locale, paramCallback);
  }
  
  public static void requestServicePayment(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("billId", paramString2);
    locale.put("payKind", Integer.valueOf(paramInt2));
    locale.put("money", Long.valueOf(paramLong));
    locale.put("draweeType", Integer.valueOf(paramInt1));
    locale.put("couponId", paramString3);
    locale.put("couponCode", paramString4);
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/receipt/pay", locale, paramCallback, true);
  }
  
  public static void requestTimeCompletion(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, Callback paramCallback)
  {
    e locale = new e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("uname", paramString2);
    locale.put("uid", paramString1);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("whether", Integer.valueOf(paramInt1));
    locale.put("bedroomCleanDateTime", paramString3);
    locale.put("bedroomCleanServiceTime", paramString4);
    locale.put("zrkCleanServiceTime", Integer.valueOf(paramInt2));
    if (!TextUtils.isEmpty(paramString5)) {
      locale.put("employeeCode", paramString5);
    }
    locale.put("houseCode", paramString6);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/bedroom/completionOperation", locale, paramCallback);
  }
  
  public static void requestYouPinGroupList(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString1);
    localHashMap.put("productCode", paramString2);
    k.requestYouPin(paramContext, q.n + e.t.x, localHashMap, paramCallback);
  }
  
  public static void requestYouPinGroupPropertyList(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.z, localHashMap, paramCallback);
  }
  
  public static void requestYouPinPromise(Context paramContext, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    k.requestYouPin(paramContext, q.n + e.t.y, localHashMap, paramCallback);
  }
  
  public static void saveGenerCleanerEval(Context paramContext, String paramString1, float paramFloat, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<String> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("feedback", paramString1);
    locale.put("score", Float.valueOf(paramFloat));
    locale.put("uid", paramString2);
    locale.put("orderId", paramString3);
    locale.put("evaPosiLabel", paramString4);
    locale.put("evaNegaLabel", paramString5);
    locale.put("userPhone", paramString6);
    if ((paramList != null) && (paramList.size() > 0)) {
      locale.put("imageUrlList", com.alibaba.fastjson.a.toJSON(paramList));
    }
    k.requestClean(paramContext, q.j + p.b.ai, locale, parama);
  }
  
  public static void saveGeneralCleanQuestion(Context paramContext, List<ab> paramList, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("pointItems", paramList);
    locale.put("workBillId", paramString);
    k.requestClean(paramContext, q.j + p.b.bQ, locale, parama);
  }
  
  public static void saveQuestion(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new h(1, q.k + p.b.bc + "/" + paramString), false, null, parama).request();
  }
  
  public static void saveQuestion_2(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("questionType", "INVALID");
    localHashMap.put("userUniqueKey", paramString2);
    com.freelxl.baselibrary.f.d.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.freelxl.baselibrary.d.a.post(q.k + p.b.bl + "/" + paramString1 + "/type").tag(paramContext).params(localHashMap).enqueue(paramCallback);
  }
  
  public static void saveSmallMoveEval(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    if ((paramMap1 != null) && (paramMap1.size() > 0)) {
      locale.put("evaluatePositiveTag", paramMap1);
    }
    if ((paramMap2 != null) && (paramMap2.size() > 0)) {
      locale.put("evaluateNegativeTag", paramMap2);
    }
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      locale.put("content", paramString4);
    }
    locale.put("userId", paramString1);
    locale.put("workOrderId", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("scroe", paramString3);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("evaluateSource", Integer.valueOf(12));
    k.requestClean(paramContext, q.j + p.d.e, locale, parama);
  }
  
  public static void saveSocialZzFilter(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = new e();
    locale.put("gender", paramString1);
    locale.put("age", paramString2);
    k.requestGateWayService(paramContext, q.o + p.h.h, locale, paramCallback);
  }
  
  public static void saveUserCollects(Activity paramActivity, String paramString, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("be_uid", paramString);
    locale.put("type", Integer.valueOf(paramInt1));
    locale.put("round", Integer.valueOf(paramInt2));
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/setting/collect.json", locale, parama);
  }
  
  public static void saveUserHomeInfo(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("photos", paramString1);
    locale.put("description", paramString2);
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/save-home.json", locale, parama);
  }
  
  public static void saveUserInfo(Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8, String paramString9, int paramInt3, String paramString10, int paramInt4, String paramString11, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("nick_name", paramString1);
    locale.put("birthday", paramString2);
    locale.put("gender", Integer.valueOf(paramInt1));
    locale.put("city", paramString3);
    locale.put("bizcircle", paramString4);
    locale.put("head_img", paramString5);
    locale.put("description", paramString6);
    locale.put("industry_id", Integer.valueOf(paramInt2));
    locale.put("industry", paramString7);
    locale.put("company", paramString8);
    locale.put("company_short", paramString9);
    locale.put("company_id", Integer.valueOf(paramInt3));
    locale.put("direction", paramString10);
    locale.put("direction_id", Integer.valueOf(paramInt4));
    locale.put("tags", paramString11);
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/save.json", locale, parama);
  }
  
  public static void saveUserPhotos(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("photos", paramString);
    k.requestGateWayService(paramActivity, q.o + "kaleidoApi/meet/user/save-photos.json", locale, parama);
  }
  
  public static void searchQuestionByText(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fuzzyName", paramString);
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("pageSize", paramInt + "");
    localHashMap.put("pageNumber", "0");
    localHashMap.put("hotspot", "1");
    com.freelxl.baselibrary.d.a.post(q.k + p.b.bz).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void selectCleanerList(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildselectCleanerList(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    paramString2 = new h(1, q.j + p.b.aY);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void selectMyCleanerList(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildselectCleanerList(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    paramString2 = new h(1, q.j + p.b.bf);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, false, null, parama).request();
  }
  
  public static void selectNearCleanerList(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, i.a<String> parama, boolean paramBoolean)
  {
    paramString1 = m.buildselectCleanerList(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    paramString2 = new h(1, q.j + p.b.bg);
    paramString2.setParams(paramString1);
    new com.freelxl.baselibrary.e.d(paramContext, paramString2, true, null, parama).request();
  }
  
  public static void setForCleanReminder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Callback paramCallback)
  {
    e locale = new e();
    locale.put("orderId", paramString1);
    locale.put("uid", paramString2);
    locale.put("customerMobileTel", paramString3);
    locale.put("roomNum", paramString4);
    locale.put("remark", paramString3);
    locale.put("customerName", paramString5);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/monthCleanExclusive/hurry", locale, paramCallback);
  }
  
  public static void setGeneralCleanCardPay(Context paramContext, String paramString1, String paramString2, float paramFloat, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("terminalType", "android");
    locale.put("terminalVersion", ah.getVersion(paramContext));
    locale.put("orderId", paramString2);
    locale.put("money", Float.valueOf(paramFloat));
    locale.put("uid", paramString1);
    k.requestClean(paramContext, q.j + p.b.aL, locale, parama);
  }
  
  public static void setMoveOrderCancle(Context paramContext, Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    if (paramMap.size() > 0) {
      locale.put("cancelTag", paramMap);
    }
    if (paramString1.length() > 0) {
      locale.put("cancelRemark", paramString1);
    }
    locale.put("cancelerId", paramString2);
    locale.put("workOrderId", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    k.requestClean(paramContext, q.j + p.d.d, locale, parama);
  }
  
  public static void setMoveReminder(Context paramContext, String paramString, Callback paramCallback)
  {
    e locale = new e();
    locale.put("orderCode", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("dataSource", Integer.valueOf(12));
    k.requestGateWayCommonService(paramContext, q.o + "smsApi/zrk/move/customerOrder/reminderOrder", locale, paramCallback);
  }
  
  public static void setOrderFinish(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uid", paramString2);
    k.requestOkService(paramContext, q.l + "zrk/move/customerOrder/acceptOrder", locale, paramCallback);
  }
  
  public static void setPeriodCoupon(Context paramContext, int paramInt, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("serviceType", Integer.valueOf(paramInt));
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("uid", paramString);
    locale.put("version", "5.6.0");
    k.requestClean(paramContext, q.j + p.b.bF, locale, parama);
  }
  
  public static void setServiceZeroPay(Context paramContext, String paramString1, String paramString2, int paramInt, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("uid", paramString1);
    locale.put("billId", paramString2);
    locale.put("payKind", Integer.valueOf(paramInt));
    k.requestOkService(paramContext, q.j + p.b.bx, locale, paramCallback);
  }
  
  public static void setSocialZzAble(Context paramContext, int paramInt, Callback paramCallback)
  {
    e locale = new e();
    locale.put("type", Integer.valueOf(paramInt));
    k.requestGateWayService(paramContext, q.o + p.h.i, locale, paramCallback);
  }
  
  public static void setSocialZzComplain(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    e locale = new e();
    locale.put("be_uid", paramString);
    locale.put("type", Integer.valueOf(paramInt));
    k.requestGateWayService(paramContext, q.o + p.h.d, locale, paramCallback);
  }
  
  public static void setSocialZzFilter(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    k.requestGateWayService(paramContext, q.o + p.h.g, locale, paramCallback);
  }
  
  public static void setSocialZzFreeze(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    e locale = new e();
    locale.put("be_uid", paramString);
    locale.put("type", Integer.valueOf(paramInt));
    k.requestGateWayService(paramContext, q.o + p.h.e, locale, paramCallback);
  }
  
  public static void setSocialZzShieldState(Context paramContext, String paramString, int paramInt, Callback paramCallback)
  {
    e locale = new e();
    locale.put("be_uid", paramString);
    locale.put("type", Integer.valueOf(paramInt));
    k.requestGateWayService(paramContext, q.o + p.h.c, locale, paramCallback);
  }
  
  public static void setSocialZzUnFreeze(Context paramContext, Callback paramCallback)
  {
    e locale = new e();
    locale.put("form", "zzchat");
    k.requestGateWayService(paramContext, q.o + p.h.f, locale, paramCallback);
  }
  
  public static void submitForCleaningTime(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = new e();
    locale.put("workbillId", paramString1);
    locale.put("appointDate", paramString4);
    locale.put("optorMan", paramString2);
    locale.put("optorPhone", paramString3);
    locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    k.requestGateWayCommonService(paramContext, q.o + p.b.bV, locale, paramCallback);
  }
  
  public static void submitMovingEval(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, List<String> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uname", paramString2);
    locale.put("evaluationScore", Integer.valueOf(paramInt));
    locale.put("evaluationContent", paramString3);
    locale.put("uid", paramString4);
    locale.put("userPhone", paramString5);
    if ((paramList != null) && (paramList.size() > 0)) {
      locale.put("imageUrlList", com.alibaba.fastjson.a.toJSON(paramList));
    }
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/orderEvaluateCommit", locale, parama);
  }
  
  public static void submitMvCancleReason(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("cancelContent", paramString2);
    locale.put("uid", paramString3);
    k.requestClean(paramContext, q.l + "zrk/move/customerOrder/cancelOrder", locale, parama);
  }
  
  public static void suggest_commit(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.alibaba.fastjson.b paramb, com.freelxl.baselibrary.d.c.a parama)
  {
    paramString1 = m.buildSuggestCommit(paramString1, paramString2, paramString3, paramString4, paramString5, paramb);
    k.requestJsonOBJ(paramContext, q.k, p.b.bu, paramString1, parama);
  }
  
  public static void upLoadQuestionNoHelp(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("evaluateType", paramString2);
    localHashMap.put("userUniqueKey", paramString3);
    com.freelxl.baselibrary.d.a.post(q.k + "knowledge-repository/knowledge/" + paramString1 + "/evaluation").tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
  }
  
  public static void upLoadQuestionNoHelpReason(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("evaluateType", paramString2);
    localHashMap.put("uselessCase", paramString3);
    if (paramInt == 0) {}
    for (paramString2 = "FALSE";; paramString2 = "TRUE")
    {
      localHashMap.put("isJump", paramString2);
      com.freelxl.baselibrary.d.a.put(q.k + p.b.bD + paramString1).tag(paramContext).params(localHashMap).setBodyString(com.alibaba.fastjson.a.toJSONString(localHashMap)).enqueue(paramCallback);
      return;
    }
  }
  
  public static void updateMvAddress(Context paramContext, String paramString1, String paramString2, String paramString3, Address paramAddress1, Address paramAddress2, int paramInt, Callback paramCallback)
  {
    e locale = new e();
    locale.put("appointmentAddress", paramAddress1);
    locale.put("targetAddress", paramAddress2);
    locale.put("distance", Integer.valueOf(paramInt));
    paramAddress1 = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    paramAddress1.put("productCode", paramString1);
    paramAddress1.put("uid", paramString2);
    paramAddress1.put("userToken", paramString3);
    paramAddress1.put("appointmentAddressDO", locale);
    paramAddress1.put("updateType", Integer.valueOf(2));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(paramAddress1.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvCoupon(Context paramContext, String paramString1, String paramString2, String paramString3, com.alibaba.fastjson.b paramb, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("couponDOs", paramb);
    locale.put("updateType", Integer.valueOf(5));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvGoods(Context paramContext, String paramString1, String paramString2, String paramString3, com.alibaba.fastjson.b paramb, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("materialsDOs", paramb);
    locale.put("updateType", Integer.valueOf(4));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvPhone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("connectPhone", paramString4);
    locale.put("updateType", Integer.valueOf(7));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvRequirement(Context paramContext, String paramString1, String paramString2, String paramString3, e parame, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("specialNeedDO", parame);
    locale.put("updateType", Integer.valueOf(6));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvService(Context paramContext, String paramString1, String paramString2, String paramString3, com.alibaba.fastjson.b paramb, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("serviceItemDOs", paramb);
    locale.put("updateType", Integer.valueOf(3));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void updateMvTime(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Callback paramCallback)
  {
    e locale = com.ziroom.ziroomcustomer.newServiceList.utils.f.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("appointmentDate", Long.valueOf(paramLong1));
    locale.put("appointmentTime", Long.valueOf(paramLong2));
    locale.put("updateType", Integer.valueOf(1));
    com.freelxl.baselibrary.d.a.post(q.l + "zrk/move/customerOrder/updateShoppingCartInfo").tag(paramContext).params(m.createPostEncodeString(locale.toJSONString())).enqueue(paramCallback);
  }
  
  public static void uploadImage(Context paramContext, File paramFile, com.freelxl.baselibrary.d.c.a parama)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("jjj", "fhgh");
      localObject = g.getPassportSign((Map)localObject);
      paramContext = com.freelxl.baselibrary.d.a.post("https://smsapis.ziroom.com/zrk/file/upload").tag(paramContext).addHeader("Accept", "application/json; version=1");
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramContext.addFormDataPart(str, (String)((Map)localObject).get(str));
      }
      paramContext.addFormDataPart("file", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath());
      paramContext.enqueue(parama);
    }
  }
  
  public static void uploadImg(Context paramContext, File paramFile, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(q.j + p.g.g).tag(paramContext).setWriteTimeOut(10).addFormDataPart("iosImage", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath()).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */