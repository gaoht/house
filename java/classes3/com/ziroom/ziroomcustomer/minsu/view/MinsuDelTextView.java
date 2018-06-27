package com.ziroom.ziroomcustomer.minsu.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

@SuppressLint({"AppCompatCustomView"})
public class MinsuDelTextView
  extends TextView
{
  private int a;
  private float b;
  private final int c = -7829368;
  private final float d = 80.0F;
  private final float e = a(0.5F);
  private boolean f = true;
  private float g;
  
  public MinsuDelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MinsuDelTextView);
    this.a = paramContext.getColor(0, -7829368);
    this.b = paramContext.getDimension(1, this.e);
    this.f = paramContext.getBoolean(2, true);
    this.g = paramContext.getDimension(3, 80.0F);
  }
  
  public MinsuDelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(float paramFloat)
  {
    return ApplicationEx.c.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f)
    {
      Paint localPaint = new Paint();
      localPaint.setColor(this.a);
      localPaint.setStrokeWidth(this.b);
      paramCanvas.drawLine(getMeasuredWidth() - this.g, this.g - 10.0F, this.g, getMeasuredWidth() - this.g - 25.0F, localPaint);
    }
  }
  
  public void setmIsShowDel(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuDelTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */