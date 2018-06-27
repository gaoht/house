package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.MyGridView;

public class OCContractItemAdapter$ViewHolder_ViewBinding<T extends OCContractItemAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public OCContractItemAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lineTop = Utils.findRequiredView(paramView, 2131695462, "field 'lineTop'");
    paramT.tvChildInfoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695463, "field 'tvChildInfoTitle'", TextView.class));
    paramT.tvChildInfoSubtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695464, "field 'tvChildInfoSubtitle'", TextView.class));
    paramT.llChildItemDetail = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695465, "field 'llChildItemDetail'", LinearLayout.class));
    paramT.glChildPicBottom = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131695466, "field 'glChildPicBottom'", MyGridView.class));
  }
  
  public void unbind()
  {
    OCContractItemAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.lineTop = null;
    localViewHolder.tvChildInfoTitle = null;
    localViewHolder.tvChildInfoSubtitle = null;
    localViewHolder.llChildItemDetail = null;
    localViewHolder.glChildPicBottom = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OCContractItemAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */