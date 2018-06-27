package com.ziroom.ziroomcustomer.minsu.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuEvaSuccessActivity_ViewBinding<T extends MinsuEvaSuccessActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuEvaSuccessActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.swipeTarget = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131689522, "field 'swipeTarget'", RecyclerView.class));
    paramT.swipeToLoadLayout = ((SwipeToLoadLayout)Utils.findRequiredViewAsType(paramView, 2131691285, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class));
  }
  
  public void unbind()
  {
    MinsuEvaSuccessActivity localMinsuEvaSuccessActivity = this.a;
    if (localMinsuEvaSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuEvaSuccessActivity.commonTitle = null;
    localMinsuEvaSuccessActivity.swipeTarget = null;
    localMinsuEvaSuccessActivity.swipeToLoadLayout = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */