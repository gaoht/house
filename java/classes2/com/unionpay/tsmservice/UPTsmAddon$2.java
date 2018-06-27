package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

final class UPTsmAddon$2
  implements ServiceConnection
{
  UPTsmAddon$2(UPTsmAddon paramUPTsmAddon) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      UPTsmAddon.a(this.a, true);
      UPTsmAddon.a(this.a, ITsmService.Stub.asInterface(paramIBinder));
      UPTsmAddon.a(this.a).sendEmptyMessage(0);
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      UPTsmAddon.a(this.a, false);
      UPTsmAddon.a(this.a, null);
      UPTsmAddon.a(this.a).sendEmptyMessage(1);
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/UPTsmAddon$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */