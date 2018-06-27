package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LeaseHistoryLivingItemAdapter$ViewHolder_ViewBinding<T extends LeaseHistoryLivingItemAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LeaseHistoryLivingItemAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.history_living_item_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696602, "field 'history_living_item_text'", TextView.class));
    paramT.history_living_item_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696603, "field 'history_living_item_price'", TextView.class));
    paramT.history_living_item_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696601, "field 'history_living_item_layout'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    LeaseHistoryLivingItemAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.history_living_item_text = null;
    localViewHolder.history_living_item_price = null;
    localViewHolder.history_living_item_layout = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingItemAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */