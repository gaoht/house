package com.huawei.hms.support.api.push.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.a.b;

public abstract class c
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = str;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (TextUtils.isEmpty(paramString2)) {
        continue;
      }
      try
      {
        localObject = paramString2 + "_v2";
        paramContext = com.huawei.hms.support.api.push.a.a.a.d.b(paramContext, new d(paramContext, paramString1).b((String)localObject));
        localObject = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          continue;
        }
        localObject = paramContext;
        if (!b.b()) {
          continue;
        }
        b.a("PushDataEncrypterManager", "not exist for:" + paramString2);
        return paramContext;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramContext = str;
          if (b.e())
          {
            b.d("PushDataEncrypterManager", "getSecureData" + paramString1.getMessage());
            paramContext = str;
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    paramString2 = paramString2 + "_v2";
    paramString3 = com.huawei.hms.support.api.push.a.a.a.d.a(paramContext, paramString3);
    return new d(paramContext, paramString1).a(paramString2, paramString3);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString2));
      try
      {
        paramString2 = paramString2 + "_v2";
        new d(paramContext, paramString1).d(paramString2);
        return;
      }
      catch (Exception paramContext) {}
    } while (!b.e());
    b.d("PushDataEncrypterManager", "removeSecureData" + paramContext.getMessage());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */