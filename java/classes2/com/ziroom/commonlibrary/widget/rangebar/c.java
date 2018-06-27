package com.ziroom.commonlibrary.widget.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

class c
{
  private final float a;
  private final Bitmap b;
  private final Bitmap c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private boolean h = false;
  private final float i;
  private float j;
  private Paint k;
  private Paint l;
  private float m;
  private boolean n;
  private int o;
  private int p;
  
  c(Context paramContext, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4)
  {
    paramContext = paramContext.getResources();
    this.b = BitmapFactory.decodeResource(paramContext, paramInt3);
    this.c = BitmapFactory.decodeResource(paramContext, paramInt4);
    if ((paramFloat2 == -1.0F) && (paramInt1 == -1) && (paramInt2 == -1))
    {
      this.n = true;
      this.d = (this.b.getWidth() / 2.0F);
      this.e = (this.b.getHeight() / 2.0F);
      this.f = (this.c.getWidth() / 2.0F);
      this.g = (this.c.getHeight() / 2.0F);
      this.a = TypedValue.applyDimension(1, (int)Math.max(24.0F, paramFloat2), paramContext.getDisplayMetrics());
      this.j = this.d;
      this.i = paramFloat1;
      return;
    }
    this.n = false;
    if (paramFloat2 == -1.0F)
    {
      this.m = TypedValue.applyDimension(1, 14.0F, paramContext.getDisplayMetrics());
      label176:
      if (paramInt1 != -1) {
        break label285;
      }
      this.o = Color.parseColor("#cc4a1a");
      label190:
      if (paramInt2 != -1) {
        break label293;
      }
    }
    label285:
    label293:
    for (this.p = Color.parseColor("#cc4a1a");; this.p = paramInt2)
    {
      this.k = new Paint();
      this.k.setColor(this.o);
      this.k.setAntiAlias(true);
      this.l = new Paint();
      this.l.setColor(this.p);
      this.l.setAntiAlias(true);
      break;
      this.m = TypedValue.applyDimension(1, paramFloat2, paramContext.getDisplayMetrics());
      break label176;
      this.o = paramInt1;
      break label190;
    }
  }
  
  float a()
  {
    return this.d;
  }
  
  void a(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.n)
    {
      if (this.h) {}
      for (Bitmap localBitmap = this.c; this.h; localBitmap = this.b)
      {
        f1 = this.i;
        f2 = this.g;
        paramCanvas.drawBitmap(localBitmap, this.j - this.f, f1 - f2, null);
        return;
      }
      float f1 = this.i;
      float f2 = this.e;
      paramCanvas.drawBitmap(localBitmap, this.j - this.d, f1 - f2, null);
      return;
    }
    if (this.h)
    {
      paramCanvas.drawCircle(this.j, this.i, this.m, this.l);
      return;
    }
    paramCanvas.drawCircle(this.j, this.i, this.m, this.k);
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat1 - this.j) <= this.a) && (Math.abs(paramFloat2 - this.i) <= this.a);
  }
  
  float b()
  {
    return this.j;
  }
  
  boolean c()
  {
    return this.h;
  }
  
  void d()
  {
    this.h = true;
  }
  
  void e()
  {
    this.h = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/rangebar/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */