package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SwipeMenuListView
  extends ListView
{
  private int a = 5;
  private int b = 3;
  private float c;
  private float d;
  private int e;
  private int f;
  private SwipeMenuLayout g;
  private b h;
  private c i;
  private a j;
  private Interpolator k;
  private Interpolator l;
  
  public SwipeMenuListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public SwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private void a()
  {
    this.b = a(this.b);
    this.a = a(this.a);
    this.e = 0;
  }
  
  public Interpolator getCloseInterpolator()
  {
    return this.k;
  }
  
  public Interpolator getOpenInterpolator()
  {
    return this.l;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (this.g == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    MotionEventCompat.getActionMasked(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        int m = this.f;
        this.c = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
        this.e = 0;
        this.f = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if ((this.f == m) && (this.g != null) && (this.g.isOpen()))
        {
          this.e = 1;
          this.g.onSwipe(paramMotionEvent);
          return true;
        }
        View localView = getChildAt(this.f - getFirstVisiblePosition());
        if ((this.g != null) && (this.g.isOpen()))
        {
          this.g.smoothCloseMenu();
          this.g = null;
          return super.onTouchEvent(paramMotionEvent);
        }
        if ((localView instanceof SwipeMenuLayout)) {
          this.g = ((SwipeMenuLayout)localView);
        }
        if (this.g != null)
        {
          this.g.onSwipe(paramMotionEvent);
          continue;
          float f1 = Math.abs(paramMotionEvent.getY() - this.d);
          float f2 = Math.abs(paramMotionEvent.getX() - this.c);
          if (this.e == 1)
          {
            if (this.g != null) {
              this.g.onSwipe(paramMotionEvent);
            }
            getSelector().setState(new int[] { 0 });
            paramMotionEvent.setAction(3);
            super.onTouchEvent(paramMotionEvent);
            return true;
          }
          if (this.e == 0) {
            if (Math.abs(f1) > this.a)
            {
              this.e = 2;
            }
            else if (f2 > this.b)
            {
              this.e = 1;
              if (this.h != null) {
                this.h.onSwipeStart(this.f);
              }
            }
          }
        }
      }
    } while (this.e != 1);
    if (this.g != null)
    {
      this.g.onSwipe(paramMotionEvent);
      if (!this.g.isOpen())
      {
        this.f = -1;
        this.g = null;
      }
    }
    if (this.h != null) {
      this.h.onSwipeEnd(this.f);
    }
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(new b(getContext(), paramListAdapter)
    {
      public void createMenu(a paramAnonymousa)
      {
        if (SwipeMenuListView.a(SwipeMenuListView.this) != null) {
          SwipeMenuListView.a(SwipeMenuListView.this).create(paramAnonymousa);
        }
      }
      
      public void onItemClick(SwipeMenuView paramAnonymousSwipeMenuView, a paramAnonymousa, int paramAnonymousInt)
      {
        if (SwipeMenuListView.b(SwipeMenuListView.this) != null) {
          SwipeMenuListView.b(SwipeMenuListView.this).onMenuItemClick(paramAnonymousSwipeMenuView.getPosition(), paramAnonymousa, paramAnonymousInt);
        }
        if (SwipeMenuListView.c(SwipeMenuListView.this) != null) {
          SwipeMenuListView.c(SwipeMenuListView.this).smoothCloseMenu();
        }
      }
    });
  }
  
  public void setCloseInterpolator(Interpolator paramInterpolator)
  {
    this.k = paramInterpolator;
  }
  
  public void setMenuCreator(c paramc)
  {
    this.i = paramc;
  }
  
  public void setOnMenuItemClickListener(a parama)
  {
    this.j = parama;
  }
  
  public void setOnSwipeListener(b paramb)
  {
    this.h = paramb;
  }
  
  public void setOpenInterpolator(Interpolator paramInterpolator)
  {
    this.l = paramInterpolator;
  }
  
  public void smoothOpenMenu(int paramInt)
  {
    if ((paramInt >= getFirstVisiblePosition()) && (paramInt <= getLastVisiblePosition()))
    {
      View localView = getChildAt(paramInt - getFirstVisiblePosition());
      if ((localView instanceof SwipeMenuLayout))
      {
        this.f = paramInt;
        if ((this.g != null) && (this.g.isOpen())) {
          this.g.smoothCloseMenu();
        }
        this.g = ((SwipeMenuLayout)localView);
        this.g.smoothOpenMenu();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onMenuItemClick(int paramInt1, a parama, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void onSwipeEnd(int paramInt);
    
    public abstract void onSwipeStart(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/SwipeMenuListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */