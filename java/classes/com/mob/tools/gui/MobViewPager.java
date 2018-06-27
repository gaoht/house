package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class MobViewPager
  extends ViewGroup
{
  private static final int DECELERATION = 10;
  private static final int SNAP_VELOCITY = 500;
  private static final int TOUCH_STATE_REST = 0;
  private static final int TOUCH_STATE_SCROLLING = 1;
  private ViewPagerAdapter adapter;
  private View currentPage;
  private int currentScreen;
  private int flingVelocity;
  private float lastMotionX;
  private float lastMotionY;
  private int maximumVelocity;
  private View nextPage;
  private int pageWidth;
  private View previousPage;
  private int screenCount;
  private Scroller scroller;
  private boolean skipScreen;
  private int touchSlop;
  private int touchState;
  private VelocityTracker velocityTracker;
  
  public MobViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void adjustScroller()
  {
    this.skipScreen = true;
    if ((this.currentPage != null) && (getFocusedChild() == this.currentPage)) {
      this.currentPage.clearFocus();
    }
    int i = this.currentScreen * getWidth() - getScrollX();
    this.scroller.abortAnimation();
    if (i != 0) {
      this.scroller.startScroll(getScrollX(), 0, i, 0, 0);
    }
    invalidate();
  }
  
  private void handleInterceptMove(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = (int)Math.abs(f1 - this.lastMotionX);
    if (((int)Math.abs(f2 - this.lastMotionY) < i) && (i > this.touchSlop))
    {
      this.touchState = 1;
      this.lastMotionX = f1;
    }
  }
  
  private void handleScrollMove(MotionEvent paramMotionEvent)
  {
    if (this.adapter == null) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          float f = paramMotionEvent.getX();
          i = (int)(this.lastMotionX - f);
          this.lastMotionX = f;
          if (i >= 0) {
            break;
          }
        } while (getScrollX() <= 0);
        scrollBy(Math.max(-getScrollX(), i), 0);
        return;
      } while ((i <= 0) || (getChildCount() == 0));
      j = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
    } while (j <= 0);
    scrollBy(Math.min(j, i), 0);
  }
  
  private void init(Context paramContext)
  {
    this.scroller = new Scroller(paramContext, new MobViewPager.1(this));
    this.touchState = 0;
    paramContext = ViewConfiguration.get(paramContext);
    this.touchSlop = paramContext.getScaledTouchSlop();
    this.maximumVelocity = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private void onScreenChange(int paramInt)
  {
    if (this.adapter != null)
    {
      if ((this.skipScreen) && (Math.abs(paramInt - this.currentScreen) > 2))
      {
        removeAllViews();
        if (this.currentScreen > 0)
        {
          this.previousPage = this.adapter.getView(this.currentScreen - 1, this.previousPage, this);
          addView(this.previousPage);
        }
        this.currentPage = this.adapter.getView(this.currentScreen, this.currentPage, this);
        addView(this.currentPage);
        if (this.currentScreen < this.screenCount - 1)
        {
          this.nextPage = this.adapter.getView(this.currentScreen + 1, this.nextPage, this);
          addView(this.nextPage);
        }
        this.adapter.onScreenChange(this.currentScreen, paramInt);
      }
    }
    else {
      return;
    }
    label162:
    int j;
    View localView;
    if (this.currentScreen > paramInt)
    {
      i = 0;
      if (i < this.currentScreen - paramInt)
      {
        j = paramInt + i + 1;
        localView = this.previousPage;
        this.previousPage = this.currentPage;
        this.currentPage = this.nextPage;
        if (getChildCount() >= 3) {
          removeViewAt(0);
        }
        if (j >= this.screenCount - 1) {
          break label255;
        }
        this.nextPage = this.adapter.getView(j + 1, localView, this);
        addView(this.nextPage);
      }
      for (;;)
      {
        i += 1;
        break label162;
        break;
        label255:
        this.nextPage = localView;
      }
    }
    int i = 0;
    label266:
    if (i < paramInt - this.currentScreen)
    {
      j = paramInt - i - 1;
      localView = this.nextPage;
      this.nextPage = this.currentPage;
      this.currentPage = this.previousPage;
      if (getChildCount() >= 3) {
        removeViewAt(2);
      }
      if (j <= 0) {
        break label354;
      }
      this.previousPage = this.adapter.getView(j - 1, localView, this);
      addView(this.previousPage, 0);
    }
    for (;;)
    {
      i += 1;
      break label266;
      break;
      label354:
      this.previousPage = localView;
    }
  }
  
  private void scrollToScreenOnUIThread(int paramInt, boolean paramBoolean)
  {
    this.skipScreen = paramBoolean;
    if ((this.currentPage != null) && (getFocusedChild() == this.currentPage)) {
      this.currentPage.clearFocus();
    }
    int k = getWidth() * paramInt - getScrollX();
    this.scroller.abortAnimation();
    int j;
    if (k != 0)
    {
      if (paramBoolean) {
        break label155;
      }
      j = Math.abs(k) / 2;
      if (this.flingVelocity == 0) {
        break label150;
      }
      paramInt = Math.abs(this.flingVelocity);
      i = Math.abs(k);
      paramInt = (int)((paramInt - Math.sqrt(paramInt * paramInt - i * 20)) * 1000.0D / 10.0D);
      if (paramInt != 0)
      {
        i = paramInt;
        if (paramInt <= j) {
          break label129;
        }
      }
    }
    label129:
    label150:
    label155:
    for (int i = j;; i = 0)
    {
      this.scroller.startScroll(getScrollX(), 0, k, 0, i);
      invalidate();
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void computeScroll()
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    for (;;)
    {
      return;
      if (this.scroller.computeScrollOffset())
      {
        scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
        postInvalidate();
      }
      while (this.adapter != null)
      {
        float f = getScrollX() / getWidth();
        this.adapter.onScreenChanging(f);
        return;
        int k = this.currentScreen;
        int m = this.scroller.getCurrX();
        int n = getWidth();
        int j = m / n;
        int i = j;
        if (m % n > n / 2) {
          i = j + 1;
        }
        this.currentScreen = Math.max(0, Math.min(i, this.screenCount - 1));
        if (k != this.currentScreen) {
          onScreenChange(k);
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    long l;
    do
    {
      return;
      l = getDrawingTime();
      if (this.currentScreen > 0) {
        drawChild(paramCanvas, this.previousPage, l);
      }
      drawChild(paramCanvas, this.currentPage, l);
    } while (this.currentScreen >= this.screenCount - 1);
    drawChild(paramCanvas, this.nextPage, l);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (this.adapter == null) {
      return super.dispatchUnhandledMove(paramView, paramInt);
    }
    if (paramInt == 17)
    {
      if (this.currentScreen > 0)
      {
        scrollToScreenOnUIThread(this.currentScreen - 1, false);
        return true;
      }
    }
    else if ((paramInt == 66) && (this.currentScreen < this.screenCount - 1))
    {
      scrollToScreenOnUIThread(this.currentScreen + 1, false);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.currentScreen;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.touchState != 0)) {}
    for (;;)
    {
      return true;
      if (this.velocityTracker == null) {
        this.velocityTracker = VelocityTracker.obtain();
      }
      this.velocityTracker.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while (this.touchState == 0)
      {
        return false;
        handleInterceptMove(paramMotionEvent);
        continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.lastMotionX = f1;
        this.lastMotionY = f2;
        if (this.scroller.isFinished()) {}
        for (i = 0;; i = 1)
        {
          this.touchState = i;
          break;
        }
        if (this.velocityTracker != null)
        {
          this.velocityTracker.recycle();
          this.velocityTracker = null;
        }
        this.touchState = 0;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    do
    {
      do
      {
        return;
        paramInt1 = paramInt3 - paramInt1;
        paramInt2 = paramInt4 - paramInt2;
        paramInt3 = this.currentScreen * paramInt1;
        if (this.currentScreen > 0) {
          this.previousPage.layout(paramInt3 - paramInt1, 0, paramInt3, paramInt2);
        }
        this.currentPage.layout(paramInt3, 0, paramInt3 + paramInt1, paramInt2);
        if (this.currentScreen < this.screenCount - 1) {
          this.nextPage.layout(paramInt3 + paramInt1, 0, paramInt1 + (paramInt3 + paramInt1), paramInt2);
        }
      } while (this.pageWidth == getWidth());
      paramInt1 = this.pageWidth;
      this.pageWidth = getWidth();
    } while (paramInt1 == 0);
    adjustScroller();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    for (;;)
    {
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = getMeasuredHeight();
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      int i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        getChildAt(paramInt1).measure(paramInt2, i);
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.adapter == null) {
      return false;
    }
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
    this.velocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if (this.touchState != 0)
      {
        if (!this.scroller.isFinished()) {
          this.scroller.abortAnimation();
        }
        this.lastMotionX = f;
        continue;
        if (this.touchState == 1)
        {
          handleScrollMove(paramMotionEvent);
        }
        else if ((onInterceptTouchEvent(paramMotionEvent)) && (this.touchState == 1))
        {
          handleScrollMove(paramMotionEvent);
          continue;
          if (this.touchState == 1)
          {
            this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
            this.flingVelocity = ((int)this.velocityTracker.getXVelocity());
            if ((this.flingVelocity <= 500) || (this.currentScreen <= 0)) {
              break label236;
            }
            scrollToScreenOnUIThread(this.currentScreen - 1, false);
          }
          for (;;)
          {
            if (this.velocityTracker != null)
            {
              this.velocityTracker.recycle();
              this.velocityTracker = null;
            }
            this.touchState = 0;
            break;
            label236:
            if ((this.flingVelocity < 65036) && (this.currentScreen < this.screenCount - 1))
            {
              scrollToScreenOnUIThread(this.currentScreen + 1, false);
            }
            else
            {
              i = getWidth();
              scrollToScreenOnUIThread((getScrollX() + i / 2) / i, false);
            }
          }
          this.touchState = 0;
        }
      }
    }
  }
  
  public void scrollLeft(boolean paramBoolean)
  {
    if (this.currentScreen > 0) {
      scrollToScreen(this.currentScreen - 1, paramBoolean);
    }
  }
  
  public void scrollRight(boolean paramBoolean)
  {
    if (this.currentScreen < this.screenCount - 1) {
      scrollToScreen(this.currentScreen + 1, paramBoolean);
    }
  }
  
  public void scrollToScreen(int paramInt, boolean paramBoolean)
  {
    post(new MobViewPager.2(this, paramInt, paramBoolean));
  }
  
  @Deprecated
  public void scrollToScreen(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    scrollToScreen(paramInt, paramBoolean1);
  }
  
  public void setAdapter(ViewPagerAdapter paramViewPagerAdapter)
  {
    if (this.adapter != null) {
      this.adapter.setMobViewPager(null);
    }
    this.adapter = paramViewPagerAdapter;
    if (this.adapter != null) {
      this.adapter.setMobViewPager(this);
    }
    if (paramViewPagerAdapter == null)
    {
      this.currentScreen = 0;
      removeAllViews();
    }
    do
    {
      return;
      this.screenCount = paramViewPagerAdapter.getCount();
      if (this.screenCount <= 0)
      {
        this.currentScreen = 0;
        removeAllViews();
        return;
      }
      if (this.screenCount <= this.currentScreen)
      {
        scrollToScreenOnUIThread(this.screenCount - 1, true);
        return;
      }
      removeAllViews();
      if (this.currentScreen > 0)
      {
        this.previousPage = paramViewPagerAdapter.getView(this.currentScreen - 1, this.previousPage, this);
        addView(this.previousPage);
      }
      this.currentPage = paramViewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
      addView(this.currentPage);
    } while (this.currentScreen >= this.screenCount - 1);
    this.nextPage = paramViewPagerAdapter.getView(this.currentScreen + 1, this.nextPage, this);
    addView(this.nextPage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/mob/tools/gui/MobViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */