package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.n.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.support.v7.widget.au;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;

class o
  extends ActionBar
{
  u a;
  boolean b;
  Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<ActionBar.a> f = new ArrayList();
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      o.this.b();
    }
  };
  private final Toolbar.b h = new Toolbar.b()
  {
    @Instrumented
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      VdsAgent.onMenuItemClick(this, paramAnonymousMenuItem);
      boolean bool = o.this.c.onMenuItemSelected(0, paramAnonymousMenuItem);
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    }
  };
  
  o(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new au(paramToolbar, false);
    this.c = new c(paramCallback);
    this.a.setWindowCallback(this.c);
    paramToolbar.setOnMenuItemClickListener(this.h);
    this.a.setWindowTitle(paramCharSequence);
  }
  
  private Menu c()
  {
    if (!this.d)
    {
      this.a.setMenuCallbacks(new a(), new b());
      this.d = true;
    }
    return this.a.getMenu();
  }
  
  void a()
  {
    this.a.getViewGroup().removeCallbacks(this.g);
  }
  
  public void addOnMenuVisibilityListener(ActionBar.a parama)
  {
    this.f.add(parama);
  }
  
  public void addTab(ActionBar.c paramc)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.c paramc, int paramInt)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.c paramc, int paramInt, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.c paramc, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  void b()
  {
    Menu localMenu = c();
    if ((localMenu instanceof h)) {}
    for (localh = (h)localMenu;; localh = null)
    {
      if (localh != null) {
        localh.stopDispatchingItemsChanged();
      }
      try
      {
        localMenu.clear();
        if ((!this.c.onCreatePanelMenu(0, localMenu)) || (!this.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localh == null) {
          break;
        }
        localh.startDispatchingItemsChanged();
      }
    }
  }
  
  public boolean closeOptionsMenu()
  {
    return this.a.hideOverflowMenu();
  }
  
  public boolean collapseActionView()
  {
    if (this.a.hasExpandedActionView())
    {
      this.a.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == this.e) {}
    for (;;)
    {
      return;
      this.e = paramBoolean;
      int j = this.f.size();
      int i = 0;
      while (i < j)
      {
        ((ActionBar.a)this.f.get(i)).onMenuVisibilityChanged(paramBoolean);
        i += 1;
      }
    }
  }
  
  public View getCustomView()
  {
    return this.a.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return this.a.getDisplayOptions();
  }
  
  public float getElevation()
  {
    return ViewCompat.getElevation(this.a.getViewGroup());
  }
  
  public int getHeight()
  {
    return this.a.getHeight();
  }
  
  public int getNavigationItemCount()
  {
    return 0;
  }
  
  public int getNavigationMode()
  {
    return 0;
  }
  
  public int getSelectedNavigationIndex()
  {
    return -1;
  }
  
  public ActionBar.c getSelectedTab()
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public CharSequence getSubtitle()
  {
    return this.a.getSubtitle();
  }
  
  public ActionBar.c getTabAt(int paramInt)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public int getTabCount()
  {
    return 0;
  }
  
  public Context getThemedContext()
  {
    return this.a.getContext();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public Window.Callback getWrappedWindowCallback()
  {
    return this.c;
  }
  
  public void hide()
  {
    this.a.setVisibility(8);
  }
  
  public boolean invalidateOptionsMenu()
  {
    this.a.getViewGroup().removeCallbacks(this.g);
    ViewCompat.postOnAnimation(this.a.getViewGroup(), this.g);
    return true;
  }
  
  public boolean isShowing()
  {
    return this.a.getVisibility() == 0;
  }
  
  public boolean isTitleTruncated()
  {
    return super.isTitleTruncated();
  }
  
  public ActionBar.c newTab()
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    Menu localMenu = c();
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label61;
      }
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label66;
      }
    }
    label61:
    label66:
    for (bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      bool = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return bool;
      i = -1;
      break;
    }
  }
  
  public boolean onMenuKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      openOptionsMenu();
    }
    return true;
  }
  
  public boolean openOptionsMenu()
  {
    return this.a.showOverflowMenu();
  }
  
  public void removeAllTabs()
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.a parama)
  {
    this.f.remove(parama);
  }
  
  public void removeTab(ActionBar.c paramc)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void removeTabAt(int paramInt)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public boolean requestFocus()
  {
    ViewGroup localViewGroup = this.a.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public void selectTab(ActionBar.c paramc)
  {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.a.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.a.getContext()).inflate(paramInt, this.a.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView)
  {
    setCustomView(paramView, new ActionBar.LayoutParams(-2, -2));
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.a.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    setDisplayOptions(paramInt, -1);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.a.getDisplayOptions();
    this.a.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      setDisplayOptions(i, 16);
      return;
    }
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      setDisplayOptions(i, 2);
      return;
    }
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setDisplayOptions(i, 8);
      return;
    }
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      setDisplayOptions(i, 1);
      return;
    }
  }
  
  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(this.a.getViewGroup(), paramFloat);
  }
  
  public void setHomeActionContentDescription(int paramInt)
  {
    this.a.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence)
  {
    this.a.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    this.a.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    this.a.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt)
  {
    this.a.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.a.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.b paramb)
  {
    this.a.setDropdownParams(paramSpinnerAdapter, new m(paramb));
  }
  
  public void setLogo(int paramInt)
  {
    this.a.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.a.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    if (paramInt == 2) {
      throw new IllegalArgumentException("Tabs not supported in this configuration");
    }
    this.a.setNavigationMode(paramInt);
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    switch (this.a.getNavigationMode())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }
    this.a.setDropdownSelectedPosition(paramInt);
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setSubtitle(int paramInt)
  {
    u localu = this.a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = this.a.getContext().getText(paramInt);; localCharSequence = null)
    {
      localu.setSubtitle(localCharSequence);
      return;
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.a.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    u localu = this.a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = this.a.getContext().getText(paramInt);; localCharSequence = null)
    {
      localu.setTitle(localCharSequence);
      return;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    this.a.setWindowTitle(paramCharSequence);
  }
  
  public void show()
  {
    this.a.setVisibility(0);
  }
  
  private final class a
    implements n.a
  {
    private boolean b;
    
    a() {}
    
    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      o.this.a.dismissPopupMenus();
      if (o.this.c != null) {
        o.this.c.onPanelClosed(108, paramh);
      }
      this.b = false;
    }
    
    public boolean onOpenSubMenu(h paramh)
    {
      if (o.this.c != null)
      {
        o.this.c.onMenuOpened(108, paramh);
        return true;
      }
      return false;
    }
  }
  
  private final class b
    implements h.a
  {
    b() {}
    
    public boolean onMenuItemSelected(h paramh, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public void onMenuModeChange(h paramh)
    {
      if (o.this.c != null)
      {
        if (!o.this.a.isOverflowMenuShowing()) {
          break label41;
        }
        o.this.c.onPanelClosed(108, paramh);
      }
      label41:
      while (!o.this.c.onPreparePanel(0, null, paramh)) {
        return;
      }
      o.this.c.onMenuOpened(108, paramh);
    }
  }
  
  private class c
    extends i
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(o.this.a.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!o.this.b))
      {
        o.this.a.setMenuPrepared();
        o.this.b = true;
      }
      return bool;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */