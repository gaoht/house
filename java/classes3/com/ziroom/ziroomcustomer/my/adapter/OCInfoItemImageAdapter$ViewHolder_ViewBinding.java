package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class OCInfoItemImageAdapter$ViewHolder_ViewBinding<T extends OCInfoItemImageAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public OCInfoItemImageAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ivPdRevisionZspace = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695460, "field 'ivPdRevisionZspace'", SimpleDraweeView.class));
    paramT.tvSeeMoreZSpace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695461, "field 'tvSeeMoreZSpace'", TextView.class));
  }
  
  public void unbind()
  {
    OCInfoItemImageAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ivPdRevisionZspace = null;
    localViewHolder.tvSeeMoreZSpace = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OCInfoItemImageAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */