package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuPriceInfoListActivity_ViewBinding<T extends MinsuPriceInfoListActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuPriceInfoListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
    paramT.listview = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'listview'", ListViewForScrollView.class));
    paramT.price_total = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691562, "field 'price_total'", TextView.class));
  }
  
  public void unbind()
  {
    MinsuPriceInfoListActivity localMinsuPriceInfoListActivity = this.a;
    if (localMinsuPriceInfoListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPriceInfoListActivity.commonTitle = null;
    localMinsuPriceInfoListActivity.sv_content = null;
    localMinsuPriceInfoListActivity.listview = null;
    localMinsuPriceInfoListActivity.price_total = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPriceInfoListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */