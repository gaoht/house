package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Method;

public class MenuItemWrapperICS
  extends c<SupportMenuItem>
  implements MenuItem
{
  private Method c;
  
  MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  a a(android.view.ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((SupportMenuItem)this.b).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((SupportMenuItem)this.b).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    android.support.v4.view.ActionProvider localActionProvider = ((SupportMenuItem)this.b).getSupportActionProvider();
    if ((localActionProvider instanceof a)) {
      return ((a)localActionProvider).a;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((SupportMenuItem)this.b).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof CollapsibleActionViewWrapper)) {
      localView1 = ((CollapsibleActionViewWrapper)localView2).a();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((SupportMenuItem)this.b).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((SupportMenuItem)this.b).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((SupportMenuItem)this.b).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((SupportMenuItem)this.b).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((SupportMenuItem)this.b).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((SupportMenuItem)this.b).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((SupportMenuItem)this.b).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((SupportMenuItem)this.b).getIntent();
  }
  
  public int getItemId()
  {
    return ((SupportMenuItem)this.b).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((SupportMenuItem)this.b).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((SupportMenuItem)this.b).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((SupportMenuItem)this.b).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((SupportMenuItem)this.b).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((SupportMenuItem)this.b).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((SupportMenuItem)this.b).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((SupportMenuItem)this.b).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((SupportMenuItem)this.b).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((SupportMenuItem)this.b).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((SupportMenuItem)this.b).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((SupportMenuItem)this.b).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((SupportMenuItem)this.b).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((SupportMenuItem)this.b).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((SupportMenuItem)this.b).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localSupportMenuItem.setSupportActionProvider(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((SupportMenuItem)this.b).setActionView(paramInt);
    View localView = ((SupportMenuItem)this.b).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((SupportMenuItem)this.b).setActionView(new CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new CollapsibleActionViewWrapper(paramView);
    }
    ((SupportMenuItem)this.b).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((SupportMenuItem)this.b).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((SupportMenuItem)this.b).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.c == null) {
        this.c = ((SupportMenuItem)this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
      this.c.invoke(this.b, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((SupportMenuItem)this.b).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((SupportMenuItem)this.b).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((SupportMenuItem)this.b).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((SupportMenuItem)this.b).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((SupportMenuItem)this.b).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((SupportMenuItem)this.b).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((SupportMenuItem)this.b).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new b(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localSupportMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new c(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localSupportMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((SupportMenuItem)this.b).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((SupportMenuItem)this.b).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((SupportMenuItem)this.b).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((SupportMenuItem)this.b).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((SupportMenuItem)this.b).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((SupportMenuItem)this.b).setVisible(paramBoolean);
  }
  
  static class CollapsibleActionViewWrapper
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView a;
    
    CollapsibleActionViewWrapper(View paramView)
    {
      super();
      this.a = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    View a()
    {
      return (View)this.a;
    }
    
    public void onActionViewCollapsed()
    {
      this.a.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded()
    {
      this.a.onActionViewExpanded();
    }
  }
  
  class a
    extends android.support.v4.view.ActionProvider
  {
    final android.view.ActionProvider a;
    
    public a(Context paramContext, android.view.ActionProvider paramActionProvider)
    {
      super();
      this.a = paramActionProvider;
    }
    
    public boolean hasSubMenu()
    {
      return this.a.hasSubMenu();
    }
    
    public View onCreateActionView()
    {
      return this.a.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction()
    {
      return this.a.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.a.onPrepareSubMenu(MenuItemWrapperICS.this.a(paramSubMenu));
    }
  }
  
  private class b
    extends d<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    b(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionCollapse(MenuItemWrapperICS.this.a(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionExpand(MenuItemWrapperICS.this.a(paramMenuItem));
    }
  }
  
  private class c
    extends d<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    c(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    @Instrumented
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      VdsAgent.onMenuItemClick(this, paramMenuItem);
      boolean bool = ((MenuItem.OnMenuItemClickListener)this.b).onMenuItemClick(MenuItemWrapperICS.this.a(paramMenuItem));
      VdsAgent.handleClickResult(new Boolean(bool));
      return bool;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/MenuItemWrapperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */