package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.view.View;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.b.b;
import com.ziroom.ziroomcustomer.util.x;

public class c
  implements b<String>
{
  private SimpleDraweeView a;
  
  public void UpdateUI(Context paramContext, int paramInt, String paramString)
  {
    paramContext = x.makeUrl(paramString);
    this.a.setController(com.freelxl.baselibrary.f.c.frescoController(paramContext));
  }
  
  public View createView(Context paramContext)
  {
    this.a = new SimpleDraweeView(paramContext);
    ((GenericDraweeHierarchy)this.a.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */