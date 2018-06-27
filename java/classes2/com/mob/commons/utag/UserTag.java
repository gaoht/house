package com.mob.commons.utag;

import com.mob.tools.proguard.PublicMemberKeeper;

public class UserTag
  implements PublicMemberKeeper
{
  public static TagRequester getUserTags()
  {
    return new TagRequester();
  }
  
  public static UserTager tagUser()
  {
    return new UserTager();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/utag/UserTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */