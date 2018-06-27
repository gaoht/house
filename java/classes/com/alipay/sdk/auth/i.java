package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.alipay.sdk.c.c;
import com.alipay.sdk.h.b;

public final class i
{
  private static com.alipay.sdk.k.a a = null;
  private static String b = null;
  
  public static void a(Activity paramActivity, a parama)
  {
    Object localObject = b.a();
    c.a();
    ((b)localObject).a(paramActivity);
    if (a(paramActivity))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("alipayauth://platformapi/startapp");
      ((StringBuilder)localObject).append("?appId=20000122");
      ((StringBuilder)localObject).append("&approveType=005");
      ((StringBuilder)localObject).append("&scope=kuaijie");
      ((StringBuilder)localObject).append("&productId=");
      ((StringBuilder)localObject).append(parama.getProductId());
      ((StringBuilder)localObject).append("&thirdpartyId=");
      ((StringBuilder)localObject).append(parama.getAppId());
      ((StringBuilder)localObject).append("&redirectUri=");
      ((StringBuilder)localObject).append(parama.getRedirectUri());
      a(paramActivity, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        localObject = new com.alipay.sdk.k.a(paramActivity, "正在加载");
        a = (com.alipay.sdk.k.a)localObject;
        ((com.alipay.sdk.k.a)localObject).a();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app_id=");
      ((StringBuilder)localObject).append(parama.getAppId());
      ((StringBuilder)localObject).append("&partner=");
      ((StringBuilder)localObject).append(parama.getPid());
      ((StringBuilder)localObject).append("&scope=kuaijie");
      ((StringBuilder)localObject).append("&login_goal=auth");
      ((StringBuilder)localObject).append("&redirect_url=");
      ((StringBuilder)localObject).append(parama.getRedirectUri());
      ((StringBuilder)localObject).append("&view=wap");
      ((StringBuilder)localObject).append("&prod_code=");
      ((StringBuilder)localObject).append(parama.getProductId());
      new Thread(new j(paramActivity, (StringBuilder)localObject, parama)).start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = null;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramActivity) {}
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.versionCode;
      if (i >= 65) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */