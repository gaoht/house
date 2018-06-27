package com.ziroom.ziroomcustomer.home.view;

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
import android.widget.ListView;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout.b;

public class CustomNestedScrollView
  extends RelativeLayout
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
  private StickyNavLayout.a p;
  private StickyNavLayout.b q;
  private a r;
  private boolean s = false;
  
  @SuppressLint({"NewApi"})
  public CustomNestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
    Object localObject = this.c.getAdapter();
    if ((localObject instanceof FragmentPagerAdapter)) {
      localObject = (ViewGroup)((Fragment)((FragmentPagerAdapter)localObject).instantiateItem(this.c, i1)).getView().findViewById(2131693954);
    }
    for (;;)
    {
      this.f = ((ViewGroup)localObject);
      return;
      if ((localObject instanceof FragmentStatePagerAdapter)) {
        localObject = (ViewGroup)((Fragment)((FragmentStatePagerAdapter)localObject).instantiateItem(this.c, i1)).getView().findViewById(2131693954);
      } else {
        localObject = null;
      }
    }
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
        } while ((this.f.getScrollY() != 0) || (!this.g) || (f1 <= 0.0F) || (this.s));
        this.s = true;
        paramMotionEvent.setAction(3);
        localObject = MotionEvent.obtain(paramMotionEvent);
        dispatchTouchEvent(paramMotionEvent);
        ((MotionEvent)localObject).setAction(0);
        return dispatchTouchEvent((MotionEvent)localObject);
      } while (!(this.f instanceof ListView));
      localObject = (ListView)this.f;
      localObject = ((ListView)localObject).getChildAt(((ListView)localObject).getFirstVisiblePosition());
    } while ((this.s) || (localObject == null) || (((View)localObject).getTop() != 0) || (!this.g) || (f1 <= 0.0F));
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
    this.h.fling(0, getScrollY(), 0, paramInt, 0, 0, 0, this.d);
    invalidate();
  }
  
  public void handOtherScrollTop()
  {
    getCurrentScrollView();
    int i2 = this.c.getCurrentItem();
    PagerAdapter localPagerAdapter = this.c.getAdapter();
    int i1 = 0;
    if (i1 < this.c.getChildCount())
    {
      if (i1 != i2)
      {
        if (!(localPagerAdapter instanceof FragmentPagerAdapter)) {
          break label86;
        }
        ((ViewGroup)((Fragment)((FragmentPagerAdapter)localPagerAdapter).instantiateItem(this.c, i2)).getView().findViewById(2131693954)).scrollTo(0, 0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        label86:
        if ((localPagerAdapter instanceof FragmentStatePagerAdapter)) {
          ((ViewGroup)((Fragment)((FragmentStatePagerAdapter)localPagerAdapter).instantiateItem(this.c, i2)).getView().findViewById(2131693954)).scrollTo(0, 0);
        }
      }
    }
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
          this.s = false;
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
    if (this.r != null) {
      this.r.onScroll(paramInt1, paramInt2);
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
  
  public void setOnScrollListener(a parama)
  {
    this.r = parama;
  }
  
  public void setStickInListener(StickyNavLayout.a parama)
  {
    this.p = parama;
  }
  
  public void setStickOutListener(StickyNavLayout.b paramb)
  {
    this.q = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/CustomNestedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */