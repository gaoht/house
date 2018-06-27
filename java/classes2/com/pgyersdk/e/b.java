package com.pgyersdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("level", 0);
      int j = paramIntent.getIntExtra("scale", 100);
      a.a = i * 100 / j + "%";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */