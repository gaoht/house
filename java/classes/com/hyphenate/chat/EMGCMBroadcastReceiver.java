package com.hyphenate.chat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.hyphenate.util.EMLog;

@Deprecated
public class EMGCMBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  private String TAG = "EMGCMBroadcastReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    EMLog.d(this.TAG, "gcm broadcastreceive!");
    try
    {
      if (paramIntent.getExtras().getString("alert") == null) {
        return;
      }
      startWakefulService(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), EMGCMListenerService.class.getName())));
      setResultCode(-1);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMGCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */