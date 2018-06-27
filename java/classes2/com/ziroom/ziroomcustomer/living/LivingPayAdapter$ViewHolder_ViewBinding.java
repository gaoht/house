package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LivingPayAdapter$ViewHolder_ViewBinding<T extends LivingPayAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LivingPayAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.living_pay_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696748, "field 'living_pay_title'", TextView.class));
    paramT.living_pay_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696749, "field 'living_pay_content'", TextView.class));
    paramT.living_pay_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131696747, "field 'living_pay_img'", ImageView.class));
  }
  
  public void unbind()
  {
    LivingPayAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.living_pay_title = null;
    localViewHolder.living_pay_content = null;
    localViewHolder.living_pay_img = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingPayAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */