package com.growingio.android.sdk.collection;

import android.app.Application.ActivityLifecycleCallbacks;

public abstract interface ActivityLifecycleCallbacksRegistrar
{
  public abstract void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks);
  
  public abstract void unRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/ActivityLifecycleCallbacksRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */