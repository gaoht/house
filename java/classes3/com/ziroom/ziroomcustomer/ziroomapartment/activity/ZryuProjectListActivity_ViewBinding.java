package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.IndicatorListView;

public class ZryuProjectListActivity_ViewBinding<T extends ZryuProjectListActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuProjectListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvProjectListFilter = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692856, "field 'tvProjectListFilter'", TextView.class));
    paramT.ilvZryuProjectList = ((IndicatorListView)Utils.findRequiredViewAsType(paramView, 2131692931, "field 'ilvZryuProjectList'", IndicatorListView.class));
    paramT.tvNoSearchResultTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692930, "field 'tvNoSearchResultTip'", TextView.class));
    paramT.rlNoSearchResult = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692929, "field 'rlNoSearchResult'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    ZryuProjectListActivity localZryuProjectListActivity = this.a;
    if (localZryuProjectListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuProjectListActivity.btnBack = null;
    localZryuProjectListActivity.tvTitle = null;
    localZryuProjectListActivity.tvProjectListFilter = null;
    localZryuProjectListActivity.ilvZryuProjectList = null;
    localZryuProjectListActivity.tvNoSearchResultTip = null;
    localZryuProjectListActivity.rlNoSearchResult = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */