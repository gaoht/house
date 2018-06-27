package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  private int a;
  private int b;
  private int c;
  private long d;
  private View e;
  private DismissCallbacks f;
  private int g = 1;
  private float h;
  private float i;
  private boolean j;
  private int k;
  private Object l;
  private VelocityTracker m;
  private float n;
  private boolean o;
  private boolean p;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.a = localViewConfiguration.getScaledTouchSlop();
    this.b = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.d = paramView.getContext().getResources().getInteger(17694720);
    this.e = paramView;
    this.e.getContext();
    this.l = paramObject;
    this.f = paramDismissCallbacks;
  }
  
  @TargetApi(11)
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    int i1 = this.e.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, 1 }).setDuration(this.d);
    localValueAnimator.addListener(new n(this, localLayoutParams, i1));
    localValueAnimator.addUpdateListener(new o(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  @TargetApi(12)
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i2 = 1;
    int i3 = 1;
    boolean bool = true;
    paramMotionEvent.offsetLocation(this.n, 0.0F);
    if (this.g < 2) {
      this.g = this.e.getWidth();
    }
    float f1;
    float f2;
    float f3;
    float f4;
    int i1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        bool = false;
        do
        {
          return bool;
          this.h = paramMotionEvent.getRawX();
          this.i = paramMotionEvent.getRawY();
        } while (!this.f.canDismiss(this.l));
        this.o = false;
        this.m = VelocityTracker.obtain();
        this.m.addMovement(paramMotionEvent);
        return true;
      } while (this.m == null);
      f1 = paramMotionEvent.getRawX() - this.h;
      this.m.addMovement(paramMotionEvent);
      this.m.computeCurrentVelocity(1000);
      f2 = this.m.getXVelocity();
      f3 = Math.abs(f2);
      f4 = Math.abs(this.m.getYVelocity());
      if ((Math.abs(f1) > this.g / 3) && (this.j)) {
        if (f1 > 0.0F) {
          i1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      label226:
      if (i2 != 0)
      {
        paramView = this.e.animate();
        if (i1 != 0)
        {
          f1 = this.g;
          label250:
          paramView.translationX(f1).setDuration(this.d).setListener(new m(this));
        }
      }
      for (;;)
      {
        this.m.recycle();
        this.m = null;
        this.n = 0.0F;
        this.h = 0.0F;
        this.i = 0.0F;
        this.j = false;
        break;
        i1 = 0;
        break label226;
        if ((this.b > f3) || (f3 > this.c) || (f4 >= f3) || (f4 >= f3) || (!this.j)) {
          break label790;
        }
        if (f2 < 0.0F)
        {
          i1 = 1;
          label370:
          if (f1 >= 0.0F) {
            break label426;
          }
          i2 = 1;
          label379:
          if (i1 != i2) {
            break label432;
          }
          i1 = 1;
          label389:
          if (this.m.getXVelocity() <= 0.0F) {
            break label438;
          }
        }
        label426:
        label432:
        label438:
        for (i2 = i3;; i2 = 0)
        {
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break;
          i1 = 0;
          break label370;
          i2 = 0;
          break label379;
          i1 = 0;
          break label389;
        }
        f1 = -this.g;
        break label250;
        if (this.j) {
          this.e.animate().translationX(0.0F).setDuration(this.d).setListener(null);
        }
      }
      if (this.m == null) {
        break;
      }
      this.e.animate().translationX(0.0F).setDuration(this.d).setListener(null);
      this.m.recycle();
      this.m = null;
      this.n = 0.0F;
      this.h = 0.0F;
      this.i = 0.0F;
      this.j = false;
      break;
      if (this.m == null) {
        break;
      }
      this.m.addMovement(paramMotionEvent);
      f1 = paramMotionEvent.getRawX() - this.h;
      f2 = paramMotionEvent.getRawY();
      f3 = this.i;
      if ((Math.abs(f1) > this.a) && (Math.abs(f2 - f3) < Math.abs(f1) / 2.0F))
      {
        this.j = true;
        if (f1 <= 0.0F) {
          break label772;
        }
        i1 = this.a;
        label637:
        this.k = i1;
        this.e.getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.o)
        {
          this.o = true;
          this.f.onNotify();
        }
        if (Math.abs(f1) <= this.g / 3) {
          break label782;
        }
        if (!this.p)
        {
          this.p = true;
          this.f.onNotify();
        }
      }
      for (;;)
      {
        paramView = MotionEvent.obtain(paramMotionEvent);
        paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
        this.e.onTouchEvent(paramView);
        paramView.recycle();
        if (!this.j) {
          break;
        }
        this.n = f1;
        this.e.setTranslationX(f1 - this.k);
        return true;
        label772:
        i1 = -this.a;
        break label637;
        label782:
        this.p = false;
      }
      label790:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);
    
    public abstract void onDismiss(View paramView, Object paramObject);
    
    public abstract void onNotify();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/SwipeDismissTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */