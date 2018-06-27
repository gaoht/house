package com.mob.tools;

import com.mob.tools.log.NLog;

public class MobLog
  extends NLog
{
  public static NLog getInstance()
  {
    return getInstanceForSDK("MOBTOOLS", true);
  }
  
  protected String getSDKTag()
  {
    return "MOBTOOLS";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/MobLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */