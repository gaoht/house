package com.baidu.mapapi.common;

import com.baidu.platform.comapi.util.f;

public class SysOSUtil
{
  public static float getDensity()
  {
    return f.z;
  }
  
  public static int getDensityDpi()
  {
    return f.k();
  }
  
  public static String getDeviceID()
  {
    return f.m();
  }
  
  public static String getModuleFileName()
  {
    return f.l();
  }
  
  public static int getScreenSizeX()
  {
    return f.g();
  }
  
  public static int getScreenSizeY()
  {
    return f.i();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/common/SysOSUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */