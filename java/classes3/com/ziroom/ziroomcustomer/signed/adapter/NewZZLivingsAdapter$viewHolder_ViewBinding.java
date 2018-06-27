package com.ziroom.ziroomcustomer.signed.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NewZZLivingsAdapter$viewHolder_ViewBinding<T extends NewZZLivingsAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public NewZZLivingsAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.livings_item_size = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697119, "field 'livings_item_size'", TextView.class));
    paramT.livings_item_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697117, "field 'livings_item_name'", TextView.class));
    paramT.livings_item_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697118, "field 'livings_item_content'", TextView.class));
  }
  
  public void unbind()
  {
    NewZZLivingsAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.livings_item_size = null;
    localviewHolder.livings_item_name = null;
    localviewHolder.livings_item_content = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZLivingsAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */