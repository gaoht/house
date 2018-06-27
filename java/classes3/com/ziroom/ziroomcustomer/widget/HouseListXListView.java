package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class HouseListXListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float a = -1.0F;
  private Scroller b;
  private AbsListView.OnScrollListener c;
  private a d;
  private XListViewHeader e;
  private RelativeLayout f;
  private TextView g;
  private int h;
  private boolean i = true;
  private boolean j = false;
  private HouseListXListViewFooter k;
  private boolean l;
  private boolean m;
  private boolean n = false;
  private int o;
  private int p;
  
  public HouseListXListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HouseListXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HouseListXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if ((this.c instanceof b)) {
      ((b)this.c).onXScrolling(this);
    }
  }
  
  private void a(float paramFloat)
  {
    this.e.setVisiableHeight((int)paramFloat + this.e.getVisiableHeight());
    if ((this.i) && (!this.j))
    {
      if (this.e.getVisiableHeight() <= this.h) {
        break label59;
      }
      this.e.setState(1);
    }
    for (;;)
    {
      setSelection(0);
      return;
      label59:
      this.e.setState(0);
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = new Scroller(paramContext, new DecelerateInterpolator());
    super.setOnScrollListener(this);
    this.e = new XListViewHeader(paramContext);
    this.f = ((RelativeLayout)this.e.findViewById(2131697822));
    this.g = ((TextView)this.e.findViewById(2131697825));
    addHeaderView(this.e);
    this.k = new HouseListXListViewFooter(paramContext);
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        HouseListXListView.a(HouseListXListView.this, HouseListXListView.a(HouseListXListView.this).getHeight());
        HouseListXListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    });
  }
  
  private void b()
  {
    int i2 = this.e.getVisiableHeight();
    if (i2 == 0) {}
    while ((this.j) && (i2 <= this.h)) {
      return;
    }
    if ((this.j) && (i2 > this.h)) {}
    for (int i1 = this.h;; i1 = 0)
    {
      this.p = 0;
      this.b.startScroll(0, i2, 0, i1 - i2, 400);
      invalidate();
      return;
    }
  }
  
  private void b(float paramFloat)
  {
    int i1 = this.k.getBottomMargin() + (int)paramFloat;
    if ((this.l) && (!this.m))
    {
      if (i1 <= 50) {
        break label48;
      }
      this.k.setState(1);
    }
    for (;;)
    {
      this.k.setBottomMargin(i1);
      return;
      label48:
      this.k.setState(0);
    }
  }
  
  private void c()
  {
    int i1 = this.k.getBottomMargin();
    if (i1 > 0)
    {
      this.p = 1;
      this.b.startScroll(0, i1, 0, -i1, 400);
      invalidate();
    }
  }
  
  private void d()
  {
    this.m = true;
    this.k.setState(2);
    if (this.d != null) {
      this.d.onLoadMore();
    }
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      if (this.p != 0) {
        break label44;
      }
      this.e.setVisiableHeight(this.b.getCurrY());
    }
    for (;;)
    {
      postInvalidate();
      a();
      super.computeScroll();
      return;
      label44:
      this.k.setBottomMargin(this.b.getCurrY());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.o = paramInt3;
    if (this.c != null) {
      this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c != null) {
      this.c.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == -1.0F) {
      this.a = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      this.a = -1.0F;
      if (getFirstVisiblePosition() == 0)
      {
        if ((this.i) && (this.e.getVisiableHeight() > this.h))
        {
          this.j = true;
          this.e.setState(2);
          if (this.d != null) {
            this.d.onRefresh();
          }
        }
        b();
      }
      break;
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.a = paramMotionEvent.getRawY();
      continue;
      float f1 = paramMotionEvent.getRawY() - this.a;
      this.a = paramMotionEvent.getRawY();
      if ((getFirstVisiblePosition() == 0) && ((this.e.getVisiableHeight() > 0) || (f1 > 0.0F)))
      {
        a(f1 / 1.8F);
        a();
      }
      else if ((getLastVisiblePosition() == this.o - 1) && ((this.k.getBottomMargin() > 0) || (f1 < 0.0F)))
      {
        b(-f1 / 1.8F);
        continue;
        if (getLastVisiblePosition() == this.o - 1)
        {
          if ((this.l) && (this.k.getBottomMargin() > 50)) {
            d();
          }
          c();
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (!this.n)
    {
      this.n = true;
      addFooterView(this.k);
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }
  
  public void setPullLoadEnable(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (!this.l)
    {
      this.k.hide();
      this.k.setOnClickListener(null);
      return;
    }
    this.m = false;
    this.k.show();
    this.k.setState(0);
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HouseListXListView.b(HouseListXListView.this);
      }
    });
  }
  
  public void setPullRefreshEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!this.i)
    {
      this.f.setVisibility(4);
      return;
    }
    this.f.setVisibility(0);
  }
  
  public void setRefreshTime(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void setXListViewListener(a parama)
  {
    this.d = parama;
  }
  
  public void stopLoadMore()
  {
    if (this.m == true)
    {
      this.m = false;
      this.k.setState(0);
    }
  }
  
  public void stopRefresh()
  {
    if (this.j == true)
    {
      this.j = false;
      b();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLoadMore();
    
    public abstract void onRefresh();
  }
  
  public static abstract interface b
    extends AbsListView.OnScrollListener
  {
    public abstract void onXScrolling(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/HouseListXListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */