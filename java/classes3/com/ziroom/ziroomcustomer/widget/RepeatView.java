package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.ziroom.ziroomcustomer.R.styleable;

public class RepeatView
  extends View
{
  int a;
  int b;
  int c;
  int d;
  int e;
  int f;
  private Paint g;
  private Bitmap h;
  private float i;
  private int j;
  private final int k = 0;
  private final int l = 1;
  private float m;
  private int n;
  private int o;
  private int p;
  
  public RepeatView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public RepeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public RepeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public RepeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i3 = 0;
    int i2 = 0;
    int i1 = i3;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RepeatView);
      i1 = i3;
      if (paramAttributeSet != null)
      {
        this.i = paramAttributeSet.getDimension(0, 0.0F);
        this.j = paramAttributeSet.getInt(1, 1);
        if (this.j != 1) {
          break label142;
        }
        this.m = paramAttributeSet.getDimension(3, 0.0F);
        if (this.m <= 0.0F) {
          throw new RuntimeException("RepeatView：circleRadius bitmapSrc is required and the value must be positive！");
        }
        this.n = paramAttributeSet.getColor(4, -1);
        i1 = i2;
        paramAttributeSet.recycle();
      }
    }
    this.g = new Paint();
    this.g.setAntiAlias(true);
    if (this.j == 1) {
      this.g.setColor(this.n);
    }
    label142:
    while (this.j != 0)
    {
      return;
      i1 = i2;
      if (this.j != 0) {
        break;
      }
      i2 = paramAttributeSet.getResourceId(2, 0);
      i1 = i2;
      if (i2 != 0) {
        break;
      }
      throw new RuntimeException("RepeatView：property bitmapSrc is required！");
    }
    this.h = BitmapFactory.decodeResource(paramContext.getResources(), i1);
    this.e = this.h.getWidth();
    this.f = this.h.getHeight();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    int i1 = 0;
    super.onDraw(paramCanvas);
    int i3 = getMeasuredWidth() - this.a - this.b;
    int i4 = getMeasuredHeight();
    int i5 = this.c;
    int i6 = this.d;
    if ((i3 < this.e) || (i4 - i5 - i6 < this.f)) {}
    for (;;)
    {
      return;
      float f1;
      if (this.j == 0)
      {
        i4 = i3 - this.e;
        i2 = (int)(this.e + this.i);
        i3 = i4 / i2;
        f1 = i4 % i2 / 2 + this.a;
        while (i1 < i3 + 1)
        {
          paramCanvas.drawBitmap(this.h, i1 * i2 + f1, this.c, this.g);
          i1 += 1;
        }
      }
      else if (this.j == 1)
      {
        i1 = i3 - (int)(this.m * 2.0F);
        i3 = (int)(this.m * 2.0F + this.i);
        i4 = i1 / i3;
        f1 = i1 % i3 / 2 + this.a;
        float f2 = this.m;
        float f3 = this.c;
        float f4 = this.m;
        i1 = i2;
        while (i1 < i4 + 1)
        {
          paramCanvas.drawCircle(i1 * i3 + (f1 + f2), f3 + f4, this.m, this.g);
          i1 += 1;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    this.a = getPaddingLeft();
    this.b = getPaddingRight();
    this.c = getPaddingTop();
    this.d = getPaddingBottom();
    if (this.j == 0)
    {
      this.o = ((int)(this.a + this.i * 2.0F + this.e + this.b));
      this.p = (this.c + this.f + this.d);
    }
    do
    {
      while ((i1 == Integer.MIN_VALUE) && (i2 == Integer.MIN_VALUE))
      {
        setMeasuredDimension(this.o, this.p);
        return;
        if (1 == this.j)
        {
          this.o = ((int)(this.a + this.i * 2.0F + this.m * 2.0F + this.b));
          this.p = ((int)(this.c + this.m * 2.0F + this.d));
        }
      }
      if (i1 == Integer.MIN_VALUE)
      {
        setMeasuredDimension(this.o, paramInt2);
        return;
      }
    } while (i2 != Integer.MIN_VALUE);
    setMeasuredDimension(paramInt1, this.p);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/RepeatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */