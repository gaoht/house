package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.t;

public class NavigationSubMenu
  extends t
{
  public NavigationSubMenu(Context paramContext, NavigationMenu paramNavigationMenu, j paramj)
  {
    super(paramContext, paramNavigationMenu, paramj);
  }
  
  public void onItemsChanged(boolean paramBoolean)
  {
    super.onItemsChanged(paramBoolean);
    ((h)getParentMenu()).onItemsChanged(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/internal/NavigationSubMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */