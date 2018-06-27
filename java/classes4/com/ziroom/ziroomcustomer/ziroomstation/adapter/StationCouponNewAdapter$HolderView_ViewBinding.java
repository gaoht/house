package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class StationCouponNewAdapter$HolderView_ViewBinding<T extends StationCouponNewAdapter.HolderView>
  implements Unbinder
{
  protected T a;
  
  public StationCouponNewAdapter$HolderView_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mTvTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689852, "field 'mTvTime'", TextView.class));
    paramT.mTvNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'mTvNum'", TextView.class));
    paramT.mTvUnit = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689840, "field 'mTvUnit'", TextView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTvSubTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694578, "field 'mTvSubTitle'", TextView.class));
    paramT.tvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'tvStatus'", TextView.class));
  }
  
  public void unbind()
  {
    StationCouponNewAdapter.HolderView localHolderView = this.a;
    if (localHolderView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHolderView.mTvName = null;
    localHolderView.mTvTime = null;
    localHolderView.mTvNum = null;
    localHolderView.mTvUnit = null;
    localHolderView.mTvTitle = null;
    localHolderView.mTvSubTitle = null;
    localHolderView.tvStatus = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/StationCouponNewAdapter$HolderView_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */