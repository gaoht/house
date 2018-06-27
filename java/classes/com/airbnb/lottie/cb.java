package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

class cb
  extends o
{
  private final RectF e = new RectF();
  private final Paint f = new Paint();
  private final av g;
  
  cb(ax paramax, av paramav)
  {
    super(paramax, paramav);
    this.g = paramav;
    this.f.setAlpha(0);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(paramav.n());
  }
  
  private void a(Matrix paramMatrix)
  {
    this.e.set(0.0F, 0.0F, this.g.p(), this.g.o());
    paramMatrix.mapRect(this.e);
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.f.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramInt = Color.alpha(this.g.n());
    if (paramInt == 0) {}
    do
    {
      return;
      float f1 = paramInt / 255.0F;
      paramInt = (int)(((Integer)this.d.a().getValue()).intValue() * f1 / 100.0F * 255.0F);
      this.f.setAlpha(paramInt);
    } while (paramInt <= 0);
    a(paramMatrix);
    paramCanvas.drawRect(this.e, this.f);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    a(this.a);
    paramRectF.set(this.e);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */