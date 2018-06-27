package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MobUIShell
  extends Activity
{
  private static HashMap<String, FakeActivity> executors = new HashMap();
  private FakeActivity executor;
  
  static
  {
    MobLog.getInstance().d("===============================", new Object[0]);
    String str = "2018-05-23".replace("-0", "-").replace("-", ".");
    MobLog.getInstance().d("MobTools " + str, new Object[0]);
    MobLog.getInstance().d("===============================", new Object[0]);
  }
  
  private FakeActivity activityForName(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String str = paramString;
        if (paramString.startsWith(".")) {
          str = getPackageName() + paramString;
        }
        paramString = ReflectHelper.importClass(str);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = ReflectHelper.newInstance(paramString, new Object[0]);
          if ((paramString != null) && ((paramString instanceof FakeActivity)))
          {
            paramString = (FakeActivity)paramString;
            return paramString;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  private boolean initExecutor()
  {
    if (this.executor == null)
    {
      Object localObject1 = getIntent();
      Object localObject2 = ((Intent)localObject1).getData();
      if ((localObject2 != null) && ("mobui".equals(((Uri)localObject2).getScheme())))
      {
        this.executor = activityForName(((Uri)localObject2).getHost());
        if (this.executor != null)
        {
          MobLog.getInstance().i("MobUIShell found executor: " + this.executor.getClass(), new Object[0]);
          this.executor.setActivity(this);
          return true;
        }
      }
      try
      {
        localObject2 = ((Intent)localObject1).getStringExtra("launch_time");
        String str = ((Intent)localObject1).getStringExtra("executor_name");
        this.executor = ((FakeActivity)executors.remove(localObject2));
        if (this.executor == null)
        {
          localObject1 = ((Intent)localObject1).getScheme();
          this.executor = ((FakeActivity)executors.remove(localObject1));
          if (this.executor == null)
          {
            this.executor = getDefault();
            if (this.executor == null)
            {
              MobLog.getInstance().w(new RuntimeException("Executor lost! launchTime = " + (String)localObject2 + ", executorName: " + str));
              return false;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        return false;
      }
      MobLog.getInstance().i("MobUIShell found executor: " + this.executor.getClass(), new Object[0]);
      this.executor.setActivity(this);
    }
    return true;
  }
  
  protected static String registerExecutor(Object paramObject)
  {
    return registerExecutor(String.valueOf(System.currentTimeMillis()), paramObject);
  }
  
  protected static String registerExecutor(String paramString, Object paramObject)
  {
    executors.put(paramString, (FakeActivity)paramObject);
    return paramString;
  }
  
  public static Uri toMobUIShellUri(String paramString, HashMap<String, Object> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new KVPair(str, String.valueOf(paramHashMap.get(str))));
    }
    return Uri.parse("mobui://" + paramString + "?" + ResHelper.encodeUrl(localArrayList));
  }
  
  public void finish()
  {
    if ((this.executor != null) && (this.executor.onFinish())) {
      return;
    }
    super.finish();
  }
  
  public FakeActivity getDefault()
  {
    try
    {
      String str = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString("defaultActivity");
      return activityForName(str);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
        Object localObject = null;
      }
    }
  }
  
  public Object getExecutor()
  {
    return this.executor;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.executor != null) {
      this.executor.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.executor != null) {
      this.executor.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (initExecutor())
    {
      super.onCreate(paramBundle);
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onCreate", new Object[0]);
      this.executor.onCreate();
      return;
    }
    super.onCreate(paramBundle);
    finish();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    if (this.executor != null) {
      bool = this.executor.onCreateOptionsMenu(paramMenu);
    }
    return bool;
  }
  
  protected void onDestroy()
  {
    if (this.executor != null)
    {
      this.executor.sendResult();
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onDestroy", new Object[0]);
      this.executor.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    label40:
    do
    {
      try
      {
        if (this.executor == null) {
          break label40;
        }
        bool = this.executor.onKeyEvent(paramInt, paramKeyEvent);
      }
      catch (Throwable paramKeyEvent)
      {
        MobLog.getInstance().w(paramKeyEvent);
        return false;
      }
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      return bool;
      bool = false;
    } while (!bool);
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    label40:
    do
    {
      try
      {
        if (this.executor == null) {
          break label40;
        }
        bool = this.executor.onKeyEvent(paramInt, paramKeyEvent);
      }
      catch (Throwable paramKeyEvent)
      {
        MobLog.getInstance().w(paramKeyEvent);
        return false;
      }
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      return bool;
      bool = false;
    } while (!bool);
    return true;
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    if (this.executor == null)
    {
      super.onNewIntent(paramIntent);
      return;
    }
    this.executor.onNewIntent(paramIntent);
  }
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    if (this.executor != null)
    {
      bool = this.executor.onOptionsItemSelected(paramMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    }
    VdsAgent.handleClickResult(new Boolean(bool));
    return bool;
  }
  
  protected void onPause()
  {
    if (this.executor != null)
    {
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onPause", new Object[0]);
      this.executor.onPause();
    }
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.executor != null) {
      this.executor.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onRestart()
  {
    if (this.executor != null)
    {
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onRestart", new Object[0]);
      this.executor.onRestart();
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.executor != null)
    {
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onResume", new Object[0]);
      this.executor.onResume();
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.executor != null)
    {
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onStart", new Object[0]);
      this.executor.onStart();
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.executor != null)
    {
      MobLog.getInstance().d(this.executor.getClass().getSimpleName() + " onStop", new Object[0]);
      this.executor.onStop();
    }
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      super.setContentView(paramView);
    } while (this.executor == null);
    this.executor.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramLayoutParams == null) {
        super.setContentView(paramView);
      }
      while (this.executor != null)
      {
        this.executor.setContentView(paramView);
        return;
        super.setContentView(paramView, paramLayoutParams);
      }
    }
  }
  
  public final void setTheme(int paramInt)
  {
    if (initExecutor())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int j;
      for (int i = 0; i < arrayOfStackTraceElement.length; i = j + 1)
      {
        j = i;
        if (arrayOfStackTraceElement[i].toString().startsWith("java.lang.Thread.getStackTrace"))
        {
          i += 2;
          j = i;
          if (i < arrayOfStackTraceElement.length)
          {
            boolean bool = arrayOfStackTraceElement[i].toString().startsWith("android.app.ActivityThread.performLaunchActivity");
            paramInt = this.executor.onSetTheme(paramInt, bool);
            if (paramInt > 0) {
              super.setTheme(paramInt);
            }
            return;
          }
        }
      }
    }
    super.setTheme(paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.executor != null) {
      this.executor.beforeStartActivityForResult(paramIntent, paramInt, paramBundle);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/MobUIShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */