package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OwnerInvoicePriceListActivity$ViewHolder_ViewBinding<T extends OwnerInvoicePriceListActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerInvoicePriceListActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ownerInvoiceName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692012, "field 'ownerInvoiceName'", TextView.class));
    paramT.llContainerPrices = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695520, "field 'llContainerPrices'", LinearLayout.class));
  }
  
  public void unbind()
  {
    OwnerInvoicePriceListActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ownerInvoiceName = null;
    localViewHolder.llContainerPrices = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoicePriceListActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */