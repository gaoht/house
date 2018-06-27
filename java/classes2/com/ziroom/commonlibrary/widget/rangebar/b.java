package com.ziroom.commonlibrary.widget.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

class b
{
  private final Paint a;
  private final float b;
  private final float c;
  
  b(Context paramContext, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.b = TypedValue.applyDimension(1, paramFloat2, paramContext.getResources().getDisplayMetrics());
    this.a = new Paint();
    this.a.setColor(paramInt);
    this.a.setStrokeWidth(this.b);
    this.a.setAntiAlias(true);
    this.c = paramFloat1;
  }
  
  void a(Canvas paramCanvas, c paramc1, c paramc2)
  {
    paramCanvas.drawLine(paramc1.b(), this.c, paramc2.b(), this.c, this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/rangebar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */