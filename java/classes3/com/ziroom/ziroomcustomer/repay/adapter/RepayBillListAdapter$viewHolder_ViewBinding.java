package com.ziroom.ziroomcustomer.repay.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class RepayBillListAdapter$viewHolder_ViewBinding<T extends RepayBillListAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public RepayBillListAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.period_repay_bills = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695590, "field 'period_repay_bills'", TextView.class));
    paramT.state_repay_bill = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695591, "field 'state_repay_bill'", TextView.class));
    paramT.repay_bill_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695592, "field 'repay_bill_time'", TextView.class));
    paramT.repay_bill_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695594, "field 'repay_bill_money'", TextView.class));
    paramT.repay_bill_money_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695593, "field 'repay_bill_money_text'", TextView.class));
    paramT.to_pay_btn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693338, "field 'to_pay_btn'", TextView.class));
    paramT.penalty_repay_bill = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695595, "field 'penalty_repay_bill'", LinearLayout.class));
    paramT.repay_bill_penalty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695596, "field 'repay_bill_penalty'", TextView.class));
  }
  
  public void unbind()
  {
    RepayBillListAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.period_repay_bills = null;
    localviewHolder.state_repay_bill = null;
    localviewHolder.repay_bill_time = null;
    localviewHolder.repay_bill_money = null;
    localviewHolder.repay_bill_money_text = null;
    localviewHolder.to_pay_btn = null;
    localviewHolder.penalty_repay_bill = null;
    localviewHolder.repay_bill_penalty = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/adapter/RepayBillListAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */