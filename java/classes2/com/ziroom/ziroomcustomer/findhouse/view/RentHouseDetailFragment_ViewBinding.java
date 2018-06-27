package com.ziroom.ziroomcustomer.findhouse.view;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class RentHouseDetailFragment_ViewBinding<T extends RentHouseDetailFragment>
  implements Unbinder
{
  protected T a;
  
  public RentHouseDetailFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mVTitleDivider = Utils.findRequiredView(paramView, 2131692780, "field 'mVTitleDivider'");
  }
  
  public void unbind()
  {
    RentHouseDetailFragment localRentHouseDetailFragment = this.a;
    if (localRentHouseDetailFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRentHouseDetailFragment.mVTitleDivider = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */