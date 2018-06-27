package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class ZryuBillListActivity_ViewBinding<T extends ZryuBillListActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ivLeaseBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691914, "field 'ivLeaseBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.leaseLinePop = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692665, "field 'leaseLinePop'", RelativeLayout.class));
    paramT.houseBillText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692831, "field 'houseBillText'", TextView.class));
    paramT.houseBillLine = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692832, "field 'houseBillLine'", TextView.class));
    paramT.houseBillLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692830, "field 'houseBillLayout'", RelativeLayout.class));
    paramT.livingCostBillText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692834, "field 'livingCostBillText'", TextView.class));
    paramT.livingCostBillLine = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692835, "field 'livingCostBillLine'", TextView.class));
    paramT.livingCostBillLayout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692833, "field 'livingCostBillLayout'", RelativeLayout.class));
    paramT.leaseTab = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692829, "field 'leaseTab'", LinearLayout.class));
    paramT.lineBelowTab = Utils.findRequiredView(paramView, 2131692836, "field 'lineBelowTab'");
    paramT.tvCheckPaiedBills = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692839, "field 'tvCheckPaiedBills'", TextView.class));
    paramT.leaseAllBillList = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692838, "field 'leaseAllBillList'", ListViewForScrollView.class));
    paramT.tvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690822, "field 'tvEmpty'", TextView.class));
    paramT.llEmptyContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692840, "field 'llEmptyContainer'", LinearLayout.class));
    paramT.svLeaseListContainer = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131692837, "field 'svLeaseListContainer'", ScrollView.class));
    paramT.tvCheckPaiedBillsEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692841, "field 'tvCheckPaiedBillsEmpty'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuBillListActivity localZryuBillListActivity = this.a;
    if (localZryuBillListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuBillListActivity.ivLeaseBack = null;
    localZryuBillListActivity.tvTitle = null;
    localZryuBillListActivity.leaseLinePop = null;
    localZryuBillListActivity.houseBillText = null;
    localZryuBillListActivity.houseBillLine = null;
    localZryuBillListActivity.houseBillLayout = null;
    localZryuBillListActivity.livingCostBillText = null;
    localZryuBillListActivity.livingCostBillLine = null;
    localZryuBillListActivity.livingCostBillLayout = null;
    localZryuBillListActivity.leaseTab = null;
    localZryuBillListActivity.lineBelowTab = null;
    localZryuBillListActivity.tvCheckPaiedBills = null;
    localZryuBillListActivity.leaseAllBillList = null;
    localZryuBillListActivity.tvEmpty = null;
    localZryuBillListActivity.llEmptyContainer = null;
    localZryuBillListActivity.svLeaseListContainer = null;
    localZryuBillListActivity.tvCheckPaiedBillsEmpty = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */