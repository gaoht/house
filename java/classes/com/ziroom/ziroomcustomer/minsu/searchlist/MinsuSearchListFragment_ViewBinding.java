package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.content.Context;
import android.view.View;
import butterknife.Unbinder;

public class MinsuSearchListFragment_ViewBinding<T extends MinsuSearchListFragment>
  implements Unbinder
{
  protected T a;
  
  public MinsuSearchListFragment_ViewBinding(T paramT, Context paramContext)
  {
    this.a = paramT;
  }
  
  @Deprecated
  public MinsuSearchListFragment_ViewBinding(T paramT, View paramView)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/MinsuSearchListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */