package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.j.e;
import com.alipay.sdk.j.k;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class AuthTask
{
  static final Object a = e.class;
  private Activity b;
  private com.alipay.sdk.k.a c;
  
  public AuthTask(Activity paramActivity)
  {
    this.b = paramActivity;
    com.alipay.sdk.h.b localb = com.alipay.sdk.h.b.a();
    Activity localActivity = this.b;
    c.a();
    localb.a(localActivity);
    com.alipay.sdk.app.a.a.a(paramActivity);
    this.c = new com.alipay.sdk.k.a(paramActivity, "去支付宝授权");
  }
  
  private String a(Activity paramActivity, String paramString)
  {
    a();
    try
    {
      paramActivity = com.alipay.sdk.g.b.a(new com.alipay.sdk.f.a.a().a(paramActivity, paramString).a().optJSONObject("form").optJSONObject("onload"));
      b();
      int i = 0;
      while (i < paramActivity.size())
      {
        if (((com.alipay.sdk.g.b)paramActivity.get(i)).a == com.alipay.sdk.g.a.b)
        {
          paramActivity = a((com.alipay.sdk.g.b)paramActivity.get(i));
          return paramActivity;
        }
        i += 1;
      }
      b();
      paramActivity = null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramActivity = j.a(j.d.h);
        com.alipay.sdk.app.a.a.a("net", paramString);
        b();
      }
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        com.alipay.sdk.app.a.a.a("biz", "H5AuthDataAnalysisError", paramActivity);
        b();
        paramActivity = null;
      }
    }
    finally
    {
      b();
    }
    paramString = paramActivity;
    if (paramActivity == null) {
      paramString = j.a(j.b.h);
    }
    return i.a(paramString.h, paramString.i, "");
  }
  
  private String a(com.alipay.sdk.g.b arg1)
  {
    Object localObject1 = ???.b;
    ??? = new Bundle();
    ???.putString("url", localObject1[0]);
    localObject1 = new Intent(this.b, H5AuthActivity.class);
    ((Intent)localObject1).putExtras(???);
    this.b.startActivity((Intent)localObject1);
    synchronized (a)
    {
      try
      {
        a.wait();
        localObject1 = i.a;
        ??? = (com.alipay.sdk.g.b)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          ??? = i.a();
        }
        return (String)???;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str = i.a();
        return str;
      }
    }
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(k.a(), 128);
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.versionCode;
      if (i >= 73) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private void b()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public String auth(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        a();
        localObject1 = com.alipay.sdk.h.b.a();
        localObject4 = this.b;
        c.a();
        ((com.alipay.sdk.h.b)localObject1).a((Context)localObject4);
        localObject4 = i.a();
        try
        {
          localObject1 = this.b;
          str2 = new com.alipay.sdk.h.a(this.b).a(paramString);
          if (!a((Context)localObject1)) {
            continue;
          }
          String str1 = new e((Activity)localObject1, new b(this)).a(str2);
          if (TextUtils.equals(str1, "failed")) {
            continue;
          }
          localObject1 = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject1 = i.a();
          }
        }
        catch (Exception localException)
        {
          String str2;
          com.alipay.sdk.c.a.b().a(this.b);
          b();
          com.alipay.sdk.app.a.a.a(this.b, paramString);
          Object localObject2 = localObject4;
          continue;
        }
        finally
        {
          com.alipay.sdk.c.a.b().a(this.b);
          b();
          com.alipay.sdk.app.a.a.a(this.b, paramString);
        }
        return (String)localObject1;
      }
      finally {}
      Object localObject1 = a((Activity)localObject1, str2);
    }
  }
  
  public Map<String, String> authV2(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = com.alipay.sdk.j.i.a(auth(paramString, paramBoolean));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/app/AuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */