package com.ziroom.ziroomcustomer.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class HouseBillPayTypeAdapter$viewHolder_ViewBinding<T extends HouseBillPayTypeAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public HouseBillPayTypeAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.pay_type_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131695061, "field 'pay_type_img'", ImageView.class));
    paramT.pay_type_cb = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131695062, "field 'pay_type_cb'", CheckBox.class));
    paramT.pay_type_name_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695063, "field 'pay_type_name_tv'", TextView.class));
    paramT.pay_type_hint_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695064, "field 'pay_type_hint_tv'", TextView.class));
  }
  
  public void unbind()
  {
    HouseBillPayTypeAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.pay_type_img = null;
    localviewHolder.pay_type_cb = null;
    localviewHolder.pay_type_name_tv = null;
    localviewHolder.pay_type_hint_tv = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/HouseBillPayTypeAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */