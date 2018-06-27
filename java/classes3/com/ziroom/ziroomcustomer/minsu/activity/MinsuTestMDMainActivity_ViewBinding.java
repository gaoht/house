package com.ziroom.ziroomcustomer.minsu.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MinsuTestMDMainActivity_ViewBinding<T extends MinsuTestMDMainActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuTestMDMainActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.appBarLayout = ((AppBarLayout)Utils.findRequiredViewAsType(paramView, 2131696301, "field 'appBarLayout'", AppBarLayout.class));
    paramT.tvBack = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696480, "field 'tvBack'", TextView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696481, "field 'tvTitle'", TextView.class));
    paramT.title_area = ((ViewGroup)Utils.findRequiredViewAsType(paramView, 2131691597, "field 'title_area'", ViewGroup.class));
    paramT.toolbar_content = ((ViewGroup)Utils.findRequiredViewAsType(paramView, 2131696303, "field 'toolbar_content'", ViewGroup.class));
    paramT.coordinatorLayout = ((CoordinatorLayout)Utils.findRequiredViewAsType(paramView, 2131691402, "field 'coordinatorLayout'", CoordinatorLayout.class));
  }
  
  public void unbind()
  {
    MinsuTestMDMainActivity localMinsuTestMDMainActivity = this.a;
    if (localMinsuTestMDMainActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuTestMDMainActivity.appBarLayout = null;
    localMinsuTestMDMainActivity.tvBack = null;
    localMinsuTestMDMainActivity.tvTitle = null;
    localMinsuTestMDMainActivity.title_area = null;
    localMinsuTestMDMainActivity.toolbar_content = null;
    localMinsuTestMDMainActivity.coordinatorLayout = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTestMDMainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */