package com.ziroom.ziroomcustomer.gesturelock.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.view.View;
import android.view.View.MeasureSpec;
import com.ziroom.ziroomcustomer.minsu.f.ab;

public class GestureLockView
  extends View
{
  private final int a;
  private a b = a.a;
  private int c;
  private int d;
  private int e;
  private int f = 2;
  private int g;
  private int h;
  private Paint i;
  private float j = 0.333F;
  private int k = -1;
  private Path l;
  private float m = 0.3F;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public GestureLockView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext);
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
    this.q = paramInt4;
    this.i = new Paint(1);
    this.a = ab.dp2px(paramContext, 1.0F);
    this.i.setStrokeWidth(this.a);
    this.l = new Path();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.k != -1)
    {
      this.i.setStyle(Paint.Style.FILL);
      paramCanvas.save();
      paramCanvas.rotate(this.k, this.g, this.h);
      paramCanvas.drawPath(this.l, this.i);
      paramCanvas.restore();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    switch (1.a[this.b.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.i.setStyle(Paint.Style.STROKE);
      this.i.setColor(this.o);
      paramCanvas.drawCircle(this.g, this.h, this.e, this.i);
      this.i.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(this.g, this.h, this.a * 8, this.i);
      this.i.setColor(this.p);
      a(paramCanvas);
      return;
    case 2: 
      if (GestureLockViewGroup.a) {
        this.i.setColor(this.p);
      }
      for (;;)
      {
        this.i.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(this.g, this.h, this.e, this.i);
        this.i.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.g, this.h, this.a * 8, this.i);
        a(paramCanvas);
        return;
        this.i.setColor(this.q);
      }
    }
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setColor(-7829368);
    paramCanvas.drawCircle(this.g, this.h, this.a * 8, this.i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = View.MeasureSpec.getSize(paramInt1);
    this.d = View.MeasureSpec.getSize(paramInt2);
    if (this.c < this.d) {}
    for (paramInt1 = this.c;; paramInt1 = this.d)
    {
      this.c = paramInt1;
      this.f = (this.a * 2);
      paramInt1 = this.c / 2;
      this.h = paramInt1;
      this.g = paramInt1;
      this.e = paramInt1;
      this.e -= this.f / 2;
      float f1 = this.c / 2 * this.j;
      this.l.moveTo(this.c / 2, this.f + 2);
      this.l.lineTo(this.c / 2 - f1, this.f + 2 + f1);
      this.l.lineTo(this.c / 2 + f1, f1 + (this.f + 2));
      this.l.close();
      this.l.setFillType(Path.FillType.WINDING);
      return;
    }
  }
  
  public void setArrowDegree(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setMode(a parama)
  {
    this.b = parama;
    invalidate();
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/view/GestureLockView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */