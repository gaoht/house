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
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.styleable;
import com.ziroom.commonlibrary.widget.convenientbanner.c.b;
import com.ziroom.commonlibrary.widget.convenientbanner.view.CBLoopViewPager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConvenientBanner<T>
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
  
  public ConvenientBanner(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ConvenientBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConvenientBanner);
    this.o = paramAttributeSet.getBoolean(R.styleable.ConvenientBanner_canLoop, true);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  @TargetApi(11)
  public ConvenientBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConvenientBanner);
    this.o = paramAttributeSet.getBoolean(R.styleable.ConvenientBanner_canLoop, true);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  @TargetApi(21)
  public ConvenientBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.include_viewpager, this, true);
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
  
  public ConvenientBanner setCoverBottomViewResource(int paramInt)
  {
    this.j.setBackgroundResource(paramInt);
    return this;
  }
  
  public ConvenientBanner setCoverBottomViewVisible(boolean paramBoolean)
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
  
  public ConvenientBanner setOnItemClickListener(b paramb)
  {
    if (paramb == null)
    {
      this.g.setOnItemClickListener(null);
      return this;
    }
    this.g.setOnItemClickListener(paramb);
    return this;
  }
  
  public ConvenientBanner setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
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
  
  public ConvenientBanner setPageIndicator(int[] paramArrayOfInt)
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
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(16, 16);
        localLayoutParams.leftMargin = 10;
        localLayoutParams.rightMargin = 10;
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
  
  public ConvenientBanner setPageIndicatorAlign(c paramc)
  {
    int i2 = -1;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    if (paramc == c.a)
    {
      i1 = -1;
      localLayoutParams.addRule(9, i1);
      if (paramc != c.b) {
        break label81;
      }
      i1 = -1;
      label40:
      localLayoutParams.addRule(11, i1);
      if (paramc != c.c) {
        break label86;
      }
    }
    label81:
    label86:
    for (int i1 = i2;; i1 = 0)
    {
      localLayoutParams.addRule(14, i1);
      this.i.setLayoutParams(localLayoutParams);
      return this;
      i1 = 0;
      break;
      i1 = 0;
      break label40;
    }
  }
  
  public ConvenientBanner setPageTransformer(ViewPager.PageTransformer paramPageTransformer)
  {
    this.g.setPageTransformer(true, paramPageTransformer);
    return this;
  }
  
  public ConvenientBanner setPages(com.ziroom.commonlibrary.widget.convenientbanner.b.a parama, List<T> paramList)
  {
    return setPages(parama, paramList, null);
  }
  
  public ConvenientBanner setPages(com.ziroom.commonlibrary.widget.convenientbanner.b.a parama, List<T> paramList, b paramb)
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
  
  public ConvenientBanner setPointViewVisible(boolean paramBoolean)
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
  
  public ConvenientBanner startTurning(long paramLong)
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
    private final WeakReference<ConvenientBanner> a;
    
    a(ConvenientBanner paramConvenientBanner)
    {
      this.a = new WeakReference(paramConvenientBanner);
    }
    
    public void run()
    {
      ConvenientBanner localConvenientBanner = (ConvenientBanner)this.a.get();
      if ((localConvenientBanner != null) && (ConvenientBanner.a(localConvenientBanner) != null) && (ConvenientBanner.b(localConvenientBanner)))
      {
        int i = ConvenientBanner.a(localConvenientBanner).getCurrentItem();
        ConvenientBanner.a(localConvenientBanner).setCurrentItem(i + 1);
        localConvenientBanner.postDelayed(ConvenientBanner.c(localConvenientBanner), ConvenientBanner.d(localConvenientBanner));
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void configGio(ViewPager paramViewPager);
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/ConvenientBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */