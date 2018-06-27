package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.ExtendedViewPager;
import com.ziroom.ziroomcustomer.widget.TouchImageView;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.utils.f;
import java.util.ArrayList;
import java.util.List;

public class ImageZoomActivity
  extends Activity
{
  private ViewPager a;
  private a b;
  private int c;
  private List<ImageItem> d = new ArrayList();
  private ViewPager.OnPageChangeListener e = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt) {}
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
    
    public void onPageSelected(int paramAnonymousInt)
    {
      ImageZoomActivity.b(ImageZoomActivity.this, paramAnonymousInt);
    }
  };
  
  private void a()
  {
    this.c = getIntent().getIntExtra("current_img_position", 0);
    this.d = StationEvaluateActivity.b;
  }
  
  private void a(int paramInt)
  {
    if (paramInt + 1 <= this.d.size()) {
      this.d.remove(paramInt);
    }
  }
  
  private void b()
  {
    this.d.clear();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903218);
    a();
    ((ImageView)findViewById(2131690958)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ImageZoomActivity.this.finish();
      }
    });
    ((ImageView)findViewById(2131690959)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ImageZoomActivity.a(ImageZoomActivity.this).size() == 1)
        {
          ImageZoomActivity.b(ImageZoomActivity.this);
          ImageZoomActivity.this.finish();
          return;
        }
        ImageZoomActivity.a(ImageZoomActivity.this, ImageZoomActivity.c(ImageZoomActivity.this));
        ImageZoomActivity.d(ImageZoomActivity.this).removeAllViews();
        ImageZoomActivity.e(ImageZoomActivity.this).removeView(ImageZoomActivity.c(ImageZoomActivity.this));
        ImageZoomActivity.e(ImageZoomActivity.this).notifyDataSetChanged();
      }
    });
    this.a = ((ExtendedViewPager)findViewById(2131690960));
    this.a.setOnPageChangeListener(this.e);
    this.b = new a(this.d);
    this.a.setAdapter(this.b);
    this.a.setCurrentItem(this.c);
  }
  
  class a
    extends PagerAdapter
  {
    private List<ImageItem> b = new ArrayList();
    private ArrayList<TouchImageView> c = new ArrayList();
    
    public a()
    {
      List localList;
      this.b = localList;
      int j = localList.size();
      int i = 0;
      while (i != j)
      {
        TouchImageView localTouchImageView = new TouchImageView(ImageZoomActivity.this);
        f.getInstance(ImageZoomActivity.this).displayBmp(localTouchImageView, null, ((ImageItem)localList.get(i)).sourcePath, false);
        localTouchImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c.add(localTouchImageView);
        i += 1;
      }
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      if (this.c.size() >= paramInt + 1) {
        ((ViewPager)paramView).removeView((View)this.c.get(paramInt));
      }
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      ImageView localImageView = (ImageView)this.c.get(paramInt);
      ((ViewPager)paramView).addView(localImageView);
      return localImageView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void removeView(int paramInt)
    {
      if (paramInt + 1 <= this.c.size()) {
        this.c.remove(paramInt);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ImageZoomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */