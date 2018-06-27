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
public class MinsuSlashDelTextView
  extends TextView
{
  private int a;
  private float b;
  private final int c = -7829368;
  private final float d = 80.0F;
  private final float e = a(0.5F);
  private boolean f = true;
  private float g;
  private float h;
  private float i;
  private float j;
  private Paint k;
  
  public MinsuSlashDelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MinsuSlashDelTextView);
    this.a = paramContext.getColor(0, -7829368);
    this.b = paramContext.getDimension(1, this.e);
    this.f = paramContext.getBoolean(2, true);
    float f1 = paramContext.getDimension(3, 80.0F);
    this.g = f1;
    this.h = f1;
    this.i = f1;
    this.j = f1;
    this.g = paramContext.getDimension(4, f1);
    this.h = paramContext.getDimension(6, f1);
    this.i = paramContext.getDimension(5, f1);
    this.j = paramContext.getDimension(7, f1);
    if (this.f) {
      a();
    }
  }
  
  public MinsuSlashDelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(float paramFloat)
  {
    return ApplicationEx.c.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  private Paint a()
  {
    if (this.k == null)
    {
      this.k = new Paint();
      this.k.setColor(this.a);
      this.k.setStrokeWidth(this.b);
    }
    return this.k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f) {
      paramCanvas.drawLine(getMeasuredWidth() - this.g, this.h, this.i, getMeasuredWidth() - this.j, this.k);
    }
  }
  
  public void setmIsShowDel(boolean paramBoolean)
  {
    a();
    this.f = paramBoolean;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuSlashDelTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */