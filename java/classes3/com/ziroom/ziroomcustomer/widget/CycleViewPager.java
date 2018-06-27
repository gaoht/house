package com.ziroom.ziroomcustomer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
@Instrumented
public class CycleViewPager
  extends Fragment
  implements ViewPager.OnPageChangeListener
{
  public int a;
  Context b;
  final Runnable c = new Runnable()
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
  private List<ImageView> d = new ArrayList();
  private RelativeLayout e;
  private BaseViewPager f;
  private BaseViewPager g;
  private c h;
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
  private b s;
  private int t;
  private int u = 0;
  private TextView v;
  private ScalingUtils.ScaleType w = ScalingUtils.ScaleType.FIT_XY;
  
  private ImageView a(String paramString)
  {
    if (this.u == 0)
    {
      localObject = new SimpleDraweeView(this.b);
      ((SimpleDraweeView)localObject).setLayoutParams(new LinearLayout.LayoutParams(this.a, this.a * 3 / 4));
      ((SimpleDraweeView)localObject).setController(c.frescoController(paramString));
      return (ImageView)localObject;
    }
    Object localObject = new ZoomableDraweeView(this.b);
    ((ZoomableDraweeView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    ((ZoomableDraweeView)localObject).setController(c.frescoController(paramString));
    return (ImageView)localObject;
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
  
  public List<ImageView> getImageViews()
  {
    return this.d;
  }
  
  public BaseViewPager getViewPager()
  {
    return this.f;
  }
  
  public void hide()
  {
    this.e.setVisibility(8);
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
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2130905196, null);
    this.f = ((BaseViewPager)paramLayoutInflater.findViewById(2131690960));
    this.e = ((RelativeLayout)paramLayoutInflater.findViewById(2131697707));
    this.v = ((TextView)paramLayoutInflater.findViewById(2131693062));
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
          CycleViewPager.f(CycleViewPager.this).removeCallbacks(CycleViewPager.this.c);
          CycleViewPager.f(CycleViewPager.this).postDelayed(CycleViewPager.this.c, CycleViewPager.g(CycleViewPager.this));
        }
        while ((paramAnonymousMessage.what != CycleViewPager.h(CycleViewPager.this)) || (CycleViewPager.b(CycleViewPager.this).size() == 0))
        {
          int i;
          int j;
          return;
        }
        CycleViewPager.f(CycleViewPager.this).removeCallbacks(CycleViewPager.this.c);
        CycleViewPager.f(CycleViewPager.this).postDelayed(CycleViewPager.this.c, CycleViewPager.g(CycleViewPager.this));
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
    int i2 = this.d.size() - 1;
    this.k = paramInt;
    int i1 = paramInt;
    if (this.m)
    {
      if (paramInt != 0) {
        break label102;
      }
      this.k = (i2 - 1);
    }
    for (;;)
    {
      i1 = this.k - 1;
      this.v.setText(i1 + 1 + "/" + (this.t - 2));
      if (this.s != null) {
        this.s.onPosChange(this.k);
      }
      return;
      label102:
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
  
  public void setCurrentItem(int paramInt)
  {
    if (!this.l)
    {
      this.k = paramInt;
      this.v.setText(paramInt + 1 + "/" + (this.t - 2));
      this.f.setCurrentItem(this.k, false);
      if (this.s != null) {
        this.s.onPosChange(this.k);
      }
    }
  }
  
  public void setCycle(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setData(Context paramContext, List<String> paramList, a parama)
  {
    setData(paramContext, paramList, parama, 0, 0);
  }
  
  public void setData(Context paramContext, List<String> paramList, a parama, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.u = paramInt2;
    this.r = parama;
    this.d.clear();
    paramContext = (WindowManager)paramContext.getSystemService("window");
    parama = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(parama);
    this.a = parama.widthPixels;
    if (paramList.size() > 0)
    {
      this.d.add(a((String)paramList.get(paramList.size() - 1)));
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        parama = (String)paramContext.next();
        this.d.add(a(parama));
      }
      this.d.add(a((String)paramList.get(0)));
    }
    this.t = this.d.size();
    this.v.setText("1/" + (this.t - 2));
    this.h = new c(null);
    this.f.setOffscreenPageLimit(3);
    this.f.setOnPageChangeListener(this);
    this.f.setAdapter(this.h);
    if (paramInt1 >= 0)
    {
      paramInt2 = paramInt1;
      if (paramInt1 < this.d.size()) {}
    }
    else
    {
      paramInt2 = 0;
    }
    paramInt1 = paramInt2;
    if (this.m) {
      paramInt1 = paramInt2 + 1;
    }
    this.f.setCurrentItem(paramInt1);
  }
  
  public void setIsPageNumVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.v.setVisibility(0);
      return;
    }
    this.v.setVisibility(8);
  }
  
  public void setPosChangeListener(b paramb)
  {
    this.s = paramb;
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.w = paramScaleType;
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
      this.i.postDelayed(this.c, this.j);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onImageClick(int paramInt, View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void onPosChange(int paramInt);
  }
  
  private class c
    extends PagerAdapter
  {
    private c() {}
    
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
    
    public View instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      ImageView localImageView = (ImageView)CycleViewPager.b(CycleViewPager.this).get(paramInt);
      if (CycleViewPager.k(CycleViewPager.this) != null) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CycleViewPager.k(CycleViewPager.this).onImageClick(paramInt, paramAnonymousView);
          }
        });
      }
      paramViewGroup.addView(localImageView);
      return localImageView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/CycleViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */