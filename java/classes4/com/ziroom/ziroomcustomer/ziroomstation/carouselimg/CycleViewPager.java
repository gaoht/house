package com.ziroom.ziroomcustomer.ziroomstation.carouselimg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.b;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
@Instrumented
public class CycleViewPager
  extends Fragment
  implements ViewPager.OnPageChangeListener
{
  final Runnable a = new Runnable()
  {
    public void run()
    {
      if ((CycleViewPager.this.getActivity() != null) && (!CycleViewPager.this.getActivity().isFinishing()) && (CycleViewPager.i(CycleViewPager.this)))
      {
        if (System.currentTimeMillis() - CycleViewPager.j(CycleViewPager.this) > CycleViewPager.g(CycleViewPager.this) - 500) {
          CycleViewPager.f(CycleViewPager.this).sendEmptyMessage(CycleViewPager.a(CycleViewPager.this));
        }
      }
      else {
        return;
      }
      CycleViewPager.f(CycleViewPager.this).sendEmptyMessage(CycleViewPager.h(CycleViewPager.this));
    }
  };
  private List<SimpleDraweeView> b = new ArrayList();
  private View[] c;
  private FrameLayout d;
  private LinearLayout e;
  private BaseViewPager f;
  private BaseViewPager g;
  private b h;
  private b i;
  private int j = 5000;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private long o = 0L;
  private int p = 100;
  private int q = 101;
  private a r;
  private List<String> s;
  
  private void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.c.length)
    {
      this.c[i1].setBackgroundResource(2130838389);
      i1 += 1;
    }
    if (this.c.length > paramInt) {
      this.c[paramInt].setBackgroundResource(2130838388);
    }
  }
  
  public void disableParentViewPagerTouchEvent(BaseViewPager paramBaseViewPager)
  {
    if (paramBaseViewPager != null) {
      paramBaseViewPager.setScrollable(false);
    }
  }
  
  public int getCurrentPostion()
  {
    return this.k;
  }
  
  public BaseViewPager getViewPager()
  {
    return this.f;
  }
  
  public void hide()
  {
    this.d.setVisibility(8);
  }
  
  public boolean isCycle()
  {
    return this.m;
  }
  
  public boolean isWheel()
  {
    return this.n;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2130905197, paramViewGroup, false);
    this.f = ((BaseViewPager)paramLayoutInflater.findViewById(2131690960));
    this.e = ((LinearLayout)paramLayoutInflater.findViewById(2131697708));
    this.d = ((FrameLayout)paramLayoutInflater.findViewById(2131697707));
    this.i = new b(getActivity())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if ((paramAnonymousMessage.what == CycleViewPager.a(CycleViewPager.this)) && (CycleViewPager.b(CycleViewPager.this).size() != 0))
        {
          if (!CycleViewPager.c(CycleViewPager.this))
          {
            i = CycleViewPager.b(CycleViewPager.this).size();
            j = (CycleViewPager.d(CycleViewPager.this) + 1) % CycleViewPager.b(CycleViewPager.this).size();
            CycleViewPager.e(CycleViewPager.this).setCurrentItem(j, true);
            if (j == i + 1) {
              CycleViewPager.e(CycleViewPager.this).setCurrentItem(1, false);
            }
          }
          CycleViewPager.a(CycleViewPager.this, System.currentTimeMillis());
          CycleViewPager.f(CycleViewPager.this).removeCallbacks(CycleViewPager.this.a);
          CycleViewPager.f(CycleViewPager.this).postDelayed(CycleViewPager.this.a, CycleViewPager.g(CycleViewPager.this));
        }
        while ((paramAnonymousMessage.what != CycleViewPager.h(CycleViewPager.this)) || (CycleViewPager.b(CycleViewPager.this).size() == 0))
        {
          int i;
          int j;
          return;
        }
        CycleViewPager.f(CycleViewPager.this).removeCallbacks(CycleViewPager.this.a);
        CycleViewPager.f(CycleViewPager.this).postDelayed(CycleViewPager.this.a, CycleViewPager.g(CycleViewPager.this));
      }
    };
    return paramLayoutInflater;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.l = true;
      return;
    }
    if (paramInt == 0)
    {
      if (this.g != null) {
        this.g.setScrollable(true);
      }
      this.o = System.currentTimeMillis();
      this.f.setCurrentItem(this.k, false);
    }
    this.l = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i2 = this.b.size() - 1;
    this.k = paramInt;
    int i1 = paramInt;
    if (this.m)
    {
      if (paramInt != 0) {
        break label50;
      }
      this.k = (i2 - 1);
    }
    for (;;)
    {
      i1 = this.k - 1;
      a(i1);
      return;
      label50:
      if (paramInt == i2) {
        this.k = 1;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    VdsAgent.onFragmentPause(this);
  }
  
  public void onResume()
  {
    super.onResume();
    VdsAgent.onFragmentResume(this);
  }
  
  public void refreshData()
  {
    if (this.h != null) {
      this.h.notifyDataSetChanged();
    }
  }
  
  public void releaseHeight()
  {
    getView().getLayoutParams().height = -1;
    refreshData();
  }
  
  public void setCycle(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setData(List<String> paramList, a parama)
  {
    setData(paramList, parama, 0);
  }
  
  public void setData(List<String> paramList, a parama, int paramInt)
  {
    this.r = parama;
    this.s = paramList;
    this.b.clear();
    if (paramList.size() == 0)
    {
      this.d.setVisibility(8);
      return;
    }
    parama = new SimpleDraweeView(getActivity());
    ((GenericDraweeHierarchy)parama.getHierarchy()).setPlaceholderImage(2130837592);
    parama.setTag(paramList.get(paramList.size() - 1));
    parama.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(paramList.size() - 1)));
    this.b.add(parama);
    int i1 = 0;
    while (i1 < paramList.size())
    {
      parama = new SimpleDraweeView(getActivity());
      ((GenericDraweeHierarchy)parama.getHierarchy()).setPlaceholderImage(2130837592);
      parama.setTag(paramList.get(i1));
      parama.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(i1)));
      this.b.add(parama);
      i1 += 1;
    }
    parama = new SimpleDraweeView(getActivity());
    ((GenericDraweeHierarchy)parama.getHierarchy()).setPlaceholderImage(2130837592);
    parama.setTag(paramList.get(0));
    parama.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(0)));
    this.b.add(parama);
    i1 = this.b.size();
    this.c = new View[i1];
    if (this.m) {
      this.c = new View[i1 - 2];
    }
    this.e.removeAllViews();
    i1 = 0;
    while (i1 < this.c.length)
    {
      parama = new View(getActivity());
      parama.setBackgroundResource(2130838389);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(getActivity(), 7), com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(getActivity(), 7));
      localLayoutParams.leftMargin = com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(getActivity(), 3);
      localLayoutParams.rightMargin = com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(getActivity(), 3);
      parama.setLayoutParams(localLayoutParams);
      this.c[i1] = parama;
      this.e.addView(parama);
      i1 += 1;
    }
    this.h = new b(null);
    a(0);
    this.f.setOnPageChangeListener(this);
    this.f.setAdapter(this.h);
    if (paramInt >= 0)
    {
      i1 = paramInt;
      if (paramInt < paramList.size()) {}
    }
    else
    {
      i1 = 0;
    }
    paramInt = i1;
    if (this.m) {
      paramInt = i1 + 1;
    }
    this.f.setCurrentItem(paramInt);
  }
  
  public void setIndicatorCenter()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = 10;
    localLayoutParams.addRule(14);
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.f.setScrollable(paramBoolean);
  }
  
  public void setTime(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
  }
  
  public void setWheel(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.m = true;
    if (paramBoolean) {
      this.i.postDelayed(this.a, this.j);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onImageClick(String paramString, int paramInt, View paramView);
  }
  
  private class b
    extends PagerAdapter
  {
    private b() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return CycleViewPager.b(CycleViewPager.this).size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)CycleViewPager.b(CycleViewPager.this).get(paramInt);
      if (CycleViewPager.k(CycleViewPager.this) != null) {
        localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CycleViewPager.k(CycleViewPager.this).onImageClick((String)CycleViewPager.l(CycleViewPager.this).get(CycleViewPager.d(CycleViewPager.this) - 1), CycleViewPager.d(CycleViewPager.this), paramAnonymousView);
          }
        });
      }
      paramViewGroup.addView(localSimpleDraweeView);
      return localSimpleDraweeView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/carouselimg/CycleViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */