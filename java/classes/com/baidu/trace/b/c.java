package com.baidu.trace.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.trace.c.e;

public final class c
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    int i;
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getAction();
      } while ((!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent)) && (!"com.baidu.trace.action.SOCKET_RECONNECT".equals(paramIntent)));
      paramIntent = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramIntent == null) || (!paramIntent.isConnected()) || (!paramIntent.isAvailable())) {
        break;
      }
      i = paramIntent.getType();
      if ((d.h()) && (e.b() - d.i() > 60L)) {
        d.a(false);
      }
    } while (((!d.a(i)) && (!d.a(paramContext))) || (d.h()));
    d.b(i);
    d.a(true);
    d.a(e.b());
    d.a().d();
    return;
    d.b(Integer.MIN_VALUE);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */