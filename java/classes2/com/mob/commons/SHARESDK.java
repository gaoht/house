package com.mob.commons;

import cn.sharesdk.framework.ShareSDK;

public class SHARESDK
  implements MobProduct
{
  public String getProductTag()
  {
    return "SHARESDK";
  }
  
  public int getSdkver()
  {
    return ShareSDK.SDK_VERSION_CODE;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/SHARESDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */