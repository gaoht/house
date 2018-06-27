package com.xiaomi.channel.commonutils.misc;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class e
{
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (paramContext == null) {}
    int i;
    do
    {
      return false;
      i = paramContext.getIntExtra("status", -1);
    } while ((i != 2) && (i != 5));
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */