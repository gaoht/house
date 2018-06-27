package com.pgyersdk.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.i.k;

public class c
{
  private static String a = "PGYER_APPID";
  
  public static void a(Context paramContext)
  {
    if (!k.a(com.pgyersdk.b.a.l)) {
      return;
    }
    String str;
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localObject == null) || (((ApplicationInfo)localObject).metaData == null))
      {
        localObject = Toast.makeText(paramContext, "App ID is not set", 0);
        if (!(localObject instanceof Toast))
        {
          ((Toast)localObject).show();
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      str = null;
    }
    for (;;)
    {
      com.pgyersdk.a.init(paramContext, str);
      return;
      VdsAgent.showToast((Toast)str);
      return;
      str = str.metaData.getString(a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */