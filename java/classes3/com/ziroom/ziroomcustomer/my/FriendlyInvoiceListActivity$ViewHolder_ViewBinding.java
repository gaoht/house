package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class FriendlyInvoiceListActivity$ViewHolder_ViewBinding<T extends FriendlyInvoiceListActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public FriendlyInvoiceListActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.friendlyInvoiceName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695024, "field 'friendlyInvoiceName'", TextView.class));
    paramT.friendlyContractCode = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695025, "field 'friendlyContractCode'", TextView.class));
    paramT.friendlyInvoiceStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695026, "field 'friendlyInvoiceStatus'", TextView.class));
    paramT.llContainerInfo = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695027, "field 'llContainerInfo'", LinearLayout.class));
    paramT.tvNeedPayValue = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695030, "field 'tvNeedPayValue'", TextView.class));
    paramT.llPriceContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695029, "field 'llPriceContainer'", LinearLayout.class));
    paramT.btnCancelInvoice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695031, "field 'btnCancelInvoice'", TextView.class));
    paramT.btnToPay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695032, "field 'btnToPay'", TextView.class));
    paramT.llContainerBelow = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695028, "field 'llContainerBelow'", LinearLayout.class));
  }
  
  public void unbind()
  {
    FriendlyInvoiceListActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.friendlyInvoiceName = null;
    localViewHolder.friendlyContractCode = null;
    localViewHolder.friendlyInvoiceStatus = null;
    localViewHolder.llContainerInfo = null;
    localViewHolder.tvNeedPayValue = null;
    localViewHolder.llPriceContainer = null;
    localViewHolder.btnCancelInvoice = null;
    localViewHolder.btnToPay = null;
    localViewHolder.llContainerBelow = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceListActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */