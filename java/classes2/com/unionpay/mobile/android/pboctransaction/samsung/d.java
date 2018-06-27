package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.unionpay.client3.tsm.ITsmConnection.Stub;
import com.unionpay.mobile.android.utils.j;

final class d
  implements ServiceConnection
{
  d(b paramb) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    j.a("plugin-clientV3", "startSamsungService onServiceConnected");
    try
    {
      b.a(this.a, ITsmConnection.Stub.asInterface(paramIBinder));
      b.a(this.a).removeMessages(1);
      b.a(this.a, true);
      return;
    }
    catch (Exception paramComponentName)
    {
      b.a(this.a, false);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    j.a("plugin-clientV3", "startSamsungService onServiceDisconnected");
    b.a(this.a, null);
    b.a(this.a).removeMessages(1);
    b.a(this.a, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */