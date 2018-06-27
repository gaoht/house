package com.ziroom.ziroomcustomer.my;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyTravelActivity_ViewBinding<T extends MyTravelActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MyTravelActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.recyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691904, "field 'recyclerView'", RecyclerView.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MyTravelActivity localMyTravelActivity = this.a;
    if (localMyTravelActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyTravelActivity.recyclerView = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyTravelActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */