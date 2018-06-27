package com.ziroom.ziroomcustomer.payment.d;

import android.app.Activity;
import android.util.Log;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.payment.b.k;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.Map;

public class b
{
  public static void SearchPayStatic(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", paramString);
    localHashMap.put("payChanel", Integer.valueOf(paramInt));
    h.request(paramActivity, "/api/pay/queryState", localHashMap, parama);
  }
  
  public static void getGifListResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(8));
    h.request(paramActivity, com.ziroom.ziroomcustomer.payment.c.a.b, "/api/invoke", localHashMap, parama);
  }
  
  public static void getGiftForBizCodeResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", h.getUid());
    localHashMap.put("bizCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(10));
    h.request(paramActivity, com.ziroom.ziroomcustomer.payment.c.a.b, "/api/invoke", localHashMap, parama);
  }
  
  public static void getHuifuBandCard(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankCode", paramString1);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("cardProvCode", paramString2);
    localHashMap.put("cardAreaCode", paramString3);
    localHashMap.put("bankNo", paramString4);
    localHashMap.put("bankPhone", paramString5);
    localHashMap.put("cwOrderId", paramString9);
    localHashMap.put("userName", paramString6);
    localHashMap.put("certNum", paramString8);
    localHashMap.put("userPhone", paramString7);
    h.request(paramActivity, "/api/other/HFbindBank.do", localHashMap, parama);
  }
  
  public static void getHuifuBandCardResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(26));
    localHashMap.put("orderId", paramString);
    h.request(paramActivity, q.s, "interfaceTransfer/transfer", localHashMap, parama);
  }
  
  public static void getHuifuBandList(Activity paramActivity, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getHuifuBandProvinceAndCityList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(3));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getHuifuBankData(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(5));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getHuifuReBandList(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(11));
    localHashMap.put("companyCode", paramString1);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("sms_code", paramString2);
    localHashMap.put("sms_order_id", paramString3);
    localHashMap.put("sms_order_date", paramString4);
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getIsBandCardResult(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/other/getBindBankInfo.do", localHashMap, parama);
  }
  
  public static void getOpenGiftResult(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", h.getUid());
    localHashMap.put("recordId", paramString1);
    localHashMap.put("marketCode", paramString2);
    localHashMap.put("interfaceId", Integer.valueOf(9));
    h.request(paramActivity, com.ziroom.ziroomcustomer.payment.c.a.b, "/api/invoke", localHashMap, parama);
  }
  
  public static void getPayCenterMessage(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderIds", paramString1);
    if (!"0".equals(h.getUid())) {
      localHashMap.put("uid", h.getUid());
    }
    localHashMap.put("token", h.getToken());
    localHashMap.put("systemId", paramString2);
    localHashMap.put("clientType", "app");
    h.request(paramActivity, "/api/checkout/list", localHashMap, parama);
  }
  
  public static void getPayMessageCode(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Btype", "201");
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/other/getHFSmsCode.do", localHashMap, parama);
  }
  
  public static void getReBandMessageCode(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Btype", "105");
    localHashMap.put("companyCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(14));
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getSinglePayWayType(Activity paramActivity, int paramInt, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("payChannel", Integer.valueOf(paramInt));
    localHashMap.put("systemId", paramString1);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("cwOrderIds", paramString2);
    localHashMap.put("clientType", "app");
    h.request(paramActivity, "/api/checkout/getPayType", localHashMap, parama);
  }
  
  public static void getUnionCheckSMSResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(15));
    localHashMap.put("uid", h.getUid());
    localHashMap.put("smsCode", paramString);
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionCheckSignResult(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypStr", paramString2);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(9));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayAssembleDataResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(8));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayBandCardResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("bankName", paramString6);
    localHashMap.put("bankCardNo", paramString2);
    localHashMap.put("certificateNum", paramString3);
    localHashMap.put("mobile", paramString4);
    localHashMap.put("bankCode", paramString5);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("appIcon", paramString7);
    localHashMap.put("interfaceId", Integer.valueOf(12));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayBankListResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(1));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayBindBankCardToContractResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(13));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayIsBandCardResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(16));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayNoticeResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(6));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayProtocolResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(7));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionPayReBandCardResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/batchDK/unlashBankCard.do", localHashMap, parama);
  }
  
  public static void getUnionPaySingleAssembleDataResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("agreeType", "1");
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/attestation/assembleData.do", localHashMap, parama);
  }
  
  public static void getUnionPaySingleProtocolResult(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("agreeType", "1");
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/attestation/toAgreement.do", localHashMap, parama);
  }
  
  public static void getUnionSendSMSResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", h.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(2));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUnionSingleCheckSignResult(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypt", paramString2);
    localHashMap.put("cwOrderId", paramString1);
    localHashMap.put("agreeType", "1");
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/attestation/checkSign.do", localHashMap, parama);
  }
  
  public static void getUserIsBandCardResult(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", h.getUid());
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("interfaceId", Integer.valueOf(10));
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void getUserMessageResult(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (!"0".equals(h.getUid())) {
      localHashMap.put("uid", h.getUid());
    }
    h.request(paramActivity, "/api/other/getUserInfo.do", localHashMap, parama);
  }
  
  public static void getValueCardAccount(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (!"0".equals(h.getUid())) {
      localHashMap.put("uid", h.getUid());
    }
    localHashMap.put("token", h.getToken());
    localHashMap.put("cwOrderIds", paramString1);
    localHashMap.put("systemId", paramString2);
    localHashMap.put("clientType", "app");
    localHashMap.put("clientCode", ah.getDeviceId(ApplicationEx.c));
    h.request(paramActivity, "/api/checkout/valuecardAmount", localHashMap, parama);
  }
  
  public static void goToPay(Activity paramActivity, k paramk, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderIds", paramk.getCwOrderIds());
    localHashMap.put("systemId", paramk.getSystemId());
    localHashMap.put("uid", h.getUid());
    localHashMap.put("token", h.getToken());
    localHashMap.put("totalFee", Integer.valueOf(paramk.getTotalFee()));
    localHashMap.put("externalPay", e.toJSONString(paramk.getExternalPay()));
    localHashMap.put("acountPay", e.toJSONString(paramk.getAcountPay()));
    localHashMap.put("coupons", e.toJSONString(paramk.getCoupons()));
    localHashMap.put("expiredDate", paramk.getExpiredDate());
    localHashMap.put("sourceType", "android");
    localHashMap.put("payChannel", Integer.valueOf(paramk.getPayChannel()));
    localHashMap.put("smsCode", paramk.getSmsCode());
    localHashMap.put("smsOrderDate", paramk.getSmsOrderDate());
    localHashMap.put("smsOrderId", paramk.getSmsOrderId());
    localHashMap.put("storedValueCard", e.toJSONString(paramk.getStoredValueCard()));
    h.request(paramActivity, "/api/pay/generPayment", localHashMap, parama);
  }
  
  public static void sendCancelPayStatus(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(38));
    localHashMap.put("orderCode", paramString);
    localHashMap.put("uid", h.getUid());
    h.request(paramActivity, "/api/invoke", localHashMap, parama);
  }
  
  public static void setErrorLog(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
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
    paramString2.put("version", ah.getAppVersion(paramActivity));
    paramString2.put("uid", h.getUid());
    h.request(paramActivity, "/api/attestation/errorLog", paramString2, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */