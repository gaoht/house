package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;

public class RootDrawable
  extends ForwardingDrawable
  implements VisibilityAwareDrawable
{
  @Nullable
  @VisibleForTesting
  Drawable mControllerOverlay = null;
  @Nullable
  private VisibilityCallback mVisibilityCallback;
  
  public RootDrawable(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  @SuppressLint({"WrongCall"})
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {}
    do
    {
      return;
      if (this.mVisibilityCallback != null) {
        this.mVisibilityCallback.onDraw();
      }
      super.draw(paramCanvas);
    } while (this.mControllerOverlay == null);
    this.mControllerOverlay.setBounds(getBounds());
    this.mControllerOverlay.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    invalidateSelf();
  }
  
  public void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
  {
    this.mVisibilityCallback = paramVisibilityCallback;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mVisibilityCallback != null) {
      this.mVisibilityCallback.onVisibilityChange(paramBoolean1);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/generic/RootDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */