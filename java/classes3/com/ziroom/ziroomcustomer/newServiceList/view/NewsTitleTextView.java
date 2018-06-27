package com.ziroom.ziroomcustomer.newServiceList.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class NewsTitleTextView
  extends TextView
{
  private boolean a = false;
  private boolean b = false;
  private int c = -1644826;
  private int d = 33792;
  private float e;
  private float f = 3.0F;
  private float g = 0.0F;
  
  public NewsTitleTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public NewsTitleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NewsTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Paint localPaint;
    if (this.a)
    {
      localPaint = new Paint();
      localPaint.setColor(this.c);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setStrokeWidth(0.25F);
      paramCanvas.drawRect(0.0F, 15.0F, this.e * 1.0F, getHeight() - 15, localPaint);
    }
    if (this.b)
    {
      localPaint = new Paint();
      localPaint.setColor(this.d);
      localPaint.setStyle(Paint.Style.FILL);
      if (this.g <= 0.0F) {
        this.g = getWidth();
      }
      float f1 = (getWidth() - this.g) / 2.0F;
      float f2 = getHeight();
      float f3 = this.f;
      float f4 = (getWidth() - this.g) / 2.0F;
      paramCanvas.drawRect(f1, f2 - f3, this.g + f4, getHeight(), localPaint);
    }
  }
  
  public void init(Context paramContext)
  {
    setGravity(17);
    setTextColor(-16777216);
    setBackgroundColor(-1);
    setTextSize(15.0F);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.e = localDisplayMetrics.density;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setHorizontalineColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setIsHorizontaline(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
  }
  
  public void setIsVerticalLine(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setLineSize(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    this.f = paramFloat2;
  }
  
  public void setVerticalLineColor(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/NewsTitleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */