package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

class bw
  extends o
{
  private final y e;
  
  bw(ax paramax, av paramav)
  {
    super(paramax, paramav);
    this.e = new y(paramax, this, new bu(paramav.d(), paramav.l()));
    this.e.setContents(Collections.emptyList(), Collections.emptyList());
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.addColorFilter(paramString1, paramString2, paramColorFilter);
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.e.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    this.e.getBounds(paramRectF, this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */