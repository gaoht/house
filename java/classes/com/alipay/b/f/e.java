package com.alipay.b.f;

import android.content.Context;
import org.json.JSONObject;

public final class e
{
  public static f a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = com.alipay.b.h.a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key");
    paramContext = (Context)localObject;
    if (com.alipay.c.a.a.a.a.a((String)localObject)) {
      paramContext = com.alipay.b.h.a.a("device_feature_file_name", "device_feature_file_key");
    }
    if (com.alipay.c.a.a.a.a.a(paramContext)) {
      return null;
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      localObject = new f();
      ((f)localObject).a = paramContext.getString("imei");
      ((f)localObject).b = paramContext.getString("imsi");
      ((f)localObject).c = paramContext.getString("mac");
      ((f)localObject).d = paramContext.getString("bluetoothmac");
      ((f)localObject).e = paramContext.getString("gsi");
      return (f)localObject;
    }
    catch (Exception paramContext)
    {
      com.alipay.b.c.a.a(paramContext);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/b/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */