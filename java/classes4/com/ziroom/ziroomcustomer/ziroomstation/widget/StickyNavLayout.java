package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.ziroom.ziroomcustomer.util.n;

public class StickyNavLayout
  extends LinearLayout
{
  private View a;
  private View b;
  private ViewPager c;
  private int d;
  private int e;
  private ViewGroup f;
  private boolean g = false;
  private OverScroller h;
  private VelocityTracker i;
  private int j;
  private int k;
  private int l;
  private float m;
  private boolean n;
  private Context o;
  private a p;
  private b q;
  private boolean r = false;
  
  @SuppressLint({"NewApi"})
  public StickyNavLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.o = paramContext;
    this.h = new OverScroller(paramContext);
    this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.k = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
    this.l = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  private void a()
  {
    if (this.i == null) {
      this.i = VelocityTracker.obtain();
    }
  }
  
  private void b()
  {
    if (this.i != null)
    {
      this.i.recycle();
      this.i = null;
    }
  }
  
  private void getCurrentScrollView()
  {
    int i1 = this.c.getCurrentItem();
    PagerAdapter localPagerAdapter = this.c.getAdapter();
    if ((localPagerAdapter instanceof FragmentPagerAdapter)) {
      this.f = ((ViewGroup)((Fragment)((FragmentPagerAdapter)localPagerAdapter).instantiateItem(this.c, i1)).getView().findViewById(2131693954));
    }
    while (!(localPagerAdapter instanceof FragmentStatePagerAdapter)) {
      return;
    }
    this.f = ((ViewGroup)((Fragment)((FragmentStatePagerAdapter)localPagerAdapter).instantiateItem(this.c, i1)).getView().findViewById(2131693954));
  }
  
  private int getTopViewPagerHeight()
  {
    return getContext().getResources().getDisplayMetrics().widthPixels * 9 / 16;
  }
  
  @SuppressLint({"NewApi"})
  public void computeScroll()
  {
    if (this.h.computeScrollOffset())
    {
      scrollTo(0, this.h.getCurrY());
      invalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return super.dispatchTouchEvent(paramMotionEvent);
            this.m = f1;
          }
          f1 -= this.m;
          getCurrentScrollView();
          if (!(this.f instanceof ScrollView)) {
            break;
          }
        } while ((this.f.getScrollY() != 0) || (!this.g) || (f1 <= 0.0F) || (this.r));
        this.r = true;
        paramMotionEvent.setAction(3);
        localObject = MotionEvent.obtain(paramMotionEvent);
        dispatchTouchEvent(paramMotionEvent);
        ((MotionEvent)localObject).setAction(0);
        return dispatchTouchEvent((MotionEvent)localObject);
      } while (!(this.f instanceof ListView));
      localObject = (ListView)this.f;
      localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getFirstVisiblePosition());
    } while ((this.r) || (localObject == null) || (((View)localObject).getTop() != 0) || (!this.g) || (f1 <= 0.0F));
    this.r = true;
    paramMotionEvent.setAction(3);
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    dispatchTouchEvent(paramMotionEvent);
    ((MotionEvent)localObject).setAction(0);
    return dispatchTouchEvent((MotionEvent)localObject);
  }
  
  @SuppressLint({"NewApi"})
  public void fling(int paramInt)
  {
    this.h.fling(0, getScrollY(), 0, paramInt, 0, 0, 0, this.d);
    invalidate();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131690045);
    this.b = findViewById(2131690060);
    View localView = findViewById(2131690064);
    if (!(localView instanceof ViewPager)) {
      throw new RuntimeException("id_stickynavlayout_viewpager show used by ViewPager !");
    }
    this.c = ((ViewPager)localView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.m = f1;
      continue;
      float f2 = f1 - this.m;
      getCurrentScrollView();
      if (Math.abs(f2) > this.j)
      {
        this.n = true;
        if ((this.f instanceof ScrollView))
        {
          if ((!this.g) || ((this.f.getScrollY() == 0) && (this.g) && (f2 > 0.0F)))
          {
            a();
            this.i.addMovement(paramMotionEvent);
            this.m = f1;
            return true;
          }
        }
        else if ((this.f instanceof ListView))
        {
          Object localObject = (ListView)this.f;
          localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getFirstVisiblePosition());
          if ((!this.g) || ((localObject != null) && (((View)localObject).getTop() == 0) && (this.g) && (f2 > 0.0F)))
          {
            a();
            this.i.addMovement(paramMotionEvent);
            this.m = f1;
            return true;
            this.n = false;
            b();
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.getLayoutParams().height = (getMeasuredHeight() - this.b.getMeasuredHeight() + n.dip2px(this.o, 10.0F));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = this.a.getMeasuredHeight();
    this.d = (this.a.getMeasuredHeight() + n.dip2px(this.o, 10.0F));
  }
  
  @SuppressLint({"NewApi"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    this.i.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (!this.h.isFinished()) {
        this.h.abortAnimation();
      }
      this.m = f1;
      return true;
      float f2 = f1 - this.m;
      Log.e("TAG", "dy = " + f2 + " , y = " + f1 + " , mLastY = " + this.m);
      if ((!this.n) && (Math.abs(f2) > this.j)) {
        this.n = true;
      }
      if (this.n)
      {
        scrollBy(0, (int)-f2);
        if ((getScrollY() == this.d) && (f2 < 0.0F))
        {
          paramMotionEvent.setAction(0);
          dispatchTouchEvent(paramMotionEvent);
          this.r = false;
        }
      }
      this.m = f1;
      continue;
      this.n = false;
      b();
      if (!this.h.isFinished())
      {
        this.h.abortAnimation();
        continue;
        this.n = false;
        this.i.computeCurrentVelocity(1000, this.k);
        i1 = (int)this.i.getYVelocity();
        if (Math.abs(i1) > this.l) {
          fling(-i1);
        }
        b();
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    paramInt2 = i1;
    if (i1 > this.d) {
      paramInt2 = this.d;
    }
    if (paramInt2 != getScrollY()) {
      super.scrollTo(paramInt1, paramInt2);
    }
    if (getScrollY() == this.d) {
      bool = true;
    }
    this.g = bool;
    if (this.g) {
      if (this.p != null) {
        this.p.stickIn();
      }
    }
    while (this.q == null) {
      return;
    }
    this.q.stickOut();
  }
  
  public void setStickInListener(a parama)
  {
    this.p = parama;
  }
  
  public void setStickOutListener(b paramb)
  {
    this.q = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void stickIn();
  }
  
  public static abstract interface b
  {
    public abstract void stickOut();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/StickyNavLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */