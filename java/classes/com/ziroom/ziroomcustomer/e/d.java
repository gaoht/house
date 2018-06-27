package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  public static final ExecutorService a = Executors.newFixedThreadPool(5);
  
  public static void PutEvaluateContent(Handler paramHandler, Context paramContext, String paramString1, String paramString2)
  {
    a.execute(new d.29(paramContext, paramString1, paramString2, paramHandler));
  }
  
  public static void SundHandleConfirm(Handler paramHandler, String paramString1, String paramString2, int paramInt)
  {
    a.execute(new d.20(paramString1, paramString2, paramHandler, paramInt));
  }
  
  public static void TurnSignature(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.42(paramString, paramHandler));
  }
  
  public static void checkHasEvaluate(Handler paramHandler, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.31(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void errorLog(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a.execute(new d.26(paramString1, paramString2, paramContext));
  }
  
  public static void evaluateAppointment(Handler paramHandler, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    a.execute(new d.40(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramString5, paramHandler));
  }
  
  public static void getContract(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.1(paramString, paramContext, paramHandler));
  }
  
  public static void getContractCodeState(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.33(paramString, paramHandler));
  }
  
  public static void getContractExtension(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.32(paramString, paramHandler));
  }
  
  public static void getContractSummary(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.38(paramString2, paramString1, paramString3, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void getEvaluateProblems(Handler paramHandler, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a.execute(new d.28(paramContext, paramString1, paramString2, paramString3, paramHandler));
  }
  
  public static void getFlatGuideList(Context paramContext, Handler paramHandler)
  {
    a.execute(new d.50(paramHandler));
  }
  
  public static void getGuest(Handler paramHandler)
  {
    a.execute(new d.35(paramHandler));
  }
  
  public static void getIndex(Handler paramHandler)
  {
    a.execute(new d.51(paramHandler));
  }
  
  public static void getLease(Context paramContext, Handler paramHandler, String paramString, int paramInt)
  {
    a.execute(new d.12(paramString, paramInt, paramHandler));
  }
  
  public static void getLeaseInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new d.23(paramString1, paramString2, paramContext, paramHandler));
  }
  
  public static void getLeaseMyData(Handler paramHandler, String paramString)
  {
    a.execute(new d.10(paramString, paramHandler));
  }
  
  public static void getModifyContractState(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.execute(new d.37(paramString1, paramString3, paramString2, paramString4, paramString5, paramHandler));
  }
  
  public static void getNewWYPayState(Handler paramHandler, String paramString)
  {
    a.execute(new d.16(paramString, paramHandler));
  }
  
  public static void getNotPayEntity(Handler paramHandler)
  {
    a.execute(new d.2(paramHandler));
  }
  
  public static void getPayData(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    a.execute(new d.5(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramHandler));
  }
  
  public static void getPayDetailInfo(Handler paramHandler, String paramString1, String paramString2, int paramInt)
  {
    a.execute(new d.36(paramString1, paramString2, paramInt, paramHandler));
  }
  
  public static void getPayDetails(Handler paramHandler, String paramString)
  {
    a.execute(new d.8(paramString, paramHandler));
  }
  
  public static void getPayKims(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a.execute(new d.7(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramHandler));
  }
  
  public static void getPayServiceData(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.6(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void getRaConfig(Context paramContext, Handler paramHandler)
  {
    a.execute(new d.22(paramHandler));
  }
  
  public static void getRaSignInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.execute(new d.24(paramString1, paramString2, paramString3, paramString4, paramString5, paramHandler));
  }
  
  public static void getRentAgentCode(Handler paramHandler, Context paramContext, String paramString)
  {
    a.execute(new d.30(paramContext, paramString, paramHandler));
  }
  
  public static void getRentCards(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a.execute(new d.49(paramString, paramInt1, paramInt2, paramInt3, paramHandler));
  }
  
  public static void getSharer(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.11(paramString, paramHandler));
  }
  
  public static void getSundHandleList(Handler paramHandler, String paramString)
  {
    a.execute(new d.19(paramString, paramHandler));
  }
  
  public static void getTenancyInfo(Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    a.execute(new d.17(paramString1, paramString2, paramString3, paramHandler));
  }
  
  public static void getTerms(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.execute(new d.3(paramString1, paramString2, paramString3, paramString4, paramString5, paramHandler));
  }
  
  public static void getText(Handler paramHandler)
  {
    a.execute(new d.44(paramHandler));
  }
  
  public static void getTurnRaSignInfo(Context paramContext, Handler paramHandler, String paramString)
  {
    a.execute(new d.41(paramString, paramHandler));
  }
  
  public static void getTurnSignStyle(Handler paramHandler, Context paramContext)
  {
    a.execute(new d.47(paramContext, paramHandler));
  }
  
  public static void getTurnSignTerms(Handler paramHandler, String paramString)
  {
    a.execute(new d.43(paramString, paramHandler));
  }
  
  public static void getWYPayState(Handler paramHandler, String paramString)
  {
    a.execute(new d.15(paramString, paramHandler));
  }
  
  public static void getWYPayState(Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    a.execute(new d.14(paramString1, paramString2, paramString3, paramHandler));
  }
  
  public static void initiateAppoint(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a.execute(new d.39(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, paramString8, paramString9, paramHandler));
  }
  
  public static void makeOrder(Context paramContext, Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.34(paramInt1, paramInt2, paramInt3, paramString1, paramList, paramString2, paramString3, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void penaltyPay(Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    a.execute(new d.45(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramHandler));
  }
  
  public static void removeAlternateListing(Context paramContext, Handler paramHandler, List<AlternateListing> paramList)
  {
    a.execute(new d.27(paramList, paramContext, paramHandler));
  }
  
  public static void setIsSharer(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    a.execute(new d.21(paramString1, paramString2, paramHandler));
  }
  
  public static void setPayWay(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    a.execute(new d.4(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramInt3, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramHandler));
  }
  
  public static void setPaycontract(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat1, float paramFloat2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a.execute(new d.9(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat1, paramFloat2, paramString6, paramString7, paramString8, paramString9, paramString10, paramHandler));
  }
  
  public static void setSharer(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.13(paramString1, paramString2, paramInt1, paramString3, paramInt2, paramString4, paramString5, paramString6, paramHandler));
  }
  
  public static void setTurnSignStyle(Handler paramHandler, String paramString1, String paramString2, Context paramContext)
  {
    a.execute(new d.46(paramContext, paramString1, paramString2, paramHandler));
  }
  
  public static void signature(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a.execute(new d.25(paramString4, paramString1, paramString2, paramString3, paramString5, paramString6, paramHandler));
  }
  
  public static void signedMakeOrder(Context paramContext, Handler paramHandler, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, int paramInt3, int paramInt4, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    a.execute(new d.18(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt2, paramString7, paramInt3, paramInt4, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramHandler));
  }
  
  public static void uploadImage(Context paramContext, Handler paramHandler, String paramString, byte[] paramArrayOfByte)
  {
    a.execute(new d.48(paramString, paramArrayOfByte, paramHandler));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */