package com.growingio.android.sdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Pair;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b
  extends AsyncTask<Void, Void, Pair<Integer, byte[]>>
{
  @TargetApi(9)
  private String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(String.format(Locale.US, "api=%s&%s&%s&%s", new Object[] { paramString1, paramString3, paramString4, paramString2 }).getBytes(Charset.forName("UTF-8")));
      paramString1 = new BigInteger(1, localMessageDigest.digest()).toString(16);
      if (paramString1.length() >= 40) {
        return paramString1;
      }
      paramString2 = new StringBuilder(40);
      int i = 40 - paramString1.length();
      while (i > 0)
      {
        paramString2.append("0");
        i -= 1;
      }
      paramString1 = paramString1;
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected Pair<Integer, byte[]> a(Void... paramVarArgs)
  {
    Object localObject1 = AppState.l();
    GConfig localGConfig = GConfig.s();
    if (localObject1 == null) {
      return null;
    }
    String str1 = String.format(Locale.US, "/products/%s/android/%s/settings", new Object[] { ((AppState)localObject1).c(), ((AppState)localObject1).b() });
    String str2 = "timestamp=" + System.currentTimeMillis();
    paramVarArgs = "";
    try
    {
      localObject1 = ((AppState)localObject1).k().getPackageManager().getPackageInfo(((AppState)localObject1).b(), 0).versionName;
      paramVarArgs = (Void[])localObject1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        LogUtil.d(localThrowable1);
      }
      localHashMap = new HashMap(1);
      localHashMap.put("If-None-Match", localGConfig.w());
      localObject2 = new HttpService.Builder().a(localHashMap).a(String.format(Locale.US, "%s%s?%s&%s&%s&sign=%s", new Object[] { NetworkConfig.a().f(), str1, paramVarArgs, "cv=1.1.2_dcb91e54", str2, localThrowable1 })).a();
      paramVarArgs = ((HttpService)localObject2).b();
    }
    paramVarArgs = "av=" + paramVarArgs;
    localObject1 = a(str1, str2, paramVarArgs, "cv=1.1.2_dcb91e54");
    if (localObject1 == null) {
      return null;
    }
    try
    {
      HashMap localHashMap;
      Object localObject2 = ((HttpService)localObject2).a();
      if (((Integer)paramVarArgs.first).intValue() == 200)
      {
        localGConfig.c(new String((byte[])paramVarArgs.second));
        if ((localObject2 != null) && (((Map)localObject2).containsKey("ETag")))
        {
          localObject2 = (List)((Map)localObject2).get("ETag");
          if (((List)localObject2).size() > 0) {
            localGConfig.b((String)((List)localObject2).get(0));
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        LogUtil.d(localThrowable2);
      }
    }
    return paramVarArgs;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */