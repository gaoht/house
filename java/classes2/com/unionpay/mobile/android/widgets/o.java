package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public final class o
  extends View
{
  private Paint a = new Paint();
  private int b;
  
  public o(Context paramContext)
  {
    this(paramContext, -7829368, 0);
  }
  
  public o(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(4.0F);
    this.a.setColor(paramInt1);
    this.a.setPathEffect(null);
    this.b = paramInt2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b == 0)
    {
      f = getHeight() >> 1;
      paramCanvas.drawLine(0.0F, f, getWidth(), f, this.a);
    }
    while (1 != this.b) {
      return;
    }
    float f = getWidth() >> 1;
    paramCanvas.drawLine(f, 0.0F, f, getHeight(), this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */