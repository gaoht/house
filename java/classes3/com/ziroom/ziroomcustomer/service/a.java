package com.ziroom.ziroomcustomer.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.account.AccountDetailsActivity;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.EvaluateSignActivity;
import com.ziroom.ziroomcustomer.activity.FiveYearWebViewActivity;
import com.ziroom.ziroomcustomer.activity.LeaseActivity;
import com.ziroom.ziroomcustomer.activity.LeaseUpdataActivity;
import com.ziroom.ziroomcustomer.activity.MessageCenterActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyAppointActivity;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.my.MyRentCardActivity;
import com.ziroom.ziroomcustomer.my.MySubmitEvaluateActivity;
import com.ziroom.ziroomcustomer.my.MyWillPayListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.GeneralCleaningEvalActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RentNewDetailActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ComplainDetailActivity;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralOrderDetailActivity;
import com.ziroom.ziroomcustomer.newclean.activity.WeekCleanDetailActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanGiftCardActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodGeneralDetailActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingEvalActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.SmallMoveEvalActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairEvalActivity;
import com.ziroom.ziroomcustomer.repay.RepayInfoActivity;
import com.ziroom.ziroomcustomer.reserve.BookingOrderListActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.social.activity.ac.AcEnrollListActivityNew;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletInitiatorDetailActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletReservationDetailActivity;
import com.ziroom.ziroomcustomer.termination.ConfirmTerminationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuLeaseInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSdActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationEvaluateActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class a
{
  private static Object f = new Object();
  private static a g;
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        a.this.showToast((String)paramAnonymousMessage.obj);
        return;
      case 2: 
        a.this.showProgress((String)paramAnonymousMessage.obj);
        return;
      }
      a.this.dismissProgress();
    }
  };
  private Intent b;
  private Context c;
  private Timer d;
  private String e = a.class.getSimpleName();
  
  private a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (ae.notNull(paramString1))
    {
      paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
      if (paramString1.get("msg_biz_params") == null) {}
      for (paramString1 = "";; paramString1 = paramString1.get("msg_biz_params").toString())
      {
        paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
        if (paramString1 != null)
        {
          if (!ae.isNull(paramString2)) {
            break label75;
          }
          if (paramString1.get("business_id") != null) {
            break;
          }
        }
        return "";
      }
      return paramString1.get("business_id").toString();
      label75:
      if (paramString1.get(paramString2) == null) {
        return "";
      }
      return paramString1.get(paramString2).toString();
    }
    return "";
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.c, MessageCenterActivity.class);
    u.i(this.e, "to消息中心");
    localIntent.setFlags(268435456);
    this.c.startActivity(localIntent);
  }
  
  private void a(Class paramClass, Map<String, String> paramMap)
  {
    if (ApplicationEx.c.isLoginState())
    {
      paramClass = new Intent(this.c, paramClass);
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramClass.putExtra(str, (String)paramMap.get(str));
        }
      }
      paramClass.setFlags(268435456);
      this.c.startActivity(paramClass);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.c, true);
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    a(RepayInfoActivity.class, localHashMap);
    u.i(this.e, "跳转到贷款信息界面");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if (ApplicationEx.c.isLoginState())
    {
      Intent localIntent = new Intent(this.c, EvaluateSignActivity.class);
      localIntent.putExtra("sceneCode", paramInt);
      localIntent.putExtra("orderCode", paramString);
      localIntent.setFlags(268435456);
      this.c.startActivity(localIntent);
      u.i(this.e, "跳转到约看管家评价界面");
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.c, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this.c, InternalRepairEvalActivity.class);
    localIntent.putExtra("headUrl", paramString1);
    localIntent.putExtra("name", paramString2);
    localIntent.putExtra("mailBillId", paramString3);
    localIntent.setFlags(268435456);
    this.c.startActivity(localIntent);
  }
  
  private boolean a(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    e locale = com.alibaba.fastjson.a.parseObject(paramb.f);
    if (locale != null)
    {
      if (locale.get("msg_h5_url") == null) {}
      for (String str = ""; (1 == Integer.parseInt(locale.getString("msg_has_response"))) && (!ae.isNull(str)) && (ah.isWebUrl(str)); str = locale.get("msg_h5_url").toString())
      {
        this.b = new Intent(paramContext, FiveYearWebViewActivity.class);
        this.b.putExtra("url", str);
        this.b.putExtra("title", paramb.e);
        this.b.setFlags(268435456);
        paramContext.startActivity(this.b);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Context paramContext, com.ziroom.commonlibrary.c.b paramb, boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    e locale = com.alibaba.fastjson.a.parseObject(paramb.f);
    boolean bool1 = bool2;
    if (locale != null) {
      if (locale.get("msg_h5_url") != null) {
        break label93;
      }
    }
    label93:
    for (paramb = "";; paramb = locale.get("msg_h5_url").toString())
    {
      bool1 = bool2;
      if (1 == Integer.parseInt(locale.getString("msg_has_response")))
      {
        bool1 = bool2;
        if (!ae.isNull(paramb))
        {
          bool1 = bool2;
          if (ah.isWebUrl(paramb))
          {
            JsBridgeWebActivity.start(paramContext, paramString1, paramb, paramBoolean, paramString2, "", false);
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.c, AcMainActivity.class);
    localIntent.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localIntent.setFlags(268435456);
    this.c.startActivity(localIntent);
  }
  
  private void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("mode", "0");
    a(ConfirmTerminationActivity.class, localHashMap);
    u.i(this.e, "跳转到查看解约付款页");
  }
  
  private void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mContractCode", paramString1);
    localHashMap.put("sysContractId", paramString2);
    localHashMap.put("NotPayHouse", "notPayHouse");
    a(LeaseAllBillActivity.class, localHashMap);
    u.i(this.e, "跳转到房租账单列表界面");
  }
  
  private void c()
  {
    a(BookingOrderListActivity.class, null);
    u.i(this.e, "跳转到我的预订单");
  }
  
  private void c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("lease", paramString);
    a(LeaseUpdataActivity.class, localHashMap);
    u.i(this.e, "跳转到生活费用账单列表");
  }
  
  private void c(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString1);
    localHashMap.put("sysContractId", paramString2);
    a(NewLeaseInfoActivity.class, localHashMap);
    u.i(this.e, "跳转到合同详情页");
  }
  
  private void d()
  {
    a(LeaseActivity.class, null);
    u.i(this.e, "跳转到我的合同");
  }
  
  private void d(String paramString)
  {
    a(MyWillPayListActivity.class, null);
    u.i(this.e, "跳转到生活费用账单列表");
  }
  
  private void d(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString1);
    localHashMap.put("house_id", paramString2);
    localHashMap.put("SIGNBACK", "SIGNBACK");
    a(RentHouseDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到房源详情");
  }
  
  private void e()
  {
    a();
  }
  
  private void e(String paramString1, String paramString2)
  {
    if (ApplicationEx.c.isLoginState())
    {
      Intent localIntent = new Intent(this.c, MySubmitEvaluateActivity.class);
      localIntent.putExtra("isShowHistory", false);
      localIntent.putExtra("isPush", true);
      localIntent.putExtra("evaluateSource", 2);
      localIntent.putExtra("keeperId", paramString1);
      localIntent.putExtra("orderCode", paramString2);
      localIntent.setFlags(268435456);
      this.c.startActivity(localIntent);
      u.i(this.e, "跳转到租期管家评价界面");
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.c, true);
  }
  
  private void f()
  {
    a(AccountDetailsActivity.class, null);
    u.i(this.e, "跳转到提现列表界面");
  }
  
  public static a getInstance(Context paramContext)
  {
    if (g == null) {}
    synchronized (f)
    {
      g = new a(paramContext);
      return g;
    }
  }
  
  public void CleanGiftCardPush(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = a(paramb.f, "uid");
    paramb = a(paramb.f, "serviceType");
    Intent localIntent = new Intent(this.c, CleanGiftCardActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("serviceType", paramb);
    localIntent.putExtra("uid", str);
    localIntent.putExtra("isbuy", false);
    this.c.startActivity(localIntent);
  }
  
  public void dealAccountGiftPush(com.ziroom.commonlibrary.c.b paramb)
  {
    paramb = new Intent(this.c, AccountMainActivity.class);
    paramb.setFlags(268435456);
    this.c.startActivity(paramb);
  }
  
  public void dealApartment(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str.equals("1"))
        {
          i = 0;
          continue;
          if (str.equals("2"))
          {
            i = 1;
            continue;
            if (str.equals("3"))
            {
              i = 2;
              continue;
              if (str.equals("4"))
              {
                i = 3;
                continue;
                if (str.equals("5"))
                {
                  i = 4;
                  continue;
                  if (str.equals("6"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("911")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    toAppartmentSeeList("0");
    return;
    toAppartmentSeeList("1");
    return;
    toAppartmentSign(a(paramb.f, "contract_id"), a(paramb.f, "customer_uid"), a(paramb.f, "contact_number"), a(paramb.f, "sign_type"));
    return;
    paramb = new Intent(this.c, MainActivity.class);
    paramb.putExtra("FRAGMENT_TYPE", 7);
    paramb.setFlags(268435456);
    this.c.startActivity(paramb);
    return;
    if (ApplicationEx.c.isLoginState())
    {
      paramb = new Intent(this.c, ZryuSdActivity.class);
      paramb.putExtra("tab", 1);
      paramb.setFlags(268435456);
      this.c.startActivity(paramb);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.c, true);
    return;
    a();
  }
  
  public void dealApartmentFromNoticaication(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        dealApartment(paramb);
        return;
        if (str.equals("3")) {
          i = 0;
        }
        break;
      }
    }
    paramb = new Intent(this.c, MainActivity.class);
    paramb.putExtra("FRAGMENT_TYPE", 7);
    paramb.setFlags(268435456);
    this.c.startActivity(paramb);
  }
  
  public void dealCommunityActivities(com.ziroom.commonlibrary.c.b paramb)
  {
    paramb = paramb.h;
    int i = -1;
    switch (paramb.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (paramb.equals("10")) {
          i = 0;
        }
        break;
      }
    }
    a(AcEnrollListActivityNew.class, null);
  }
  
  public void dealCreditActivities(com.ziroom.commonlibrary.c.b paramb)
  {
    new Intent();
    paramb = paramb.h;
    int i = -1;
    switch (paramb.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (paramb.equals("SCOREUPDATE"))
        {
          i = 0;
          continue;
          if (paramb.equals("ARTIFICIAL_ADD_BLACK"))
          {
            i = 1;
            continue;
            if (paramb.equals("NATIVE"))
            {
              i = 2;
              continue;
              if (paramb.equals("MEDAL"))
              {
                i = 3;
                continue;
                if (paramb.equals("ARTIFICIAL_REFUSED_AUTH"))
                {
                  i = 4;
                  continue;
                  if (paramb.equals("ARTIFICIAL_PASS_AUTH")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    if (ApplicationEx.c.isLoginState())
    {
      Routers.open(this.c, "ziroomCustomer://zrCreditModule/homeView");
      return;
    }
    g.textToast(this.c, "请登录");
    return;
    if (ApplicationEx.c.isLoginState())
    {
      Routers.open(this.c, "ziroomCustomer://zrCreditModule/negativeListView");
      return;
    }
    g.textToast(this.c, "请登录");
    return;
    if (ApplicationEx.c.isLoginState())
    {
      Routers.open(this.c, "ziroomCustomer://zrCreditModule/medalListView");
      return;
    }
    g.textToast(this.c, "请登录");
    return;
    o.toCertificate(this.c, null);
    return;
    paramb = new SearchCondition();
    Intent localIntent = new Intent(this.c, HouseListActivity.class);
    localIntent.setFlags(268435456);
    paramb.setHouse_type("合租");
    localIntent.setFlags(268435456);
    localIntent.putExtra("searchCondition", paramb);
    this.c.startActivity(localIntent);
  }
  
  public void dealFinance(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str.equals("10"))
        {
          i = 0;
          continue;
          if (str.equals("20"))
          {
            i = 1;
            continue;
            if (str.equals("30"))
            {
              i = 2;
              continue;
              if (str.equals("40"))
              {
                i = 3;
                continue;
                if (str.equals("50"))
                {
                  i = 4;
                  continue;
                  if (str.equals("900")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    f();
    return;
    b(a(paramb.f, "contractCode"), a(paramb.f, "sysContractId"));
    return;
    a(a(paramb.f, "contractCode"));
    return;
    a(this.c, paramb, true, paramb.e, paramb.d);
  }
  
  public void dealMoveClean(com.ziroom.commonlibrary.c.b paramb)
  {
    String str2 = "";
    String str1 = str2;
    if (ApplicationEx.c.getUser() != null)
    {
      str1 = str2;
      if (!ae.isNull(ApplicationEx.c.getUser().getUid())) {
        str1 = ApplicationEx.c.getUser().getUid();
      }
    }
    str2 = paramb.h;
    int i = -1;
    switch (str2.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str2.equals("11"))
        {
          i = 0;
          continue;
          if (str2.equals("12"))
          {
            i = 1;
            continue;
            if (str2.equals("31"))
            {
              i = 2;
              continue;
              if (str2.equals("32"))
              {
                i = 3;
                continue;
                if (str2.equals("41"))
                {
                  i = 4;
                  continue;
                  if (str2.equals("42"))
                  {
                    i = 5;
                    continue;
                    if (str2.equals("21"))
                    {
                      i = 6;
                      continue;
                      if (str2.equals("24"))
                      {
                        i = 7;
                        continue;
                        if (str2.equals("22"))
                        {
                          i = 8;
                          continue;
                          if (str2.equals("23"))
                          {
                            i = 9;
                            continue;
                            if (str2.equals("911")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    str2 = a(paramb.f, "billId");
    String str3 = a(paramb.f, "cleanerId");
    String str4 = a(paramb.f, "rentContractCode");
    String str5 = a(paramb.f, "hireContractCode");
    String str6 = a(paramb.f, "contractAddress");
    String str7 = a(paramb.f, "date");
    String str8 = a(paramb.f, "time");
    if (ae.isNull(str1)) {
      str1 = a(paramb.f, "uid");
    }
    for (;;)
    {
      toBiWeeklyDetailActivity(str2, str3, str4, str5, str6, str7, str8, str1, a(paramb.f, "phone"), a(paramb.f, "name"));
      return;
      str2 = a(paramb.f, "billId");
      str3 = a(paramb.f, "cleanerId");
      str4 = a(paramb.f, "rentContractCode");
      str5 = a(paramb.f, "hireContractCode");
      str6 = a(paramb.f, "contractAddress");
      str7 = a(paramb.f, "date");
      str8 = a(paramb.f, "time");
      if (ae.isNull(str1)) {
        str1 = a(paramb.f, "uid");
      }
      for (;;)
      {
        toBiWeeklyEvalActivity(str2, str3, str4, str5, str6, str7, str8, str1, a(paramb.f, "phone"), a(paramb.f, "name"), a(paramb.f, "month"), a(paramb.f, "evalId"));
        return;
        toMHOrderDetailActivity(a(paramb.f, "workOrderId"));
        return;
        toMHOrderDetailActivity(a(paramb.f, "workOrderId"));
        return;
        toMovingVanDetailActivity(a(paramb.f, "orderId"));
        return;
        toMHOrderDetailActivity(a(paramb.f, "orderId"));
        return;
        toGeneralCleanDetailActivity(a(paramb.f, "cleanId"), a(paramb.f, "cleanerId"));
        return;
        toNewGeneralCleanDetailActivity(a(paramb.f, "cleanId"));
        return;
        toGeneralEvalActivity(a(paramb.f, "orderId"), a(paramb.f, "generalPrice"), a(paramb.f, "cleanerId"));
        return;
        toGeneralCleaningActivity(a(paramb.f, "serviceInfoId"), a(paramb.f, "serviceInfoName"));
        return;
        a();
        return;
      }
    }
  }
  
  public void dealPush(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str.equals("1"))
        {
          i = 0;
          continue;
          if (str.equals("2"))
          {
            i = 1;
            continue;
            if (str.equals("3"))
            {
              i = 2;
              continue;
              if (str.equals("4")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    a(this.c, paramb, true, paramb.e, paramb.d);
    return;
    a(this.c, paramb);
    return;
    a();
    return;
    b();
  }
  
  public void dealRentWhole(com.ziroom.commonlibrary.c.b paramb)
  {
    int j = 0;
    String str1 = paramb.h;
    label304:
    int i;
    switch (str1.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
      case 0: 
      case 8: 
      case 10: 
      case 11: 
      case 13: 
      case 14: 
      case 15: 
      case 19: 
      case 20: 
      case 32: 
        return;
        if (!str1.equals("1")) {
          break label304;
        }
        i = 0;
        continue;
        if (!str1.equals("2")) {
          break label304;
        }
        i = 1;
        continue;
        if (!str1.equals("3")) {
          break label304;
        }
        i = 2;
        continue;
        if (!str1.equals("4")) {
          break label304;
        }
        i = 3;
        continue;
        if (!str1.equals("5")) {
          break label304;
        }
        i = 4;
        continue;
        if (!str1.equals("6")) {
          break label304;
        }
        i = 5;
        continue;
        if (!str1.equals("7")) {
          break label304;
        }
        i = 6;
        continue;
        if (!str1.equals("8")) {
          break label304;
        }
        i = 7;
        continue;
        if (!str1.equals("9")) {
          break label304;
        }
        i = 8;
        continue;
        if (!str1.equals("10")) {
          break label304;
        }
        i = 9;
        continue;
        if (!str1.equals("11")) {
          break label304;
        }
        i = 10;
        continue;
        if (!str1.equals("12")) {
          break label304;
        }
        i = 11;
        continue;
        if (!str1.equals("13")) {
          break label304;
        }
        i = 12;
        continue;
        if (!str1.equals("14")) {
          break label304;
        }
        i = 13;
        continue;
        if (!str1.equals("15")) {
          break label304;
        }
        i = 14;
        continue;
        if (!str1.equals("16")) {
          break label304;
        }
        i = 15;
        continue;
        if (!str1.equals("17")) {
          break label304;
        }
        i = 16;
        continue;
        if (!str1.equals("18")) {
          break label304;
        }
        i = 17;
        continue;
        if (!str1.equals("19")) {
          break label304;
        }
        i = 18;
        continue;
        if (!str1.equals("20")) {
          break label304;
        }
        i = 19;
        continue;
        if (!str1.equals("21")) {
          break label304;
        }
        i = 20;
        continue;
        if (!str1.equals("22")) {
          break label304;
        }
        i = 21;
        continue;
        if (!str1.equals("23")) {
          break label304;
        }
        i = 22;
        continue;
        if (!str1.equals("24")) {
          break label304;
        }
        i = 23;
        continue;
        if (!str1.equals("25")) {
          break label304;
        }
        i = 24;
        continue;
        if (!str1.equals("26")) {
          break label304;
        }
        i = 25;
        continue;
        if (!str1.equals("27")) {
          break label304;
        }
        i = 26;
        continue;
        if (!str1.equals("28")) {
          break label304;
        }
        i = 27;
        continue;
        if (!str1.equals("29")) {
          break label304;
        }
        i = 28;
        continue;
        if (!str1.equals("30")) {
          break label304;
        }
        i = 29;
        continue;
        if (!str1.equals("31")) {
          break label304;
        }
        i = 30;
        continue;
        if (!str1.equals("32")) {
          break label304;
        }
        i = 31;
        continue;
        if (!str1.equals("70")) {
          break label304;
        }
        i = 32;
        continue;
        if (!str1.equals("900")) {
          break label304;
        }
        i = 33;
        continue;
        if (!str1.equals("911")) {
          break label304;
        }
        i = 34;
      }
    }
    c();
    return;
    a();
    return;
    b(a(paramb.f, "contractCode"), a(paramb.f, "sysContractId"));
    return;
    c(a(paramb.f, "contractCode"), a(paramb.f, "sysContractId"));
    return;
    d();
    return;
    b(a(paramb.f, "contractCode"));
    return;
    d(a(paramb.f, "contractCode"));
    return;
    e(a(paramb.f, "keeperId"), a(paramb.f, "orderCode"));
    return;
    toInitiatorDetailActivity(a(paramb.f, "contract_code"));
    return;
    toReservationDetailActivity(a(paramb.f, "reserveCode"));
    return;
    d(a(paramb.f, "house_code"), a(paramb.f, "house_id"));
    return;
    a(MyRentCardActivity.class, null);
    return;
    a(MyCouponActivity.class, null);
    return;
    c(a(paramb.f, "contractCode"));
    return;
    a(paramb.f, "keeperId");
    str1 = a(paramb.f, "orderKey");
    String str2 = a(paramb.f, "orderType");
    paramb = a(paramb.f, "orderStatus");
    if ("sign".equals(str2)) {
      i = j;
    }
    for (;;)
    {
      a(str1, i);
      return;
      if ("order".equals(str2))
      {
        if ("6".equals(paramb))
        {
          i = 3;
          continue;
        }
        i = 1;
        continue;
        paramb = com.alibaba.fastjson.a.parseObject(paramb.f);
        if (paramb == null) {
          break;
        }
        if (paramb.get("msg_h5_url") == null) {}
        for (paramb = "";; paramb = paramb.get("msg_h5_url").toString())
        {
          JsBridgeWebActivity.start(this.c, "", paramb, false, "", "", false);
          return;
        }
        a();
        return;
      }
      i = -1;
    }
  }
  
  public void dealRepair(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str.equals("10")) {
          i = 0;
        }
        break;
      }
    }
    a(a(paramb.f, "servicerImg"), a(paramb.f, "servicerName"), a(paramb.f, "maiVisitId"));
  }
  
  public void dealService(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        a();
      }
      break;
    }
    do
    {
      return;
      if (!str.equals("1")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("2")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("3")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("4")) {
        break;
      }
      i = 3;
      break;
      if (!str.equals("5")) {
        break;
      }
      i = 4;
      break;
      if (!str.equals("6")) {
        break;
      }
      i = 5;
      break;
      if (!str.equals("7")) {
        break;
      }
      i = 6;
      break;
      if (!str.equals("8")) {
        break;
      }
      i = 7;
      break;
      if (!str.equals("911")) {
        break;
      }
      i = 8;
      break;
      toServiceOrderDetail(a(paramb.f, ""));
      return;
      toComplainDetail(a(paramb.f, ""));
      return;
    } while (!ApplicationEx.c.isLoginState());
    paramb = new Intent(this.c, ChatWebViewActivity.class);
    paramb.setFlags(268435456);
    this.c.startActivity(paramb);
    return;
    a();
  }
  
  public void dealSmartLock(com.ziroom.commonlibrary.c.b paramb)
  {
    paramb = paramb.h;
    int i = -1;
    switch (paramb.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (paramb.equals("1")) {
          i = 0;
        }
        break;
      }
    }
    e();
  }
  
  public void dealStation(com.ziroom.commonlibrary.c.b paramb)
  {
    String str = paramb.h;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a();
        return;
        if (str.equals("3"))
        {
          i = 0;
          continue;
          if (str.equals("4"))
          {
            i = 1;
            continue;
            if (str.equals("5"))
            {
              i = 2;
              continue;
              if (str.equals("911")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    toStationOrderDetail(a(paramb.f, "orderBid"));
    return;
    toStationEvaluate(a(paramb.f, "dName"), a(paramb.f, "phone"), a(paramb.f, "orderBid"), a(paramb.f, "orderNumber"), a(paramb.f, "projectBid"), a(paramb.f, "houseTypeNames"));
    return;
    a();
  }
  
  public void dismissProgress()
  {
    if (LodingProgressDialog.getDialog() != null) {
      LodingProgressDialog.dismiss();
    }
    if (this.d != null)
    {
      this.d.cancel();
      this.d.purge();
      this.d = null;
    }
  }
  
  public void showHandleToast(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.a.sendMessage(localMessage);
  }
  
  public boolean showProgress(String paramString)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    this.d = new Timer();
    this.d.schedule(new b(), 30000L);
    return true;
  }
  
  public boolean showProgressNoCancel(String paramString, long paramLong)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    this.d = new Timer();
    this.d.schedule(new a(), paramLong);
    return true;
  }
  
  public void showToast(String paramString)
  {
    if (ae.notNull(paramString))
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        g.textToast(this.c, paramString);
      }
    }
    else {
      return;
    }
    Message localMessage = this.a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.a.sendMessage(localMessage);
  }
  
  public void toAppartmentSeeList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tabIndex", paramString);
    a(MyAppointActivity.class, localHashMap);
    u.i(this.e, "跳转到自如寓约看列表");
  }
  
  public void toAppartmentSign(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    u.i(this.e, "====contractId:" + paramString1 + ":uid:" + paramString2 + ":管家电话：" + paramString3 + ":isNewSign:" + paramString4);
    paramString2 = new HashMap();
    paramString2.put("deCode", "XQ");
    paramString2.put("contractId", paramString1);
    a(ZryuLeaseInfoActivity.class, paramString2);
  }
  
  public void toBiWeeklyDetailActivity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billId", paramString1);
    localHashMap.put("cleanerId", paramString2);
    localHashMap.put("rentContractCode", paramString3);
    localHashMap.put("hireContractCode", paramString4);
    localHashMap.put("contractAddress", paramString5);
    localHashMap.put("date", paramString6);
    localHashMap.put("time", paramString7);
    localHashMap.put("uid", paramString8);
    localHashMap.put("phone", paramString9);
    localHashMap.put("name", paramString10);
    a(WeekCleanDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到双周保洁订单详情");
  }
  
  public void toBiWeeklyEvalActivity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("billId", paramString1);
    localHashMap.put("cleanerId", paramString2);
    localHashMap.put("rentContractCode", paramString3);
    localHashMap.put("hireContractCode", paramString4);
    localHashMap.put("contractAddress", paramString5);
    localHashMap.put("date", paramString6);
    localHashMap.put("time", paramString7);
    localHashMap.put("uid", paramString8);
    localHashMap.put("phone", paramString9);
    localHashMap.put("name", paramString10);
    localHashMap.put("month", paramString11);
    localHashMap.put("evalId", paramString12);
    a(WeekCleanDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到双周保洁订单评价页");
  }
  
  public void toComplainDetail(String paramString)
  {
    Intent localIntent = new Intent(this.c, ComplainDetailActivity.class);
    localIntent.putExtra("consultId", paramString);
    localIntent.setFlags(268435456);
    u.i(this.e, "跳转到投诉详情页,consultId:" + paramString);
    this.c.startActivity(localIntent);
  }
  
  public void toGeneralCleanDetailActivity(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cleanId", paramString1);
    localHashMap.put("cleanerId", paramString2);
    a(GeneralOrderDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到通用保洁订单详情页");
  }
  
  public void toGeneralCleaningActivity(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ServiceInfoId", paramString1);
    localHashMap.put("ServiceInfoName", paramString2);
    localHashMap.put("isZhengZu", "isZhengZu");
    a(GeneralCleaningActivity.class, localHashMap);
    u.i(this.e, "跳转到整租保洁预约页");
  }
  
  public void toGeneralEvalActivity(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString1);
    localHashMap.put("generalPrice", paramString2);
    localHashMap.put("cleanerId", paramString3);
    a(GeneralCleaningEvalActivity.class, localHashMap);
    u.i(this.e, "跳转到通用保洁订单评价页");
  }
  
  public void toInitiatorDetailActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contract_code", paramString);
    a(SubletInitiatorDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到转租详情页");
  }
  
  public void toMHEstimateActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("workOrderId", paramString);
    a(SmallMoveEvalActivity.class, localHashMap);
    u.i(this.e, "跳转到自如中搬评价界面");
  }
  
  public void toMHOrderDetailActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString);
    localHashMap.put("moveOrderType", "move_small");
    a(com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到自如中搬订单详情界面");
  }
  
  public void toMovingEvalActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString);
    a(MovingEvalActivity.class, localHashMap);
    u.i(this.e, "跳转到自如大搬评价页");
  }
  
  public void toMovingVanDetailActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderId", paramString);
    localHashMap.put("moveOrderType", "move_van");
    a(com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到自如箱货订单详情界面");
  }
  
  public void toNewGeneralCleanDetailActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cleanId", paramString);
    a(PeriodGeneralDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到新通用保洁订单详情页20171017");
  }
  
  public void toReservationDetailActivity(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("reserveCode", paramString);
    a(SubletReservationDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到预订单详情页");
  }
  
  public void toServiceOrderDetail(String paramString)
  {
    Intent localIntent = new Intent(this.c, RentNewDetailActivity.class);
    localIntent.putExtra("serviceProjectId", paramString);
    localIntent.setFlags(268435456);
    u.i(this.e, "跳转到工单详情页,serviceProjectId:" + paramString);
    this.c.startActivity(localIntent);
  }
  
  public void toStationEvaluate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dName", paramString1);
    localHashMap.put("phone", paramString2);
    localHashMap.put("orderBid", paramString3);
    localHashMap.put("orderNumber", paramString4);
    localHashMap.put("projectBid", paramString5);
    localHashMap.put("houseTypeNames", paramString6);
    a(StationEvaluateActivity.class, localHashMap);
    u.i(this.e, "跳转到自如驿评价界面");
  }
  
  public void toStationOrderDetail(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderBid", paramString);
    a(com.ziroom.ziroomcustomer.ziroomstation.OrderDetailActivity.class, localHashMap);
    u.i(this.e, "跳转到自如驿订单详情页orderBid" + paramString);
  }
  
  public class a
    extends TimerTask
  {
    public a() {}
    
    public void run()
    {
      if (LodingProgressDialog.getDialog() != null) {
        LodingProgressDialog.dismiss();
      }
      if (a.a(a.this) != null) {
        a.this.showHandleToast("");
      }
      a.a(a.this, null);
    }
  }
  
  public class b
    extends TimerTask
  {
    public b() {}
    
    public void run()
    {
      if (LodingProgressDialog.getDialog() != null) {
        LodingProgressDialog.dismiss();
      }
      if (a.a(a.this) != null) {
        a.this.showHandleToast("网络超时");
      }
      a.a(a.this, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */