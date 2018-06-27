package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.ziroom.ziroomcustomer.R.styleable;

public class ProcessView2
  extends View
{
  private Context a;
  private String b;
  private String c;
  private int d = 2;
  private int e = 12;
  private int f = 12;
  private int g = 2;
  private int h;
  private int i;
  private int j;
  private int k = 12;
  private int l = 12;
  private int m = 3;
  private float n;
  
  public ProcessView2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProcessView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProcessView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.n = this.a.getResources().getDisplayMetrics().density;
    this.e = ((int)(this.k * this.n));
    this.f = ((int)(this.l * this.n));
    paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.ProcessView);
    this.b = paramAttributeSet.getString(0);
    this.c = paramAttributeSet.getString(2);
    this.h = paramAttributeSet.getColor(3, 33792);
    this.i = paramAttributeSet.getColor(4, 33792);
    this.j = paramAttributeSet.getInt(5, 16);
    this.j = ((int)(this.j * this.n));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getMeasuredHeight();
    int i1 = getMeasuredWidth();
    this.g = ((int)(this.m * this.n));
    Paint localPaint = new Paint(1);
    localPaint.setColor(this.h);
    localPaint.setTextSize(this.j);
    localPaint.getFontMetrics();
    paramCanvas.drawText(this.b, this.e, this.e / 2 + this.j, localPaint);
    int i2 = this.j + this.f * 2;
    int i3 = (int)localPaint.measureText(this.b);
    int i4 = (int)localPaint.measureText(this.c);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.e + i3 / 2, i2, this.g, localPaint);
    localPaint.setStrokeWidth(this.g / 3);
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.e + i3 / 2, i2, (float)(this.g * 1.5D), localPaint);
      localPaint.setColor(-7829368);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(this.c, i1 - i4 / 2, this.e / 2 + this.j, localPaint);
      i4 = this.e;
      paramCanvas.drawLine(i3 / 2 + i4 + this.g * 3, i2, i1 / 2 - this.g * 2, i2, localPaint);
      paramCanvas.drawCircle(i1 / 2, i2, this.g, localPaint);
      return;
    }
    paramCanvas.drawText(this.c, i1 - this.e - i4, this.e / 2 + this.j, localPaint);
    int i5 = this.e;
    paramCanvas.drawLine(i3 / 2 + i5 + this.g * 2, i2, i1 - this.e - i4 / 2 - this.g * 3, i2, localPaint);
    paramCanvas.drawCircle(i1 - this.e - i4 / 2, i2, this.g, localPaint);
    localPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i1 - this.e - i4 / 2, i2, this.g * 3 / 2, localPaint);
  }
  
  public void setProcessState(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setText(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.b = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.c = paramString2;
    }
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ProcessView2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */