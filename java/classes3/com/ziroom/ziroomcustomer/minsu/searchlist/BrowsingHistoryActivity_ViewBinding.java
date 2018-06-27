package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class BrowsingHistoryActivity_ViewBinding<T extends BrowsingHistoryActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public BrowsingHistoryActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'onClick'");
    paramT.btn_back = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.rv_history = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131690080, "field 'rv_history'", RecyclerView.class));
    paramT.rl_empty = Utils.findRequiredView(paramView, 2131690081, "field 'rl_empty'");
  }
  
  public void unbind()
  {
    BrowsingHistoryActivity localBrowsingHistoryActivity = this.a;
    if (localBrowsingHistoryActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBrowsingHistoryActivity.btn_back = null;
    localBrowsingHistoryActivity.rv_history = null;
    localBrowsingHistoryActivity.rl_empty = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/BrowsingHistoryActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */