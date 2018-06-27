package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LeaseLivingInfoActivity_ViewBinding<T extends LeaseLivingInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LeaseLivingInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691914, "field 'iv_lease_back' and method 'onClick'");
    paramT.iv_lease_back = ((ImageView)Utils.castView(localView, 2131691914, "field 'iv_lease_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.living_info_order_code = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696630, "field 'living_info_order_code'", TextView.class));
    paramT.living_info_bill_start_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696631, "field 'living_info_bill_start_date'", TextView.class));
    paramT.living_info_before_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696633, "field 'living_info_before_num'", TextView.class));
    paramT.living_info_display_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696635, "field 'living_info_display_num'", TextView.class));
    paramT.living_info_unit_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696637, "field 'living_info_unit_price'", TextView.class));
    paramT.living_info_all_should = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696638, "field 'living_info_all_should'", TextView.class));
    paramT.living_info_number_share = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696639, "field 'living_info_number_share'", TextView.class));
    paramT.living_info_should_pay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696640, "field 'living_info_should_pay'", TextView.class));
    paramT.living_info_payed_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696642, "field 'living_info_payed_time'", TextView.class));
    paramT.living_info_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696627, "field 'living_info_title'", TextView.class));
    paramT.living_info_pay_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696629, "field 'living_info_pay_type'", TextView.class));
    paramT.living_info_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696628, "field 'living_info_money'", TextView.class));
    paramT.living_info_before_num_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696632, "field 'living_info_before_num_rl'", RelativeLayout.class));
    paramT.living_info_display_num_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696634, "field 'living_info_display_num_rl'", RelativeLayout.class));
    paramT.living_info_unit_price_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696636, "field 'living_info_unit_price_rl'", RelativeLayout.class));
    paramT.living_info_payed_time_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696641, "field 'living_info_payed_time_rl'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    LeaseLivingInfoActivity localLeaseLivingInfoActivity = this.a;
    if (localLeaseLivingInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseLivingInfoActivity.iv_lease_back = null;
    localLeaseLivingInfoActivity.living_info_order_code = null;
    localLeaseLivingInfoActivity.living_info_bill_start_date = null;
    localLeaseLivingInfoActivity.living_info_before_num = null;
    localLeaseLivingInfoActivity.living_info_display_num = null;
    localLeaseLivingInfoActivity.living_info_unit_price = null;
    localLeaseLivingInfoActivity.living_info_all_should = null;
    localLeaseLivingInfoActivity.living_info_number_share = null;
    localLeaseLivingInfoActivity.living_info_should_pay = null;
    localLeaseLivingInfoActivity.living_info_payed_time = null;
    localLeaseLivingInfoActivity.living_info_title = null;
    localLeaseLivingInfoActivity.living_info_pay_type = null;
    localLeaseLivingInfoActivity.living_info_money = null;
    localLeaseLivingInfoActivity.living_info_before_num_rl = null;
    localLeaseLivingInfoActivity.living_info_display_num_rl = null;
    localLeaseLivingInfoActivity.living_info_unit_price_rl = null;
    localLeaseLivingInfoActivity.living_info_payed_time_rl = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseLivingInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */