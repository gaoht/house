package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ZryuBillListActivity$WillViewHolder_ViewBinding<T extends ZryuBillListActivity.WillViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillListActivity$WillViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ll_zryu_online_will_pay_item = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695892, "field 'll_zryu_online_will_pay_item'", LinearLayout.class));
    paramT.tvBillTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695888, "field 'tvBillTitle'", TextView.class));
    paramT.tvBillNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692814, "field 'tvBillNum'", TextView.class));
    paramT.tvShouldPayTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692817, "field 'tvShouldPayTime'", TextView.class));
    paramT.tvShouldPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695890, "field 'tvShouldPayPrice'", TextView.class));
    paramT.tvRealPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695891, "field 'tvRealPayPrice'", TextView.class));
    paramT.tvWillPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694452, "field 'tvWillPayPrice'", TextView.class));
    paramT.btnTvToPay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695893, "field 'btnTvToPay'", TextView.class));
    paramT.vDivider = Utils.findRequiredView(paramView, 2131689863, "field 'vDivider'");
    paramT.llBtn = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691870, "field 'llBtn'", LinearLayout.class));
  }
  
  public void unbind()
  {
    ZryuBillListActivity.WillViewHolder localWillViewHolder = this.a;
    if (localWillViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localWillViewHolder.ll_zryu_online_will_pay_item = null;
    localWillViewHolder.tvBillTitle = null;
    localWillViewHolder.tvBillNum = null;
    localWillViewHolder.tvShouldPayTime = null;
    localWillViewHolder.tvShouldPayPrice = null;
    localWillViewHolder.tvRealPayPrice = null;
    localWillViewHolder.tvWillPayPrice = null;
    localWillViewHolder.btnTvToPay = null;
    localWillViewHolder.vDivider = null;
    localWillViewHolder.llBtn = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillListActivity$WillViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */