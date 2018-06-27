package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class j
  implements ViewPager.OnPageChangeListener
{
  private ViewPager a;
  private List<String> b;
  private List<View> c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private ScheduledExecutorService i;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      j.b(j.this).setCurrentItem(j.a(j.this), true);
      if (j.a(j.this) == j.c(j.this) - 1) {
        j.b(j.this).setCurrentItem(1, true);
      }
    }
  };
  private a k;
  
  public j(ViewPager paramViewPager, List<String> paramList, List<View> paramList1)
  {
    this.a = paramViewPager;
    if (i.isLegal(paramList))
    {
      paramViewPager = (String)paramList.get(paramList.size() - 1);
      paramList.add(paramViewPager);
      paramList.add(paramViewPager);
      paramList.add(paramViewPager);
      this.b = paramList;
    }
    this.c = paramList1;
    if (paramList != null) {}
    for (int m = paramList.size();; m = 0)
    {
      this.d = m;
      a();
      return;
    }
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    c();
    this.k = new a(this.a.getContext(), this.b);
    this.a.setAdapter(this.k);
    this.a.setOnPageChangeListener(this);
    b();
  }
  
  private void b()
  {
    int n = 0;
    Iterator localIterator = this.c.iterator();
    int m;
    for (;;)
    {
      m = n;
      if (!localIterator.hasNext()) {
        break;
      }
      ((View)localIterator.next()).setVisibility(0);
    }
    while (m < this.c.size())
    {
      if (m > this.d - 1) {
        ((View)this.c.get(m)).setVisibility(8);
      }
      m += 1;
    }
  }
  
  private void c()
  {
    this.g = this.a.getContext().getResources().getDisplayMetrics().widthPixels;
    this.h = (this.g * 2 / 3);
    ((FrameLayout)this.a.getParent()).getLayoutParams().height = this.h;
    this.a.getParent().requestLayout();
  }
  
  public void onDestory() {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.f = paramInt;
    ((View)this.c.get(this.e)).setBackgroundResource(2130838389);
    ((View)this.c.get(paramInt)).setBackgroundResource(2130838388);
    this.e = paramInt;
  }
  
  public void onStart()
  {
    this.i = Executors.newSingleThreadScheduledExecutor();
    this.i.scheduleAtFixedRate(new b(null), 2L, 2L, TimeUnit.SECONDS);
  }
  
  public void onStop()
  {
    this.i.shutdown();
  }
  
  public void update(LinkedList<String> paramLinkedList)
  {
    if (i.isLegal(paramLinkedList))
    {
      String str = (String)paramLinkedList.get(paramLinkedList.size() - 1);
      paramLinkedList.add(str);
      paramLinkedList.add(str);
      paramLinkedList.add(str);
      this.b = paramLinkedList;
    }
    if (paramLinkedList != null) {}
    for (int m = paramLinkedList.size();; m = 0)
    {
      this.d = m;
      this.k.setData(paramLinkedList);
      b();
      return;
    }
  }
  
  class a
    extends PagerAdapter
  {
    private Context b;
    private List<String> c;
    private LinkedList<ImageView> d;
    
    public a(List<String> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
      this.d = new LinkedList();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      try
      {
        paramViewGroup.removeView((View)this.d.get(paramInt));
        return;
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public List<String> getData()
    {
      return this.c;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.b);
      ((GenericDraweeHierarchy)localSimpleDraweeView.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
      localSimpleDraweeView.setTag(j.d(j.this).get(paramInt));
      localSimpleDraweeView.setController(c.frescoController((String)j.d(j.this).get(paramInt)));
      paramViewGroup.addView(localSimpleDraweeView);
      this.d.add(localSimpleDraweeView);
      return localSimpleDraweeView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void setData(LinkedList<String> paramLinkedList)
    {
      this.c = null;
      this.d = null;
      this.c = paramLinkedList;
      this.d = new LinkedList();
      notifyDataSetChanged();
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      synchronized (j.b(j.this))
      {
        Log.d("ViewPagerHelper", "currentPosition: " + j.a(j.this));
        j.a(j.this, (j.a(j.this) + 1) % j.d(j.this).size());
        j.e(j.this).obtainMessage().sendToTarget();
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */