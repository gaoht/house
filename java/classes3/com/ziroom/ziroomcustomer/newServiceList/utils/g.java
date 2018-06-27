package com.ziroom.ziroomcustomer.newServiceList.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.activity.IntellectLockActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.gesturelock.GestureLockActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairBuyCardActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.aw;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.a;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.c;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.d;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class g
{
  public static Class getActivityClassByCMS(String paramString1, String paramString2)
  {
    if ("1".equals(paramString1))
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
    while (!"0".equals(paramString1))
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
                      if (paramString2.equals("clean_woshi"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_xiaoban"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("move_truck"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_shuiluguanjian"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_dengjudianlu"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kaisuohuansuo"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("repair_kongtiaoqingxi"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_repair"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("card_clean"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString2.equals("upin_jiaju"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString2.equals("move_list"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString2.equals("clean_list"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString2.equals("repair_list"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString2.equals("uping_list")) {
                                                  i = 20;
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
      return CleanIndexActivity.class;
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
      return MoveTypeActivity.class;
      return CleanHomeActivity.class;
      return RepairHomeActivity.class;
      if (!TextUtils.isEmpty(ad.getOther(ApplicationEx.c.getApplicationContext(), "youpinH5url"))) {
        return YouPinGuidanceH5Activity.class;
      }
      return YouPinGuidanceActivity.class;
    }
    return JsBridgeWebActivity.class;
  }
  
  public static aw getBannerBean(int paramInt, String paramString1, String paramString2, Class paramClass, Bundle paramBundle, boolean paramBoolean, String paramString3)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setTitle(paramString1);
    localaw.setNetIcon(paramString2);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean);
    localaw.setAppTo(paramString3);
    return localaw;
  }
  
  public static aw getBannerData(bc.a parama)
  {
    String str2 = parama.getTitle();
    String str3 = parama.getImg();
    Class localClass = getActivityClassByCMS(parama.getApp(), parama.getTarget());
    Bundle localBundle = new Bundle();
    boolean bool;
    String str1;
    if ("0".equals(parama.getApp()))
    {
      localBundle.putString("url", parama.getTarget());
      localBundle.putString("title", parama.getTitle());
      localBundle.putString("shareContent", parama.getDescription());
      localBundle.putString("shareImg", parama.getDescription());
      localBundle.putBoolean("isShowShare", true);
      bool = isNeedLogin(parama.getApp(), parama.getTarget());
      str1 = "";
      if (!"1".equals(parama.getApp())) {
        break label152;
      }
      str1 = "native";
    }
    for (;;)
    {
      return getBannerBean(2130839498, str2, str3, localClass, localBundle, bool, str1);
      localBundle = getBundleByCMS(parama.getApp(), parama.getTarget());
      break;
      label152:
      if ("0".equals(parama.getApp())) {
        str1 = "html";
      }
    }
  }
  
  public static Bundle getBundleByCMS(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    int i;
    if ("1".equals(paramString1))
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
                      if (paramString2.equals("clean_woshi"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_xiaoban"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("move_truck"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_shuiluguanjian"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_dengjudianlu"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kaisuohuansuo"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("repair_kongtiaoqingxi"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_repair"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("card_clean"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString2.equals("upin_jiaju"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString2.equals("move_list"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString2.equals("clean_list"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString2.equals("repair_list"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString2.equals("uping_list")) {
                                                  i = 20;
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
    localBundle.putString("ServiceInfoId", "8a90a5d85841edb0015847dd11110000");
    localBundle.putString("ServiceInfoName", "卧室保洁");
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
    return null;
    return null;
    return null;
    return null;
  }
  
  public static String getCleanNameByCode(String paramString)
  {
    String str = "";
    if ("2c9084454b7835b0014b7841269101a9".equals(paramString)) {
      str = "日常保洁";
    }
    do
    {
      return str;
      if ("2c9084434b783482014b784188290209".equals(paramString)) {
        return "深度保洁";
      }
      if ("2c9084454b7835b0014b78422b1e01cb".equals(paramString)) {
        return "开荒保洁";
      }
      if ("2c9084454b7835b0014b7842917e01d7".equals(paramString)) {
        return "消杀保洁";
      }
      if ("8a90a5d8580a5cb2015822c397920018".equals(paramString)) {
        return "擦玻璃";
      }
    } while (!"8a90a5d85841edb0015847dd78a80014".equals(paramString));
    return "除螨";
  }
  
  public static aw getRecommendBean(int paramInt, String paramString1, String paramString2, Class paramClass, Bundle paramBundle, boolean paramBoolean, String paramString3)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setTitle(paramString1);
    localaw.setNetIcon(paramString2);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean);
    localaw.setAppTo(paramString3);
    return localaw;
  }
  
  public static List<aw> getRecommendData(List<bc.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str2;
    String str3;
    Class localClass;
    Bundle localBundle;
    label200:
    boolean bool;
    String str1;
    if (i < paramList.size())
    {
      str2 = ((bc.c)paramList.get(i)).getTitle();
      str3 = ((bc.c)paramList.get(i)).getImg();
      localClass = getActivityClassByCMS(((bc.c)paramList.get(i)).getApp(), ((bc.c)paramList.get(i)).getTarget());
      localBundle = new Bundle();
      if ("0".equals(((bc.c)paramList.get(i)).getApp()))
      {
        localBundle.putString("url", ((bc.c)paramList.get(i)).getTarget());
        localBundle.putString("title", ((bc.c)paramList.get(i)).getTitle());
        localBundle.putString("shareContent", ((bc.c)paramList.get(i)).getDescription());
        localBundle.putString("shareImg", ((bc.c)paramList.get(i)).getImg());
        localBundle.putBoolean("isShowShare", true);
        bool = isNeedLogin(((bc.c)paramList.get(i)).getApp(), ((bc.c)paramList.get(i)).getTarget());
        if (!"1".equals(((bc.c)paramList.get(i)).getApp())) {
          break label318;
        }
        str1 = "native";
      }
    }
    for (;;)
    {
      localArrayList.add(getRecommendBean(2130839498, str2, str3, localClass, localBundle, bool, str1));
      i += 1;
      break;
      localBundle = getBundleByCMS(((bc.c)paramList.get(i)).getApp(), ((bc.c)paramList.get(i)).getTarget());
      break label200;
      label318:
      if ("0".equals(((bc.c)paramList.get(i)).getApp()))
      {
        str1 = "html";
        continue;
        return localArrayList;
      }
      else
      {
        str1 = "";
      }
    }
  }
  
  public static List<aw> getShrfflingData(List<bc.d> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str2;
    String str3;
    Class localClass;
    Bundle localBundle;
    label200:
    boolean bool;
    String str1;
    if (i < paramList.size())
    {
      str2 = ((bc.d)paramList.get(i)).getTitle();
      str3 = ((bc.d)paramList.get(i)).getImg();
      localClass = getActivityClassByCMS(((bc.d)paramList.get(i)).getApp(), ((bc.d)paramList.get(i)).getTarget());
      localBundle = new Bundle();
      if ("0".equals(((bc.d)paramList.get(i)).getApp()))
      {
        localBundle.putString("url", ((bc.d)paramList.get(i)).getTarget());
        localBundle.putString("title", ((bc.d)paramList.get(i)).getTitle());
        localBundle.putString("shareContent", ((bc.d)paramList.get(i)).getDescription());
        localBundle.putString("shareImg", ((bc.d)paramList.get(i)).getImg());
        localBundle.putBoolean("isShowShare", true);
        bool = isNeedLogin(((bc.d)paramList.get(i)).getApp(), ((bc.d)paramList.get(i)).getTarget());
        if (!"1".equals(((bc.d)paramList.get(i)).getApp())) {
          break label318;
        }
        str1 = "native";
      }
    }
    for (;;)
    {
      localArrayList.add(getShufflingBean(2130839498, str2, str3, localClass, localBundle, bool, str1));
      i += 1;
      break;
      localBundle = getBundleByCMS(((bc.d)paramList.get(i)).getApp(), ((bc.d)paramList.get(i)).getTarget());
      break label200;
      label318:
      if ("0".equals(((bc.d)paramList.get(i)).getApp()))
      {
        str1 = "html";
        continue;
        return localArrayList;
      }
      else
      {
        str1 = "";
      }
    }
  }
  
  public static aw getShufflingBean(int paramInt, String paramString1, String paramString2, Class paramClass, Bundle paramBundle, boolean paramBoolean, String paramString3)
  {
    aw localaw = new aw();
    localaw.setResIcon(paramInt);
    localaw.setTitle(paramString1);
    localaw.setNetIcon(paramString2);
    localaw.setTargetClazz(paramClass);
    localaw.setBundle(paramBundle);
    localaw.setNeedLogin(paramBoolean);
    localaw.setAppTo(paramString3);
    return localaw;
  }
  
  public static boolean isNeedLogin(String paramString1, String paramString2)
  {
    if ("1".equals(paramString1))
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
    while (!"0".equals(paramString1))
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
                      if (paramString2.equals("clean_woshi"))
                      {
                        i = 7;
                        continue;
                        if (paramString2.equals("move_xiaoban"))
                        {
                          i = 8;
                          continue;
                          if (paramString2.equals("move_truck"))
                          {
                            i = 9;
                            continue;
                            if (paramString2.equals("repair_shuiluguanjian"))
                            {
                              i = 10;
                              continue;
                              if (paramString2.equals("repair_dengjudianlu"))
                              {
                                i = 11;
                                continue;
                                if (paramString2.equals("repair_kaisuohuansuo"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString2.equals("repair_kongtiaoqingxi"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString2.equals("card_repair"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString2.equals("card_clean"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString2.equals("upin_jiaju"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString2.equals("move_list"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString2.equals("clean_list"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString2.equals("repair_list"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString2.equals("uping_list")) {
                                                  i = 20;
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
      return true;
      return true;
      return true;
      return true;
    }
    return false;
  }
  
  public static void startActivityByPageBean(Context paramContext, aw paramaw)
  {
    if ((paramaw.isNeedLogin()) && (!ApplicationEx.c.isLoginState())) {
      a.startLoginActivity(paramContext);
    }
    do
    {
      return;
      if (paramaw.getTargetClazz() == null)
      {
        af.showToast(paramContext, "服务尚未开通，敬请期待");
        return;
      }
      if ((paramaw.isNeedContract()) && (ApplicationEx.c.isLoginState()) && ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0))) && (TextUtils.isEmpty(paramaw.getServeType())))
      {
        e.newBuilder(paramContext).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if ("native".equals(paramaw.getAppTo()))
      {
        localObject1 = paramaw.getTargetClazz();
        localObject2 = new Intent(paramContext, paramaw.getTargetClazz());
        if (((Class)localObject1).getName().equals(IntellectLockActivity.class.getName()))
        {
          ((Intent)localObject2).setClass(paramContext, GestureLockActivity.class);
          ((Intent)localObject2).putExtra("to", paramaw.getTargetClazz().getName());
        }
        if ((paramaw.getBundle() != null) && (paramaw.getBundle().size() > 0)) {
          ((Intent)localObject2).putExtras(paramaw.getBundle());
        }
        if (paramaw.getTitle() != null) {}
        paramContext.startActivity((Intent)localObject2);
        return;
      }
    } while (!"html".equals(paramaw.getAppTo()));
    Object localObject1 = paramaw.getBundle().getString("title");
    Object localObject2 = paramaw.getBundle().getString("url");
    String str1 = paramaw.getBundle().getString("shareContent");
    String str2 = paramaw.getBundle().getString("shareImg");
    JsBridgeWebActivity.start(paramContext, (String)localObject1, (String)localObject2, paramaw.getBundle().getBoolean("isShowShare", false), str1, str2, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */