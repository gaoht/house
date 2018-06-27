package com.ziroom.ziroomcustomer.minsu.view.refresh.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

public class b
  extends a
{
  private Paint a = new Paint(1);
  private Path b;
  private RectF c = new RectF();
  private int d;
  private float e;
  private float f;
  private int g;
  private Runnable h = new Runnable()
  {
    public void run()
    {
      if (b.this.isRunning())
      {
        int[] arrayOfInt = b.this.getColors();
        int i = arrayOfInt.length;
        b.a(b.this, b.a(b.this) + 5.0F);
        if (b.a(b.this) >= 360.0F)
        {
          b.a(b.this, 0.0F);
          b.b(b.this);
          if (b.c(b.this) >= i) {
            b.a(b.this, 0);
          }
          b.d(b.this).setColor(arrayOfInt[b.c(b.this)]);
        }
        b.b(b.this, b.a(b.this));
        b.this.invalidateSelf();
        b.this.a(this, 16);
      }
    }
  };
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(a(3));
    this.b = new Path();
    this.a.setColor(-1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.e, paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
    this.b.reset();
    float f1 = Math.min(paramCanvas.getWidth(), paramCanvas.getHeight());
    float f2 = a(3);
    float f3 = a(3);
    float f4 = a(3);
    float f5 = a(3);
    this.c.set(f2, f3, f1 - f4, f1 - f5);
    this.b.arcTo(this.c, 270.0F, this.f, true);
    this.a.setAlpha(this.d);
    paramCanvas.drawPath(this.b, this.a);
    paramCanvas.restore();
  }
  
  public void setAlpha(int paramInt)
  {
    this.d = paramInt;
    invalidateSelf();
  }
  
  public void setPercent(float paramFloat, boolean paramBoolean)
  {
    float f1 = paramFloat;
    if (paramFloat >= 1.0F) {
      f1 = 1.0F;
    }
    int[] arrayOfInt = getColors();
    this.a.setColor(arrayOfInt[0]);
    this.f = (360.0F * f1 - 0.001F);
    this.d = ((int)(255.0F * f1));
    this.e = (360.0F * f1);
    invalidateSelf();
  }
  
  public void start()
  {
    setRunning(true);
    a(this.h);
  }
  
  public void stop()
  {
    setRunning(false);
    b(this.h);
    this.f = 0.0F;
    this.e = 0.0F;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */