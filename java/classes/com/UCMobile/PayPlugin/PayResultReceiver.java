package com.UCMobile.PayPlugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PayResultReceiver
  extends BroadcastReceiver
{
  private static native void native_UCPayResultNotify(String paramString);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    native_UCPayResultNotify(paramIntent.getStringExtra("ResultURL"));
    paramIntent = paramContext.getPackageName();
    if (paramIntent.startsWith("com.UCMobile"))
    {
      Intent localIntent = new Intent("com.UCMobile.PluginApp.ActivityState");
      localIntent.putExtra("ActivityState", "inactive");
      localIntent.putExtra("PackageName", paramIntent);
      paramContext.sendBroadcast(localIntent);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/UCMobile/PayPlugin/PayResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */