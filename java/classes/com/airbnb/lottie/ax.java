package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ax
  extends Drawable
  implements Drawable.Callback
{
  private static final String a = ax.class.getSimpleName();
  private final Matrix b = new Matrix();
  private aw c;
  private final ValueAnimator d = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private float e = 1.0F;
  private float f = 0.0F;
  private float g = 1.0F;
  private final Set<a> h = new HashSet();
  private an i;
  private String j;
  private ao k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private v p;
  private int q = 255;
  
  public ax()
  {
    this.d.setRepeatCount(0);
    this.d.setInterpolator(new LinearInterpolator());
    this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (ax.a(ax.this))
        {
          ax.b(ax.this).cancel();
          ax.this.setProgress(1.0F);
          return;
        }
        ax.this.setProgress(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
  }
  
  private float a(Canvas paramCanvas)
  {
    return Math.min(paramCanvas.getWidth() / this.c.getBounds().width(), paramCanvas.getHeight() / this.c.getBounds().height());
  }
  
  private void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    a locala = new a(paramString1, paramString2, paramColorFilter);
    if ((paramColorFilter == null) && (this.h.contains(locala))) {
      this.h.remove(locala);
    }
    while (this.p == null)
    {
      return;
      this.h.add(new a(paramString1, paramString2, paramColorFilter));
    }
    this.p.addColorFilter(paramString1, paramString2, paramColorFilter);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.p == null)
    {
      this.l = true;
      this.m = false;
      return;
    }
    if (paramBoolean) {}
    for (long l1 = (this.f * (float)this.d.getDuration());; l1 = 0L)
    {
      this.d.start();
      if (!paramBoolean) {
        break;
      }
      this.d.setCurrentPlayTime(l1);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.p == null)
    {
      this.l = false;
      this.m = true;
      return;
    }
    if (paramBoolean) {
      this.d.setCurrentPlayTime((this.f * (float)this.d.getDuration()));
    }
    this.d.reverse();
  }
  
  private void c()
  {
    this.p = new v(this, av.a.a(this.c), this.c.b(), this.c);
  }
  
  private void d()
  {
    if (this.p == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        this.p.addColorFilter(locala.a, locala.b, locala.c);
      }
    }
  }
  
  private void e()
  {
    recycleBitmaps();
    this.p = null;
    this.i = null;
    invalidateSelf();
  }
  
  private void f()
  {
    if (this.c == null) {
      return;
    }
    setBounds(0, 0, (int)(this.c.getBounds().width() * this.g), (int)(this.c.getBounds().height() * this.g));
  }
  
  private an g()
  {
    if (getCallback() == null) {
      return null;
    }
    if ((this.i != null) && (!this.i.a(h())))
    {
      this.i.a();
      this.i = null;
    }
    if (this.i == null) {
      this.i = new an(getCallback(), this.j, this.k, this.c.c());
    }
    return this.i;
  }
  
  private Context h()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {
      return null;
    }
    if ((localCallback instanceof View)) {
      return ((View)localCallback).getContext();
    }
    return null;
  }
  
  Bitmap a(String paramString)
  {
    an localan = g();
    if (localan != null) {
      return localan.a(paramString);
    }
    return null;
  }
  
  boolean a()
  {
    return this.o;
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.d.addListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.d.addUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void addColorFilter(ColorFilter paramColorFilter)
  {
    a(null, null, paramColorFilter);
  }
  
  public void addColorFilterToContent(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    a(paramString1, paramString2, paramColorFilter);
  }
  
  public void addColorFilterToLayer(String paramString, ColorFilter paramColorFilter)
  {
    a(paramString, null, paramColorFilter);
  }
  
  void b()
  {
    this.n = true;
  }
  
  public void cancelAnimation()
  {
    this.l = false;
    this.m = false;
    this.d.cancel();
  }
  
  public void clearColorFilters()
  {
    this.h.clear();
    a(null, null, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.p == null) {
      return;
    }
    float f1 = this.g;
    if (this.p.e()) {
      f1 = Math.min(this.g, a(paramCanvas));
    }
    this.b.reset();
    this.b.preScale(f1, f1);
    this.p.draw(paramCanvas, this.b, this.q);
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19) {
      Log.w(a, "Merge paths are not supported pre-Kit Kat.");
    }
    do
    {
      return;
      this.o = paramBoolean;
    } while (this.c == null);
    c();
  }
  
  public int getAlpha()
  {
    return this.q;
  }
  
  public aw getComposition()
  {
    return this.c;
  }
  
  public String getImageAssetsFolder()
  {
    return this.j;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.c == null) {
      return -1;
    }
    return (int)(this.c.getBounds().height() * this.g);
  }
  
  public int getIntrinsicWidth()
  {
    if (this.c == null) {
      return -1;
    }
    return (int)(this.c.getBounds().width() * this.g);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float getProgress()
  {
    return this.f;
  }
  
  public float getScale()
  {
    return this.g;
  }
  
  public boolean hasMasks()
  {
    return (this.p != null) && (this.p.d());
  }
  
  public boolean hasMatte()
  {
    return (this.p != null) && (this.p.e());
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.invalidateDrawable(this);
  }
  
  public void invalidateSelf()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public boolean isAnimating()
  {
    return this.d.isRunning();
  }
  
  public boolean isLooping()
  {
    return this.d.getRepeatCount() == -1;
  }
  
  public void loop(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.d;
    if (paramBoolean) {}
    for (int i1 = -1;; i1 = 0)
    {
      localValueAnimator.setRepeatCount(i1);
      return;
    }
  }
  
  public void playAnimation()
  {
    if ((this.f > 0.0D) && (this.f < 1.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void recycleBitmaps()
  {
    if (this.i != null) {
      this.i.a();
    }
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.d.removeListener(paramAnimatorListener);
  }
  
  public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.d.removeUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void resumeAnimation()
  {
    a(true);
  }
  
  public void resumeReverseAnimation()
  {
    b(true);
  }
  
  public void reverseAnimation()
  {
    if ((this.f > 0.0D) && (this.f < 1.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setComposition(aw paramaw)
  {
    if (this.c == paramaw) {
      return false;
    }
    e();
    this.c = paramaw;
    setSpeed(this.e);
    f();
    c();
    d();
    setProgress(this.f);
    if (this.l)
    {
      this.l = false;
      playAnimation();
    }
    if (this.m)
    {
      this.m = false;
      reverseAnimation();
    }
    return true;
  }
  
  public void setImageAssetDelegate(ao paramao)
  {
    this.k = paramao;
    if (this.i != null) {
      this.i.a(paramao);
    }
  }
  
  public void setImagesAssetsFolder(String paramString)
  {
    this.j = paramString;
  }
  
  public void setProgress(float paramFloat)
  {
    this.f = paramFloat;
    if (this.p != null) {
      this.p.setProgress(paramFloat);
    }
  }
  
  public void setScale(float paramFloat)
  {
    this.g = paramFloat;
    f();
  }
  
  public void setSpeed(float paramFloat)
  {
    this.e = paramFloat;
    if (paramFloat < 0.0F) {
      this.d.setFloatValues(new float[] { 1.0F, 0.0F });
    }
    for (;;)
    {
      if (this.c != null) {
        this.d.setDuration(((float)this.c.getDuration() / Math.abs(paramFloat)));
      }
      return;
      this.d.setFloatValues(new float[] { 0.0F, 1.0F });
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  public Bitmap updateBitmap(String paramString, Bitmap paramBitmap)
  {
    an localan = g();
    if (localan == null)
    {
      Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
      return null;
    }
    paramString = localan.a(paramString, paramBitmap);
    invalidateSelf();
    return paramString;
  }
  
  private static class a
  {
    final String a;
    final String b;
    final ColorFilter c;
    
    a(String paramString1, String paramString2, ColorFilter paramColorFilter)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramColorFilter;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((hashCode() == ((a)paramObject).hashCode()) && (this.c == ((a)paramObject).c));
      return false;
    }
    
    public int hashCode()
    {
      int i = 17;
      if (this.a != null) {
        i = this.a.hashCode() * 527;
      }
      int j = i;
      if (this.b != null) {
        j = i * 31 * this.b.hashCode();
      }
      return j;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */