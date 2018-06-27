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
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.d.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
@Instrumented
public class MinsuCycleViewPager
  extends Fragment
  implements ViewPager.OnPageChangeListener
{
  public int a;
  Context b;
  final Runnable c = new Runnable()
  {
    public void run()
    {
      if ((MinsuCycleViewPager.this.getActivity() != null) && (!MinsuCycleViewPager.this.getActivity().isFinishing()) && (MinsuCycleViewPager.i(MinsuCycleViewPager.this)))
      {
        if (System.currentTimeMillis() - MinsuCycleViewPager.j(MinsuCycleViewPager.this) > MinsuCycleViewPager.g(MinsuCycleViewPager.this) - 500) {
          MinsuCycleViewPager.f(MinsuCycleViewPager.this).sendEmptyMessage(MinsuCycleViewPager.a(MinsuCycleViewPager.this));
        }
      }
      else {
        return;
      }
      MinsuCycleViewPager.f(MinsuCycleViewPager.this).sendEmptyMessage(MinsuCycleViewPager.h(MinsuCycleViewPager.this));
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
  private List<String> t;
  private int u;
  private int v = 0;
  private TextView w;
  private ScalingUtils.ScaleType x = ScalingUtils.ScaleType.FIT_XY;
  
  private ImageView a(String paramString)
  {
    if (this.v == 0)
    {
      localObject = new SimpleDraweeView(this.b);
      c.frescoHierarchyController((SimpleDraweeView)localObject, ScalingUtils.ScaleType.FIT_CENTER, 2130838349);
      ((SimpleDraweeView)localObject).setController(c.frescoController(paramString));
      return (ImageView)localObject;
    }
    Object localObject = new ZoomableDraweeView(this.b);
    ((ZoomableDraweeView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    ((GenericDraweeHierarchy)((ZoomableDraweeView)localObject).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    ((GenericDraweeHierarchy)((ZoomableDraweeView)localObject).getHierarchy()).setPlaceholderImage(a.a.b);
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
    this.w = ((TextView)paramLayoutInflater.findViewById(2131693062));
    this.i = new b(getActivity())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if ((paramAnonymousMessage.what == MinsuCycleViewPager.a(MinsuCycleViewPager.this)) && (MinsuCycleViewPager.b(MinsuCycleViewPager.this).size() != 0))
        {
          if (!MinsuCycleViewPager.c(MinsuCycleViewPager.this))
          {
            i = MinsuCycleViewPager.b(MinsuCycleViewPager.this).size();
            j = (MinsuCycleViewPager.d(MinsuCycleViewPager.this) + 1) % MinsuCycleViewPager.b(MinsuCycleViewPager.this).size();
            MinsuCycleViewPager.e(MinsuCycleViewPager.this).setCurrentItem(j, true);
            if (j == i + 1) {
              MinsuCycleViewPager.e(MinsuCycleViewPager.this).setCurrentItem(1, false);
            }
          }
          MinsuCycleViewPager.a(MinsuCycleViewPager.this, System.currentTimeMillis());
          MinsuCycleViewPager.f(MinsuCycleViewPager.this).removeCallbacks(MinsuCycleViewPager.this.c);
          MinsuCycleViewPager.f(MinsuCycleViewPager.this).postDelayed(MinsuCycleViewPager.this.c, MinsuCycleViewPager.g(MinsuCycleViewPager.this));
        }
        while ((paramAnonymousMessage.what != MinsuCycleViewPager.h(MinsuCycleViewPager.this)) || (MinsuCycleViewPager.b(MinsuCycleViewPager.this).size() == 0))
        {
          int i;
          int j;
          return;
        }
        MinsuCycleViewPager.f(MinsuCycleViewPager.this).removeCallbacks(MinsuCycleViewPager.this.c);
        MinsuCycleViewPager.f(MinsuCycleViewPager.this).postDelayed(MinsuCycleViewPager.this.c, MinsuCycleViewPager.g(MinsuCycleViewPager.this));
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
    }
    this.l = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.d.size();
    this.k = paramInt;
    if (this.m) {}
    this.w.setText(paramInt % this.t.size() + 1 + "/" + (this.u - 2));
    if (this.s != null) {
      this.s.onPosChange(this.k);
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
      this.w.setText(paramInt + 1 + "/" + (this.u - 2));
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
    this.v = paramInt2;
    this.t = paramList;
    this.r = parama;
    this.d.clear();
    paramContext = (WindowManager)paramContext.getSystemService("window");
    parama = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(parama);
    this.a = parama.widthPixels;
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      parama = (String)paramContext.next();
      this.d.add(a(parama));
    }
    this.u = (this.d.size() + 2);
    this.w.setText("1/" + (this.u - 2));
    this.h = new c(null);
    this.f.setOffscreenPageLimit(3);
    if (paramInt2 == 0) {
      this.f.setOffscreenPageLimit(1);
    }
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
    if (this.m)
    {
      this.f.setCurrentItem(paramList.size() * 100 + paramInt2);
      return;
    }
    this.f.setCurrentItem(paramInt2);
  }
  
  public void setIsPageNumVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w.setVisibility(0);
      return;
    }
    this.w.setVisibility(8);
  }
  
  public void setPosChangeListener(b paramb)
  {
    this.s = paramb;
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.x = paramScaleType;
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
      if (!MinsuCycleViewPager.k(MinsuCycleViewPager.this)) {
        paramViewGroup.removeView((View)paramObject);
      }
    }
    
    public int getCount()
    {
      if (MinsuCycleViewPager.k(MinsuCycleViewPager.this)) {
        return Integer.MAX_VALUE;
      }
      return MinsuCycleViewPager.b(MinsuCycleViewPager.this).size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      int j = MinsuCycleViewPager.l(MinsuCycleViewPager.this).size();
      int i = paramInt;
      while (i < 0) {
        i += j * 100;
      }
      ImageView localImageView = (ImageView)MinsuCycleViewPager.b(MinsuCycleViewPager.this).get(i % j);
      if (MinsuCycleViewPager.m(MinsuCycleViewPager.this) != null) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MinsuCycleViewPager.m(MinsuCycleViewPager.this).onImageClick(paramInt, paramAnonymousView);
          }
        });
      }
      ViewParent localViewParent = localImageView.getParent();
      if (localViewParent != null) {
        ((ViewGroup)localViewParent).removeView(localImageView);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/MinsuCycleViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */