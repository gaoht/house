package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.q;
import com.xiaomi.xmpush.thrift.r;
import java.util.List;

public class PushMessageHelper
{
  private static int pushMode = 0;
  
  public static MiPushCommandMessage generateCommandMessage(String paramString1, List<String> paramList, long paramLong, String paramString2, String paramString3)
  {
    MiPushCommandMessage localMiPushCommandMessage = new MiPushCommandMessage();
    localMiPushCommandMessage.setCommand(paramString1);
    localMiPushCommandMessage.setCommandArguments(paramList);
    localMiPushCommandMessage.setResultCode(paramLong);
    localMiPushCommandMessage.setReason(paramString2);
    localMiPushCommandMessage.setCategory(paramString3);
    return localMiPushCommandMessage;
  }
  
  public static MiPushMessage generateMessage(aj paramaj, r paramr, boolean paramBoolean)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    localMiPushMessage.setMessageId(paramaj.c());
    if (!TextUtils.isEmpty(paramaj.j()))
    {
      localMiPushMessage.setMessageType(1);
      localMiPushMessage.setAlias(paramaj.j());
    }
    for (;;)
    {
      localMiPushMessage.setCategory(paramaj.p());
      if (paramaj.l() != null) {
        localMiPushMessage.setContent(paramaj.l().f());
      }
      if (paramr != null)
      {
        if (TextUtils.isEmpty(localMiPushMessage.getMessageId())) {
          localMiPushMessage.setMessageId(paramr.b());
        }
        if (TextUtils.isEmpty(localMiPushMessage.getTopic())) {
          localMiPushMessage.setTopic(paramr.f());
        }
        localMiPushMessage.setDescription(paramr.j());
        localMiPushMessage.setTitle(paramr.h());
        localMiPushMessage.setNotifyType(paramr.l());
        localMiPushMessage.setNotifyId(paramr.q());
        localMiPushMessage.setPassThrough(paramr.o());
        localMiPushMessage.setExtra(paramr.s());
      }
      localMiPushMessage.setNotified(paramBoolean);
      return localMiPushMessage;
      if (!TextUtils.isEmpty(paramaj.h()))
      {
        localMiPushMessage.setMessageType(2);
        localMiPushMessage.setTopic(paramaj.h());
      }
      else if (!TextUtils.isEmpty(paramaj.r()))
      {
        localMiPushMessage.setMessageType(3);
        localMiPushMessage.setUserAccount(paramaj.r());
      }
      else
      {
        localMiPushMessage.setMessageType(0);
      }
    }
  }
  
  public static int getPushMode(Context paramContext)
  {
    if (pushMode == 0)
    {
      if (!isUseCallbackPushMode(paramContext)) {
        break label21;
      }
      setPushMode(1);
    }
    for (;;)
    {
      return pushMode;
      label21:
      setPushMode(2);
    }
  }
  
  private static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.queryBroadcastReceivers(paramIntent, 32);
      if (paramContext != null)
      {
        boolean bool = paramContext.isEmpty();
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static boolean isUseCallbackPushMode(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setClassName(paramContext.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
    return isIntentAvailable(paramContext, localIntent);
  }
  
  public static void sendCommandMessageBroadcast(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 3);
    localIntent.putExtra("key_command", paramMiPushCommandMessage);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }
  
  public static void sendQuitMessageBroadcast(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 4);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }
  
  private static void setPushMode(int paramInt)
  {
    pushMode = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/PushMessageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */