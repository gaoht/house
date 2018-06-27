package com.ziroom.ziroomcustomer.minsu.webchecklist.b;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import java.util.List;

public class a
  extends com.ziroom.ziroomcustomer.minsu.view.b.a<com.ziroom.ziroomcustomer.minsu.webchecklist.c.b>
{
  public a(Activity paramActivity, List paramList)
  {
    super(paramActivity, 2130904288, paramList);
  }
  
  protected void a(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, com.ziroom.ziroomcustomer.minsu.webchecklist.c.b paramb, int paramInt)
  {
    paramc = (SimpleDraweeView)paramc.getView(2131691098);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramc.getLayoutParams();
    localLayoutParams.height = ((com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this.b) - ab.dp2px(this.b, 36.0F)) * 9 / 16);
    com.freelxl.baselibrary.f.c.loadHolderImage(paramc, paramb.getImg());
    if (paramInt == 0) {
      localLayoutParams.setMargins(ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 24.0F), ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F));
    }
    for (;;)
    {
      paramc.setLayoutParams(localLayoutParams);
      return;
      if (getItemCount() == paramInt + 1) {
        localLayoutParams.setMargins(ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 24.0F));
      } else {
        localLayoutParams.setMargins(ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F), ab.dp2px(this.b, 9.0F));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */