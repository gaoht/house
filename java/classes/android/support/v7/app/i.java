package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.f.a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class i
  extends h
{
  private int t = -100;
  private boolean u;
  private boolean v = true;
  private b w;
  
  i(Context paramContext, Window paramWindow, d paramd)
  {
    super(paramContext, paramWindow, paramd);
  }
  
  private boolean e(int paramInt)
  {
    Resources localResources = this.a.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label117;
      }
      if (!l()) {
        break label61;
      }
      ((Activity)this.a).recreate();
    }
    for (;;)
    {
      return true;
      paramInt = 16;
      break;
      label61:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        n.a(localResources);
      }
    }
    label117:
    return false;
  }
  
  private int j()
  {
    if (this.t != -100) {
      return this.t;
    }
    return getDefaultNightMode();
  }
  
  private void k()
  {
    if (this.w == null) {
      this.w = new b(q.a(this.a));
    }
  }
  
  private boolean l()
  {
    if ((this.u) && ((this.a instanceof Activity)))
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      try
      {
        int i = localPackageManager.getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges;
        return (i & 0x200) == 0;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        return true;
      }
    }
    return false;
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      k();
      return this.w.a();
    }
    return -1;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  public boolean applyDayNight()
  {
    boolean bool = false;
    int i = j();
    int j = a(i);
    if (j != -1) {
      bool = e(j);
    }
    if (i == 0)
    {
      k();
      this.w.c();
    }
    this.u = true;
    return bool;
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.v;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.t == -100)) {
      this.t = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.w != null) {
      this.w.d();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.t != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.t);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    applyDayNight();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.w != null) {
      this.w.d();
    }
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      do
      {
        return;
      } while (this.t == paramInt);
      this.t = paramInt;
    } while (!this.u);
    applyDayNight();
  }
  
  class a
    extends f.b
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(i.this.a, paramCallback);
      b localb = i.this.startSupportActionMode(paramCallback);
      if (localb != null) {
        return paramCallback.getActionModeWrapper(localb);
      }
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (i.this.isHandleNativeActionModesEnabled()) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
  
  final class b
  {
    private q b;
    private boolean c;
    private BroadcastReceiver d;
    private IntentFilter e;
    
    b(q paramq)
    {
      this.b = paramq;
      this.c = paramq.a();
    }
    
    final int a()
    {
      this.c = this.b.a();
      if (this.c) {
        return 2;
      }
      return 1;
    }
    
    final void b()
    {
      boolean bool = this.b.a();
      if (bool != this.c)
      {
        this.c = bool;
        i.this.applyDayNight();
      }
    }
    
    final void c()
    {
      d();
      if (this.d == null) {
        this.d = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            i.b.this.b();
          }
        };
      }
      if (this.e == null)
      {
        this.e = new IntentFilter();
        this.e.addAction("android.intent.action.TIME_SET");
        this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.e.addAction("android.intent.action.TIME_TICK");
      }
      i.this.a.registerReceiver(this.d, this.e);
    }
    
    final void d()
    {
      if (this.d != null)
      {
        i.this.a.unregisterReceiver(this.d);
        this.d = null;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */