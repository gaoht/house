package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class FriendlyWillPayAdapter$ViewHolder_ViewBinding<T extends FriendlyWillPayAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public FriendlyWillPayAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvWillPayTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694447, "field 'tvWillPayTitle'", TextView.class));
    paramT.tvWillPayStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694448, "field 'tvWillPayStatus'", TextView.class));
    paramT.sdvIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694449, "field 'sdvIcon'", SimpleDraweeView.class));
    paramT.tvWillPayInfoTop = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694450, "field 'tvWillPayInfoTop'", TextView.class));
    paramT.tvWillPayInfoCenter = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694451, "field 'tvWillPayInfoCenter'", TextView.class));
    paramT.tvWillPayPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694452, "field 'tvWillPayPrice'", TextView.class));
    paramT.btnPay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690461, "field 'btnPay'", TextView.class));
  }
  
  public void unbind()
  {
    FriendlyWillPayAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvWillPayTitle = null;
    localViewHolder.tvWillPayStatus = null;
    localViewHolder.sdvIcon = null;
    localViewHolder.tvWillPayInfoTop = null;
    localViewHolder.tvWillPayInfoCenter = null;
    localViewHolder.tvWillPayPrice = null;
    localViewHolder.btnPay = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/FriendlyWillPayAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */