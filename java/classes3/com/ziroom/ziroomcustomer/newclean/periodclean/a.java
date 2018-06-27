package com.ziroom.ziroomcustomer.newclean.periodclean;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.k;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CancelOrderBean;
import java.util.ArrayList;
import java.util.List;

public class a
{
  public static void DeleteZhengzuAddress(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("fid", paramString);
    locale.put("dataSource", Integer.valueOf(12));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/commonAdress/delete", locale, parama);
  }
  
  public static void PeriodCleanCreateOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("connectName", paramString1);
    locale.put("connectPhone", paramString2);
    locale.put("firstAppointmentTime", paramString3);
    locale.put("cyclePlanFrequencyCode", paramString4);
    locale.put("remark", paramString5);
    locale.put("addressId", paramString6);
    locale.put("employeeCode", paramString7);
    locale.put("burningTimeCode", paramString8);
    locale.put("addressId", paramString6);
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/createOrder", locale, parama);
  }
  
  public static void changePhoneByOrderid(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("planOrderCode", paramString1);
    locale.put("connectPhone", paramString2);
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/updateConnectPhone", locale, parama);
  }
  
  public static void getChangeOrderTime(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    locale.put("orderStatus", paramInt + "");
    locale.put("oldStartTime", paramString2);
    locale.put("planStartTime", paramString3);
    locale.put("employeeCode", paramString4);
    locale.put("uid", com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/changeOrderTime", locale, parama);
  }
  
  public static void getCleanerByAddress(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("addressId", paramString);
    locale.put("cityCode", b.d);
    locale.put("versionNum", "1.0");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalCleanSupplier/noCapacityCleanEmployeeList", locale, parama);
  }
  
  public static void getCommonAdressList(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "5.6.0");
    locale.put("uid", com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/commons/commonAdress/list", locale, parama);
  }
  
  public static void getCycleplanCapacityList(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    paramString2 = new e();
    paramString2.put("productCode", "2c9084454b7835b0014b7841269101a9");
    paramString2.put("weekNum", Integer.valueOf(paramInt));
    paramString2.put("employeeCode", paramString1);
    paramString2.put("serviceItemCodes", localArrayList);
    paramString2.put("addressId", paramString3);
    paramString2.put("cyclePlanFrequencyCode", paramString4);
    paramString2.put("osType", "12");
    paramString2.put("dataSource", "12");
    paramString2.put("cityCode", b.d);
    paramString2.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/capacityList", paramString2, parama);
  }
  
  public static void getCycleplanWeekList(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("osType", "12");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/commons/weekListConst", locale, parama);
  }
  
  public static void getFrequencyConfigs(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "1.0");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/commons/cyclePlanConfigs", locale, parama);
  }
  
  public static void getPeriodCleanCancelOrder(Context paramContext, String paramString1, String paramString2, CancelOrderBean paramCancelOrderBean, com.freelxl.baselibrary.d.c.a parama)
  {
    new e().put(paramCancelOrderBean.getTagId(), paramCancelOrderBean.getTagName());
    e locale = new e();
    locale.put("userMessage", paramString2);
    locale.put("reason", paramCancelOrderBean.getTagName());
    locale.put("planOrderCode", paramString1);
    locale.put("osType", "12");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/planCancel", locale, parama);
  }
  
  public static void getPeriodCleanCancelOrderList(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("osType", "12");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/cancelTags", locale, parama);
  }
  
  public static void getPeriodCleanMainNoticeMessage(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/document", locale, parama);
  }
  
  public static void getPeriodCleanOrderDetail(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("planOrderCode", paramString);
    locale.put("osType", "12");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/planOrderInfo", locale, parama);
  }
  
  public static void getPeriodCleanOrderList(Context paramContext, String paramString, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("planOrderCode", paramString);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/orderList", locale, parama);
  }
  
  public static void getPeriodCleanRemarkLabel(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("osType", "12");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/tags", locale, parama);
  }
  
  public static void getPeriodCleanSuggestAddress(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/suggestAddress", locale, parama);
  }
  
  public static void getPeriodCleanTimeNoticeMessage(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("dicType", "UserCyclePlanCalendarDocment");
    locale.put("dataSource", "12");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/commons/dicTag", locale, parama);
  }
  
  public static void getPeriodGeneralActionState(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/actions", locale, parama);
  }
  
  public static void getPeriodGeneralCancleTag(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cancel/reasons", locale, parama);
  }
  
  public static void getPeriodGeneralCleanerInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("cleanerId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/cleaner/empInfo", locale, parama);
  }
  
  public static void getPeriodGeneralDetailInfo(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    locale.put("useCoupon", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      locale.put("couponCode", paramString3);
    }
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/detail", locale, parama);
  }
  
  public static void getPeriodGeneralPayCharge(Context paramContext, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    locale.put("couponId", paramString2);
    locale.put("couponCode", paramString3);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/charges", locale, parama);
  }
  
  public static void getPeriodGeneralStatusInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/order/trace", locale, parama);
  }
  
  public static void getPeriodHistoryCleaner(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("addressId", paramString);
    locale.put("cityCode", b.d);
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalCleanSupplier/noCapacityHistoryCleanEmployeeList", locale, parama);
  }
  
  public static void getServiceTimeLong(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "1.0");
    locale.put("dataSource", "12");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/serviceTimes", locale, parama);
  }
  
  public static void getValidateCustomerPermission(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("cityCode", b.d);
    locale.put("versionNum", "1.0");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/validateCustomerPermission", locale, parama);
  }
  
  public static void getValidateCustomerPermission(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", paramString);
    locale.put("cityCode", b.d);
    locale.put("versionNum", "1.0");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/validateCustomerPermission", locale, parama);
  }
  
  public static void nextOrderInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("planOrderCode", paramString);
    locale.put("uid", com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/nextOrderInfo", locale, parama);
  }
  
  public static void submitPeriodGeneralCancleTag(Context paramContext, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("orderCode", paramString1);
    locale.put("reason", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", b.d);
    locale.put("dataSource", "12");
    locale.put("versionNum", "2");
    k.requestGateWayService(paramContext, q.o + "cleanApi/zrk/generalclean/cancel/confirm", locale, parama);
  }
  
  public static void validCycleOrder(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("uid", com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalclean/cycleplan/validCycleOrder", locale, parama);
  }
  
  public static void validMatchSupplierScopeByCoord(Context paramContext, double paramDouble1, double paramDouble2, com.freelxl.baselibrary.d.c.a parama)
  {
    e locale = new e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("longitude", Double.valueOf(paramDouble1));
    locale.put("latitude", Double.valueOf(paramDouble2));
    locale.put("cityCode", b.d);
    locale.put("osType", Integer.valueOf(12));
    k.requestGateWayCommonService(paramContext, q.o + "cleanApi/zrk/generalCleanSupplier/validMatchSupplierScopeByCoord", locale, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */