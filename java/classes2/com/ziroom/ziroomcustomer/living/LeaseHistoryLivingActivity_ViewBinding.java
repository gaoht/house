package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LeaseHistoryLivingActivity_ViewBinding<T extends LeaseHistoryLivingActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LeaseHistoryLivingActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691914, "field 'mBack' and method 'onClick'");
    paramT.mBack = ((ImageView)Utils.castView(localView, 2131691914, "field 'mBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.history_living_list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131696600, "field 'history_living_list'", ListView.class));
    paramT.living_history_linear = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696599, "field 'living_history_linear'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    LeaseHistoryLivingActivity localLeaseHistoryLivingActivity = this.a;
    if (localLeaseHistoryLivingActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseHistoryLivingActivity.mBack = null;
    localLeaseHistoryLivingActivity.history_living_list = null;
    localLeaseHistoryLivingActivity.living_history_linear = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */