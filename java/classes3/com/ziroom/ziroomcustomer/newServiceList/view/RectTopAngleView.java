package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class RectTopAngleView
  extends ImageView
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private ColorFilter b;
  private int c = a(8);
  private int d = a(40);
  private int e = a(20);
  private int f = a(20);
  private int g = 0;
  private int h = 0;
  private Rect i;
  private Bitmap j;
  private BitmapShader k;
  private Paint l;
  private Matrix m;
  private int n;
  private int o;
  
  public RectTopAngleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RectTopAngleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RectTopAngleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
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
      for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, a);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), a))
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
    if (this.j == null) {
      return;
    }
    this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.l = new Paint();
    if (this.b != null) {
      this.l.setColorFilter(this.b);
    }
    this.l.setAntiAlias(true);
    this.l.setShader(this.k);
    this.o = this.j.getHeight();
    this.n = this.j.getWidth();
    b();
    invalidate();
  }
  
  private void b()
  {
    float f1 = 0.0F;
    this.m = new Matrix();
    this.m.set(null);
    this.i = new Rect(0, 0, getRight() - getLeft(), getBottom() - getTop());
    float f3;
    float f2;
    if (this.n * this.i.height() > this.i.width() * this.o)
    {
      f3 = this.i.height() / this.o;
      f2 = (this.i.width() - this.n * f3) * 0.5F;
    }
    for (;;)
    {
      this.m.setScale(f3, f3);
      this.m.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
      this.k.setLocalMatrix(this.m);
      return;
      f3 = this.i.width() / this.n;
      f1 = this.i.height();
      float f4 = this.o;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getRight() - getLeft() - getPaddingRight(), getBottom() - getTop() - getPaddingBottom());
    Path localPath = new Path();
    rightPath(localRectF, localPath);
    paramCanvas.drawPath(localPath, this.l);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void rightPath(RectF paramRectF, Path paramPath)
  {
    paramPath.moveTo(this.c, paramRectF.top);
    paramPath.lineTo(paramRectF.width(), paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.c * 2, paramRectF.top, paramRectF.right, this.c * 2 + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.c * 2 + paramRectF.left, this.c * 2 + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b = paramColorFilter;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.j = paramBitmap;
    a();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.j = a(paramDrawable);
    a();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.j = a(getDrawable());
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/RectTopAngleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */