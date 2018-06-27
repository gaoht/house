package com.ziroom.ziroomcustomer.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Process;
import cn.jpush.android.api.JPushInterface;
import com.huawei.hms.api.HuaweiApiClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.ziroom.commonlibrary.g.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.a.c;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.y;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class e
{
  public static Context a;
  public static String b = "PushInterface";
  public static int c = 0;
  public static String d = "";
  public static int e = -1;
  public static int f = -1;
  public static int g = -1;
  public static HuaweiApiClient h;
  private static String i = "";
  
  public static void JPushInit(Context paramContext)
  {
    u.i(b, "初始化,极光推送");
    JPushInterface.init(paramContext);
    JPushInterface.setDebugMode(false);
    if (JPushInterface.isPushStopped(paramContext)) {
      JPushInterface.resumePush(paramContext);
    }
    c = 1;
    a(paramContext);
  }
  
  private static void a(Context paramContext)
  {
    y.putInt(paramContext, "push_channel_key", c);
    switch (c)
    {
    case 3: 
    default: 
      d = d.f;
    }
    for (;;)
    {
      y.putString(paramContext, "push_channel_name_key", d);
      return;
      d = d.f;
      continue;
      d = d.c;
    }
  }
  
  private static void a(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    u.i("JpushListenerSysMessImpl", "广播类已收消息反馈");
    String str3 = y.getString(paramContext, "zr_dev_token_key");
    int j = 0;
    String str1 = "";
    String str2 = "";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      str1 = localUserInfo.getUid();
      j = 1;
      str2 = ah.toMd5(str1.getBytes());
    }
    paramContext = d.buildBroadCastRece(paramContext, paramb.c, null, str3, j, str1, str2);
    f.sendBroadcastRece(new e.11(new r()), paramContext);
  }
  
  private static void b(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    u.i("JpushListenerSysMessImpl", "接收消息反馈");
    f.sendFeedBackRece(new e.2(new r()), d.buildFeedbackRece(paramContext, paramb.c, null));
  }
  
  private static boolean b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = paramContext.getPackageName();
    int j = Process.myPid();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.pid == j) && (paramContext.equals(localRunningAppProcessInfo.processName))) {
        return true;
      }
    }
    return false;
  }
  
  private static void c(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    u.i("JpushListenerSysMessImpl", "广播类已读消息反馈");
    String str3 = y.getString(paramContext, "zr_dev_token_key");
    int j = 0;
    String str1 = "";
    String str2 = "";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      str1 = localUserInfo.getUid();
      j = 1;
      str2 = ah.toMd5(str1.getBytes());
    }
    paramContext = d.buildBroadCastDeal(paramContext, paramb.c, null, str3, j, str1, str2);
    f.sendBroadcastDeal(new e.3(new r()), paramContext);
  }
  
  private static void d(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    u.i("JpushListenerSysMessImpl", "非广播类已读消息反馈");
    f.sendFeedBackDeal(new e.4(new r()), d.buildFeedbackDeal(paramContext, paramb.c, null));
  }
  
  public static String getChannelCurrName(Context paramContext)
  {
    return d;
  }
  
  public static long getLastSyncTime(Context paramContext)
  {
    long l = y.getLong(paramContext, "push_last_sync_time", -1L);
    if (-1L != l) {
      return l;
    }
    paramContext = Calendar.getInstance();
    paramContext.add(5, -7);
    return paramContext.getTimeInMillis();
  }
  
  public static void init(Context paramContext)
  {
    a = paramContext;
    a.getInstance().setjPushListener(new b());
    c = y.getInt(paramContext, "push_channel_key", 0);
    d = y.getString(paramContext, "push_channel_name_key");
    if (c == 0)
    {
      c = com.ziroom.ziroomcustomer.util.b.getPushChannel();
      switch (c)
      {
      }
    }
    for (;;)
    {
      init(paramContext, c);
      return;
      u.i(b, "其他手机");
      continue;
      u.i(b, "小米手机");
      continue;
      u.i(b, "华为手机");
    }
  }
  
  public static void init(Context paramContext, int paramInt)
  {
    c = y.getInt(paramContext, "push_channel_key", 0);
    if (paramInt != c)
    {
      c = paramInt;
      a(paramContext);
    }
    d = y.getString(paramContext, "push_channel_name_key");
    switch (c)
    {
    case 3: 
    default: 
      JPushInit(paramContext);
    }
    do
    {
      do
      {
        return;
        if (-1 == g) {
          g = y.getInt(paramContext, d.f);
        }
        u.i(b, "初始化,极光推送");
        JPushInterface.init(paramContext);
        JPushInterface.setDebugMode(false);
      } while (!JPushInterface.isPushStopped(paramContext));
      JPushInterface.resumePush(paramContext);
      return;
      if (-1 == f) {
        f = y.getInt(paramContext, d.c);
      }
      if (1 != f) {
        break;
      }
      u.i(b, "准备初始化,小米推送");
    } while (!b(paramContext));
    u.i(b, "初始化,小米推送");
    MiPushClient.registerPush(paramContext, "2882303761517229920", "5241722961920");
    JPushInterface.stopPush(paramContext);
    return;
    JPushInit(paramContext);
  }
  
  public static boolean isConnected()
  {
    return (h != null) && (h.isConnected());
  }
  
  public static void putLastSyncTime(Context paramContext, long paramLong)
  {
    y.putLong(paramContext, "push_last_sync_time", paramLong);
  }
  
  public static void sendDeviceInfo(Context paramContext, String paramString)
  {
    if (ae.isNull(paramString)) {
      paramString = y.getString(paramContext, "zr_dev_token_key");
    }
    for (;;)
    {
      if (!ae.isNull(paramString))
      {
        String str3 = i.getPhoneBrand();
        String str4 = i.getPhoneModel();
        String str5 = i.getSysVersion();
        String str6 = i.getIMEI(paramContext);
        String str7 = i.getLanguage();
        String str8 = d.a;
        String str9 = ah.getVersion(ApplicationEx.c);
        String str10 = y.getString(paramContext, "push_channel_name_key");
        int j = 0;
        String str1 = "";
        String str2 = "";
        Object localObject = ApplicationEx.c.getUser();
        if (localObject != null)
        {
          str1 = ((UserInfo)localObject).getUid();
          j = 1;
          str2 = ah.toMd5(str1.getBytes());
        }
        localObject = y.getString(paramContext, "zr_lat_key");
        String str11 = y.getString(paramContext, "zr_lng_key");
        double d1 = 0.0D;
        double d2 = 0.0D;
        if (!ae.isNull((String)localObject)) {
          d1 = Double.parseDouble((String)localObject);
        }
        if (!ae.isNull(str11)) {
          d2 = Double.parseDouble(str11);
        }
        localObject = y.getString(paramContext, "zr_geo_city_key");
        str11 = y.getString(paramContext, "zr_geo_address_key");
        paramContext = d.buildSendDeviceInfo(paramContext, paramString, str3, str4, str5, str6, str7, str8, str9, str10, j, str1, str2, d2, d1, com.ziroom.ziroomcustomer.base.b.c, (String)localObject, str11);
        f.sendDeviceInfo(new e.10(new r()), paramContext);
      }
      return;
    }
  }
  
  public static void sendMessageDeal(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    if (!ae.isNull(paramb.c))
    {
      if (!"push_notify".equals(paramb.g)) {
        d(paramContext, paramb);
      }
    }
    else {
      return;
    }
    c(paramContext, paramb);
  }
  
  public static void sendMessageRece(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    if (!ae.isNull(paramb.c))
    {
      if (!"push_notify".equals(paramb.g)) {
        b(paramContext, paramb);
      }
    }
    else {
      return;
    }
    a(paramContext, paramb);
  }
  
  public static void setAliasAndTags(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    sendDeviceInfo(paramContext, "");
    if (ae.isNull(paramString2)) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    }
    switch (c)
    {
    default: 
      u.i(b, "设置alias,极光推送alias:" + paramString2);
      JPushInterface.setAliasAndTags(paramContext, paramString2, paramSet, new e.9());
    case 4: 
      return;
    case 1: 
      u.i(b, "设置alias,极光推送alias:" + paramString2);
      JPushInterface.setAliasAndTags(paramContext, paramString2, paramSet, new e.1());
      return;
    case 2: 
      u.i(b, "设置alias,小米推送alias:" + paramString2);
      if (!ae.isNull(paramString2))
      {
        i = paramString2;
        MiPushClient.setUserAccount(paramContext, paramString2, null);
        return;
      }
      MiPushClient.unsetUserAccount(paramContext, i, null);
      i = paramString2;
      return;
    }
    if (!ae.isNull(paramString2))
    {
      f.setHuaWeiBind(paramContext, new e.5(new m(com.alibaba.fastjson.e.class, new c()), paramContext), d.buildSetHuaWeiBind(paramContext, d.e, d.a, paramString1, paramString2));
      f.setHuaWeiBind(paramContext, new e.6(new m(com.alibaba.fastjson.e.class, new c()), paramContext), d.buildSetHuaWeiBind(paramContext, d.e, d.b, paramString1, paramString2));
      return;
    }
    f.setHuaWeiUnbind(paramContext, new e.7(new m(com.alibaba.fastjson.e.class, new c()), paramContext), d.buildSetHuaWeiUnbind(paramContext, d.e, d.a, paramString1));
    f.setHuaWeiUnbind(paramContext, new e.8(new m(com.alibaba.fastjson.e.class, new c()), paramContext), d.buildSetHuaWeiUnbind(paramContext, d.e, d.b, paramString1));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/service/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */