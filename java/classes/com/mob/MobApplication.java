package com.mob;

import android.app.Application;
import com.mob.tools.proguard.ProtectedMemberKeeper;

public class MobApplication
  extends Application
  implements ProtectedMemberKeeper
{
  protected String getAppSecret()
  {
    return null;
  }
  
  protected String getAppkey()
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobSDK.init(this, getAppkey(), getAppSecret());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/mob/MobApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */