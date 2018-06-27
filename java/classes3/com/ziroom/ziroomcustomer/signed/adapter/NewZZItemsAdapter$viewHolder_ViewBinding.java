package com.ziroom.ziroomcustomer.signed.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NewZZItemsAdapter$viewHolder_ViewBinding<T extends NewZZItemsAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public NewZZItemsAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.items_item_size = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697101, "field 'items_item_size'", TextView.class));
    paramT.items_item_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697099, "field 'items_item_name'", TextView.class));
    paramT.items_item_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697100, "field 'items_item_content'", TextView.class));
  }
  
  public void unbind()
  {
    NewZZItemsAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.items_item_size = null;
    localviewHolder.items_item_name = null;
    localviewHolder.items_item_content = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZItemsAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */