package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FakeActivity
{
  private static Class<? extends Activity> shellClass;
  protected Activity activity;
  private View contentView;
  private HashMap<String, Object> result;
  private FakeActivity resultReceiver;
  
  public static void registerExecutor(String paramString, Object paramObject)
  {
    if (shellClass != null) {
      try
      {
        Method localMethod = shellClass.getMethod("registerExecutor", new Class[] { String.class, Object.class });
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramString, paramObject });
        return;
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().w(paramString);
        return;
      }
    }
    MobUIShell.registerExecutor(paramString, paramObject);
  }
  
  public static void setShell(Class<? extends Activity> paramClass)
  {
    shellClass = paramClass;
  }
  
  private void showActivity(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramContext;
    if (!(paramContext instanceof Activity))
    {
      localObject = DeviceHelper.getInstance(paramContext).getTopActivity();
      if (localObject != null) {
        break label36;
      }
      paramIntent.addFlags(268435456);
      localObject = paramContext;
    }
    label36:
    for (;;)
    {
      ((Context)localObject).startActivity(paramIntent);
      return;
    }
  }
  
  public void beforeStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  protected boolean disableScreenCapture()
  {
    if ((this.activity != null) && (Build.VERSION.SDK_INT >= 11))
    {
      this.activity.getWindow().setFlags(8192, 8192);
      return true;
    }
    return false;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    if (this.activity == null) {
      return null;
    }
    return this.activity.findViewById(paramInt);
  }
  
  public <T extends View> T findViewByResName(View paramView, String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = ResHelper.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return paramView.findViewById(i);
  }
  
  public <T extends View> T findViewByResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = ResHelper.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return findViewById(i);
  }
  
  public final void finish()
  {
    if (this.activity != null) {
      this.activity.finish();
    }
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public Context getContext()
  {
    return this.activity;
  }
  
  public int getOrientation()
  {
    return this.activity.getResources().getConfiguration().orientation;
  }
  
  public FakeActivity getParent()
  {
    return this.resultReceiver;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onDestroy() {}
  
  public boolean onFinish()
  {
    return false;
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  @Instrumented
  public void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    VdsAgent.handleClickResult(new Boolean(false));
    return false;
  }
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onRestart() {}
  
  public void onResult(HashMap<String, Object> paramHashMap) {}
  
  public void onResume() {}
  
  protected int onSetTheme(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void requestFullScreen(boolean paramBoolean)
  {
    if (this.activity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.activity.getWindow().addFlags(1024);
      this.activity.getWindow().clearFlags(2048);
    }
    for (;;)
    {
      this.activity.getWindow().getDecorView().requestLayout();
      return;
      this.activity.getWindow().addFlags(2048);
      this.activity.getWindow().clearFlags(1024);
    }
  }
  
  public void requestLandscapeOrientation()
  {
    setRequestedOrientation(0);
  }
  
  public void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    if (this.activity == null) {}
    while (Build.VERSION.SDK_INT < 23) {
      return;
    }
    try
    {
      ReflectHelper.invokeInstanceMethod(this.activity, "requestPermissions", new Object[] { paramArrayOfString, Integer.valueOf(paramInt) });
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      MobLog.getInstance().d(paramArrayOfString);
    }
  }
  
  public void requestPortraitOrientation()
  {
    setRequestedOrientation(1);
  }
  
  public void requestSensorLandscapeOrientation()
  {
    setRequestedOrientation(6);
  }
  
  public void requestSensorPortraitOrientation()
  {
    setRequestedOrientation(7);
  }
  
  public void runOnUIThread(final Runnable paramRunnable)
  {
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramRunnable.run();
        return false;
      }
    });
  }
  
  public void runOnUIThread(final Runnable paramRunnable, long paramLong)
  {
    UIHandler.sendEmptyMessageDelayed(0, paramLong, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramRunnable.run();
        return false;
      }
    });
  }
  
  public void sendResult()
  {
    if (this.resultReceiver != null) {
      this.resultReceiver.onResult(this.result);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentViewLayoutResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return;
      i = ResHelper.getLayoutRes(this.activity, paramString);
    } while (i <= 0);
    this.activity.setContentView(i);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (this.activity == null) {}
    while ((Build.VERSION.SDK_INT >= 26) && (getContext().getApplicationInfo().targetSdkVersion >= 27)) {
      return;
    }
    this.activity.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(HashMap<String, Object> paramHashMap)
  {
    this.result = paramHashMap;
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    showForResult(paramContext, paramIntent, null);
  }
  
  public void showForResult(final Context paramContext, Intent paramIntent, final FakeActivity paramFakeActivity)
  {
    this.resultReceiver = paramFakeActivity;
    if (shellClass != null) {
      paramFakeActivity = new Intent(paramContext, shellClass);
    }
    for (;;)
    {
      try
      {
        Object localObject = shellClass.getMethod("registerExecutor", new Class[] { Object.class });
        ((Method)localObject).setAccessible(true);
        localObject = (String)((Method)localObject).invoke(null, new Object[] { this });
        paramFakeActivity.putExtra("launch_time", (String)localObject);
        paramFakeActivity.putExtra("executor_name", getClass().getName());
        if (paramIntent != null) {
          paramFakeActivity.putExtras(paramIntent);
        }
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
          break;
        }
        showActivity(paramContext, paramFakeActivity);
        return;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        str = null;
        continue;
      }
      paramFakeActivity = new Intent(paramContext, MobUIShell.class);
      String str = MobUIShell.registerExecutor(this);
    }
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        FakeActivity.this.showActivity(paramContext, paramFakeActivity);
        return false;
      }
    });
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, -1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/FakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */