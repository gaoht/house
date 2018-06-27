package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class SwipeMenuLayout
  extends FrameLayout
{
  private View a;
  private SwipeMenuView b;
  private int c;
  private int d = 0;
  private GestureDetectorCompat e;
  private GestureDetector.OnGestureListener f;
  private boolean g;
  private int h = b(15);
  private int i = -b(500);
  private ScrollerCompat j;
  private ScrollerCompat k;
  private int l;
  private int m;
  private Interpolator n;
  private Interpolator o;
  
  public SwipeMenuLayout(View paramView, SwipeMenuView paramSwipeMenuView)
  {
    this(paramView, paramSwipeMenuView, null, null);
  }
  
  public SwipeMenuLayout(View paramView, SwipeMenuView paramSwipeMenuView, Interpolator paramInterpolator1, Interpolator paramInterpolator2)
  {
    super(paramView.getContext());
    this.n = paramInterpolator1;
    this.o = paramInterpolator2;
    this.a = paramView;
    this.b = paramSwipeMenuView;
    this.b.setLayout(this);
    a();
  }
  
  private void a()
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.f = new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        SwipeMenuLayout.a(SwipeMenuLayout.this, false);
        return true;
      }
      
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if ((paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX() > SwipeMenuLayout.a(SwipeMenuLayout.this)) && (paramAnonymousFloat1 < SwipeMenuLayout.b(SwipeMenuLayout.this))) {
          SwipeMenuLayout.a(SwipeMenuLayout.this, true);
        }
        return super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
      }
    };
    this.e = new GestureDetectorCompat(getContext(), this.f);
    if (this.n != null)
    {
      this.k = ScrollerCompat.create(getContext(), this.n);
      if (this.o == null) {
        break label184;
      }
    }
    label184:
    for (this.j = ScrollerCompat.create(getContext(), this.o);; this.j = ScrollerCompat.create(getContext()))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      this.a.setLayoutParams(localLayoutParams);
      if (this.a.getId() < 1) {
        this.a.setId(1);
      }
      this.b.setId(2);
      this.b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      addView(this.a);
      addView(this.b);
      return;
      this.k = ScrollerCompat.create(getContext());
      break;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt > this.b.getWidth()) {
      paramInt = this.b.getWidth();
    }
    for (;;)
    {
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      this.a.layout(-i1, this.a.getTop(), this.a.getWidth() - i1, getMeasuredHeight());
      this.b.layout(this.a.getWidth() - i1, this.b.getTop(), this.a.getWidth() + this.b.getWidth() - i1, this.b.getBottom());
      return;
    }
  }
  
  private int b(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  public void closeMenu()
  {
    if (this.k.computeScrollOffset()) {
      this.k.abortAnimation();
    }
    if (this.d == 1)
    {
      this.d = 0;
      a(0);
    }
  }
  
  public void computeScroll()
  {
    if (this.d == 1) {
      if (this.j.computeScrollOffset())
      {
        a(this.j.getCurrX());
        postInvalidate();
      }
    }
    while (!this.k.computeScrollOffset()) {
      return;
    }
    a(this.l - this.k.getCurrX());
    postInvalidate();
  }
  
  public View getContentView()
  {
    return this.a;
  }
  
  public SwipeMenuView getMenuView()
  {
    return this.b;
  }
  
  public int getPosition()
  {
    return this.m;
  }
  
  public boolean isOpen()
  {
    return this.d == 1;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(0, 0, getMeasuredWidth(), this.a.getMeasuredHeight());
    this.b.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.b.getMeasuredWidth(), this.a.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onSwipe(MotionEvent paramMotionEvent)
  {
    this.e.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.c = ((int)paramMotionEvent.getX());
      this.g = false;
      continue;
      int i2 = (int)(this.c - paramMotionEvent.getX());
      int i1 = i2;
      if (this.d == 1) {
        i1 = i2 + this.b.getWidth();
      }
      a(i1);
      continue;
      if ((!this.g) && (this.c - paramMotionEvent.getX() <= this.b.getWidth() / 2)) {
        break;
      }
      smoothOpenMenu();
    }
    smoothCloseMenu();
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void openMenu()
  {
    if (this.d == 0)
    {
      this.d = 1;
      a(this.b.getWidth());
    }
  }
  
  public void setMenuHeight(int paramInt)
  {
    Log.i("byz", "pos = " + this.m + ", height = " + paramInt);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    if (localLayoutParams.height != paramInt)
    {
      localLayoutParams.height = paramInt;
      this.b.setLayoutParams(this.b.getLayoutParams());
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.m = paramInt;
    this.b.setPosition(paramInt);
  }
  
  public void smoothCloseMenu()
  {
    this.d = 0;
    this.l = (-this.a.getLeft());
    this.k.startScroll(0, 0, this.l, 0, 350);
    postInvalidate();
  }
  
  public void smoothOpenMenu()
  {
    this.d = 1;
    this.j.startScroll(-this.a.getLeft(), 0, this.b.getWidth(), 0, 350);
    postInvalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/SwipeMenuLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */