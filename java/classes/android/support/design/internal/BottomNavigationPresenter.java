package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.n.a;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.t;
import android.view.ViewGroup;

public class BottomNavigationPresenter
  implements n
{
  private int mId;
  private h mMenu;
  private BottomNavigationMenuView mMenuView;
  private boolean mUpdateSuspended = false;
  
  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public o getMenuView(ViewGroup paramViewGroup)
  {
    return this.mMenuView;
  }
  
  public void initForMenu(Context paramContext, h paramh)
  {
    this.mMenuView.initialize(this.mMenu);
    this.mMenu = paramh;
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState)) {
      this.mMenuView.tryRestoreSelectedItemId(((SavedState)paramParcelable).selectedItemId);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.selectedItemId = this.mMenuView.getSelectedItemId();
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    return false;
  }
  
  public void setBottomNavigationMenuView(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    this.mMenuView = paramBottomNavigationMenuView;
  }
  
  public void setCallback(n.a parama) {}
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    this.mUpdateSuspended = paramBoolean;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.mUpdateSuspended) {
      return;
    }
    if (paramBoolean)
    {
      this.mMenuView.buildMenuView();
      return;
    }
    this.mMenuView.updateMenuView();
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public BottomNavigationPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomNavigationPresenter.SavedState(paramAnonymousParcel);
      }
      
      public BottomNavigationPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationPresenter.SavedState[paramAnonymousInt];
      }
    };
    int selectedItemId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.selectedItemId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.selectedItemId);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/internal/BottomNavigationPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */