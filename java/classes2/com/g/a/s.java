package com.g.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class s
  extends BroadcastReceiver
{
  BroadcastReceiver a;
  
  s(Object paramObject, Context paramContext) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a = this;
    paramContext = new t(this);
    paramContext.setName("t-scan");
    paramContext.start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */