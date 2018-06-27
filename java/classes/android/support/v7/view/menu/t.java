package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class t
  extends h
  implements SubMenu
{
  private j mItem;
  private h mParentMenu;
  
  public t(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.mParentMenu = paramh;
    this.mItem = paramj;
  }
  
  public boolean collapseItemActionView(j paramj)
  {
    return this.mParentMenu.collapseItemActionView(paramj);
  }
  
  boolean dispatchMenuItemSelected(h paramh, MenuItem paramMenuItem)
  {
    return (super.dispatchMenuItemSelected(paramh, paramMenuItem)) || (this.mParentMenu.dispatchMenuItemSelected(paramh, paramMenuItem));
  }
  
  public boolean expandItemActionView(j paramj)
  {
    return this.mParentMenu.expandItemActionView(paramj);
  }
  
  public String getActionViewStatesKey()
  {
    if (this.mItem != null) {}
    for (int i = this.mItem.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.getActionViewStatesKey() + ":" + i;
  }
  
  public MenuItem getItem()
  {
    return this.mItem;
  }
  
  public Menu getParentMenu()
  {
    return this.mParentMenu;
  }
  
  public h getRootMenu()
  {
    return this.mParentMenu.getRootMenu();
  }
  
  public boolean isQwertyMode()
  {
    return this.mParentMenu.isQwertyMode();
  }
  
  public boolean isShortcutsVisible()
  {
    return this.mParentMenu.isShortcutsVisible();
  }
  
  public void setCallback(h.a parama)
  {
    this.mParentMenu.setCallback(parama);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    return (SubMenu)super.setHeaderIconInt(paramInt);
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    return (SubMenu)super.setHeaderIconInt(paramDrawable);
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    return (SubMenu)super.setHeaderTitleInt(paramInt);
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    return (SubMenu)super.setHeaderTitleInt(paramCharSequence);
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    return (SubMenu)super.setHeaderViewInt(paramView);
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mParentMenu.setQwertyMode(paramBoolean);
  }
  
  public void setShortcutsVisible(boolean paramBoolean)
  {
    this.mParentMenu.setShortcutsVisible(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */