package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuLLApplyDetailActivity_ViewBinding<T extends MinsuLLApplyDetailActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuLLApplyDetailActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.listview = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'listview'", ListViewForScrollView.class));
    paramT.price_total = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691562, "field 'price_total'", TextView.class));
    paramT.tvHouseName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691210, "field 'tvHouseName'", TextView.class));
    paramT.tvStartDate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691212, "field 'tvStartDate'", TextView.class));
    paramT.tvEndDate = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691214, "field 'tvEndDate'", TextView.class));
    paramT.tvPerson = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691561, "field 'tvPerson'", TextView.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    MinsuLLApplyDetailActivity localMinsuLLApplyDetailActivity = this.a;
    if (localMinsuLLApplyDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLLApplyDetailActivity.commonTitle = null;
    localMinsuLLApplyDetailActivity.listview = null;
    localMinsuLLApplyDetailActivity.price_total = null;
    localMinsuLLApplyDetailActivity.tvHouseName = null;
    localMinsuLLApplyDetailActivity.tvStartDate = null;
    localMinsuLLApplyDetailActivity.tvEndDate = null;
    localMinsuLLApplyDetailActivity.tvPerson = null;
    localMinsuLLApplyDetailActivity.sv_content = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLLApplyDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */