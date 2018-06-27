package com.ziroom.commonlibrary.widget.convenientbanner.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ziroom.commonlibrary.widget.convenientbanner.a.a;
import com.ziroom.commonlibrary.widget.convenientbanner.c.b;

public class CBLoopViewPager
  extends ViewPager
{
  ViewPager.OnPageChangeListener a;
  private b b;
  private a c;
  private boolean d = true;
  private boolean e = true;
  private float f = 0.0F;
  private float g = 0.0F;
  private ViewPager.OnPageChangeListener h = new ViewPager.OnPageChangeListener()
  {
    private float b = -1.0F;
    
    public void onPageScrollStateChanged(int paramAnonymousInt)
    {
      if (CBLoopViewPager.this.a != null) {
        CBLoopViewPager.this.a.onPageScrollStateChanged(paramAnonymousInt);
      }
    }
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
    {
      if (CBLoopViewPager.this.a != null)
      {
        if (paramAnonymousInt1 != CBLoopViewPager.a(CBLoopViewPager.this).getRealCount() - 1) {
          CBLoopViewPager.this.a.onPageScrolled(paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        }
      }
      else {
        return;
      }
      if (paramAnonymousFloat > 0.5D)
      {
        CBLoopViewPager.this.a.onPageScrolled(0, 0.0F, 0);
        return;
      }
      CBLoopViewPager.this.a.onPageScrolled(paramAnonymousInt1, 0.0F, 0);
    }
    
    public void onPageSelected(int paramAnonymousInt)
    {
      paramAnonymousInt = CBLoopViewPager.a(CBLoopViewPager.this).toRealPosition(paramAnonymousInt);
      if (this.b != paramAnonymousInt)
      {
        this.b = paramAnonymousInt;
        if (CBLoopViewPager.this.a != null) {
          CBLoopViewPager.this.a.onPageSelected(paramAnonymousInt);
        }
      }
    }
  };
  
  public CBLoopViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CBLoopViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    super.setOnPageChangeListener(this.h);
  }
  
  public a getAdapter()
  {
    return this.c;
  }
  
  public int getFristItem()
  {
    if (this.e) {
      return this.c.getRealCount();
    }
    return 0;
  }
  
  public int getLastItem()
  {
    return this.c.getRealCount() - 1;
  }
  
  public int getRealItem()
  {
    if (this.c != null) {
      return this.c.toRealPosition(super.getCurrentItem());
    }
    return 0;
  }
  
  public boolean isCanLoop()
  {
    return this.e;
  }
  
  public boolean isCanScroll()
  {
    return this.d;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d)
    {
      if (this.b != null) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.f = paramMotionEvent.getX();
        continue;
        this.g = paramMotionEvent.getX();
        if (Math.abs(this.f - this.g) < 5.0F) {
          this.b.onItemClick(getRealItem());
        }
        this.f = 0.0F;
        this.g = 0.0F;
      }
    }
    return false;
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    this.c = ((a)paramPagerAdapter);
    this.c.setCanLoop(paramBoolean);
    this.c.setViewPager(this);
    super.setAdapter(this.c);
    setCurrentItem(getFristItem(), false);
  }
  
  public void setCanLoop(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean) {
      setCurrentItem(getRealItem(), false);
    }
    if (this.c == null) {
      return;
    }
    this.c.setCanLoop(paramBoolean);
    this.c.notifyDataSetChanged();
  }
  
  public void setCanScroll(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.a = paramOnPageChangeListener;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/view/CBLoopViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */