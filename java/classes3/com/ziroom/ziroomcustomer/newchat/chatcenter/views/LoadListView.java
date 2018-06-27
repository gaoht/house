package com.ziroom.ziroomcustomer.newchat.chatcenter.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class LoadListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float a = -1.0F;
  private Scroller b;
  private AbsListView.OnScrollListener c;
  private a d;
  private XListViewFooter e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private int i;
  private int j;
  
  public LoadListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LoadListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LoadListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    int k = this.e.getBottomMargin();
    if (k > 0)
    {
      this.j = 1;
      this.b.startScroll(0, k, 0, -k, 400);
      invalidate();
    }
  }
  
  private void a(float paramFloat)
  {
    int k = this.e.getBottomMargin() + (int)paramFloat;
    if ((this.f) && (!this.g))
    {
      if (k <= 50) {
        break label48;
      }
      this.e.setState(1);
    }
    for (;;)
    {
      this.e.setBottomMargin(k);
      return;
      label48:
      this.e.setState(0);
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = new Scroller(paramContext, new DecelerateInterpolator());
    super.setOnScrollListener(this);
    this.e = new XListViewFooter(paramContext);
  }
  
  private void b()
  {
    this.g = true;
    this.e.setState(2);
    if (this.d != null) {
      this.d.onLoadMore();
    }
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset()) {
      if (this.j != 0) {
        break label26;
      }
    }
    for (;;)
    {
      postInvalidate();
      super.computeScroll();
      return;
      label26:
      this.e.setBottomMargin(this.b.getCurrY());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = paramInt3;
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
      if (getLastVisiblePosition() == this.i - 1)
      {
        if ((this.f) && (this.e.getBottomMargin() > 50)) {
          b();
        }
        a();
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
      if ((getLastVisiblePosition() == this.i - 1) && ((this.e.getBottomMargin() > 0) || (f1 < 0.0F))) {
        a(-f1 / 1.8F);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (!this.h)
    {
      this.h = true;
      addFooterView(this.e);
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }
  
  public void setPullLoadEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (!this.f)
    {
      this.e.hide();
      this.e.setOnClickListener(null);
      return;
    }
    this.g = false;
    this.e.show();
    this.e.setState(0);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LoadListView.a(LoadListView.this);
      }
    });
  }
  
  public void setXListViewListener(a parama)
  {
    this.d = parama;
  }
  
  public void stopLoadMore()
  {
    if (this.g == true)
    {
      this.g = false;
      this.e.setState(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLoadMore();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/views/LoadListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */