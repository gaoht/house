package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.SwipeMenuListView;

public class MinsuCommonReplyListActivity_ViewBinding<T extends MinsuCommonReplyListActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuCommonReplyListActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.listview = ((SwipeMenuListView)Utils.findRequiredViewAsType(paramView, 2131689522, "field 'listview'", SwipeMenuListView.class));
  }
  
  public void unbind()
  {
    MinsuCommonReplyListActivity localMinsuCommonReplyListActivity = this.a;
    if (localMinsuCommonReplyListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuCommonReplyListActivity.commonTitle = null;
    localMinsuCommonReplyListActivity.listview = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCommonReplyListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */