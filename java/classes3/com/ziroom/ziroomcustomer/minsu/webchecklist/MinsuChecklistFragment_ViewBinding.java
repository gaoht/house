package com.ziroom.ziroomcustomer.minsu.webchecklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuChecklistFragment_ViewBinding<T extends MinsuChecklistFragment>
  implements Unbinder
{
  protected T a;
  
  public MinsuChecklistFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.recyclerview = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131694160, "field 'recyclerview'", RecyclerView.class));
  }
  
  public void unbind()
  {
    MinsuChecklistFragment localMinsuChecklistFragment = this.a;
    if (localMinsuChecklistFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuChecklistFragment.commonTitle = null;
    localMinsuChecklistFragment.recyclerview = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/MinsuChecklistFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */