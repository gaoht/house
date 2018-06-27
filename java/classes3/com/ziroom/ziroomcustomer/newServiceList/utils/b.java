package com.ziroom.ziroomcustomer.newServiceList.utils;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;

public class b
{
  public static void setAllPartParams(Context paramContext, SimpleDraweeView paramSimpleDraweeView1, SimpleDraweeView paramSimpleDraweeView2, SimpleDraweeView paramSimpleDraweeView3, SimpleDraweeView paramSimpleDraweeView4, SimpleDraweeView paramSimpleDraweeView5)
  {
    int i = ac.getScreenWidth(paramContext);
    ViewGroup.LayoutParams localLayoutParams = paramSimpleDraweeView1.getLayoutParams();
    localLayoutParams.height = ((int)(i * 280 / 375));
    paramSimpleDraweeView1.setLayoutParams(localLayoutParams);
    paramSimpleDraweeView1 = paramSimpleDraweeView2.getLayoutParams();
    paramSimpleDraweeView1.height = ((int)((i - n.dip2px(paramContext, 48.0F)) / 3 * 132 / 109));
    paramSimpleDraweeView2.setLayoutParams(paramSimpleDraweeView1);
    paramSimpleDraweeView1 = paramSimpleDraweeView3.getLayoutParams();
    paramSimpleDraweeView1.height = ((int)((i - n.dip2px(paramContext, 48.0F)) / 3 * 132 / 109));
    paramSimpleDraweeView3.setLayoutParams(paramSimpleDraweeView1);
    paramSimpleDraweeView1 = paramSimpleDraweeView4.getLayoutParams();
    paramSimpleDraweeView1.height = ((int)((i - n.dip2px(paramContext, 48.0F)) / 3 * 132 / 109));
    paramSimpleDraweeView4.setLayoutParams(paramSimpleDraweeView1);
    paramSimpleDraweeView1 = paramSimpleDraweeView5.getLayoutParams();
    paramSimpleDraweeView1.height = ((int)((i - n.dip2px(paramContext, 36.0F)) * 113 / 339));
    paramSimpleDraweeView5.setLayoutParams(paramSimpleDraweeView1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */