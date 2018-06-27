package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Date;

public class PullToRefreshView
  extends LinearLayout
{
  private boolean a = true;
  private boolean b = true;
  private int c;
  private boolean d;
  private View e;
  private View f;
  private AdapterView<?> g;
  private ScrollView h;
  private int i;
  private int j;
  private ImageView k;
  private ImageView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private ProgressBar p;
  private ProgressBar q;
  private LayoutInflater r;
  private int s;
  private int t;
  private int u;
  private RotateAnimation v;
  private RotateAnimation w;
  private a x;
  private b y;
  
  public PullToRefreshView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PullToRefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.v = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.v.setInterpolator(new LinearInterpolator());
    this.v.setDuration(250L);
    this.v.setFillAfter(true);
    this.w = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.w.setInterpolator(new LinearInterpolator());
    this.w.setDuration(250L);
    this.w.setFillAfter(true);
    this.r = LayoutInflater.from(getContext());
    b();
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i2 = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i1 = localLayoutParams1.height;
    if (i1 > 0) {}
    for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((this.s == 4) || (this.t == 4)) {}
    View localView;
    label190:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                if (this.g == null) {
                  break label190;
                }
                if (paramInt <= 0) {
                  break;
                }
              } while (!this.a);
              localView = this.g.getChildAt(0);
            } while (localView == null);
            if ((this.g.getFirstVisiblePosition() == 0) && (localView.getTop() == 0))
            {
              this.u = 1;
              return true;
            }
            int i1 = localView.getTop();
            int i2 = this.g.getPaddingTop();
            if ((this.g.getFirstVisiblePosition() != 0) || (Math.abs(i1 - i2) > 11)) {
              break;
            }
            this.u = 1;
            return true;
            if (paramInt >= 0) {
              break;
            }
          } while (!this.b);
          localView = this.g.getChildAt(this.g.getChildCount() - 1);
        } while (localView == null);
        if ((localView.getBottom() <= getHeight()) && (this.g.getLastVisiblePosition() == this.g.getCount() - 1))
        {
          this.u = 0;
          return true;
        }
      } while (this.h == null);
      localView = this.h.getChildAt(0);
      if ((paramInt > 0) && (this.h.getScrollY() == 0))
      {
        this.u = 1;
        return true;
      }
    } while ((paramInt >= 0) || (localView.getMeasuredHeight() > getHeight() + this.h.getScrollY()));
    this.u = 0;
    return true;
  }
  
  private void b()
  {
    this.e = this.r.inflate(2130905085, this, false);
    this.k = ((ImageView)this.e.findViewById(2131697367));
    this.m = ((TextView)this.e.findViewById(2131697369));
    this.o = ((TextView)this.e.findViewById(2131697379));
    this.p = ((ProgressBar)this.e.findViewById(2131697368));
    a(this.e);
    this.i = this.e.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.i);
    localLayoutParams.topMargin = (-this.i);
    addView(this.e, localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    paramInt = d(paramInt);
    if ((paramInt >= 0) && (this.s != 3))
    {
      this.m.setText(2131297353);
      this.o.setVisibility(0);
      this.k.clearAnimation();
      this.k.startAnimation(this.v);
      this.s = 3;
    }
    while ((paramInt >= 0) || (paramInt <= -this.i)) {
      return;
    }
    this.k.clearAnimation();
    this.k.startAnimation(this.v);
    this.m.setText(2131297351);
    this.s = 2;
  }
  
  private void c()
  {
    this.f = this.r.inflate(2130905084, this, false);
    this.l = ((ImageView)this.f.findViewById(2131697377));
    this.n = ((TextView)this.f.findViewById(2131697378));
    this.q = ((ProgressBar)this.f.findViewById(2131697376));
    a(this.f);
    this.j = this.f.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.j);
    addView(this.f, localLayoutParams);
  }
  
  private void c(int paramInt)
  {
    paramInt = d(paramInt);
    if ((Math.abs(paramInt) >= this.i + this.j) && (this.t != 3))
    {
      this.n.setText("下拉刷新加载更多...");
      this.l.clearAnimation();
      this.l.startAnimation(this.v);
      this.t = 3;
    }
    while (Math.abs(paramInt) >= this.i + this.j) {
      return;
    }
    this.l.clearAnimation();
    this.l.startAnimation(this.v);
    this.n.setText("下拉刷新加载更多...");
    this.t = 2;
  }
  
  private int d(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    float f1 = localLayoutParams.topMargin;
    float f2 = paramInt;
    if ((paramInt > 0) && (this.u == 0) && (Math.abs(localLayoutParams.topMargin) <= this.i)) {
      return localLayoutParams.topMargin;
    }
    if ((paramInt < 0) && (this.u == 1) && (Math.abs(localLayoutParams.topMargin) >= this.i)) {
      return localLayoutParams.topMargin;
    }
    localLayoutParams.topMargin = ((int)(f1 + f2 * 0.3F));
    this.e.setLayoutParams(localLayoutParams);
    invalidate();
    return localLayoutParams.topMargin;
  }
  
  private void d()
  {
    int i2 = getChildCount();
    if (i2 < 3) {
      throw new IllegalArgumentException("this layout must contain 3 child views,and AdapterView or ScrollView must in the second position!");
    }
    int i1 = 0;
    while (i1 < i2 - 1)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof AdapterView)) {
        this.g = ((AdapterView)localView);
      }
      if ((localView instanceof ScrollView)) {
        this.h = ((ScrollView)localView);
      }
      i1 += 1;
    }
    if ((this.g == null) && (this.h == null)) {
      throw new IllegalArgumentException("must contain a AdapterView or ScrollView in this layout!");
    }
  }
  
  private void e()
  {
    this.t = 4;
    setHeaderTopMargin(-(this.i + this.j));
    this.l.setVisibility(8);
    this.l.clearAnimation();
    this.l.setImageDrawable(null);
    this.q.setVisibility(0);
    this.n.setText("下拉刷新加载更多...");
    if (this.x != null) {
      this.x.onFooterRefresh(this);
    }
  }
  
  private int getHeaderTopMargin()
  {
    return ((LinearLayout.LayoutParams)this.e.getLayoutParams()).topMargin;
  }
  
  private void setHeaderTopMargin(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.e.setLayoutParams(localLayoutParams);
    invalidate();
  }
  
  public void headerRefreshing()
  {
    this.s = 4;
    setHeaderTopMargin(0);
    this.k.setVisibility(8);
    this.k.clearAnimation();
    this.k.setImageDrawable(null);
    this.p.setVisibility(0);
    this.m.setText(2131297352);
    if (this.y != null) {
      this.y.onHeaderRefresh(this);
    }
  }
  
  public boolean isEnablePullLoadMoreDataStatus()
  {
    return this.b;
  }
  
  public boolean isEnablePullTorefresh()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c();
    d();
  }
  
  public void onFooterRefreshComplete()
  {
    setHeaderTopMargin(-this.i);
    this.l.setVisibility(0);
    this.l.setImageResource(2130837609);
    this.n.setText("下拉刷新加载更多...");
    this.q.setVisibility(8);
    this.t = 2;
  }
  
  public void onFooterRefreshComplete(int paramInt)
  {
    if (paramInt > 0) {
      this.f.setVisibility(0);
    }
    for (;;)
    {
      setHeaderTopMargin(-this.i);
      this.l.setVisibility(0);
      this.l.setImageResource(2130837609);
      this.n.setText("下拉刷新加载更多...");
      this.q.setVisibility(8);
      this.t = 2;
      return;
      this.f.setVisibility(8);
    }
  }
  
  public void onHeaderRefreshComplete()
  {
    setHeaderTopMargin(-this.i);
    this.k.setVisibility(0);
    this.k.setImageResource(2130837609);
    this.m.setText(2131297351);
    this.p.setVisibility(8);
    this.s = 2;
    setLastUpdated("最近更新:" + new Date().toLocaleString());
  }
  
  public void onHeaderRefreshComplete(CharSequence paramCharSequence)
  {
    setLastUpdated(paramCharSequence);
    onHeaderRefreshComplete();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.c = i1;
      }
    } while (!a(i1 - this.c));
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      return true;
    }
    int i1 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i2 = i1 - this.c;
      if (this.u == 1)
      {
        Log.i("PullToRefreshView", " pull down!parent view move!");
        b(i2);
      }
      for (;;)
      {
        this.c = i1;
        break;
        if (this.u == 0)
        {
          Log.i("PullToRefreshView", "pull up!parent view move!");
          c(i2);
        }
      }
      i1 = getHeaderTopMargin();
      if (this.u == 1)
      {
        if (i1 >= 0) {
          headerRefreshing();
        } else {
          setHeaderTopMargin(-this.i);
        }
      }
      else if (this.u == 0) {
        if (Math.abs(i1) >= this.i + this.j) {
          e();
        } else {
          setHeaderTopMargin(-this.i);
        }
      }
    }
  }
  
  public void setEnablePullLoadMoreDataStatus(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setEnablePullTorefresh(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setLastUpdated(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.o.setVisibility(0);
      this.o.setText(paramCharSequence);
      return;
    }
    this.o.setVisibility(8);
  }
  
  public void setOnFooterRefreshListener(a parama)
  {
    this.x = parama;
  }
  
  public void setOnHeaderRefreshListener(b paramb)
  {
    this.y = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void onFooterRefresh(PullToRefreshView paramPullToRefreshView);
  }
  
  public static abstract interface b
  {
    public abstract void onHeaderRefresh(PullToRefreshView paramPullToRefreshView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/PullToRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */