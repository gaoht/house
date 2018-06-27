package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MyListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private LayoutInflater a;
  private LinearLayout b;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private RotateAnimation f;
  private RotateAnimation g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private a o;
  private boolean p;
  private Animation q;
  
  public MyListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    switch (this.m)
    {
    default: 
      return;
    case 0: 
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.c.setVisibility(0);
      this.d.clearAnimation();
      this.d.startAnimation(this.f);
      this.c.setText("松开刷新");
      Log.v("listview", "当前状态，松开刷新");
      return;
    case 1: 
      this.e.setVisibility(8);
      this.c.setVisibility(0);
      this.d.clearAnimation();
      this.d.setVisibility(0);
      if (this.n)
      {
        this.n = false;
        this.d.clearAnimation();
        this.d.startAnimation(this.g);
        this.c.setText("下拉刷新");
      }
      for (;;)
      {
        Log.v("listview", "当前状态，下拉刷新");
        return;
        this.c.setText("下拉刷新");
      }
    case 2: 
      this.b.setPadding(0, 0, 0, 0);
      this.e.setVisibility(0);
      this.c.setText("页面加载中，请稍等...");
      rotateAnimation();
      Log.v("listview", "当前状态,正在刷新...");
      return;
    }
    this.b.setPadding(0, this.j * -1, 0, 0);
    this.e.setVisibility(8);
    this.d.clearAnimation();
    this.e.clearAnimation();
    this.d.setImageResource(2130838954);
    this.c.setText("下拉刷新");
    Log.v("listview", "当前状态，done");
  }
  
  private void a(Context paramContext)
  {
    setCacheColorHint(paramContext.getResources().getColor(2131624576));
    this.a = LayoutInflater.from(paramContext);
    this.b = ((LinearLayout)this.a.inflate(2130903687, null));
    this.d = ((ImageView)this.b.findViewById(2131693276));
    this.e = ((ImageView)this.b.findViewById(2131693277));
    this.c = ((TextView)this.b.findViewById(2131693278));
    a(this.b);
    this.j = this.b.getMeasuredHeight();
    this.i = this.b.getMeasuredWidth();
    this.b.setPadding(0, this.j * -1, 0, 0);
    this.b.invalidate();
    Log.v("size", "width:" + this.i + " height:" + this.j);
    addHeaderView(this.b, null, false);
    setOnScrollListener(this);
    this.f = new RotateAnimation(0.0F, -360.0F, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(new LinearInterpolator());
    this.f.setDuration(250L);
    this.f.setFillAfter(true);
    this.g = new RotateAnimation(-360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.g.setInterpolator(new LinearInterpolator());
    this.g.setDuration(200L);
    this.g.setFillAfter(true);
    this.m = 3;
    this.p = false;
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
  
  private void b()
  {
    if (this.o != null) {
      this.o.onRefresh();
    }
  }
  
  public void onRefreshComplete()
  {
    this.m = 3;
    a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.p) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    int i1;
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        if ((this.l == 0) && (!this.h))
        {
          this.h = true;
          this.k = ((int)paramMotionEvent.getY());
          Log.v("listview", "在down时候记录当前位置‘");
          continue;
          if ((this.m != 2) && (this.m != 4))
          {
            if ((this.m != 3) || (this.m == 1))
            {
              this.m = 3;
              a();
              Log.v("listview", "由下拉刷新状态，到done状态");
            }
            if (this.m == 0)
            {
              this.m = 2;
              a();
              b();
              Log.v("listview", "由松开刷新状态，到done状态");
            }
          }
          this.h = false;
          this.n = false;
        }
      }
      i1 = (int)paramMotionEvent.getY();
      if ((!this.h) && (this.l == 0))
      {
        Log.v("listview", "在move时候记录下位置");
        this.h = true;
        this.k = i1;
      }
    } while ((this.m == 2) || (!this.h) || (this.m == 4));
    if (this.m == 0)
    {
      setSelection(0);
      if (((i1 - this.k) / 3 < this.j) && (i1 - this.k > 0))
      {
        this.m = 1;
        a();
        Log.v("listview", "由松开刷新状态转变到下拉刷新状态");
      }
    }
    else
    {
      label290:
      if (this.m == 1)
      {
        setSelection(0);
        if ((i1 - this.k) / 3 < this.j) {
          break label463;
        }
        this.m = 0;
        this.n = true;
        a();
        Log.v("listview", "由done或者下拉刷新状态转变到松开刷新");
      }
    }
    for (;;)
    {
      if ((this.m == 3) && (i1 - this.k > 0))
      {
        this.m = 1;
        a();
      }
      if (this.m == 1) {
        this.b.setPadding(0, this.j * -1 + (i1 - this.k) / 3, 0, 0);
      }
      if (this.m != 0) {
        break;
      }
      this.b.setPadding(0, (i1 - this.k) / 3 - this.j, 0, 0);
      break;
      if (i1 - this.k > 0) {
        break label290;
      }
      this.m = 3;
      a();
      Log.v("listview", "由松开刷新状态转变到done状态");
      break label290;
      label463:
      if (i1 - this.k <= 0)
      {
        this.m = 3;
        a();
        Log.v("listview", "由DOne或者下拉刷新状态转变到done状态");
      }
    }
  }
  
  public void rotateAnimation()
  {
    this.q = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.q.setDuration(1000L);
    this.q.setRepeatCount(-1);
    this.q.setInterpolator(new LinearInterpolator());
    this.e.setAnimation(this.q);
    this.q.start();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    super.setAdapter(paramBaseAdapter);
  }
  
  public void setonRefreshListener(a parama)
  {
    this.o = parama;
    this.p = true;
  }
  
  public static abstract interface a
  {
    public abstract void onRefresh();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/MyListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */