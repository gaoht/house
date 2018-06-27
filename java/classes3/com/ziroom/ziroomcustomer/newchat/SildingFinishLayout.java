package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

public class SildingFinishLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  private ViewGroup a;
  private View b;
  private int c;
  private int d;
  private int e;
  private int f;
  private Scroller g;
  private int h;
  private boolean i;
  private a j;
  private boolean k;
  
  public SildingFinishLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SildingFinishLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.g = new Scroller(paramContext);
  }
  
  private void a()
  {
    int m = this.h + this.a.getScrollX();
    this.g.startScroll(this.a.getScrollX(), 0, -m + 1, 0, Math.abs(m));
    postInvalidate();
  }
  
  private void b()
  {
    int m = this.a.getScrollX();
    this.g.startScroll(this.a.getScrollX(), 0, -m, 0, Math.abs(m));
    postInvalidate();
  }
  
  private boolean c()
  {
    return this.b instanceof AbsListView;
  }
  
  private boolean d()
  {
    return this.b instanceof ScrollView;
  }
  
  public void computeScroll()
  {
    if (this.g.computeScrollOffset())
    {
      this.a.scrollTo(this.g.getCurrX(), this.g.getCurrY());
      postInvalidate();
      if ((this.g.isFinished()) && (this.j != null) && (this.k)) {
        this.j.onSildingFinish();
      }
    }
  }
  
  public View getTouchView()
  {
    return this.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.a = ((ViewGroup)getParent());
      this.h = getWidth();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1;
      if (!d())
      {
        bool1 = bool2;
        if (!c()) {}
      }
      else
      {
        bool1 = paramView.onTouchEvent(paramMotionEvent);
      }
      do
      {
        return bool1;
        int m = (int)paramMotionEvent.getRawX();
        this.f = m;
        this.d = m;
        this.e = ((int)paramMotionEvent.getRawY());
        break;
        m = (int)paramMotionEvent.getRawX();
        int n = this.f;
        this.f = m;
        if ((Math.abs(m - this.d) > this.c) && (Math.abs((int)paramMotionEvent.getRawY() - this.e) < this.c))
        {
          this.i = true;
          if (c())
          {
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
            paramView.onTouchEvent(localMotionEvent);
          }
        }
        if ((m - this.d < 0) || (!this.i)) {
          break;
        }
        this.a.scrollBy(n - m, 0);
        bool1 = bool2;
      } while (d());
      if (c())
      {
        return true;
        if (this.a.getScrollX() <= -this.h / 2)
        {
          return false;
          this.i = false;
          if (this.a.getScrollX() <= -this.h / 2)
          {
            this.k = true;
            a();
          }
          else
          {
            b();
            this.k = false;
            continue;
            this.i = false;
            if (this.a.getScrollX() <= -this.h / 2)
            {
              this.k = true;
              a();
            }
            else
            {
              b();
              this.k = false;
            }
          }
        }
      }
    }
  }
  
  public void setOnSildingFinishListener(a parama)
  {
    this.j = parama;
  }
  
  public void setTouchView(View paramView)
  {
    this.b = paramView;
    paramView.setOnTouchListener(this);
  }
  
  public static abstract interface a
  {
    public abstract void onSildingFinish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/SildingFinishLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */