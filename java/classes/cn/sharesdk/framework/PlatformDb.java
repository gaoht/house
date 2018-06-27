package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;

public class PlatformDb
{
  private static final String DB_NAME = "cn_sharesdk_weibodb";
  private String platformNname;
  private int platformVersion;
  private SharePrefrenceHelper sp = new SharePrefrenceHelper(MobSDK.getContext());
  
  public PlatformDb(String paramString, int paramInt)
  {
    this.sp.open("cn_sharesdk_weibodb_" + paramString, paramInt);
    this.platformNname = paramString;
    this.platformVersion = paramInt;
  }
  
  public String exportData()
  {
    try
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).putAll(this.sp.getAll());
      localObject = new Hashon().fromHashMap((HashMap)localObject);
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      e.b().d(localThrowable);
    }
    return null;
  }
  
  public String get(String paramString)
  {
    return this.sp.getString(paramString);
  }
  
  public long getExpiresIn()
  {
    try
    {
      long l = this.sp.getLong("expiresIn");
      return l;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        int i = this.sp.getInt("expiresIn");
        return i;
      }
      catch (Throwable localThrowable2) {}
    }
    return 0L;
  }
  
  public long getExpiresTime()
  {
    return this.sp.getLong("expiresTime") + getExpiresIn() * 1000L;
  }
  
  public String getPlatformNname()
  {
    return this.platformNname;
  }
  
  public int getPlatformVersion()
  {
    return this.platformVersion;
  }
  
  public String getToken()
  {
    return this.sp.getString("token");
  }
  
  public String getTokenSecret()
  {
    return this.sp.getString("secret");
  }
  
  public String getUserGender()
  {
    String str = this.sp.getString("gender");
    if ("0".equals(str)) {
      return "m";
    }
    if ("1".equals(str)) {
      return "f";
    }
    return null;
  }
  
  public String getUserIcon()
  {
    return this.sp.getString("icon");
  }
  
  public String getUserId()
  {
    String str2 = this.sp.getString("userID");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.sp.getString("weibo");
    }
    return str1;
  }
  
  public String getUserName()
  {
    return this.sp.getString("nickname");
  }
  
  public void importData(String paramString)
  {
    try
    {
      paramString = new Hashon().fromJson(paramString);
      if (paramString != null) {
        this.sp.putAll(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      e.b().d(paramString);
    }
  }
  
  public boolean isValid()
  {
    boolean bool2 = true;
    String str = getToken();
    boolean bool1;
    if ((str == null) || (str.length() <= 0)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (getExpiresIn() == 0L);
      bool1 = bool2;
    } while (getExpiresTime() > System.currentTimeMillis());
    return false;
  }
  
  public void put(String paramString1, String paramString2)
  {
    this.sp.putString(paramString1, paramString2);
  }
  
  public void putExpiresIn(long paramLong)
  {
    this.sp.putLong("expiresIn", Long.valueOf(paramLong));
    this.sp.putLong("expiresTime", Long.valueOf(System.currentTimeMillis()));
  }
  
  public void putToken(String paramString)
  {
    this.sp.putString("token", paramString);
  }
  
  public void putTokenSecret(String paramString)
  {
    this.sp.putString("secret", paramString);
  }
  
  public void putUserId(String paramString)
  {
    this.sp.putString("userID", paramString);
  }
  
  public void removeAccount()
  {
    this.sp.clear();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/PlatformDb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */