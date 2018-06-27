package android.support.v7.b.a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;

public class b
  extends Drawable
{
  private static final float b = (float)Math.toRadians(45.0D);
  private final Paint a = new Paint();
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g;
  private final Path h = new Path();
  private final int i;
  private boolean j = false;
  private float k;
  private float l;
  private int m = 2;
  
  public b(Context paramContext)
  {
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeJoin(Paint.Join.MITER);
    this.a.setStrokeCap(Paint.Cap.BUTT);
    this.a.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
    setColor(paramContext.getColor(R.styleable.DrawerArrowToggle_color, 0));
    setBarThickness(paramContext.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F));
    setSpinEnabled(paramContext.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
    setGapSize(Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F)));
    this.i = paramContext.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
    this.d = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0F));
    this.c = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
    this.e = paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
    paramContext.recycle();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n;
    float f1;
    label137:
    float f2;
    switch (this.m)
    {
    case 2: 
    default: 
      if (DrawableCompat.getLayoutDirection(this) == 1)
      {
        n = 1;
        f1 = (float)Math.sqrt(this.c * this.c * 2.0F);
        float f5 = a(this.d, f1, this.k);
        float f3 = a(this.d, this.e, this.k);
        float f4 = Math.round(a(0.0F, this.l, this.k));
        float f6 = a(0.0F, b, this.k);
        if (n == 0) {
          break label453;
        }
        f1 = 0.0F;
        if (n == 0) {
          break label460;
        }
        f2 = 180.0F;
        label145:
        f1 = a(f1, f2, this.k);
        f2 = (float)Math.round(f5 * Math.cos(f6));
        f5 = (float)Math.round(f5 * Math.sin(f6));
        this.h.rewind();
        f6 = a(this.f + this.a.getStrokeWidth(), -this.l, this.k);
        float f7 = -f3 / 2.0F;
        this.h.moveTo(f7 + f4, 0.0F);
        this.h.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.h.moveTo(f7, f6);
        this.h.rLineTo(f2, f5);
        this.h.moveTo(f7, -f6);
        this.h.rLineTo(f2, -f5);
        this.h.close();
        paramCanvas.save();
        f2 = this.a.getStrokeWidth();
        f3 = (int)(localRect.height() - 3.0F * f2 - this.f * 2.0F) / 4 * 2;
        f4 = this.f;
        paramCanvas.translate(localRect.centerX(), f2 * 1.5F + f4 + f3);
        if (!this.g) {
          break label471;
        }
        if ((n ^ this.j) == 0) {
          break label465;
        }
        n = -1;
        label390:
        paramCanvas.rotate(n * f1);
      }
      break;
    }
    for (;;)
    {
      paramCanvas.drawPath(this.h, this.a);
      paramCanvas.restore();
      return;
      n = 0;
      break;
      n = 1;
      break;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        n = 1;
        break;
      }
      n = 0;
      break;
      n = 0;
      break;
      label453:
      f1 = -180.0F;
      break label137;
      label460:
      f2 = 0.0F;
      break label145;
      label465:
      n = 1;
      break label390;
      label471:
      if (n != 0) {
        paramCanvas.rotate(180.0F);
      }
    }
  }
  
  public float getArrowHeadLength()
  {
    return this.c;
  }
  
  public float getArrowShaftLength()
  {
    return this.e;
  }
  
  public float getBarLength()
  {
    return this.d;
  }
  
  public float getBarThickness()
  {
    return this.a.getStrokeWidth();
  }
  
  public int getColor()
  {
    return this.a.getColor();
  }
  
  public int getDirection()
  {
    return this.m;
  }
  
  public float getGapSize()
  {
    return this.f;
  }
  
  public int getIntrinsicHeight()
  {
    return this.i;
  }
  
  public int getIntrinsicWidth()
  {
    return this.i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public final Paint getPaint()
  {
    return this.a;
  }
  
  public float getProgress()
  {
    return this.k;
  }
  
  public boolean isSpinEnabled()
  {
    return this.g;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.a.getAlpha())
    {
      this.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setArrowHeadLength(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setArrowShaftLength(float paramFloat)
  {
    if (this.e != paramFloat)
    {
      this.e = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarLength(float paramFloat)
  {
    if (this.d != paramFloat)
    {
      this.d = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarThickness(float paramFloat)
  {
    if (this.a.getStrokeWidth() != paramFloat)
    {
      this.a.setStrokeWidth(paramFloat);
      this.l = ((float)(paramFloat / 2.0F * Math.cos(b)));
      invalidateSelf();
    }
  }
  
  public void setColor(int paramInt)
  {
    if (paramInt != this.a.getColor())
    {
      this.a.setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDirection(int paramInt)
  {
    if (paramInt != this.m)
    {
      this.m = paramInt;
      invalidateSelf();
    }
  }
  
  public void setGapSize(float paramFloat)
  {
    if (paramFloat != this.f)
    {
      this.f = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setSpinEnabled(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setVerticalMirror(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      invalidateSelf();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */