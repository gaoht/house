package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.SwipeMenuListView;

public class MinsuCustomersListActivity_ViewBinding<T extends MinsuCustomersListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MinsuCustomersListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690041, "field 'tvAdd' and method 'onClick'");
    paramT.tvAdd = ((TextView)Utils.castView(localView, 2131690041, "field 'tvAdd'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.line = Utils.findRequiredView(paramView, 2131689578, "field 'line'");
    paramT.listview = ((SwipeMenuListView)Utils.findRequiredViewAsType(paramView, 2131691286, "field 'listview'", SwipeMenuListView.class));
    paramT.swipeToLoadLayout = ((SwipeToLoadLayout)Utils.findRequiredViewAsType(paramView, 2131691285, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131691284, "field 'tvSelect' and method 'onClick'");
    paramT.tvSelect = ((TextView)Utils.castView(paramView, 2131691284, "field 'tvSelect'", TextView.class));
    this.c = paramView;
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
    MinsuCustomersListActivity localMinsuCustomersListActivity = this.a;
    if (localMinsuCustomersListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuCustomersListActivity.commonTitle = null;
    localMinsuCustomersListActivity.tvTitle = null;
    localMinsuCustomersListActivity.tvAdd = null;
    localMinsuCustomersListActivity.line = null;
    localMinsuCustomersListActivity.listview = null;
    localMinsuCustomersListActivity.swipeToLoadLayout = null;
    localMinsuCustomersListActivity.tvSelect = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCustomersListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */