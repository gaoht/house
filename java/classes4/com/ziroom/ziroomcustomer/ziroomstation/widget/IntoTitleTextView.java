package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class IntoTitleTextView
  extends TextView
{
  private boolean a = false;
  private boolean b = false;
  private int c = -1644826;
  private int d = -14239358;
  private int e = 12;
  private float f;
  private float g;
  
  public IntoTitleTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public IntoTitleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public IntoTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      paramCanvas.drawRect(0.0F, 15.0F, this.f * 1.0F, getHeight() - 15, localPaint);
    }
    if (this.b)
    {
      localPaint = new Paint();
      localPaint.setColor(this.d);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect((getWidth() - getTextWidth()) / 2.0F - 2.0F, getHeight() - 4, 5.0F + (getWidth() - (getWidth() - getTextWidth()) / 2.0F), getHeight(), localPaint);
    }
  }
  
  public int getNormalTextSize()
  {
    return this.e;
  }
  
  public float getTextWidth()
  {
    return getPaint().measureText(getText().toString().trim());
  }
  
  public void init(Context paramContext)
  {
    setGravity(17);
    setTextColor(-16777216);
    setBackgroundColor(-1);
    setTextSize(14.0F);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.f = localDisplayMetrics.density;
    this.g = localDisplayMetrics.scaledDensity;
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
  
  public void setNormalTextSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setVerticalLineColor(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/IntoTitleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */