package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.ziroomcustomer.util.ah;

public class ViewPagerIndicator2
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  private ViewPager a;
  private Context b;
  private ViewPagerIndicator c;
  private ImageView d;
  private int e;
  private a f;
  private float g = 0.0F;
  
  public ViewPagerIndicator2(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ViewPagerIndicator2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ViewPagerIndicator2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public ViewPagerIndicator2(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void addOnPageChangeListener(a parama)
  {
    this.f = parama;
  }
  
  public void draw(Context paramContext)
  {
    if ((this.a != null) && (this.a.getAdapter().getCount() != 0))
    {
      this.c = new ViewPagerIndicator(paramContext);
      this.c.setLength(this.e);
      this.c.setSelected(0, 2130837852, 2130837852);
      this.d = new ImageView(paramContext);
      this.d.setBackgroundResource(2130837853);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(20, 20);
      localLayoutParams.height = ah.dip2px(paramContext, 3.0F);
      localLayoutParams.width = ah.dip2px(paramContext, 9.0F);
      localLayoutParams.leftMargin = ah.dip2px(paramContext, 6.0F);
      localLayoutParams.topMargin = ah.dip2px(paramContext, 0.0F);
      this.d.setLayoutParams(localLayoutParams);
      addView(this.c);
      addView(this.d);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.f != null) {
      this.f.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = paramInt1;
    int j;
    if (this.e > 1)
    {
      j = (int)this.c.getDistance();
      i = paramInt1 % this.e;
      if ((this.c.getSelected() != 0) || (i != this.c.getSum() - 1)) {
        break label119;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.leftMargin = (Math.round(0.0F) + ah.dip2px(this.b, 6.0F));
      this.d.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.g = paramFloat;
      if (this.f != null) {
        this.f.onPageScrolled(i, paramFloat, paramInt2);
      }
      return;
      label119:
      if ((this.c.getSelected() != this.c.getSum() - 1) || (i != this.c.getSum() - 1)) {
        break;
      }
      float f1 = j * i;
      localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.leftMargin = (Math.round(f1) + ah.dip2px(this.b, 6.0F));
      this.d.setLayoutParams(localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    if ((1.0F > paramFloat) && (paramFloat > 0.72D))
    {
      localLayoutParams.leftMargin = (j * i + ah.dip2px(this.b, 6.0F) + ah.dip2px(this.b, (paramFloat - 0.28F) * 9.0F * 7.0F / 3.0F));
      localLayoutParams.width = ah.dip2px(this.b, (1.0F - paramFloat) * 6.0F * 3.5F + 9.0F);
    }
    for (;;)
    {
      this.d.setLayoutParams(localLayoutParams);
      break;
      if (paramFloat > 0.28D)
      {
        localLayoutParams.leftMargin = (j * i + ah.dip2px(this.b, 6.0F) + ah.dip2px(this.b, (paramFloat - 0.28F) * 9.0F * 7.0F / 3.0F));
      }
      else
      {
        localLayoutParams.width = ah.dip2px(this.b, paramFloat * 6.0F * 3.5F + 9.0F);
        localLayoutParams.leftMargin = (Math.round(j * i) + ah.dip2px(this.b, 6.0F));
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.c.setSelected(paramInt);
    if (this.f != null) {
      this.f.onPageSelected(paramInt);
    }
  }
  
  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    this.a = paramViewPager;
    this.e = paramInt;
    draw(this.b);
    this.a.addOnPageChangeListener(this);
  }
  
  public static abstract interface a
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ViewPagerIndicator2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */