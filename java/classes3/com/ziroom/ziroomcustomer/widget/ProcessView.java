package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.ziroom.ziroomcustomer.R.styleable;

public class ProcessView
  extends View
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private int e = 2;
  private int f = 12;
  private int g = 12;
  private int h = 2;
  private int i;
  private int j;
  private int k;
  private int l = 12;
  private int m = 12;
  private int n = 3;
  private float o;
  
  public ProcessView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProcessView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProcessView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.o = this.a.getResources().getDisplayMetrics().density;
    this.f = ((int)(this.l * this.o));
    this.g = ((int)(this.m * this.o));
    paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.ProcessView);
    this.b = paramAttributeSet.getString(0);
    this.c = paramAttributeSet.getString(1);
    this.d = paramAttributeSet.getString(2);
    this.i = paramAttributeSet.getColor(3, 33792);
    this.j = paramAttributeSet.getColor(4, 33792);
    this.k = paramAttributeSet.getInt(5, 16);
    this.k = ((int)(this.k * this.o));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getMeasuredHeight();
    int i1 = getMeasuredWidth();
    this.h = ((int)(this.n * this.o));
    Paint localPaint = new Paint(1);
    localPaint.setColor(this.i);
    localPaint.setTextSize(this.k);
    localPaint.getFontMetrics();
    paramCanvas.drawText(this.b, this.f, this.f / 2 + this.k, localPaint);
    int i2 = this.k + this.g * 2;
    int i3 = (int)localPaint.measureText(this.b);
    int i5 = (int)localPaint.measureText(this.c);
    int i4 = (int)localPaint.measureText(this.d);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.f + i3 / 2, i2, this.h, localPaint);
    localPaint.setStrokeWidth(this.h / 3);
    switch (this.e)
    {
    }
    for (;;)
    {
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(this.d, i1 - this.f - i4, this.f / 2 + this.k, localPaint);
      return;
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.f + i3 / 2, i2, (float)(this.h * 1.5D), localPaint);
      localPaint.setColor(-7829368);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(this.c, i1 / 2 - i5 / 2, this.f / 2 + this.k, localPaint);
      i5 = this.f;
      paramCanvas.drawLine(i3 / 2 + i5 + this.h * 3, i2, i1 / 2 - this.h * 2, i2, localPaint);
      paramCanvas.drawCircle(i1 / 2, i2, this.h, localPaint);
      paramCanvas.drawLine(i1 / 2 + this.h * 2, i2, i1 - this.f - i4 / 2 - this.h * 2, i2, localPaint);
      paramCanvas.drawCircle(i1 - this.f - i4 / 2, i2, this.h, localPaint);
      continue;
      paramCanvas.drawText(this.c, i1 / 2 - i5 / 2, this.f / 2 + this.k, localPaint);
      i5 = this.f;
      paramCanvas.drawLine(i3 / 2 + i5 + this.h * 2, i2, i1 / 2 - this.h * 3, i2, localPaint);
      paramCanvas.drawCircle(i1 / 2, i2, this.h, localPaint);
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(i1 / 2, i2, this.h * 3 / 2, localPaint);
      localPaint.setColor(-7829368);
      paramCanvas.drawLine(i1 / 2 + this.h * 3, i2, i1 - this.f - i4 / 2 - this.h * 2, i2, localPaint);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(i1 - this.f - i4 / 2, i2, this.h, localPaint);
      continue;
      paramCanvas.drawText(this.c, i1 / 2 - i5 / 2, this.f / 2 + this.k, localPaint);
      i5 = this.f;
      paramCanvas.drawLine(i3 / 2 + i5 + this.h * 2, i2, i1 / 2 - this.h * 2, i2, localPaint);
      paramCanvas.drawCircle(i1 / 2, i2, this.h, localPaint);
      paramCanvas.drawLine(i1 / 2 + this.h * 2, i2, i1 - this.f - i4 / 2 - this.h * 3, i2, localPaint);
      paramCanvas.drawCircle(i1 - this.f - i4 / 2, i2, this.h, localPaint);
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(i1 - this.f - i4 / 2, i2, this.h * 3 / 2, localPaint);
    }
  }
  
  public void setProcessState(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setProcessText(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      this.b = paramString1;
    }
    if (paramString2 != null) {
      this.c = paramString2;
    }
    if (paramString3 != null) {
      this.d = paramString3;
    }
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ProcessView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */