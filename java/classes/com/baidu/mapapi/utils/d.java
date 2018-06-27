package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.a.a.a.a.a;
import com.baidu.a.a.a.c.a;

class d
  extends c.a
{
  d(c paramc) {}
  
  public void a(IBinder paramIBinder)
    throws RemoteException
  {
    Log.d(a.b(), "onClientReady");
    if (a.c() != null) {
      a.a(null);
    }
    a.a(a.a.a(paramIBinder));
    if (!a.f()) {
      a.a(a.a);
    }
    a.a(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */