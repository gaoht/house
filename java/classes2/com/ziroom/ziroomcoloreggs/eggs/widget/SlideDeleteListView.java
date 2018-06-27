package com.ziroom.ziroomcoloreggs.eggs.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Scroller;

public class SlideDeleteListView
  extends ListView
{
  private int a;
  private int b;
  private int c;
  private int d;
  private View e;
  private Scroller f;
  private VelocityTracker g;
  private boolean h = false;
  private int i;
  private b j;
  private a k;
  private int l;
  
  public SlideDeleteListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideDeleteListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideDeleteListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.f = new Scroller(paramContext);
    this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.l = (getHeaderViewsCount() + getCount() + getFooterViewsCount());
  }
  
  private void a()
  {
    this.k = a.a;
    int m = this.d + this.e.getScrollX();
    this.f.startScroll(this.e.getScrollX(), 0, -m, 0, Math.abs(m));
    postInvalidate();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
    this.g.addMovement(paramMotionEvent);
  }
  
  private boolean a(int paramInt)
  {
    int m = getHeaderViewsCount();
    int n = getFooterViewsCount();
    if ((m == 0) && (n == 0)) {}
    do
    {
      return false;
      if ((m != 0) && (paramInt + 1 <= m)) {
        return true;
      }
    } while ((n == 0) || (paramInt + 1 - m - getCount() <= n));
    return true;
  }
  
  private void b()
  {
    this.k = a.b;
    int m = this.d - this.e.getScrollX();
    this.f.startScroll(this.e.getScrollX(), 0, m, 0, Math.abs(m));
    postInvalidate();
  }
  
  private void c()
  {
    if (this.e.getScrollX() >= this.d / 3)
    {
      b();
      return;
    }
    if (this.e.getScrollX() <= -this.d / 3)
    {
      a();
      return;
    }
    this.e.scrollTo(0, 0);
  }
  
  private void d()
  {
    if (this.g != null)
    {
      this.g.recycle();
      this.g = null;
    }
  }
  
  private int getScrollVelocity()
  {
    this.g.computeCurrentVelocity(1000);
    return (int)this.g.getXVelocity();
  }
  
  public void computeScroll()
  {
    if (this.f.computeScrollOffset())
    {
      this.e.scrollTo(this.f.getCurrX(), this.f.getCurrY());
      postInvalidate();
      if (this.f.isFinished())
      {
        if (this.j == null) {
          throw new NullPointerException("RemoveListener is null, we should called setRemoveListener()");
        }
        this.j.removeItem(this.k, this.a);
        this.e.scrollTo(0, this.f.getCurrY());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      a(paramMotionEvent);
      if (!this.f.isFinished()) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.c = ((int)paramMotionEvent.getX());
      this.b = ((int)paramMotionEvent.getY());
      this.a = pointToPosition(this.c, this.b);
      if ((this.a == -1) || (a(this.a)))
      {
        this.h = false;
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.e = getChildAt(this.a - getFirstVisiblePosition());
      continue;
      if ((Math.abs(getScrollVelocity()) > 600) || ((Math.abs(paramMotionEvent.getX() - this.c) > this.i) && (Math.abs(paramMotionEvent.getY() - this.b) < this.i)))
      {
        this.h = true;
        continue;
        d();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.h) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.h) && (this.a != -1) && (!a(this.a)))
    {
      a(paramMotionEvent);
      int n = paramMotionEvent.getAction();
      int m = (int)paramMotionEvent.getX();
      switch (n)
      {
      default: 
      case 2: 
        for (;;)
        {
          return true;
          n = this.c;
          this.c = m;
          this.e.scrollBy(n - m, 0);
        }
      }
      m = getScrollVelocity();
      if (m > 600) {
        a();
      }
      for (;;)
      {
        d();
        this.h = false;
        break;
        if (m < 64936) {
          b();
        } else {
          c();
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setRemoveListener(b paramb)
  {
    this.j = paramb;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void removeItem(SlideDeleteListView.a parama, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/widget/SlideDeleteListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */