package com.freelxl.baselibrary.widget.frescoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;

public abstract interface g
{
  public abstract float getScaleFactor();
  
  public abstract Matrix getTransform();
  
  public abstract boolean isEnabled();
  
  public abstract boolean isIdentity();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setImageBounds(RectF paramRectF);
  
  public abstract void setListener(a parama);
  
  public abstract void setViewBounds(RectF paramRectF);
  
  public abstract boolean wasTransformCorrected();
  
  public static abstract interface a
  {
    public abstract void onTransformChanged(Matrix paramMatrix);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */