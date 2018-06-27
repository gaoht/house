package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class PullToRequestView
  extends RelativeLayout
{
  private static final int FAULT_TOLERANCE_RANGE = 10;
  private static final long MIN_REF_TIME = 1000L;
  private PullToRequestAdatper adapter;
  private View bodyView;
  private float downY;
  private int footerHeight;
  private View footerView;
  private int headerHeight;
  private View headerView;
  private long pullTime;
  private boolean pullingDownLock;
  private boolean pullingUpLock;
  private int state;
  private Runnable stopAct;
  private int top;
  
  public PullToRequestView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PullToRequestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PullToRequestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean canPullDown()
  {
    return (!this.pullingDownLock) && (this.adapter.isPullDownReady()) && (this.state == 0);
  }
  
  private boolean canPullUp()
  {
    return (!this.pullingUpLock) && (this.adapter.isPullUpReady()) && (this.state == 0);
  }
  
  private MotionEvent getCancelEvent(MotionEvent paramMotionEvent)
  {
    return MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 3, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState());
  }
  
  private void init()
  {
    this.stopAct = new Runnable()
    {
      public void run()
      {
        PullToRequestView.this.reversePulling();
      }
    };
  }
  
  private void performRequestNext()
  {
    this.pullTime = System.currentTimeMillis();
    this.state = -1;
    if (this.adapter != null) {
      this.adapter.onRequestNext();
    }
  }
  
  private void reversePulling()
  {
    this.top = 0;
    scrollTo(0, 0);
    this.state = 0;
    if (this.adapter != null) {
      this.adapter.onReversed();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localMotionEvent = paramMotionEvent;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(localMotionEvent);
      this.downY = paramMotionEvent.getY();
      localMotionEvent = paramMotionEvent;
      continue;
      float f = paramMotionEvent.getY();
      switch (this.state)
      {
      case 0: 
      default: 
        if (this.top > 0)
        {
          this.top = ((int)(this.top + (f - this.downY) / 2.0F));
          if (this.top < 0) {
            this.top = 0;
          }
          scrollTo(0, -this.top);
          if ((this.adapter != null) && (this.headerHeight != 0)) {
            this.adapter.onPullDown(this.top * 100 / this.headerHeight);
          }
          localMotionEvent = getCancelEvent(paramMotionEvent);
        }
        break;
      }
      for (;;)
      {
        this.downY = f;
        break;
        this.top = ((int)(this.top + (f - this.downY) / 2.0F));
        if (this.top < 0) {
          this.top = 0;
        }
        scrollTo(0, -this.top);
        localMotionEvent = getCancelEvent(paramMotionEvent);
        continue;
        this.top = ((int)(this.top + (f - this.downY) / 2.0F));
        if (this.top > 0) {
          this.top = 0;
        }
        scrollTo(0, -this.top);
        localMotionEvent = getCancelEvent(paramMotionEvent);
        continue;
        if (this.top < 0)
        {
          this.top = ((int)(this.top + (f - this.downY) / 2.0F));
          if (this.top > 0) {
            this.top = 0;
          }
          scrollTo(0, -this.top);
          if ((this.adapter != null) && (this.footerHeight != 0)) {
            this.adapter.onPullUp(-this.top * 100 / this.footerHeight);
          }
          localMotionEvent = getCancelEvent(paramMotionEvent);
        }
        else if (f - this.downY > 10.0F)
        {
          localMotionEvent = paramMotionEvent;
          if (canPullDown())
          {
            this.top = ((int)(this.top + (f - this.downY) / 2.0F));
            scrollTo(0, -this.top);
            if ((this.adapter != null) && (this.headerHeight != 0)) {
              this.adapter.onPullUp(-this.top * 100 / this.headerHeight);
            }
            localMotionEvent = getCancelEvent(paramMotionEvent);
          }
        }
        else
        {
          localMotionEvent = paramMotionEvent;
          if (this.downY - f > 10.0F)
          {
            localMotionEvent = paramMotionEvent;
            if (canPullUp())
            {
              this.top = ((int)(this.top + (f - this.downY) / 2.0F));
              scrollTo(0, -this.top);
              if ((this.adapter != null) && (this.footerHeight != 0)) {
                this.adapter.onPullUp(-this.top * 100 / this.footerHeight);
              }
              localMotionEvent = getCancelEvent(paramMotionEvent);
            }
          }
        }
      }
      switch (this.state)
      {
      default: 
        localMotionEvent = paramMotionEvent;
        break;
      case -1: 
        this.top = (-this.footerHeight);
        scrollTo(0, -this.top);
        localMotionEvent = paramMotionEvent;
        break;
      case 0: 
        if (this.top > this.headerHeight)
        {
          this.top = this.headerHeight;
          scrollTo(0, -this.top);
          if (this.adapter != null) {
            this.adapter.onPullDown(100);
          }
          performFresh();
          localMotionEvent = getCancelEvent(paramMotionEvent);
        }
        else if (this.top < -this.footerHeight)
        {
          this.top = (-this.footerHeight);
          scrollTo(0, -this.top);
          if (this.adapter != null) {
            this.adapter.onPullUp(100);
          }
          performRequestNext();
          localMotionEvent = getCancelEvent(paramMotionEvent);
        }
        else
        {
          localMotionEvent = paramMotionEvent;
          if (this.top != 0)
          {
            scrollTo(0, 0);
            if (this.adapter != null)
            {
              if (this.top <= 0) {
                break label790;
              }
              this.adapter.onPullDown(0);
            }
            for (;;)
            {
              this.top = 0;
              localMotionEvent = paramMotionEvent;
              break;
              this.adapter.onPullUp(0);
            }
          }
        }
        break;
      case 1: 
        label790:
        this.top = this.headerHeight;
        scrollTo(0, -this.top);
        localMotionEvent = paramMotionEvent;
      }
    }
  }
  
  public void lockPullingDown()
  {
    this.pullingDownLock = true;
  }
  
  public void lockPullingUp()
  {
    this.pullingUpLock = true;
  }
  
  protected void performFresh()
  {
    this.pullTime = System.currentTimeMillis();
    this.state = 1;
    if (this.adapter != null) {
      this.adapter.onRefresh();
    }
  }
  
  public void performPullingDown(boolean paramBoolean)
  {
    this.top = this.headerHeight;
    scrollTo(0, -this.top);
    if (paramBoolean) {
      performFresh();
    }
  }
  
  public void performPullingUp(boolean paramBoolean)
  {
    this.top = (-this.footerHeight);
    scrollTo(0, -this.top);
    if (paramBoolean) {
      performRequestNext();
    }
  }
  
  public void releasePullingDownLock()
  {
    this.pullingDownLock = false;
  }
  
  public void releasePullingUpLock()
  {
    this.pullingUpLock = false;
  }
  
  public void setAdapter(PullToRequestAdatper paramPullToRequestAdatper)
  {
    this.adapter = paramPullToRequestAdatper;
    removeAllViews();
    this.bodyView = ((View)paramPullToRequestAdatper.getBodyView());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    addView(this.bodyView, localLayoutParams);
    this.headerView = paramPullToRequestAdatper.getHeaderView();
    this.headerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.headerView.measure(0, 0);
    this.headerHeight = this.headerView.getMeasuredHeight();
    localLayoutParams = new RelativeLayout.LayoutParams(-2, this.headerHeight);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = (-this.headerHeight);
    addView(this.headerView, localLayoutParams);
    this.footerView = paramPullToRequestAdatper.getFooterView();
    this.footerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.footerView.measure(0, 0);
    this.footerHeight = this.footerView.getMeasuredHeight();
    paramPullToRequestAdatper = new RelativeLayout.LayoutParams(-2, this.headerHeight);
    paramPullToRequestAdatper.addRule(9);
    paramPullToRequestAdatper.addRule(11);
    paramPullToRequestAdatper.addRule(12);
    paramPullToRequestAdatper.bottomMargin = (-this.headerHeight);
    addView(this.footerView, paramPullToRequestAdatper);
  }
  
  public void stopPulling()
  {
    long l = System.currentTimeMillis() - this.pullTime;
    if (l < 1000L)
    {
      postDelayed(this.stopAct, 1000L - l);
      return;
    }
    post(this.stopAct);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */