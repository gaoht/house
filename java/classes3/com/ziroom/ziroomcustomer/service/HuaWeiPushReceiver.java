package com.ziroom.ziroomcustomer.service;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.alibaba.fastjson.b;
import com.huawei.hms.support.api.push.PushReceiver;
import com.huawei.hms.support.api.push.PushReceiver.Event;
import com.hyphenate.chat.EMClient;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.y;
import java.util.Iterator;
import java.util.Set;

public class HuaWeiPushReceiver
  extends PushReceiver
{
  String a = HuaWeiPushReceiver.class.getSimpleName();
  
  public Bundle createBundle(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(JPushInterface.EXTRA_TITLE, paramString1);
    localBundle.putString(JPushInterface.EXTRA_MESSAGE, paramString2);
    localBundle.putString(JPushInterface.EXTRA_EXTRA, paramString3);
    return localBundle;
  }
  
  public Bundle createRegistBundle(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(JPushInterface.EXTRA_REGISTRATION_ID, paramString);
    return localBundle;
  }
  
  public void onEvent(Context paramContext, PushReceiver.Event paramEvent, Bundle paramBundle)
  {
    String str2 = paramBundle.getString("pushMsg");
    String str1 = this.a;
    Object localObject2 = new StringBuilder().append("1ymq, receive extented notification message: ").append(str2).append(";event:");
    if (PushReceiver.Event.NOTIFICATION_OPENED.equals(paramEvent)) {}
    int i;
    for (Object localObject1 = PushReceiver.Event.NOTIFICATION_OPENED;; localObject1 = PushReceiver.Event.NOTIFICATION_CLICK_BTN)
    {
      u.i(str1, localObject1);
      b localb = b.parseArray(str2);
      localObject1 = "";
      str1 = "";
      localObject2 = "";
      i = 0;
      while (i < localb.size())
      {
        com.alibaba.fastjson.e locale = localb.getJSONObject(i);
        if (locale.containsKey("msg_title")) {
          str1 = locale.getString("msg_title");
        }
        if (locale.containsKey("msg_content")) {
          localObject2 = locale.getString("msg_content");
        }
        if (locale.containsKey("msg_extra")) {
          localObject1 = locale.getString("msg_extra");
        }
        i += 1;
      }
    }
    localObject1 = createBundle(str1, (String)localObject2, (String)localObject1);
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().saveMessage(paramContext, (Bundle)localObject1);
    }
    try
    {
      Thread.sleep(3000L);
      sendNotifyOpenBroadcast(paramContext, (Bundle)localObject1);
      if ((PushReceiver.Event.NOTIFICATION_OPENED.equals(paramEvent)) || (PushReceiver.Event.NOTIFICATION_CLICK_BTN.equals(paramEvent)))
      {
        i = paramBundle.getInt("pushNotifyId", 0);
        if (i != 0) {
          ((NotificationManager)paramContext.getSystemService("notification")).cancel(i);
        }
        str1 = this.a;
        localObject2 = new StringBuilder().append("2ymq, receive extented notification message: ").append(str2).append(";event:");
        if (PushReceiver.Event.NOTIFICATION_OPENED.equals(paramEvent))
        {
          localObject1 = PushReceiver.Event.NOTIFICATION_OPENED;
          u.i(str1, localObject1);
        }
      }
      else
      {
        super.onEvent(paramContext, paramEvent, paramBundle);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        localObject1 = PushReceiver.Event.NOTIFICATION_CLICK_BTN;
      }
    }
  }
  
  public boolean onPushMsg(Context paramContext, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    try
    {
      paramContext = "ymq, Receive a Push pass-by message： " + new String(paramArrayOfByte, "UTF-8");
      u.i(this.a, paramContext);
      return false;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void onPushState(Context paramContext, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ymq, The current push status： ");
      if (paramBoolean) {}
      for (paramContext = "Connected";; paramContext = "Disconnected")
      {
        paramContext = paramContext;
        u.i(this.a, paramContext);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onToken(Context paramContext, String paramString, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("belongId");
    localObject = "ymq, get token and belongId successful, token = " + paramString + ",beloId = " + (String)localObject;
    u.i(this.a, (String)localObject);
    localObject = paramBundle.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      u.i(this.a, str + " = " + paramBundle.get(str));
    }
    ApplicationEx.c.setHuaWeiToken(paramString);
    y.putString(paramContext, "huawei_token", paramString);
    EMClient.getInstance().sendHMSPushTokenToServer("10388799", paramString);
    paramBundle = createRegistBundle(paramString);
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processRegistration(paramContext, paramBundle);
    }
    if ((ApplicationEx.c.getUser() != null) && (!ae.isNull(ApplicationEx.c.getUser().getUid()))) {
      e.setAliasAndTags(paramContext, paramString, ah.toMd5(ApplicationEx.c.getUser().getUid().getBytes()), null);
    }
  }
  
  public void sendNotifyOpenBroadcast(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
    localIntent.putExtras(paramBundle);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/service/HuaWeiPushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */