package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class OwnerContractDetailAdapter$viewHolder_ViewBinding<T extends OwnerContractDetailAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerContractDetailAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.owner_contract_detail_item_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131695469, "field 'owner_contract_detail_item_list'", ListViewForScrollView.class));
    paramT.owner_contract_detail_context = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695468, "field 'owner_contract_detail_context'", TextView.class));
    paramT.owner_contract_detail_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695467, "field 'owner_contract_detail_title'", TextView.class));
    paramT.owner_contract_detail_show_html = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695470, "field 'owner_contract_detail_show_html'", TextView.class));
  }
  
  public void unbind()
  {
    OwnerContractDetailAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.owner_contract_detail_item_list = null;
    localviewHolder.owner_contract_detail_context = null;
    localviewHolder.owner_contract_detail_title = null;
    localviewHolder.owner_contract_detail_show_html = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerContractDetailAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */