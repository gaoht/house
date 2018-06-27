package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;

class x
  extends RecyclerView.g
  implements RecyclerView.k
{
  private static final int[] g = { 16842919 };
  private static final int[] h = new int[0];
  private final int[] A = new int[2];
  private final ValueAnimator B = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private int C = 0;
  private final Runnable D = new Runnable()
  {
    public void run()
    {
      x.this.a(500);
    }
  };
  private final RecyclerView.l E = new RecyclerView.l()
  {
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      x.this.a(paramAnonymousRecyclerView.computeHorizontalScrollOffset(), paramAnonymousRecyclerView.computeVerticalScrollOffset());
    }
  };
  int a;
  int b;
  float c;
  int d;
  int e;
  float f;
  private final int i;
  private final int j;
  private final StateListDrawable k;
  private final Drawable l;
  private final int m;
  private final int n;
  private final StateListDrawable o;
  private final Drawable p;
  private final int q;
  private final int r;
  private int s = 0;
  private int t = 0;
  private RecyclerView u;
  private boolean v = false;
  private boolean w = false;
  private int x = 0;
  private int y = 0;
  private final int[] z = new int[2];
  
  x(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = paramStateListDrawable1;
    this.l = paramDrawable1;
    this.o = paramStateListDrawable2;
    this.p = paramDrawable2;
    this.m = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.n = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.q = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.r = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.i = paramInt2;
    this.j = paramInt3;
    this.k.setAlpha(255);
    this.l.setAlpha(255);
    this.B.addListener(new a(null));
    this.B.addUpdateListener(new b(null));
    attachToRecyclerView(paramRecyclerView);
  }
  
  private int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i1 == 0) {}
    do
    {
      return 0;
      paramFloat1 = (paramFloat2 - paramFloat1) / i1;
      paramInt1 -= paramInt3;
      paramInt3 = (int)(paramFloat1 * paramInt1);
      paramInt2 += paramInt3;
    } while ((paramInt2 >= paramInt1) || (paramInt2 < 0));
    return paramInt3;
  }
  
  private void a()
  {
    this.u.addItemDecoration(this);
    this.u.addOnItemTouchListener(this);
    this.u.addOnScrollListener(this.E);
  }
  
  private void a(float paramFloat)
  {
    int[] arrayOfInt = f();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.b - paramFloat) < 2.0F) {
      return;
    }
    int i1 = a(this.c, paramFloat, arrayOfInt, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
    if (i1 != 0) {
      this.u.scrollBy(0, i1);
    }
    this.c = paramFloat;
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = this.s - this.m;
    int i2 = this.b - this.a / 2;
    this.k.setBounds(0, 0, this.m, this.a);
    this.l.setBounds(0, 0, this.n, this.t);
    if (d())
    {
      this.l.draw(paramCanvas);
      paramCanvas.translate(this.m, i2);
      paramCanvas.scale(-1.0F, 1.0F);
      this.k.draw(paramCanvas);
      paramCanvas.scale(1.0F, 1.0F);
      paramCanvas.translate(-this.m, -i2);
      return;
    }
    paramCanvas.translate(i1, 0.0F);
    this.l.draw(paramCanvas);
    paramCanvas.translate(0.0F, i2);
    this.k.draw(paramCanvas);
    paramCanvas.translate(-i1, -i2);
  }
  
  private void b()
  {
    this.u.removeItemDecoration(this);
    this.u.removeOnItemTouchListener(this);
    this.u.removeOnScrollListener(this.E);
    e();
  }
  
  private void b(float paramFloat)
  {
    int[] arrayOfInt = g();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.e - paramFloat) < 2.0F) {
      return;
    }
    int i1 = a(this.f, paramFloat, arrayOfInt, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
    if (i1 != 0) {
      this.u.scrollBy(i1, 0);
    }
    this.f = paramFloat;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == 2) && (this.x != 2))
    {
      this.k.setState(g);
      e();
    }
    if (paramInt == 0)
    {
      c();
      if ((this.x != 2) || (paramInt == 2)) {
        break label80;
      }
      this.k.setState(h);
      c(1200);
    }
    for (;;)
    {
      this.x = paramInt;
      return;
      show();
      break;
      label80:
      if (paramInt == 1) {
        c(1500);
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = this.t - this.q;
    int i2 = this.e - this.d / 2;
    this.o.setBounds(0, 0, this.d, this.q);
    this.p.setBounds(0, 0, this.s, this.r);
    paramCanvas.translate(0.0F, i1);
    this.p.draw(paramCanvas);
    paramCanvas.translate(i2, 0.0F);
    this.o.draw(paramCanvas);
    paramCanvas.translate(-i2, -i1);
  }
  
  private void c()
  {
    this.u.invalidate();
  }
  
  private void c(int paramInt)
  {
    e();
    this.u.postDelayed(this.D, paramInt);
  }
  
  private boolean d()
  {
    return ViewCompat.getLayoutDirection(this.u) == 1;
  }
  
  private void e()
  {
    this.u.removeCallbacks(this.D);
  }
  
  private int[] f()
  {
    this.z[0] = this.j;
    this.z[1] = (this.t - this.j);
    return this.z;
  }
  
  private int[] g()
  {
    this.A[0] = this.j;
    this.A[1] = (this.s - this.j);
    return this.A;
  }
  
  void a(int paramInt)
  {
    switch (this.C)
    {
    default: 
      return;
    case 1: 
      this.B.cancel();
    }
    this.C = 3;
    this.B.setFloatValues(new float[] { ((Float)this.B.getAnimatedValue()).floatValue(), 0.0F });
    this.B.setDuration(paramInt);
    this.B.start();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i1 = this.u.computeVerticalScrollRange();
    int i2 = this.t;
    boolean bool;
    int i3;
    int i4;
    if ((i1 - i2 > 0) && (this.t >= this.i))
    {
      bool = true;
      this.v = bool;
      i3 = this.u.computeHorizontalScrollRange();
      i4 = this.s;
      if ((i3 - i4 <= 0) || (this.s < this.i)) {
        break label117;
      }
      bool = true;
      label78:
      this.w = bool;
      if ((this.v) || (this.w)) {
        break label123;
      }
      if (this.x != 0) {
        b(0);
      }
    }
    label117:
    label123:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label78;
      if (this.v)
      {
        this.b = ((int)((paramInt2 + i2 / 2.0F) * i2 / i1));
        this.a = Math.min(i2, i2 * i2 / i1);
      }
      if (this.w)
      {
        this.e = ((int)((paramInt1 + i4 / 2.0F) * i4 / i3));
        this.d = Math.min(i4, i4 * i4 / i3);
      }
    } while ((this.x != 0) && (this.x != 1));
    b(1);
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    if (d())
    {
      if (paramFloat1 > this.m / 2) {}
    }
    else {
      while (paramFloat1 >= this.s - this.m)
      {
        if ((paramFloat2 < this.b - this.a / 2) || (paramFloat2 > this.b + this.a / 2)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView)
  {
    if (this.u == paramRecyclerView) {}
    do
    {
      return;
      if (this.u != null) {
        b();
      }
      this.u = paramRecyclerView;
    } while (this.u == null);
    a();
  }
  
  boolean b(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.t - this.q) && (paramFloat1 >= this.e - this.d / 2) && (paramFloat1 <= this.e + this.d / 2);
  }
  
  public void hide()
  {
    a(0);
  }
  
  public boolean isDragging()
  {
    return this.x == 2;
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    if ((this.s != this.u.getWidth()) || (this.t != this.u.getHeight()))
    {
      this.s = this.u.getWidth();
      this.t = this.u.getHeight();
      b(0);
    }
    do
    {
      do
      {
        return;
      } while (this.C == 0);
      if (this.v) {
        a(paramCanvas);
      }
    } while (!this.w);
    b(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (this.x == 1)
    {
      bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool1) || (bool2))) {
        if (bool2)
        {
          this.y = 1;
          this.f = ((int)paramMotionEvent.getX());
          b(2);
        }
      }
    }
    while (this.x == 2)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        return true;
        if (bool1)
        {
          this.y = 2;
          this.c = ((int)paramMotionEvent.getY());
        }
      }
      return false;
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (this.x == 0) {}
    do
    {
      do
      {
        boolean bool1;
        boolean bool2;
        do
        {
          return;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          bool2 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
        } while ((!bool1) && (!bool2));
        if (bool2)
        {
          this.y = 1;
          this.f = ((int)paramMotionEvent.getX());
        }
        for (;;)
        {
          b(2);
          return;
          if (bool1)
          {
            this.y = 2;
            this.c = ((int)paramMotionEvent.getY());
          }
        }
        if ((paramMotionEvent.getAction() == 1) && (this.x == 2))
        {
          this.c = 0.0F;
          this.f = 0.0F;
          b(1);
          this.y = 0;
          return;
        }
      } while ((paramMotionEvent.getAction() != 2) || (this.x != 2));
      show();
      if (this.y == 1) {
        b(paramMotionEvent.getX());
      }
    } while (this.y != 2);
    a(paramMotionEvent.getY());
  }
  
  public void show()
  {
    switch (this.C)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.B.cancel();
    }
    this.C = 1;
    this.B.setFloatValues(new float[] { ((Float)this.B.getAnimatedValue()).floatValue(), 1.0F });
    this.B.setDuration(500L);
    this.B.setStartDelay(0L);
    this.B.start();
  }
  
  private class a
    extends AnimatorListenerAdapter
  {
    private boolean b = false;
    
    private a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.b = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.b)
      {
        this.b = false;
        return;
      }
      if (((Float)x.a(x.this).getAnimatedValue()).floatValue() == 0.0F)
      {
        x.a(x.this, 0);
        x.b(x.this, 0);
        return;
      }
      x.a(x.this, 2);
      x.b(x.this);
    }
  }
  
  private class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    private b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      x.c(x.this).setAlpha(i);
      x.d(x.this).setAlpha(i);
      x.b(x.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */