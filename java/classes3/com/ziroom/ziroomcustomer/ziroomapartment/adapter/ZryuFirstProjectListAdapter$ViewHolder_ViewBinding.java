package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuFirstProjectListAdapter$ViewHolder_ViewBinding<T extends ZryuFirstProjectListAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public ZryuFirstProjectListAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ivProjectPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695895, "field 'ivProjectPic'", SimpleDraweeView.class));
    paramT.projectName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695008, "field 'projectName'", TextView.class));
    paramT.projectAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695009, "field 'projectAddress'", TextView.class));
    paramT.projectPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695896, "field 'projectPrice'", TextView.class));
    paramT.flProjectPic = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131695894, "field 'flProjectPic'", FrameLayout.class));
  }
  
  public void unbind()
  {
    ZryuFirstProjectListAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.ivProjectPic = null;
    localViewHolder.projectName = null;
    localViewHolder.projectAddress = null;
    localViewHolder.projectPrice = null;
    localViewHolder.flProjectPic = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/ZryuFirstProjectListAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */