package com.ziroom.ziroomcustomer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;

public class TouchImageView
  extends ImageView
{
  private View.OnTouchListener A = null;
  private e B = null;
  private float a;
  private Matrix b;
  private Matrix c;
  private h d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float[] i;
  private Context j;
  private c k;
  private ImageView.ScaleType l;
  private boolean m;
  private boolean n;
  private i o;
  private int p;
  private int q;
  private int r;
  private int s;
  private float t;
  private float u;
  private float v;
  private float w;
  private ScaleGestureDetector x;
  private GestureDetector y;
  private GestureDetector.OnDoubleTapListener z = null;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    if (paramFloat3 <= paramFloat2)
    {
      paramFloat2 -= paramFloat3;
      paramFloat3 = 0.0F;
      if (paramFloat1 >= paramFloat3) {
        break label37;
      }
      paramFloat3 = -paramFloat1 + paramFloat3;
    }
    label37:
    do
    {
      return paramFloat3;
      paramFloat3 = paramFloat2 - paramFloat3;
      paramFloat2 = 0.0F;
      break;
      paramFloat3 = f1;
    } while (paramFloat1 <= paramFloat2);
    return -paramFloat1 + paramFloat2;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    case 1073741824: 
    default: 
      return paramInt2;
    case -2147483648: 
      return Math.min(paramInt3, paramInt2);
    }
    return paramInt3;
  }
  
  private PointF a(float paramFloat1, float paramFloat2)
  {
    this.b.getValues(this.i);
    float f2 = getDrawable().getIntrinsicWidth();
    float f1 = getDrawable().getIntrinsicHeight();
    paramFloat1 /= f2;
    paramFloat2 /= f1;
    f1 = this.i[2];
    f2 = getImageWidth();
    float f3 = this.i[5];
    return new PointF(paramFloat1 * f2 + f1, paramFloat2 * getImageHeight() + f3);
  }
  
  private PointF a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.b.getValues(this.i);
    float f4 = getDrawable().getIntrinsicWidth();
    float f3 = getDrawable().getIntrinsicHeight();
    float f1 = this.i[2];
    float f2 = this.i[5];
    f1 = (paramFloat1 - f1) * f4 / getImageWidth();
    f2 = (paramFloat2 - f2) * f3 / getImageHeight();
    paramFloat2 = f2;
    paramFloat1 = f1;
    if (paramBoolean)
    {
      paramFloat1 = Math.min(Math.max(f1, 0.0F), f4);
      paramFloat2 = Math.min(Math.max(f2, 0.0F), f3);
    }
    return new PointF(paramFloat1, paramFloat2);
  }
  
  private void a()
  {
    if ((this.b != null) && (this.q != 0) && (this.p != 0))
    {
      this.b.getValues(this.i);
      this.c.setValues(this.i);
      this.w = this.u;
      this.v = this.t;
      this.s = this.q;
      this.r = this.p;
    }
  }
  
  private void a(double paramDouble, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f2;
    float f1;
    float f3;
    if (paramBoolean)
    {
      f2 = this.g;
      f1 = this.h;
      f3 = this.a;
      this.a = ((float)(this.a * paramDouble));
      if (this.a <= f1) {
        break label93;
      }
      this.a = f1;
      paramDouble = f1 / f3;
    }
    for (;;)
    {
      this.b.postScale((float)paramDouble, (float)paramDouble, paramFloat1, paramFloat2);
      c();
      return;
      f2 = this.e;
      f1 = this.f;
      break;
      label93:
      if (this.a < f2)
      {
        this.a = f2;
        paramDouble = f2 / f3;
      }
    }
  }
  
  private void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramFloat3 < paramInt3)
    {
      this.i[paramInt1] = ((paramInt3 - paramInt4 * this.i[0]) * 0.5F);
      return;
    }
    if (paramFloat1 > 0.0F)
    {
      this.i[paramInt1] = (-((paramFloat3 - paramInt3) * 0.5F));
      return;
    }
    paramFloat1 = (Math.abs(paramFloat1) + paramInt2 * 0.5F) / paramFloat2;
    this.i[paramInt1] = (-(paramFloat1 * paramFloat3 - paramInt3 * 0.5F));
  }
  
  private void a(Context paramContext)
  {
    super.setClickable(true);
    this.j = paramContext;
    this.x = new ScaleGestureDetector(paramContext, new g(null));
    this.y = new GestureDetector(paramContext, new d(null));
    this.b = new Matrix();
    this.c = new Matrix();
    this.i = new float[9];
    this.a = 1.0F;
    if (this.l == null) {
      this.l = ImageView.ScaleType.FIT_CENTER;
    }
    this.e = 1.0F;
    this.f = 3.0F;
    this.g = (0.75F * this.e);
    this.h = (1.25F * this.f);
    setImageMatrix(this.b);
    setScaleType(ImageView.ScaleType.MATRIX);
    setState(h.a);
    this.n = false;
    super.setOnTouchListener(new f(null));
  }
  
  @TargetApi(16)
  private void a(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(paramRunnable);
      return;
    }
    postDelayed(paramRunnable, 16L);
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 <= paramFloat2) {
      paramFloat1 = 0.0F;
    }
    return paramFloat1;
  }
  
  private void b()
  {
    this.b.getValues(this.i);
    float f2 = this.i[2];
    float f1 = this.i[5];
    f2 = a(f2, this.p, getImageWidth());
    f1 = a(f1, this.q, getImageHeight());
    if ((f2 != 0.0F) || (f1 != 0.0F)) {
      this.b.postTranslate(f2, f1);
    }
  }
  
  private void c()
  {
    b();
    this.b.getValues(this.i);
    if (getImageWidth() < this.p) {
      this.i[2] = ((this.p - getImageWidth()) / 2.0F);
    }
    if (getImageHeight() < this.q) {
      this.i[5] = ((this.q - getImageHeight()) / 2.0F);
    }
    this.b.setValues(this.i);
  }
  
  private void d()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0)) {}
    while ((this.b == null) || (this.c == null)) {
      return;
    }
    int i1 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    float f4 = this.p / i1;
    float f5 = this.q / i2;
    float f1 = f5;
    float f2 = f4;
    float f6 = f5;
    float f3 = f4;
    switch (1.a[this.l.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    case 1: 
      f1 = 1.0F;
      f2 = 1.0F;
    case 5: 
      f3 = this.p - i1 * f2;
      f4 = this.q - i2 * f1;
      this.t = (this.p - f3);
      this.u = (this.q - f4);
      if ((!isZoomed()) && (!this.m))
      {
        this.b.setScale(f2, f1);
        this.b.postTranslate(f3 / 2.0F, f4 / 2.0F);
        this.a = 1.0F;
      }
      break;
    }
    for (;;)
    {
      b();
      setImageMatrix(this.b);
      return;
      f1 = Math.max(f4, f5);
      f2 = f1;
      break;
      f6 = Math.min(1.0F, Math.min(f4, f5));
      f3 = f6;
      f1 = Math.min(f3, f6);
      f2 = f1;
      break;
      if ((this.v == 0.0F) || (this.w == 0.0F)) {
        a();
      }
      this.c.getValues(this.i);
      this.i[0] = (this.t / i1 * this.a);
      this.i[4] = (this.u / i2 * this.a);
      f1 = this.i[2];
      f2 = this.i[5];
      f3 = this.v;
      a(2, f1, this.a * f3, getImageWidth(), this.r, this.p, i1);
      a(5, f2, this.w * this.a, getImageHeight(), this.s, this.q, i2);
      this.b.setValues(this.i);
    }
  }
  
  private float getImageHeight()
  {
    return this.u * this.a;
  }
  
  private float getImageWidth()
  {
    return this.t * this.a;
  }
  
  private void setState(h paramh)
  {
    this.d = paramh;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    this.b.getValues(this.i);
    float f1 = this.i[2];
    if (getImageWidth() < this.p) {}
    while (((f1 >= -1.0F) && (paramInt < 0)) || ((Math.abs(f1) + this.p + 1.0F >= getImageWidth()) && (paramInt > 0))) {
      return false;
    }
    return true;
  }
  
  public boolean canScrollHorizontallyFroyo(int paramInt)
  {
    return canScrollHorizontally(paramInt);
  }
  
  public float getCurrentZoom()
  {
    return this.a;
  }
  
  public float getMaxZoom()
  {
    return this.f;
  }
  
  public float getMinZoom()
  {
    return this.e;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.l;
  }
  
  public PointF getScrollPosition()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return null;
    }
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = ((Drawable)localObject).getIntrinsicHeight();
    localObject = a(this.p / 2, this.q / 2, true);
    ((PointF)localObject).x /= i1;
    ((PointF)localObject).y /= i2;
    return (PointF)localObject;
  }
  
  public RectF getZoomedRect()
  {
    if (this.l == ImageView.ScaleType.FIT_XY) {
      throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }
    PointF localPointF1 = a(0.0F, 0.0F, true);
    PointF localPointF2 = a(this.p, this.q, true);
    float f1 = getDrawable().getIntrinsicWidth();
    float f2 = getDrawable().getIntrinsicHeight();
    return new RectF(localPointF1.x / f1, localPointF1.y / f2, localPointF2.x / f1, localPointF2.y / f2);
  }
  
  public boolean isZoomed()
  {
    return this.a != 1.0F;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.n = true;
    this.m = true;
    if (this.o != null)
    {
      setZoom(this.o.a, this.o.b, this.o.c, this.o.d);
      this.o = null;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int i1 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    this.p = a(paramInt1, i3, i1);
    this.q = a(paramInt2, i4, i2);
    setMeasuredDimension(this.p, this.q);
    d();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.a = paramParcelable.getFloat("saveScale");
      this.i = paramParcelable.getFloatArray("matrix");
      this.c.setValues(this.i);
      this.w = paramParcelable.getFloat("matchViewHeight");
      this.v = paramParcelable.getFloat("matchViewWidth");
      this.s = paramParcelable.getInt("viewHeight");
      this.r = paramParcelable.getInt("viewWidth");
      this.m = paramParcelable.getBoolean("imageRendered");
      super.onRestoreInstanceState(paramParcelable.getParcelable("instanceState"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putFloat("saveScale", this.a);
    localBundle.putFloat("matchViewHeight", this.u);
    localBundle.putFloat("matchViewWidth", this.t);
    localBundle.putInt("viewWidth", this.p);
    localBundle.putInt("viewHeight", this.q);
    this.b.getValues(this.i);
    localBundle.putFloatArray("matrix", this.i);
    localBundle.putBoolean("imageRendered", this.m);
    return localBundle;
  }
  
  public void resetZoom()
  {
    this.a = 1.0F;
    d();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    a();
    d();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    a();
    d();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    a();
    d();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    a();
    d();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    this.f = paramFloat;
    this.h = (1.25F * this.f);
  }
  
  public void setMinZoom(float paramFloat)
  {
    this.e = paramFloat;
    this.g = (0.75F * this.e);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.z = paramOnDoubleTapListener;
  }
  
  public void setOnTouchImageViewListener(e parame)
  {
    this.B = parame;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.A = paramOnTouchListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.FIT_START) || (paramScaleType == ImageView.ScaleType.FIT_END)) {
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      super.setScaleType(ImageView.ScaleType.MATRIX);
    }
    do
    {
      return;
      this.l = paramScaleType;
    } while (!this.n);
    setZoom(this);
  }
  
  public void setScrollPosition(float paramFloat1, float paramFloat2)
  {
    setZoom(this.a, paramFloat1, paramFloat2);
  }
  
  public void setZoom(float paramFloat)
  {
    setZoom(paramFloat, 0.5F, 0.5F);
  }
  
  public void setZoom(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    setZoom(paramFloat1, paramFloat2, paramFloat3, this.l);
  }
  
  public void setZoom(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
  {
    if (!this.n)
    {
      this.o = new i(paramFloat1, paramFloat2, paramFloat3, paramScaleType);
      return;
    }
    if (paramScaleType != this.l) {
      setScaleType(paramScaleType);
    }
    resetZoom();
    a(paramFloat1, this.p / 2, this.q / 2, true);
    this.b.getValues(this.i);
    this.i[2] = (-(getImageWidth() * paramFloat2 - this.p * 0.5F));
    this.i[5] = (-(getImageHeight() * paramFloat3 - this.q * 0.5F));
    this.b.setValues(this.i);
    b();
    setImageMatrix(this.b);
  }
  
  public void setZoom(TouchImageView paramTouchImageView)
  {
    PointF localPointF = paramTouchImageView.getScrollPosition();
    setZoom(paramTouchImageView.getCurrentZoom(), localPointF.x, localPointF.y, paramTouchImageView.getScaleType());
  }
  
  @TargetApi(9)
  private class a
  {
    Scroller a;
    OverScroller b;
    boolean c;
    
    public a(Context paramContext)
    {
      if (Build.VERSION.SDK_INT < 9)
      {
        this.c = true;
        this.a = new Scroller(paramContext);
        return;
      }
      this.c = false;
      this.b = new OverScroller(paramContext);
    }
    
    public boolean computeScrollOffset()
    {
      if (this.c) {
        return this.a.computeScrollOffset();
      }
      this.b.computeScrollOffset();
      return this.b.computeScrollOffset();
    }
    
    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (this.c)
      {
        this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
        return;
      }
      this.b.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void forceFinished(boolean paramBoolean)
    {
      if (this.c)
      {
        this.a.forceFinished(paramBoolean);
        return;
      }
      this.b.forceFinished(paramBoolean);
    }
    
    public int getCurrX()
    {
      if (this.c) {
        return this.a.getCurrX();
      }
      return this.b.getCurrX();
    }
    
    public int getCurrY()
    {
      if (this.c) {
        return this.a.getCurrY();
      }
      return this.b.getCurrY();
    }
    
    public boolean isFinished()
    {
      if (this.c) {
        return this.a.isFinished();
      }
      return this.b.isFinished();
    }
  }
  
  private class b
    implements Runnable
  {
    private long b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
    private PointF i;
    private PointF j;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.e);
      this.b = System.currentTimeMillis();
      this.c = TouchImageView.d(TouchImageView.this);
      this.d = paramFloat1;
      this.g = paramBoolean;
      PointF localPointF = TouchImageView.a(TouchImageView.this, paramFloat2, paramFloat3, false);
      this.e = localPointF.x;
      this.f = localPointF.y;
      this.i = TouchImageView.a(TouchImageView.this, this.e, this.f);
      this.j = new PointF(TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2);
    }
    
    private float a()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.b) / 500.0F);
      return this.h.getInterpolation(f1);
    }
    
    private void a(float paramFloat)
    {
      float f1 = this.i.x;
      float f2 = this.j.x;
      float f3 = this.i.x;
      float f4 = this.i.y;
      float f5 = this.j.y;
      float f6 = this.i.y;
      PointF localPointF = TouchImageView.a(TouchImageView.this, this.e, this.f);
      TouchImageView.m(TouchImageView.this).postTranslate(f1 + (f2 - f3) * paramFloat - localPointF.x, f4 + (f5 - f6) * paramFloat - localPointF.y);
    }
    
    private double b(float paramFloat)
    {
      return (this.c + (this.d - this.c) * paramFloat) / TouchImageView.d(TouchImageView.this);
    }
    
    public void run()
    {
      float f1 = a();
      double d1 = b(f1);
      TouchImageView.a(TouchImageView.this, d1, this.e, this.f, this.g);
      a(f1);
      TouchImageView.q(TouchImageView.this);
      TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).onMove();
      }
      if (f1 < 1.0F)
      {
        TouchImageView.a(TouchImageView.this, this);
        return;
      }
      TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
    }
  }
  
  private class c
    implements Runnable
  {
    TouchImageView.a a;
    int b;
    int c;
    
    c(int paramInt1, int paramInt2)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.d);
      this.a = new TouchImageView.a(TouchImageView.this, TouchImageView.r(TouchImageView.this));
      TouchImageView.m(TouchImageView.this).getValues(TouchImageView.s(TouchImageView.this));
      int i = (int)TouchImageView.s(TouchImageView.this)[2];
      int j = (int)TouchImageView.s(TouchImageView.this)[5];
      int k;
      int m;
      int n;
      int i1;
      if (TouchImageView.j(TouchImageView.this) > TouchImageView.i(TouchImageView.this))
      {
        k = TouchImageView.i(TouchImageView.this) - (int)TouchImageView.j(TouchImageView.this);
        m = 0;
        if (TouchImageView.l(TouchImageView.this) <= TouchImageView.k(TouchImageView.this)) {
          break label162;
        }
        n = TouchImageView.k(TouchImageView.this) - (int)TouchImageView.l(TouchImageView.this);
        i1 = 0;
      }
      for (;;)
      {
        this.a.fling(i, j, paramInt1, paramInt2, k, m, n, i1);
        this.b = i;
        this.c = j;
        return;
        m = i;
        k = i;
        break;
        label162:
        i1 = j;
        n = j;
      }
    }
    
    public void cancelFling()
    {
      if (this.a != null)
      {
        TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        this.a.forceFinished(true);
      }
    }
    
    public void run()
    {
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).onMove();
      }
      if (this.a.isFinished()) {
        this.a = null;
      }
      while (!this.a.computeScrollOffset()) {
        return;
      }
      int i = this.a.getCurrX();
      int j = this.a.getCurrY();
      int k = this.b;
      int m = this.c;
      this.b = i;
      this.c = j;
      TouchImageView.m(TouchImageView.this).postTranslate(i - k, j - m);
      TouchImageView.n(TouchImageView.this);
      TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
      TouchImageView.a(TouchImageView.this, this);
    }
  }
  
  private class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {}
      for (boolean bool = TouchImageView.a(TouchImageView.this).onDoubleTap(paramMotionEvent);; bool = false)
      {
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) {
          if (TouchImageView.d(TouchImageView.this) != TouchImageView.e(TouchImageView.this)) {
            break label97;
          }
        }
        label97:
        for (float f = TouchImageView.f(TouchImageView.this);; f = TouchImageView.e(TouchImageView.this))
        {
          paramMotionEvent = new TouchImageView.b(TouchImageView.this, f, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
          TouchImageView.a(TouchImageView.this, paramMotionEvent);
          bool = true;
          return bool;
        }
      }
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {
        return TouchImageView.a(TouchImageView.this).onDoubleTapEvent(paramMotionEvent);
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (TouchImageView.b(TouchImageView.this) != null) {
        TouchImageView.b(TouchImageView.this).cancelFling();
      }
      TouchImageView.a(TouchImageView.this, new TouchImageView.c(TouchImageView.this, (int)paramFloat1, (int)paramFloat2));
      TouchImageView.a(TouchImageView.this, TouchImageView.b(TouchImageView.this));
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      TouchImageView.this.performLongClick();
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {
        return TouchImageView.a(TouchImageView.this).onSingleTapConfirmed(paramMotionEvent);
      }
      return TouchImageView.this.performClick();
    }
  }
  
  public static abstract interface e
  {
    public abstract void onMove();
  }
  
  private class f
    implements View.OnTouchListener
  {
    private PointF b = new PointF();
    
    private f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TouchImageView.g(TouchImageView.this).onTouchEvent(paramMotionEvent);
      TouchImageView.h(TouchImageView.this).onTouchEvent(paramMotionEvent);
      PointF localPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.d)) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
        if (TouchImageView.o(TouchImageView.this) != null) {
          TouchImageView.o(TouchImageView.this).onTouch(paramView, paramMotionEvent);
        }
        if (TouchImageView.p(TouchImageView.this) != null) {
          TouchImageView.p(TouchImageView.this).onMove();
        }
        return true;
        this.b.set(localPointF);
        if (TouchImageView.b(TouchImageView.this) != null) {
          TouchImageView.b(TouchImageView.this).cancelFling();
        }
        TouchImageView.a(TouchImageView.this, TouchImageView.h.b);
        continue;
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b)
        {
          float f3 = localPointF.x;
          float f4 = this.b.x;
          float f1 = localPointF.y;
          float f2 = this.b.y;
          f3 = TouchImageView.a(TouchImageView.this, f3 - f4, TouchImageView.i(TouchImageView.this), TouchImageView.j(TouchImageView.this));
          f1 = TouchImageView.a(TouchImageView.this, f1 - f2, TouchImageView.k(TouchImageView.this), TouchImageView.l(TouchImageView.this));
          TouchImageView.m(TouchImageView.this).postTranslate(f3, f1);
          TouchImageView.n(TouchImageView.this);
          this.b.set(localPointF.x, localPointF.y);
          continue;
          TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        }
      }
    }
  }
  
  private class g
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private g() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), true);
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this).onMove();
      }
      return true;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.c);
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      super.onScaleEnd(paramScaleGestureDetector);
      TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
      int i = 0;
      float f = TouchImageView.d(TouchImageView.this);
      if (TouchImageView.d(TouchImageView.this) > TouchImageView.f(TouchImageView.this))
      {
        f = TouchImageView.f(TouchImageView.this);
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramScaleGestureDetector = new TouchImageView.b(TouchImageView.this, f, TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2, true);
          TouchImageView.a(TouchImageView.this, paramScaleGestureDetector);
        }
        return;
        if (TouchImageView.d(TouchImageView.this) < TouchImageView.e(TouchImageView.this))
        {
          f = TouchImageView.e(TouchImageView.this);
          i = 1;
        }
      }
    }
  }
  
  private static enum h
  {
    private h() {}
  }
  
  private class i
  {
    public float a;
    public float b;
    public float c;
    public ImageView.ScaleType d;
    
    public i(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramScaleType;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */