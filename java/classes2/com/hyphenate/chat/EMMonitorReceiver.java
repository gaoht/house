package com.hyphenate.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.hyphenate.chat.core.EMMonitorDB;
import com.hyphenate.util.EMLog;

public class EMMonitorReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction()))
    {
      if (paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
        return;
      }
      EMLog.d("EMMonitorReceiver", paramIntent.getData().getSchemeSpecificPart() + " be removed");
      EMMonitor.getInstance().getMonitorDB().b(paramIntent.getData().getSchemeSpecificPart());
      return;
    }
    paramContext.startService(new Intent(paramContext, EMChatService.class));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMMonitorReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */