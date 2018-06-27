package com.ziroom.commonlibrary.widget.convenientbanner;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.styleable;
import com.ziroom.commonlibrary.widget.convenientbanner.view.CBLoopViewPager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConvenientOptiBanner<T>
  extends LinearLayout
{
  private List<T> a;
  private int[] b;
  private ArrayList<ImageView> c = new ArrayList();
  private com.ziroom.commonlibrary.widget.convenientbanner.c.a d;
  private ViewPager.OnPageChangeListener e;
  private com.ziroom.commonlibrary.widget.convenientbanner.a.a f;
  private CBLoopViewPager g;
  private a h;
  private LinearLayout i;
  private View j;
  private long k;
  private boolean l;
  private boolean m = false;
  private boolean n = true;
  private boolean o = true;
  private a p;
  
  public ConvenientOptiBanner(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ConvenientOptiBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConvenientBanner);
    this.o = paramAttributeSet.getBoolean(R.styleable.ConvenientBanner_canLoop, true);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  @TargetApi(11)
  public ConvenientOptiBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConvenientBanner);
    this.o = paramAttributeSet.getBoolean(R.styleable.ConvenientBanner_canLoop, true);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  @TargetApi(21)
  public ConvenientOptiBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConvenientBanner);
    this.o = paramAttributeSet.getBoolean(R.styleable.ConvenientBanner_canLoop, true);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  private void a()
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      this.h = new a(this.g.getContext());
      localField.set(this.g, this.h);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.include_viewpager_opti, this, true);
    this.g = ((CBLoopViewPager)paramContext.findViewById(R.id.cbLoopViewPager));
    this.i = ((LinearLayout)paramContext.findViewById(R.id.loPageTurningPoint));
    this.j = paramContext.findViewById(R.id.cover_at_bottom);
    a();
    this.p = new a(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 1) || (i1 == 3) || (i1 == 4)) {
      if (this.m) {
        startTurning(this.k);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (this.m)) {
        stopTurning();
      }
    }
  }
  
  public int getCurrentItem()
  {
    if (this.g != null) {
      return this.g.getRealItem();
    }
    return -1;
  }
  
  public ViewPager.OnPageChangeListener getOnPageChangeListener()
  {
    return this.e;
  }
  
  public int getScrollDuration()
  {
    return this.h.getScrollDuration();
  }
  
  public CBLoopViewPager getViewPager()
  {
    return this.g;
  }
  
  public boolean isCanLoop()
  {
    return this.g.isCanLoop();
  }
  
  public boolean isManualPageable()
  {
    return this.g.isCanScroll();
  }
  
  public boolean isTurning()
  {
    return this.l;
  }
  
  public void notifyDataSetChanged()
  {
    this.g.getAdapter().notifyDataSetChanged();
    if (this.b != null) {
      setPageIndicator(this.b);
    }
  }
  
  public void setCanLoop(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.g.setCanLoop(paramBoolean);
  }
  
  public ConvenientOptiBanner setCoverBottomViewResource(int paramInt)
  {
    this.j.setBackgroundResource(paramInt);
    return this;
  }
  
  public ConvenientOptiBanner setCoverBottomViewVisible(boolean paramBoolean)
  {
    View localView = this.j;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return this;
    }
  }
  
  public void setManualPageable(boolean paramBoolean)
  {
    this.g.setCanScroll(paramBoolean);
  }
  
  public ConvenientOptiBanner setOnItemClickListener(com.ziroom.commonlibrary.widget.convenientbanner.c.b paramb)
  {
    if (paramb == null)
    {
      this.g.setOnItemClickListener(null);
      return this;
    }
    this.g.setOnItemClickListener(paramb);
    return this;
  }
  
  public ConvenientOptiBanner setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.e = paramOnPageChangeListener;
    if (this.d != null)
    {
      this.d.setOnPageChangeListener(paramOnPageChangeListener);
      return this;
    }
    this.g.setOnPageChangeListener(paramOnPageChangeListener);
    return this;
  }
  
  public ConvenientOptiBanner setPageIndicator(int[] paramArrayOfInt)
  {
    this.i.removeAllViews();
    this.c.clear();
    this.b = paramArrayOfInt;
    if (this.a == null) {}
    do
    {
      return this;
      int i1 = 0;
      if (i1 < this.a.size())
      {
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.freelxl.baselibrary.f.b.dip2px(getContext(), 9.0F), com.freelxl.baselibrary.f.b.dip2px(getContext(), 3.0F));
        localLayoutParams.leftMargin = com.freelxl.baselibrary.f.b.dip2px(getContext(), 3.0F);
        localLayoutParams.rightMargin = com.freelxl.baselibrary.f.b.dip2px(getContext(), 3.0F);
        this.c.add(localImageView);
        if (this.c.isEmpty()) {
          localImageView.setBackgroundResource(paramArrayOfInt[1]);
        }
        for (;;)
        {
          this.i.addView(localImageView, localLayoutParams);
          i1 += 1;
          break;
          localImageView.setBackgroundResource(paramArrayOfInt[0]);
        }
      }
      this.d = new com.ziroom.commonlibrary.widget.convenientbanner.c.a(this.c, paramArrayOfInt);
      this.g.setOnPageChangeListener(this.d);
      this.d.onPageSelected(this.g.getRealItem());
    } while (this.e == null);
    this.d.setOnPageChangeListener(this.e);
    return this;
  }
  
  public ConvenientOptiBanner setPageTransformer(ViewPager.PageTransformer paramPageTransformer)
  {
    this.g.setPageTransformer(true, paramPageTransformer);
    return this;
  }
  
  public ConvenientOptiBanner setPages(com.ziroom.commonlibrary.widget.convenientbanner.b.a parama, List<T> paramList)
  {
    return setPages(parama, paramList, null);
  }
  
  public ConvenientOptiBanner setPages(com.ziroom.commonlibrary.widget.convenientbanner.b.a parama, List<T> paramList, b paramb)
  {
    this.a = paramList;
    this.f = new com.ziroom.commonlibrary.widget.convenientbanner.a.a(parama, this.a);
    this.g.setAdapter(this.f, this.o);
    if (paramb != null) {
      paramb.configGio(this.g);
    }
    if (this.b != null) {
      setPageIndicator(this.b);
    }
    return this;
  }
  
  public ConvenientOptiBanner setPointViewVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.i;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      return this;
    }
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.h.setScrollDuration(paramInt);
  }
  
  public void setcurrentitem(int paramInt)
  {
    if (this.g != null) {
      this.g.setCurrentItem(paramInt);
    }
  }
  
  public ConvenientOptiBanner startTurning(long paramLong)
  {
    if (this.l) {
      stopTurning();
    }
    this.m = true;
    this.k = paramLong;
    this.l = true;
    postDelayed(this.p, paramLong);
    return this;
  }
  
  public void stopTurning()
  {
    this.l = false;
    removeCallbacks(this.p);
  }
  
  static class a
    implements Runnable
  {
    private final WeakReference<ConvenientOptiBanner> a;
    
    a(ConvenientOptiBanner paramConvenientOptiBanner)
    {
      this.a = new WeakReference(paramConvenientOptiBanner);
    }
    
    public void run()
    {
      ConvenientOptiBanner localConvenientOptiBanner = (ConvenientOptiBanner)this.a.get();
      if ((localConvenientOptiBanner != null) && (ConvenientOptiBanner.a(localConvenientOptiBanner) != null) && (ConvenientOptiBanner.b(localConvenientOptiBanner)))
      {
        int i = ConvenientOptiBanner.a(localConvenientOptiBanner).getCurrentItem();
        ConvenientOptiBanner.a(localConvenientOptiBanner).setCurrentItem(i + 1);
        localConvenientOptiBanner.postDelayed(ConvenientOptiBanner.c(localConvenientOptiBanner), ConvenientOptiBanner.d(localConvenientOptiBanner));
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void configGio(ViewPager paramViewPager);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/ConvenientOptiBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */