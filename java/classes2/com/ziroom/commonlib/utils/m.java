package com.ziroom.commonlib.utils;

import android.text.TextUtils;

public class m
{
  static p a = p.getInstance("login_info");
  private static String b;
  private static String c;
  
  public static void clearLoginInfo()
  {
    b = null;
    c = null;
    a.remove("token");
    a.remove("uid");
  }
  
  public static int getLastLoginType()
  {
    return a.getInt("login_last");
  }
  
  public static boolean getLoginState()
  {
    return (!TextUtils.isEmpty(a.getString("token"))) && (!TextUtils.isEmpty(a.getString("uid")));
  }
  
  public static String getToken()
  {
    if (r.isEmpty(b)) {
      b = a.getString("token");
    }
    return b;
  }
  
  public static String getUid()
  {
    if (r.isEmpty(c)) {
      c = a.getString("uid");
    }
    return c;
  }
  
  public static void putLastLoginType(int paramInt)
  {
    a.putInt("login_last", paramInt);
  }
  
  public static void setLoginInfo(String paramString1, String paramString2)
  {
    b = paramString1;
    c = paramString2;
    a.putString("token", paramString1);
    a.putString("uid", paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */