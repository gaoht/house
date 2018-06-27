package com.ziroom.ziroomcustomer.newrepair.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.ziroom.ziroomcustomer.R.styleable;

public class DashLineView
  extends View
{
  int a;
  float b;
  int c;
  int d = 2;
  float e;
  float f;
  float g;
  float h;
  float[] i;
  private Paint j;
  
  public DashLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public DashLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DashLineView);
    this.a = paramContext.getColor(0, getResources().getColor(2131624047));
    this.b = paramContext.getDimension(1, 1.0F);
    this.c = paramContext.getInteger(6, 0);
    this.d = paramContext.getInteger(7, 2);
    this.e = paramContext.getDimension(2, 2.0F);
    this.f = paramContext.getDimension(3, 2.0F);
    this.g = paramContext.getDimension(4, 2.0F);
    this.h = paramContext.getDimension(5, 2.0F);
    paramContext.recycle();
    if ((this.d != 2) && (this.d != 4)) {
      throw new RuntimeException("段数必须为2或4");
    }
    if (this.d == 2) {}
    for (this.i = new float[] { this.e, this.f };; this.i = new float[] { this.e, this.f, this.g, this.h })
    {
      this.j = new Paint();
      this.j.setStrokeWidth(this.b);
      this.j.setColor(this.a);
      this.j.setStyle(Paint.Style.STROKE);
      paramContext = new DashPathEffect(this.i, this.c);
      this.j.setPathEffect(paramContext);
      return;
    }
  }
  
  public void FileLine()
  {
    if (this.d == 2) {}
    for (this.i = new float[] { this.e, 0.0F };; this.i = new float[] { this.e, 0.0F, this.g, 0.0F })
    {
      DashPathEffect localDashPathEffect = new DashPathEffect(this.i, this.c);
      this.j.setPathEffect(localDashPathEffect);
      requestLayout();
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getHeight();
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(0.0F, k);
    paramCanvas.drawPath(localPath, this.j);
  }
  
  public void setDash()
  {
    this.d = 2;
    this.i = new float[] { this.e, this.f };
    DashPathEffect localDashPathEffect = new DashPathEffect(this.i, this.c);
    this.j.setPathEffect(localDashPathEffect);
    requestLayout();
  }
  
  public void setDash(float paramFloat1, float paramFloat2)
  {
    this.d = 2;
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.i = new float[] { this.e, this.f };
    DashPathEffect localDashPathEffect = new DashPathEffect(this.i, this.c);
    this.j.setPathEffect(localDashPathEffect);
    requestLayout();
  }
  
  public void setDash(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.d = 4;
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.i = new float[] { this.e, this.f, this.g, this.h };
    DashPathEffect localDashPathEffect = new DashPathEffect(this.i, this.c);
    this.j.setPathEffect(localDashPathEffect);
    requestLayout();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/widget/DashLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */