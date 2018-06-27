package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class e
{
  private static int a = -1;
  private static boolean b = false;
  
  private static e a(Context paramContext, Window paramWindow, d paramd)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new g(paramContext, paramWindow, paramd);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new j(paramContext, paramWindow, paramd);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new i(paramContext, paramWindow, paramd);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new h(paramContext, paramWindow, paramd);
    }
    return new AppCompatDelegateImplV9(paramContext, paramWindow, paramd);
  }
  
  public static e create(Activity paramActivity, d paramd)
  {
    return a(paramActivity, paramActivity.getWindow(), paramd);
  }
  
  public static e create(Dialog paramDialog, d paramd)
  {
    return a(paramDialog.getContext(), paramDialog.getWindow(), paramd);
  }
  
  public static int getDefaultNightMode()
  {
    return a;
  }
  
  public static boolean isCompatVectorFromResourcesEnabled()
  {
    return b;
  }
  
  public static void setCompatVectorFromResourcesEnabled(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void setDefaultNightMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
      return;
    }
    a = paramInt;
  }
  
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract boolean applyDayNight();
  
  public abstract View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract <T extends View> T findViewById(int paramInt);
  
  public abstract a.a getDrawerToggleDelegate();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract ActionBar getSupportActionBar();
  
  public abstract boolean hasWindowFeature(int paramInt);
  
  public abstract void installViewFactory();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract boolean isHandleNativeActionModesEnabled();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPostCreate(Bundle paramBundle);
  
  public abstract void onPostResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract boolean requestWindowFeature(int paramInt);
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setHandleNativeActionModesEnabled(boolean paramBoolean);
  
  public abstract void setLocalNightMode(int paramInt);
  
  public abstract void setSupportActionBar(Toolbar paramToolbar);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract b startSupportActionMode(b.a parama);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */