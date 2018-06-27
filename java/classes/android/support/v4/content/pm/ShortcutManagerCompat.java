package android.support.v4.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class ShortcutManagerCompat
{
  static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
  static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
  
  public static Intent createShortcutResultIntent(Context paramContext, ShortcutInfoCompat paramShortcutInfoCompat)
  {
    Intent localIntent = null;
    if (Build.VERSION.SDK_INT >= 26) {
      localIntent = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).createShortcutResultIntent(paramShortcutInfoCompat.toShortcutInfo());
    }
    paramContext = localIntent;
    if (localIntent == null) {
      paramContext = new Intent();
    }
    return paramShortcutInfoCompat.addToIntent(paramContext);
  }
  
  public static boolean isRequestPinShortcutSupported(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }
    if (ContextCompat.checkSelfPermission(paramContext, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
      return false;
    }
    paramContext = paramContext.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
    while (paramContext.hasNext())
    {
      String str = ((ResolveInfo)paramContext.next()).activityInfo.permission;
      if ((TextUtils.isEmpty(str)) || ("com.android.launcher.permission.INSTALL_SHORTCUT".equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean requestPinShortcut(Context paramContext, ShortcutInfoCompat paramShortcutInfoCompat, IntentSender paramIntentSender)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).requestPinShortcut(paramShortcutInfoCompat.toShortcutInfo(), paramIntentSender);
    }
    if (!isRequestPinShortcutSupported(paramContext)) {
      return false;
    }
    paramShortcutInfoCompat = paramShortcutInfoCompat.addToIntent(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
    if (paramIntentSender == null)
    {
      paramContext.sendBroadcast(paramShortcutInfoCompat);
      return true;
    }
    paramContext.sendOrderedBroadcast(paramShortcutInfoCompat, null, new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        try
        {
          this.val$callback.sendIntent(paramAnonymousContext, 0, null, null, null);
          return;
        }
        catch (IntentSender.SendIntentException paramAnonymousContext) {}
      }
    }, null, -1, null, null);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/content/pm/ShortcutManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */