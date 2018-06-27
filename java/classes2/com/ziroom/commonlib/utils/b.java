package com.ziroom.commonlib.utils;

import android.text.TextUtils;
import com.ziroom.commonlib.a.d;

public class b
{
  private static long a = -1L;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static int e;
  private static int f;
  private static boolean g;
  private static double[] h;
  private static d i;
  
  public static String getAppId()
  {
    return b;
  }
  
  public static String getHuaWeiToken()
  {
    return c;
  }
  
  public static String getJPushUid()
  {
    return d;
  }
  
  public static double[] getLatlngArray()
  {
    return h;
  }
  
  public static int getMisuNum()
  {
    return f;
  }
  
  public static long getTimeDiff()
  {
    return a;
  }
  
  public static int getUnReadNum()
  {
    return e;
  }
  
  public static d getUserInfo()
  {
    return i;
  }
  
  public static boolean isImconnect()
  {
    return g;
  }
  
  public static void setAppId(String paramString)
  {
    b = paramString;
  }
  
  public static void setHuaWeiToken(String paramString)
  {
    c = paramString;
  }
  
  public static void setImconnect(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static void setLatlng_array(double[] paramArrayOfDouble)
  {
    h = paramArrayOfDouble;
  }
  
  public static void setMisuNum(int paramInt)
  {
    f = paramInt;
  }
  
  public static void setTimeDiff(long paramLong)
  {
    a = paramLong;
  }
  
  public static void setUnReadNum(int paramInt)
  {
    e = paramInt;
  }
  
  public static void setUserInfo(d paramd)
  {
    if ((paramd != null) && (!TextUtils.isEmpty(paramd.getUid())))
    {
      i = paramd;
      d = paramd.getUid();
      return;
    }
    i = paramd;
    d = "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */