package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import com.xiaomi.channel.commonutils.misc.a;

public class ao
{
  private static ao a;
  private Context b;
  private int c = 0;
  
  private ao(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static ao a(Context paramContext)
  {
    if (a == null) {
      a = new ao(paramContext);
    }
    return a;
  }
  
  public boolean a()
  {
    return (a.a.contains("xmsf")) || (a.a.contains("xiaomi")) || (a.a.contains("miui"));
  }
  
  @SuppressLint({"NewApi"})
  public int b()
  {
    if (this.c != 0) {
      return this.c;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.c = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
      return this.c;
    }
    this.c = Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
    return this.c;
  }
  
  @SuppressLint({"NewApi"})
  public Uri c()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Settings.Global.getUriFor("device_provisioned");
    }
    return Settings.Secure.getUriFor("device_provisioned");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */