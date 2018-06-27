package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class OpenClientUtil
{
  public static int getBaiduMapVersion(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
        if ((paramContext != null) && (paramContext.length() > 0))
        {
          int i = Integer.valueOf(paramContext.trim().replace(".", "").trim()).intValue();
          return i;
        }
      }
      catch (Exception paramContext) {}
    }
    return 0;
  }
  
  public static void getLatestBaiduMapApp(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    String str = a.b(paramContext);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("http://map.baidu.com/zt/client/index/?fr=sdk_[" + str + "]"));
    paramContext.startActivity(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/OpenClientUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */