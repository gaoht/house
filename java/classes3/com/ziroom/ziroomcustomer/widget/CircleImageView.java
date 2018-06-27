package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CircleImageView
  extends ImageView
{
  public static final int[] a = { 2130771968, 2130771969 };
  private static final ImageView.ScaleType b = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config c = Bitmap.Config.ARGB_8888;
  private final RectF d = new RectF();
  private final RectF e = new RectF();
  private final Matrix f = new Matrix();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private int i = -1;
  private int j = 1;
  private Bitmap k;
  private BitmapShader l;
  private int m;
  private int n;
  private float o;
  private float p;
  private boolean q;
  private boolean r;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(b);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a, paramInt, 0);
    this.j = paramContext.getDimensionPixelSize(0, 1);
    this.i = paramContext.getColor(1, -1);
    paramContext.recycle();
    this.q = true;
    if (this.r)
    {
      a();
      this.r = false;
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, c);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), c))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void a()
  {
    if (!this.q) {
      this.r = true;
    }
    while (this.k == null) {
      return;
    }
    this.l = new BitmapShader(this.k, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.g.setAntiAlias(true);
    this.g.setShader(this.l);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setAntiAlias(true);
    this.h.setColor(this.i);
    this.h.setStrokeWidth(this.j);
    this.n = this.k.getHeight();
    this.m = this.k.getWidth();
    this.e.set(0.0F, 0.0F, getWidth(), getHeight());
    this.p = Math.min((this.e.height() - this.j) / 2.0F, (this.e.width() - this.j) / 2.0F);
    this.d.set(this.j, this.j, this.e.width() - this.j, this.e.height() - this.j);
    this.o = Math.min(this.d.height() / 2.0F, this.d.width() / 2.0F);
    b();
    invalidate();
  }
  
  private void b()
  {
    float f1 = 0.0F;
    this.f.set(null);
    float f3;
    float f2;
    if (this.m * this.d.height() > this.d.width() * this.n)
    {
      f3 = this.d.height() / this.n;
      f2 = (this.d.width() - this.m * f3) * 0.5F;
    }
    for (;;)
    {
      this.f.setScale(f3, f3);
      this.f.postTranslate((int)(f2 + 0.5F) + this.j, (int)(f1 + 0.5F) + this.j);
      this.l.setLocalMatrix(this.f);
      return;
      f3 = this.d.width() / this.m;
      f1 = this.d.height();
      float f4 = this.n;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  public int getBorderColor()
  {
    return this.i;
  }
  
  public int getBorderWidth()
  {
    return this.j;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.g);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.p, this.h);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    this.h.setColor(this.i);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    a();
  }
  
  public void setDefaultBorderWidth(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.k = paramBitmap;
    a();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.k = a(paramDrawable);
    a();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.k = a(getDrawable());
    a();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != b) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
  
  public void setmBorderColor(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */