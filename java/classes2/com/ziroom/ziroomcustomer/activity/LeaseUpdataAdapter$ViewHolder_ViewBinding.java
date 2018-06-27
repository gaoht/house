package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LeaseUpdataAdapter$ViewHolder_ViewBinding<T extends LeaseUpdataAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public LeaseUpdataAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.updata_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696707, "field 'updata_title'", TextView.class));
    paramT.updata_message = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696708, "field 'updata_message'", TextView.class));
    paramT.updata_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696709, "field 'updata_tv'", TextView.class));
  }
  
  public void unbind()
  {
    LeaseUpdataAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.updata_title = null;
    localViewHolder.updata_message = null;
    localViewHolder.updata_tv = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseUpdataAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */