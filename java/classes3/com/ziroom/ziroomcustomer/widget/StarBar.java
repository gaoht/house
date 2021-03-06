package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ziroom.ziroomcustomer.R.styleable;

public class StarBar
  extends View
{
  private int a = 0;
  private int b = 5;
  private int c;
  private float d = 0.0F;
  private Bitmap e;
  private Drawable f;
  private a g;
  private Paint h;
  private boolean i = false;
  
  public StarBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public StarBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(this.c, this.c, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, this.c, this.c);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setClickable(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RatingBar);
    this.a = ((int)paramContext.getDimension(0, 0.0F));
    this.c = ((int)paramContext.getDimension(1, 20.0F));
    this.b = paramContext.getInteger(2, 5);
    this.f = paramContext.getDrawable(3);
    this.e = a(paramContext.getDrawable(4));
    paramContext.recycle();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setShader(new BitmapShader(this.e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
  }
  
  public float getStarMark()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = 1;
    int k = 1;
    super.onDraw(paramCanvas);
    if ((this.e == null) || (this.f == null)) {}
    int j;
    for (;;)
    {
      return;
      j = 0;
      while (j < this.b)
      {
        this.f.setBounds((this.a + this.c) * j, 0, (this.a + this.c) * j + this.c, this.c);
        this.f.draw(paramCanvas);
        j += 1;
      }
      if (this.d <= 1.0F) {
        break label305;
      }
      paramCanvas.drawRect(0.0F, 0.0F, this.c, this.c, this.h);
      j = m;
      if (this.d - (int)this.d != 0.0F) {
        break;
      }
      j = k;
      while (j < this.d)
      {
        paramCanvas.translate(this.a + this.c, 0.0F);
        paramCanvas.drawRect(0.0F, 0.0F, this.c, this.c, this.h);
        j += 1;
      }
    }
    while (j < this.d - 1.0F)
    {
      paramCanvas.translate(this.a + this.c, 0.0F);
      paramCanvas.drawRect(0.0F, 0.0F, this.c, this.c, this.h);
      j += 1;
    }
    paramCanvas.translate(this.a + this.c, 0.0F);
    paramCanvas.drawRect(0.0F, 0.0F, this.c * (Math.round((this.d - (int)this.d) * 10.0F) * 1.0F / 10.0F), this.c, this.h);
    return;
    label305:
    paramCanvas.drawRect(0.0F, 0.0F, this.c * this.d, this.c, this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.c * this.b + this.a * (this.b - 1), this.c);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = (int)paramMotionEvent.getX();
    int j = k;
    if (k < 0) {
      j = 0;
    }
    k = j;
    if (j > getMeasuredWidth()) {
      k = getMeasuredWidth();
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      invalidate();
      return super.onTouchEvent(paramMotionEvent);
      setStarMark(k * 1.0F / (getMeasuredWidth() * 1.0F / this.b));
      continue;
      setStarMark(k * 1.0F / (getMeasuredWidth() * 1.0F / this.b));
    }
  }
  
  public void setIntegerMark(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setOnStarChangeListener(a parama)
  {
    this.g = parama;
  }
  
  public void setStarMark(float paramFloat)
  {
    if (this.i) {}
    for (this.d = ((int)Math.ceil(paramFloat));; this.d = (Math.round(paramFloat * 10.0F) * 1.0F / 10.0F))
    {
      if (this.g != null) {
        this.g.onStarChange(this.d);
      }
      invalidate();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onStarChange(float paramFloat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/StarBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */