package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ZryuRentCardActivity$ViewHolder_ViewBinding<T extends ZryuRentCardActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuRentCardActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mTvTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689852, "field 'mTvTime'", TextView.class));
    paramT.mTvNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'mTvNum'", TextView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTvSubTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694578, "field 'mTvSubTitle'", TextView.class));
    paramT.mIv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691574, "field 'mIv'", ImageView.class));
    paramT.card_check = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131695387, "field 'card_check'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    ZryuRentCardActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.mTvName = null;
    localViewHolder.mTvTime = null;
    localViewHolder.mTvNum = null;
    localViewHolder.mTvTitle = null;
    localViewHolder.mTvSubTitle = null;
    localViewHolder.mIv = null;
    localViewHolder.card_check = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuRentCardActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */