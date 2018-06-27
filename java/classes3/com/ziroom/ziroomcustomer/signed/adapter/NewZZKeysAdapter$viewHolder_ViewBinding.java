package com.ziroom.ziroomcustomer.signed.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NewZZKeysAdapter$viewHolder_ViewBinding<T extends NewZZKeysAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public NewZZKeysAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.keys_item_size = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697110, "field 'keys_item_size'", TextView.class));
    paramT.keys_item_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697108, "field 'keys_item_name'", TextView.class));
    paramT.keys_item_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697109, "field 'keys_item_content'", TextView.class));
  }
  
  public void unbind()
  {
    NewZZKeysAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.keys_item_size = null;
    localviewHolder.keys_item_name = null;
    localviewHolder.keys_item_content = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZKeysAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */