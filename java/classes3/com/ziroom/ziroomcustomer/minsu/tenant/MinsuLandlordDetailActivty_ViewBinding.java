package com.ziroom.ziroomcustomer.minsu.tenant;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;

public class MinsuLandlordDetailActivty_ViewBinding<T extends MinsuLandlordDetailActivty>
  implements Unbinder
{
  protected T a;
  
  public MinsuLandlordDetailActivty_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sl_root = ((SearchListScrollView)Utils.findRequiredViewAsType(paramView, 2131691456, "field 'sl_root'", SearchListScrollView.class));
    paramT.rv_house = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691465, "field 'rv_house'", RecyclerView.class));
  }
  
  public void unbind()
  {
    MinsuLandlordDetailActivty localMinsuLandlordDetailActivty = this.a;
    if (localMinsuLandlordDetailActivty == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandlordDetailActivty.sl_root = null;
    localMinsuLandlordDetailActivty.rv_house = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/tenant/MinsuLandlordDetailActivty_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */