package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.content.Context;
import android.view.View;
import butterknife.Unbinder;

public class StationSearchListFragment_ViewBinding<T extends StationSearchListFragment>
  implements Unbinder
{
  protected T a;
  
  public StationSearchListFragment_ViewBinding(T paramT, Context paramContext)
  {
    this.a = paramT;
  }
  
  @Deprecated
  public StationSearchListFragment_ViewBinding(T paramT, View paramView)
  {
    this(paramT, paramView.getContext());
  }
  
  public void unbind()
  {
    if (this.a == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/StationSearchListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */