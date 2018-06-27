package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OwnerPhotoPreviewActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final String b = OwnerPhotoPreviewActivity.class.getSimpleName();
  private ViewPager a;
  private List<String> c = new ArrayList();
  private int d = 0;
  private a e;
  private LinearLayout f;
  
  private void a()
  {
    this.c = getIntent().getStringArrayListExtra("urlList");
    this.d = getIntent().getIntExtra("position", 0);
    this.f = ((LinearLayout)findViewById(2131692108));
    this.a = ((ViewPager)findViewById(2131691037));
    this.e = new a(this, this.c);
    this.a.setAdapter(this.e);
    b(this.c.size());
    this.a.setCurrentItem(this.d);
    this.a.setOnPageChangeListener(this);
  }
  
  private void b(int paramInt)
  {
    this.f.removeAllViews();
    int i = 0;
    if (i < paramInt)
    {
      ImageView localImageView = new ImageView(this);
      int j = n.dip2px(this, 8.0F);
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(j, j));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
      localLayoutParams.leftMargin = (j / 2);
      localLayoutParams.rightMargin = (j / 2);
      if (i == this.d) {
        localImageView.setImageResource(2130838388);
      }
      for (;;)
      {
        this.f.addView(localImageView);
        i += 1;
        break;
        localImageView.setImageResource(2130838389);
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt < this.f.getChildCount())
    {
      int i = 0;
      if (i < this.f.getChildCount())
      {
        if (i == paramInt) {
          ((ImageView)this.f.getChildAt(i)).setImageResource(2130838388);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ImageView)this.f.getChildAt(i)).setImageResource(2130838389);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    setBackResult();
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView.getId();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903433);
    a();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    c(paramInt);
  }
  
  public void setBackResult()
  {
    Object localObject = this.a.getBackground();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.a = null;
    this.e = null;
    finish();
  }
  
  class a
    extends PagerAdapter
  {
    private Context b;
    private List<String> c;
    private LinkedList<ImageView> d;
    
    public a(List<String> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
      this.d = new LinkedList();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (this.d.size() >= paramInt + 1) {
        paramViewGroup.removeView((View)this.d.get(paramInt));
      }
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public List<String> getData()
    {
      return this.c;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ZoomableDraweeView localZoomableDraweeView = new ZoomableDraweeView(this.b);
      ((GenericDraweeHierarchy)localZoomableDraweeView.getHierarchy()).setPlaceholderImage(2130837781, ScalingUtils.ScaleType.FIT_CENTER);
      localZoomableDraweeView.setTag(this.c.get(paramInt));
      localZoomableDraweeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localZoomableDraweeView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((OwnerPhotoPreviewActivity)OwnerPhotoPreviewActivity.a.a(OwnerPhotoPreviewActivity.a.this)).setBackResult();
        }
      });
      localZoomableDraweeView.setController(c.frescoController((String)this.c.get(paramInt)));
      paramViewGroup.addView(localZoomableDraweeView);
      this.d.add(localZoomableDraweeView);
      return localZoomableDraweeView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void setData(List<String> paramList)
    {
      this.d = null;
      this.c = paramList;
      this.d = new LinkedList();
      notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerPhotoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */