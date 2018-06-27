package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseListActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.HomeH5WebActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.SerachQuestionActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanGiftCardActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerSelectActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.StationProjectDetailActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class ai
{
  private static void a(Context paramContext, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("android");
    if ((!TextUtils.isEmpty(str1)) && (ah.stringToInteger(ah.getVersion(paramContext)) < ah.stringToInteger(str1))) {}
    String str2;
    do
    {
      return;
      str1 = paramUri.getQueryParameter("product");
      str2 = paramUri.getQueryParameter("function");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
      case 0: 
        d(paramContext, str2, paramUri);
        return;
        if (str1.equals("apartment"))
        {
          i = 0;
          continue;
          if (str1.equals("minsu"))
          {
            i = 1;
            continue;
            if (str1.equals("ZRService"))
            {
              i = 2;
              continue;
              if (str1.equals("rent"))
              {
                i = 3;
                continue;
                if (str1.equals("station"))
                {
                  i = 4;
                  continue;
                  if (str1.equals("credit"))
                  {
                    i = 5;
                    continue;
                    if (str1.equals("common")) {
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
    c(paramContext, str2, paramUri);
    return;
    b(paramContext, str2, paramUri);
    return;
    f(paramContext, str2, paramUri);
    return;
    e(paramContext, str2, paramUri);
    return;
    a(paramContext, str2, paramUri);
    return;
    g(paramContext, str2, paramUri);
  }
  
  private static void a(Context paramContext, String paramString, Uri paramUri)
  {
    u.d("onCreditAction", "========   uri= " + paramUri);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("to_ZiRoomScoreAuthorization"))
        {
          i = 0;
          continue;
          if (paramString.equals("to_ZiRoomScorePromote")) {
            i = 1;
          }
        }
        break;
      }
    }
    if (!ApplicationEx.c.isLoginState())
    {
      LocalBroadcastManager.getInstance(paramContext).registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getIntExtra("type", 0) == 1) {
            Routers.open(this.a, "ziroomCustomer://zrCreditModule/impowerView");
          }
        }
      }, new IntentFilter("com.ziroom.commonlibrary.login.broadcast"));
      paramContext.startActivity(new Intent(paramContext, ServiceLoginActivity.class));
      return;
    }
    Routers.open(paramContext, "ziroomCustomer://zrCreditModule/impowerView");
    return;
    if (!ApplicationEx.c.isLoginState())
    {
      LocalBroadcastManager.getInstance(paramContext).registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getIntExtra("type", 0) == 1) {
            Routers.open(this.a, "ziroomCustomer://zrCreditModule/scorePromoteView");
          }
        }
      }, new IntentFilter("com.ziroom.commonlibrary.login.broadcast"));
      paramContext.startActivity(new Intent(paramContext, ServiceLoginActivity.class));
      return;
    }
    Routers.open(paramContext, "ziroomCustomer://zrCreditModule/scorePromoteView");
  }
  
  private static void b(Context paramContext, String paramString, Uri paramUri)
  {
    u.d("onServiceAction", "========   uri= " + paramUri);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("to_Search_QuestionsView"))
        {
          i = 0;
          continue;
          if (paramString.equals("toCleanRichang"))
          {
            i = 1;
            continue;
            if (paramString.equals("toCleanShendu"))
            {
              i = 2;
              continue;
              if (paramString.equals("toCleanKaihuang"))
              {
                i = 3;
                continue;
                if (paramString.equals("toCleanXiaosha"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("toCleanChuman"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("toCleanCaboli"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("toCleanMinsu"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("toCleanBedroom"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("toMoveXiaoban"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("toMoveSmall"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("toMoveXianghuo"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("toMoveJingzhi"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("toMoveList"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("toCleanList"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("toYouPinGoodsDetails"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("toPeriodCleanReservation"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("toCompanyOrder"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("toGiftCardBuyView")) {
                                              i = 18;
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
    paramString = new Intent(paramContext, SerachQuestionActivity.class);
    paramString.putExtra("search", paramUri.getQueryParameter("serachStr"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
    paramString.putExtra("ServiceInfoName", "日常保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "2c9084434b783482014b784188290209");
    paramString.putExtra("ServiceInfoName", "深度保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
    paramString.putExtra("ServiceInfoName", "开荒保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
    paramString.putExtra("ServiceInfoName", "消杀保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "8a90a5d85841edb0015847dd78a80014");
    paramString.putExtra("ServiceInfoName", "除螨保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "8a90a5d8580a5cb2015822c397920018");
    paramString.putExtra("ServiceInfoName", "擦玻璃");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
    paramString.putExtra("ServiceInfoName", "民宿保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, CleanIndexActivity.class);
    paramString.putExtra("ServiceInfoId", "8a90a5d85841edb0015847dd11110000");
    paramString.putExtra("ServiceInfoName", "卧室保洁");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, MovingIndexActivity.class);
    paramString.putExtra("productCode", "2c9085f248ba3f3a0148bb156f6e0004");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, MovingIndexActivity.class);
    paramString.putExtra("productCode", "8a908eb161d66afc0161fa59fd210009");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, MovingIndexActivity.class);
    paramString.putExtra("productCode", "8a90a5f8593e65b501593e65b5200000");
    paramString.putExtra("enCity", paramUri.getQueryParameter("enCity"));
    paramContext.startActivity(paramString);
    return;
    paramString = q.q + "app/intro/jzxh.shtml?source=jzxh";
    Intent localIntent = new Intent(paramContext, HomeH5WebActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("ziru", "finish_web");
    localIntent.putExtra("ziru_back", "ziru_back_main");
    localIntent.putExtra("title", "精致搬家");
    localIntent.putExtra("content", "自如这个服务不错，快来预约体验吧~");
    paramString = "not_show";
    String str = paramString;
    if (!TextUtils.isEmpty(paramUri.getQueryParameter("enCity")))
    {
      paramUri = j.getSplitCityCode(paramUri.getQueryParameter("enCity"), ",").iterator();
      str = paramString;
      if (paramUri.hasNext())
      {
        str = (String)paramUri.next();
        if (!b.d.equals(str)) {
          break label1472;
        }
        paramString = "can_show";
      }
    }
    label1472:
    for (;;)
    {
      break;
      localIntent.putExtra("isEnCity", str);
      paramContext.startActivity(localIntent);
      return;
      paramString = new Intent(paramContext, MoveTypeActivity.class);
      paramString.putExtra("recommendCode", paramUri.getQueryParameter("recommendCode"));
      paramString.putExtra("channelCode", paramUri.getQueryParameter("channelCode"));
      paramContext.startActivity(paramString);
      return;
      paramContext.startActivity(new Intent(paramContext, CleanHomeActivity.class));
      return;
      paramString = new Intent(paramContext, GoodsDetailAc.class);
      paramString.putExtra("productCode", paramUri.getQueryParameter("productCode"));
      paramString.putExtra("skuCode", paramUri.getQueryParameter("skuCode"));
      paramContext.startActivity(paramString);
      return;
      PeriodCleanerSelectActivity.StartPeriodCleanActivity((Activity)paramContext);
      return;
      JsBridgeWebActivity.start(paramContext, "企业搬家", q.q + "app/intro/qybj.shtml?source=qybj", false, "", "", false);
      return;
      paramContext.startActivity(new Intent(paramContext, CleanGiftCardActivity.class));
      return;
    }
  }
  
  private static void c(Context paramContext, String paramString, Uri paramUri)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    String str;
    do
    {
      return;
      if (!paramString.equals("to_house_detail")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("to_top50_house_list")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("to_tenant_home")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("to_ll_house_list")) {
        break;
      }
      i = 3;
      break;
      paramString = paramUri.getQueryParameter("istop50");
      str = paramUri.getQueryParameter("fid");
      paramUri = paramUri.getQueryParameter("rentWay");
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramUri)));
    k.toHouseDetail(paramContext, str, paramUri, "1".equals(paramString));
    return;
    paramContext.startActivity(new Intent(paramContext, MinsuTopHouseListActivity.class));
    return;
    paramString = new Intent(paramContext, MainActivity.class);
    paramString.putExtra("FRAGMENT_TYPE", 2);
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
    return;
    paramString = new Bundle();
    paramString.putString("from", ai.class.getSimpleName());
    k.goLLHouseList(paramContext, paramString);
  }
  
  private static void d(Context paramContext, String paramString, Uri paramUri)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!paramString.equals("to_apartment_detail")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("to_apartment_home")) {
        break;
      }
      i = 1;
      break;
      paramString = paramUri.getQueryParameter("projectId");
    } while (TextUtils.isEmpty(paramString));
    com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(paramContext, paramString);
    return;
    paramString = new Intent(paramContext, MainActivity.class);
    paramString.putExtra("FRAGMENT_TYPE", 1);
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  private static void e(Context paramContext, String paramString, Uri paramUri)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!paramString.equals("to_station_detail")) {
        break;
      }
      i = 0;
      break;
      paramString = paramUri.getQueryParameter("projectBid");
      paramUri = new Intent(paramContext, StationProjectDetailActivity.class);
    } while (TextUtils.isEmpty(paramString));
    paramUri.putExtra("projectBid", paramString);
    paramContext.startActivity(paramUri);
  }
  
  private static void f(Context paramContext, String paramString, Uri paramUri)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("toRentHomePage"))
        {
          i = 0;
          continue;
          if (paramString.equals("toRentHouseDetail"))
          {
            i = 1;
            continue;
            if (paramString.equals("toSocialActivity"))
            {
              i = 2;
              continue;
              if (paramString.equals("toAppOpenH5")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    paramString = new Intent(paramContext, MainActivity.class);
    paramString.putExtra("FRAGMENT_TYPE", 0);
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, RentHouseDetailActivity.class);
    paramString.putExtra("id", paramUri.getQueryParameter("id"));
    paramString.putExtra("house_id", paramUri.getQueryParameter("houseId"));
    paramString.putExtra("SIGNBACK", "SIGNBACK");
    paramContext.startActivity(paramString);
    return;
    paramString = new Intent(paramContext, AcMainActivity.class);
    paramString.putExtra("cityCode", paramUri.getQueryParameter("cityCode"));
    paramString.putExtra("backToMain", true);
    paramContext.startActivity(paramString);
    return;
    JsBridgeWebActivity.start(paramContext, paramUri.getQueryParameter("title"), paramUri.getQueryParameter("link"), true, paramUri.getQueryParameter("subTitle"), paramUri.getQueryParameter("imgUrl"), true);
  }
  
  private static void g(Context paramContext, String paramString, Uri paramUri)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("to_myziroom"))
        {
          i = 0;
          continue;
          if (paramString.equals("to_myaccount"))
          {
            i = 1;
            continue;
            if (paramString.equals("to_mycoupon")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString = new Intent(paramContext, MainActivity.class);
    paramString.putExtra("FRAGMENT_TYPE", 7);
    paramContext.startActivity(paramString);
    return;
    if (ApplicationEx.c.isLoginState())
    {
      paramString = new Intent(paramContext, AccountMainActivity.class);
      if (!(paramContext instanceof Activity)) {
        paramString.setFlags(268435456);
      }
      paramContext.startActivity(paramString);
      return;
    }
    paramString = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = paramAnonymousIntent.getIntExtra("type", 0);
        int j = paramAnonymousIntent.getIntExtra("status", 0);
        if ((i == 17) && (j == 1))
        {
          paramAnonymousIntent = new Intent(paramAnonymousContext, AccountMainActivity.class);
          if (!(paramAnonymousContext instanceof Activity)) {
            paramAnonymousIntent.setFlags(268435456);
          }
          paramAnonymousContext.startActivity(paramAnonymousIntent);
        }
      }
    };
    paramUri = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(paramContext).registerReceiver(paramString, paramUri);
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
    return;
    if (ApplicationEx.c.isLoginState())
    {
      paramString = new Intent(paramContext, MyCouponActivity.class);
      if (!(paramContext instanceof Activity)) {
        paramString.setFlags(268435456);
      }
      paramContext.startActivity(paramString);
      return;
    }
    paramString = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = paramAnonymousIntent.getIntExtra("type", 0);
        int j = paramAnonymousIntent.getIntExtra("status", 0);
        if ((i == 17) && (j == 1))
        {
          paramAnonymousIntent = new Intent(paramAnonymousContext, MyCouponActivity.class);
          if (!(paramAnonymousContext instanceof Activity)) {
            paramAnonymousIntent.setFlags(268435456);
          }
          paramAnonymousContext.startActivity(paramAnonymousIntent);
        }
      }
    };
    paramUri = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(paramContext).registerReceiver(paramString, paramUri);
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
  
  public static boolean onRoute(Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      paramIntent = paramIntent.getData();
      if (("android.intent.action.VIEW".equals(str)) && (paramIntent != null))
      {
        paramIntent = paramIntent.getQueryParameter("p");
        if (com.freelxl.baselibrary.f.f.notNull(paramIntent))
        {
          paramIntent = URLDecoder.decode(paramIntent);
          try
          {
            paramIntent = new String(f.decode(paramIntent), "UTF-8");
            if (!TextUtils.isEmpty(paramIntent))
            {
              a(paramActivity, Uri.parse("ziroom://ziroom.app/openApp?" + paramIntent));
              paramActivity.finish();
              return true;
            }
          }
          catch (UnsupportedEncodingException paramIntent)
          {
            for (;;)
            {
              paramIntent.printStackTrace();
              paramIntent = null;
            }
          }
          return false;
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */