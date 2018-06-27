package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class RecommendHouseAdapter$RecyclerViewHolder_ViewBinding<T extends RecommendHouseAdapter.RecyclerViewHolder>
  implements Unbinder
{
  protected T a;
  
  public RecommendHouseAdapter$RecyclerViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695429, "field 'tv_price'", TextView.class));
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695430, "field 'tv_title'", TextView.class));
    paramT.tv_subtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695431, "field 'tv_subtitle'", TextView.class));
    paramT.iv_img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695428, "field 'iv_img'", SimpleDraweeView.class));
  }
  
  public void unbind()
  {
    RecommendHouseAdapter.RecyclerViewHolder localRecyclerViewHolder = this.a;
    if (localRecyclerViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRecyclerViewHolder.tv_price = null;
    localRecyclerViewHolder.tv_title = null;
    localRecyclerViewHolder.tv_subtitle = null;
    localRecyclerViewHolder.iv_img = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/RecommendHouseAdapter$RecyclerViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */