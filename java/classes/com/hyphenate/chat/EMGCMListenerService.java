package com.hyphenate.chat;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

@Deprecated
@SuppressLint({"Registered"})
public class EMGCMListenerService
  extends IntentService
{
  public static final String TAG = "EMGcmListenerService";
  
  public EMGCMListenerService()
  {
    super("EMGcmListenerService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.hyphenate.sdk.push");
    localIntent.addCategory(EMClient.getInstance().getContext().getPackageName());
    localIntent.putExtra("alert", paramIntent.getExtras().getString("alert"));
    sendBroadcast(localIntent);
    EMGCMBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMGCMListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */