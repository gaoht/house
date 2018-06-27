package com.baidu.platform.comjni.util;

public class AppMD5
{
  public static String encodeUrlParamsValue(String paramString)
  {
    return JNIMD5.encodeUrlParamsValue(paramString);
  }
  
  public static String getSignMD5String(String paramString)
  {
    return JNIMD5.getSignMD5String(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/util/AppMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */