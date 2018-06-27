package com.mob.tools.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.HashSet;

public class ActivityTracker
{
  private static ActivityTracker instance;
  private HashSet<Tracker> trackers = new HashSet();
  
  private ActivityTracker(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      initLevel14(paramContext);
      return;
    }
    init(paramContext);
  }
  
  private void eachTracker(EachTracker paramEachTracker)
  {
    try
    {
      synchronized (this.trackers)
      {
        Tracker[] arrayOfTracker = (Tracker[])this.trackers.toArray(new Tracker[this.trackers.size()]);
        int j = arrayOfTracker.length;
        int i = 0;
        if (i < j)
        {
          ??? = arrayOfTracker[i];
          if (??? != null) {
            paramEachTracker.each(???);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramEachTracker)
    {
      MobLog.getInstance().w(paramEachTracker);
    }
  }
  
  public static ActivityTracker getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new ActivityTracker(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  private void init(Context paramContext)
  {
    try
    {
      DeviceHelper.getInstance(paramContext);
      paramContext = DeviceHelper.currentActivityThread();
      ReflectHelper.setInstanceField(paramContext, "mInstrumentation", new Instrumentation()
      {
        public void callActivityOnCreate(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnCreate", new Object[] { paramAnonymousActivity, paramAnonymousBundle });
            super.callActivityOnCreate(paramAnonymousActivity, paramAnonymousBundle);
            ActivityTracker.this.onCreated(paramAnonymousActivity, paramAnonymousBundle);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnDestroy(Activity paramAnonymousActivity)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnDestroy", new Object[] { paramAnonymousActivity });
            super.callActivityOnDestroy(paramAnonymousActivity);
            ActivityTracker.this.onDestroyed(paramAnonymousActivity);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnPause(Activity paramAnonymousActivity)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnPause", new Object[] { paramAnonymousActivity });
            super.callActivityOnPause(paramAnonymousActivity);
            ActivityTracker.this.onPaused(paramAnonymousActivity);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnResume(Activity paramAnonymousActivity)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnResume", new Object[] { paramAnonymousActivity });
            super.callActivityOnResume(paramAnonymousActivity);
            ActivityTracker.this.onResumed(paramAnonymousActivity);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnSaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnSaveInstanceState", new Object[] { paramAnonymousActivity, paramAnonymousBundle });
            super.callActivityOnSaveInstanceState(paramAnonymousActivity, paramAnonymousBundle);
            ActivityTracker.this.onSaveInstanceState(paramAnonymousActivity, paramAnonymousBundle);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnStart(Activity paramAnonymousActivity)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnStart", new Object[] { paramAnonymousActivity });
            super.callActivityOnStart(paramAnonymousActivity);
            ActivityTracker.this.onStarted(paramAnonymousActivity);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
        
        public void callActivityOnStop(Activity paramAnonymousActivity)
        {
          if (this.val$origin != null) {}
          try
          {
            ReflectHelper.invokeInstanceMethod(this.val$origin, "callActivityOnStop", new Object[] { paramAnonymousActivity });
            super.callActivityOnStop(paramAnonymousActivity);
            ActivityTracker.this.onStopped(paramAnonymousActivity);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
      });
      return;
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
  }
  
  private void initLevel14(Context paramContext)
  {
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        ActivityTracker.this.onCreated(paramAnonymousActivity, paramAnonymousBundle);
      }
      
      public void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        ActivityTracker.this.onDestroyed(paramAnonymousActivity);
      }
      
      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        ActivityTracker.this.onPaused(paramAnonymousActivity);
      }
      
      public void onActivityResumed(Activity paramAnonymousActivity)
      {
        ActivityTracker.this.onResumed(paramAnonymousActivity);
      }
      
      public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        ActivityTracker.this.onSaveInstanceState(paramAnonymousActivity, paramAnonymousBundle);
      }
      
      public void onActivityStarted(Activity paramAnonymousActivity)
      {
        ActivityTracker.this.onStarted(paramAnonymousActivity);
      }
      
      public void onActivityStopped(Activity paramAnonymousActivity)
      {
        ActivityTracker.this.onStopped(paramAnonymousActivity);
      }
    });
  }
  
  private void onCreated(final Activity paramActivity, final Bundle paramBundle)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onCreated(paramActivity, paramBundle);
      }
    });
  }
  
  private void onDestroyed(final Activity paramActivity)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onDestroyed(paramActivity);
      }
    });
  }
  
  private void onPaused(final Activity paramActivity)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onPaused(paramActivity);
      }
    });
  }
  
  private void onResumed(final Activity paramActivity)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onResumed(paramActivity);
      }
    });
  }
  
  private void onSaveInstanceState(final Activity paramActivity, final Bundle paramBundle)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onSaveInstanceState(paramActivity, paramBundle);
      }
    });
  }
  
  private void onStarted(final Activity paramActivity)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onStarted(paramActivity);
      }
    });
  }
  
  private void onStopped(final Activity paramActivity)
  {
    eachTracker(new EachTracker()
    {
      public void each(ActivityTracker.Tracker paramAnonymousTracker)
      {
        paramAnonymousTracker.onStopped(paramActivity);
      }
    });
  }
  
  public void addTracker(Tracker paramTracker)
  {
    synchronized (this.trackers)
    {
      this.trackers.add(paramTracker);
      return;
    }
  }
  
  public void removeTracker(Tracker paramTracker)
  {
    synchronized (this.trackers)
    {
      this.trackers.remove(paramTracker);
      return;
    }
  }
  
  private static abstract interface EachTracker
  {
    public abstract void each(ActivityTracker.Tracker paramTracker);
  }
  
  public static abstract interface Tracker
  {
    public abstract void onCreated(Activity paramActivity, Bundle paramBundle);
    
    public abstract void onDestroyed(Activity paramActivity);
    
    public abstract void onPaused(Activity paramActivity);
    
    public abstract void onResumed(Activity paramActivity);
    
    public abstract void onSaveInstanceState(Activity paramActivity, Bundle paramBundle);
    
    public abstract void onStarted(Activity paramActivity);
    
    public abstract void onStopped(Activity paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/ActivityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */