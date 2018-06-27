package com.ziroom.ziroomcustomer.minsu.collectlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MinsuHouseCollectListFragment_ViewBinding<T extends MinsuHouseCollectListFragment>
  implements Unbinder
{
  protected T a;
  
  public MinsuHouseCollectListFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ll_empty = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689818, "field 'll_empty'", LinearLayout.class));
    paramT.rv_list = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691646, "field 'rv_list'", RecyclerView.class));
  }
  
  public void unbind()
  {
    MinsuHouseCollectListFragment localMinsuHouseCollectListFragment = this.a;
    if (localMinsuHouseCollectListFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuHouseCollectListFragment.ll_empty = null;
    localMinsuHouseCollectListFragment.rv_list = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/collectlist/MinsuHouseCollectListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */