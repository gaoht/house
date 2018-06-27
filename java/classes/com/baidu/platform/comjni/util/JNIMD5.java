package com.baidu.platform.comjni.util;

public class JNIMD5
{
  public static native String encodeUrlParamsValue(String paramString);
  
  public static native String getSignMD5String(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/util/JNIMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */