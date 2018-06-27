package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.a.a.a.a.a.a.a.a.a.a;

final class b
  implements ServiceConnection
{
  b(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      a.a(this.a, a.a.a(paramIBinder));
      if (a.a(this.a) != null) {
        a.a(this.a).a();
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      while (a.a(this.a) == null) {}
      a.a(this.a).b();
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.a(this.a, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/icfcc/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */