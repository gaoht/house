package com.baidu.trace;

import android.content.Context;
import com.baidu.trace.c.e;

final class au
  implements Runnable
{
  au(ar paramar, Context paramContext) {}
  
  public final void run()
  {
    if (ar.a(this.b) == null) {
      ar.a(this.b, new ak(this.a));
    }
    if (e.e(this.a)) {
      ar.a(this.b).a(2000);
    }
    do
    {
      return;
      a.a("BaiduTraceSDK", "Need ACCESS_FINE_LOCATION permission to get gps information");
      this.b.d();
    } while (3 == ak.a);
    ar.a(this.b).a(3, "未授予GPS定位所需权限");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */