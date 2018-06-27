package com.ziroom.ziroomcustomer.newchat.chatcenter.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.LeaseActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.n;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.p;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.gesturelock.GestureLockActivity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.my.MyStewardListActivity;
import com.ziroom.ziroomcustomer.my.model.MyStewardListEntity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.NetPhoneActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.SuggAndComActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ForCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.RefactorMHMainActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairSelectActivity;
import com.ziroom.ziroomcustomer.reserve.BookingOrderActivity;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  protected static String a;
  private static List<MyStewardListEntity> b;
  
  public static void ToAotherActivity(Activity paramActivity, com.ziroom.ziroomcustomer.newchat.chatcenter.b.g paramg)
  {
    if (paramg == null) {
      return;
    }
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
      return;
    }
    if (1 == paramg.getFormType())
    {
      paramg = paramg.getFormUrl();
      int i = -1;
      switch (paramg.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        case 0: 
          com.ziroom.ziroomcustomer.newServiceList.utils.j.toZiRuRepairV2(paramActivity);
          return;
          if (paramg.equals("toRepair"))
          {
            i = 0;
            continue;
            if (paramg.equals("toClean"))
            {
              i = 1;
              continue;
              if (paramg.equals("toContract"))
              {
                i = 2;
                continue;
                if (paramg.equals("ZRQuestionDetailLinkToUrlTypeSuggestions"))
                {
                  i = 3;
                  continue;
                  if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeSuggestions.ziroom.com"))
                  {
                    i = 4;
                    continue;
                    if (paramg.equals("ZRQuestionDetailLinkToUrlTypeSearchHome"))
                    {
                      i = 5;
                      continue;
                      if (paramg.equals("ZRQuestionDetailLinkToUrlTypeContract"))
                      {
                        i = 6;
                        continue;
                        if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeContract.ziroom.com"))
                        {
                          i = 7;
                          continue;
                          if (paramg.equals("ZRQuestionDetailLinkToUrlTypeFortnight"))
                          {
                            i = 8;
                            continue;
                            if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeFortnight.ziroom.com"))
                            {
                              i = 9;
                              continue;
                              if (paramg.equals("ZRQuestionDetailLinkToUrlTypeFortnightOrderList"))
                              {
                                i = 10;
                                continue;
                                if (paramg.equals("ZRQuestionDetailLinkToUrlTypeCleanNormal"))
                                {
                                  i = 11;
                                  continue;
                                  if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeDailycleaning.ziroom.com"))
                                  {
                                    i = 12;
                                    continue;
                                    if (paramg.equals("ZRQuestionDetailLinkToUrlTypeCleanNormalOrderList"))
                                    {
                                      i = 13;
                                      continue;
                                      if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeDailycleaningOrderList.ziroom.com"))
                                      {
                                        i = 14;
                                        continue;
                                        if (paramg.equals("ZRQuestionDetailLinkToUrlTypeCleanXiaoSha"))
                                        {
                                          i = 15;
                                          continue;
                                          if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeXiaoSha.ziroom.com"))
                                          {
                                            i = 16;
                                            continue;
                                            if (paramg.equals("ZRQuestionDetailLinkToUrlTypeCleanShengdu"))
                                            {
                                              i = 17;
                                              continue;
                                              if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeShendu.ziroom.com"))
                                              {
                                                i = 18;
                                                continue;
                                                if (paramg.equals("ZRQuestionDetailLinkToUrlTypeCleanKaihuang"))
                                                {
                                                  i = 19;
                                                  continue;
                                                  if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeKaihuang.ziroom.com"))
                                                  {
                                                    i = 20;
                                                    continue;
                                                    if (paramg.equals("ZRQuestionDetailLinkToUrlTypeMove"))
                                                    {
                                                      i = 21;
                                                      continue;
                                                      if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeHousemoving.ziroom.com"))
                                                      {
                                                        i = 22;
                                                        continue;
                                                        if (paramg.equals("ZRQuestionDetailLinkToUrlTypeMoveOrderList"))
                                                        {
                                                          i = 23;
                                                          continue;
                                                          if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeHousemovingOrderList.ziroom.com"))
                                                          {
                                                            i = 24;
                                                            continue;
                                                            if (paramg.equals("ZRQuestionDetailLinkToUrlTypeRepair"))
                                                            {
                                                              i = 25;
                                                              continue;
                                                              if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeRepair.ziroom.com"))
                                                              {
                                                                i = 26;
                                                                continue;
                                                                if (paramg.equals("ZRQuestionDetailLinkToUrlTypeRepairOrderList"))
                                                                {
                                                                  i = 27;
                                                                  continue;
                                                                  if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeRepairOrderList.ziroom.com"))
                                                                  {
                                                                    i = 28;
                                                                    continue;
                                                                    if (paramg.equals("ZRQuestionDetailLinkToUrlTypeKuanDai"))
                                                                    {
                                                                      i = 29;
                                                                      continue;
                                                                      if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeKuanDai.ziroom.com"))
                                                                      {
                                                                        i = 30;
                                                                        continue;
                                                                        if (paramg.equals("ZRQuestionDetailLinkToUrlTypeGuanJia"))
                                                                        {
                                                                          i = 31;
                                                                          continue;
                                                                          if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeHousekeeper.ziroom.com"))
                                                                          {
                                                                            i = 32;
                                                                            continue;
                                                                            if (paramg.equals("ZRQuestionDetailLinkToUrlTypeZhiNengSou"))
                                                                            {
                                                                              i = 33;
                                                                              continue;
                                                                              if (paramg.equals("http://ZRQuestionDetailLinkToUrlTypeIintelligentlock.ziroom.com"))
                                                                              {
                                                                                i = 34;
                                                                                continue;
                                                                                if (paramg.equals("http://zrquestiondetaillinktourltypewallet.ziroom.com"))
                                                                                {
                                                                                  i = 35;
                                                                                  continue;
                                                                                  if (paramg.equals("http://zrquestiondetaillinktourltypecredit.ziroom.com"))
                                                                                  {
                                                                                    i = 36;
                                                                                    continue;
                                                                                    if (paramg.equals("http://zrquestiondetaillinktourltypequalification.ziroom.com"))
                                                                                    {
                                                                                      i = 37;
                                                                                      continue;
                                                                                      if (paramg.equals("http://zrquestiondetaillinktourltypecontractxueli.ziroom.com"))
                                                                                      {
                                                                                        i = 38;
                                                                                        continue;
                                                                                        if (paramg.equals("http://zrquestiondetaillinktourltypeschedule.ziroom.com"))
                                                                                        {
                                                                                          i = 39;
                                                                                          continue;
                                                                                          if (paramg.equals("http://zrquestiondetaillinktourltypesearch.ziroom.com"))
                                                                                          {
                                                                                            i = 40;
                                                                                            continue;
                                                                                            if (paramg.equals("http://zrquestiondetaillinktourltypeconsignation.ziroom.com")) {
                                                                                              i = 41;
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
      paramActivity.startActivity(new Intent(paramActivity, CleanHomeActivity.class));
      return;
      paramActivity.startActivity(new Intent(paramActivity, LeaseActivity.class));
      return;
      paramActivity.startActivity(new Intent(paramActivity, SuggAndComActivity.class));
      return;
      paramg = new SearchCondition();
      Intent localIntent = new Intent(paramActivity, HouseListActivity.class);
      paramg.setHouse_type("合租");
      localIntent.putExtra("searchCondition", paramg);
      paramActivity.startActivity(localIntent);
      return;
      paramActivity.startActivity(new Intent(paramActivity, LeaseActivity.class));
      return;
      paramg = ApplicationEx.c.getContracts();
      if ((paramg != null) && (paramg.size() > 0))
      {
        paramActivity.startActivity(new Intent(paramActivity, ForCleaningActivity.class));
        return;
      }
      af.showToast(paramActivity, "只有自如客可以进入");
      return;
      paramg = new Intent(paramActivity, ZiroomOrderListActivity.class);
      paramg.putExtra("ServiceList", "weekclean");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, GeneralCleaningActivity.class);
      paramg.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
      paramg.putExtra("ServiceInfoName", "日常保洁");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, ZiroomOrderListActivity.class);
      paramg.putExtra("ServiceList", "clean");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, GeneralCleaningActivity.class);
      paramg.putExtra("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
      paramg.putExtra("ServiceInfoName", "消杀保洁");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, GeneralCleaningActivity.class);
      paramg.putExtra("ServiceInfoId", "2c9084434b783482014b784188290209");
      paramg.putExtra("ServiceInfoName", "深度保洁");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, GeneralCleaningActivity.class);
      paramg.putExtra("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
      paramg.putExtra("ServiceInfoName", "开荒保洁");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, RefactorMHMainActivity.class);
      paramg.putExtra("serviceInfoId", "2c9085f248ba3f3a0148bb156f6e0004");
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent(paramActivity, ZiroomOrderListActivity.class);
      paramg.putExtra("ServiceList", "move");
      paramActivity.startActivity(paramg);
      return;
      paramg = ApplicationEx.c.getContracts();
      if ((paramg != null) && (paramg.size() > 0))
      {
        paramActivity.startActivity(new Intent(paramActivity, InternalRepairSelectActivity.class));
        return;
      }
      af.showToast(paramActivity, "只有自如客可以进入");
      return;
      paramActivity.startActivity(new Intent(paramActivity, ZiroomOrderListActivity.class));
      return;
      paramg = ApplicationEx.c.getContracts();
      if ((paramg != null) && (paramg.size() > 0))
      {
        if (paramg.size() == 1)
        {
          localIntent = new Intent(paramActivity, NetPhoneActivity.class);
          localIntent.putExtra("contractAddress", (Serializable)paramg.get(0));
          paramActivity.startActivity(localIntent);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(paramActivity, "多合同查询用户默认查看第一个");
        return;
      }
      af.showToast(paramActivity, "只有自如客可以进入");
      return;
      a(paramActivity);
      return;
      paramg = new Intent();
      paramg.setClass(paramActivity, GestureLockActivity.class);
      paramg.putExtra("to", GestureLockActivity.class.getName());
      paramActivity.startActivity(paramg);
      return;
      paramg = new Intent();
      paramg.setClass(paramActivity, AccountMainActivity.class);
      paramActivity.startActivity(paramg);
      return;
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
        return;
      }
      Routers.open(paramActivity, "ziroomCustomer://zrCreditModule/home");
      return;
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
        return;
      }
      paramg = new Intent(paramActivity, SignerAptitudeActivity.class);
      paramg.addFlags(335544320);
      paramg.putExtra("activityName", "AccountInfoActivity");
      paramActivity.startActivity(paramg);
      return;
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
        return;
      }
      paramActivity.startActivity(new Intent(paramActivity, EducationActivity.class));
      return;
      paramg = new Intent(paramActivity, BookingOrderActivity.class);
      paramg.putExtra("from", "orders");
      paramActivity.startActivity(paramg);
      return;
      paramg = new SearchCondition();
      localIntent = new Intent(paramActivity, HouseListActivity.class);
      paramg.setHouse_type("合租");
      localIntent.putExtra("searchCondition", paramg);
      paramActivity.startActivity(localIntent);
      return;
      JsBridgeWebActivity.start(paramActivity, null, q.ai);
      return;
    }
    JsBridgeWebActivity.start(paramActivity, paramg.getFormName(), paramg.getFormUrl());
  }
  
  private static void a(final Activity paramActivity)
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(paramActivity));
    com.freelxl.baselibrary.d.a.get(q.R + e.p.a).tag(paramActivity).params(com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(localHashMap)).enqueue(new f(paramActivity, new n())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        d.d("OKHttp", "===" + paramAnonymousb.toString());
        a.a(com.alibaba.fastjson.a.parseArray(paramAnonymousb.toString(), MyStewardListEntity.class));
        if (a.a() != null)
        {
          if (a.a().size() == 1)
          {
            paramAnonymousb = new Intent(paramActivity, MyStewardInfoActivity.class);
            paramAnonymousb.putExtra("contractCode", ((MyStewardListEntity)a.a().get(0)).getContractCode() + "");
            paramActivity.startActivity(paramAnonymousb);
          }
        }
        else {
          return;
        }
        Intent localIntent = new Intent(paramActivity, MyStewardListActivity.class);
        localIntent.putExtra("stewardList", paramAnonymousb.toString());
        paramActivity.startActivity(localIntent);
      }
    });
  }
  
  private static void b(final Activity paramActivity, final String paramString)
  {
    com.ziroom.ziroomcustomer.e.j.getCertInfo(paramActivity, com.ziroom.commonlibrary.login.a.getToken(paramActivity), 1, new f(paramActivity, new o())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
        Intent localIntent;
        if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {
          localIntent = new Intent();
        }
        switch (paramAnonymouse.credits.realNameStatus)
        {
        default: 
          return;
        case 2: 
          localIntent.setClass(paramActivity, CertificationInfoActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", paramString);
          localIntent.putExtra("type", 0);
          paramActivity.startActivity(localIntent);
          return;
        case 3: 
          localIntent.setClass(paramActivity, CertificationInfoActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", paramString);
          localIntent.putExtra("type", 0);
          paramActivity.startActivity(localIntent);
          return;
        case 4: 
          localIntent.setClass(paramActivity, CertificationInfoActivity.class);
          localIntent.putExtra("type", 0);
          localIntent.putExtra("phone", paramString);
          localIntent.putExtra("cert_info", paramAnonymouse);
          paramActivity.startActivity(localIntent);
          return;
        case 1: 
          if ("1".equals(paramAnonymouse.getCert_type()))
          {
            localIntent.setClass(paramActivity, CertInformationActivity.class);
            localIntent.putExtra("cert_info", paramAnonymouse);
            localIntent.putExtra("type", 0);
            localIntent.putExtra("phone", paramString);
            paramActivity.startActivity(localIntent);
            return;
          }
          localIntent.setClass(paramActivity, CertificationInfoActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", paramString);
          localIntent.putExtra("type", 0);
          paramActivity.startActivity(localIntent);
          return;
        }
        localIntent.setClass(paramActivity, CertInformationActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", paramString);
        localIntent.putExtra("type", 0);
        paramActivity.startActivity(localIntent);
      }
    });
  }
  
  public static void doSign(Activity paramActivity)
  {
    com.ziroom.commonlibrary.login.a.getUserInfo(paramActivity, new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        a.a = (String)paramAnonymouse.get("phone");
        if (!TextUtils.isEmpty(a.a))
        {
          a.a(this.a, a.a);
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(this.a);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */