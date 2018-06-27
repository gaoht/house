package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ZryuBillListActivity$PaiedViewHolder_ViewBinding<T extends ZryuBillListActivity.PaiedViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillListActivity$PaiedViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ll_zryu_online_had_pay_item = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695887, "field 'll_zryu_online_had_pay_item'", LinearLayout.class));
    paramT.tvBillTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695888, "field 'tvBillTitle'", TextView.class));
    paramT.tvBillNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692814, "field 'tvBillNum'", TextView.class));
    paramT.tvShouldPayTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692817, "field 'tvShouldPayTime'", TextView.class));
    paramT.tvRealPayTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695889, "field 'tvRealPayTime'", TextView.class));
    paramT.tvShouldPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695890, "field 'tvShouldPayPrice'", TextView.class));
    paramT.tvRealPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695891, "field 'tvRealPayPrice'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuBillListActivity.PaiedViewHolder localPaiedViewHolder = this.a;
    if (localPaiedViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPaiedViewHolder.ll_zryu_online_had_pay_item = null;
    localPaiedViewHolder.tvBillTitle = null;
    localPaiedViewHolder.tvBillNum = null;
    localPaiedViewHolder.tvShouldPayTime = null;
    localPaiedViewHolder.tvRealPayTime = null;
    localPaiedViewHolder.tvShouldPayPrice = null;
    localPaiedViewHolder.tvRealPayPrice = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillListActivity$PaiedViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */