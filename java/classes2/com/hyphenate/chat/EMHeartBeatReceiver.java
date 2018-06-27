package com.hyphenate.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hyphenate.util.EMLog;

class EMHeartBeatReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "EMHeartBeatReceiver";
  EMSmartHeartBeat smartHeartbeat = null;
  
  public EMHeartBeatReceiver(EMSmartHeartBeat paramEMSmartHeartBeat)
  {
    this.smartHeartbeat = paramEMSmartHeartBeat;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    EMLog.d("EMHeartBeatReceiver", "onReceive EMHeartBeatReceiver");
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        if (EMHeartBeatReceiver.this.smartHeartbeat != null) {
          EMHeartBeatReceiver.this.smartHeartbeat.start();
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMHeartBeatReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */