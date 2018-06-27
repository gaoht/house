package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class CleanGralleyCardAdapter$ViewHolder_ViewBinding<T extends CleanGralleyCardAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public CleanGralleyCardAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sdvCard = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694925, "field 'sdvCard'", SimpleDraweeView.class));
    paramT.tvGet = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694927, "field 'tvGet'", TextView.class));
    paramT.tvMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689846, "field 'tvMoney'", TextView.class));
    paramT.view = Utils.findRequiredView(paramView, 2131690147, "field 'view'");
    paramT.tvContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690084, "field 'tvContent'", TextView.class));
    paramT.sdvHeadPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131692685, "field 'sdvHeadPic'", SimpleDraweeView.class));
    paramT.btnSend = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691257, "field 'btnSend'", TextView.class));
    paramT.llSend = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692486, "field 'llSend'", LinearLayout.class));
  }
  
  public void unbind()
  {
    CleanGralleyCardAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.sdvCard = null;
    localViewHolder.tvGet = null;
    localViewHolder.tvMoney = null;
    localViewHolder.view = null;
    localViewHolder.tvContent = null;
    localViewHolder.sdvHeadPic = null;
    localViewHolder.btnSend = null;
    localViewHolder.llSend = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/CleanGralleyCardAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */