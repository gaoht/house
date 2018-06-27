package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyStewardListAdapter$viewHolder_ViewBinding<T extends MyStewardListAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyStewardListAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.my_steward_item_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697000, "field 'my_steward_item_address'", TextView.class));
    paramT.my_steward_item_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697002, "field 'my_steward_item_name'", TextView.class));
    paramT.my_steward_item_img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131697001, "field 'my_steward_item_img'", SimpleDraweeView.class));
    paramT.contact_housekeeper = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696624, "field 'contact_housekeeper'", TextView.class));
    paramT.my_steward_item_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697003, "field 'my_steward_item_text'", TextView.class));
  }
  
  public void unbind()
  {
    MyStewardListAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.my_steward_item_address = null;
    localviewHolder.my_steward_item_name = null;
    localviewHolder.my_steward_item_img = null;
    localviewHolder.contact_housekeeper = null;
    localviewHolder.my_steward_item_text = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyStewardListAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */