package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;

public class ImageCycleView
  extends LinearLayout
{
  private Context a;
  private ViewPager b = null;
  private b c;
  private TextView d;
  private ImageView e = null;
  private ImageView[] f = null;
  private int g = 0;
  private float h;
  private int i;
  private d j;
  
  public ImageCycleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageCycleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.h = paramContext.getResources().getDisplayMetrics().density;
    LayoutInflater.from(paramContext).inflate(2130903640, this);
    this.b = ((ExtendedViewPager)findViewById(2131693104));
    this.d = ((TextView)findViewById(2131693062));
    this.b.setOnPageChangeListener(new a(null));
  }
  
  public void setImageResources(ArrayList<String> paramArrayList, c paramc)
  {
    this.i = paramArrayList.size();
    this.d.setText("1/" + this.i);
    this.c = new b(this.a, paramArrayList, paramc);
    this.b.setAdapter(this.c);
  }
  
  public void setIndexChangeListener(d paramd)
  {
    this.j = paramd;
  }
  
  private final class a
    implements ViewPager.OnPageChangeListener
  {
    private a() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      ImageCycleView.b(ImageCycleView.this).setText(paramInt + 1 + "/" + ImageCycleView.a(ImageCycleView.this));
      if (ImageCycleView.c(ImageCycleView.this) != null) {
        ImageCycleView.c(ImageCycleView.this).changeIndex(paramInt);
      }
    }
  }
  
  private class b
    extends PagerAdapter
  {
    private ArrayList<String> b = new ArrayList();
    private ImageCycleView.c c;
    private Context d;
    
    public b(ArrayList<String> paramArrayList, ImageCycleView.c paramc)
    {
      this.d = paramArrayList;
      this.b = paramc;
      ImageCycleView.c localc;
      this.c = localc;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((SimpleDraweeView)paramObject);
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      String str = (String)this.b.get(paramInt);
      SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.d);
      localSimpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      c.frescoHierarchyController(localSimpleDraweeView, ScalingUtils.ScaleType.FIT_CENTER, 2130838349);
      localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ImageCycleView.b.a(ImageCycleView.b.this).onImageClick(paramInt, paramAnonymousView);
        }
      });
      paramViewGroup.addView(localSimpleDraweeView);
      this.c.displayImage(str, localSimpleDraweeView);
      return localSimpleDraweeView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
  
  public static abstract interface c
  {
    public abstract void displayImage(String paramString, SimpleDraweeView paramSimpleDraweeView);
    
    public abstract void onImageClick(int paramInt, View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void changeIndex(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ImageCycleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */