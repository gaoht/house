package com.mob.wrappers;

import com.mob.moblink.ActionListener;
import com.mob.moblink.MobLink;
import com.mob.moblink.Scene;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashMap;
import java.util.Map;

public class MobLinkWrapper
  implements PublicMemberKeeper
{
  private static int state;
  
  public static boolean getMobId(String paramString1, String paramString2, Map<String, Object> paramMap, MobIdCallback paramMobIdCallback)
  {
    if (isAvailable())
    {
      Scene localScene = new Scene();
      localScene.path = paramString1;
      localScene.source = paramString2;
      localScene.params = new HashMap(paramMap);
      MobLink.getMobID(localScene, new ActionListener()
      {
        public void onError(Throwable paramAnonymousThrowable)
        {
          this.val$callback.onError(paramAnonymousThrowable);
        }
        
        public void onResult(String paramAnonymousString)
        {
          this.val$callback.onResult(paramAnonymousString);
        }
      });
      return true;
    }
    return false;
  }
  
  private static boolean isAvailable()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = state;
        if (i == 0) {}
        try
        {
          ReflectHelper.importClass("com.mob.moblink.MobLink");
          state = 1;
          i = state;
          if (i == 1) {
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          state = -1;
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  public static abstract interface MobIdCallback
  {
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onResult(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/MobLinkWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */