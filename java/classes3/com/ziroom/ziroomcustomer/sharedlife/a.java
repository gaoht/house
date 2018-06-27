package com.ziroom.ziroomcustomer.sharedlife;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.k;
import com.ziroom.ziroomcustomer.e.q;

public class a
{
  public static void changeSharedLifeLockPwd(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("deviceUuid", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("password", paramString4);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/intelligentLockB/updatePassword", locale, parama);
  }
  
  public static void getSharedLifeContracts(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/getRentContracts", locale, parama);
  }
  
  public static void getSharedLifeEqDetail(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("deviceUuid", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      locale.put("lastOperation", paramString3);
    }
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/deviceDetail", locale, parama);
  }
  
  public static void getSharedLifeEqTypes(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/getDeviceTypes", locale, parama);
  }
  
  public static void getSharedLifeEqViaType(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("deviceType", paramString3);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/equipmentList", locale, parama);
  }
  
  public static void getSharedLifeLockInfo(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("deviceUuid", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/intelligentLockB/getLockInfoC", locale, parama);
  }
  
  public static void getSharedLifeLockTempPwd(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("userName", paramString4);
    locale.put("userPhone", paramString5);
    locale.put("deviceUuid", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/intelligentLockB/temporaryPasswordC", locale, parama);
  }
  
  public static void getSharedLifeOrderDetail(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("orderCode", paramString3);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/queryOrderDetail", locale, parama);
  }
  
  public static void getSharedLifeOrderList(Context paramContext, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("rentContractCode", paramString2);
    locale.put("page", Integer.valueOf(paramInt));
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/queryOrderList", locale, parama);
  }
  
  public static void setSharedLifeEqInstruction(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", paramString1);
    locale.put("deviceUuid", paramString2);
    locale.put("rentContractCode", paramString3);
    locale.put("operationMarked", paramString4);
    locale.put("versionNum", "1.0");
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "intelligence/api/share/equipmentOperation", locale, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */