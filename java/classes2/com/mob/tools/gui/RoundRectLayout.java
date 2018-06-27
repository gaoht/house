package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundRectLayout
  extends RelativeLayout
{
  private Path path;
  private float[] rect;
  
  public RoundRectLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundRectLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundRectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.rect != null)
    {
      if (this.path == null)
      {
        int i = getWidth();
        int j = getHeight();
        this.path = new Path();
        RectF localRectF = new RectF(0.0F, 0.0F, i, j);
        this.path.addRoundRect(localRectF, this.rect, Path.Direction.CW);
      }
      paramCanvas.clipPath(this.path);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setRound(float paramFloat)
  {
    setRound(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setRound(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.rect = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/RoundRectLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */