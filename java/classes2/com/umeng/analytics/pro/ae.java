package com.umeng.analytics.pro;

import android.content.Context;
import android.telephony.TelephonyManager;

public class ae
  extends y
{
  private static final String a = "imei";
  private Context b;
  
  public ae(Context paramContext)
  {
    super("imei");
    this.b = paramContext;
  }
  
  public String f()
  {
    Object localObject = (TelephonyManager)this.b.getSystemService("phone");
    if (localObject == null) {}
    try
    {
      if (bv.a(this.b, "android.permission.READ_PHONE_STATE"))
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */