package com.ziroom.ziroomcustomer.my;

import android.content.Context;
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
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OwnerInvoiceExampleActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private String a = OwnerInvoiceExampleActivity.class.getSimpleName();
  private ViewPager b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private List<String> f = new ArrayList();
  private List<String> g = new ArrayList();
  private int r = 0;
  private a s;
  
  private void a()
  {
    this.e = ((ImageView)findViewById(2131691035));
    this.e.setOnClickListener(this);
    this.d = ((TextView)findViewById(2131691038));
    this.c = ((TextView)findViewById(2131691036));
    this.f.add("res://" + getPackageName() + "/" + 2130840049);
    this.g.add("电子发票示例");
    this.r = 0;
    this.b = ((ViewPager)findViewById(2131691037));
    this.s = new a(this, this.f);
    this.b.setAdapter(this.s);
    this.b.setCurrentItem(this.r);
    this.b.setOnPageChangeListener(this);
    b();
  }
  
  private void b()
  {
    this.c.setText(this.r + 1 + "/" + this.f.size());
    this.d.setText((CharSequence)this.g.get(this.r));
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
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903234);
    a();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.r = paramInt;
    b();
  }
  
  public void setBackResult()
  {
    Object localObject = this.b.getBackground();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.b = null;
    this.s = null;
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
          ((OwnerInvoiceExampleActivity)OwnerInvoiceExampleActivity.a.a(OwnerInvoiceExampleActivity.a.this)).setBackResult();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceExampleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */