package com.ziroom.ziroomcustomer.newrepair.widget;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class ElasticScrollView
  extends ScrollView
{
  private int a;
  private int b;
  private LinearLayout c;
  private LinearLayout d;
  private ImageView e;
  private ProgressBar f;
  private TextView g;
  private TextView h;
  private a i;
  private boolean j;
  private int k;
  private boolean l;
  private RotateAnimation m;
  private RotateAnimation n;
  private boolean o;
  private boolean p;
  private int q;
  
  public ElasticScrollView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ElasticScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ElasticScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    switch (this.k)
    {
    default: 
      return;
    case 0: 
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.e.clearAnimation();
      this.e.startAnimation(this.m);
      this.g.setText("松开刷新");
      Log.i("ElasticScrollView", "当前状态，松开刷新");
      return;
    case 1: 
      this.f.setVisibility(8);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.e.clearAnimation();
      this.e.setVisibility(0);
      if (this.l)
      {
        this.l = false;
        this.e.clearAnimation();
        this.e.startAnimation(this.n);
        this.g.setText("下拉刷新");
      }
      for (;;)
      {
        Log.i("ElasticScrollView", "当前状态，下拉刷新");
        return;
        this.g.setText("下拉刷新");
      }
    case 2: 
      this.d.setPadding(0, 0, 0, 0);
      this.f.setVisibility(0);
      this.e.clearAnimation();
      this.e.setVisibility(8);
      this.g.setText("正在刷新...");
      this.h.setVisibility(0);
      Log.i("ElasticScrollView", "当前状态,正在刷新...");
      return;
    }
    this.d.setPadding(0, this.b * -1, 0, 0);
    this.f.setVisibility(8);
    this.e.clearAnimation();
    this.e.setImageResource(2130839919);
    this.g.setText("下拉刷新");
    this.h.setVisibility(0);
    Log.e("ElasticScrollView", "当前状态，done");
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    this.c = new LinearLayout(paramContext);
    this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.c.setOrientation(1);
    this.d = ((LinearLayout)localLayoutInflater.inflate(2130905091, null));
    this.e = ((ImageView)this.d.findViewById(2131693276));
    this.f = ((ProgressBar)this.d.findViewById(2131693277));
    this.g = ((TextView)this.d.findViewById(2131693278));
    this.h = ((TextView)this.d.findViewById(2131697027));
    a(this.d);
    this.b = this.d.getMeasuredHeight();
    this.a = this.d.getMeasuredWidth();
    this.d.setPadding(0, this.b * -1, 0, 0);
    this.d.setVisibility(0);
    this.d.invalidate();
    Log.e("size", "width:" + this.a + " height:" + this.b);
    this.c.addView(this.d);
    addView(this.c);
    this.m = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.m.setInterpolator(new LinearInterpolator());
    this.m.setDuration(250L);
    this.m.setFillAfter(true);
    this.n = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.n.setInterpolator(new LinearInterpolator());
    this.n.setDuration(200L);
    this.n.setFillAfter(true);
    this.k = 3;
    this.j = false;
    this.o = false;
    requestDisallowInterceptTouchEvent(true);
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
    if (this.i != null) {
      this.i.onRefresh();
    }
  }
  
  public void addChild(View paramView)
  {
    this.c.addView(paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    this.c.addView(paramView, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      Log.e("TAG", "touchEvent---》" + bool);
      return super.onInterceptTouchEvent(paramMotionEvent);
      Log.e("TAG", "Intercept_DOWN");
      continue;
      Log.e("TAG", "Intercept_MOVE");
      continue;
      Log.e("TAG", "Intercept_UP");
    }
  }
  
  public void onRefreshComplete()
  {
    this.k = 3;
    this.h.setText("最近更新:刚刚");
    a();
    invalidate();
    scrollTo(0, 0);
    this.d.setPadding(0, this.b * -1, 0, 0);
    this.d.setVisibility(4);
    this.f.setVisibility(8);
    invalidate();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.i != null) {
      this.i.onScroll(paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j) {
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
        if ((getScrollY() == 0) && (!this.p))
        {
          this.d.setVisibility(0);
          this.p = true;
          this.q = ((int)paramMotionEvent.getY());
          Log.e("ElasticScrollView", "在down时候记录当前位置‘");
        }
        Log.e("TAG", this.d.getVisibility() + "");
        continue;
        if ((this.k != 2) && (this.k != 4))
        {
          if ((this.k != 3) || (this.k == 1))
          {
            this.k = 3;
            a();
            Log.e("ElasticScrollView", "由下拉刷新状态，到done状态");
          }
          if (this.k == 0)
          {
            this.k = 2;
            a();
            b();
            Log.e("ElasticScrollView", "由松开刷新状态，到done状态");
          }
        }
        this.p = false;
        this.l = false;
      }
      i1 = (int)paramMotionEvent.getY();
      Log.e("TAG", this.d.getVisibility() + "");
      if ((!this.p) && (getScrollY() == 0))
      {
        Log.e("ElasticScrollView", "在move时候记录下位置");
        this.p = true;
        this.q = i1;
      }
    } while ((this.k == 2) || (!this.p) || (this.k == 4));
    if (this.k == 0)
    {
      this.o = true;
      if (((i1 - this.q) / 3 < this.b) && (i1 - this.q > 0))
      {
        this.k = 1;
        a();
        Log.e("ElasticScrollView", "由松开刷新状态转变到下拉刷新状态");
      }
    }
    else
    {
      label364:
      if (this.k == 1)
      {
        this.o = true;
        if ((i1 - this.q) / 3 < this.b) {
          break label548;
        }
        this.k = 0;
        this.l = true;
        a();
        Log.e("ElasticScrollView", "由done或者下拉刷新状态转变到松开刷新");
      }
    }
    for (;;)
    {
      if ((this.k == 3) && (i1 - this.q > 0))
      {
        this.k = 1;
        a();
      }
      if (this.k == 1) {
        this.d.setPadding(0, this.b * -1 + (i1 - this.q) / 3, 0, 0);
      }
      if (this.k == 0) {
        this.d.setPadding(0, (i1 - this.q) / 3 - this.b, 0, 0);
      }
      if (!this.o) {
        break;
      }
      this.o = false;
      return true;
      if (i1 - this.q > 0) {
        break label364;
      }
      this.k = 3;
      a();
      Log.e("ElasticScrollView", "由松开刷新状态转变到done状态");
      break label364;
      label548:
      if (i1 - this.q <= 0)
      {
        this.k = 3;
        a();
        Log.e("ElasticScrollView", "由DOne或者下拉刷新状态转变到done状态");
      }
    }
  }
  
  public void setonRefreshListener(a parama)
  {
    this.i = parama;
    this.j = true;
  }
  
  public static abstract interface a
  {
    public abstract void onRefresh();
    
    public abstract void onScroll(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/widget/ElasticScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */