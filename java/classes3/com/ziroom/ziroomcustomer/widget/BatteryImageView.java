package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ziroom.ziroomcustomer.util.n;

public class BatteryImageView
  extends ImageView
{
  public float a = -1.0F;
  private Paint b;
  private float c;
  private float d;
  private Context e;
  private float f;
  private float g;
  private Bitmap h;
  private int i;
  
  public BatteryImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BatteryImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public BatteryImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramContext;
    a();
  }
  
  private void a()
  {
    this.b = new Paint();
    this.h = BitmapFactory.decodeResource(this.e.getResources(), 2130838989);
    this.i = n.dip2px(this.e, 1.0F);
    int j = this.h.getWidth() / this.i;
    int k = this.h.getHeight() / this.i;
    this.g = (j * 0.68F * this.i - 1.0F);
    this.f = (k * 0.28F * this.i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d = getWidth();
    this.c = getHeight();
    paramCanvas.drawBitmap(this.h, 0.0F, 0.0F, this.b);
    float f2 = (this.d - this.g) / 2.0F;
    float f3 = (this.c - this.f) / 2.0F;
    paramCanvas.save();
    float f1;
    if (this.a >= 20.0F)
    {
      f1 = this.g / 100.0F * this.a;
      this.b.setColor(Color.parseColor("#4adc2d"));
    }
    for (;;)
    {
      paramCanvas.drawRect(f2 - this.i * 1.3F, f3, f2 + f1, this.f + f3, this.b);
      return;
      if ((this.a >= 0.0F) && (this.a < 20.0F))
      {
        this.b.setColor(Color.parseColor("#FF5544"));
        f1 = this.g / 100.0F * this.a;
      }
      else
      {
        f1 = this.g;
        this.b.setColor(Color.parseColor("#A3A3A3"));
      }
    }
  }
  
  public void setCurrentBattery(float paramFloat)
  {
    this.a = paramFloat;
    postInvalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/BatteryImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */