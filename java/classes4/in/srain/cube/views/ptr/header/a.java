package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.b.b;
import java.util.ArrayList;

public class a
  extends Drawable
  implements Animatable
{
  private static final Interpolator a = new LinearInterpolator();
  private static final Interpolator b = new a(null);
  private static final Interpolator c = new d(null);
  private static final Interpolator d = new AccelerateDecelerateInterpolator();
  private final int[] e = { -3591113, -13149199, -536002, -13327536 };
  private final ArrayList<Animation> f = new ArrayList();
  private final c g;
  private final Drawable.Callback h = new Drawable.Callback()
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
  private float i;
  private Resources j;
  private View k;
  private Animation l;
  private float m;
  private double n;
  private double o;
  private Animation p;
  private int q;
  private ShapeDrawable r;
  
  public a(Context paramContext, View paramView)
  {
    this.k = paramView;
    this.j = paramContext.getResources();
    this.g = new c(this.h);
    this.g.setColors(this.e);
    updateSizes(1);
    c();
  }
  
  private void a(double paramDouble)
  {
    b.init(this.k.getContext());
    int i1 = b.dp2px(1.75F);
    int i2 = b.dp2px(0.0F);
    int i3 = b.dp2px(3.5F);
    this.r = new ShapeDrawable(new b(i3, (int)paramDouble));
    if (Build.VERSION.SDK_INT >= 11) {
      this.k.setLayerType(1, this.r.getPaint());
    }
    this.r.getPaint().setShadowLayer(i3, i2, i1, 503316480);
  }
  
  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    c localc = this.g;
    float f1 = this.j.getDisplayMetrics().density;
    this.n = (f1 * paramDouble1);
    this.o = (f1 * paramDouble2);
    localc.setStrokeWidth((float)paramDouble4 * f1);
    localc.setCenterRadius(f1 * paramDouble3);
    localc.setColorIndex(0);
    localc.setArrowDimensions(paramFloat1 * f1, f1 * paramFloat2);
    localc.setInsets((int)this.n, (int)this.o);
    a(this.n);
  }
  
  private void c()
  {
    final c localc = this.g;
    Animation local2 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = (float)(Math.floor(localc.getStartingRotation() / 0.8F) + 1.0D);
        float f2 = localc.getStartingStartTrim();
        float f3 = localc.getStartingEndTrim();
        float f4 = localc.getStartingStartTrim();
        localc.setStartTrim(f2 + (f3 - f4) * paramAnonymousFloat);
        f2 = localc.getStartingRotation();
        f3 = localc.getStartingRotation();
        localc.setRotation((f1 - f3) * paramAnonymousFloat + f2);
        localc.setArrowScale(1.0F - paramAnonymousFloat);
      }
    };
    local2.setInterpolator(d);
    local2.setDuration(666L);
    local2.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        localc.goToNextColor();
        localc.storeOriginals();
        localc.setShowArrow(false);
        a.b(a.this).startAnimation(a.a(a.this));
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    Animation local4 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f3 = (float)Math.toRadians(localc.getStrokeWidth() / (6.283185307179586D * localc.getCenterRadius()));
        float f4 = localc.getStartingEndTrim();
        float f1 = localc.getStartingStartTrim();
        float f2 = localc.getStartingRotation();
        float f5 = a.a().getInterpolation(paramAnonymousFloat);
        localc.setEndTrim((0.8F - f3) * f5 + f4);
        f3 = a.b().getInterpolation(paramAnonymousFloat);
        localc.setStartTrim(f3 * 0.8F + f1);
        localc.setRotation(0.25F * paramAnonymousFloat + f2);
        f1 = a.c(a.this) / 5.0F;
        a.this.a(144.0F * paramAnonymousFloat + 720.0F * f1);
      }
    };
    local4.setRepeatCount(-1);
    local4.setRepeatMode(1);
    local4.setInterpolator(a);
    local4.setDuration(1333L);
    local4.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        localc.storeOriginals();
        localc.goToNextColor();
        localc.setStartTrim(localc.getEndTrim());
        a.a(a.this, (a.c(a.this) + 1.0F) % 5.0F);
      }
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        a.a(a.this, 0.0F);
      }
    });
    this.p = local2;
    this.l = local4;
  }
  
  void a(float paramFloat)
  {
    this.i = paramFloat;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.r != null)
    {
      this.r.getPaint().setColor(this.q);
      this.r.draw(paramCanvas);
    }
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.i, localRect.exactCenterX(), localRect.exactCenterY());
    this.g.draw(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }
  
  public int getAlpha()
  {
    return this.g.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.o;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.n;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    ArrayList localArrayList = this.f;
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Animation localAnimation = (Animation)localArrayList.get(i1);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded())) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.g.setAlpha(paramInt);
  }
  
  public void setArrowScale(float paramFloat)
  {
    this.g.setArrowScale(paramFloat);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.q = paramInt;
    this.g.setBackgroundColor(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.g.setColorFilter(paramColorFilter);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    this.g.setColors(paramVarArgs);
    this.g.setColorIndex(0);
  }
  
  public void setProgressRotation(float paramFloat)
  {
    this.g.setRotation(paramFloat);
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    this.g.setStartTrim(paramFloat1);
    this.g.setEndTrim(paramFloat2);
  }
  
  public void showArrow(boolean paramBoolean)
  {
    this.g.setShowArrow(paramBoolean);
  }
  
  public void start()
  {
    this.l.reset();
    this.g.storeOriginals();
    if (this.g.getEndTrim() != this.g.getStartTrim())
    {
      this.k.startAnimation(this.p);
      return;
    }
    this.g.setColorIndex(0);
    this.g.resetOriginals();
    this.k.startAnimation(this.l);
  }
  
  public void stop()
  {
    this.k.clearAnimation();
    a(0.0F);
    this.g.setShowArrow(false);
    this.g.setColorIndex(0);
    this.g.resetOriginals();
  }
  
  public void updateSizes(int paramInt)
  {
    if (paramInt == 0)
    {
      a(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    }
    a(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }
  
  private static class a
    extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.max(0.0F, (paramFloat - 0.5F) * 2.0F));
    }
  }
  
  private class b
    extends OvalShape
  {
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;
    
    public b(int paramInt1, int paramInt2)
    {
      this.c = paramInt1;
      this.e = paramInt2;
      float f1 = this.e / 2;
      float f2 = this.e / 2;
      float f3 = this.c;
      this$1 = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, a.this);
      this.d.setShader(this.b);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = a.this.getBounds().width();
      int j = a.this.getBounds().height();
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2 + this.c, this.d);
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2, paramPaint);
    }
  }
  
  private static class c
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
    
    public c(Drawable.Callback paramCallback)
    {
      this.d = paramCallback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
      this.e.setAntiAlias(true);
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
          break label229;
        }
        this.q = new Path();
        this.q.setFillType(Path.FillType.EVEN_ODD);
      }
      for (;;)
      {
        float f1 = (int)this.j / 2;
        float f2 = this.r;
        float f3 = (float)(this.s * Math.cos(0.0D) + paramRect.exactCenterX());
        float f4 = (float)(this.s * Math.sin(0.0D) + paramRect.exactCenterY());
        this.q.moveTo(0.0F, 0.0F);
        this.q.lineTo(this.t * this.r, 0.0F);
        this.q.lineTo(this.t * this.r / 2.0F, this.u * this.r);
        this.q.offset(f3 - f1 * f2, f4);
        this.q.close();
        this.c.setColor(this.k[this.l]);
        this.c.setAlpha(this.v);
        paramCanvas.rotate(paramFloat1 + paramFloat2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
        paramCanvas.drawPath(this.q, this.c);
        return;
        label229:
        this.q.reset();
      }
    }
    
    public void draw(Canvas paramCanvas, Rect paramRect)
    {
      this.e.setColor(this.w);
      this.e.setAlpha(this.v);
      paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.e);
      RectF localRectF = this.a;
      localRectF.set(paramRect);
      localRectF.inset(this.j, this.j);
      float f1 = (this.f + this.h) * 360.0F;
      float f2 = (this.g + this.h) * 360.0F - f1;
      this.b.setColor(this.k[this.l]);
      this.b.setAlpha(this.v);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      a(paramCanvas, f1, f2, paramRect);
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
  
  private static class d
    extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/header/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */