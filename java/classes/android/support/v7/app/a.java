package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class a
  implements DrawerLayout.DrawerListener
{
  boolean a = true;
  View.OnClickListener b;
  private final a c;
  private final DrawerLayout d;
  private android.support.v7.b.a.b e;
  private boolean f = true;
  private Drawable g;
  private boolean h;
  private final int i;
  private final int j;
  private boolean k = false;
  
  public a(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public a(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, int paramInt1, int paramInt2)
  {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  a(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, android.support.v7.b.a.b paramb, int paramInt1, int paramInt2)
  {
    if (paramToolbar != null)
    {
      this.c = new g(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (a.this.a) {
            a.this.a();
          }
          while (a.this.b == null) {
            return;
          }
          a.this.b.onClick(paramAnonymousView);
        }
      });
      this.d = paramDrawerLayout;
      this.i = paramInt1;
      this.j = paramInt2;
      if (paramb != null) {
        break label205;
      }
    }
    label205:
    for (this.e = new android.support.v7.b.a.b(this.c.getActionBarThemedContext());; this.e = paramb)
    {
      this.g = b();
      return;
      if ((paramActivity instanceof b))
      {
        this.c = ((b)paramActivity).getDrawerToggleDelegate();
        break;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.c = new f(paramActivity);
        break;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.c = new e(paramActivity);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.c = new d(paramActivity);
        break;
      }
      this.c = new c(paramActivity);
      break;
    }
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.e.setVerticalMirror(true);
    }
    for (;;)
    {
      this.e.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.e.setVerticalMirror(false);
      }
    }
  }
  
  void a()
  {
    int m = this.d.getDrawerLockMode(8388611);
    if ((this.d.isDrawerVisible(8388611)) && (m != 2)) {
      this.d.closeDrawer(8388611);
    }
    while (m == 1) {
      return;
    }
    this.d.openDrawer(8388611);
  }
  
  void a(int paramInt)
  {
    this.c.setActionBarDescription(paramInt);
  }
  
  void a(Drawable paramDrawable, int paramInt)
  {
    if ((!this.k) && (!this.c.isNavigationVisible()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.k = true;
    }
    this.c.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  Drawable b()
  {
    return this.c.getThemeUpIndicator();
  }
  
  public android.support.v7.b.a.b getDrawerArrowDrawable()
  {
    return this.e;
  }
  
  public View.OnClickListener getToolbarNavigationClickListener()
  {
    return this.b;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.a;
  }
  
  public boolean isDrawerSlideAnimationEnabled()
  {
    return this.f;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.h) {
      this.g = b();
    }
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    a(0.0F);
    if (this.a) {
      a(this.i);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    a(1.0F);
    if (this.a) {
      a(this.j);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    if (this.f)
    {
      a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    a(0.0F);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  @Instrumented
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    VdsAgent.onOptionsItemSelected(this, paramMenuItem);
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.a))
    {
      a();
      VdsAgent.handleClickResult(new Boolean(true));
      return true;
    }
    VdsAgent.handleClickResult(new Boolean(false));
    return false;
  }
  
  public void setDrawerArrowDrawable(android.support.v7.b.a.b paramb)
  {
    this.e = paramb;
    syncState();
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int m;
    if (paramBoolean != this.a)
    {
      if (!paramBoolean) {
        break label54;
      }
      android.support.v7.b.a.b localb = this.e;
      if (!this.d.isDrawerOpen(8388611)) {
        break label46;
      }
      m = this.j;
      a(localb, m);
    }
    for (;;)
    {
      this.a = paramBoolean;
      return;
      label46:
      m = this.i;
      break;
      label54:
      a(this.g, 0);
    }
  }
  
  public void setDrawerSlideAnimationEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (!paramBoolean) {
      a(0.0F);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = this.d.getResources().getDrawable(paramInt);
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      this.g = b();
    }
    for (this.h = false;; this.h = true)
    {
      if (!this.a) {
        a(this.g, 0);
      }
      return;
      this.g = paramDrawable;
    }
  }
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void syncState()
  {
    android.support.v7.b.a.b localb;
    if (this.d.isDrawerOpen(8388611))
    {
      a(1.0F);
      if (this.a)
      {
        localb = this.e;
        if (!this.d.isDrawerOpen(8388611)) {
          break label61;
        }
      }
    }
    label61:
    for (int m = this.j;; m = this.i)
    {
      a(localb, m);
      return;
      a(0.0F);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract Context getActionBarThemedContext();
    
    public abstract Drawable getThemeUpIndicator();
    
    public abstract boolean isNavigationVisible();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract a.a getDrawerToggleDelegate();
  }
  
  static class c
    implements a.a
  {
    final Activity a;
    
    c(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      return this.a;
    }
    
    public Drawable getThemeUpIndicator()
    {
      return null;
    }
    
    public boolean isNavigationVisible()
    {
      return true;
    }
    
    public void setActionBarDescription(int paramInt) {}
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt) {}
  }
  
  private static class d
    implements a.a
  {
    final Activity a;
    b.a b;
    
    d(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      return this.a;
    }
    
    public Drawable getThemeUpIndicator()
    {
      return b.getThemeUpIndicator(this.a);
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = this.a.getActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      this.b = b.setActionBarDescription(this.b, this.a, paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null)
      {
        localActionBar.setDisplayShowHomeEnabled(true);
        this.b = b.setActionBarUpIndicator(this.b, this.a, paramDrawable, paramInt);
        localActionBar.setDisplayShowHomeEnabled(false);
      }
    }
  }
  
  private static class e
    extends a.d
  {
    e(Activity paramActivity)
    {
      super();
    }
    
    public Context getActionBarThemedContext()
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null) {
        return localActionBar.getThemedContext();
      }
      return this.a;
    }
  }
  
  private static class f
    implements a.a
  {
    final Activity a;
    
    f(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null) {
        return localActionBar.getThemedContext();
      }
      return this.a;
    }
    
    public Drawable getThemeUpIndicator()
    {
      TypedArray localTypedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
      Drawable localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = this.a.getActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  static class g
    implements a.a
  {
    final Toolbar a;
    final Drawable b;
    final CharSequence c;
    
    g(Toolbar paramToolbar)
    {
      this.a = paramToolbar;
      this.b = paramToolbar.getNavigationIcon();
      this.c = paramToolbar.getNavigationContentDescription();
    }
    
    public Context getActionBarThemedContext()
    {
      return this.a.getContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      return this.b;
    }
    
    public boolean isNavigationVisible()
    {
      return true;
    }
    
    public void setActionBarDescription(int paramInt)
    {
      if (paramInt == 0)
      {
        this.a.setNavigationContentDescription(this.c);
        return;
      }
      this.a.setNavigationContentDescription(paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      this.a.setNavigationIcon(paramDrawable);
      setActionBarDescription(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */