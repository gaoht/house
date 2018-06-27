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
import com.ziroom.ziroomcustomer.ziroomstation.model.ZSpaceImageItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
@Instrumented
public class ZryuCycleViewPager
  extends Fragment
  implements ViewPager.OnPageChangeListener
{
  public int a;
  Context b;
  final Runnable c = new Runnable()
  {
    public void run()
    {
      if ((ZryuCycleViewPager.this.getActivity() != null) && (!ZryuCycleViewPager.this.getActivity().isFinishing()) && (ZryuCycleViewPager.i(ZryuCycleViewPager.this)))
      {
        if (System.currentTimeMillis() - ZryuCycleViewPager.j(ZryuCycleViewPager.this) > ZryuCycleViewPager.g(ZryuCycleViewPager.this) - 500) {
          ZryuCycleViewPager.f(ZryuCycleViewPager.this).sendEmptyMessage(ZryuCycleViewPager.a(ZryuCycleViewPager.this));
        }
      }
      else {
        return;
      }
      ZryuCycleViewPager.f(ZryuCycleViewPager.this).sendEmptyMessage(ZryuCycleViewPager.h(ZryuCycleViewPager.this));
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
      c.frescoHierarchyController((SimpleDraweeView)localObject, this.w, 2130838349);
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
        if ((paramAnonymousMessage.what == ZryuCycleViewPager.a(ZryuCycleViewPager.this)) && (ZryuCycleViewPager.b(ZryuCycleViewPager.this).size() != 0))
        {
          if (!ZryuCycleViewPager.c(ZryuCycleViewPager.this))
          {
            i = ZryuCycleViewPager.b(ZryuCycleViewPager.this).size();
            j = (ZryuCycleViewPager.d(ZryuCycleViewPager.this) + 1) % ZryuCycleViewPager.b(ZryuCycleViewPager.this).size();
            ZryuCycleViewPager.e(ZryuCycleViewPager.this).setCurrentItem(j, true);
            if (j == i + 1) {
              ZryuCycleViewPager.e(ZryuCycleViewPager.this).setCurrentItem(1, false);
            }
          }
          ZryuCycleViewPager.a(ZryuCycleViewPager.this, System.currentTimeMillis());
          ZryuCycleViewPager.f(ZryuCycleViewPager.this).removeCallbacks(ZryuCycleViewPager.this.c);
          ZryuCycleViewPager.f(ZryuCycleViewPager.this).postDelayed(ZryuCycleViewPager.this.c, ZryuCycleViewPager.g(ZryuCycleViewPager.this));
        }
        while ((paramAnonymousMessage.what != ZryuCycleViewPager.h(ZryuCycleViewPager.this)) || (ZryuCycleViewPager.b(ZryuCycleViewPager.this).size() == 0))
        {
          int i;
          int j;
          return;
        }
        ZryuCycleViewPager.f(ZryuCycleViewPager.this).removeCallbacks(ZryuCycleViewPager.this.c);
        ZryuCycleViewPager.f(ZryuCycleViewPager.this).postDelayed(ZryuCycleViewPager.this.c, ZryuCycleViewPager.g(ZryuCycleViewPager.this));
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
  
  public void setData(Context paramContext, List<ZSpaceImageItem> paramList, a parama)
  {
    setData(paramContext, paramList, parama, 0, 0);
  }
  
  public void setData(Context paramContext, List<ZSpaceImageItem> paramList, a parama, int paramInt1, int paramInt2)
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
      this.d.add(a(((ZSpaceImageItem)paramList.get(paramList.size() - 1)).sourcePath));
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        parama = (ZSpaceImageItem)paramContext.next();
        this.d.add(a(parama.sourcePath));
      }
      this.d.add(a(((ZSpaceImageItem)paramList.get(0)).sourcePath));
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
      return ZryuCycleViewPager.b(ZryuCycleViewPager.this).size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      ImageView localImageView = (ImageView)ZryuCycleViewPager.b(ZryuCycleViewPager.this).get(paramInt);
      if (ZryuCycleViewPager.k(ZryuCycleViewPager.this) != null) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            ZryuCycleViewPager.k(ZryuCycleViewPager.this).onImageClick(paramInt, paramAnonymousView);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ZryuCycleViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */