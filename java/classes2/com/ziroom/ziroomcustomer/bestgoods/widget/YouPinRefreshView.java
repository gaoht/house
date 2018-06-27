package com.ziroom.ziroomcustomer.bestgoods.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import java.util.Calendar;

public class YouPinRefreshView
  extends LinearLayout
{
  Calendar a;
  private Scroller b;
  private View c;
  private ImageView d;
  private int e = -65;
  private ProgressBar f;
  private TextView g;
  private TextView h;
  private LinearLayout i;
  private a j;
  private String k;
  private String l;
  private int m;
  private boolean n = false;
  private boolean o = true;
  private boolean p = false;
  private Context q;
  
  public YouPinRefreshView(Context paramContext)
  {
    super(paramContext);
    this.q = paramContext;
  }
  
  public YouPinRefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.q = paramContext;
    a();
  }
  
  private void a()
  {
    this.e = ((int)(this.q.getResources().getDisplayMetrics().density * this.e));
    this.a = Calendar.getInstance();
    this.b = new Scroller(this.q);
    this.c = LayoutInflater.from(this.q).inflate(2130905078, null);
    this.d = ((ImageView)this.c.findViewById(2131694102));
    this.f = ((ProgressBar)this.c.findViewById(2131692289));
    this.g = ((TextView)this.c.findViewById(2131697364));
    this.h = ((TextView)this.c.findViewById(2131697365));
    this.i = ((LinearLayout)this.c.findViewById(2131697363));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -this.e);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.gravity = 17;
    addView(this.c, localLayoutParams);
    this.k = "下拉刷新";
    this.l = "松开后刷新";
  }
  
  private void a(int paramInt)
  {
    Object localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    if (paramInt > 0)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(((LinearLayout.LayoutParams)localObject).topMargin + paramInt * 0.3F));
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.invalidate();
      invalidate();
    }
    for (;;)
    {
      this.h.setVisibility(0);
      this.g.setVisibility(0);
      this.d.setVisibility(0);
      this.f.setVisibility(8);
      if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
        break;
      }
      this.g.setText("松开后刷新");
      localObject = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((RotateAnimation)localObject).setDuration(200L);
      ((RotateAnimation)localObject).setFillAfter(true);
      this.d.setAnimation((Animation)localObject);
      return;
      paramInt = (int)(((LinearLayout.LayoutParams)localObject).topMargin + paramInt * 0.9F);
      Log.i("aa", String.valueOf(paramInt));
      if (paramInt >= this.e)
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = paramInt;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c.invalidate();
        invalidate();
      }
    }
    this.g.setText("下拉刷新");
    localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject).setDuration(200L);
    ((RotateAnimation)localObject).setFillAfter(true);
    this.d.startAnimation((Animation)localObject);
  }
  
  private void b()
  {
    this.i.setVisibility(0);
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis() - this.a.getTimeInMillis();
    int i1 = new Long(l1 / 86400000L).intValue();
    int i2 = new Long(l1 / 3600000L).intValue();
    int i3 = new Long(l1 / 60000L).intValue();
    int i4 = new Long(l1 / 1000L).intValue();
    if (i1 != 0) {
      this.h.setText("距离上次刷新 " + i1 + "天" + i2 + "小时" + i3 + "分钟");
    }
    for (;;)
    {
      this.a = localCalendar;
      return;
      if (i2 != 0) {
        this.h.setText("距离上次刷新 " + i2 + "小时" + i3 + "分钟");
      } else if (i3 != 0) {
        this.h.setText("距离上次刷新 " + i3 + "分钟" + i4 + "秒");
      } else if (i4 != 0) {
        this.h.setText("距离上次刷新 " + i4 + "秒");
      }
    }
  }
  
  private void c()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    Log.i("LILITH", "fling()" + localLayoutParams.topMargin);
    if (localLayoutParams.topMargin > 0)
    {
      e();
      return;
    }
    d();
  }
  
  private void d()
  {
    int i1 = ((LinearLayout.LayoutParams)this.c.getLayoutParams()).topMargin;
    this.b.startScroll(0, i1, 0, this.e - i1);
    invalidate();
  }
  
  private void e()
  {
    int i1 = ((LinearLayout.LayoutParams)this.c.getLayoutParams()).topMargin;
    this.i.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.h.setVisibility(8);
    this.g.setVisibility(8);
    this.b.startScroll(0, i1, 0, 0 - i1);
    invalidate();
    if (this.j != null)
    {
      this.j.onRefresh(this);
      this.p = true;
    }
  }
  
  private boolean f()
  {
    boolean bool = true;
    if (getChildCount() > 1)
    {
      View localView = getChildAt(1);
      if (((localView instanceof ListView)) && (((ListView)localView).getChildCount() > 0)) {
        return (Math.abs(((ListView)localView).getChildAt(0).getTop() - ((ListView)localView).getListPaddingTop()) < 3) && (((ListView)localView).getFirstVisiblePosition() == 0);
      }
      if (((localView instanceof ScrollView)) && (((ScrollView)localView).getChildCount() > 0))
      {
        if (localView.getScrollY() == 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      int i1 = this.b.getCurrY();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.topMargin = Math.max(i1, this.e);
      this.c.setLayoutParams(localLayoutParams);
      this.c.invalidate();
      invalidate();
    }
  }
  
  public void finishRefresh()
  {
    Log.i("LILITH", "执行了=====finishRefresh");
    int i1 = ((LinearLayout.LayoutParams)this.c.getLayoutParams()).topMargin;
    this.d.setVisibility(0);
    this.h.setVisibility(0);
    this.b.startScroll(0, i1, 0, this.e - i1);
    invalidate();
    this.p = false;
    this.a = Calendar.getInstance();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    int i1 = (int)paramMotionEvent.getRawY();
    switch (i2)
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.m = i1;
      }
      i2 = this.m;
      this.m = i1;
    } while ((i1 - i2 <= 0) || (!f()));
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.m = i1;
      continue;
      Log.i("LILITH", "ACTION_MOVE");
      int i2 = i1 - this.m;
      if (((i2 < 6) && (i2 > -1)) || (!this.n))
      {
        b();
        a(i2);
      }
      this.m = i1;
      continue;
      Log.i("LILITH", "ACTION_UP");
      c();
    }
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setRefreshListener(a parama)
  {
    this.j = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onRefresh(YouPinRefreshView paramYouPinRefreshView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/widget/YouPinRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */