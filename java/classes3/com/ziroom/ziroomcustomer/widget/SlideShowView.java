package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.AdAcitivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.i;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.home.bean.ImageInfo;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;

public class SlideShowView
  extends FrameLayout
{
  private List<SimpleDraweeView> a;
  private List<View> b;
  private List<ImageInfo> c;
  private ViewPager d;
  private int e = 0;
  private Context f;
  private boolean g = false;
  private Thread h;
  private LinearLayout i;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (!locall.getSuccess().booleanValue());
          SlideShowView.a(SlideShowView.this, (List)locall.getObject());
        } while ((SlideShowView.a(SlideShowView.this) == null) || (SlideShowView.a(SlideShowView.this).size() <= 0));
        ad.saveRollImage(SlideShowView.b(SlideShowView.this), SlideShowView.a(SlideShowView.this), b.d);
        SlideShowView.a(SlideShowView.this, SlideShowView.b(SlideShowView.this));
        return;
      } while (SlideShowView.c(SlideShowView.this) == null);
      SlideShowView.c(SlideShowView.this).setCurrentItem(SlideShowView.d(SlideShowView.this));
    }
  };
  
  public SlideShowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideShowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramContext;
    LayoutInflater.from(paramContext).inflate(2130905191, this, true);
    this.i = ((LinearLayout)findViewById(2131694016));
    this.d = ((ViewPager)findViewById(2131690960));
    this.d.setFocusable(true);
    b();
    a();
  }
  
  private void a()
  {
    this.h = new Thread(new Runnable()
    {
      public void run()
      {
        while (!SlideShowView.e(SlideShowView.this))
        {
          SystemClock.sleep(3000L);
          int i = SlideShowView.f(SlideShowView.this).size();
          if (i > 0) {
            SlideShowView.a(SlideShowView.this, (SlideShowView.d(SlideShowView.this) + 1) % i);
          }
          i.sendMessage(SlideShowView.g(SlideShowView.this), 131076, null);
        }
      }
    });
    this.h.start();
  }
  
  private void a(final Context paramContext)
  {
    this.i.removeAllViews();
    int k = 0;
    while (k < this.c.size())
    {
      Object localObject = new SimpleDraweeView(paramContext);
      ((SimpleDraweeView)localObject).setTag(((ImageInfo)this.c.get(k)).getbImageUrl());
      if (k == 0) {
        ((GenericDraweeHierarchy)((SimpleDraweeView)localObject).getHierarchy()).setPlaceholderImage(2130839296);
      }
      ((GenericDraweeHierarchy)((SimpleDraweeView)localObject).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      ((SimpleDraweeView)localObject).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(paramContext, AdAcitivity.class);
          paramAnonymousView.putExtra("url", this.b);
          paramContext.startActivity(paramAnonymousView);
        }
      });
      this.a.add(localObject);
      localObject = new View(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(paramContext, 8.0F), n.dip2px(paramContext, 8.0F));
      localLayoutParams.leftMargin = n.dip2px(paramContext, 7.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      ((View)localObject).setEnabled(false);
      ((View)localObject).setBackgroundResource(2130839307);
      this.i.addView((View)localObject);
      this.b.add(localObject);
      k += 1;
    }
    this.d.setAdapter(new b(null));
    this.d.setOnPageChangeListener(new a(null));
  }
  
  private void b()
  {
    this.a = new ArrayList();
    this.b = new ArrayList();
    if (!ah.isNetworkAvailable(this.f))
    {
      this.c = ad.getRollImage(this.f, b.d);
      if (this.c.size() > 0)
      {
        a(this.f);
        return;
      }
      this.d.setBackgroundResource(2130839296);
      return;
    }
    this.d.setBackgroundResource(2130839297);
    o.getServicePageImage(this.f, this.j);
  }
  
  private class a
    implements ViewPager.OnPageChangeListener
  {
    boolean a = false;
    
    private a() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      switch (paramInt)
      {
      }
      do
      {
        return;
        this.a = false;
        return;
        this.a = true;
        return;
        if ((SlideShowView.c(SlideShowView.this).getCurrentItem() == SlideShowView.c(SlideShowView.this).getAdapter().getCount() - 1) && (!this.a))
        {
          SlideShowView.c(SlideShowView.this).setCurrentItem(0);
          return;
        }
      } while ((SlideShowView.c(SlideShowView.this).getCurrentItem() != 0) || (this.a));
      SlideShowView.c(SlideShowView.this).setCurrentItem(SlideShowView.c(SlideShowView.this).getAdapter().getCount() - 1);
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      SlideShowView.a(SlideShowView.this, paramInt);
      u.e("ffsf: ", Integer.valueOf(paramInt));
      int i = 0;
      if (i < SlideShowView.h(SlideShowView.this).size())
      {
        if (i == paramInt) {
          ((View)SlideShowView.h(SlideShowView.this).get(paramInt)).setEnabled(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ((View)SlideShowView.h(SlideShowView.this).get(i)).setEnabled(false);
        }
      }
    }
  }
  
  private class b
    extends PagerAdapter
  {
    private b() {}
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)SlideShowView.f(SlideShowView.this).get(paramInt));
    }
    
    public void finishUpdate(View paramView) {}
    
    public int getCount()
    {
      return SlideShowView.f(SlideShowView.this).size();
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)SlideShowView.f(SlideShowView.this).get(paramInt);
      localSimpleDraweeView.setController(c.frescoController(localSimpleDraweeView.getTag() + ""));
      ((ViewPager)paramView).addView((View)SlideShowView.f(SlideShowView.this).get(paramInt));
      return SlideShowView.f(SlideShowView.this).get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
    
    public Parcelable saveState()
    {
      return null;
    }
    
    public void startUpdate(View paramView) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SlideShowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */