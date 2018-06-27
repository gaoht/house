package com.lsjwzh.widget.materialloadingprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class a
  extends Drawable
  implements Animatable
{
  private static final Interpolator b = new LinearInterpolator();
  private static final Interpolator c = new a(null);
  private static final Interpolator d = new c(null);
  private static final Interpolator e = new AccelerateDecelerateInterpolator();
  boolean a;
  private final int[] f = { -16777216 };
  private final ArrayList<Animation> g = new ArrayList();
  private final b h;
  private final Drawable.Callback i = new Drawable.Callback()
  {
    public void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      a.this.invalidateSelf();
    }
    
    public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      a.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      a.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private float j;
  private Resources k;
  private View l;
  private Animation m;
  private float n;
  private double o;
  private double p;
  private boolean q = false;
  
  public a(Context paramContext, View paramView)
  {
    this.l = paramView;
    this.k = paramContext.getResources();
    this.h = new b(this.i);
    this.h.setColors(this.f);
    updateSizes(1);
    c();
  }
  
  private void a(float paramFloat, b paramb)
  {
    float f1 = (float)(Math.floor(paramb.getStartingRotation() / 0.8F) + 1.0D);
    paramb.setStartTrim(paramb.getStartingStartTrim() + (paramb.getStartingEndTrim() - paramb.getStartingStartTrim()) * paramFloat);
    float f2 = paramb.getStartingRotation();
    paramb.setRotation((f1 - paramb.getStartingRotation()) * paramFloat + f2);
  }
  
  private void c()
  {
    final b localb = this.h;
    Animation local2 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        if (a.this.a) {
          a.a(a.this, paramAnonymousFloat, localb);
        }
        do
        {
          return;
          float f2 = (float)Math.toRadians(localb.getStrokeWidth() / (6.283185307179586D * localb.getCenterRadius()));
          float f4 = localb.getStartingEndTrim();
          float f1 = localb.getStartingStartTrim();
          float f3 = localb.getStartingRotation();
          f2 = (0.8F - f2) * a.a().getInterpolation(paramAnonymousFloat) + f4;
          f4 = a.b().getInterpolation(paramAnonymousFloat) * 0.8F + f1;
          f1 = f2;
          if (Math.abs(f2 - f4) >= 1.0F) {
            f1 = 0.5F + f4;
          }
          localb.setEndTrim(f1);
          localb.setStartTrim(f4);
          localb.setRotation(0.25F * paramAnonymousFloat + f3);
          f1 = a.a(a.this) / 5.0F;
          a.this.a(144.0F * paramAnonymousFloat + 720.0F * f1);
        } while (a.b(a.this).getParent() != null);
        a.this.stop();
      }
    };
    local2.setRepeatCount(-1);
    local2.setRepeatMode(1);
    local2.setInterpolator(b);
    local2.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        localb.storeOriginals();
        localb.goToNextColor();
        localb.setStartTrim(localb.getEndTrim());
        if (a.this.a)
        {
          a.this.a = false;
          paramAnonymousAnimation.setDuration(1333L);
          localb.setShowArrow(false);
          return;
        }
        a.a(a.this, (a.a(a.this) + 1.0F) % 5.0F);
      }
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        a.a(a.this, 0.0F);
      }
    });
    this.m = local2;
  }
  
  void a(float paramFloat)
  {
    this.j = paramFloat;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.j, localRect.exactCenterX(), localRect.exactCenterY());
    this.h.draw(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }
  
  public int getAlpha()
  {
    return this.h.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.p;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.o;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return (this.m.hasStarted()) && (!this.m.hasEnded());
  }
  
  public void setAlpha(int paramInt)
  {
    this.h.setAlpha(paramInt);
  }
  
  public void setArrowScale(float paramFloat)
  {
    this.h.setArrowScale(paramFloat);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.h.setBackgroundColor(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.h.setColorFilter(paramColorFilter);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    this.h.setColors(paramVarArgs);
    this.h.setColorIndex(0);
  }
  
  public void setProgressRotation(float paramFloat)
  {
    this.h.setRotation(paramFloat);
  }
  
  public void setSizeParameters(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    b localb = this.h;
    this.o = paramDouble1;
    this.p = paramDouble2;
    localb.setStrokeWidth((float)paramDouble4);
    localb.setCenterRadius(paramDouble3);
    localb.setColorIndex(0);
    localb.setArrowDimensions(paramFloat1, paramFloat2);
    localb.setInsets((int)this.o, (int)this.p);
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    this.h.setStartTrim(paramFloat1);
    this.h.setEndTrim(paramFloat2);
  }
  
  public void showArrow(boolean paramBoolean)
  {
    this.h.setShowArrow(paramBoolean);
  }
  
  public void showArrowOnFirstStart(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void start()
  {
    this.m.reset();
    this.h.storeOriginals();
    this.h.setShowArrow(this.q);
    if (this.h.getEndTrim() != this.h.getStartTrim())
    {
      this.a = true;
      this.m.setDuration(666L);
      this.l.startAnimation(this.m);
      return;
    }
    this.h.setColorIndex(0);
    this.h.resetOriginals();
    this.m.setDuration(1333L);
    this.l.startAnimation(this.m);
  }
  
  public void stop()
  {
    this.l.clearAnimation();
    a(0.0F);
    this.h.setShowArrow(false);
    this.h.setColorIndex(0);
    this.h.resetOriginals();
  }
  
  public void updateSizes(int paramInt)
  {
    float f1 = this.k.getDisplayMetrics().density;
    if (paramInt == 0)
    {
      setSizeParameters(56.0F * f1, 56.0F * f1, 12.5F * f1, 3.0F * f1, 12.0F * f1, 6.0F * f1);
      return;
    }
    setSizeParameters(40.0F * f1, 40.0F * f1, 8.75F * f1, 2.5F * f1, 10.0F * f1, 5.0F * f1);
  }
  
  private static class a
    extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.max(0.0F, (paramFloat - 0.5F) * 2.0F));
    }
  }
  
  private static class b
  {
    private final RectF a = new RectF();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Drawable.Callback d;
    private final Paint e = new Paint();
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 0.0F;
    private float i = 5.0F;
    private float j = 2.5F;
    private int[] k;
    private int l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private Path q;
    private float r;
    private double s;
    private int t;
    private int u;
    private int v;
    private int w;
    
    public b(Drawable.Callback paramCallback)
    {
      this.d = paramCallback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }
    
    private void a()
    {
      this.d.invalidateDrawable(null);
    }
    
    private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Rect paramRect)
    {
      if (this.p)
      {
        if (this.q != null) {
          break label221;
        }
        this.q = new Path();
        this.q.setFillType(Path.FillType.EVEN_ODD);
      }
      for (;;)
      {
        float f1 = (float)(this.s * Math.cos(0.0D) + paramRect.exactCenterX());
        float f2 = (float)(this.s * Math.sin(0.0D) + paramRect.exactCenterY());
        this.q.moveTo(0.0F, 0.0F);
        this.q.lineTo(this.t * this.r, 0.0F);
        this.q.lineTo(this.t * this.r / 2.0F, this.u * this.r);
        this.q.offset(f1 - this.t * this.r / 2.0F, f2);
        this.q.close();
        this.c.setColor(this.k[this.l]);
        f1 = paramFloat2;
        if (paramFloat2 < 0.0F) {
          f1 = 0.0F;
        }
        paramCanvas.rotate(paramFloat1 + f1 - 0.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
        paramCanvas.drawPath(this.q, this.c);
        return;
        label221:
        this.q.reset();
      }
    }
    
    public void draw(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = this.a;
      localRectF.set(paramRect);
      localRectF.inset(this.j, this.j);
      float f1 = (this.f + this.h) * 360.0F;
      float f2 = (this.g + this.h) * 360.0F - f1;
      this.b.setColor(this.k[this.l]);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      a(paramCanvas, f1, f2, paramRect);
      if (this.v < 255)
      {
        this.e.setColor(this.w);
        this.e.setAlpha(255 - this.v);
        paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.e);
      }
    }
    
    public int getAlpha()
    {
      return this.v;
    }
    
    public double getCenterRadius()
    {
      return this.s;
    }
    
    public float getEndTrim()
    {
      return this.g;
    }
    
    public float getInsets()
    {
      return this.j;
    }
    
    public float getRotation()
    {
      return this.h;
    }
    
    public float getStartTrim()
    {
      return this.f;
    }
    
    public float getStartingEndTrim()
    {
      return this.n;
    }
    
    public float getStartingRotation()
    {
      return this.o;
    }
    
    public float getStartingStartTrim()
    {
      return this.m;
    }
    
    public float getStrokeWidth()
    {
      return this.i;
    }
    
    public void goToNextColor()
    {
      this.l = ((this.l + 1) % this.k.length);
    }
    
    public void resetOriginals()
    {
      this.m = 0.0F;
      this.n = 0.0F;
      this.o = 0.0F;
      setStartTrim(0.0F);
      setEndTrim(0.0F);
      setRotation(0.0F);
    }
    
    public void setAlpha(int paramInt)
    {
      this.v = paramInt;
    }
    
    public void setArrowDimensions(float paramFloat1, float paramFloat2)
    {
      this.t = ((int)paramFloat1);
      this.u = ((int)paramFloat2);
    }
    
    public void setArrowScale(float paramFloat)
    {
      if (paramFloat != this.r)
      {
        this.r = paramFloat;
        a();
      }
    }
    
    public void setBackgroundColor(int paramInt)
    {
      this.w = paramInt;
    }
    
    public void setCenterRadius(double paramDouble)
    {
      this.s = paramDouble;
    }
    
    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
      a();
    }
    
    public void setColorIndex(int paramInt)
    {
      this.l = paramInt;
    }
    
    public void setColors(int[] paramArrayOfInt)
    {
      this.k = paramArrayOfInt;
      setColorIndex(0);
    }
    
    public void setEndTrim(float paramFloat)
    {
      this.g = paramFloat;
      a();
    }
    
    public void setInsets(int paramInt1, int paramInt2)
    {
      float f1 = Math.min(paramInt1, paramInt2);
      if ((this.s <= 0.0D) || (f1 < 0.0F)) {}
      for (f1 = (float)Math.ceil(this.i / 2.0F);; f1 = (float)(f1 / 2.0F - this.s))
      {
        this.j = f1;
        return;
      }
    }
    
    public void setRotation(float paramFloat)
    {
      this.h = paramFloat;
      a();
    }
    
    public void setShowArrow(boolean paramBoolean)
    {
      if (this.p != paramBoolean)
      {
        this.p = paramBoolean;
        a();
      }
    }
    
    public void setStartTrim(float paramFloat)
    {
      this.f = paramFloat;
      a();
    }
    
    public void setStrokeWidth(float paramFloat)
    {
      this.i = paramFloat;
      this.b.setStrokeWidth(paramFloat);
      a();
    }
    
    public void storeOriginals()
    {
      this.m = this.f;
      this.n = this.g;
      this.o = this.h;
    }
  }
  
  private static class c
    extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/lsjwzh/widget/materialloadingprogressbar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */