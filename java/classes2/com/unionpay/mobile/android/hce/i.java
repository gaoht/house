package com.unionpay.mobile.android.hce;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.a.a;
import com.unionpay.mobile.android.utils.j;
import java.util.concurrent.ConcurrentHashMap;

final class i
  implements ServiceConnection
{
  i(f paramf, String paramString1, String paramString2) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    String str = null;
    paramComponentName = null;
    f.d(this.c).removeMessages(2006, this.a);
    try
    {
      locala = a.a.a(paramIBinder);
      if (locala != null) {
        paramIBinder = str;
      }
      try
      {
        str = locala.a(f.f(this.c), f.g(this.c), new b(2003, this.a, f.d(this.c)));
        paramComponentName = str;
        paramIBinder = str;
        Message localMessage = f.d(this.c).obtainMessage(2006, this.a);
        paramComponentName = str;
        paramIBinder = str;
        f.d(this.c).sendMessageDelayed(localMessage, f.e(this.c));
        paramComponentName = str;
      }
      catch (RemoteException paramIBinder)
      {
        for (;;)
        {
          paramIBinder.printStackTrace();
        }
      }
      catch (Exception paramComponentName)
      {
        for (;;)
        {
          paramComponentName = paramIBinder;
        }
      }
      if (paramComponentName != null)
      {
        j.a("uppay-hce", "session Key: " + paramComponentName);
        j.a("uppay-hce", "3des key: " + this.b);
        str = a.a(paramComponentName, this.b);
        j.a("uppay-hce", this.a + " sessionkey after: " + str);
        paramIBinder = (l)f.c(this.c).get(this.a);
        paramComponentName = paramIBinder;
        if (paramIBinder == null) {
          paramComponentName = new l(this.a);
        }
        paramComponentName.a(str);
        paramComponentName.a(locala);
        paramComponentName.d();
        f.c(this.c).put(this.a, paramComponentName);
        paramComponentName = f.d(this.c).obtainMessage(2002, this.a);
        f.d(this.c).sendMessage(paramComponentName);
      }
      return;
    }
    catch (Exception paramIBinder)
    {
      for (;;)
      {
        paramIBinder.printStackTrace();
        com.unionpay.mobile.android.hce.service.a locala = null;
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    f.d(this.c).removeMessages(2006, this.a);
    paramComponentName = f.d(this.c).obtainMessage(2005, this.a);
    f.d(this.c).sendMessage(paramComponentName);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */