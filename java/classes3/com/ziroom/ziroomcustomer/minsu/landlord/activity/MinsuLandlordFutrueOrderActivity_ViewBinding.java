package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLandlordFutrueOrderActivity_ViewBinding<T extends MinsuLandlordFutrueOrderActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuLandlordFutrueOrderActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.container = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691278, "field 'container'", FrameLayout.class));
  }
  
  public void unbind()
  {
    MinsuLandlordFutrueOrderActivity localMinsuLandlordFutrueOrderActivity = this.a;
    if (localMinsuLandlordFutrueOrderActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandlordFutrueOrderActivity.commonTitle = null;
    localMinsuLandlordFutrueOrderActivity.container = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordFutrueOrderActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */