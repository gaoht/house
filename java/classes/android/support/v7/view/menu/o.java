package android.support.v7.view.menu;

import android.graphics.drawable.Drawable;

public abstract interface o
{
  public abstract int getWindowAnimations();
  
  public abstract void initialize(h paramh);
  
  public static abstract interface a
  {
    public abstract j getItemData();
    
    public abstract void initialize(j paramj, int paramInt);
    
    public abstract boolean prefersCondensedTitle();
    
    public abstract void setCheckable(boolean paramBoolean);
    
    public abstract void setChecked(boolean paramBoolean);
    
    public abstract void setEnabled(boolean paramBoolean);
    
    public abstract void setIcon(Drawable paramDrawable);
    
    public abstract void setShortcut(boolean paramBoolean, char paramChar);
    
    public abstract void setTitle(CharSequence paramCharSequence);
    
    public abstract boolean showsIcon();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */