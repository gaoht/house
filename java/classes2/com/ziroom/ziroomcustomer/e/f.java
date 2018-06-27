package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f
{
  public static l logout(String paramString1, String paramString2)
  {
    return h.parselogout(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.s.b, new Object[] { paramString1, paramString2 })));
  }
  
  public static l requesLoginMessage(String paramString1, String paramString2)
  {
    return null;
  }
  
  public static l requestBizcircleList(String paramString1, String paramString2)
  {
    paramString1 = g.buildBizcircleList(paramString1, paramString2);
    return h.parseBizcircleList(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.b.b, paramString1));
  }
  
  public static l requestChangePsw(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildChangPwd(paramString1, paramString3, paramString2);
    return h.parseResetPsw(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.s.c, new Object[] { paramString1 })));
  }
  
  public static l requestCheckHasEvaluate(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramContext = g.buildCheckHasEvaluate(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    return h.parseCheckHasEvaluate(com.ziroom.ziroomcustomer.util.q.httpPost(q.r + e.b.y, paramContext));
  }
  
  public static l requestContract(String paramString)
  {
    paramString = ah.encodeGetParams(g.buildGetContract(paramString));
    paramString = com.ziroom.ziroomcustomer.util.q.httpGet(q.s + e.e.f + "?" + paramString);
    d.d("sdjgkldsjgk", "=======  " + paramString);
    return h.parseGetContract(paramString);
  }
  
  public static l requestContractCodeState(String paramString)
  {
    paramString = g.buildContractCodeState(paramString);
    return h.parseContractCodeState(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.M, paramString));
  }
  
  public static l requestContractExtension(String paramString)
  {
    paramString = g.buildContractExtension(paramString);
    return h.parseContractExtension(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.K, paramString));
  }
  
  public static l requestContractSummary(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = g.buildContractSummary(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    paramString1.remove("sign");
    g.appendCommenParams(paramString1);
    return h.parseContractSummary(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.P, paramString1));
  }
  
  public static l requestEvaluateAppoint(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("orderCode", paramString2);
    localHashMap.put("isComplete", Integer.valueOf(paramInt1));
    localHashMap.put("score", Integer.valueOf(paramInt2));
    localHashMap.put("remark", paramString3);
    localHashMap.put("tokenId", paramString4);
    localHashMap.put("evaluateMsg", paramString5);
    g.appendCommenParams(localHashMap);
    return h.parseEvaluateAppoint(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.h.B, localHashMap));
  }
  
  public static l requestExtendData()
  {
    Map localMap = g.getHouseSign(new HashMap());
    return h.parseExtendData(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.n.N, new Object[] { localMap.get("uid"), localMap.get("sign"), localMap.get("timestamp") })));
  }
  
  public static l requestFlatGuideList()
  {
    return h.parseGuideList(com.ziroom.ziroomcustomer.util.q.httpGet(q.a + e.h.j));
  }
  
  public static l requestForChangePsw(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildChangePswByCode(paramString1, paramString2, paramString3);
    return h.parseChangePswByCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.t, paramString1));
  }
  
  public static void requestForErrorLog(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = g.buildErrorLog(paramString1, paramString2, paramContext);
    com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.I, paramString1);
  }
  
  public static l requestForGetRaConfig()
  {
    HashMap localHashMap = new HashMap();
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    localHashMap.put("uid", str);
    g.appendCommenParams(localHashMap);
    return h.parseGetRaConfig(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.F, localHashMap));
  }
  
  public static l requestForPayPartState(String paramString)
  {
    paramString = g.buildPayPartStateList(paramString);
    return h.parsePayPartStateInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.n.x, paramString));
  }
  
  public static l requestForSetIsSharer(String paramString1, String paramString2)
  {
    paramString1 = g.buildSetShareInformationList(paramString1, paramString2);
    return h.parseSetIsShareInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.C, paramString1));
  }
  
  public static l requestForSetShareInfromation(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = g.buildSetShareInformationList(paramString1, paramString2, paramInt1, paramString3, paramInt2, paramString4, paramString5, paramString6);
    return h.parseSetShareInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.v, paramString1));
  }
  
  public static l requestForShareInfromation(String paramString)
  {
    paramString = g.buildShareInformationList(paramString);
    return h.parseShareInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.u, paramString));
  }
  
  public static l requestForSignature(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = g.buildgetRaSignature(paramString2, paramString3, paramString4, paramString1, paramString5, paramString6);
    return h.parseSignature(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.H, paramString1));
  }
  
  public static l requestForTurnSignature(String paramString)
  {
    paramString = g.buildgetRaTurnSignature(paramString);
    return h.parseSignature(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.r.c, paramString));
  }
  
  public static l requestForWYPayState(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildPayWYStateList(paramString1, paramString2, paramString3);
    return h.parsePayStateWYInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.E, paramString1));
  }
  
  public static l requestForgetRaSignInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = g.buildgetRaSignInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
    return h.parseGetRaSignInfo(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.G, paramString1));
  }
  
  public static l requestGetAlternateList(String paramString)
  {
    paramString = g.getHouseSign(new HashMap());
    return h.parseGetAlternateList(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.v, paramString));
  }
  
  public static l requestGetEvaluateProblems(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = g.buildGetEvaluateProblems(paramContext, paramString1, paramString2, paramString3);
    return h.parseGetEvaluateProblems(com.ziroom.ziroomcustomer.util.q.httpPost(q.r + e.b.w, paramContext));
  }
  
  public static l requestGetImgUrl(String paramString)
  {
    l locall = new l();
    locall.setObject(Boolean.valueOf(com.ziroom.ziroomcustomer.util.q.httpGetImg(paramString)));
    locall.setSuccess(Boolean.valueOf(true));
    return locall;
  }
  
  public static l requestGetRentAgentCode(Context paramContext, String paramString)
  {
    paramContext = g.buildGetRentAgentCode(paramContext, paramString);
    return h.parseGetRentAgentCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.h.n, paramContext));
  }
  
  public static l requestGetRentCards(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString = g.buildNotPaybadgeUrl();
    return h.parseGetRentCards(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.j.a, paramString));
  }
  
  public static l requestGetTurnSignStyle(Context paramContext)
  {
    paramContext = (HashMap)g.getTurnSign();
    return h.parseGetTurnSign(com.ziroom.ziroomcustomer.util.q.httpGet(q.u + e.r.a + "?uid=" + paramContext.get("uid") + "&who=" + paramContext.get("who") + "&Client-Type=" + paramContext.get("Client-Type")));
  }
  
  public static l requestGetTurnSignText(Context paramContext)
  {
    paramContext = (HashMap)g.buildTurnSignText();
    return h.parseGetTurnText(com.ziroom.ziroomcustomer.util.q.httpGet(q.u + e.r.f + "?uid=" + paramContext.get("uid") + "&who=" + paramContext.get("who")));
  }
  
  public static l requestHouseDetail(SearchCondition paramSearchCondition, int paramInt1, int paramInt2, String paramString)
  {
    paramSearchCondition = g.buildHouseCondition(paramSearchCondition, paramInt1, paramInt2, paramString);
    return h.parseHouseCondition(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.b.t, paramSearchCondition));
  }
  
  public static l requestHouseStatus(String paramString)
  {
    paramString = g.buildSundHouseStatus(paramString);
    return h.parsePayStatus(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.n.B, paramString));
  }
  
  public static l requestHouseType(String paramString)
  {
    paramString = g.buildSundHouseType(paramString);
    return h.parsePayType(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.n.A, paramString));
  }
  
  public static l requestIndex()
  {
    Map localMap = g.buildIndex();
    return h.parseIndex(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.h.l, localMap));
  }
  
  public static l requestLease(String paramString, int paramInt)
  {
    l locall = null;
    Map localMap = g.buildLease(paramInt);
    localMap.remove("sign");
    g.appendCommenParams(localMap);
    if ("1".equals(paramString)) {
      locall = h.parseLeaseList(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.b, localMap));
    }
    while (!"0".equals(paramString)) {
      return locall;
    }
    return h.parseLeaseList(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.a, localMap));
  }
  
  public static l requestLeaseInfo(String paramString1, String paramString2)
  {
    paramString1 = g.buildLeaseInfo(paramString1, paramString2);
    return h.parseLease(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.c, paramString1));
  }
  
  public static l requestLeaseMyData(String paramString)
  {
    paramString = g.buildLeaseMyData(paramString);
    g.appendCommenParams(paramString);
    return h.parseLeaseMyData(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.g, paramString));
  }
  
  public static l requestLifeActivityData()
  {
    Object localObject = g.getLifeSign(new HashMap());
    localObject = com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.f.b, (Map)localObject);
    u.e("wode2", (String)localObject);
    return h.parseLifeActivityData((String)localObject);
  }
  
  public static l requestLifeBannerData()
  {
    Object localObject = g.getLifeSign(new HashMap());
    localObject = com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.f.a, (Map)localObject);
    u.e("wode1", (String)localObject);
    return h.parseLifeBannerData((String)localObject);
  }
  
  public static l requestLifeDetailsData(String paramString, Context paramContext)
  {
    paramContext = g.getLifeSign(new HashMap());
    paramContext.put("activity_id", paramString);
    return h.parseLifeDetailsData(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.f.c, paramContext));
  }
  
  public static l requestLogin(String paramString1, String paramString2)
  {
    paramString1 = g.buildLogin(paramString1, paramString2);
    return h.parseLogin(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.s.a, new Object[] { paramString1 })));
  }
  
  public static l requestLoginByCode(String paramString1, String paramString2)
  {
    paramString1 = g.buildLoginByCode(paramString1, paramString2);
    return h.parseLoginByCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.o, paramString1));
  }
  
  public static l requestLoginCode(String paramString)
  {
    paramString = g.buildLoginCode(paramString);
    return h.parseLoginCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.l, paramString));
  }
  
  public static l requestMakeOrder(int paramInt1, int paramInt2, int paramInt3, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    String str;
    if ((paramList != null) && (paramList.size() > 0))
    {
      str = "";
      int i = 0;
      if (i < paramList.size())
      {
        if (i == 0) {}
        for (str = (String)paramList.get(0);; str = str + "," + (String)paramList.get(i))
        {
          i += 1;
          break;
        }
      }
    }
    for (;;)
    {
      paramString1 = g.getMakeOrcer(paramInt1, paramInt2, paramInt3, paramString1, str, paramString2, paramString3, paramString4, paramString5, paramString6);
      u.e("url ======", " ===========" + paramString1);
      return h.parseOldMakeOrder(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.d, paramString1), "0");
      str = "";
    }
  }
  
  public static l requestModifyContractState(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = g.buildModifyContractState(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString1.remove("sign");
    g.appendCommenParams(paramString1);
    return h.parseModifyContractState(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.O, paramString1));
  }
  
  public static l requestNewForWYPayState(String paramString)
  {
    paramString = g.buildNewPayWYStateList(paramString);
    return h.parsePayStateWYInformation(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.E, paramString));
  }
  
  public static l requestNewLogin(String paramString1, String paramString2)
  {
    paramString1 = g.buildNewLogin(paramString1, paramString2);
    return h.parseNewLogin(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.q, paramString1));
  }
  
  public static l requestNotPay()
  {
    Map localMap = g.buildNotPay();
    return h.parseNotPayEntity(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.j.b, localMap));
  }
  
  public static l requestPayContract(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat1, float paramFloat2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramContext = g.buildPayContract(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat1, paramFloat2, paramString6, paramString7, paramString8, paramString9, paramString10);
    if ("0".equals(paramString6))
    {
      g.appendCommenParams(paramContext);
      return h.parsePayContractJava(com.ziroom.ziroomcustomer.util.q.httpPost(q.t + e.n.o, paramContext));
    }
    return h.parsePayContractPhp(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.n, paramContext));
  }
  
  public static l requestPayData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = g.buildPayData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    if ("0".equals(paramString4)) {
      g.appendCommenParams(paramString1);
    }
    for (paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.e, paramString1);; paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.d, paramString1)) {
      return h.parsePayData(paramString1, paramString4);
    }
  }
  
  public static l requestPayDetailInfo(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = g.buildPayDetailInfo(paramString1, paramString2, paramInt);
    paramString1.remove("sign");
    g.appendCommenParams(paramString1);
    return h.parsePayDetailInfo(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.h, paramString1));
  }
  
  public static l requestPayDetails(String paramString)
  {
    paramString = g.buildPayDetails(paramString);
    paramString.remove("sign");
    g.appendCommenParams(paramString);
    return h.parsePayDetails(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.l, paramString));
  }
  
  public static l requestPayKims(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = g.buildPayKims(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    paramString1.remove("sign");
    if ("0".equals(paramString5)) {
      g.appendCommenParams(paramString1);
    }
    for (paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.k, paramString1);; paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.n.j, paramString1)) {
      return h.parsePayKims(paramString1);
    }
  }
  
  public static l requestPayServiceData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = g.buildPayServiceData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    if ("0".equals(paramString4)) {
      g.appendCommenParams(paramString1);
    }
    for (paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.i, paramString1);; paramString1 = com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.h, paramString1)) {
      return h.parsePayServiceData(paramString1);
    }
  }
  
  public static l requestPenaltyPay(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = g.buildPenaltySubmitOrderApp(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    return h.parseMakeOrder(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.e.j, paramString1), "0");
  }
  
  public static l requestPutEvaluateContent(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = g.buildPutEvaluateContent(paramContext, paramString1, paramString2);
    return h.parseGetEvaluateProblems(com.ziroom.ziroomcustomer.util.q.httpPost(q.r + e.b.x, paramContext));
  }
  
  public static l requestRegister(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_name", paramString1);
    localHashMap.put("password", paramString2);
    localHashMap.put("body", paramString3);
    return h.parseRegister(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.e, localHashMap));
  }
  
  public static l requestRegisterByCode(String paramString1, String paramString2)
  {
    paramString1 = g.buildRegisterByCode(paramString1, paramString2);
    return h.parseRegisterByCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.n, paramString1));
  }
  
  public static l requestRegisterCode(String paramString)
  {
    paramString = g.buildRegisterCode(paramString);
    return h.parseRegisterCode(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.m, paramString));
  }
  
  public static l requestRemoveAlternateList(List<AlternateListing> paramList)
  {
    paramList = g.buildRemoveAlternateList(paramList);
    return h.parseRemoveAlternateList(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.w, paramList));
  }
  
  public static l requestResetPsw(String paramString1, String paramString2)
  {
    return h.parseResetPsw(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.s.g, new Object[] { paramString1, paramString2 })));
  }
  
  public static l requestSaveAlternateList(List<AlternateListing> paramList)
  {
    paramList = g.buildSaveAlternateList(paramList);
    return h.parseSignature(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.u, paramList));
  }
  
  public static l requestSetTurnSignStyle(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = (HashMap)g.setTurnSign(paramString1, paramString2);
    return h.parseSetTurnSign(com.ziroom.ziroomcustomer.util.q.httpPost(q.u + e.r.a, paramContext));
  }
  
  public static l requestSignInfo()
  {
    Map localMap = g.buildUid();
    return h.parseSignInfo(com.ziroom.ziroomcustomer.util.q.httpGet(String.format(q.a + e.n.p, new Object[] { localMap.get("uid"), localMap.get("sign"), localMap.get("timestamp") })));
  }
  
  public static l requestSignedMakeOrder(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, int paramInt3, int paramInt4, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    paramString1 = g.buildPayment(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramInt2, paramString7, paramInt3, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14);
    g.appendCommenParams(paramString1);
    return h.parseMakeOrder(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.j.e, paramString1), "1");
  }
  
  public static l requestSundHandleConfirm(String paramString1, String paramString2)
  {
    paramString1 = g.buildSundHandleConfirm(paramString1, paramString2);
    return h.parseSundHandleConfirm(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.z, paramString1), paramString2);
  }
  
  public static l requestSundHandleList(String paramString)
  {
    paramString = g.buildSundHandleList(paramString);
    return h.parseSundHandleList(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.y, paramString));
  }
  
  public static l requestTenancyInfo(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildTenancyInfo(paramString1, paramString2, paramString3);
    paramString1.remove("sign");
    g.appendCommenParams(paramString1);
    return h.parseTenancyInfo(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.s, paramString1));
  }
  
  public static l requestTerms(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = g.buildTerms(paramString1, paramString3, paramString2, paramString4, paramString5);
    return h.parseTerms(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.a, paramString1));
  }
  
  public static l requestText()
  {
    return h.parseText(com.ziroom.ziroomcustomer.util.q.httpGet(q.s + e.r.e));
  }
  
  public static l requestThreeUserInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("head_img", paramString3);
    localHashMap.put("nickname", paramString4);
    return h.parseThreeUserInfo(com.ziroom.ziroomcustomer.util.q.httpPost(q.x + e.s.s, localHashMap));
  }
  
  public static l requestToSeeStatu(String paramString)
  {
    paramString = g.buildToSeeStatu(paramString);
    return h.parseToSeeStatu(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.p, paramString));
  }
  
  public static l requestTurnForgetRaSignInfo(String paramString)
  {
    paramString = g.buildgetTurnRaSignInfo(paramString);
    return h.parseGetTurnRaSignInfo(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.r.b, paramString));
  }
  
  public static l requestTurnSignTerms(String paramString)
  {
    paramString = g.buildTurnSignTerms(paramString);
    return h.parseTerms(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.r.d, paramString));
  }
  
  public static l requestUpdateTenancy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramString1 = g.buildUpdateTenancy(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt);
    return h.parseUpdateTenancy(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.n.t, paramString1));
  }
  
  public static l requestUploadHeadImage(String paramString, byte[] paramArrayOfByte)
  {
    return h.parseUploadHeadImg(com.ziroom.ziroomcustomer.util.q.httpUploadTo(q.a + e.d.b, paramArrayOfByte, paramString));
  }
  
  public static l requestUserGuest()
  {
    Map localMap = g.buildIndex();
    return h.parseIndex(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.h.x, localMap));
  }
  
  public static l requestUserInfo(String paramString)
  {
    paramString = g.buildUserInfo(paramString);
    return h.parseLogin(com.ziroom.ziroomcustomer.util.q.httpPost(q.a + e.s.r, paramString));
  }
  
  public static l requestatutoCode(String paramString)
  {
    return h.parseAutoCode(com.ziroom.ziroomcustomer.util.q.httpPost(String.format(q.a + e.s.x, new Object[] { paramString }), null));
  }
  
  public static l requetInitiateAppoint(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("userName", paramString2);
    localHashMap.put("userPhone", paramString3);
    localHashMap.put("houseId", paramString4);
    localHashMap.put("houseCode", paramString5);
    localHashMap.put("houseType", Integer.valueOf(paramInt));
    localHashMap.put("villageId", paramString6);
    localHashMap.put("prepareSoruce", Integer.valueOf(0));
    localHashMap.put("expectTime", paramString7);
    localHashMap.put("msgToKeeper", paramString8);
    localHashMap.put("gender", paramString9);
    g.appendCommenParams(localHashMap);
    return h.parseInitiateAppoint(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.h.A, localHashMap));
  }
  
  public static l setPayWay(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    paramString1 = g.buildSetPayWay(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramInt3, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
    g.appendCommenParams(paramString1);
    return h.parseSetPayWay(com.ziroom.ziroomcustomer.util.q.httpPost(q.s + e.n.b, paramString1));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */