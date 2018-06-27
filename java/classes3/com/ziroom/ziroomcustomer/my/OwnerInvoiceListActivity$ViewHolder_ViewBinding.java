package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OwnerInvoiceListActivity$ViewHolder_ViewBinding<T extends OwnerInvoiceListActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerInvoiceListActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ownerInvoiceName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692012, "field 'ownerInvoiceName'", TextView.class));
    paramT.ownerInvoiceStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695508, "field 'ownerInvoiceStatus'", TextView.class));
    paramT.ownerInvoicePriceOpen = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695510, "field 'ownerInvoicePriceOpen'", TextView.class));
    paramT.btnOpenInvoice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695511, "field 'btnOpenInvoice'", TextView.class));
    paramT.llContainerOpen = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695509, "field 'llContainerOpen'", LinearLayout.class));
    paramT.ownerInvoicePriceNotOpen = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695513, "field 'ownerInvoicePriceNotOpen'", TextView.class));
    paramT.ownerInvoiceType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695514, "field 'ownerInvoiceType'", TextView.class));
    paramT.ownerInvoiceTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695515, "field 'ownerInvoiceTime'", TextView.class));
    paramT.llContainerNotOpen = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695512, "field 'llContainerNotOpen'", LinearLayout.class));
    paramT.btnDownloadInvoice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695517, "field 'btnDownloadInvoice'", TextView.class));
    paramT.llContainerDownloadInvoice = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695516, "field 'llContainerDownloadInvoice'", LinearLayout.class));
    paramT.tvInvoiceReason = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695519, "field 'tvInvoiceReason'", TextView.class));
    paramT.llContainerReason = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695518, "field 'llContainerReason'", LinearLayout.class));
  }
  
  public void unbind()
  {
    OwnerInvoiceListActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ownerInvoiceName = null;
    localViewHolder.ownerInvoiceStatus = null;
    localViewHolder.ownerInvoicePriceOpen = null;
    localViewHolder.btnOpenInvoice = null;
    localViewHolder.llContainerOpen = null;
    localViewHolder.ownerInvoicePriceNotOpen = null;
    localViewHolder.ownerInvoiceType = null;
    localViewHolder.ownerInvoiceTime = null;
    localViewHolder.llContainerNotOpen = null;
    localViewHolder.btnDownloadInvoice = null;
    localViewHolder.llContainerDownloadInvoice = null;
    localViewHolder.tvInvoiceReason = null;
    localViewHolder.llContainerReason = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceListActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */