package com.hyphenate.chat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.hyphenate.util.EMLog;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class EMMipushReceiver
  extends PushMessageReceiver
{
  private static final String TAG = EMMipushReceiver.class.getSimpleName();
  
  public void onNotificationMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    super.onNotificationMessageClicked(paramContext, paramMiPushMessage);
    EMLog.d(TAG, "mi push onNotificationMessageClicked");
    paramMiPushMessage = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    paramMiPushMessage.addFlags(268435456);
    paramContext.startActivity(paramMiPushMessage);
  }
  
  public void onReceiveRegisterResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    super.onReceiveRegisterResult(paramContext, paramMiPushCommandMessage);
    if ("register".equals(paramMiPushCommandMessage.getCommand()))
    {
      paramContext = paramMiPushCommandMessage.getCommandArguments();
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        break label72;
      }
    }
    label72:
    for (paramContext = (String)paramContext.get(0); paramMiPushCommandMessage.getResultCode() == 0L; paramContext = null)
    {
      EMLog.d(TAG, "mi push reigster success");
      EMPushHelper.getInstance().onReceiveToken(paramContext);
      return;
    }
    EMLog.d(TAG, "mi push register fail");
    EMPushHelper.getInstance().onReceiveToken(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMMipushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */