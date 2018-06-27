package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.R.color;
import android.support.v7.cardview.R.dimen;

class aj
  extends Drawable
{
  static a a;
  private static final double b = Math.cos(Math.toRadians(45.0D));
  private final int c;
  private Paint d;
  private Paint e;
  private Paint f;
  private final RectF g;
  private float h;
  private Path i;
  private float j;
  private float k;
  private float l;
  private ColorStateList m;
  private boolean n = true;
  private final int o;
  private final int p;
  private boolean q = true;
  private boolean r = false;
  
  aj(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.o = paramResources.getColor(R.color.cardview_shadow_start_color);
    this.p = paramResources.getColor(R.color.cardview_shadow_end_color);
    this.c = paramResources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
    this.d = new Paint(5);
    b(paramColorStateList);
    this.e = new Paint(5);
    this.e.setStyle(Paint.Style.FILL);
    this.h = ((int)(0.5F + paramFloat1));
    this.g = new RectF();
    this.f = new Paint(this.e);
    this.f.setAntiAlias(false);
    a(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - b) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 0.0F) {
      throw new IllegalArgumentException("Invalid shadow size " + paramFloat1 + ". Must be >= 0");
    }
    if (paramFloat2 < 0.0F) {
      throw new IllegalArgumentException("Invalid max shadow size " + paramFloat2 + ". Must be >= 0");
    }
    float f1 = d(paramFloat1);
    paramFloat2 = d(paramFloat2);
    paramFloat1 = f1;
    if (f1 > paramFloat2)
    {
      if (!this.r) {
        this.r = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.l == paramFloat1) && (this.j == paramFloat2)) {
      return;
    }
    this.l = paramFloat1;
    this.j = paramFloat2;
    this.k = ((int)(paramFloat1 * 1.5F + this.c + 0.5F));
    this.n = true;
    invalidateSelf();
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = -this.h - this.k;
    float f2 = this.h + this.c + this.l / 2.0F;
    int i1;
    if (this.g.width() - 2.0F * f2 > 0.0F)
    {
      i1 = 1;
      if (this.g.height() - 2.0F * f2 <= 0.0F) {
        break label413;
      }
    }
    label413:
    for (int i2 = 1;; i2 = 0)
    {
      int i3 = paramCanvas.save();
      paramCanvas.translate(this.g.left + f2, this.g.top + f2);
      paramCanvas.drawPath(this.i, this.e);
      if (i1 != 0) {
        paramCanvas.drawRect(0.0F, f1, this.g.width() - 2.0F * f2, -this.h, this.f);
      }
      paramCanvas.restoreToCount(i3);
      i3 = paramCanvas.save();
      paramCanvas.translate(this.g.right - f2, this.g.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.i, this.e);
      if (i1 != 0)
      {
        float f3 = this.g.width();
        float f4 = -this.h;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, this.k + f4, this.f);
      }
      paramCanvas.restoreToCount(i3);
      i1 = paramCanvas.save();
      paramCanvas.translate(this.g.left + f2, this.g.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.i, this.e);
      if (i2 != 0) {
        paramCanvas.drawRect(0.0F, f1, this.g.height() - 2.0F * f2, -this.h, this.f);
      }
      paramCanvas.restoreToCount(i1);
      i1 = paramCanvas.save();
      paramCanvas.translate(this.g.right - f2, this.g.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.i, this.e);
      if (i2 != 0) {
        paramCanvas.drawRect(0.0F, f1, this.g.height() - 2.0F * f2, -this.h, this.f);
      }
      paramCanvas.restoreToCount(i1);
      return;
      i1 = 0;
      break;
    }
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    if (paramBoolean) {
      f1 = (float)(paramFloat1 + (1.0D - b) * paramFloat2);
    }
    return f1;
  }
  
  private void b(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.m = localColorStateList;
    this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
  }
  
  private void b(Rect paramRect)
  {
    float f1 = this.j * 1.5F;
    this.g.set(paramRect.left + this.j, paramRect.top + f1, paramRect.right - this.j, paramRect.bottom - f1);
    g();
  }
  
  private int d(float paramFloat)
  {
    int i2 = (int)(0.5F + paramFloat);
    int i1 = i2;
    if (i2 % 2 == 1) {
      i1 = i2 - 1;
    }
    return i1;
  }
  
  private void g()
  {
    Object localObject1 = new RectF(-this.h, -this.h, this.h, this.h);
    Object localObject2 = new RectF((RectF)localObject1);
    ((RectF)localObject2).inset(-this.k, -this.k);
    if (this.i == null) {
      this.i = new Path();
    }
    for (;;)
    {
      this.i.setFillType(Path.FillType.EVEN_ODD);
      this.i.moveTo(-this.h, 0.0F);
      this.i.rLineTo(-this.k, 0.0F);
      this.i.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
      this.i.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
      this.i.close();
      float f1 = this.h / (this.h + this.k);
      localObject1 = this.e;
      float f2 = this.h;
      float f3 = this.k;
      int i1 = this.o;
      int i2 = this.o;
      int i3 = this.p;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i1, i2, i3 }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
      localObject1 = this.f;
      f1 = -this.h;
      f2 = this.k;
      f3 = -this.h;
      float f4 = this.k;
      i1 = this.o;
      i2 = this.o;
      i3 = this.p;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i1, i2, i3 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
      this.f.setAntiAlias(false);
      return;
      this.i.reset();
    }
  }
  
  float a()
  {
    return this.h;
  }
  
  void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (this.h == paramFloat) {
      return;
    }
    this.h = paramFloat;
    this.n = true;
    invalidateSelf();
  }
  
  void a(ColorStateList paramColorStateList)
  {
    b(paramColorStateList);
    invalidateSelf();
  }
  
  void a(Rect paramRect)
  {
    getPadding(paramRect);
  }
  
  void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    invalidateSelf();
  }
  
  float b()
  {
    return this.l;
  }
  
  void b(float paramFloat)
  {
    a(paramFloat, this.j);
  }
  
  float c()
  {
    return this.j;
  }
  
  void c(float paramFloat)
  {
    a(this.l, paramFloat);
  }
  
  float d()
  {
    return Math.max(this.j, this.h + this.c + this.j / 2.0F) * 2.0F + (this.j + this.c) * 2.0F;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.n)
    {
      b(getBounds());
      this.n = false;
    }
    paramCanvas.translate(0.0F, this.l / 2.0F);
    a(paramCanvas);
    paramCanvas.translate(0.0F, -this.l / 2.0F);
    a.drawRoundRect(paramCanvas, this.g, this.h, this.d);
  }
  
  float e()
  {
    return Math.max(this.j, this.h + this.c + this.j * 1.5F / 2.0F) * 2.0F + (this.j * 1.5F + this.c) * 2.0F;
  }
  
  ColorStateList f()
  {
    return this.m;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i1 = (int)Math.ceil(a(this.j, this.h, this.q));
    int i2 = (int)Math.ceil(b(this.j, this.h, this.q));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((this.m != null) && (this.m.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.n = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i1 = this.m.getColorForState(paramArrayOfInt, this.m.getDefaultColor());
    if (this.d.getColor() == i1) {
      return false;
    }
    this.d.setColor(i1);
    this.n = true;
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
    this.e.setAlpha(paramInt);
    this.f.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
  
  static abstract interface a
  {
    public abstract void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */