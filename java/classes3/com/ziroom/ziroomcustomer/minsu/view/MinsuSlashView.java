package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class MinsuSlashView
  extends View
{
  private float a;
  private float b;
  private Paint c;
  
  public MinsuSlashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MinsuSlashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float paramFloat)
  {
    return getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  private Paint a()
  {
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setColor(Color.parseColor("#dddddd"));
      this.c.setStrokeWidth(a(0.5F));
      this.c.setAntiAlias(true);
    }
    this.a = a(16.0F);
    this.b = a(8.0F);
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawLine(0.0F + this.a, getMeasuredHeight(), getMeasuredWidth() - this.a, 0.0F + this.b, this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuSlashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */