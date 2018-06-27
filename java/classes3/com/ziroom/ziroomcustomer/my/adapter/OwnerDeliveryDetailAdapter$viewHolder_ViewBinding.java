package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class OwnerDeliveryDetailAdapter$viewHolder_ViewBinding<T extends OwnerDeliveryDetailAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public OwnerDeliveryDetailAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.owner_delivery_detail_item_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131695493, "field 'owner_delivery_detail_item_list'", ListViewForScrollView.class));
    paramT.owner_delivery_detail_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695492, "field 'owner_delivery_detail_title'", TextView.class));
    paramT.owner_delivery_detail_img_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695494, "field 'owner_delivery_detail_img_ll'", LinearLayout.class));
    paramT.owner_delivery_detail_img1 = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695495, "field 'owner_delivery_detail_img1'", SimpleDraweeView.class));
    paramT.owner_delivery_detail_img2 = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695496, "field 'owner_delivery_detail_img2'", SimpleDraweeView.class));
    paramT.owner_delivery_detail_img3 = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695497, "field 'owner_delivery_detail_img3'", SimpleDraweeView.class));
    paramT.owner_delivery_detail_img4 = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695498, "field 'owner_delivery_detail_img4'", SimpleDraweeView.class));
  }
  
  public void unbind()
  {
    OwnerDeliveryDetailAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.owner_delivery_detail_item_list = null;
    localviewHolder.owner_delivery_detail_title = null;
    localviewHolder.owner_delivery_detail_img_ll = null;
    localviewHolder.owner_delivery_detail_img1 = null;
    localviewHolder.owner_delivery_detail_img2 = null;
    localviewHolder.owner_delivery_detail_img3 = null;
    localviewHolder.owner_delivery_detail_img4 = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerDeliveryDetailAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */