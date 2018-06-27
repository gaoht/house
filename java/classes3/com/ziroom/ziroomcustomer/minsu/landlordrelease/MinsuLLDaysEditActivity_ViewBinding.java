package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLLDaysEditActivity_ViewBinding<T extends MinsuLLDaysEditActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuLLDaysEditActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.subtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691564, "field 'subtitle'", TextView.class));
    paramT.cbRentable = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131691566, "field 'cbRentable'", CheckBox.class));
    paramT.cbNotRentable = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131691568, "field 'cbNotRentable'", CheckBox.class));
    paramT.etSpecialPrice = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691569, "field 'etSpecialPrice'", EditText.class));
  }
  
  public void unbind()
  {
    MinsuLLDaysEditActivity localMinsuLLDaysEditActivity = this.a;
    if (localMinsuLLDaysEditActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLLDaysEditActivity.commonTitle = null;
    localMinsuLLDaysEditActivity.subtitle = null;
    localMinsuLLDaysEditActivity.cbRentable = null;
    localMinsuLLDaysEditActivity.cbNotRentable = null;
    localMinsuLLDaysEditActivity.etSpecialPrice = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/MinsuLLDaysEditActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */