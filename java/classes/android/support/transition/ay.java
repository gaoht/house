package android.support.transition;

import android.graphics.Matrix;
import android.view.View;

abstract interface ay
{
  public abstract void clearNonTransitionAlpha(View paramView);
  
  public abstract ar getOverlay(View paramView);
  
  public abstract float getTransitionAlpha(View paramView);
  
  public abstract bc getWindowId(View paramView);
  
  public abstract void saveNonTransitionAlpha(View paramView);
  
  public abstract void setAnimationMatrix(View paramView, Matrix paramMatrix);
  
  public abstract void setLeftTopRightBottom(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setTransitionAlpha(View paramView, float paramFloat);
  
  public abstract void transformMatrixToGlobal(View paramView, Matrix paramMatrix);
  
  public abstract void transformMatrixToLocal(View paramView, Matrix paramMatrix);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */