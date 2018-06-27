package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ZryuBillDetailActivity$ViewHolder_ViewBinding<T extends ZryuBillDetailActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillDetailActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvPriceTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690454, "field 'tvPriceTitle'", TextView.class));
    paramT.tvPriceAmount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695765, "field 'tvPriceAmount'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuBillDetailActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvPriceTitle = null;
    localViewHolder.tvPriceAmount = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillDetailActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */