package android.support.v4.os;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class UserManagerCompat
{
  public static boolean isUserUnlocked(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ((UserManager)paramContext.getSystemService(UserManager.class)).isUserUnlocked();
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/os/UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */