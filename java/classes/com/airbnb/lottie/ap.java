package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class ap
  extends o
{
  private final Paint e = new Paint(3);
  private final Rect f = new Rect();
  private final Rect g = new Rect();
  private final float h;
  
  ap(ax paramax, av paramav, float paramFloat)
  {
    super(paramax, paramav);
    this.h = paramFloat;
  }
  
  private Bitmap d()
  {
    String str = this.c.e();
    return this.b.a(str);
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = d();
    if (localBitmap == null) {
      return;
    }
    this.e.setAlpha(paramInt);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.f.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.g.set(0, 0, (int)(localBitmap.getWidth() * this.h), (int)(localBitmap.getHeight() * this.h));
    paramCanvas.drawBitmap(localBitmap, this.f, this.g, this.e);
    paramCanvas.restore();
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    paramMatrix = d();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.a.mapRect(paramRectF);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */