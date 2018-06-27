package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.baidu.mapapi.model.LatLng;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.util.n;

public class StaticLocationMapView
  extends FrameLayout
{
  private SimpleDraweeView a;
  private ImageView b;
  
  public StaticLocationMapView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StaticLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new SimpleDraweeView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    Object localObject = (GenericDraweeHierarchy)this.a.getHierarchy();
    ((GenericDraweeHierarchy)localObject).setPlaceholderImage(2130837592);
    ((GenericDraweeHierarchy)localObject).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    this.b = new ImageView(getContext());
    localObject = new FrameLayout.LayoutParams(n.dip2px(getContext(), 24.0F), n.dip2px(getContext(), 24.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setImageResource(2130839008);
    addView(this.b);
  }
  
  private void a(LatLng paramLatLng, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > 0)
    {
      i = paramInt1;
      if (paramInt1 > 0) {}
    }
    else
    {
      i = getResources().getDisplayMetrics().widthPixels;
      paramInt2 = i / 2;
    }
    while ((paramInt2 > 1024) || (i > 1024))
    {
      paramInt2 /= 2;
      i /= 2;
    }
    paramLatLng = paramLatLng.longitude + "," + paramLatLng.latitude;
    this.a.setController(c.frescoController("http://api.map.baidu.com/staticimage?width=" + i + "&height=" + paramInt2 + "&center=" + paramLatLng + "&zoom=15"));
    paramLatLng = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramLatLng.setDuration(1500L);
    paramLatLng.setRepeatCount(-1);
    this.b.setAnimation(paramLatLng);
    paramLatLng.start();
  }
  
  public void initMapInfo(LatLng paramLatLng)
  {
    a(paramLatLng, n.px2dip(getContext(), getWidth()), n.px2dip(getContext(), getHeight()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/StaticLocationMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */