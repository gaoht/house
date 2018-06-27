package com.pgyersdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import com.pgyersdk.i.c;

class d
  extends Shape
{
  d(b paramb, Paint paramPaint, Context paramContext, int paramInt) {}
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    this.a.setAntiAlias(true);
    int i = c.a(this.b, 1.0F);
    paramCanvas.drawArc(new RectF(i, i, this.c - i, this.c - i), 0.0F, 360.0F, true, this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */