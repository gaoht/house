package com.mob.commons.logcollector;

import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class d
{
  private static d a;
  private SharePrefrenceHelper b = new SharePrefrenceHelper(MobSDK.getContext());
  
  private d()
  {
    this.b.open("mob_sdk_exception", 1);
  }
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    this.b.putInt("is_upload_crash", Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong)
  {
    this.b.putLong("service_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    this.b.putString("err_log_filter", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    SharePrefrenceHelper localSharePrefrenceHelper = this.b;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localSharePrefrenceHelper.putInt("is_upload_err_log", Integer.valueOf(i));
      return;
    }
  }
  
  public long b()
  {
    return this.b.getLong("service_time");
  }
  
  public void b(int paramInt)
  {
    this.b.putInt("is_upload_sdkerr", Integer.valueOf(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.b.putInt("is_upload_apperr", Integer.valueOf(paramInt));
  }
  
  public boolean c()
  {
    return this.b.getInt("is_upload_err_log") == 0;
  }
  
  public int d()
  {
    return this.b.getInt("is_upload_crash");
  }
  
  public int e()
  {
    return this.b.getInt("is_upload_sdkerr");
  }
  
  public int f()
  {
    return this.b.getInt("is_upload_apperr");
  }
  
  public String g()
  {
    return this.b.getString("err_log_filter");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/logcollector/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */