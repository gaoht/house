package com.ziroom.ziroomcustomer.sublet.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class LuxuryHouseShareView$LuxuryImageAdapter$ViewHolder_ViewBinding<T extends LuxuryHouseShareView.LuxuryImageAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LuxuryHouseShareView$LuxuryImageAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ivLuxuryShareImg = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695211, "field 'ivLuxuryShareImg'", SimpleDraweeView.class));
    paramT.tvLuxuryImgDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695213, "field 'tvLuxuryImgDesc'", TextView.class));
    paramT.v_luxury_share_img_top = Utils.findRequiredView(paramView, 2131695212, "field 'v_luxury_share_img_top'");
  }
  
  public void unbind()
  {
    LuxuryHouseShareView.LuxuryImageAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ivLuxuryShareImg = null;
    localViewHolder.tvLuxuryImgDesc = null;
    localViewHolder.v_luxury_share_img_top = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/widget/LuxuryHouseShareView$LuxuryImageAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */