package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OwnerContractAdapter$viewHolder_ViewBinding<T extends OwnerContractAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerContractAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.owner_contract_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695476, "field 'owner_contract_address'", TextView.class));
    paramT.owner_contract_start_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695477, "field 'owner_contract_start_time'", TextView.class));
    paramT.owner_contract_end_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695478, "field 'owner_contract_end_time'", TextView.class));
    paramT.owner_contract_btn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695479, "field 'owner_contract_btn'", TextView.class));
  }
  
  public void unbind()
  {
    OwnerContractAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.owner_contract_address = null;
    localviewHolder.owner_contract_start_time = null;
    localviewHolder.owner_contract_end_time = null;
    localviewHolder.owner_contract_btn = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerContractAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */