package com.pgyersdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.pgyersdk.b.b;
import com.pgyersdk.e.a;
import com.pgyersdk.i.c;

public class s
  extends View
{
  private Context a;
  private int b = 0;
  private int c = 10;
  private String d;
  
  public s(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.d = a.h(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject2 = new Paint();
    ((Paint)localObject2).setColor(Color.parseColor("#5f000000"));
    Object localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Paint)localObject1).setStyle(Paint.Style.STROKE);
    ((Paint)localObject1).setStrokeWidth(2.0F);
    ((Paint)localObject1).setAntiAlias(true);
    int i = c.a(this.a, 15.0F);
    int j = c.a(this.a, 18.0F);
    int k = c.a(this.a, 13.0F);
    new RectF(-c.a(this.a, j), i, getHeight() - i * 2 - j, getHeight() - i);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), c.a(this.a, 10.0F), c.a(this.a, 10.0F), (Paint)localObject2);
    if (this.b != -1)
    {
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStyle(Paint.Style.FILL_AND_STROKE);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      ((Paint)localObject2).setAntiAlias(true);
      paramCanvas.drawRoundRect(new RectF(j, i, j + c.a(this.a, 10.0F), i + c.a(this.a, 24.0F)), c.a(this.a, 5.0F), c.a(this.a, 5.0F), (Paint)localObject2);
      paramCanvas.drawArc(new RectF(k, c.a(this.a, 25.0F), k + c.a(this.a, 20.0F), c.a(this.a, 45.0F)), 0.0F, 180.0F, false, (Paint)localObject1);
      paramCanvas.drawLine(c.a(this.a, 23.0F), c.a(this.a, 45.0F), c.a(this.a, 23.0F), c.a(this.a, 53.0F), (Paint)localObject1);
      paramCanvas.drawLine(c.a(this.a, 18.0F), c.a(this.a, 53.0F), c.a(this.a, 28.0F), c.a(this.a, 53.0F), (Paint)localObject1);
      i = c.a(this.a, 6.0F);
      j = c.a(this.a, 2.5F);
      k = c.a(this.a, 5.0F);
      if (this.b >= 1) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F), c.a(this.a, 40.0F) + k, c.a(this.a, 53.0F), (Paint)localObject1);
      }
      if (this.b >= 2) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i, c.a(this.a, 40.0F) + k + j, c.a(this.a, 53.0F) - i, (Paint)localObject1);
      }
      if (this.b >= 3) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i * 2, c.a(this.a, 40.0F) + k + j * 2, c.a(this.a, 53.0F) - i * 2, (Paint)localObject1);
      }
      if (this.b >= 4) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i * 3, c.a(this.a, 40.0F) + k + j * 3, c.a(this.a, 53.0F) - i * 3, (Paint)localObject1);
      }
      if (this.b >= 5) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i * 4, c.a(this.a, 40.0F) + k + j * 4, c.a(this.a, 53.0F) - i * 4, (Paint)localObject1);
      }
      if (this.b >= 6) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i * 5, c.a(this.a, 40.0F) + k + j * 5, c.a(this.a, 53.0F) - i * 5, (Paint)localObject1);
      }
      if (this.b >= 7) {
        paramCanvas.drawLine(c.a(this.a, 35.0F) + k, c.a(this.a, 53.0F) - i * 6, c.a(this.a, 40.0F) + k + j * 6, c.a(this.a, 53.0F) - i * 6, (Paint)localObject1);
      }
      localObject1 = new Paint();
      ((Paint)localObject1).setColor(-1);
      if (!"mdpi".equals(this.d)) {
        break label1253;
      }
      ((Paint)localObject1).setTextSize(13.0F);
    }
    for (;;)
    {
      localObject2 = b.a(1076);
      float f1 = ((Paint)localObject1).measureText((String)localObject2);
      Paint.FontMetrics localFontMetrics = ((Paint)localObject1).getFontMetrics();
      float f2 = localFontMetrics.bottom;
      float f3 = localFontMetrics.top;
      float f4 = getHeight();
      float f5 = c.a(this.a, 2.0F);
      paramCanvas.drawText((String)localObject2, (getWidth() - f1) / 2.0F, f4 - (f2 - f3) + f5, (Paint)localObject1);
      return;
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setTextSize(80.0F);
      localObject1 = this.c + "";
      if (this.c <= 0)
      {
        this.c = 0;
        localObject1 = "0";
      }
      f1 = ((Paint)localObject2).measureText((String)localObject1);
      localFontMetrics = ((Paint)localObject2).getFontMetrics();
      f3 = localFontMetrics.bottom;
      f4 = localFontMetrics.top;
      f2 = getHeight();
      f3 = (getHeight() - (f3 - f4)) / 2.0F;
      f4 = localFontMetrics.bottom;
      f5 = c.a(this.a, 5.0F);
      paramCanvas.drawText((String)localObject1, (getWidth() - f1) / 2.0F, f2 - f3 - f4 - f5, (Paint)localObject2);
      break;
      label1253:
      if ("hdpi".equals(this.d)) {
        ((Paint)localObject1).setTextSize(14.0F);
      } else {
        ((Paint)localObject1).setTextSize(17.0F);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */