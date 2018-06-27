package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

abstract interface h
{
  public abstract void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView);
  
  public abstract void setVisibility(int paramInt);
  
  public static abstract interface a
  {
    public abstract h addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix);
    
    public abstract void removeGhost(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */