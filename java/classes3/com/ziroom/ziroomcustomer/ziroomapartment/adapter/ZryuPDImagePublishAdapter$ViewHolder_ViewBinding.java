package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuPDImagePublishAdapter$ViewHolder_ViewBinding<T extends ZryuPDImagePublishAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuPDImagePublishAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ivPdRevisionZspaceDefault = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131695529, "field 'ivPdRevisionZspaceDefault'", ImageView.class));
    paramT.ivPdRevisionZspace = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695460, "field 'ivPdRevisionZspace'", SimpleDraweeView.class));
    paramT.tvSeeMoreZSpace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695461, "field 'tvSeeMoreZSpace'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuPDImagePublishAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ivPdRevisionZspaceDefault = null;
    localViewHolder.ivPdRevisionZspace = null;
    localViewHolder.tvSeeMoreZSpace = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/ZryuPDImagePublishAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */