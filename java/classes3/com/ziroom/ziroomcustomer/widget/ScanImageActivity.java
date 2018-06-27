package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.d.a.a;
import com.ziroom.ziroomcustomer.e.e.d;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScanImageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  a a;
  int b = 0;
  private ViewPager c;
  private TextView d;
  private ImageView e;
  private ArrayList<String> f;
  private ArrayList<String> g;
  private int r;
  private Context s;
  private ArrayList<String> t = new ArrayList();
  private String u;
  
  private void a()
  {
    if ((this.g != null) && (this.g.size() > 0))
    {
      this.b = this.g.size();
      this.d.setText("(1/" + this.b + ")");
      this.a.setData(this.g);
      this.a.notifyDataSetChanged();
      this.c.setCurrentItem(this.r);
      return;
    }
    showToast("没有更多图片了");
  }
  
  private void b()
  {
    this.d = ((TextView)findViewById(2131696761));
    this.c = ((ExtendedViewPager)findViewById(2131690960));
    this.e = ((ImageView)findViewById(2131697452));
    this.a = new a(this.g);
    this.c.setAdapter(this.a);
    this.c.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        ScanImageActivity.a(ScanImageActivity.this).setText("(" + (paramAnonymousInt + 1) + "/" + ScanImageActivity.this.b + ")");
      }
    });
    this.e.setOnClickListener(this);
    findViewById(2131697451).setOnClickListener(this);
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("pics", this.t);
    setResult(3, localIntent);
  }
  
  protected String b(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.contains("?")) {
      localStringBuilder.append(paramString + "&");
    }
    while ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        localStringBuilder.append(str).append("=").append((String)paramMap.get(str)).append("&");
      }
      localStringBuilder.append(paramString + "?");
    }
    return localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString();
  }
  
  public void onBackPressed()
  {
    e();
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
    case 2131697452: 
      int i = this.a.a.size();
      if (i == 1)
      {
        this.t.add(this.a.a.get(this.c.getCurrentItem()));
        e();
        finish();
        return;
      }
      int j = this.c.getCurrentItem();
      this.t.add(this.a.a.get(this.c.getCurrentItem()));
      this.a.a.remove(j);
      this.b = (i - 1);
      this.d.setText("(1/" + this.b + ")");
      this.c.setAdapter(this.a);
      return;
    }
    e();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905108);
    this.s = this;
    this.g = new ArrayList();
    b();
    this.f = ((ArrayList)getIntent().getSerializableExtra("photos"));
    this.r = getIntent().getIntExtra("position", 0);
    this.u = getIntent().getStringExtra("tag");
    if (this.f != null)
    {
      this.g = this.f;
      a();
    }
    if (this.b == 0) {
      finish();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  class a
    extends PagerAdapter
  {
    List<String> a;
    
    public a()
    {
      List localList;
      this.a = localList;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public List<String> getList()
    {
      return this.a;
    }
    
    public View instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ZoomableDraweeView localZoomableDraweeView = new ZoomableDraweeView(paramViewGroup.getContext());
      ((GenericDraweeHierarchy)localZoomableDraweeView.getHierarchy()).setPlaceholderImage(a.a.b);
      if ((this.a != null) && (!TextUtils.isEmpty((CharSequence)this.a.get(paramInt))))
      {
        if ((!"SignerDataActivity".equals(ScanImageActivity.b(ScanImageActivity.this))) && (!"CertInformationActivity".equals(ScanImageActivity.b(ScanImageActivity.this)))) {
          break label212;
        }
        Object localObject = new HashMap();
        ((Map)localObject).put("token", a.getToken(ScanImageActivity.this.getApplicationContext()));
        ((Map)localObject).put("uuid", (String)this.a.get(paramInt) + "");
        localObject = g.getPassportSign((Map)localObject);
        localZoomableDraweeView.setController(c.frescoController(ScanImageActivity.this.b(q.O + e.d.d, (Map)localObject)));
      }
      for (;;)
      {
        u.e("scan", "到这里了么");
        paramViewGroup.addView(localZoomableDraweeView, -1, -1);
        return localZoomableDraweeView;
        label212:
        localZoomableDraweeView.setController(c.frescoController((String)this.a.get(paramInt)));
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void setData(List<String> paramList)
    {
      this.a = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ScanImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */