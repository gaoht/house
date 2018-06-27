package com.megvii.zhimasdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.megvii.zhimasdk.R.drawable;

public class CircleProgressBar
  extends View
{
  SweepGradient a = null;
  private final TextPaint b = new TextPaint();
  private int c = 100;
  private int d = 100;
  private Paint e = new Paint();
  private RectF f = new RectF();
  private int g = 20;
  private int h = 75;
  private Bitmap i = BitmapFactory.decodeResource(getResources(), R.drawable.mg_liveness_circle);
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getMax()
  {
    return this.d;
  }
  
  public int getProgress()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.e.setAntiAlias(true);
    this.e.setFlags(1);
    this.e.setColor(-16777216);
    this.e.setStrokeWidth(this.g);
    this.e.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.h + this.g, this.h + this.g, this.h, this.e);
    this.e.setColor(-12594716);
    this.f.set(this.g, this.g, this.h * 2 + this.g, this.h * 2 + this.g);
    paramCanvas.drawArc(this.f, -90.0F, 360.0F * (this.c / this.d), false, this.e);
    this.e.reset();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 > paramInt2) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      paramInt2 = this.g + this.h;
      this.g = (paramInt1 / 2 * this.g / paramInt2);
      this.h = (paramInt1 / 2 * this.h / paramInt2);
      setMeasuredDimension(paramInt1, paramInt1);
      return;
    }
  }
  
  public void setMax(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/view/CircleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */