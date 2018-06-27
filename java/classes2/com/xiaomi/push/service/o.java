package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.misc.a;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class o
{
  private static n a;
  private static a b;
  
  public static n a(Context paramContext)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        if (a != null)
        {
          localObject1 = a;
          return (n)localObject1;
        }
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_account", 0);
        String str1 = localSharedPreferences.getString("uuid", null);
        String str2 = localSharedPreferences.getString("token", null);
        String str3 = localSharedPreferences.getString("security", null);
        String str4 = localSharedPreferences.getString("app_id", null);
        String str5 = localSharedPreferences.getString("app_token", null);
        String str6 = localSharedPreferences.getString("package_name", null);
        localObject1 = localSharedPreferences.getString("device_id", null);
        int i = localSharedPreferences.getInt("env_type", 1);
        Object localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (((String)localObject1).startsWith("a-"))
          {
            localObject2 = e.e(paramContext);
            localSharedPreferences.edit().putString("device_id", (String)localObject2).commit();
          }
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty(str3)) {
          continue;
        }
        localObject1 = e.e(paramContext);
        if ((!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1)))
        {
          com.xiaomi.channel.commonutils.logger.b.d("erase the old account.");
          b(paramContext);
          localObject1 = localObject3;
          continue;
        }
        a = new n(str1, str2, str3, str4, str5, str6, i);
      }
      finally {}
      Object localObject1 = a;
    }
  }
  
  public static n a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        Object localObject2 = new TreeMap();
        ((Map)localObject2).put("devid", e.a(paramContext));
        if (c(paramContext))
        {
          paramString2 = "1000271";
          if (!c(paramContext)) {
            continue;
          }
          paramString3 = "420100086271";
          if (!c(paramContext)) {
            continue;
          }
          paramString1 = "com.xiaomi.xmsf";
          ((Map)localObject2).put("appid", paramString2);
          ((Map)localObject2).put("apptoken", paramString3);
        }
        try
        {
          Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramString1, 16384);
          if (localObject1 != null)
          {
            localObject1 = String.valueOf(((PackageInfo)localObject1).versionCode);
            ((Map)localObject2).put("appversion", localObject1);
            ((Map)localObject2).put("sdkversion", Integer.toString(26));
            ((Map)localObject2).put("packagename", paramString1);
            ((Map)localObject2).put("model", Build.MODEL);
            ((Map)localObject2).put("imei_md5", com.xiaomi.channel.commonutils.string.d.a(e.c(paramContext)));
            ((Map)localObject2).put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            int i = e.b();
            if (i >= 0) {
              ((Map)localObject2).put("space_id", Integer.toString(i));
            }
            localObject1 = com.xiaomi.channel.commonutils.string.d.a(e.g(paramContext));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((Map)localObject2).put("mac_address", localObject1);
            }
            ((Map)localObject2).put("android_id", e.b(paramContext));
            localObject2 = com.xiaomi.channel.commonutils.network.d.a(paramContext, a(), (Map)localObject2);
            localObject1 = "";
            if (localObject2 != null) {
              localObject1 = ((com.xiaomi.channel.commonutils.network.b)localObject2).a();
            }
            localObject2 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new JSONObject((String)localObject1);
              if (((JSONObject)localObject2).getInt("code") == 0)
              {
                localObject3 = ((JSONObject)localObject2).getJSONObject("data");
                localObject1 = ((JSONObject)localObject3).getString("ssecurity");
                localObject2 = ((JSONObject)localObject3).getString("token");
                localObject3 = ((JSONObject)localObject3).getString("userId");
                localObject2 = new n((String)localObject3 + "@xiaomi.com/an" + com.xiaomi.channel.commonutils.string.d.a(6), (String)localObject2, (String)localObject1, paramString2, paramString3, paramString1, a.c());
                a(paramContext, (n)localObject2);
                a = (n)localObject2;
              }
            }
            else
            {
              return (n)localObject2;
              continue;
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          com.xiaomi.channel.commonutils.logger.b.a(localException);
          str = null;
          continue;
          r.a(paramContext, ((JSONObject)localObject2).getInt("code"), ((JSONObject)localObject2).optString("description"));
          com.xiaomi.channel.commonutils.logger.b.a(str);
          localObject2 = localObject3;
          continue;
        }
        String str = "0";
      }
      finally {}
    }
  }
  
  public static String a()
  {
    if (a.b()) {
      return "http://" + com.xiaomi.smack.b.c + ":9085/pass/register";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("https://");
    if (a.a()) {}
    for (String str = "sandbox.xmpush.xiaomi.com";; str = "register.xmpush.xiaomi.com") {
      return str + "/pass/register";
    }
  }
  
  public static void a(Context paramContext, n paramn)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("mipush_account", 0).edit();
    localEditor.putString("uuid", paramn.a);
    localEditor.putString("security", paramn.c);
    localEditor.putString("token", paramn.b);
    localEditor.putString("app_id", paramn.d);
    localEditor.putString("package_name", paramn.f);
    localEditor.putString("app_token", paramn.e);
    localEditor.putString("device_id", e.e(paramContext));
    localEditor.putInt("env_type", paramn.g);
    localEditor.commit();
    b();
  }
  
  public static void b()
  {
    if (b != null) {
      b.a();
    }
  }
  
  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_account", 0).edit().clear().commit();
    a = null;
    b();
  }
  
  private static boolean c(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */