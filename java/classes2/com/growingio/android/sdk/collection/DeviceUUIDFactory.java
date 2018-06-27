package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.PermissionUtil;
import com.growingio.android.sdk.utils.PersistUtil;
import java.nio.charset.Charset;
import java.util.UUID;

public class DeviceUUIDFactory
{
  private String a;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private final String f = "Gio.DeviceUUIDFactory";
  
  @TargetApi(9)
  public DeviceUUIDFactory(Context paramContext)
  {
    if (TextUtils.isEmpty(this.a)) {
      try
      {
        b(paramContext);
        c(paramContext);
        d(paramContext);
        a(paramContext);
        e(paramContext);
        return;
      }
      finally {}
    }
  }
  
  @SuppressLint({"HardwareIds"})
  private void b(Context paramContext)
  {
    if (PermissionUtil.f())
    {
      paramContext = h(paramContext);
      if (paramContext != null) {
        this.c = paramContext.getMacAddress();
      }
    }
  }
  
  @SuppressLint({"HardwareIds"})
  private void c(Context paramContext)
  {
    if (PermissionUtil.e()) {
      this.b = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
  }
  
  private void d(Context paramContext)
  {
    if (TextUtils.isEmpty(this.a))
    {
      this.a = PersistUtil.a();
      if (TextUtils.isEmpty(this.a))
      {
        f(paramContext);
        if (TextUtils.isEmpty(this.a)) {
          break label43;
        }
      }
    }
    return;
    label43:
    g(paramContext);
  }
  
  private void e(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (PermissionUtil.e())
    {
      paramContext = "" + ((TelephonyManager)localObject).getDeviceId();
      localObject = "" + ((TelephonyManager)localObject).getSimSerialNumber();
      long l1 = this.d.hashCode();
      long l2 = paramContext.hashCode();
      this.e = new UUID(l1, ((String)localObject).hashCode() | l2 << 32).toString();
      return;
    }
    LogUtil.d("Gio.DeviceUUIDFactory", new Object[] { "don't have permission android.permission.READ_PHONE_STATE,initUUID failed " });
  }
  
  private void f(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("device_id.xml", 0).getString("device_id", null);
    if (!TextUtils.isEmpty(paramContext))
    {
      this.a = paramContext;
      PersistUtil.a(this.a);
    }
  }
  
  @SuppressLint({"HardwareIds"})
  @TargetApi(9)
  private void g(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((!TextUtils.isEmpty(paramContext)) && (!"9774d56d682e549c".equals(paramContext))) {
      this.a = UUID.nameUUIDFromBytes(paramContext.getBytes(Charset.forName("UTF-8"))).toString();
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.a)) {
        this.a = UUID.randomUUID().toString();
      }
      PersistUtil.a(this.a);
      return;
      if (!TextUtils.isEmpty(this.b)) {
        this.a = UUID.nameUUIDFromBytes(this.b.getBytes(Charset.forName("UTF-8"))).toString();
      }
    }
  }
  
  private WifiInfo h(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getConnectionInfo();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        LogUtil.e("Gio.DeviceUUIDFactory", "设备WIFI异常");
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    this.d = Settings.System.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/DeviceUUIDFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */