package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyGridView;

public class SelectedBedInfosAdapter$ViewHolder_ViewBinding<T extends SelectedBedInfosAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public SelectedBedInfosAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvRoomNameInto = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695119, "field 'tvRoomNameInto'", TextView.class));
    paramT.gvRoomBedsInto = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131695120, "field 'gvRoomBedsInto'", MyGridView.class));
  }
  
  public void unbind()
  {
    SelectedBedInfosAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvRoomNameInto = null;
    localViewHolder.gvRoomBedsInto = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/SelectedBedInfosAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */