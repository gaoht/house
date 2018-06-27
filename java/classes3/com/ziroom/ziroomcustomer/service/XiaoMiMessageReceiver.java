package com.ziroom.ziroomcustomer.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hyphenate.chat.EMMipushReceiver;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuMiPushMessage;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class XiaoMiMessageReceiver
  extends EMMipushReceiver
{
  private String TAG = "XiaoMiMessageReceiver";
  private String mContent;
  private String mExtra;
  private String mTitle;
  private String miContent;
  
  private boolean checkim()
  {
    if (isIM())
    {
      MinsuMiPushMessage localMinsuMiPushMessage = new MinsuMiPushMessage();
      localMinsuMiPushMessage.setContent(this.mContent);
      localMinsuMiPushMessage.setTitle(this.mTitle);
      localMinsuMiPushMessage.setExtra(this.mExtra);
      com.ziroom.ziroomcustomer.minsu.d.e.putOfflinePushMsg(localMinsuMiPushMessage);
      com.ziroom.ziroomcustomer.minsu.d.e.putOfflineMsgId(com.alibaba.fastjson.e.parseObject(this.mExtra).getString("m"));
      return true;
    }
    return false;
  }
  
  private boolean isIM()
  {
    if (TextUtils.isEmpty(this.mExtra)) {}
    Object localObject;
    String str;
    do
    {
      return false;
      localObject = com.alibaba.fastjson.e.parseObject(this.mExtra);
      str = ((com.alibaba.fastjson.e)localObject).getString("f");
      localObject = ((com.alibaba.fastjson.e)localObject).getString("t");
    } while ((str == null) || (!str.contains("app_")) || (localObject == null) || (!((String)localObject).contains("app_")));
    return true;
  }
  
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
  
  public void onCommandResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    super.onCommandResult(paramContext, paramMiPushCommandMessage);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " m  = " + paramMiPushCommandMessage);
    String str = paramMiPushCommandMessage.getCommand();
    List localList = paramMiPushCommandMessage.getCommandArguments();
    if (("register".equals(str)) && (paramMiPushCommandMessage.getResultCode() == 0L))
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " mRegID  = " + (String)localList.get(0));
      Bundle localBundle = createRegistBundle((String)localList.get(0));
      if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
        com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processRegistration(paramContext, localBundle);
      }
    }
    if (("set-alias".equals(str)) && (paramMiPushCommandMessage.getResultCode() == 0L)) {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " mAlias  = " + (String)localList.get(0));
    }
    if (("set-account".equals(str)) && (paramMiPushCommandMessage.getResultCode() == 0L)) {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " mAccount  = " + (String)localList.get(0));
    }
    if (("subscribe-topic".equals(str)) && (paramMiPushCommandMessage.getResultCode() == 0L)) {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " mTopic  = " + (String)localList.get(0));
    }
  }
  
  public void onNotificationMessageArrived(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    this.miContent = paramMiPushMessage.getContent();
    u.i(this.TAG, "收到了小米推送的通知mTitle:" + this.mTitle + ";mContent:" + this.mContent + ";mExtra:" + this.mExtra);
    printMessage(paramMiPushMessage);
  }
  
  public void onNotificationMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onNotificationMessageClicked(paramContext, paramMiPushMessage);
    this.miContent = paramMiPushMessage.getContent();
    printMessage(paramMiPushMessage);
    this.mTitle = paramMiPushMessage.getTitle();
    this.mContent = paramMiPushMessage.getDescription();
    this.mExtra = paramMiPushMessage.getContent();
    u.i(this.TAG, "用户点击了小米推送的通知mTitle:" + this.mTitle + ";mContent:" + this.mContent + ";mExtra:" + this.mExtra);
    if (checkim()) {
      return;
    }
    paramMiPushMessage = createBundle(this.mTitle, this.mContent, this.mExtra);
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null)
    {
      u.i(this.TAG, "用户点击小米  : 保存");
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().saveMessage(paramContext, paramMiPushMessage);
    }
    sendNotifyOpenBroadcast(paramContext, paramMiPushMessage);
    int i = Process.myPid();
    paramContext = ah.getAppName(paramContext, i);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", " app  pid = " + i + " app name = " + paramContext);
  }
  
  public void onReceiveMessage(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onReceiveMessage(paramContext, paramMiPushMessage);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " m = " + paramMiPushMessage);
  }
  
  public void onReceivePassThroughMessage(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    this.miContent = paramMiPushMessage.getContent();
    Object localObject = com.alibaba.fastjson.e.parseObject(this.miContent);
    this.mTitle = ((com.alibaba.fastjson.e)localObject).getString("msg_title");
    this.mContent = ((com.alibaba.fastjson.e)localObject).getString("msg_content");
    this.mExtra = ((com.alibaba.fastjson.e)localObject).getString("msg_extra");
    localObject = createBundle(this.mTitle, this.mContent, this.mExtra);
    u.i(this.TAG, "收到小米推送的透传消息mTitle:" + this.mTitle + ";mContent:" + this.mContent + ";mExtra:" + this.mExtra);
    int i = Process.myPid();
    String str = ah.getAppName(paramContext, i);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", " app  pid = " + i + " app name = " + str);
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processCustomMessage(paramContext, (Bundle)localObject);
    }
    printMessage(paramMiPushMessage);
  }
  
  public void onReceiveRegisterResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    super.onReceiveRegisterResult(paramContext, paramMiPushCommandMessage);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.TAG, " m  = " + paramMiPushCommandMessage);
  }
  
  public void printMessage(MiPushMessage paramMiPushMessage)
  {
    String str1 = paramMiPushMessage.getAlias();
    String str2 = paramMiPushMessage.getCategory();
    String str3 = paramMiPushMessage.getContent();
    String str4 = paramMiPushMessage.getDescription();
    String str5 = com.alibaba.fastjson.a.toJSONString(paramMiPushMessage.getExtra(), new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
    String str6 = paramMiPushMessage.getMessageId();
    int i = paramMiPushMessage.getMessageType();
    int j = paramMiPushMessage.getNotifyId();
    int k = paramMiPushMessage.getNotifyType();
    int m = paramMiPushMessage.getPassThrough();
    String str7 = paramMiPushMessage.getTitle();
    String str8 = paramMiPushMessage.getTopic();
    paramMiPushMessage = paramMiPushMessage.getUserAccount();
    u.i(this.TAG, "小米推送: alias:" + str1 + ";category:" + str2 + ";content:" + str3 + ";desc:" + str4 + ";extra:" + str5 + ";messageId:" + str6 + ";messageType:" + i + ";notifyId:" + j + ";notifyType:" + k + ";passThrough:" + m + ";title:" + str7 + ";topic:" + str8 + ";userAcount:" + paramMiPushMessage);
  }
  
  public void sendNotifyOpenBroadcast(Context paramContext, Bundle paramBundle)
  {
    u.i("wz_xiaomi", "sendNotifyOpenBroadcast -------------");
    Intent localIntent = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
    localIntent.putExtras(paramBundle);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/service/XiaoMiMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */