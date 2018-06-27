package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.ziroom.ziroomcustomer.R.styleable;

public class DashView
  extends View
{
  private float a;
  private float b;
  private float c;
  private int d;
  private int e;
  private Paint f = new Paint(1);
  private int g;
  private int h;
  
  public DashView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DashView);
    this.a = paramContext.getDimension(0, 100.0F);
    this.b = paramContext.getDimension(2, 10.0F);
    this.c = paramContext.getDimension(1, 100.0F);
    this.d = paramContext.getColor(3, 10395294);
    this.e = paramContext.getInteger(4, 0);
    this.f.setColor(this.d);
    this.f.setStrokeWidth(this.b);
    paramContext.recycle();
  }
  
  public void drawHorizontalLine(Canvas paramCanvas)
  {
    paramCanvas.save();
    float f2 = this.c;
    paramCanvas.translate(0.0F, this.b / 2.0F);
    for (float f1 = 0.0F; f1 <= this.g; f1 += this.c + this.a)
    {
      Paint localPaint = this.f;
      paramCanvas.drawLines(new float[] { 0.0F, 0.0F, f2, 0.0F }, localPaint);
      paramCanvas.translate(this.c + this.a, 0.0F);
    }
    paramCanvas.restore();
  }
  
  public void drawVerticalLine(Canvas paramCanvas)
  {
    paramCanvas.save();
    float f2 = this.c;
    paramCanvas.translate(this.b / 2.0F, 0.0F);
    for (float f1 = 0.0F; f1 <= this.h; f1 += this.c + this.a)
    {
      Paint localPaint = this.f;
      paramCanvas.drawLines(new float[] { 0.0F, 0.0F, 0.0F, f2 }, localPaint);
      paramCanvas.translate(0.0F, this.c + this.a);
    }
    paramCanvas.restore();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.e)
    {
    default: 
      drawHorizontalLine(paramCanvas);
      return;
    }
    drawVerticalLine(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.g = (View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight());
    this.h = View.MeasureSpec.getSize(paramInt2 - getPaddingTop() - getPaddingBottom());
    Log.d("DashView", "onMeasure: " + this.g + "----" + this.h);
    Log.d("DashView", "dashOrientation: " + this.e);
    if (this.e == 0)
    {
      setMeasuredDimension(this.g, (int)this.b);
      return;
    }
    setMeasuredDimension((int)this.b, this.h);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/DashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */