package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class LeaseHistoryLivingAdapter$ViewHolder_ViewBinding<T extends LeaseHistoryLivingAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LeaseHistoryLivingAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.history_living_date_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696605, "field 'history_living_date_text'", TextView.class));
    paramT.lease_history_living_item_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131696606, "field 'lease_history_living_item_list'", ListViewForScrollView.class));
  }
  
  public void unbind()
  {
    LeaseHistoryLivingAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.history_living_date_text = null;
    localViewHolder.lease_history_living_item_list = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */