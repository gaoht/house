package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.stickylistheaders.StickyListHeadersListView;

public class MinsuTopHouseListActivity_ViewBinding<T extends MinsuTopHouseListActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuTopHouseListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.stickyList = ((StickyListHeadersListView)Utils.findRequiredViewAsType(paramView, 2131689522, "field 'stickyList'", StickyListHeadersListView.class));
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.swipeToLoadLayout = ((SwipeToLoadLayout)Utils.findRequiredViewAsType(paramView, 2131691285, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class));
  }
  
  public void unbind()
  {
    MinsuTopHouseListActivity localMinsuTopHouseListActivity = this.a;
    if (localMinsuTopHouseListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuTopHouseListActivity.stickyList = null;
    localMinsuTopHouseListActivity.commonTitle = null;
    localMinsuTopHouseListActivity.swipeToLoadLayout = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */