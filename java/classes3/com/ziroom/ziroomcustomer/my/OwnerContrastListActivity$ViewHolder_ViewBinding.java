package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OwnerContrastListActivity$ViewHolder_ViewBinding<T extends OwnerContrastListActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerContrastListActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.llAddress = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692247, "field 'llAddress'", LinearLayout.class));
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    paramT.llLoanContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695480, "field 'llLoanContainer'", LinearLayout.class));
    paramT.tvOwnerContractName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695481, "field 'tvOwnerContractName'", TextView.class));
    paramT.tvOwnerContractStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695482, "field 'tvOwnerContractStatus'", TextView.class));
    paramT.tvOwnerContractAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695483, "field 'tvOwnerContractAddress'", TextView.class));
    paramT.llOwnerContractDetail = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695484, "field 'llOwnerContractDetail'", LinearLayout.class));
    paramT.tvSeeContract = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695485, "field 'tvSeeContract'", TextView.class));
    paramT.tvConfirmContract = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695486, "field 'tvConfirmContract'", TextView.class));
    paramT.tvOpenInvoice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695487, "field 'tvOpenInvoice'", TextView.class));
    paramT.llOwnerContractContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695488, "field 'llOwnerContractContainer'", LinearLayout.class));
    paramT.dividerBottom = Utils.findRequiredView(paramView, 2131695489, "field 'dividerBottom'");
  }
  
  public void unbind()
  {
    OwnerContrastListActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.llAddress = null;
    localViewHolder.tvAddress = null;
    localViewHolder.llLoanContainer = null;
    localViewHolder.tvOwnerContractName = null;
    localViewHolder.tvOwnerContractStatus = null;
    localViewHolder.tvOwnerContractAddress = null;
    localViewHolder.llOwnerContractDetail = null;
    localViewHolder.tvSeeContract = null;
    localViewHolder.tvConfirmContract = null;
    localViewHolder.tvOpenInvoice = null;
    localViewHolder.llOwnerContractContainer = null;
    localViewHolder.dividerBottom = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContrastListActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */