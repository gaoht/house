package com.ziroom.ziroomcustomer.newrepair.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.BaseViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class TouchImageView
  extends Fragment
  implements ViewPager.OnPageChangeListener
{
  public int a;
  Context b;
  private List<ImageView> c = new ArrayList();
  private RelativeLayout d;
  private BaseViewPager e;
  private BaseViewPager f;
  private b g;
  private int h = 0;
  private boolean i = false;
  private boolean j = false;
  private a k;
  private int l;
  private int m = 0;
  private TextView n;
  private ScalingUtils.ScaleType o = ScalingUtils.ScaleType.FIT_XY;
  
  private ImageView a(String paramString)
  {
    ZoomableDraweeView localZoomableDraweeView = new ZoomableDraweeView(this.b);
    localZoomableDraweeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    ((GenericDraweeHierarchy)localZoomableDraweeView.getHierarchy()).setFailureImage(2130838349, ScalingUtils.ScaleType.FIT_CENTER);
    ((GenericDraweeHierarchy)localZoomableDraweeView.getHierarchy()).setPlaceholderImage(2130838349, ScalingUtils.ScaleType.FIT_CENTER);
    localZoomableDraweeView.setController(c.frescoController(paramString));
    return localZoomableDraweeView;
  }
  
  public BaseViewPager getViewPager()
  {
    return this.e;
  }
  
  public void hide()
  {
    this.d.setVisibility(8);
  }
  
  public boolean isCycle()
  {
    return this.j;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2130905199, null);
    this.e = ((BaseViewPager)paramLayoutInflater.findViewById(2131690960));
    this.d = ((RelativeLayout)paramLayoutInflater.findViewById(2131697707));
    this.n = ((TextView)paramLayoutInflater.findViewById(2131693062));
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
      this.i = true;
      return;
    }
    if (paramInt == 0)
    {
      if (this.f != null) {
        this.f.setScrollable(true);
      }
      this.e.setCurrentItem(this.h, false);
    }
    this.i = false;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i1 = this.c.size() - 1;
    this.h = paramInt;
    if (this.j)
    {
      if (paramInt == 0) {
        this.h = (i1 - 1);
      }
      for (;;)
      {
        paramInt = this.h;
        this.n.setText(paramInt - 1 + 1 + "/" + (this.l - 2));
        return;
        if (paramInt == i1) {
          this.h = 1;
        }
      }
    }
    this.n.setText(paramInt + 1 + "/" + this.l);
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
    if (this.g != null) {
      this.g.notifyDataSetChanged();
    }
  }
  
  public void releaseHeight()
  {
    getView().getLayoutParams().height = -1;
    refreshData();
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (!this.i)
    {
      this.h = paramInt;
      this.n.setText(paramInt + 1 + "/" + (this.l - 2));
      this.e.setCurrentItem(this.h, false);
    }
  }
  
  public void setCycle(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setData(Context paramContext, List<String> paramList, a parama)
  {
    setData(paramContext, paramList, parama, 0, 0);
  }
  
  public void setData(Context paramContext, List<String> paramList, a parama, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.m = paramInt2;
    this.k = parama;
    this.c.clear();
    paramContext = (WindowManager)paramContext.getSystemService("window");
    parama = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(parama);
    this.a = parama.widthPixels;
    if (this.j)
    {
      this.c.add(a((String)paramList.get(paramList.size() - 1)));
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        parama = (String)paramContext.next();
        this.c.add(a(parama));
      }
      this.c.add(a((String)paramList.get(0)));
      this.l = this.c.size();
      if (!this.j) {
        break label357;
      }
      this.n.setText("1/" + (this.l - 2));
    }
    for (;;)
    {
      this.g = new b(null);
      this.e.setOffscreenPageLimit(3);
      this.e.setOnPageChangeListener(this);
      this.e.setAdapter(this.g);
      if (paramInt1 >= 0)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < this.c.size()) {}
      }
      else
      {
        paramInt2 = 0;
      }
      paramInt1 = paramInt2;
      if (this.j) {
        paramInt1 = paramInt2 + 1;
      }
      this.e.setCurrentItem(paramInt1);
      return;
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        paramList = (String)paramContext.next();
        this.c.add(a(paramList));
      }
      break;
      label357:
      this.n.setText("1/" + this.l);
    }
  }
  
  public void setIsPageNumVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }
  
  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.o = paramScaleType;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void onImageClick(int paramInt, View paramView);
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
      return TouchImageView.a(TouchImageView.this).size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      ImageView localImageView = (ImageView)TouchImageView.a(TouchImageView.this).get(paramInt);
      if (TouchImageView.b(TouchImageView.this) != null) {
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            TouchImageView.b(TouchImageView.this).onImageClick(paramInt, paramAnonymousView);
          }
        });
      }
      paramViewGroup.addView(localImageView);
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (TouchImageView.b(TouchImageView.this) != null) {
            TouchImageView.b(TouchImageView.this).onImageClick(paramInt, paramAnonymousView);
          }
        }
      });
      return localImageView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/widget/TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */