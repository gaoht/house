package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuChatActivity;
import com.ziroom.ziroomcustomer.minsu.chat.b;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class j
{
  private static j a = null;
  private String b = "ChatHelper";
  private NotificationManager c;
  private Context d;
  private List<Activity> e = Collections.synchronizedList(new ArrayList());
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, Class paramClass)
  {
    u.i("huanxin", "minsu kefu  chathelper  001 ");
    this.c = ((NotificationManager)paramContext.getSystemService("notification"));
    paramClass = PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, paramClass), 134217728);
    paramContext = new Notification.Builder(paramContext).setAutoCancel(true).setTicker(paramString1).setSmallIcon(2130839951).setContentTitle(paramString2).setContentText(paramString3).setDefaults(-1).setWhen(System.currentTimeMillis()).setContentIntent(paramClass).getNotification();
    this.c.notify(291, paramContext);
  }
  
  public static j getInstance()
  {
    try
    {
      if (a == null) {
        a = new j();
      }
      j localj = a;
      return localj;
    }
    finally {}
  }
  
  public void clearAll()
  {
    this.e.clear();
  }
  
  public String getAppName(int paramInt, Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return "";
    }
    paramContext = paramContext.iterator();
    for (;;)
    {
      Object localObject;
      if (paramContext.hasNext()) {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      }
      try
      {
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid != paramInt) {
          continue;
        }
        localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        return (String)localObject;
      }
      catch (Exception localException) {}
      return null;
    }
  }
  
  public void getChatNewMsg(Context paramContext, String paramString1, String paramString2)
  {
    EMMessage localEMMessage = EMClient.getInstance().chatManager().getMessage(paramString1);
    u.e("huanxin", "chatHelper--------MyMessageReceiver ----getChatNewMsg----------- " + localEMMessage);
    if ("ziroomerPro".equals(paramString2))
    {
      if (localEMMessage.getType() == EMMessage.Type.TXT)
      {
        a(paramContext, "您有一条信息", "自如客服", ((EMTextMessageBody)localEMMessage.getBody()).getMessage(), ChatNewActivity.class);
        EMConversation localEMConversation = EMClient.getInstance().chatManager().getConversation("ziroomerPro");
        u.e("chatHelper", localEMConversation.getUnreadMsgCount() + "");
        ApplicationEx.c.setUnReadNum(localEMConversation.getUnreadMsgCount());
      }
    }
    else if ("ms_ziroom".equalsIgnoreCase(paramString2))
    {
      u.i("huanxin", "minsu kefu  自如客服发通知 = " + paramString2);
      if (!"TXT".equals(localEMMessage.getType())) {
        break label401;
      }
      a(paramContext, "您有一条信息", "民宿客服", ((EMTextMessageBody)localEMMessage.getBody()).getMessage(), MinsuChatActivity.class);
    }
    for (;;)
    {
      paramContext = EMClient.getInstance().chatManager().getConversation("ms_ziroom");
      u.e("chatHelper---------MyMessageReceiver", paramContext.getUnreadMsgCount() + "");
      ApplicationEx.c.setMisuNum(paramContext.getUnreadMsgCount());
      paramContext = localEMMessage.getStringAttribute("ziroomFlag", "");
      if (("ZIROOM_MINSU_IM".equals(paramContext)) && (!com.ziroom.ziroomcustomer.minsu.chat.j.hasForegroundActivies()) && (!"3".equals(localEMMessage.getStringAttribute("msgType", ""))))
      {
        u.i("wz_xiaomi", "chathelper  msg id 222 ---= " + paramString1);
        ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
      }
      if (("ZIROOM_ZRY_IM".equals(paramContext)) && (!com.ziroom.ziroomcustomer.minsu.chat.j.hasForegroundActivies()) && (!"3".equals(localEMMessage.getStringAttribute("msgType", "")))) {
        ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
      }
      return;
      a(paramContext, "您有一条信息", "自如客服", "您有一条信息", ChatNewActivity.class);
      break;
      label401:
      a(paramContext, "您有一条信息", "民宿客服", "您有一条信息", MinsuChatActivity.class);
    }
  }
  
  public int getImActivitySize()
  {
    return this.e.size();
  }
  
  public boolean hasActivity()
  {
    Object localObject2 = new StringBuilder().append(" hasActivity ");
    if (this.e == null) {}
    for (Object localObject1 = " list nul ";; localObject1 = " size = " + this.e.size())
    {
      u.i("huanxin", (String)localObject1);
      if ((this.e == null) || (this.e.size() <= 0)) {
        break label154;
      }
      localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Activity)((Iterator)localObject1).next();
        u.i("huanxin", " activity List = " + localObject2.getClass().getSimpleName());
      }
    }
    return true;
    label154:
    return false;
  }
  
  public void init(Context paramContext)
  {
    this.d = paramContext;
    Object localObject = getAppName(Process.myPid(), paramContext);
    if ((localObject == null) || (!((String)localObject).equalsIgnoreCase(paramContext.getPackageName())))
    {
      u.e(this.b, "enter the service process!");
      return;
    }
    localObject = new EMOptions();
    ((EMOptions)localObject).setAcceptInvitationAlways(false);
    ((EMOptions)localObject).setRequireAck(true);
    ((EMOptions)localObject).setRequireDeliveryAck(false);
    EMClient.getInstance().init(paramContext, (EMOptions)localObject);
    EMClient.getInstance().setDebugMode(false);
  }
  
  public void popActivity(Activity paramActivity)
  {
    this.e.remove(paramActivity);
    paramActivity = this.e.iterator();
    while (paramActivity.hasNext())
    {
      Activity localActivity = (Activity)paramActivity.next();
      u.i("huanxin", "popActivity List = " + localActivity.getClass().getSimpleName());
    }
  }
  
  public void pushActivity(Activity paramActivity)
  {
    this.e.clear();
    if (!this.e.contains(paramActivity)) {
      this.e.add(0, paramActivity);
    }
    paramActivity = this.e.iterator();
    while (paramActivity.hasNext())
    {
      Activity localActivity = (Activity)paramActivity.next();
      u.i("huanxin", " pushActivity List = " + localActivity.getClass().getSimpleName());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */