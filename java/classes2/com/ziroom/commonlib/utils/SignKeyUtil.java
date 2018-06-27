package com.ziroom.commonlib.utils;

public class SignKeyUtil
{
  private static SignKeyUtil a = null;
  
  static
  {
    System.loadLibrary("ZiroomKey");
  }
  
  public static String getHouseKey()
  {
    return getInstance().getHouseKeyFromC();
  }
  
  public static SignKeyUtil getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new SignKeyUtil();
      }
      return a;
    }
    finally {}
  }
  
  public static native String getIvKeyFromC();
  
  public static String getKey()
  {
    String str = getSignKey();
    try
    {
      str = g.aesEncrypt(str.substring(0, str.length() - 1), getInstance().getDataFromC());
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static native String getKeyFromC();
  
  public static String getSignKey()
  {
    return getInstance().getSignKeyFromC();
  }
  
  public native String getDataFromC();
  
  public native String getHouseKeyFromC();
  
  public native String getSignKeyFromC();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/SignKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */