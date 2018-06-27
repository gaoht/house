package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import org.greenrobot.eventbus.c;

public class ErrorDialogManager
{
  public static b<?> a;
  
  protected static void a(d paramd)
  {
    if (a.a.f)
    {
      String str2 = a.a.g;
      String str1 = str2;
      if (str2 == null) {
        str1 = c.a;
      }
      Log.i(str1, "Error dialog manager received exception", paramd.a);
    }
  }
  
  private static boolean a(Activity paramActivity)
  {
    boolean bool = false;
    for (Class localClass = paramActivity.getClass().getSuperclass();; localClass = localClass.getSuperclass())
    {
      if (localClass == null) {
        throw new RuntimeException("Illegal activity type: " + paramActivity.getClass());
      }
      String str = localClass.getName();
      if (str.equals("android.support.v4.app.FragmentActivity")) {
        bool = true;
      }
      do
      {
        return bool;
        if ((str.startsWith("com.actionbarsherlock.app")) && ((str.endsWith(".SherlockActivity")) || (str.endsWith(".SherlockListActivity")) || (str.endsWith(".SherlockPreferenceActivity")))) {
          throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + str);
        }
        if (!str.equals("android.app.Activity")) {
          break;
        }
      } while (Build.VERSION.SDK_INT >= 11);
      throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }
  }
  
  public static void attachTo(Activity paramActivity)
  {
    attachTo(paramActivity, false, null);
  }
  
  public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
  {
    if (a == null) {
      throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }
    if (a(paramActivity))
    {
      SupportManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
      return;
    }
    HoneycombManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
  }
  
  public static void attachTo(Activity paramActivity, boolean paramBoolean)
  {
    attachTo(paramActivity, paramBoolean, null);
  }
  
  public static void attachTo(Activity paramActivity, boolean paramBoolean, Bundle paramBundle)
  {
    attachTo(paramActivity, paramActivity.getClass(), paramBoolean, paramBundle);
  }
  
  private static boolean b(Object paramObject, d paramd)
  {
    if (paramd != null)
    {
      paramd = paramd.getExecutionScope();
      if ((paramd != null) && (!paramd.equals(paramObject))) {
        return false;
      }
    }
    return true;
  }
  
  @TargetApi(11)
  @Instrumented
  public static class HoneycombManagerFragment
    extends android.app.Fragment
  {
    protected boolean a;
    protected Bundle b;
    private c c;
    private Object d;
    
    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      HoneycombManagerFragment localHoneycombManagerFragment = (HoneycombManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      paramActivity = localHoneycombManagerFragment;
      if (localHoneycombManagerFragment == null)
      {
        paramActivity = new HoneycombManagerFragment();
        localFragmentManager.beginTransaction().add(paramActivity, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      paramActivity.a = paramBoolean;
      paramActivity.b = paramBundle;
      paramActivity.d = paramObject;
    }
    
    public void onEventMainThread(d paramd)
    {
      if (!ErrorDialogManager.a(this.d, paramd)) {}
      android.app.FragmentManager localFragmentManager;
      do
      {
        return;
        ErrorDialogManager.a(paramd);
        localFragmentManager = getFragmentManager();
        localFragmentManager.executePendingTransactions();
        android.app.DialogFragment localDialogFragment = (android.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (localDialogFragment != null) {
          localDialogFragment.dismiss();
        }
        paramd = (android.app.DialogFragment)ErrorDialogManager.a.a(paramd, this.a, this.b);
      } while (paramd == null);
      if (!(paramd instanceof android.app.DialogFragment))
      {
        paramd.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
        return;
      }
      VdsAgent.showDialogFragment((android.app.DialogFragment)paramd, localFragmentManager, "de.greenrobot.eventbus.error_dialog");
    }
    
    public void onHiddenChanged(boolean paramBoolean)
    {
      super.onHiddenChanged(paramBoolean);
      VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
    }
    
    public void onPause()
    {
      VdsAgent.onFragmentPause(this);
      this.c.unregister(this);
      super.onPause();
    }
    
    public void onResume()
    {
      VdsAgent.onFragmentResume(this);
      super.onResume();
      this.c = ErrorDialogManager.a.a.a();
      this.c.register(this);
    }
    
    public void setUserVisibleHint(boolean paramBoolean)
    {
      super.setUserVisibleHint(paramBoolean);
      VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
    }
  }
  
  @Instrumented
  public static class SupportManagerFragment
    extends android.support.v4.app.Fragment
  {
    protected boolean a;
    protected Bundle b;
    private c c;
    private boolean d;
    private Object e;
    
    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      android.support.v4.app.FragmentManager localFragmentManager = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportManagerFragment localSupportManagerFragment = (SupportManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      paramActivity = localSupportManagerFragment;
      if (localSupportManagerFragment == null)
      {
        paramActivity = new SupportManagerFragment();
        localFragmentManager.beginTransaction().add(paramActivity, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      paramActivity.a = paramBoolean;
      paramActivity.b = paramBundle;
      paramActivity.e = paramObject;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      this.c = ErrorDialogManager.a.a.a();
      this.c.register(this);
      this.d = true;
    }
    
    public void onEventMainThread(d paramd)
    {
      if (!ErrorDialogManager.a(this.e, paramd)) {}
      android.support.v4.app.FragmentManager localFragmentManager;
      do
      {
        return;
        ErrorDialogManager.a(paramd);
        localFragmentManager = getFragmentManager();
        localFragmentManager.executePendingTransactions();
        android.support.v4.app.DialogFragment localDialogFragment = (android.support.v4.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (localDialogFragment != null) {
          localDialogFragment.dismiss();
        }
        paramd = (android.support.v4.app.DialogFragment)ErrorDialogManager.a.a(paramd, this.a, this.b);
      } while (paramd == null);
      if (!(paramd instanceof android.support.v4.app.DialogFragment))
      {
        paramd.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
        return;
      }
      VdsAgent.showDialogFragment((android.support.v4.app.DialogFragment)paramd, localFragmentManager, "de.greenrobot.eventbus.error_dialog");
    }
    
    public void onHiddenChanged(boolean paramBoolean)
    {
      super.onHiddenChanged(paramBoolean);
      VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
    }
    
    public void onPause()
    {
      VdsAgent.onFragmentPause(this);
      this.c.unregister(this);
      super.onPause();
    }
    
    public void onResume()
    {
      VdsAgent.onFragmentResume(this);
      super.onResume();
      if (this.d)
      {
        this.d = false;
        return;
      }
      this.c = ErrorDialogManager.a.a.a();
      this.c.register(this);
    }
    
    public void setUserVisibleHint(boolean paramBoolean)
    {
      super.setUserVisibleHint(paramBoolean);
      VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/ErrorDialogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */