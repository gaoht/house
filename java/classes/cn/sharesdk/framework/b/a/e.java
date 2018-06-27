package cn.sharesdk.framework.b.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class e
{
  private static e b;
  private SharePrefrenceHelper a = new SharePrefrenceHelper(MobSDK.getContext());
  
  private e()
  {
    this.a.open("share_sdk", 1);
  }
  
  public static e a()
  {
    if (b == null) {
      b = new e();
    }
    return b;
  }
  
  public void a(long paramLong)
  {
    this.a.putLong("device_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    this.a.putString("trans_short_link", paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.putInt(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, Long paramLong)
  {
    this.a.putLong(paramString, paramLong);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.putBoolean("connect_server", Boolean.valueOf(paramBoolean));
  }
  
  public long b()
  {
    return this.a.getLong("service_time");
  }
  
  public void b(long paramLong)
  {
    this.a.putLong("connect_server_time", Long.valueOf(paramLong));
  }
  
  public void b(String paramString)
  {
    this.a.putString("upload_device_info", paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.putBoolean("sns_info_buffered", Boolean.valueOf(paramBoolean));
  }
  
  public void c(String paramString)
  {
    this.a.putString("upload_user_info", paramString);
  }
  
  public boolean c()
  {
    String str = this.a.getString("upload_device_info");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.parseBoolean(str);
  }
  
  public void d(String paramString)
  {
    this.a.putString("upload_share_content", paramString);
  }
  
  public boolean d()
  {
    String str = this.a.getString("upload_user_info");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.parseBoolean(str);
  }
  
  public void e(String paramString)
  {
    this.a.putString("buffered_snsconf_" + MobSDK.getAppkey(), paramString);
  }
  
  public boolean e()
  {
    String str = this.a.getString("trans_short_link");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.parseBoolean(str);
  }
  
  public int f()
  {
    String str = this.a.getString("upload_share_content");
    if ("true".equals(str)) {
      return 1;
    }
    if ("false".equals(str)) {
      return -1;
    }
    return 0;
  }
  
  public long f(String paramString)
  {
    return this.a.getLong(paramString);
  }
  
  public int g(String paramString)
  {
    return this.a.getInt(paramString);
  }
  
  public String g()
  {
    return this.a.getString("buffered_snsconf_" + MobSDK.getAppkey());
  }
  
  public Long h()
  {
    return Long.valueOf(this.a.getLong("device_time"));
  }
  
  public Object h(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public boolean i()
  {
    return this.a.getBoolean("connect_server");
  }
  
  public Long j()
  {
    return Long.valueOf(this.a.getLong("connect_server_time"));
  }
  
  public boolean k()
  {
    return this.a.getBoolean("sns_info_buffered");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */