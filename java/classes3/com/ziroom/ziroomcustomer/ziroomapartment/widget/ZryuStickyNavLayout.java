package com.ziroom.ziroomcustomer.ziroomapartment.widget;

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

public class ZryuStickyNavLayout
  extends LinearLayout
{
  private String a = "ZryuStickyNavLayout";
  private View b;
  private View c;
  private ViewPager d;
  private int e;
  private int f;
  private ViewGroup g;
  private boolean h = false;
  private OverScroller i;
  private VelocityTracker j;
  private int k;
  private int l;
  private int m;
  private float n;
  private boolean o;
  private Context p;
  private a q;
  private b r;
  private boolean s = false;
  
  @SuppressLint({"NewApi"})
  public ZryuStickyNavLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.p = paramContext;
    this.i = new OverScroller(paramContext);
    this.k = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.l = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
    this.m = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  private void a()
  {
    if (this.j == null) {
      this.j = VelocityTracker.obtain();
    }
  }
  
  private void b()
  {
    if (this.j != null)
    {
      this.j.recycle();
      this.j = null;
    }
  }
  
  private void getCurrentScrollView()
  {
    int i1 = this.d.getCurrentItem();
    PagerAdapter localPagerAdapter = this.d.getAdapter();
    if ((localPagerAdapter instanceof FragmentPagerAdapter)) {
      this.g = ((ViewGroup)((Fragment)((FragmentPagerAdapter)localPagerAdapter).instantiateItem(this.d, i1)).getView().findViewById(2131693954));
    }
    while (!(localPagerAdapter instanceof FragmentStatePagerAdapter)) {
      return;
    }
    this.g = ((ViewGroup)((Fragment)((FragmentStatePagerAdapter)localPagerAdapter).instantiateItem(this.d, i1)).getView().findViewById(2131693954));
  }
  
  private int getTopViewPagerHeight()
  {
    return getContext().getResources().getDisplayMetrics().widthPixels * 9 / 16;
  }
  
  public void calculateTopViewHeight()
  {
    this.f = this.b.getMeasuredHeight();
    this.e = (this.f + n.dip2px(this.p, 1.0F));
  }
  
  @SuppressLint({"NewApi"})
  public void computeScroll()
  {
    if (this.i.computeScrollOffset())
    {
      scrollTo(0, this.i.getCurrY());
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
            this.n = f1;
          }
          f1 -= this.n;
          getCurrentScrollView();
          if (!(this.g instanceof ScrollView)) {
            break;
          }
        } while ((this.g.getScrollY() != 0) || (!this.h) || (f1 <= 0.0F) || (this.s));
        this.s = true;
        paramMotionEvent.setAction(3);
        localObject = MotionEvent.obtain(paramMotionEvent);
        dispatchTouchEvent(paramMotionEvent);
        ((MotionEvent)localObject).setAction(0);
        return dispatchTouchEvent((MotionEvent)localObject);
      } while (!(this.g instanceof ListView));
      localObject = (ListView)this.g;
      localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getFirstVisiblePosition());
    } while ((this.s) || (localObject == null) || (((View)localObject).getTop() != 0) || (!this.h) || (f1 <= 0.0F));
    this.s = true;
    paramMotionEvent.setAction(3);
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    dispatchTouchEvent(paramMotionEvent);
    ((MotionEvent)localObject).setAction(0);
    return dispatchTouchEvent((MotionEvent)localObject);
  }
  
  @SuppressLint({"NewApi"})
  public void fling(int paramInt)
  {
    this.i.fling(0, getScrollY(), 0, paramInt, 0, 0, 0, this.e);
    invalidate();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131690045);
    this.c = findViewById(2131690060);
    View localView = findViewById(2131690064);
    if (!(localView instanceof ViewPager)) {
      throw new RuntimeException("id_stickynavlayout_viewpager show used by ViewPager !");
    }
    this.d = ((ViewPager)localView);
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
      this.n = f1;
      continue;
      float f2 = f1 - this.n;
      getCurrentScrollView();
      if (Math.abs(f2) > this.k)
      {
        this.o = true;
        if ((this.g instanceof ScrollView))
        {
          if ((!this.h) || ((this.g.getScrollY() == 0) && (this.h) && (f2 > 0.0F)))
          {
            a();
            this.j.addMovement(paramMotionEvent);
            this.n = f1;
            return true;
          }
        }
        else if ((this.g instanceof ListView))
        {
          Object localObject = (ListView)this.g;
          localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getFirstVisiblePosition());
          if ((!this.h) || ((localObject != null) && (((View)localObject).getTop() == 0) && (this.h) && (f2 > 0.0F)))
          {
            a();
            this.j.addMovement(paramMotionEvent);
            this.n = f1;
            return true;
            this.o = false;
            b();
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.getLayoutParams().height = (getMeasuredHeight() - this.c.getMeasuredHeight() + n.dip2px(this.p, 1.0F));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    calculateTopViewHeight();
  }
  
  @SuppressLint({"NewApi"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    this.j.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (!this.i.isFinished()) {
        this.i.abortAnimation();
      }
      this.n = f1;
      return true;
      float f2 = f1 - this.n;
      Log.e("TAG", "dy = " + f2 + " , y = " + f1 + " , mLastY = " + this.n);
      if ((!this.o) && (Math.abs(f2) > this.k)) {
        this.o = true;
      }
      if (this.o)
      {
        scrollBy(0, (int)-f2);
        if ((getScrollY() == this.e) && (f2 < 0.0F))
        {
          paramMotionEvent.setAction(0);
          dispatchTouchEvent(paramMotionEvent);
          this.s = false;
        }
      }
      this.n = f1;
      continue;
      this.o = false;
      b();
      if (!this.i.isFinished())
      {
        this.i.abortAnimation();
        continue;
        this.o = false;
        this.j.computeCurrentVelocity(1000, this.l);
        i1 = (int)this.j.getYVelocity();
        if (Math.abs(i1) > this.m) {
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
    if (i1 > this.e) {
      paramInt2 = this.e;
    }
    if (paramInt2 != getScrollY()) {
      super.scrollTo(paramInt1, paramInt2);
    }
    if (getScrollY() == this.e) {
      bool = true;
    }
    this.h = bool;
    if (this.h) {
      if (this.q != null) {
        this.q.stickIn();
      }
    }
    while (this.r == null) {
      return;
    }
    this.r.stickOut();
  }
  
  public void setStickInListener(a parama)
  {
    this.q = parama;
  }
  
  public void setStickOutListener(b paramb)
  {
    this.r = paramb;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ZryuStickyNavLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */