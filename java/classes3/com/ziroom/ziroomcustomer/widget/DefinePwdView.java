package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;

public class DefinePwdView
  extends View
{
  public int a = 0;
  public int b = 0;
  private int c = 6;
  private String d = "#E6E6E6";
  private float e = 0.5F;
  private float f;
  private int g;
  private Context h;
  private Paint i;
  
  public DefinePwdView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefinePwdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DefinePwdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
    a();
  }
  
  private void a()
  {
    this.g = n.dip2px(this.h, 1.0F);
    this.f = (this.g * 45);
    this.i = new Paint();
    this.i.setColor(Color.parseColor(this.d));
    this.i.setStrokeWidth(this.g);
    this.a = (this.g * 20);
    this.b = (this.g * 80);
    int j = ac.getScreenWidth(this.h);
    int k = ac.getScreenHeight(this.h);
    this.a = ((int)((j - this.f * this.c) / 2.0F));
    this.b = ((int)((k - this.f) / 2.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = this.c + 3;
    int j = 0;
    if (j < k)
    {
      float f1;
      float f2;
      float f3;
      float f4;
      if (j == 0)
      {
        f1 = this.a;
        f2 = this.b;
        f3 = this.c;
        f4 = this.f;
        paramCanvas.drawLine(f1, f2, this.a + f3 * f4, this.b, this.i);
      }
      for (;;)
      {
        j += 1;
        break;
        float f5;
        float f6;
        float f7;
        if (j <= k - 2)
        {
          f1 = this.f;
          f2 = j - 1;
          f3 = this.a;
          f4 = this.b;
          f5 = this.f;
          f6 = j - 1;
          f7 = this.a;
          float f8 = this.f;
          paramCanvas.drawLine(f3 + f1 * f2, f4, f7 + f5 * f6, this.b + f8, this.i);
        }
        else if (j == k - 1)
        {
          f1 = this.a;
          f2 = this.f;
          f3 = this.b;
          f4 = this.c;
          f5 = this.f;
          f6 = this.a;
          f7 = this.f;
          paramCanvas.drawLine(f1, f3 + f2, f6 + f4 * f5, this.b + f7, this.i);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/DefinePwdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */