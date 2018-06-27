package com.ziroom.ziroomcustomer.sublet.widget;

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
import com.ziroom.ziroomcustomer.sublet.model.LeaseSubletReserveEntity;

public class LeaseSubletTextView
  extends TextView
{
  private LeaseSubletReserveEntity a;
  private boolean b = false;
  private boolean c = false;
  private int d = -1644826;
  private int e = 33792;
  private float f;
  
  public LeaseSubletTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public LeaseSubletTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LeaseSubletTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Paint localPaint;
    if (this.b)
    {
      localPaint = new Paint();
      localPaint.setColor(this.d);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setStrokeWidth(0.25F);
      paramCanvas.drawRect(0.0F, 30.0F, 1.0F * this.f, getHeight() - 30, localPaint);
    }
    if (this.c)
    {
      localPaint = new Paint();
      localPaint.setColor(this.e);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(1.0F, getHeight() - 3, getWidth() * this.f, getHeight() * this.f, localPaint);
    }
  }
  
  public LeaseSubletReserveEntity getEntity()
  {
    return this.a;
  }
  
  public void init(Context paramContext)
  {
    setGravity(17);
    setTextColor(-16777216);
    setBackgroundColor(-1);
    setTextSize(15.0F);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.f = localDisplayMetrics.density;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setEntity(LeaseSubletReserveEntity paramLeaseSubletReserveEntity)
  {
    this.a = paramLeaseSubletReserveEntity;
  }
  
  public void setHorizontalineColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setIsHorizontaline(boolean paramBoolean)
  {
    this.c = paramBoolean;
    invalidate();
  }
  
  public void setIsVerticalLine(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setVerticalLineColor(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/widget/LeaseSubletTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */