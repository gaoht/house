package com.ziroom.ziroomcustomer.reserve;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ReserveOrderListAdapter$ViewHolder_ViewBinding<T extends ReserveOrderListAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ReserveOrderListAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvBookOrderAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693180, "field 'tvBookOrderAddress'", TextView.class));
    paramT.tvBookOrderStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693181, "field 'tvBookOrderStatus'", TextView.class));
    paramT.sdvBookOrderImg = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131693182, "field 'sdvBookOrderImg'", SimpleDraweeView.class));
    paramT.tvBookOrderContractcode = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693183, "field 'tvBookOrderContractcode'", TextView.class));
    paramT.tvBookOrderLiveinTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693184, "field 'tvBookOrderLiveinTime'", TextView.class));
    paramT.tvBookOrderPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693185, "field 'tvBookOrderPrice'", TextView.class));
    paramT.tvBookOrderTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693186, "field 'tvBookOrderTips'", TextView.class));
    paramT.tvButton1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693187, "field 'tvButton1'", TextView.class));
    paramT.tvButton2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693188, "field 'tvButton2'", TextView.class));
    paramT.llBookOrderItem = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693179, "field 'llBookOrderItem'", LinearLayout.class));
  }
  
  public void unbind()
  {
    ReserveOrderListAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvBookOrderAddress = null;
    localViewHolder.tvBookOrderStatus = null;
    localViewHolder.sdvBookOrderImg = null;
    localViewHolder.tvBookOrderContractcode = null;
    localViewHolder.tvBookOrderLiveinTime = null;
    localViewHolder.tvBookOrderPrice = null;
    localViewHolder.tvBookOrderTips = null;
    localViewHolder.tvButton1 = null;
    localViewHolder.tvButton2 = null;
    localViewHolder.llBookOrderItem = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/ReserveOrderListAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */