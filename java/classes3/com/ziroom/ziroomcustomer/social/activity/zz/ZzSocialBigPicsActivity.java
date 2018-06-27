package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.BaseViewPager;

public class ZzSocialBigPicsActivity
  extends Activity
  implements ViewPager.OnPageChangeListener
{
  private ImageView[] a;
  private ZoomableDraweeView[] b;
  private String[] c;
  private int d = 0;
  @BindView(2131693062)
  LinearLayout viewGroup;
  @BindView(2131690960)
  BaseViewPager viewPager;
  
  private void a()
  {
    int j = 0;
    if ((this.c == null) || (this.c.length == 0)) {
      return;
    }
    this.a = new ImageView[this.c.length];
    this.viewGroup.removeAllViews();
    int i = 0;
    Object localObject;
    if (i < this.a.length)
    {
      localObject = new ImageView(this);
      ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(10, 10));
      this.a[i] = localObject;
      if (i != 0) {
        this.a[i].setBackgroundResource(2130837743);
      }
      for (;;)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localLayoutParams.leftMargin = ah.dip2px(this, 4.0F);
        localLayoutParams.rightMargin = ah.dip2px(this, 4.0F);
        this.viewGroup.addView((View)localObject, localLayoutParams);
        i += 1;
        break;
        this.a[i].setBackgroundResource(2130837742);
      }
    }
    if (this.a.length == 1) {
      this.viewGroup.setVisibility(8);
    }
    this.b = new ZoomableDraweeView[this.c.length];
    i = j;
    while (i < this.b.length)
    {
      localObject = new ZoomableDraweeView(this);
      ((ZoomableDraweeView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      ((ZoomableDraweeView)localObject).setTransitionName("sharedView");
      ((GenericDraweeHierarchy)((ZoomableDraweeView)localObject).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      this.b[i] = localObject;
      ((ZoomableDraweeView)localObject).setController(c.frescoController(this.c[i]));
      ((ZoomableDraweeView)localObject).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialBigPicsActivity.this.finish();
        }
      });
      i += 1;
    }
    this.viewPager.setAdapter(new a());
    this.viewPager.setOnPageChangeListener(this);
    this.viewPager.setCurrentItem(this.d);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (i < this.a.length)
    {
      if (i != paramInt) {
        this.a[i].setBackgroundResource(2130837743);
      }
      for (;;)
      {
        i += 1;
        break;
        this.a[i].setBackgroundResource(2130837742);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(12);
    setContentView(2130903624);
    ButterKnife.bind(this);
    this.c = getIntent().getStringArrayExtra("imageUrls");
    this.d = getIntent().getIntExtra("currentImageIndex", 0);
    a();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    a(paramInt % this.b.length);
  }
  
  @OnClick({2131690960})
  public void onViewClicked()
  {
    finish();
  }
  
  public class a
    extends PagerAdapter
  {
    public a() {}
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView(ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this)[(paramInt % ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this).length)]);
    }
    
    public int getCount()
    {
      return ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this).length;
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      ((ViewPager)paramView).addView(ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this)[(paramInt % ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this).length)], 0);
      return ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this)[(paramInt % ZzSocialBigPicsActivity.a(ZzSocialBigPicsActivity.this).length)];
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialBigPicsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */