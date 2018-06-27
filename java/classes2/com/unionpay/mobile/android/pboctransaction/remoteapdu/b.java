package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
import com.unionpay.mobile.tsm.connect.IRemoteApdu.Stub;

final class b
  implements ServiceConnection
{
  b(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    j.a("plugin-tsm", "mConnection.onServiceConnected()");
    try
    {
      a.a(this.a, IRemoteApdu.Stub.asInterface(paramIBinder));
      a.b(this.a).registerCallback(a.a(this.a));
      a.b(this.a).init();
      return;
    }
    catch (Exception paramComponentName)
    {
      while (this.a.a == null) {}
      this.a.a.b();
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    j.a("plugin-tsm", "mConnection.onServiceDisconnected()");
    a.a(this.a, null);
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/remoteapdu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */