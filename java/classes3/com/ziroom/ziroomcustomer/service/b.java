package com.ziroom.ziroomcustomer.service;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import cn.jpush.android.api.JPushInterface;
import com.ziroom.ziroomcustomer.activity.MessageCenterActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.d.d;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.y;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.Calendar;

public class b
  implements com.ziroom.commonlibrary.receiver.a
{
  String a = "";
  private Intent b;
  private PendingIntent c;
  private Notification d;
  private NotificationManager e;
  private String f = "JpushListenerSysMessImpl";
  private int g = 101000;
  
  private com.ziroom.commonlibrary.c.b a(Bundle paramBundle)
  {
    com.ziroom.commonlibrary.c.b localb = new com.ziroom.commonlibrary.c.b();
    paramBundle.getString(JPushInterface.EXTRA_ALERT);
    String str1 = paramBundle.getString(JPushInterface.EXTRA_MESSAGE);
    String str2 = paramBundle.getString(JPushInterface.EXTRA_ALERT);
    String str4 = paramBundle.getString(JPushInterface.EXTRA_TITLE);
    String str3 = paramBundle.getString(JPushInterface.EXTRA_EXTRA);
    localb.e = str4;
    if (ae.isNull(str1)) {}
    for (paramBundle = str2;; paramBundle = str1)
    {
      localb.d = paramBundle;
      localb.f = str3;
      localb.k = (Calendar.getInstance().getTimeInMillis() + "");
      localb.l = (Calendar.getInstance().getTimeInMillis() + "");
      localb.m = 0;
      localb.n = 0;
      if (ae.notNull(str3))
      {
        Object localObject = com.alibaba.fastjson.a.parseObject(str3);
        if (localObject != null)
        {
          paramBundle = ((com.alibaba.fastjson.e)localObject).getString("msgId");
          str1 = ((com.alibaba.fastjson.e)localObject).getString("msg_body_type");
          str2 = ((com.alibaba.fastjson.e)localObject).getString("msg_sub_type");
          str4 = ((com.alibaba.fastjson.e)localObject).getString("push_time");
          String str5 = ((com.alibaba.fastjson.e)localObject).getString("msg_tag_type");
          localObject = ((com.alibaba.fastjson.e)localObject).getString("msg_backup");
          localb.c = paramBundle;
          localb.g = str1;
          localb.h = str2;
          if (!ae.isNull(str5)) {
            localb.i = Integer.parseInt(str5);
          }
          localb.j = ((String)localObject);
          u.i(this.f, "msg_extra:" + str3 + ";msg_body_type:" + str1 + ";msg_sub_type:" + str2 + ";msg_tag_type:" + str5 + ";msg_backup:" + (String)localObject + ";push_time:" + str4);
          if (!ae.isNull(str4)) {
            localb.k = str4;
          }
        }
      }
      return localb;
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(805306394, "");
    paramContext.acquire(3000L);
    paramContext.release();
  }
  
  public void onClickNotiInBar(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    Object localObject;
    int i;
    if ((paramb != null) && (ae.notNull(paramb.g)))
    {
      localObject = paramb.g;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject = com.alibaba.fastjson.a.parseObject(paramb.f);
          if (((com.alibaba.fastjson.e)localObject).get("content") == null)
          {
            localObject = "";
            label231:
            if ((ae.isNull((String)localObject)) || (!ah.isWebUrl((String)localObject))) {
              break label621;
            }
            JsBridgeWebActivity.start(paramContext, paramb.e, (String)localObject, true, paramb.d, "", false);
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      this.b.setFlags(268435456);
      paramContext.startActivity(this.b);
      return;
      if (!((String)localObject).equals("move_clean_notify")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("home_repair_notify")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("service_notify_new")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("friend_whole_notify")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("smart_lock_notify")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject).equals("station_notify")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject).equals("apartment_notify")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject).equals("push_notify")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject).equals("finance_notify")) {
        break;
      }
      i = 8;
      break;
      if (!((String)localObject).equals("red_paper_notify")) {
        break;
      }
      i = 9;
      break;
      if (!((String)localObject).equals("value_card_notify")) {
        break;
      }
      i = 10;
      break;
      if (!((String)localObject).equals("community_activities_notify")) {
        break;
      }
      i = 11;
      break;
      if (!((String)localObject).equals("credit_notify")) {
        break;
      }
      i = 12;
      break;
      a.getInstance(paramContext).dealMoveClean(paramb);
      return;
      a.getInstance(paramContext).dealRepair(paramb);
      return;
      a.getInstance(paramContext).dealService(paramb);
      return;
      a.getInstance(paramContext).dealRentWhole(paramb);
      return;
      a.getInstance(paramContext).dealSmartLock(paramb);
      return;
      a.getInstance(paramContext).dealStation(paramb);
      return;
      a.getInstance(paramContext).dealApartmentFromNoticaication(paramb);
      return;
      a.getInstance(paramContext).dealPush(paramb);
      return;
      a.getInstance(paramContext).dealFinance(paramb);
      return;
      a.getInstance(paramContext).dealAccountGiftPush(paramb);
      return;
      a.getInstance(paramContext).CleanGiftCardPush(paramb);
      return;
      a.getInstance(paramContext).dealCommunityActivities(paramb);
      return;
      a.getInstance(paramContext).dealCreditActivities(paramb);
      return;
      localObject = ((com.alibaba.fastjson.e)localObject).get("content").toString();
      break label231;
      label621:
      this.b = new Intent(paramContext, MessageCenterActivity.class);
    }
  }
  
  public void onClickNotiInSysMess(Context paramContext, com.ziroom.commonlibrary.c.b paramb)
  {
    int i;
    if ((paramb != null) && (ae.notNull(paramb.g)))
    {
      localObject = paramb.g;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject = com.alibaba.fastjson.a.parseObject(paramb.f);
          if (((com.alibaba.fastjson.e)localObject).get("content") != null) {}
          break;
        }
        break;
      }
    }
    for (Object localObject = "";; localObject = ((com.alibaba.fastjson.e)localObject).get("content").toString())
    {
      if ((!ae.isNull((String)localObject)) && (ah.isWebUrl((String)localObject))) {
        JsBridgeWebActivity.start(paramContext, paramb.e, (String)localObject, true, paramb.d, "", false);
      }
      return;
      if (!((String)localObject).equals("move_clean_notify")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("home_repair_notify")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("service_notify_new")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("friend_whole_notify")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("smart_lock_notify")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject).equals("station_notify")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject).equals("apartment_notify")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject).equals("push_notify")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject).equals("red_paper_notify")) {
        break;
      }
      i = 8;
      break;
      if (!((String)localObject).equals("finance_notify")) {
        break;
      }
      i = 9;
      break;
      if (!((String)localObject).equals("value_card_notify")) {
        break;
      }
      i = 10;
      break;
      if (!((String)localObject).equals("community_activities_notify")) {
        break;
      }
      i = 11;
      break;
      if (!((String)localObject).equals("credit_notify")) {
        break;
      }
      i = 12;
      break;
      a.getInstance(paramContext).dealMoveClean(paramb);
      return;
      a.getInstance(paramContext).dealRepair(paramb);
      return;
      a.getInstance(paramContext).dealService(paramb);
      return;
      a.getInstance(paramContext).dealRentWhole(paramb);
      return;
      a.getInstance(paramContext).dealSmartLock(paramb);
      return;
      a.getInstance(paramContext).dealStation(paramb);
      return;
      a.getInstance(paramContext).dealApartment(paramb);
      return;
      a.getInstance(paramContext).dealPush(paramb);
      return;
      a.getInstance(paramContext).dealAccountGiftPush(paramb);
      return;
      a.getInstance(paramContext).dealFinance(paramb);
      return;
      a.getInstance(paramContext).CleanGiftCardPush(paramb);
      return;
      a.getInstance(paramContext).dealCommunityActivities(paramb);
      return;
      a.getInstance(paramContext).dealCreditActivities(paramb);
      return;
    }
  }
  
  public void openMessageActivity(Context paramContext, Bundle paramBundle)
  {
    com.ziroom.commonlibrary.c.b localb = a(paramBundle);
    e.sendMessageDeal(paramContext, localb);
    if ("minsu_notify".equals(localb.g)) {
      d.getInstance(paramContext).deal(paramBundle);
    }
    while (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() == null) {
      return;
    }
    com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInBar(paramContext, localb);
  }
  
  public void processCustomMessage(Context paramContext, Bundle paramBundle)
  {
    u.i(this.f, "processCustomMessage");
    d.getInstance(paramContext).Messagedeal(paramBundle);
    saveMessage(paramContext, paramBundle);
    try
    {
      sendNotification(paramContext, paramBundle);
      paramContext.sendBroadcast(new Intent("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION"));
      return;
    }
    catch (Exception paramContext)
    {
      u.e(this.f, "processCustomMessage Error is " + paramContext.toString());
    }
  }
  
  public void processNotification(Context paramContext, Bundle paramBundle)
  {
    u.i(this.f, "processNotification");
    saveMessage(paramContext, paramBundle);
  }
  
  public void processRegistration(Context paramContext, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
    u.i(this.f, "注册的regId：" + paramBundle);
    y.putString(paramContext, "zr_dev_token_key", paramBundle);
    e.sendDeviceInfo(paramContext, paramBundle);
  }
  
  public com.ziroom.commonlibrary.c.b saveMessage(Context paramContext, Bundle paramBundle)
  {
    com.ziroom.commonlibrary.c.b localb = new com.ziroom.commonlibrary.c.b();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      this.a = localUserInfo.getUid();
    }
    try
    {
      paramBundle = a(paramBundle);
      u.e(this.f, "saveMessage Error is " + paramBundle.toString());
    }
    catch (Exception paramBundle)
    {
      try
      {
        e.sendMessageRece(paramContext, paramBundle);
        return paramBundle;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramContext = paramBundle;
          paramBundle = localException;
        }
      }
      paramBundle = paramBundle;
      paramContext = localb;
    }
    return paramContext;
  }
  
  public void sendNotification(Context paramContext, Bundle paramBundle)
  {
    Object localObject2 = paramBundle.getString(JPushInterface.EXTRA_MESSAGE);
    Object localObject3 = paramBundle.getString(JPushInterface.EXTRA_ALERT);
    Object localObject1 = localObject2;
    if (ae.isNull((String)localObject2)) {
      localObject1 = localObject3;
    }
    this.e = ((NotificationManager)paramContext.getSystemService("notification"));
    this.b = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
    this.b.putExtras(paramBundle);
    this.c = PendingIntent.getBroadcast(paramContext, 0, this.b, 134217728);
    localObject3 = new Notification.Builder(paramContext);
    if (ae.isNull(paramBundle.getString(JPushInterface.EXTRA_TITLE)))
    {
      localObject2 = "自如消息";
      localObject3 = ((Notification.Builder)localObject3).setContentTitle((CharSequence)localObject2);
      localObject2 = localObject1;
      if (ae.isNull((String)localObject1)) {
        localObject2 = "消息内容为空";
      }
      this.d = ((Notification.Builder)localObject3).setContentText((CharSequence)localObject2).setSmallIcon(2130838626).setContentIntent(this.c).build();
      localObject1 = this.d;
      if (!ae.isNull(paramBundle.getString(JPushInterface.EXTRA_TITLE))) {
        break label295;
      }
    }
    label295:
    for (paramBundle = "自如消息";; paramBundle = paramBundle.getString(JPushInterface.EXTRA_TITLE))
    {
      ((Notification)localObject1).tickerText = paramBundle;
      this.d.flags = 16;
      paramBundle = this.d;
      paramBundle.defaults |= 0x1;
      paramBundle = this.d;
      paramBundle.defaults |= 0x2;
      paramBundle = this.d;
      paramBundle.defaults |= 0x4;
      paramBundle = this.e;
      int i = this.g + 1;
      this.g = i;
      paramBundle.notify(i, this.d);
      a(paramContext);
      return;
      localObject2 = paramBundle.getString(JPushInterface.EXTRA_TITLE);
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */