package com.baidu.mapapi;

import com.baidu.platform.comjni.tools.a;

public class OpenLogUtil
{
  private static ModuleName a;
  
  public static void setModuleLogEnable(ModuleName paramModuleName, boolean paramBoolean)
  {
    a = paramModuleName;
    a.a(paramBoolean, a.ordinal());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/OpenLogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */