package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScanCameraActivity
  extends BaseActivity
{
  private TextView a;
  private LinearLayout b;
  private ArrayList<String> c = new ArrayList();
  private ScanCameraActivity d;
  private int e;
  private ViewPager f;
  private List<ImageView> g = new ArrayList();
  private a r;
  private int s;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131691849));
    this.f = ((ViewPager)findViewById(2131690960));
    this.b = ((LinearLayout)findViewById(2131691261));
  }
  
  private void b()
  {
    this.s = b.getScreenWidth(this.d);
    this.c = ((ArrayList)getIntent().getSerializableExtra("photos"));
    if ((this.c == null) || (this.c.size() == 0)) {
      return;
    }
    this.e = getIntent().getIntExtra("position", 0);
    this.g = e();
    f();
    this.b.getChildAt(this.e).setEnabled(true);
    this.r = new a(null);
    this.f.setAdapter(this.r);
    this.f.setCurrentItem(this.e);
    this.f.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        ScanCameraActivity.b(ScanCameraActivity.this).getChildAt(ScanCameraActivity.a(ScanCameraActivity.this)).setEnabled(false);
        ScanCameraActivity.b(ScanCameraActivity.this).getChildAt(paramAnonymousInt).setEnabled(true);
        ScanCameraActivity.a(ScanCameraActivity.this, paramAnonymousInt);
      }
    });
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ScanCameraActivity.c(ScanCameraActivity.this).size() > 0)
        {
          ScanCameraActivity.c(ScanCameraActivity.this).remove(ScanCameraActivity.a(ScanCameraActivity.this));
          ScanCameraActivity.a(ScanCameraActivity.this, 0);
          if (ScanCameraActivity.c(ScanCameraActivity.this).size() > 0)
          {
            ScanCameraActivity.d(ScanCameraActivity.this);
            ScanCameraActivity.a(ScanCameraActivity.this, ScanCameraActivity.e(ScanCameraActivity.this));
            ScanCameraActivity.f(ScanCameraActivity.this).notifyDataSetChanged();
            ScanCameraActivity.b(ScanCameraActivity.this).getChildAt(ScanCameraActivity.a(ScanCameraActivity.this)).setEnabled(true);
            ScanCameraActivity.g(ScanCameraActivity.this).setCurrentItem(ScanCameraActivity.a(ScanCameraActivity.this));
          }
        }
        else
        {
          return;
        }
        g.textToast(ScanCameraActivity.h(ScanCameraActivity.this), "图片已经删除完");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("photos", ScanCameraActivity.c(ScanCameraActivity.this));
        ScanCameraActivity.this.setResult(-1, paramAnonymousView);
        ScanCameraActivity.this.finish();
      }
    });
  }
  
  private ImageView d(String paramString)
  {
    ZoomableDraweeView localZoomableDraweeView = new ZoomableDraweeView(this.d);
    localZoomableDraweeView.setLayoutParams(new ViewGroup.LayoutParams(this.s, this.s * 3 / 4));
    localZoomableDraweeView.setController(c.frescoController(paramString));
    return localZoomableDraweeView;
  }
  
  private List<ImageView> e()
  {
    this.g.clear();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.g.add(d(str));
    }
    return this.g;
  }
  
  private void f()
  {
    this.b.removeAllViews();
    int i = 0;
    while (i < this.c.size())
    {
      View localView = new View(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(this.d, 8.0F), n.dip2px(this.d, 8.0F));
      localLayoutParams.leftMargin = n.dip2px(this.d, 7.0F);
      localView.setEnabled(false);
      localView.setBackgroundResource(2130839307);
      this.b.addView(localView, localLayoutParams);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903465);
    this.d = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("photos", this.c);
      setResult(-1, paramKeyEvent);
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  private class a
    extends PagerAdapter
  {
    private a() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return ScanCameraActivity.c(ScanCameraActivity.this).size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ImageView localImageView = (ImageView)ScanCameraActivity.i(ScanCameraActivity.this).get(paramInt);
      paramViewGroup.addView(localImageView);
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("photos", ScanCameraActivity.c(ScanCameraActivity.this));
          ScanCameraActivity.this.setResult(-1, paramAnonymousView);
          ScanCameraActivity.this.finish();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/ScanCameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */