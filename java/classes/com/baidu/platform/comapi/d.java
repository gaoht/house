package com.baidu.platform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.platform.comapi.util.c;
import com.baidu.platform.comapi.util.f;

public class d
  extends BroadcastReceiver
{
  public static final String a = d.class.getSimpleName();
  
  public void a(Context paramContext)
  {
    paramContext = c.c(paramContext);
    if (!f.d().equals(paramContext)) {
      f.a(paramContext);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext);
    c.a(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */