package com.ziroom.commonlibrary.widget.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

class a
{
  private final Paint a;
  private final float b;
  private final float c;
  private final float d;
  private int e;
  private float f;
  private final float g;
  private final float h;
  private final float i;
  
  a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, float paramFloat4, float paramFloat5, int paramInt2)
  {
    this.b = paramFloat1;
    this.c = (paramFloat1 + paramFloat3);
    this.d = paramFloat2;
    this.e = (paramInt1 - 1);
    this.f = (paramFloat3 / this.e);
    this.g = TypedValue.applyDimension(1, paramFloat4, paramContext.getResources().getDisplayMetrics());
    this.h = (this.d - this.g / 2.0F);
    this.i = (this.d + this.g / 2.0F);
    this.a = new Paint();
    this.a.setColor(paramInt2);
    this.a.setStrokeWidth(paramFloat5);
    this.a.setAntiAlias(true);
  }
  
  private void b(Canvas paramCanvas)
  {
    int j = 0;
    while (j < this.e)
    {
      float f1 = j;
      float f2 = this.f;
      f1 = this.b + f1 * f2;
      paramCanvas.drawLine(f1, this.h, f1, this.i, this.a);
      j += 1;
    }
    paramCanvas.drawLine(this.c, this.h, this.c, this.i, this.a);
  }
  
  float a()
  {
    return this.b;
  }
  
  float a(c paramc)
  {
    int k = b(paramc);
    int j;
    if (k < 0) {
      j = 0;
    }
    for (;;)
    {
      float f1 = this.b;
      return j * this.f + f1;
      j = k;
      if (k > this.e) {
        j = this.e;
      }
    }
  }
  
  void a(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.b, this.d, this.c, this.d, this.a);
    b(paramCanvas);
  }
  
  float b()
  {
    return this.c;
  }
  
  int b(c paramc)
  {
    return (int)((paramc.b() - this.b + this.f / 2.0F) / this.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/rangebar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */