package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MyRentCardActivity$ViewHolder_ViewBinding<T extends MyRentCardActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyRentCardActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mTvTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689852, "field 'mTvTime'", TextView.class));
    paramT.mTvNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'mTvNum'", TextView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
  }
  
  public void unbind()
  {
    MyRentCardActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.mTvName = null;
    localViewHolder.mTvTime = null;
    localViewHolder.mTvNum = null;
    localViewHolder.mTvTitle = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyRentCardActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */