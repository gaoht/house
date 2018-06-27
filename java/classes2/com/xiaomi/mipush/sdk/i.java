package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

final class i
  implements Runnable
{
  i(Context paramContext) {}
  
  public void run()
  {
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4612);
      h.b(this.a);
      h.a(this.a, localPackageInfo);
      h.b(this.a, localPackageInfo);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ManifestChecker", "", localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */