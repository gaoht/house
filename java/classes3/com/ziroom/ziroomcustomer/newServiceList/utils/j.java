package com.ziroom.ziroomcustomer.newServiceList.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.activity.IntellectLockActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.gesturelock.GestureLockActivity;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyStewardListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairBuyCardActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderNewActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceWebActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.at;
import com.ziroom.ziroomcustomer.newServiceList.model.aw;
import com.ziroom.ziroomcustomer.newServiceList.model.ay.a;
import com.ziroom.ziroomcustomer.newServiceList.model.ay.b;
import com.ziroom.ziroomcustomer.newServiceList.model.ay.c;
import com.ziroom.ziroomcustomer.newServiceList.model.bi;
import com.ziroom.ziroomcustomer.newServiceList.model.m.a;
import com.ziroom.ziroomcustomer.newServiceList.model.m.b;
import com.ziroom.ziroomcustomer.newServiceList.model.m.c;
import com.ziroom.ziroomcustomer.newServiceList.model.m.d;
import com.ziroom.ziroomcustomer.newServiceList.model.m.e;
import com.ziroom.ziroomcustomer.newServiceList.model.m.f;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanAddressActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ForCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo.InviteMo;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.newclean.d.bh;
import com.ziroom.ziroomcustomer.newclean.d.bh.a;
import com.ziroom.ziroomcustomer.newclean.d.bh.b;
import com.ziroom.ziroomcustomer.newclean.d.o.a;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralChargeBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralChargeBean.ChargesBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralChargeBean.ChargesBean.ItemsBean;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean.ChargesBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean.ChargesBean.ItemsBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairSelectActivity;
import com.ziroom.ziroomcustomer.newrepair.b.s.b;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class j
{
  public static void LogLongMessage(String paramString)
  {
    if (paramString.length() > 4000)
    {
      int i = 0;
      if (i < paramString.length())
      {
        if (i + 4000 < paramString.length()) {
          u.d("rescounter" + i, "=======    " + paramString.substring(i, i + 4000));
        }
        for (;;)
        {
          i += 4000;
          break;
          u.d("rescounter" + i, "=======    " + paramString.substring(i, paramString.length()));
        }
      }
    }
    else
    {
      u.d("resinfo", "=======    " + paramString);
    }
  }
  
  public static void addComFlke(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-6710887);
      localButton.setTextSize(10.0F);
      localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localButton.setBackgroundResource(2130838212);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), 0);
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
    }
  }
  
  public static void addDetailFlke(Context paramContext, String[] paramArrayOfString, FlowLayout paramFlowLayout)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfString[i];
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-6710887);
      localButton.setTextSize(12.0F);
      localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 6.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 6.0F));
      localButton.setBackgroundResource(2130839521);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), 0);
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
      i += 1;
    }
  }
  
  public static void addFlke(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-6710887);
      localButton.setTextSize(10.0F);
      localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localButton.setBackgroundResource(2130838212);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), 0);
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
    }
  }
  
  public static void addShowFlke(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-6710887);
      localButton.setTextSize(10.0F);
      localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localButton.setBackgroundResource(2130838212);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), 0);
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
    }
  }
  
  public static void addZzSocialFlke(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-12303292);
      localButton.setTextSize(14.0F);
      localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localButton.setBackgroundResource(2130840444);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
    }
  }
  
  public static void addZzSocialFlke2(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      TextView localTextView = new TextView(paramContext);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTag(Boolean.valueOf(false));
      localTextView.setTextColor(-12303292);
      localTextView.setTextSize(14.0F);
      localTextView.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localTextView.setBackgroundResource(2130840444);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 5.0F));
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localTextView);
    }
  }
  
  public static void click2Clean(Context paramContext, o.a parama)
  {
    String str1 = parama.getServiceInfoId();
    String str2 = parama.getServiceInfoName();
    int i = parama.getOpen();
    int j = parama.getApp();
    int k = parama.getZhengZu();
    int m = parama.getTargetType();
    if ("ff8080813164497d01316483ef880023".equals(str1)) {
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
        g.textToast(paramContext, "请先登录");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (i == 0)
            {
              g.textToast(paramContext, "服务尚未开通，敬请期待");
              return;
            }
          } while (i != 1);
          parama = ApplicationEx.c.getContracts();
          if ((parama != null) && (parama.size() > 0))
          {
            parama = new Intent(paramContext, ForCleaningActivity.class);
            parama.putExtra("ServiceInfoId", str1);
            parama.putExtra("ServiceInfoName", str2);
            paramContext.startActivity(parama);
            return;
          }
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean) {}
          }).build().show();
          return;
          if (i == 0)
          {
            g.textToast(paramContext, "服务尚未开通，敬请期待");
            return;
          }
        } while (i != 1);
        if (j == 0)
        {
          JsBridgeWebActivity.start(paramContext, parama.getServiceInfoName(), parama.getTargetUrl(), true, parama.getSlogan(), parama.getPicUrl(), false);
          return;
        }
      } while (j != 1);
      if (m == 1)
      {
        if (k == 1)
        {
          parama = new Intent(paramContext, GeneralCleaningActivity.class);
          parama.putExtra("isZhengZu", "isZhengZu");
          parama.putExtra("ServiceInfoId", str1);
          parama.putExtra("ServiceInfoName", str2);
        }
        for (;;)
        {
          paramContext.startActivity(parama);
          return;
          parama = new Intent(paramContext, CleanIndexActivity.class);
          parama.putExtra("ServiceInfoId", str1);
          parama.putExtra("ServiceInfoName", str2);
          parama.putExtra("shareImage", "");
          parama.putExtra("serviceContent", "");
        }
      }
      if (m == 2)
      {
        paramContext.startActivity(new Intent(paramContext, CleanStoredCardBuyActivity.class));
        return;
      }
    } while (m != 3);
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      g.textToast(paramContext, "请先登录");
      return;
    }
    parama = new Intent(paramContext, RepairOrderNewActivity.class);
    parama.putExtra("serviceInfoId", str1);
    parama.putExtra("serviceInfoName", str2);
    paramContext.startActivity(parama);
  }
  
  public static void createShareInfo(final Context paramContext, String paramString1, String paramString2, String paramString3, final String paramString4, final com.ziroom.ziroomcustomer.newServiceList.model.m paramm)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    final String str = localUserInfo.getUid();
    com.ziroom.ziroomcustomer.e.n.createShareOrder(paramContext, paramString1, paramString2, paramString3, paramString4, str, localUserInfo.getRealName(), localUserInfo.getPhone(), new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.ziroom.ziroomcustomer.newServiceList.model.f.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.f paramAnonymousf)
      {
        String str1 = paramAnonymousf.getLogicCode();
        String str3 = paramAnonymousf.getCityCode();
        paramAnonymousf = new Intent(paramContext, HomeWebActivity.class);
        String str2 = paramm.getAppUrl().getContent() + "?orderShareCode=" + str1 + "&employeeCode=" + paramString4 + "&cityCode=" + str3 + "&userCode=" + str;
        str1 = paramm.getWechatUrl().getContent() + "?orderShareCode=" + str1 + "&employeeCode=" + paramString4 + "&cityCode=" + str3;
        paramAnonymousf.putExtra("url", str2);
        paramAnonymousf.putExtra("shareUrl", str1);
        paramAnonymousf.putExtra("shareTitle", paramm.getTitle().getContent());
        paramAnonymousf.putExtra("content", paramm.getDesc().getContent());
        paramAnonymousf.putExtra("pic", paramm.getPic().getContent());
        paramAnonymousf.putExtra("ziru", "serviceOrderShare");
        paramContext.startActivity(paramAnonymousf);
      }
    });
  }
  
  public static void createShareOrder(final Context paramContext, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    final String str = localUserInfo.getUid();
    com.ziroom.ziroomcustomer.e.n.createShareOrder(paramContext, paramString1, paramString2, paramString3, paramString4, str, localUserInfo.getRealName(), localUserInfo.getPhone(), new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.ziroom.ziroomcustomer.newServiceList.model.f.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.f paramAnonymousf)
      {
        String str = paramAnonymousf.getLogicCode();
        paramAnonymousf = paramAnonymousf.getCityCode();
        j.getShareInfo(paramContext, str, paramString4, paramAnonymousf, str);
      }
    });
  }
  
  public static Class getActivityClassByCMS(String paramString1, String paramString2, String paramString3)
  {
    if ("0".equals(paramString1))
    {
      i = -1;
      switch (paramString2.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    while (!"1".equals(paramString1))
    {
      for (;;)
      {
        int i;
        return null;
        if (paramString2.equals("clean_richang"))
        {
          i = 0;
          continue;
          if (paramString2.equals("clean_shendu"))
          {
            i = 1;
            continue;
            if (paramString2.equals("clean_xiaosha"))
            {
              i = 2;
              continue;
              if (paramString2.equals("clean_kaihuang"))
              {
                i = 3;
                continue;
                if (paramString2.equals("clean_minsu"))
                {
                  i = 4;
                  continue;
                  if (paramString2.equals("clean_caboli"))
                  {
                    i = 5;
                    continue;
                    if (paramString2.equals("clean_chuman"))
                    {
                      i = 6;
                      continue;
                      if (paramString2.equals("move_xiaoban"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_truck"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("repair_shuiluguanjian"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_dengjudianlu"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_kaisuohuansuo"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kongtiaoqingxi"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("card_repair"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_clean"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("upin_jiaju")) {
                                        i = 15;
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
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return CleanIndexActivity.class;
      return MovingIndexActivity.class;
      return MovingIndexActivity.class;
      return RepairOrderActivity.class;
      return RepairOrderActivity.class;
      return RepairOrderActivity.class;
      return RepairOrderActivity.class;
      return RepairBuyCardActivity.class;
      return CleanStoredCardBuyActivity.class;
      if (!TextUtils.isEmpty(ad.getOther(ApplicationEx.c.getApplicationContext(), "youpinH5url"))) {
        return YouPinGuidanceH5Activity.class;
      }
      return YouPinGuidanceActivity.class;
    }
    return JsBridgeWebActivity.class;
  }
  
  public static Bundle getBundleByCMS(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    int i;
    if ("0".equals(paramString1))
    {
      i = -1;
      switch (paramString2.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return localBundle;
        if (paramString2.equals("clean_richang"))
        {
          i = 0;
          continue;
          if (paramString2.equals("clean_shendu"))
          {
            i = 1;
            continue;
            if (paramString2.equals("clean_xiaosha"))
            {
              i = 2;
              continue;
              if (paramString2.equals("clean_kaihuang"))
              {
                i = 3;
                continue;
                if (paramString2.equals("clean_minsu"))
                {
                  i = 4;
                  continue;
                  if (paramString2.equals("clean_caboli"))
                  {
                    i = 5;
                    continue;
                    if (paramString2.equals("clean_chuman"))
                    {
                      i = 6;
                      continue;
                      if (paramString2.equals("move_xiaoban"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_truck"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("repair_shuiluguanjian"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_dengjudianlu"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_kaisuohuansuo"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kongtiaoqingxi"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("card_repair"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_clean"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("upin_jiaju")) {
                                        i = 15;
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
    localBundle.putString("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
    localBundle.putString("ServiceInfoName", "日常保洁");
    return localBundle;
    localBundle.putString("ServiceInfoId", "2c9084434b783482014b784188290209");
    localBundle.putString("ServiceInfoName", "深度保洁");
    return localBundle;
    localBundle.putString("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
    localBundle.putString("ServiceInfoName", "消杀保洁");
    return localBundle;
    localBundle.putString("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
    localBundle.putString("ServiceInfoName", "新居开荒");
    return localBundle;
    localBundle.putString("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
    localBundle.putString("ServiceInfoName", "民宿保洁");
    return localBundle;
    localBundle.putString("ServiceInfoId", "8a90a5d8580a5cb2015822c397920018");
    localBundle.putString("ServiceInfoName", "擦玻璃");
    return localBundle;
    localBundle.putString("ServiceInfoId", "8a90a5d85841edb0015847dd78a80014");
    localBundle.putString("ServiceInfoName", "专业除螨");
    return localBundle;
    localBundle.putString("productCode", "2c9085f248ba3f3a0148bb156f6e0004");
    return localBundle;
    localBundle.putString("productCode", "8a90a5f8593e65b501593e65b5200000");
    return localBundle;
    localBundle.putInt("type", 0);
    return localBundle;
    localBundle.putInt("type", 1);
    return localBundle;
    localBundle.putInt("type", 2);
    return localBundle;
    return null;
    return null;
    return null;
    return null;
  }
  
  public static String getChannelCode(String paramString)
  {
    String str2 = "";
    String str1;
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
        str1 = "202300010000";
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return str1;
            if ("2c9084434b783482014b784188290209".equals(paramString)) {
              return "203300010000";
            }
            if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
              return "204300010000";
            }
            if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
              return "205300010000";
            }
            str1 = str2;
          } while (!"8a90a5d8580a5cb2015822c397920018".equals(paramString));
          return "207300010000";
          if (!"310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
            break;
          }
          if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
            return "202300020000";
          }
          if ("2c9084434b783482014b784188290209".equals(paramString)) {
            return "203300020000";
          }
          if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
            return "204300020000";
          }
          if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
            return "205300020000";
          }
          str1 = str2;
        } while (!"8a90a5d8580a5cb2015822c397920018".equals(paramString));
        return "207300020000";
        str1 = str2;
      } while (!"440300".equals(com.ziroom.ziroomcustomer.base.b.d));
      if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
        return "202300030000";
      }
      if ("2c9084434b783482014b784188290209".equals(paramString)) {
        return "203300030000";
      }
      if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
        return "204300030000";
      }
      if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
        return "205300030000";
      }
      str1 = str2;
    } while (!"8a90a5d8580a5cb2015822c397920018".equals(paramString));
    return "207300030000";
  }
  
  public static int getChildWidth(Context paramContext, int paramInt)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    paramInt = (localDisplayMetrics.widthPixels - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 16.0F)) / paramInt - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F);
    if (paramInt > 0) {
      return paramInt;
    }
    return -2;
  }
  
  public static aw getChoiceServiceBean(int paramInt, String paramString, Class paramClass, Bundle paramBundle)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setTitle(paramString);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    return localaw;
  }
  
  public static List<aw> getChoiceServiceData()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getChoiceServiceBean(2130839501, "搬家", MoveTypeActivity.class, null));
    localArrayList.add(getChoiceServiceBean(2130839499, "保洁", CleanHomeActivity.class, null));
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d))
    {
      localArrayList.add(getChoiceServiceBean(2130839502, "维修", RepairHomeActivity.class, null));
      return localArrayList;
    }
    localArrayList.add(getChoiceServiceBean(2130839502, "", null, null));
    return localArrayList;
  }
  
  public static String getCleanShowUrl(String paramString)
  {
    String str = "";
    if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
      str = q.q + "app/intro/daily.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
    }
    do
    {
      return str;
      if ("2c9084434b783482014b784188290209".equals(paramString)) {
        return q.q + "app/intro/depth.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      }
      if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
        return q.q + "app/intro/reclaim.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      }
      if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
        return q.q + "app/intro/kill.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      }
      if ("8a90a28956f928920156f9c0472f000a".equals(paramString)) {
        return q.q + "app/intro/minsu.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      }
      if ("8a90a5d8580a5cb2015822c397920018".equals(paramString)) {
        return q.q + "app/intro/caboli.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      }
      if ("8a90a5d85841edb0015847dd78a80014".equals(paramString)) {
        return q.q + "app/intro/chuman.shtml";
      }
    } while (!"8a90a5d85841edb0015847dd11110000".equals(paramString));
    return q.q + "app/intro/bedroom.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
  }
  
  public static String getCms_Url()
  {
    if (4 == h.getsEnvironment())
    {
      if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        return "http://contentful.ziroom.com/online/combine/8f14e45fceea167a5a36dedd4bea2543.json";
      }
      if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        return "http://contentful.ziroom.com/online/combine/70efdf2ec9b086079795c442636b55fb.json";
      }
      if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        return "http://contentful.ziroom.com/online/combine/6f4922f45568161a8cdf4ad2299f6d23.json";
      }
      if ("330100".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        return "http://contentful.ziroom.com/online/combine/2838023a778dfaecdc212708f721b788.json";
      }
      if ("320100".equals(com.ziroom.ziroomcustomer.base.b.d)) {
        return "http://contentful.ziroom.com/online/combine/9a1158154dfa42caddbd0694a4e9bdc8.json";
      }
      return "http://contentful.ziroom.com/online/combine/8f14e45fceea167a5a36dedd4bea2543.json";
    }
    return "http://contentful.ziroom.com/online/combine/f457c545a9ded88f18ecee47145a72c0.json";
  }
  
  public static String getCms_Url_Clean()
  {
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/d3d9446802a44259755d38e6d163e820.json";
    }
    if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c51ce410c124a10e0db5e4b97fc2af39.json";
    }
    if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/9bf31c7ff062936a96d3c8bd1f8f2ff3.json";
    }
    if ("330100".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/d3d9446802a44259755d38e6d163e820.json";
    }
    return "http://contentful.ziroom.com/online/combine/d3d9446802a44259755d38e6d163e820.json";
  }
  
  public static String getCms_Url_Move()
  {
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/6512bd43d9caa6e02c990b0a82652dca.json";
    }
    if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/aab3238922bcc25a6f606eb525ffdc56.json";
    }
    if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c74d97b01eae257e44aa9d5bade97baf.json";
    }
    if ("330100".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "";
    }
    return "http://contentful.ziroom.com/online/combine/6512bd43d9caa6e02c990b0a82652dca.json";
  }
  
  public static String getCms_Url_Repair()
  {
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c20ad4d76fe97759aa27a0c99bff6710.json";
    }
    if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c20ad4d76fe97759aa27a0c99bff6710.json";
    }
    if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c20ad4d76fe97759aa27a0c99bff6710.json";
    }
    if ("330100".equals(com.ziroom.ziroomcustomer.base.b.d)) {
      return "http://contentful.ziroom.com/online/combine/c20ad4d76fe97759aa27a0c99bff6710.json";
    }
    return "http://contentful.ziroom.com/online/combine/c20ad4d76fe97759aa27a0c99bff6710.json";
  }
  
  public static List<String> getCutApart(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.split(paramString2);
      int i = 0;
      while (i < paramString1.length)
      {
        localArrayList.add(paramString1[i]);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static int getDisplayHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    if (i > 0) {
      return i;
    }
    return -2;
  }
  
  public static int getDisplayWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    if (i > 0) {
      return i;
    }
    return -2;
  }
  
  public static String getEvalDesc(float paramFloat)
  {
    String str = "";
    if (paramFloat > 4.0F) {
      str = "特别满意";
    }
    do
    {
      return str;
      if (paramFloat > 3.0F) {
        return "满意";
      }
      if (paramFloat > 2.0F) {
        return "一般";
      }
      if (paramFloat > 1.0F) {
        return "不满意";
      }
    } while (paramFloat <= 0.0F);
    return "特别不满意";
  }
  
  public static String getException(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a)) {
      return paramThrowable.getMessage();
    }
    if ((paramThrowable instanceof com.ziroom.commonlibrary.a.b)) {
      return paramThrowable.getMessage();
    }
    if ((paramThrowable instanceof UnknownHostException)) {
      return "网络请求失败，请检查网络连接";
    }
    return "服务器请求异常！";
  }
  
  public static List<String> getForCutApart(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.split(paramString2);
      int i = 0;
      while (i < paramString1.length)
      {
        if (!TextUtils.isEmpty(paramString1[i])) {
          localArrayList.add(paramString1[i]);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static aw getHotRecommendBean(int paramInt, String paramString1, String paramString2, String paramString3, Class paramClass, Bundle paramBundle, boolean paramBoolean)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setTitle(paramString1);
    localaw.setSubTitle(paramString2);
    localaw.setNetIcon(paramString3);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean);
    return localaw;
  }
  
  public static List<aw> getHotRecommendData(List<ay.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str1 = ((ay.a)paramList.get(i)).getTitle();
      String str2 = ((ay.a)paramList.get(i)).getSubtitle();
      String str3 = ((ay.a)paramList.get(i)).getPic();
      Class localClass = getActivityClassByCMS(((ay.a)paramList.get(i)).getTypes(), ((ay.a)paramList.get(i)).getUrl(), "hot_recommend");
      Bundle localBundle = new Bundle();
      if ("1".equals(((ay.a)paramList.get(i)).getTypes()))
      {
        localBundle.putString("url", ((ay.a)paramList.get(i)).getUrl());
        localBundle.putString("title", ((ay.a)paramList.get(i)).getTitle());
        localBundle.putString("shareContent", ((ay.a)paramList.get(i)).getSubtitle());
        localBundle.putString("shareImg", ((ay.a)paramList.get(i)).getPic());
        localBundle.putBoolean("isShowShare", true);
      }
      for (;;)
      {
        localArrayList.add(getHotRecommendBean(2130839498, str1, str2, str3, localClass, localBundle, isNeedLogin(((ay.a)paramList.get(i)).getTypes(), ((ay.a)paramList.get(i)).getUrl())));
        i += 1;
        break;
        localBundle = getBundleByCMS(((ay.a)paramList.get(i)).getTypes(), ((ay.a)paramList.get(i)).getUrl());
      }
    }
    return localArrayList;
  }
  
  public static List<MoveChargeInfo> getMoveFeeChargeList(MoveFeeBean paramMoveFeeBean, List<MoveChargeInfo> paramList)
  {
    if (paramMoveFeeBean.getCharges() != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramMoveFeeBean.getCharges().getItems().size())
        {
          String str = ((MoveFeeBean.ChargesBean.ItemsBean)paramMoveFeeBean.getCharges().getItems().get(i)).getItemName();
          try
          {
            paramList.add(new MoveChargeInfo(str, new DecimalFormat("######0.00").format(((MoveFeeBean.ChargesBean.ItemsBean)paramMoveFeeBean.getCharges().getItems().get(i)).getItemCost() / 100), false));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      try
      {
        Object localObject = new DecimalFormat("######0.00");
        if (paramMoveFeeBean.getCharges().getDiscount().intValue() > 0) {}
        for (localObject = "-" + ((DecimalFormat)localObject).format(paramMoveFeeBean.getCharges().getDiscount().intValue() / 100); paramMoveFeeBean.getCanUseCoupon().intValue() == 1; localObject = "-" + ((DecimalFormat)localObject).format(paramMoveFeeBean.getCharges().getDiscount().intValue() / 100))
        {
          paramList.add(new MoveChargeInfo("优惠劵", (String)localObject, true));
          return paramList;
        }
        paramList.add(new MoveChargeInfo("优惠劵", (String)localObject, false));
        return paramList;
      }
      catch (Exception paramMoveFeeBean)
      {
        paramMoveFeeBean.printStackTrace();
      }
    }
    return paramList;
  }
  
  public static List<String> getNeedFlikTag(Context paramContext, FlowLayout paramFlowLayout, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        Button localButton = new Button(paramContext);
        localButton.setText((CharSequence)localObject);
        localButton.setTag(Boolean.valueOf(false));
        localButton.setTextColor(-6710887);
        localButton.setTextSize(12.0F);
        localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 6.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 6.0F));
        localButton.setBackgroundResource(2130838210);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 12.0F), 0);
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
            {
              paramAnonymousView.setBackgroundResource(2130838211);
              paramAnonymousView.setTextColor(-1);
              paramAnonymousView.setTag(Boolean.valueOf(true));
              this.a.add(str);
            }
            do
            {
              return;
              paramAnonymousView.setBackgroundResource(2130838210);
              paramAnonymousView.setTextColor(-6710887);
              paramAnonymousView.setTag(Boolean.valueOf(false));
            } while ((this.a == null) || (this.a.size() <= 0) || (!this.a.contains(str)));
            this.a.remove(str);
          }
        });
        paramFlowLayout.addView(localButton);
      }
    }
    return localArrayList;
  }
  
  public static List<String> getNumbers(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("(\\d+)").matcher(paramString);
    while (paramString.find()) {
      localArrayList.add(paramString.group(1).toString());
    }
    return localArrayList;
  }
  
  public static List<MoveChargeInfo> getPeriodGeneralChareList(PeriodGeneralChargeBean paramPeriodGeneralChargeBean, List<MoveChargeInfo> paramList)
  {
    if (paramPeriodGeneralChargeBean.getCharges() != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramPeriodGeneralChargeBean.getCharges().getItems().size())
        {
          String str = ((PeriodGeneralChargeBean.ChargesBean.ItemsBean)paramPeriodGeneralChargeBean.getCharges().getItems().get(i)).getItemName();
          try
          {
            paramList.add(new MoveChargeInfo(str, new DecimalFormat("######0.00").format(((PeriodGeneralChargeBean.ChargesBean.ItemsBean)paramPeriodGeneralChargeBean.getCharges().getItems().get(i)).getItemCost().intValue() / 100), false));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      try
      {
        Object localObject = new DecimalFormat("######0.00");
        if (paramPeriodGeneralChargeBean.getCharges().getDiscount().intValue() > 0) {}
        for (localObject = "-" + ((DecimalFormat)localObject).format(paramPeriodGeneralChargeBean.getCharges().getDiscount().intValue() / 100); paramPeriodGeneralChargeBean.getCanUseCoupon().intValue() == 1; localObject = "-" + ((DecimalFormat)localObject).format(paramPeriodGeneralChargeBean.getCharges().getDiscount().intValue() / 100))
        {
          paramList.add(new MoveChargeInfo("优惠劵", (String)localObject, true));
          return paramList;
        }
        paramList.add(new MoveChargeInfo("优惠劵", (String)localObject, false));
        return paramList;
      }
      catch (Exception paramPeriodGeneralChargeBean)
      {
        paramPeriodGeneralChargeBean.printStackTrace();
      }
    }
    return paramList;
  }
  
  public static float getRepairSelectWidth(Context paramContext)
  {
    return (getDisplayWidth(paramContext) - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 72.0F) - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 20.0F) * 2 - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 20.0F) * 2) / 3.0F;
  }
  
  public static List<MoveChargeInfo> getServeChareList(bh parambh, List<MoveChargeInfo> paramList)
  {
    if ((parambh.getChargeItem() != null) && (parambh.getChargeItem().size() > 0))
    {
      int i = 0;
      while (i < parambh.getChargeItem().size())
      {
        paramList.add(new MoveChargeInfo(((bh.a)parambh.getChargeItem().get(i)).getItemName(), ((bh.a)parambh.getChargeItem().get(i)).getItemCost(), false));
        i += 1;
      }
    }
    if ((parambh.getDiscountChargeItem() != null) && (parambh.getDiscountChargeItem().size() > 0)) {
      paramList.add(new MoveChargeInfo(((bh.b)parambh.getDiscountChargeItem().get(0)).getItemName(), ((bh.b)parambh.getDiscountChargeItem().get(0)).getItemCost(), false));
    }
    return paramList;
  }
  
  public static void getServiceCalendarTip(Context paramContext, String paramString, final TextView paramTextView)
  {
    com.ziroom.ziroomcustomer.e.n.getServiceCalendarTip(paramContext, paramString, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.newServiceList.model.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.a paramAnonymousa)
      {
        if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.getToast()))) {
          paramTextView.setText(paramAnonymousa.getToast());
        }
      }
    });
  }
  
  public static aw getServiceStoryBean(String paramString1, String paramString2, String paramString3, Class paramClass, Bundle paramBundle)
  {
    aw localaw = new aw();
    localaw.setTitle(paramString1);
    localaw.setSubTitle(paramString2);
    localaw.setNetIcon(paramString3);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    return localaw;
  }
  
  public static List<aw> getServiceStoryData(List<ay.b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str1 = ((ay.b)paramList.get(i)).getTitle();
      String str2 = ((ay.b)paramList.get(i)).getSubtitle();
      String str3 = ((ay.b)paramList.get(i)).getPic();
      Bundle localBundle = new Bundle();
      localBundle.putString("url", ((ay.b)paramList.get(i)).getUrl());
      localBundle.putString("title", ((ay.b)paramList.get(i)).getTitle());
      localBundle.putString("shareContent", ((ay.b)paramList.get(i)).getSubtitle());
      localBundle.putString("shareImg", ((ay.b)paramList.get(i)).getPic());
      localBundle.putBoolean("isShowShare", true);
      localArrayList.add(getServiceStoryBean(str1, str2, str3, JsBridgeWebActivity.class, localBundle));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void getShareInfo(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    com.ziroom.ziroomcustomer.e.n.getShareInfo(paramContext, paramString2, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.ziroom.ziroomcustomer.newServiceList.model.m.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.m paramAnonymousm)
      {
        Intent localIntent = new Intent(paramContext, HomeWebActivity.class);
        String str1 = paramAnonymousm.getAppUrl().getContent() + "?orderShareCode=" + paramString1 + "&employeeCode=" + paramString2 + "&cityCode=" + paramString3 + "&userCode=" + paramString4;
        String str2 = paramAnonymousm.getWechatUrl().getContent() + "?orderShareCode=" + paramString1 + "&employeeCode=" + paramString2 + "&cityCode=" + paramString3;
        localIntent.putExtra("url", str1);
        localIntent.putExtra("shareUrl", str2);
        localIntent.putExtra("shareTitle", paramAnonymousm.getTitle().getContent());
        localIntent.putExtra("content", paramAnonymousm.getDesc().getContent());
        localIntent.putExtra("pic", paramAnonymousm.getPic().getContent());
        localIntent.putExtra("ziru", "serviceOrderShare");
        paramContext.startActivity(localIntent);
      }
    });
  }
  
  public static String[] getSpaceTar(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return paramString1.split(paramString2);
  }
  
  public static List<String> getSplitApart(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.split(paramString2);
      int i = 0;
      while (i < paramString1.length)
      {
        if (!TextUtils.isEmpty(paramString1[i])) {
          localArrayList.add(paramString1[i]);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static List<String> getSplitCityCode(String paramString1, String paramString2)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.split(paramString2);
      int i = 0;
      while (i < paramString1.length)
      {
        if (!TextUtils.isEmpty(paramString1[i])) {
          localArrayList2.add(paramString1[i]);
        }
        i += 1;
      }
      if (localArrayList2.size() > 0)
      {
        paramString1 = localArrayList2.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          if ("bj".equals(paramString2)) {
            localArrayList1.add("110000");
          } else if ("sh".equals(paramString2)) {
            localArrayList1.add("310000");
          } else if ("sz".equals(paramString2)) {
            localArrayList1.add("440300");
          }
        }
      }
      return localArrayList1;
    }
    return null;
  }
  
  public static void getStar(int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5)
  {
    if (paramInt == 1)
    {
      paramImageView1.setBackgroundResource(2130839387);
      paramImageView2.setBackgroundResource(2130838510);
      paramImageView3.setBackgroundResource(2130838510);
      paramImageView4.setBackgroundResource(2130838510);
      paramImageView5.setBackgroundResource(2130838510);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        paramImageView1.setBackgroundResource(2130839387);
        paramImageView2.setBackgroundResource(2130839387);
        paramImageView3.setBackgroundResource(2130838510);
        paramImageView4.setBackgroundResource(2130838510);
        paramImageView5.setBackgroundResource(2130838510);
        return;
      }
      if (paramInt == 3)
      {
        paramImageView1.setBackgroundResource(2130839387);
        paramImageView2.setBackgroundResource(2130839387);
        paramImageView3.setBackgroundResource(2130839387);
        paramImageView4.setBackgroundResource(2130838510);
        paramImageView5.setBackgroundResource(2130838510);
        return;
      }
      if (paramInt == 4)
      {
        paramImageView1.setBackgroundResource(2130839387);
        paramImageView2.setBackgroundResource(2130839387);
        paramImageView3.setBackgroundResource(2130839387);
        paramImageView4.setBackgroundResource(2130839387);
        paramImageView5.setBackgroundResource(2130838510);
        return;
      }
    } while (paramInt != 5);
    paramImageView1.setBackgroundResource(2130839387);
    paramImageView2.setBackgroundResource(2130839387);
    paramImageView3.setBackgroundResource(2130839387);
    paramImageView4.setBackgroundResource(2130839387);
    paramImageView5.setBackgroundResource(2130839387);
  }
  
  public static String getStarDesc(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "非常不满意";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "不满意";
      }
      if (paramInt == 3) {
        return "一般";
      }
      if (paramInt == 4) {
        return "满意";
      }
    } while (paramInt != 5);
    return "非常满意";
  }
  
  public static String getTelnum(String paramString)
  {
    if (paramString.length() <= 0) {
      return "";
    }
    paramString = Pattern.compile("(1|861)(3|5|8)\\d{9}$*").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find()) {
      localStringBuffer.append(paramString.group()).append(",");
    }
    int i = localStringBuffer.length();
    if (i > 0) {
      localStringBuffer.deleteCharAt(i - 1);
    }
    return localStringBuffer.toString();
  }
  
  public static String getUid()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    return str;
  }
  
  public static aw getYoupinBean(int paramInt, String paramString1, String paramString2, String paramString3, Class paramClass, Bundle paramBundle, boolean paramBoolean)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setNetIcon(paramString1);
    localaw.setTitle(paramString2);
    localaw.setSubTitle(paramString3);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean);
    return localaw;
  }
  
  public static List<aw> getYoupinData(List<ay.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str1 = ((ay.c)paramList.get(i)).getPic();
      String str2 = ((ay.c)paramList.get(i)).getTitle();
      String str3 = ((ay.c)paramList.get(i)).getSubtitle();
      Class localClass = getActivityClassByCMS(((ay.c)paramList.get(i)).getTypes(), ((ay.c)paramList.get(i)).getUrl(), "youpin");
      Bundle localBundle = new Bundle();
      if ("1".equals(((ay.c)paramList.get(i)).getTypes()))
      {
        localBundle.putString("url", ((ay.c)paramList.get(i)).getUrl());
        localBundle.putString("title", ((ay.c)paramList.get(i)).getTitle());
        localBundle.putString("shareContent", ((ay.c)paramList.get(i)).getSubtitle());
        localBundle.putString("shareImg", ((ay.c)paramList.get(i)).getPic());
        localBundle.putBoolean("isShowShare", true);
      }
      for (;;)
      {
        localArrayList.add(getYoupinBean(2130839498, str1, str2, str3, localClass, localBundle, isNeedLogin(((ay.c)paramList.get(i)).getTypes(), ((ay.c)paramList.get(i)).getUrl())));
        i += 1;
        break;
        localBundle = getBundleByCMS(((ay.c)paramList.get(i)).getTypes(), ((ay.c)paramList.get(i)).getUrl());
      }
    }
    return localArrayList;
  }
  
  public static aw getZikeBean(String paramString1, int paramInt, Class paramClass, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    aw localaw = new aw();
    localaw.setTitle(paramString1);
    localaw.setResIcon(paramInt);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean1);
    localaw.setNeedContract(paramBoolean2);
    localaw.setDialogContent(paramString2);
    localaw.setServeType(paramString3);
    return localaw;
  }
  
  public static void hideSoftInput(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  public static boolean isEven(int paramInt)
  {
    return paramInt % 2 == 0;
  }
  
  public static boolean isIncludeTelNum(String paramString)
  {
    if (paramString.length() <= 0) {}
    StringBuffer localStringBuffer;
    int i;
    do
    {
      return false;
      paramString = Pattern.compile("(1|861)(3|5|8)\\d{9}$*").matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find()) {
        localStringBuffer.append(paramString.group()).append(",");
      }
      i = localStringBuffer.length();
    } while (i <= 0);
    localStringBuffer.deleteCharAt(i - 1);
    return true;
  }
  
  public static boolean isNeedLogin(String paramString1, String paramString2)
  {
    if ("0".equals(paramString1))
    {
      i = -1;
      switch (paramString2.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    while (!"1".equals(paramString1))
    {
      for (;;)
      {
        int i;
        return false;
        if (paramString2.equals("clean_richang"))
        {
          i = 0;
          continue;
          if (paramString2.equals("clean_shendu"))
          {
            i = 1;
            continue;
            if (paramString2.equals("clean_xiaosha"))
            {
              i = 2;
              continue;
              if (paramString2.equals("clean_kaihuang"))
              {
                i = 3;
                continue;
                if (paramString2.equals("clean_minsu"))
                {
                  i = 4;
                  continue;
                  if (paramString2.equals("clean_caboli"))
                  {
                    i = 5;
                    continue;
                    if (paramString2.equals("clean_chuman"))
                    {
                      i = 6;
                      continue;
                      if (paramString2.equals("move_xiaoban"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_truck"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("repair_shuiluguanjian"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_dengjudianlu"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_kaisuohuansuo"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kongtiaoqingxi"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("card_repair"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_clean"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("upin_jiaju")) {
                                        i = 15;
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
      return true;
      return true;
      return true;
      return true;
    }
    return false;
  }
  
  public static final boolean isOPenGps(Context paramContext)
  {
    return ((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps");
  }
  
  public static void moveIndicator(String paramString, float paramFloat, int paramInt1, View paramView, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if ("left".equals(paramString)) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * paramInt1 + paramInt2 * paramInt1));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      if ("right".equals(paramString)) {
        localLayoutParams.leftMargin = ((int)(paramInt1 * paramFloat + paramInt2 * paramInt1));
      }
    }
  }
  
  public static void requestFocus(View paramView)
  {
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    paramView.requestFocus();
    paramView.requestFocusFromTouch();
  }
  
  public static void sendShareEvalInfo(Context paramContext)
  {
    Intent localIntent = new Intent("com.ziroom.ziroomcustomer.service.shareInfo.broadcast");
    localIntent.putExtra("share_type", "week_clean");
    LocalBroadcastManager.getInstance(paramContext).sendBroadcast(localIntent);
  }
  
  public static void setBedroomGrowingIo(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("status", "open");
      }
      for (;;)
      {
        GrowingIO.getInstance().track("service_bedroom_ispublic", localJSONObject);
        return;
        localJSONObject.put("status", "close");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void setClean2Address(final Activity paramActivity, final String paramString1, final String paramString2, final String paramString3)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && ("isZhengZu".equals(paramString1)))
    {
      com.ziroom.ziroomcustomer.e.n.getCleanZuAddressList(paramActivity, localUserInfo.getUid(), new com.freelxl.baselibrary.d.c.a(new l(com.ziroom.ziroomcustomer.newclean.d.c.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          j.showFailureMessage(paramActivity, paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newclean.d.c> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            Intent localIntent = new Intent(paramActivity, CleanAddressActivity.class);
            localIntent.putExtra("isOnly", paramString2);
            if ((!TextUtils.isEmpty(paramString1)) && ("isZhengZu".equals(paramString1))) {
              localIntent.putExtra("isZu", "isZu");
            }
            if (("8a90a5d8580a5cb2015822c397920018".equals(paramString3)) || ("8a90a5d85841edb0015847dd78a80014".equals(paramString3))) {
              localIntent.putExtra("serviceInfoId", paramString3);
            }
            localIntent.putExtra("isFromGeneral", true);
            localIntent.putExtra("isFromEmpty", true);
            localIntent.putExtra("cleanAddressData", com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
            paramActivity.startActivityForResult(localIntent, 111);
            return;
          }
          paramAnonymousList = new Intent(paramActivity, ModifyNewAddressActivity.class);
          paramActivity.startActivityForResult(paramAnonymousList, 555);
        }
      });
      return;
    }
    com.ziroom.ziroomcustomer.e.n.getCleanddressList(paramActivity, localUserInfo.getUid(), 1, 8, new com.freelxl.baselibrary.d.c.a(new l(com.ziroom.ziroomcustomer.newclean.d.c.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(paramActivity, paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newclean.d.c> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          Intent localIntent = new Intent(paramActivity, CleanAddressActivity.class);
          localIntent.putExtra("isOnly", paramString2);
          if ((!TextUtils.isEmpty(paramString1)) && ("isZhengZu".equals(paramString1))) {
            localIntent.putExtra("isZu", "isZu");
          }
          if (("8a90a5d8580a5cb2015822c397920018".equals(paramString3)) || ("8a90a5d85841edb0015847dd78a80014".equals(paramString3))) {
            localIntent.putExtra("serviceInfoId", paramString3);
          }
          localIntent.putExtra("isFromGeneral", true);
          localIntent.putExtra("isFromEmpty", true);
          localIntent.putExtra("cleanAddressData", com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
          paramActivity.startActivityForResult(localIntent, 111);
          return;
        }
        paramAnonymousList = new Intent(paramActivity, ModifyNewAddressActivity.class);
        paramActivity.startActivityForResult(paramAnonymousList, 555);
      }
    });
  }
  
  public static void setClick2RepairList(Context paramContext, s.b paramb)
  {
    String str1 = paramb.getCode();
    String str2 = paramb.getName();
    if ("00000000".equals(str1)) {
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
        g.textToast(paramContext, "请先登录");
      }
    }
    for (;;)
    {
      return;
      if ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0)))
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent("您没有履行中的合同哦~").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean) {}
        }).build().show();
        return;
      }
      paramb = new Intent(paramContext, InternalRepairSelectActivity.class);
      while (paramb != null)
      {
        paramContext.startActivity(paramb);
        return;
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
          g.textToast(paramContext, "请先登录");
          return;
        }
        paramb = new Intent(paramContext, RepairOrderNewActivity.class);
        paramb.putExtra("serviceInfoId", str1);
        paramb.putExtra("serviceInfoName", str2);
      }
    }
  }
  
  public static void setFinishDialog(Activity paramActivity)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramActivity).setTitle("退出提示").setContent("信息还未填写完，您确定要放弃填写吗？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          this.a.finish();
        }
      }
    }).build().show();
  }
  
  public static void setFriendCard(final Context paramContext)
  {
    final Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.requestIsUserInfo(paramContext, (String)localObject, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(CleanUesrIsNewMo.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, CleanUesrIsNewMo paramAnonymousCleanUesrIsNewMo)
      {
        if (paramAnonymousCleanUesrIsNewMo != null)
        {
          Object localObject = paramAnonymousCleanUesrIsNewMo.getInvite();
          if (localObject != null)
          {
            paramAnonymousCleanUesrIsNewMo = ((CleanUesrIsNewMo.InviteMo)localObject).getInviteUrl() + "?uid=" + localObject;
            String str1 = ((CleanUesrIsNewMo.InviteMo)localObject).getTitle();
            String str2 = ((CleanUesrIsNewMo.InviteMo)localObject).getContent();
            localObject = ((CleanUesrIsNewMo.InviteMo)localObject).getImage();
            JsBridgeWebActivity.start(paramContext, str1, paramAnonymousCleanUesrIsNewMo, false, str2, (String)localObject, false);
          }
        }
      }
    });
  }
  
  public static void setIndexColor(String paramString1, String paramString2, int paramInt, TextView paramTextView)
  {
    if (paramString1.indexOf(paramString2) == -1)
    {
      paramTextView.setText(paramString1);
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), paramString1.indexOf(paramString2), paramString1.indexOf(paramString2) + paramString2.length(), 33);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), paramString1.indexOf(paramString2), paramString1.indexOf(paramString2) + paramString2.length(), 33);
    paramTextView.setText(localSpannableStringBuilder);
  }
  
  public static int setInitVar(Activity paramActivity, int paramInt1, View paramView, int paramInt2)
  {
    Object localObject = (WindowManager)paramActivity.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    paramInt1 = localDisplayMetrics.widthPixels / paramInt1;
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = (paramInt1 * 1);
    paramInt2 = (paramInt1 - com.ziroom.ziroomcustomer.util.n.dip2px(paramActivity, paramInt2)) / 2;
    paramView.setPadding(paramInt2, 0, paramInt2, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return paramInt1;
  }
  
  public static void setLunBoBanner(List<String> paramList, ConvenientBanner paramConvenientBanner)
  {
    paramConvenientBanner.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
      {
        return new com.ziroom.ziroomcustomer.newServiceList.view.c();
      }
    }, paramList).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt) {}
    });
    paramConvenientBanner.startTurning(3000L);
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramList.size() == 1)
      {
        paramConvenientBanner.setPointViewVisible(false);
        paramConvenientBanner.setCanLoop(false);
      }
    }
    else {
      return;
    }
    paramConvenientBanner.setPointViewVisible(true);
    paramConvenientBanner.setCanLoop(true);
  }
  
  public static void setPoint(Context paramContext, String paramString)
  {
    String str = "";
    Intent localIntent = new Intent(paramContext, ServiceWebActivity.class);
    if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
      str = q.q + "app/intro/daily.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
    }
    for (;;)
    {
      localIntent.putExtra("url", str);
      localIntent.putExtra("title_name", "服务说明");
      paramContext.startActivity(localIntent);
      return;
      if ("2c9084434b783482014b784188290209".equals(paramString)) {
        str = q.q + "app/intro/depth.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      } else if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
        str = q.q + "app/intro/reclaim.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      } else if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
        str = q.q + "app/intro/kill.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      } else if ("8a90a28956f928920156f9c0472f000a".equals(paramString))
      {
        if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
          str = "http://www.ziroom.com/zhuanti/fw/detail/minsuBaojie.html?city=bj";
        } else if ("310000".equals(com.ziroom.ziroomcustomer.base.b.d)) {
          str = "http://www.ziroom.com/zhuanti/fw/detail/minsuBaojie.html?city=sh";
        } else if ("440300".equals(com.ziroom.ziroomcustomer.base.b.d)) {
          str = "http://www.ziroom.com/zhuanti/fw/detail/minsuBaojie.html?city=sz";
        }
      }
      else if ("8a90a5d8580a5cb2015822c397920018".equals(paramString)) {
        str = q.q + "app/intro/caboli.shtml?cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
      } else if ("8a90a5d85841edb0015847dd78a80014".equals(paramString)) {
        str = q.q + "app/intro/chuman.shtml";
      }
    }
  }
  
  public static void setRepairVideo(final Activity paramActivity, String paramString, final SimpleDraweeView paramSimpleDraweeView)
  {
    com.ziroom.ziroomcustomer.e.n.getRepairVideoTag(paramActivity, paramString, new com.ziroom.ziroomcustomer.e.a.a(paramActivity, new com.ziroom.ziroomcustomer.e.c.m(at.class, new com.ziroom.ziroomcustomer.e.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        paramSimpleDraweeView.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, final at paramAnonymousat)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousat);
        u.d("jdsgkj", "===== " + com.alibaba.fastjson.a.toJSONString(paramAnonymousat));
        if ((paramAnonymousat != null) && (paramSimpleDraweeView != null))
        {
          if (!TextUtils.isEmpty(paramAnonymousat.getPicUrl()))
          {
            paramSimpleDraweeView.setVisibility(0);
            paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousat.getPicUrl()));
            paramSimpleDraweeView.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (!TextUtils.isEmpty(paramAnonymousat.getJumpUrl())) {
                  JsBridgeWebActivity.start(j.22.this.d, "", paramAnonymousat.getJumpUrl(), false, "", "", true);
                }
              }
            });
            return;
          }
          paramSimpleDraweeView.setVisibility(8);
          return;
        }
        paramSimpleDraweeView.setVisibility(8);
      }
    });
  }
  
  public static void setServantThumb(final Context paramContext, final SimpleDraweeView paramSimpleDraweeView, final Bundle paramBundle)
  {
    final String str1 = paramBundle.getString("thumbType");
    final String str2 = paramBundle.getString("showType");
    final String str3 = paramBundle.getString("orderCode");
    final String str4 = paramBundle.getString("orderNum");
    paramBundle = paramBundle.getString("employeeCode");
    com.ziroom.ziroomcustomer.e.n.getCommonTemplateOnCity(paramContext, Integer.valueOf(18), new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.f(bi.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final bi paramAnonymousbi)
      {
        final Object localObject1;
        final Object localObject2;
        if (paramAnonymousbi != null)
        {
          localObject1 = "";
          if (!"clean".equals(str1)) {
            break label187;
          }
          localObject2 = "2c9085f24af1d728014b004be6b50d3b";
          if (!"detail".equals(str2)) {
            break label149;
          }
          localObject1 = paramAnonymousbi.getCleanOrder();
          if (paramAnonymousbi.getCleanDetail() != 1) {
            break label144;
          }
          paramAnonymousInt = 1;
        }
        for (;;)
        {
          if (paramAnonymousInt == 1)
          {
            localObject3 = paramSimpleDraweeView.getLayoutParams();
            if ("detail".equals(str2)) {
              ((ViewGroup.LayoutParams)localObject3).height = (ac.getScreenWidth(paramContext) * 180 / 750);
            }
            for (;;)
            {
              paramSimpleDraweeView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              paramSimpleDraweeView.setVisibility(0);
              paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject1));
              paramSimpleDraweeView.setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  paramAnonymous2View = paramAnonymousbi.getUrl() + "?orderCode=" + j.18.this.f + "&orderNum=" + j.18.this.g + "&serviceTypeCode=" + localObject2 + "&employeeCode=" + j.18.this.h + "&cityCode=" + com.ziroom.ziroomcustomer.base.b.d;
                  JsBridgeWebActivity.start(j.18.this.e, "", paramAnonymous2View, false, "", localObject1, false);
                }
              });
              return;
              label144:
              paramAnonymousInt = 0;
              break;
              label149:
              localObject1 = localObject2;
              if (!"eval".equals(str2)) {
                break label421;
              }
              localObject1 = paramAnonymousbi.getCleanBanner();
              if (paramAnonymousbi.getCleanEvaluate() == 1)
              {
                paramAnonymousInt = 1;
                break;
              }
              paramAnonymousInt = 0;
              break;
              label187:
              if ("move".equals(str1))
              {
                localObject2 = "2c9085f248ba3f3a0148bb151aca0003";
                if ("detail".equals(str2))
                {
                  localObject1 = paramAnonymousbi.getMoveOrder();
                  if (paramAnonymousbi.getMoveDetail() == 1)
                  {
                    paramAnonymousInt = 1;
                    break;
                  }
                  paramAnonymousInt = 0;
                  break;
                }
                localObject1 = localObject2;
                if (!"eval".equals(str2)) {
                  break label421;
                }
                localObject1 = paramAnonymousbi.getMoveBanner();
                if (paramAnonymousbi.getMoveEvaluate() == 1)
                {
                  paramAnonymousInt = 1;
                  break;
                }
                paramAnonymousInt = 0;
                break;
              }
              if (!"repair".equals(str1)) {
                break label421;
              }
              localObject2 = "8a90b7955fa091a5015fa398de930c8f";
              if ("detail".equals(str2))
              {
                localObject1 = paramAnonymousbi.getMaintenanceOrder();
                if (paramAnonymousbi.getMaintenanceDetail() == 1)
                {
                  paramAnonymousInt = 1;
                  break;
                }
                paramAnonymousInt = 0;
                break;
              }
              localObject1 = localObject2;
              if (!"eval".equals(str2)) {
                break label421;
              }
              localObject1 = paramAnonymousbi.getMaintenanceBanner();
              if (paramAnonymousbi.getMaintenanceEvaluate() == 1)
              {
                paramAnonymousInt = 1;
                break;
              }
              paramAnonymousInt = 0;
              break;
              if ("eval".equals(str2)) {
                ((ViewGroup.LayoutParams)localObject3).height = ((ac.getScreenWidth(paramContext) - com.ziroom.ziroomcustomer.util.n.dip2px(paramContext, 24.0F) * 2) * 109 / 327);
              }
            }
          }
          paramSimpleDraweeView.setVisibility(8);
          return;
          label421:
          Object localObject3 = "";
          paramAnonymousInt = 0;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    });
  }
  
  public static void setServePic(SimpleDraweeView paramSimpleDraweeView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(""));
    }
    do
    {
      return;
      if (paramSimpleDraweeView.getTag() == null)
      {
        paramSimpleDraweeView.setTag(paramString);
        paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
        return;
      }
    } while (paramString.equals(paramSimpleDraweeView.getTag()));
    paramSimpleDraweeView.setTag(paramString);
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
  }
  
  public static void setServicePay(final Activity paramActivity, final String paramString1, String paramString2, int paramInt, long paramLong, String paramString3, String paramString4)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.requestServicePayment(paramActivity, localUserInfo.getUid(), paramString2, 1, paramInt, paramLong, paramString3, paramString4, new d(paramActivity, new com.ziroom.ziroomcustomer.e.c.f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (paramAnonymousbc.getAmount() == 0)
        {
          if ("general".equals(paramString1))
          {
            g.textToast(paramActivity, "您已支付成功~");
            org.greenrobot.eventbus.c.getDefault().post(new c("general_detail_refresh", null));
            org.greenrobot.eventbus.c.getDefault().post(new c("refresh_service_order_list", null));
            org.greenrobot.eventbus.c.getDefault().post(new c("general_button_refresh", null));
          }
          do
          {
            return;
            if ("periodgeneral".equals(paramString1))
            {
              g.textToast(paramActivity, "您已支付成功~");
              org.greenrobot.eventbus.c.getDefault().post(new c("period_general_detail_refresh", null));
              org.greenrobot.eventbus.c.getDefault().post(new c("refresh_service_order_list", null));
              org.greenrobot.eventbus.c.getDefault().post(new c("period_general_button_refresh", null));
              return;
            }
          } while (!"move".equals(paramString1));
          g.textToast(paramActivity, "您已支付成功~");
          org.greenrobot.eventbus.c.getDefault().post(new c("move_small_detail_refresh", null));
          org.greenrobot.eventbus.c.getDefault().post(new c("refresh_service_order_list", null));
          org.greenrobot.eventbus.c.getDefault().post(new c("move_small_button_refresh", null));
          return;
        }
        String str = "";
        if ("general".equals(paramString1)) {
          str = "baojie_pay";
        }
        for (;;)
        {
          com.ziroom.ziroomcustomer.payment.a.startPayActivty(paramActivity, paramAnonymousbc.getAmount(), str, paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
          return;
          if ("periodgeneral".equals(paramString1)) {
            str = "baojie_pay";
          } else if ("move".equals(paramString1)) {
            str = "banjia_pay";
          }
        }
      }
    });
  }
  
  public static void setShowPartTran(final boolean paramBoolean, View paramView, final int paramInt)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofInt(new int[] { 0, paramInt });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        Log.d("sdjd", "=======  animatorValue=" + i);
        paramAnonymousValueAnimator = (LinearLayout.LayoutParams)this.a.getLayoutParams();
        if (paramBoolean) {}
        for (paramAnonymousValueAnimator.height = i;; paramAnonymousValueAnimator.height = (paramInt - i))
        {
          this.a.setLayoutParams(paramAnonymousValueAnimator);
          return;
        }
      }
    });
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  public static void setToList(Context paramContext, String paramString)
  {
    if (ApplicationEx.c.isLoginState())
    {
      Intent localIntent = new Intent(paramContext, ZiroomOrderListActivity.class);
      localIntent.putExtra("ServiceList", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
  
  public static void setToWeekList(Context paramContext, String paramString, Contract paramContract)
  {
    if (ApplicationEx.c.isLoginState())
    {
      paramContext.startActivity(new Intent(paramContext, ZiroomOrderListActivity.class));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
  
  public static void setToWorker(final Context paramContext, String paramString, TextView paramTextView)
  {
    paramTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(this.a)) {
          return;
        }
        ah.callPhone(paramContext, this.a);
      }
    });
  }
  
  public static void setToZiroomList(Context paramContext)
  {
    if (ApplicationEx.c.isLoginState())
    {
      paramContext.startActivity(new Intent(paramContext, ZiroomOrderListActivity.class));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
  
  public static void showArrow(boolean paramBoolean, final View paramView)
  {
    if (paramBoolean) {}
    for (RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);; localRotateAnimation = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F))
    {
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      localRotateAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (this.a)
          {
            paramView.setBackgroundResource(2130840358);
            return;
          }
          paramView.setBackgroundResource(2130840357);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      return;
    }
  }
  
  public static void showChooseView(boolean paramBoolean, final View paramView)
  {
    com.d.a.c localc = null;
    com.d.a.j localj;
    if (paramBoolean)
    {
      localc = new com.d.a.c();
      localj = com.d.a.j.ofFloat(paramView, "translationY", new float[] { paramView.getHeight(), 0.0F });
      localc.setDuration(300L);
      localc.playTogether(new com.d.a.a[] { localj });
    }
    for (;;)
    {
      if (localc != null)
      {
        localc.addListener(new com.d.a.b()
        {
          public void onAnimationEnd(com.d.a.a paramAnonymousa)
          {
            super.onAnimationEnd(paramAnonymousa);
            if (!this.a) {
              paramView.setVisibility(8);
            }
          }
          
          public void onAnimationStart(com.d.a.a paramAnonymousa)
          {
            super.onAnimationStart(paramAnonymousa);
            if (this.a) {
              paramView.setVisibility(0);
            }
          }
        });
        localc.start();
      }
      return;
      if (!paramBoolean)
      {
        localc = new com.d.a.c();
        localj = com.d.a.j.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() });
        localc.setDuration(300L);
        localc.playTogether(new com.d.a.a[] { localj });
      }
    }
  }
  
  public static void showCoverAlphaAnimation(boolean paramBoolean, View paramView)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.7F);; localAlphaAnimation = new AlphaAnimation(0.7F, 0.0F))
    {
      localAlphaAnimation.setDuration(300L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setFillBefore(false);
      paramView.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          this.a.setBackgroundColor(Color.parseColor("#000000"));
        }
      });
      return;
    }
  }
  
  public static void showCoverAlphaAnimaton(View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 0.3F);
    localAlphaAnimation.setDuration(300L);
    paramView.setAnimation(localAlphaAnimation);
    localAlphaAnimation.startNow();
  }
  
  public static void showFailureMessage(Context paramContext, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      g.textToast(paramContext, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof com.ziroom.commonlibrary.a.b))
    {
      g.textToast(paramContext, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof UnknownHostException))
    {
      g.textToast(paramContext, "网络请求失败，请检查网络连接");
      return;
    }
    g.textToast(paramContext, "服务器请求异常！");
  }
  
  public static void showGateFailureMessage(Context paramContext, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      g.textToast(paramContext, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
    {
      g.textToast(paramContext, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof UnknownHostException))
    {
      g.textToast(paramContext, "网络请求失败，请检查网络连接");
      return;
    }
    g.textToast(paramContext, "服务器请求异常！");
  }
  
  public static void showSameArrow(boolean paramBoolean, View paramView)
  {
    if (paramBoolean) {}
    for (RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);; localRotateAnimation = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F))
    {
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  public static void showSelectTypeView(boolean paramBoolean, final View paramView)
  {
    ObjectAnimator localObjectAnimator = null;
    Object localObject;
    if ((paramView.getVisibility() != 0) && (paramBoolean))
    {
      localObject = new AnimatorSet();
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { -paramView.getHeight(), 0.0F });
      localObjectAnimator.setDuration(300L);
      ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator });
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            super.onAnimationEnd(paramAnonymousAnimator);
            if (!this.a) {
              paramView.setVisibility(8);
            }
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            super.onAnimationStart(paramAnonymousAnimator);
            if (this.a) {
              paramView.setVisibility(0);
            }
          }
        });
        ((AnimatorSet)localObject).start();
      }
      return;
      localObject = localObjectAnimator;
      if (paramView.getVisibility() == 0)
      {
        localObject = localObjectAnimator;
        if (!paramBoolean)
        {
          localObject = new AnimatorSet();
          localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, -paramView.getHeight() });
          localObjectAnimator.setDuration(300L);
          ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator });
        }
      }
    }
  }
  
  public static void showServceEvalTran(final boolean paramBoolean, View paramView, final int paramInt)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofInt(new int[] { 0, paramInt });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        Log.d("sdjd", "=======  animatorValue=" + i);
        paramAnonymousValueAnimator = this.a.getLayoutParams();
        if (paramBoolean) {}
        for (paramAnonymousValueAnimator.height = i;; paramAnonymousValueAnimator.height = (paramInt - i))
        {
          this.a.setLayoutParams(paramAnonymousValueAnimator);
          return;
        }
      }
    });
    localValueAnimator.setDuration(200L);
    localValueAnimator.start();
  }
  
  public static void showSoftInput(Context paramContext, EditText paramEditText)
  {
    paramEditText.requestFocus();
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInput(0, 2);
  }
  
  public static void startActivityByServiceBean(Context paramContext, aw paramaw)
  {
    if ((paramaw.isNeedLogin()) && (!ApplicationEx.c.isLoginState()))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    if (paramaw.getTargetClazz() == null)
    {
      af.showToast(paramContext, "敬请期待");
      return;
    }
    if ((paramaw.isNeedContract()) && (ApplicationEx.c.isLoginState()) && ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0))))
    {
      if (TextUtils.isEmpty(paramaw.getServeType()))
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(paramContext).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if ("week_clean".equals(paramaw.getServeType()))
      {
        if (("330100".equals(com.ziroom.ziroomcustomer.base.b.d)) || ("320100".equals(com.ziroom.ziroomcustomer.base.b.d)))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(paramContext).setTitle("提示").setContent("这是自如客专享的保洁，非自如客暂不能预约哦~").setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
            }
          }).build().show();
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent("这是自如客专享的保洁~非自如客可以预约通用保洁哦~").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(this.a, CleanHomeActivity.class);
              this.a.startActivity(paramAnonymousView);
            }
          }
        }).build().show();
        return;
      }
      if ("ziroomer_repair".equals(paramaw.getServeType()))
      {
        if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent("这是自如客专享的维修哦~非自如客可以预约通用维修哦~").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean)
              {
                paramAnonymousView = new Intent(this.a, RepairHomeActivity.class);
                this.a.startActivity(paramAnonymousView);
              }
            }
          }).build().show();
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(paramContext).setTitle("提示").setContent("这是自如客专享的维修，非自如客暂不能预约哦~").setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(paramContext).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      }).build().show();
      return;
    }
    Class localClass = paramaw.getTargetClazz();
    Intent localIntent = new Intent(paramContext, paramaw.getTargetClazz());
    if (localClass.getName().equals(IntellectLockActivity.class.getName()))
    {
      localIntent.setClass(paramContext, GestureLockActivity.class);
      localIntent.putExtra("to", paramaw.getTargetClazz().getName());
    }
    if ((paramaw.getBundle() != null) && (paramaw.getBundle().size() > 0)) {
      localIntent.putExtras(paramaw.getBundle());
    }
    if (paramaw.getTitle() != null) {}
    paramContext.startActivity(localIntent);
  }
  
  public static void toBiWeekActivity(Context paramContext)
  {
    if (ApplicationEx.c.getUser() == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
    }
    List localList;
    do
    {
      return;
      localList = ApplicationEx.c.getContracts();
    } while ((localList == null) || (localList.size() <= 0));
    paramContext.startActivity(new Intent(paramContext, ForCleaningActivity.class));
  }
  
  public static void toChat(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.startActivity(new Intent(paramBaseActivity, ChatWebViewActivity.class));
  }
  
  public static void toLeaveCleaner(Context paramContext, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "保洁员已离职，请联系400-100-1111";
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(paramContext).setButtonText("确定").setContent(str).setOnButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ah.callPhone(this.a, "4001001111");
      }
    }).build().show();
  }
  
  public static void toMyKeeperActivity(Context paramContext)
  {
    if (ApplicationEx.c.getUser() == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, MyStewardListActivity.class));
  }
  
  public static void toServiceOrderList(Context paramContext, String paramString1, String paramString2)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    Intent localIntent = new Intent(paramContext, ZiroomOrderListActivity.class);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("order_bus_type", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("order_status_type", paramString2);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void toShareCoupon(final Context paramContext, final SimpleDraweeView paramSimpleDraweeView, final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    com.ziroom.ziroomcustomer.e.n.getShareInfo(paramContext, paramString4, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.ziroom.ziroomcustomer.newServiceList.model.m.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newServiceList.model.m paramAnonymousm)
      {
        if (paramAnonymousm != null)
        {
          String str = paramAnonymousm.getBanner().getContent();
          paramSimpleDraweeView.setVisibility(0);
          paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(str));
          paramSimpleDraweeView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              j.createShareInfo(j.2.this.c, j.2.this.d, j.2.this.e, j.2.this.f, j.2.this.g, paramAnonymousm);
            }
          });
        }
      }
    });
  }
  
  public static void toZiRuRepair(Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    Object localObject = ApplicationEx.c.getContracts();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new Intent(paramContext, InternalRepairSelectActivity.class);
      ((Intent)localObject).putExtra("isMyFragment", true);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    if ("110000".equals(com.ziroom.ziroomcustomer.base.b.d))
    {
      com.ziroom.ziroomcustomer.dialog.c.newBuilder(paramContext).setButtonText("取消").setSecondButtonText("去预约").setContent("这是自如客专享的维修哦~非自如客可以预约通用维修哦~").setOnButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      }).setOnSecondClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(this.a, RepairHomeActivity.class);
          this.a.startActivity(paramAnonymousView);
        }
      }).build().show();
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(paramContext).setButtonText("确定").setContent("这是自如客专享的维修，非自如客暂不能预约哦~").setOnButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    }).build().show();
  }
  
  public static void toZiRuRepairV2(Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    Object localObject = ApplicationEx.c.getContracts();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new Intent(paramContext, InternalRepairSelectActivity.class);
      ((Intent)localObject).putExtra("isMyFragment", true);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(paramContext).setButtonText("确定").setContent("这是自如客专享的维修，非自如客暂不能预约哦~").setOnButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    }).build().show();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */