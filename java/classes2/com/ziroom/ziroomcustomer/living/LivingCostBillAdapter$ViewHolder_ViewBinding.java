package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LivingCostBillAdapter$ViewHolder_ViewBinding<T extends LivingCostBillAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LivingCostBillAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.living_cost_item_check = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131696723, "field 'living_cost_item_check'", CheckBox.class));
    paramT.lease_living_cost_table_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696727, "field 'lease_living_cost_table_name'", TextView.class));
    paramT.lease_living_cost_item_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696724, "field 'lease_living_cost_item_title'", TextView.class));
    paramT.lease_living_cost_price_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696726, "field 'lease_living_cost_price_title'", TextView.class));
    paramT.lease_living_cost_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696728, "field 'lease_living_cost_date'", TextView.class));
    paramT.lease_living_cost_divide_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696729, "field 'lease_living_cost_divide_money'", TextView.class));
    paramT.lease_living_cost_previous_display = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696732, "field 'lease_living_cost_previous_display'", TextView.class));
    paramT.lease_living_cost_current_display = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696734, "field 'lease_living_cost_current_display'", TextView.class));
    paramT.lease_living_cost_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696736, "field 'lease_living_cost_price'", TextView.class));
    paramT.lease_living_cost_total_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696738, "field 'lease_living_cost_total_money'", TextView.class));
    paramT.lease_living_cost_divide_number = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696740, "field 'lease_living_cost_divide_number'", TextView.class));
    paramT.lease_living_cost_click_pack_up = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696741, "field 'lease_living_cost_click_pack_up'", LinearLayout.class));
    paramT.living_cost_bill_item_click_check = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131696743, "field 'living_cost_bill_item_click_check'", CheckBox.class));
    paramT.lease_living_cost_previous_display_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696731, "field 'lease_living_cost_previous_display_layout'", RelativeLayout.class));
    paramT.lease_living_cost_current_display_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696733, "field 'lease_living_cost_current_display_layout'", RelativeLayout.class));
    paramT.lease_living_cost_price_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696735, "field 'lease_living_cost_price_layout'", RelativeLayout.class));
    paramT.lease_living_cost_total_money_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696737, "field 'lease_living_cost_total_money_layout'", RelativeLayout.class));
    paramT.lease_living_cost_divide_number_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696739, "field 'lease_living_cost_divide_number_layout'", RelativeLayout.class));
    paramT.living_cost_bill_item_click_check_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696742, "field 'living_cost_bill_item_click_check_text'", TextView.class));
    paramT.living_cost_bill_layout = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692833, "field 'living_cost_bill_layout'", LinearLayout.class));
    paramT.living_cost_bill_history_text = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131696719, "field 'living_cost_bill_history_text'", FrameLayout.class));
    paramT.lease_living_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696721, "field 'lease_living_text'", TextView.class));
    paramT.lease_living_cost_item_code = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696725, "field 'lease_living_cost_item_code'", TextView.class));
    paramT.living_cost_bill_show_pay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696720, "field 'living_cost_bill_show_pay'", TextView.class));
    paramT.lease_living_cost_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696730, "field 'lease_living_cost_ll'", LinearLayout.class));
  }
  
  public void unbind()
  {
    LivingCostBillAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.living_cost_item_check = null;
    localViewHolder.lease_living_cost_table_name = null;
    localViewHolder.lease_living_cost_item_title = null;
    localViewHolder.lease_living_cost_price_title = null;
    localViewHolder.lease_living_cost_date = null;
    localViewHolder.lease_living_cost_divide_money = null;
    localViewHolder.lease_living_cost_previous_display = null;
    localViewHolder.lease_living_cost_current_display = null;
    localViewHolder.lease_living_cost_price = null;
    localViewHolder.lease_living_cost_total_money = null;
    localViewHolder.lease_living_cost_divide_number = null;
    localViewHolder.lease_living_cost_click_pack_up = null;
    localViewHolder.living_cost_bill_item_click_check = null;
    localViewHolder.lease_living_cost_previous_display_layout = null;
    localViewHolder.lease_living_cost_current_display_layout = null;
    localViewHolder.lease_living_cost_price_layout = null;
    localViewHolder.lease_living_cost_total_money_layout = null;
    localViewHolder.lease_living_cost_divide_number_layout = null;
    localViewHolder.living_cost_bill_item_click_check_text = null;
    localViewHolder.living_cost_bill_layout = null;
    localViewHolder.living_cost_bill_history_text = null;
    localViewHolder.lease_living_text = null;
    localViewHolder.lease_living_cost_item_code = null;
    localViewHolder.living_cost_bill_show_pay = null;
    localViewHolder.lease_living_cost_ll = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingCostBillAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */