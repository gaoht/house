package com.ziroom.ziroomcustomer.minsu.searchlist.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class SearchListScrollView
  extends LinearLayout
{
  private boolean A;
  private int B = 0;
  private int C = 0;
  private int D;
  private boolean E;
  private int F = 10;
  private b G;
  private a H;
  private Context a;
  private Scroller b;
  private float c;
  private float d;
  private float e;
  private float f;
  private VelocityTracker g;
  private int h;
  private int i;
  private int j;
  private boolean k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private View r;
  private ViewPager s;
  private a t;
  private int u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private int z;
  
  public SearchListScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchListScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SearchListScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.H = new a();
    this.b = new Scroller(paramContext);
    paramContext = ViewConfiguration.get(paramContext);
    this.h = paramContext.getScaledTouchSlop();
    this.i = paramContext.getScaledMinimumFlingVelocity();
    this.j = paramContext.getScaledMaximumFlingVelocity();
    this.w = Build.VERSION.SDK_INT;
    setOrientation(1);
  }
  
  @TargetApi(14)
  private int a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return 0;
    }
    if (this.w >= 14) {
      return (int)this.b.getCurrVelocity();
    }
    return paramInt1 / paramInt2;
  }
  
  private void a()
  {
    if (this.g == null)
    {
      this.g = VelocityTracker.obtain();
      return;
    }
    this.g.clear();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.E = bool;
      return;
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private void b()
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
  }
  
  public void computeScroll()
  {
    int i1;
    if (this.b.computeScrollOffset())
    {
      i1 = this.b.getCurrY();
      if (this.t != a.a) {
        break label100;
      }
      if (isSticked())
      {
        i1 = this.b.getFinalY() - i1;
        int i2 = b(this.b.getDuration(), this.b.timePassed());
        this.H.smoothScrollBy(a(i1, i2), i1, i2);
        this.b.forceFinished(true);
      }
    }
    else
    {
      return;
    }
    scrollTo(0, i1);
    for (;;)
    {
      this.z = i1;
      return;
      label100:
      if (this.H.isTop())
      {
        scrollTo(0, i1 - this.z + getScrollY());
        if (this.D <= this.B)
        {
          this.b.forceFinished(true);
          return;
        }
      }
      invalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = (int)Math.abs(f1 - this.c);
    int i2 = (int)Math.abs(f2 - this.d);
    switch (paramMotionEvent.getAction())
    {
    }
    label409:
    label438:
    label517:
    label581:
    label589:
    do
    {
      do
      {
        for (;;)
        {
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
          this.A = false;
          this.k = false;
          this.l = paramMotionEvent.getRawX();
          this.m = paramMotionEvent.getRawY();
          this.x = true;
          this.y = true;
          this.c = f1;
          this.d = f2;
          this.e = f1;
          this.f = f2;
          this.v = getScrollY();
          a((int)f2, this.u, getScrollY());
          a();
          this.g.addMovement(paramMotionEvent);
          this.b.forceFinished(true);
          continue;
          if (!this.A)
          {
            b();
            this.g.addMovement(paramMotionEvent);
            float f3 = this.f;
            if (this.x)
            {
              if ((i1 <= this.h) || (i1 <= i2)) {
                break label409;
              }
              this.x = false;
            }
            for (this.y = false;; this.y = true)
            {
              do
              {
                if ((this.y) && (i2 > this.h) && (i2 > i1) && ((!isSticked()) || (this.H.isTop())))
                {
                  if (this.s != null) {
                    this.s.requestDisallowInterceptTouchEvent(true);
                  }
                  scrollBy(0, (int)(f3 - f2 + 0.5D));
                }
                this.e = f1;
                this.f = f2;
                this.n = paramMotionEvent.getRawX();
                this.o = paramMotionEvent.getRawY();
                this.p = ((int)(this.n - this.l));
                this.q = ((int)(this.o - this.m));
                if ((Math.abs(this.q) <= this.F) || (Math.abs(this.q) * 0.1D <= Math.abs(this.p))) {
                  break label438;
                }
                this.k = false;
                break;
              } while ((i2 <= this.h) || (i2 <= i1));
              this.x = false;
            }
            this.k = true;
          }
        }
      } while ((!this.y) || (i2 <= i1) || (i2 <= this.h));
      this.g.computeCurrentVelocity(1000, this.j);
      f1 = -this.g.getYVelocity();
      a locala;
      if (Math.abs(f1) > this.i)
      {
        if (f1 <= 0.0F) {
          break label581;
        }
        locala = a.a;
        this.t = locala;
        if ((this.t != a.a) || (!isSticked())) {
          break label589;
        }
      }
      while ((this.E) || (!isSticked()))
      {
        i1 = paramMotionEvent.getAction();
        paramMotionEvent.setAction(3);
        bool = super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(i1);
        return bool;
        locala = a.b;
        break label517;
        this.b.fling(0, getScrollY(), 0, (int)f1, 0, 0, -2147483647, Integer.MAX_VALUE);
        this.b.computeScrollOffset();
        this.z = getScrollY();
        invalidate();
      }
    } while ((!this.y) || (!this.E) || ((i1 <= this.h) && (i2 <= this.h)));
    i1 = paramMotionEvent.getAction();
    paramMotionEvent.setAction(3);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.setAction(i1);
    return bool;
  }
  
  public a getHelper()
  {
    return this.H;
  }
  
  public int getMaxY()
  {
    return this.C;
  }
  
  public boolean isCanPullToRefresh()
  {
    return (getScrollY() <= 0) && (this.H.isTop()) && (!this.k);
  }
  
  public boolean isSticked()
  {
    return this.D == this.C;
  }
  
  protected void onFinishInflate()
  {
    if ((this.r != null) && (!this.r.isClickable())) {
      this.r.setClickable(true);
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView != null) && ((localView instanceof ViewPager))) {
        this.s = ((ViewPager)localView);
      }
      i1 += 1;
    }
    super.onFinishInflate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.r = getChildAt(0);
    if (this.r != null)
    {
      measureChildWithMargins(this.r, paramInt1, 0, 0, 0);
      this.C = this.r.getMeasuredHeight();
      this.u = this.r.getMeasuredHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.C, 1073741824));
  }
  
  public void requestSearchListScrollViewDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.A = paramBoolean;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int i2 = getScrollY();
    int i1 = i2 + paramInt2;
    if (i1 >= this.C) {
      paramInt2 = this.C;
    }
    for (;;)
    {
      super.scrollBy(paramInt1, paramInt2 - i2);
      return;
      paramInt2 = i1;
      if (i1 <= this.B) {
        paramInt2 = this.B;
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt2 >= this.C) {
      i1 = this.C;
    }
    for (;;)
    {
      this.D = i1;
      if (this.G != null) {
        this.G.onScroll(i1, this.C);
      }
      super.scrollTo(paramInt1, i1);
      return;
      i1 = paramInt2;
      if (paramInt2 <= this.B) {
        i1 = this.B;
      }
    }
  }
  
  public void scrollToMaxTop()
  {
    scrollTo(0, this.C);
  }
  
  public void setOnScrollListener(b paramb)
  {
    this.G = paramb;
  }
  
  public void setScrollMinY(int paramInt)
  {
    this.F = paramInt;
  }
  
  static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onScroll(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/widget/SearchListScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */