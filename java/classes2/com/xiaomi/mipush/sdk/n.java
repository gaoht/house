package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

final class n
  implements Runnable
{
  n(String[] paramArrayOfString, Context paramContext) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = this.a;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          Object localObject = arrayOfString[i];
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label69;
          }
          localObject = this.b.getPackageManager().getPackageInfo((String)localObject, 4);
          if (localObject == null) {
            break label69;
          }
          MiPushClient.access$100(this.b, (PackageInfo)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        b.a(localThrowable);
      }
      return;
      label69:
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */