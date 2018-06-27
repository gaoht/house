package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.at;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class f
  extends e
{
  private static boolean m;
  private static final boolean n;
  private static final int[] o;
  final Context a;
  final Window b;
  final Window.Callback c;
  final Window.Callback d;
  final d e;
  ActionBar f;
  MenuInflater g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  private CharSequence p;
  private boolean q;
  private boolean r;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      n = bool;
      if ((n) && (!m))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          private boolean a(Throwable paramAnonymousThrowable)
          {
            boolean bool2 = false;
            boolean bool1 = bool2;
            if ((paramAnonymousThrowable instanceof Resources.NotFoundException))
            {
              paramAnonymousThrowable = paramAnonymousThrowable.getMessage();
              bool1 = bool2;
              if (paramAnonymousThrowable != null) {
                if (!paramAnonymousThrowable.contains("drawable"))
                {
                  bool1 = bool2;
                  if (!paramAnonymousThrowable.contains("Drawable")) {}
                }
                else
                {
                  bool1 = true;
                }
              }
            }
            return bool1;
          }
          
          public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            if (a(paramAnonymousThrowable))
            {
              Resources.NotFoundException localNotFoundException = new Resources.NotFoundException(paramAnonymousThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
              localNotFoundException.initCause(paramAnonymousThrowable.getCause());
              localNotFoundException.setStackTrace(paramAnonymousThrowable.getStackTrace());
              this.a.uncaughtException(paramAnonymousThread, localNotFoundException);
              return;
            }
            this.a.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        m = true;
      }
      o = new int[] { 16842836 };
      return;
    }
  }
  
  f(Context paramContext, Window paramWindow, d paramd)
  {
    this.a = paramContext;
    this.b = paramWindow;
    this.e = paramd;
    this.c = this.b.getCallback();
    if ((this.c instanceof b)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.d = a(this.c);
    this.b.setCallback(this.d);
    paramContext = at.obtainStyledAttributes(paramContext, null, o);
    paramWindow = paramContext.getDrawableIfKnown(0);
    if (paramWindow != null) {
      this.b.setBackgroundDrawable(paramWindow);
    }
    paramContext.recycle();
  }
  
  final ActionBar a()
  {
    return this.f;
  }
  
  abstract b a(b.a parama);
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new b(paramCallback);
  }
  
  abstract void a(int paramInt, Menu paramMenu);
  
  abstract void a(CharSequence paramCharSequence);
  
  abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean a(KeyEvent paramKeyEvent);
  
  public boolean applyDayNight()
  {
    return false;
  }
  
  final Context b()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.a;
    }
    return (Context)localObject;
  }
  
  abstract boolean b(int paramInt, Menu paramMenu);
  
  final boolean c()
  {
    return this.r;
  }
  
  final Window.Callback d()
  {
    return this.b.getCallback();
  }
  
  final CharSequence e()
  {
    if ((this.c instanceof Activity)) {
      return ((Activity)this.c).getTitle();
    }
    return this.p;
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public MenuInflater getMenuInflater()
  {
    if (this.g == null)
    {
      initWindowDecorActionBar();
      if (this.f == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.f.getThemedContext();; localContext = this.a)
    {
      this.g = new g(localContext);
      return this.g;
    }
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.f;
  }
  
  abstract void initWindowDecorActionBar();
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return false;
  }
  
  public void onDestroy()
  {
    this.r = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.q = true;
  }
  
  public void onStop()
  {
    this.q = false;
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean) {}
  
  public void setLocalNightMode(int paramInt) {}
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    a(paramCharSequence);
  }
  
  private class a
    implements a.a
  {
    a() {}
    
    public Context getActionBarThemedContext()
    {
      return f.this.b();
    }
    
    public Drawable getThemeUpIndicator()
    {
      at localat = at.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
      Drawable localDrawable = localat.getDrawable(0);
      localat.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = f.this.getSupportActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = f.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = f.this.getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  class b
    extends i
  {
    b(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (f.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (f.this.a(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof h))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      f.this.b(paramInt, paramMenu);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      f.this.a(paramInt, paramMenu);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      h localh;
      boolean bool1;
      if ((paramMenu instanceof h))
      {
        localh = (h)paramMenu;
        if ((paramInt != 0) || (localh != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localh = null;
        break;
        if (localh != null) {
          localh.setOverrideVisibleItems(true);
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.setOverrideVisibleItems(false);
      return bool2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */