package com.ziroom.ziroomcustomer.intellect;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class IntelligentLockActivity_ViewBinding<T extends IntelligentLockActivity>
  implements Unbinder
{
  protected T a;
  
  public IntelligentLockActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_lockInfo_contractName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690990, "field 'tv_lockInfo_contractName'", TextView.class));
    paramT.rl_vp = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690992, "field 'rl_vp'", RelativeLayout.class));
    paramT.intellect_vp = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690993, "field 'intellect_vp'", ViewPager.class));
    paramT.tv_lockInfo_roomName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689977, "field 'tv_lockInfo_roomName'", TextView.class));
    paramT.intellect_ll_point = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690994, "field 'intellect_ll_point'", LinearLayout.class));
  }
  
  public void unbind()
  {
    IntelligentLockActivity localIntelligentLockActivity = this.a;
    if (localIntelligentLockActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localIntelligentLockActivity.tv_lockInfo_contractName = null;
    localIntelligentLockActivity.rl_vp = null;
    localIntelligentLockActivity.intellect_vp = null;
    localIntelligentLockActivity.tv_lockInfo_roomName = null;
    localIntelligentLockActivity.intellect_ll_point = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/intellect/IntelligentLockActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */