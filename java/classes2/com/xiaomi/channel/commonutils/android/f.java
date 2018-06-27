package com.xiaomi.channel.commonutils.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.b;

public class f
{
  public static Account a(Context paramContext)
  {
    try
    {
      if (!b(paramContext)) {
        return null;
      }
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.xiaomi");
      if ((paramContext != null) && (paramContext.length > 0))
      {
        paramContext = paramContext[0];
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      b.d(paramContext.toString());
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.GET_ACCOUNTS", paramContext.getPackageName()) == 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */