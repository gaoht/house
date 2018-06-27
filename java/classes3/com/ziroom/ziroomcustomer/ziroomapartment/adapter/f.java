package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuPhotoPreviewActivity;
import java.util.LinkedList;
import java.util.List;

public class f
  extends PagerAdapter
{
  private Context a;
  private List<String> b;
  private LinkedList<ImageView> c;
  
  public f(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = new LinkedList();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.c.size() >= paramInt + 1) {
      paramViewGroup.removeView((View)this.c.get(paramInt));
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public List<String> getData()
  {
    return this.b;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ZoomableDraweeView localZoomableDraweeView = new ZoomableDraweeView(this.a);
    ((GenericDraweeHierarchy)localZoomableDraweeView.getHierarchy()).setPlaceholderImage(2130837781, ScalingUtils.ScaleType.FIT_CENTER);
    localZoomableDraweeView.setTag(this.b.get(paramInt));
    localZoomableDraweeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localZoomableDraweeView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ((ZryuPhotoPreviewActivity)f.a(f.this)).setBackResult();
      }
    });
    localZoomableDraweeView.setController(c.frescoController((String)this.b.get(paramInt)));
    paramViewGroup.addView(localZoomableDraweeView);
    this.c.add(localZoomableDraweeView);
    return localZoomableDraweeView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setData(List<String> paramList)
  {
    this.c = null;
    this.b = paramList;
    this.c = new LinkedList();
    notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */