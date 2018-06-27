package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ItemOwnerContractDetailAdapter$viewHolder_ViewBinding<T extends ItemOwnerContractDetailAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public ItemOwnerContractDetailAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.item_owner_contract_detail_info_item_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695471, "field 'item_owner_contract_detail_info_item_title'", TextView.class));
    paramT.item_owner_contract_detail_info_item_context = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695472, "field 'item_owner_contract_detail_info_item_context'", TextView.class));
    paramT.item_owner_contract_detail_info_item_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131695473, "field 'item_owner_contract_detail_info_item_img'", ImageView.class));
  }
  
  public void unbind()
  {
    ItemOwnerContractDetailAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.item_owner_contract_detail_info_item_title = null;
    localviewHolder.item_owner_contract_detail_info_item_context = null;
    localviewHolder.item_owner_contract_detail_info_item_img = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/ItemOwnerContractDetailAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */