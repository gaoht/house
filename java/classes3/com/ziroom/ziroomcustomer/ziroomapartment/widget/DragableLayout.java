package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class DragableLayout
  extends RelativeLayout
{
  private final String a = "DragableLayout";
  private Context b;
  private int c = -1;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private boolean k = true;
  private Scroller l;
  private int m;
  private int n;
  private int o = 0;
  private int p = 0;
  private int q;
  private a r;
  
  public DragableLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DragableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DragableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    paramContext = this.b.getResources().getDisplayMetrics();
    this.e = paramContext.widthPixels;
    this.f = paramContext.heightPixels;
    this.q = ViewConfiguration.get(this.b).getScaledTouchSlop();
    this.c = 2;
    this.l = new Scroller(this.b);
  }
  
  private boolean a()
  {
    return this.k;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.l.computeScrollOffset())
    {
      layout(this.l.getCurrX(), this.l.getCurrY(), this.l.getCurrX() + this.g, this.l.getCurrY() + this.h);
      if (this.r != null) {
        this.r.onDrag(getTop(), getTop() - this.i, Math.round((getTop() - this.i) / (this.j - this.i) * 100.0F) / 100.0F);
      }
      invalidate();
    }
  }
  
  public int getStatus()
  {
    if (getTop() == this.i) {
      return 1;
    }
    if (getTop() == this.j) {
      return 2;
    }
    return -1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    Log.d("DragableLayout", "====onInterceptTouchEvent:x:" + i1 + ",y:" + i2 + ",lastX:" + this.m + ";lastY:" + this.n);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.m = i1;
        this.n = i2;
      }
      this.o = (i1 - this.m);
      this.p = (i2 - this.n);
    } while ((!a()) || (((getTop() != this.i) || (this.p <= 0)) && ((getTop() != this.j) || (this.p >= 0))));
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = getMeasuredWidth();
    this.h = getMeasuredHeight();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        this.m = i1;
        this.n = i2;
        return true;
        this.o = (i1 - this.m);
        this.p = (i2 - this.n);
      } while ((a()) && (this.o * this.o + this.p * this.p > this.q * this.q));
      this.p = 0;
      return true;
    } while ((this.p == 0) || (!a()));
    if (this.p < 0) {
      scrollToTop();
    }
    for (;;)
    {
      invalidate();
      return true;
      scrollToBottom();
    }
  }
  
  public void scrollToBottom()
  {
    this.l.startScroll(getLeft(), getTop(), 0, this.j - getTop());
    invalidate();
  }
  
  public void scrollToTop()
  {
    this.l.startScroll(getLeft(), getTop(), 0, this.i - getTop());
    invalidate();
  }
  
  public void setBottomEdge(int paramInt)
  {
    if (paramInt < this.i) {
      return;
    }
    this.j = paramInt;
  }
  
  public void setDragListener(a parama)
  {
    this.r = parama;
  }
  
  public void setDragable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setTopEdge(int paramInt)
  {
    if ((paramInt > this.j) || (paramInt < 0)) {
      return;
    }
    this.i = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onDrag(int paramInt1, int paramInt2, float paramFloat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/DragableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */