package com.ziroom.ziroomcustomer.minsu.chat.photoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class b
  implements GestureDetector.OnDoubleTapListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, e.d
{
  static final boolean a = Log.isLoggable("PhotoViewAttacher", 3);
  private float b = 1.0F;
  private float c = 2.0F;
  private boolean d = true;
  private WeakReference<ImageView> e;
  private ViewTreeObserver f;
  private GestureDetector g;
  private e h;
  private final Matrix i = new Matrix();
  private final Matrix j = new Matrix();
  private final Matrix k = new Matrix();
  private final RectF l = new RectF();
  private final float[] m = new float[9];
  private c n;
  private d o;
  private e p;
  private View.OnLongClickListener q;
  private int r;
  private int s;
  private int t;
  private int u;
  private b v;
  private int w = 2;
  private boolean x;
  private ImageView.ScaleType y = ImageView.ScaleType.FIT_CENTER;
  
  public b(ImageView paramImageView)
  {
    this.e = new WeakReference(paramImageView);
    paramImageView.setOnTouchListener(this);
    this.f = paramImageView.getViewTreeObserver();
    this.f.addOnGlobalLayoutListener(this);
    b(paramImageView);
    if (!paramImageView.isInEditMode())
    {
      this.h = e.newInstance(paramImageView.getContext(), this);
      this.g = new GestureDetector(paramImageView.getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          if (b.a(b.this) != null) {
            b.a(b.this).onLongClick((View)b.b(b.this).get());
          }
        }
      });
      this.g.setOnDoubleTapListener(this);
      setZoomable(true);
    }
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.m);
    return this.m[paramInt];
  }
  
  private RectF a(Matrix paramMatrix)
  {
    Object localObject = getImageView();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        this.l.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(this.l);
        return this.l;
      }
    }
    return null;
  }
  
  private static void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("MinZoom should be less than maxZoom");
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    Object localObject = getImageView();
    if ((localObject == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = ((ImageView)localObject).getWidth();
    float f2 = ((ImageView)localObject).getHeight();
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.i.reset();
    float f3 = f1 / i1;
    float f4 = f2 / i2;
    if (this.y == ImageView.ScaleType.CENTER) {
      this.i.postTranslate((f1 - i1) / 2.0F, (f2 - i2) / 2.0F);
    }
    for (;;)
    {
      f();
      return;
      if (this.y == ImageView.ScaleType.CENTER_CROP)
      {
        f3 = Math.max(f3, f4);
        this.i.postScale(f3, f3);
        this.i.postTranslate((f1 - i1 * f3) / 2.0F, (f2 - i2 * f3) / 2.0F);
      }
      else if (this.y == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        this.i.postScale(f3, f3);
        this.i.postTranslate((f1 - i1 * f3) / 2.0F, (f2 - i2 * f3) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, i1, i2);
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        switch (2.a[this.y.ordinal()])
        {
        default: 
          break;
        case 2: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
          break;
        case 4: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
          break;
        case 3: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          break;
        case 5: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  private static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (2.a[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }
  
  private static boolean a(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }
  
  private void b()
  {
    if (this.v != null)
    {
      this.v.cancelFling();
      this.v = null;
    }
  }
  
  private void b(Matrix paramMatrix)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      d();
      localImageView.setImageMatrix(paramMatrix);
      if (this.n != null)
      {
        paramMatrix = a(paramMatrix);
        if (paramMatrix != null) {
          this.n.onMatrixChanged(paramMatrix);
        }
      }
    }
  }
  
  private static void b(ImageView paramImageView)
  {
    if ((paramImageView == null) || ((paramImageView instanceof MinsuChatPhotoView))) {
      return;
    }
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void c()
  {
    e();
    b(a());
  }
  
  private void d()
  {
    ImageView localImageView = getImageView();
    if ((localImageView != null) && (!(localImageView instanceof MinsuChatPhotoView)) && (localImageView.getScaleType() != ImageView.ScaleType.MATRIX)) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
    }
  }
  
  private void e()
  {
    float f2 = 0.0F;
    ImageView localImageView = getImageView();
    if (localImageView == null) {}
    RectF localRectF;
    do
    {
      return;
      localRectF = a(a());
    } while (localRectF == null);
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int i1 = localImageView.getHeight();
    if (f1 <= i1) {
      switch (2.a[this.y.ordinal()])
      {
      default: 
        f1 = (i1 - f1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      i1 = localImageView.getWidth();
      if (f3 <= i1) {
        switch (2.a[this.y.ordinal()])
        {
        default: 
          f2 = (i1 - f3) / 2.0F - localRectF.left;
          label166:
          this.w = 2;
        }
      }
      for (;;)
      {
        this.k.postTranslate(f2, f1);
        return;
        f1 = -localRectF.top;
        break;
        f1 = i1 - f1 - localRectF.top;
        break;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i1) {
          break label340;
        }
        f1 = i1 - localRectF.bottom;
        break;
        f2 = -localRectF.left;
        break label166;
        f2 = i1 - f3 - localRectF.left;
        break label166;
        if (localRectF.left > 0.0F)
        {
          this.w = 0;
          f2 = -localRectF.left;
        }
        else if (localRectF.right < i1)
        {
          f2 = i1 - localRectF.right;
          this.w = 1;
        }
        else
        {
          this.w = -1;
        }
      }
      label340:
      f1 = 0.0F;
    }
  }
  
  private void f()
  {
    this.k.reset();
    b(a());
    e();
  }
  
  protected Matrix a()
  {
    this.j.set(this.i);
    this.j.postConcat(this.k);
    return this.j;
  }
  
  public final boolean canZoom()
  {
    return this.x;
  }
  
  @SuppressLint({"NewApi"})
  public final void cleanup()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.e != null) {
        ((ImageView)this.e.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((this.f != null) && (this.f.isAlive()))
      {
        this.f.removeOnGlobalLayoutListener(this);
        this.f = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.e = null;
      }
    }
    do
    {
      return;
      if (this.e != null) {
        ((ImageView)this.e.get()).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    } while ((this.f == null) || (!this.f.isAlive()));
    this.f.removeGlobalOnLayoutListener(this);
    this.f = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.e = null;
  }
  
  public final RectF getDisplayRect()
  {
    e();
    return a(a());
  }
  
  public final ImageView getImageView()
  {
    ImageView localImageView = null;
    if (this.e != null) {
      localImageView = (ImageView)this.e.get();
    }
    if (localImageView == null)
    {
      cleanup();
      throw new IllegalStateException("ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return localImageView;
  }
  
  public float getMaxScale()
  {
    return this.c;
  }
  
  public float getMidScale()
  {
    return 0.0F;
  }
  
  public float getMinScale()
  {
    return this.b;
  }
  
  public final float getScale()
  {
    return a(this.k, 0);
  }
  
  public final ImageView.ScaleType getScaleType()
  {
    return this.y;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = getScale();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.c) {
        zoomTo(this.c, f2, f3);
      } else {
        zoomTo(this.b, f2, f3);
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return true;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void onDrag(float paramFloat1, float paramFloat2)
  {
    if (a) {
      Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
    }
    ImageView localImageView = getImageView();
    if ((localImageView != null) && (a(localImageView)))
    {
      this.k.postTranslate(paramFloat1, paramFloat2);
      c();
      if ((this.d) && (!this.h.isScaling()) && ((this.w == 2) || ((this.w == 0) && (paramFloat1 >= 1.0F)) || ((this.w == 1) && (paramFloat1 <= -1.0F)))) {
        localImageView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public final void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (a) {
      Log.d("PhotoViewAttacher", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
    }
    ImageView localImageView = getImageView();
    if (a(localImageView))
    {
      this.v = new b(localImageView.getContext());
      this.v.fling(localImageView.getWidth(), localImageView.getHeight(), (int)paramFloat3, (int)paramFloat4);
      localImageView.post(this.v);
    }
  }
  
  public final void onGlobalLayout()
  {
    ImageView localImageView = getImageView();
    if ((localImageView != null) && (this.x))
    {
      int i1 = localImageView.getTop();
      int i2 = localImageView.getRight();
      int i3 = localImageView.getBottom();
      int i4 = localImageView.getLeft();
      if ((i1 != this.r) || (i3 != this.t) || (i4 != this.u) || (i2 != this.s))
      {
        a(localImageView.getDrawable());
        this.r = i1;
        this.s = i2;
        this.t = i3;
        this.u = i4;
      }
    }
  }
  
  public final void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (a) {
      Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    if ((a(getImageView())) && ((getScale() < this.c) || (paramFloat1 < 1.0F)))
    {
      this.k.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      c();
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if (this.o != null)
      {
        RectF localRectF = getDisplayRect();
        if (localRectF != null)
        {
          float f2 = paramMotionEvent.getX();
          float f1 = paramMotionEvent.getY();
          if (localRectF.contains(f2, f1))
          {
            f2 = (f2 - localRectF.left) / localRectF.width();
            f1 = (f1 - localRectF.top) / localRectF.height();
            this.o.onPhotoTap(localImageView, f2, f1);
            return true;
          }
        }
      }
      if (this.p != null) {
        this.p.onViewTap(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.x)
    {
      bool1 = bool2;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.g != null)
      {
        bool2 = bool1;
        if (this.g.onTouchEvent(paramMotionEvent)) {
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (this.h != null)
      {
        bool1 = bool2;
        if (this.h.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      return bool1;
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      b();
      bool1 = bool2;
      continue;
      bool1 = bool2;
      if (getScale() < this.b)
      {
        RectF localRectF = getDisplayRect();
        bool1 = bool2;
        if (localRectF != null)
        {
          paramView.post(new a(getScale(), this.b, localRectF.centerX(), localRectF.centerY()));
          bool1 = true;
        }
      }
    }
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setMaxScale(float paramFloat)
  {
    a(this.b, paramFloat);
    this.c = paramFloat;
  }
  
  public void setMidScale(float paramFloat) {}
  
  public void setMinScale(float paramFloat)
  {
    a(paramFloat, this.c);
    this.b = paramFloat;
  }
  
  public final void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.q = paramOnLongClickListener;
  }
  
  public final void setOnMatrixChangeListener(c paramc)
  {
    this.n = paramc;
  }
  
  public final void setOnPhotoTapListener(d paramd)
  {
    this.o = paramd;
  }
  
  public final void setOnViewTapListener(e parame)
  {
    this.p = parame;
  }
  
  public final void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((a(paramScaleType)) && (paramScaleType != this.y))
    {
      this.y = paramScaleType;
      update();
    }
  }
  
  public final void setZoomable(boolean paramBoolean)
  {
    this.x = paramBoolean;
    update();
  }
  
  public final void update()
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if (this.x)
      {
        b(localImageView);
        a(localImageView.getDrawable());
      }
    }
    else {
      return;
    }
    f();
  }
  
  public final void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null) {
      localImageView.post(new a(getScale(), paramFloat1, paramFloat2, paramFloat3));
    }
  }
  
  private class a
    implements Runnable
  {
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.d = paramFloat2;
      this.b = paramFloat3;
      this.c = paramFloat4;
      if (paramFloat1 < paramFloat2)
      {
        this.e = 1.07F;
        return;
      }
      this.e = 0.93F;
    }
    
    public void run()
    {
      ImageView localImageView = b.this.getImageView();
      if (localImageView != null)
      {
        b.c(b.this).postScale(this.e, this.e, this.b, this.c);
        b.d(b.this);
        f = b.this.getScale();
        if (((this.e > 1.0F) && (f < this.d)) || ((this.e < 1.0F) && (this.d < f))) {
          a.postOnAnimation(localImageView, this);
        }
      }
      else
      {
        return;
      }
      float f = this.d / f;
      b.c(b.this).postScale(f, f, this.b, this.c);
      b.d(b.this);
    }
  }
  
  private class b
    implements Runnable
  {
    private final d b;
    private int c;
    private int d;
    
    public b(Context paramContext)
    {
      this.b = d.getScroller(paramContext);
    }
    
    public void cancelFling()
    {
      if (b.a) {
        Log.d("PhotoViewAttacher", "Cancel Fling");
      }
      this.b.forceFinished(true);
    }
    
    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RectF localRectF = b.this.getDisplayRect();
      if (localRectF == null) {
        return;
      }
      int i = Math.round(-localRectF.left);
      int j;
      label52:
      int k;
      int m;
      if (paramInt1 < localRectF.width())
      {
        j = Math.round(localRectF.width() - paramInt1);
        paramInt1 = 0;
        k = Math.round(-localRectF.top);
        if (paramInt2 >= localRectF.height()) {
          break label210;
        }
        m = Math.round(localRectF.height() - paramInt2);
      }
      for (paramInt2 = 0;; paramInt2 = k)
      {
        this.c = i;
        this.d = k;
        if (b.a) {
          Log.d("PhotoViewAttacher", "fling. StartX:" + i + " StartY:" + k + " MaxX:" + j + " MaxY:" + m);
        }
        if ((i == j) && (k == m)) {
          break;
        }
        this.b.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
        return;
        j = i;
        paramInt1 = i;
        break label52;
        label210:
        m = k;
      }
    }
    
    public void run()
    {
      ImageView localImageView = b.this.getImageView();
      if ((localImageView != null) && (this.b.computeScrollOffset()))
      {
        int i = this.b.getCurrX();
        int j = this.b.getCurrY();
        if (b.a) {
          Log.d("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + i + " NewY:" + j);
        }
        b.c(b.this).postTranslate(this.c - i, this.d - j);
        b.a(b.this, b.this.a());
        this.c = i;
        this.d = j;
        a.postOnAnimation(localImageView, this);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onMatrixChanged(RectF paramRectF);
  }
  
  public static abstract interface d
  {
    public abstract void onPhotoTap(View paramView, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface e
  {
    public abstract void onViewTap(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/photoview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */