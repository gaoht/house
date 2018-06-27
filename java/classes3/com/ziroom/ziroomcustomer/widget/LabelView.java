package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.ziroom.ziroomcustomer.R.styleable;

public class LabelView
  extends View
{
  private String a;
  private int b;
  private float c;
  private boolean d;
  private boolean e;
  private boolean f;
  private int g;
  private float h;
  private float i;
  private int j;
  private Paint k = new Paint(1);
  private Paint l = new Paint(1);
  private Path m = new Path();
  
  public LabelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    this.k.setTextAlign(Paint.Align.CENTER);
  }
  
  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return i2;
    }
    paramInt = getPaddingLeft();
    int n = getPaddingRight();
    this.k.setColor(this.b);
    this.k.setTextSize(this.c);
    n = (int)((paramInt + n + (int)this.k.measureText(this.a + "")) * Math.sqrt(2.0D));
    paramInt = n;
    if (i1 == Integer.MIN_VALUE) {
      paramInt = Math.min(n, i2);
    }
    return Math.max((int)this.h, paramInt);
  }
  
  private void a(int paramInt, float paramFloat1, Canvas paramCanvas, float paramFloat2, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.rotate(paramFloat1, paramInt / 2.0F, paramInt / 2.0F);
    float f1;
    if (paramBoolean)
    {
      paramFloat1 = -(this.i * 2.0F + paramFloat2) / 2.0F;
      paramFloat2 = paramInt / 2;
      f1 = (this.k.descent() + this.k.ascent()) / 2.0F;
      if (!this.f) {
        break label133;
      }
    }
    label133:
    for (String str = this.a.toUpperCase();; str = this.a)
    {
      paramCanvas.drawText(str, getPaddingLeft() + (paramInt - getPaddingLeft() - getPaddingRight()) / 2, paramFloat2 - f1 + paramFloat1, this.k);
      paramCanvas.restore();
      return;
      paramFloat1 = (this.i * 2.0F + paramFloat2) / 2.0F;
      break;
    }
  }
  
  private void a(int paramInt, float paramFloat, Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.rotate(paramFloat, paramInt / 2.0F, paramInt / 2.0F);
    float f1;
    float f2;
    if (paramBoolean)
    {
      paramFloat = -paramInt / 4;
      f1 = paramInt / 2;
      f2 = (this.k.descent() + this.k.ascent()) / 2.0F;
      if (!this.f) {
        break label119;
      }
    }
    label119:
    for (String str = this.a.toUpperCase();; str = this.a)
    {
      paramCanvas.drawText(str, getPaddingLeft() + (paramInt - getPaddingLeft() - getPaddingRight()) / 2, f1 - f2 + paramFloat, this.k);
      paramCanvas.restore();
      return;
      paramFloat = paramInt / 4;
      break;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LabelView);
    this.a = paramContext.getString(0);
    this.b = paramContext.getColor(1, Color.parseColor("#ffffff"));
    this.c = paramContext.getDimension(2, b(11.0F));
    this.d = paramContext.getBoolean(3, true);
    this.f = paramContext.getBoolean(4, true);
    this.e = paramContext.getBoolean(9, false);
    this.g = paramContext.getColor(5, Color.parseColor("#FF4081"));
    if (this.e) {}
    for (float f1 = a(35.0F);; f1 = a(50.0F))
    {
      this.h = paramContext.getDimension(6, f1);
      this.i = paramContext.getDimension(7, a(3.5F));
      this.j = paramContext.getInt(8, 51);
      paramContext.recycle();
      return;
    }
  }
  
  protected int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected int b(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public int getBgColor()
  {
    return this.g;
  }
  
  public int getGravity()
  {
    return this.j;
  }
  
  public float getMinSize()
  {
    return this.h;
  }
  
  public float getPadding()
  {
    return this.i;
  }
  
  public String getText()
  {
    return this.a;
  }
  
  public int getTextColor()
  {
    return this.b;
  }
  
  public float getTextSize()
  {
    return this.c;
  }
  
  public boolean isFillTriangle()
  {
    return this.e;
  }
  
  public boolean isTextAllCaps()
  {
    return this.f;
  }
  
  public boolean isTextBold()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int n = getHeight();
    this.k.setColor(this.b);
    this.k.setTextSize(this.c);
    this.k.setFakeBoldText(this.d);
    this.l.setColor(this.g);
    float f1 = this.k.descent() - this.k.ascent();
    if (this.e) {
      if (this.j == 51)
      {
        this.m.reset();
        this.m.moveTo(0.0F, 0.0F);
        this.m.lineTo(0.0F, n);
        this.m.lineTo(n, 0.0F);
        this.m.close();
        paramCanvas.drawPath(this.m, this.l);
        a(n, -45.0F, paramCanvas, true);
      }
    }
    double d1;
    do
    {
      do
      {
        return;
        if (this.j == 53)
        {
          this.m.reset();
          this.m.moveTo(n, 0.0F);
          this.m.lineTo(0.0F, 0.0F);
          this.m.lineTo(n, n);
          this.m.close();
          paramCanvas.drawPath(this.m, this.l);
          a(n, 45.0F, paramCanvas, true);
          return;
        }
        if (this.j == 83)
        {
          this.m.reset();
          this.m.moveTo(0.0F, n);
          this.m.lineTo(0.0F, 0.0F);
          this.m.lineTo(n, n);
          this.m.close();
          paramCanvas.drawPath(this.m, this.l);
          a(n, 45.0F, paramCanvas, false);
          return;
        }
      } while (this.j != 85);
      this.m.reset();
      this.m.moveTo(n, n);
      this.m.lineTo(0.0F, n);
      this.m.lineTo(n, 0.0F);
      this.m.close();
      paramCanvas.drawPath(this.m, this.l);
      a(n, -45.0F, paramCanvas, false);
      return;
      d1 = (this.i * 2.0F + f1) * Math.sqrt(2.0D);
      if (this.j == 51)
      {
        this.m.reset();
        this.m.moveTo(0.0F, (float)(n - d1));
        this.m.lineTo(0.0F, n);
        this.m.lineTo(n, 0.0F);
        this.m.lineTo((float)(n - d1), 0.0F);
        this.m.close();
        paramCanvas.drawPath(this.m, this.l);
        a(n, -45.0F, paramCanvas, f1, true);
        return;
      }
      if (this.j == 53)
      {
        this.m.reset();
        this.m.moveTo(0.0F, 0.0F);
        this.m.lineTo((float)d1, 0.0F);
        this.m.lineTo(n, (float)(n - d1));
        this.m.lineTo(n, n);
        this.m.close();
        paramCanvas.drawPath(this.m, this.l);
        a(n, 45.0F, paramCanvas, f1, true);
        return;
      }
      if (this.j == 83)
      {
        this.m.reset();
        this.m.moveTo(0.0F, 0.0F);
        this.m.lineTo(0.0F, (float)d1);
        this.m.lineTo((float)(n - d1), n);
        this.m.lineTo(n, n);
        this.m.close();
        paramCanvas.drawPath(this.m, this.l);
        a(n, 45.0F, paramCanvas, f1, false);
        return;
      }
    } while (this.j != 85);
    this.m.reset();
    this.m.moveTo(0.0F, n);
    this.m.lineTo((float)d1, n);
    this.m.lineTo(n, (float)d1);
    this.m.lineTo(n, 0.0F);
    this.m.close();
    paramCanvas.drawPath(this.m, this.l);
    a(n, -45.0F, paramCanvas, f1, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1);
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setBgColor(int paramInt)
  {
    this.g = paramInt;
    invalidate();
  }
  
  public void setFillTriangle(boolean paramBoolean)
  {
    this.e = paramBoolean;
    invalidate();
  }
  
  public void setGravity(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setMinSize(float paramFloat)
  {
    this.h = a(paramFloat);
    invalidate();
  }
  
  public void setPadding(float paramFloat)
  {
    this.i = a(paramFloat);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.a = paramString;
    invalidate();
  }
  
  public void setTextAllCaps(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidate();
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.d = paramBoolean;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.b = paramInt;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.c = b(paramFloat);
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/LabelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */