package com.ziroom.ziroomcustomer.pay.common.b;

import android.app.Activity;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.ziroomcustomer.account.model.GiftBase;
import com.ziroom.ziroomcustomer.account.model.GiftListBase;
import com.ziroom.ziroomcustomer.account.model.GiftListItemBase;
import com.ziroom.ziroomcustomer.e.e.j;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HufuBandCardResult;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuReBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandCard;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandPrivinceAndCityList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankData;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKAssenble;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKBaseJson;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKCheckMessage;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKCheckSign;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayAddBandCard;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayBandCardList;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayBandCardToContract;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayNotice;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayProtocol;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayUnBandCard;
import java.util.HashMap;
import java.util.Map;

public class a
{
  public static void getGifListResult(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(8));
    d.request(paramActivity, "api/invoke", localHashMap, GiftListBase.class, parama);
  }
  
  public static void getGiftForBizCodeResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("bizCode", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(10));
    d.request(paramActivity, "api/invoke", localHashMap, GiftBase.class, parama);
  }
  
  public static void getHuifuBandCard(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankCode", paramString2);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("cardProvCode", paramString3);
    localHashMap.put("cardAreaCode", paramString4);
    localHashMap.put("bankNo", paramString5);
    localHashMap.put("bankPhone", paramString6);
    localHashMap.put("contractCode", paramString10);
    localHashMap.put("reserveCode", paramString11);
    localHashMap.put("backRentOrderCode", paramString12);
    localHashMap.put("bizType", paramString1);
    localHashMap.put("userName", paramString7);
    localHashMap.put("certNum", paramString9);
    localHashMap.put("userPhone", paramString8);
    d.requestNoDES(paramActivity, "hf/bindBank", localHashMap, true, HuifuBandCard.class, parama);
  }
  
  public static void getHuifuBandCardResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(26));
    localHashMap.put("orderId", paramString);
    d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, false, HufuBandCardResult.class, parama);
  }
  
  public static void getHuifuBandList(Activity paramActivity, int paramInt, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(20));
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, true, HuiFuBandList.class, parama);
  }
  
  public static void getHuifuBandMessage(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null)
    {
      localHashMap.put("interfaceId", Integer.valueOf(16));
      localHashMap.put("companyCode", paramString2);
    }
    for (;;)
    {
      localHashMap.put("uid", d.getUid());
      localHashMap.put("Btype", Integer.valueOf(paramInt));
      if (paramString2 == null) {
        break;
      }
      d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, paramBoolean, HuifuBankMessage.class, parama);
      return;
      localHashMap.put("contractCode", paramString3);
      localHashMap.put("reserveCode", paramString4);
      localHashMap.put("backRentOrderCode", paramString5);
      localHashMap.put("bizType", paramString1);
    }
    d.requestNoDES(paramActivity, "hf/getSmsInfo", localHashMap, paramBoolean, HuifuBankMessage.class, parama);
  }
  
  public static void getHuifuBandProvinceAndCityList(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(22));
    d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, true, HuifuBandPrivinceAndCityList.class, parama);
  }
  
  public static void getHuifuBankData(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(17));
    d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, true, HuifuBankData.class, parama);
  }
  
  public static void getHuifuPayTypeList(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("companyCode", paramString1);
    localHashMap.put("pyaType", paramString2);
    localHashMap.put("bizType", paramString2);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("contractCode", paramString3);
    localHashMap.put("reserveCode", paramString4);
    localHashMap.put("backRentOrderCode", paramString5);
    d.requestNoDES(paramActivity, "hf/getPayTypeList", localHashMap, true, HuiFuIsBandAndBandList.class, parama);
  }
  
  public static void getHuifuReBandList(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(25));
    localHashMap.put("companyCode", paramString1);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("sms_code", paramString2);
    localHashMap.put("sms_order_id", paramString3);
    localHashMap.put("sms_order_date", paramString4);
    d.requestNoDES(paramActivity, "interfaceTransfer/transfer", localHashMap, true, HuiFuReBandList.class, parama);
  }
  
  public static void getIsCanPayResult(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("checkType", Integer.valueOf(paramInt1));
    localHashMap.put("checkKey", paramString1);
    localHashMap.put("period", Integer.valueOf(paramInt2));
    localHashMap.put("countMoney", Integer.valueOf(paramInt3));
    localHashMap.put("thirdPartyMoney", Integer.valueOf(paramInt4));
    localHashMap.put("payType", paramString2);
    d.requestNoDES(paramActivity, e.j.p, localHashMap, false, UnionDKPayProtocol.class, parama);
  }
  
  public static void getOpenGiftResult(Activity paramActivity, String paramString1, String paramString2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("recordId", paramString1);
    localHashMap.put("marketCode", paramString2);
    localHashMap.put("interfaceId", Integer.valueOf(9));
    d.request(paramActivity, "api/invoke", localHashMap, GiftListItemBase.class, parama);
  }
  
  public static void getUnionCheckSMSResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(3));
    localHashMap.put("uid", d.getUid());
    localHashMap.put("smsCode", paramString);
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKCheckMessage.class, parama);
  }
  
  public static void getUnionCheckSignResult(Activity paramActivity, String paramString1, String paramString2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypStr", paramString2);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(5));
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKCheckSign.class, parama);
  }
  
  public static void getUnionPayAssembleDataResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(4));
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKAssenble.class, parama);
  }
  
  public static void getUnionPayBandCardResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("bankName", paramString6);
    localHashMap.put("bankCardNo", paramString2);
    localHashMap.put("certificateNum", paramString3);
    localHashMap.put("mobile", paramString4);
    localHashMap.put("bankCode", paramString5);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("appIcon", paramString7);
    d.requestNoDES(paramActivity, "payment/unionpay/bindBankCard", localHashMap, false, UnionDKPayAddBandCard.class, parama);
  }
  
  public static void getUnionPayBankListResult(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(1));
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKPayBandCardList.class, parama);
  }
  
  public static void getUnionPayBindBankCardToContractResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, "payment/unionpay/bindBankCardToContract", localHashMap, false, UnionDKPayBandCardToContract.class, parama);
  }
  
  public static void getUnionPayIsBandCardResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, "payment/unionpay/queryBankCardInfo", localHashMap, false, UnionDKPayIsBandCard.class, parama);
  }
  
  public static void getUnionPayNoticeResult(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(6));
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKPayNotice.class, parama);
  }
  
  public static void getUnionPayProtocolResult(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", d.getUid());
    localHashMap.put("interfaceId", Integer.valueOf(7));
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKPayProtocol.class, parama);
  }
  
  public static void getUnionPayUnBandCardResult(Activity paramActivity, String paramString1, String paramString2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindCityCode", paramString1);
    localHashMap.put("cardNo", paramString2);
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, "payment/unionpay/unbind", localHashMap, false, UnionDKPayUnBandCard.class, parama);
  }
  
  public static void getUnionSendSMSResult(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(2));
    localHashMap.put("uid", d.getUid());
    d.request(paramActivity, "api/invoke", localHashMap, UnionDKBaseJson.class, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/common/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */