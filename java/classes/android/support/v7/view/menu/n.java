package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

public abstract interface n
{
  public abstract boolean collapseItemActionView(h paramh, j paramj);
  
  public abstract boolean expandItemActionView(h paramh, j paramj);
  
  public abstract boolean flagActionItems();
  
  public abstract int getId();
  
  public abstract o getMenuView(ViewGroup paramViewGroup);
  
  public abstract void initForMenu(Context paramContext, h paramh);
  
  public abstract void onCloseMenu(h paramh, boolean paramBoolean);
  
  public abstract void onRestoreInstanceState(Parcelable paramParcelable);
  
  public abstract Parcelable onSaveInstanceState();
  
  public abstract boolean onSubMenuSelected(t paramt);
  
  public abstract void setCallback(a parama);
  
  public abstract void updateMenuView(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void onCloseMenu(h paramh, boolean paramBoolean);
    
    public abstract boolean onOpenSubMenu(h paramh);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */