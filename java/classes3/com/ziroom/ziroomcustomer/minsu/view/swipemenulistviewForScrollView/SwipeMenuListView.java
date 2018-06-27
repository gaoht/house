package com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import java.util.List;

public class SwipeMenuListView
  extends ListView
{
  private int a = 1;
  private int b = 5;
  private int c = 3;
  private float d;
  private float e;
  private int f;
  private int g;
  private SwipeMenuLayout h;
  private c i;
  private d j;
  private a k;
  private b l;
  private Interpolator m;
  private Interpolator n;
  private List<MinsuImReplyCommonBean.DataBean.ListMsgBean> o;
  
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
    this.c = a(this.c);
    this.b = a(this.b);
    this.f = 0;
  }
  
  public static boolean inRangeOfView(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    return (paramMotionEvent.getRawX() >= i1) && (paramMotionEvent.getRawX() <= i1 + paramView.getWidth()) && (paramMotionEvent.getRawY() >= i2) && (paramMotionEvent.getRawY() <= i2 + paramView.getHeight());
  }
  
  public Interpolator getCloseInterpolator()
  {
    return this.m;
  }
  
  public Interpolator getOpenInterpolator()
  {
    return this.n;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    this.g = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    label59:
    boolean bool3;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    case 0: 
      View localView;
      do
      {
        return bool1;
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        bool3 = super.onInterceptTouchEvent(paramMotionEvent);
        this.f = 0;
        this.g = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        localView = getChildAt(this.g - getFirstVisiblePosition());
        if (!(localView instanceof SwipeMenuLayout)) {
          break label186;
        }
        if ((this.h == null) || (!this.h.isOpen())) {
          break;
        }
        bool1 = bool2;
      } while (!inRangeOfView(this.h.getMenuView(), paramMotionEvent));
      this.h = ((SwipeMenuLayout)localView);
      this.h.setSwipeDirection(this.a);
      label186:
      if ((this.h == null) || (!this.h.isOpen()) || (localView == this.h)) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = bool3)
    {
      if (this.h != null) {
        this.h.onSwipe(paramMotionEvent);
      }
      return bool1;
      float f1 = Math.abs(paramMotionEvent.getY() - this.e);
      float f2 = Math.abs(paramMotionEvent.getX() - this.d);
      if ((Math.abs(f1) <= this.b) && (Math.abs(f2) <= this.c)) {
        break;
      }
      bool1 = bool2;
      if (this.f != 0) {
        break label59;
      }
      if (Math.abs(f1) > this.b)
      {
        this.f = 2;
        return true;
      }
      bool1 = bool2;
      if (f2 <= this.c) {
        break label59;
      }
      this.f = 1;
      bool1 = bool2;
      if (this.i == null) {
        break label59;
      }
      this.i.onSwipeStart(this.g);
      return true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (this.h == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if ((this.o != null) && (!this.o.isEmpty()) && ((1 == ((MinsuImReplyCommonBean.DataBean.ListMsgBean)this.o.get(this.h.getPosition())).msgType) || (-1 == ((MinsuImReplyCommonBean.DataBean.ListMsgBean)this.o.get(this.h.getPosition())).msgType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        int i1 = this.g;
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        this.f = 0;
        this.g = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if ((this.g == i1) && (this.h != null) && (this.h.isOpen()))
        {
          this.f = 1;
          this.h.onSwipe(paramMotionEvent);
          return true;
        }
        View localView = getChildAt(this.g - getFirstVisiblePosition());
        if ((this.h != null) && (this.h.isOpen()))
        {
          this.h.smoothCloseMenu();
          this.h = null;
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setAction(3);
          onTouchEvent(paramMotionEvent);
          if (this.l != null) {
            this.l.onMenuClose(i1);
          }
          return true;
        }
        if ((localView instanceof SwipeMenuLayout))
        {
          this.h = ((SwipeMenuLayout)localView);
          this.h.setSwipeDirection(this.a);
        }
        if (this.h != null)
        {
          this.h.onSwipe(paramMotionEvent);
          continue;
          this.g = (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) - getHeaderViewsCount());
          if ((this.h.getSwipEnable()) && (this.g == this.h.getPosition()))
          {
            float f1 = Math.abs(paramMotionEvent.getY() - this.e);
            float f2 = Math.abs(paramMotionEvent.getX() - this.d);
            if (this.f == 1)
            {
              if (this.h != null) {
                this.h.onSwipe(paramMotionEvent);
              }
              getSelector().setState(new int[] { 0 });
              paramMotionEvent.setAction(3);
              super.onTouchEvent(paramMotionEvent);
              return true;
            }
            if (this.f == 0) {
              if (Math.abs(f1) > this.b)
              {
                this.f = 2;
              }
              else if (f2 > this.c)
              {
                this.f = 1;
                if (this.i != null) {
                  this.i.onSwipeStart(this.g);
                }
              }
            }
          }
        }
      }
    } while (this.f != 1);
    boolean bool2;
    if (this.h != null)
    {
      boolean bool1 = this.h.isOpen();
      this.h.onSwipe(paramMotionEvent);
      bool2 = this.h.isOpen();
      if ((bool1 != bool2) && (this.l != null))
      {
        if (!bool2) {
          break label661;
        }
        this.l.onMenuOpen(this.g);
      }
    }
    for (;;)
    {
      if (!bool2)
      {
        this.g = -1;
        this.h = null;
      }
      if (this.i != null) {
        this.i.onSwipeEnd(this.g);
      }
      paramMotionEvent.setAction(3);
      super.onTouchEvent(paramMotionEvent);
      return true;
      label661:
      this.l.onMenuClose(this.g);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(new c(getContext(), paramListAdapter)
    {
      public void createMenu(b paramAnonymousb)
      {
        if (SwipeMenuListView.a(SwipeMenuListView.this) != null) {
          SwipeMenuListView.a(SwipeMenuListView.this).create(paramAnonymousb);
        }
      }
      
      public void onItemClick(SwipeMenuView paramAnonymousSwipeMenuView, b paramAnonymousb, int paramAnonymousInt)
      {
        boolean bool = false;
        if (SwipeMenuListView.b(SwipeMenuListView.this) != null) {
          bool = SwipeMenuListView.b(SwipeMenuListView.this).onMenuItemClick(paramAnonymousSwipeMenuView.getPosition(), paramAnonymousb, paramAnonymousInt);
        }
        if ((SwipeMenuListView.c(SwipeMenuListView.this) != null) && (!bool)) {
          SwipeMenuListView.c(SwipeMenuListView.this).smoothCloseMenu();
        }
      }
    });
  }
  
  public void setCloseInterpolator(Interpolator paramInterpolator)
  {
    this.m = paramInterpolator;
  }
  
  public void setMenuCreator(d paramd)
  {
    this.j = paramd;
  }
  
  public void setOnMenuItemClickListener(a parama)
  {
    this.k = parama;
  }
  
  public void setOnMenuStateChangeListener(b paramb)
  {
    this.l = paramb;
  }
  
  public void setOnSwipeListener(c paramc)
  {
    this.i = paramc;
  }
  
  public void setOpenInterpolator(Interpolator paramInterpolator)
  {
    this.n = paramInterpolator;
  }
  
  public void setSwipeDirection(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setdataIn(List<MinsuImReplyCommonBean.DataBean.ListMsgBean> paramList)
  {
    this.o = paramList;
  }
  
  public void smoothCloseMenu()
  {
    if ((this.h != null) && (this.h.isOpen())) {
      this.h.smoothCloseMenu();
    }
  }
  
  public void smoothOpenMenu(int paramInt)
  {
    if ((paramInt >= getFirstVisiblePosition()) && (paramInt <= getLastVisiblePosition()))
    {
      View localView = getChildAt(paramInt - getFirstVisiblePosition());
      if ((localView instanceof SwipeMenuLayout))
      {
        this.g = paramInt;
        if ((this.h != null) && (this.h.isOpen())) {
          this.h.smoothCloseMenu();
        }
        this.h = ((SwipeMenuLayout)localView);
        this.h.setSwipeDirection(this.a);
        this.h.smoothOpenMenu();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean onMenuItemClick(int paramInt1, b paramb, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void onMenuClose(int paramInt);
    
    public abstract void onMenuOpen(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void onSwipeEnd(int paramInt);
    
    public abstract void onSwipeStart(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/swipemenulistviewForScrollView/SwipeMenuListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */