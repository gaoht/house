package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LeaseSubletSuccessActivity_ViewBinding<T extends LeaseSubletSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LeaseSubletSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690854, "field 'lease_sublet_success_btn' and method 'onClick'");
    paramT.lease_sublet_success_btn = ((TextView)Utils.castView(localView, 2131690854, "field 'lease_sublet_success_btn'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.sublet_success_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690853, "field 'sublet_success_text'", TextView.class));
    paramT.sublet_success_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690852, "field 'sublet_success_title'", TextView.class));
  }
  
  public void unbind()
  {
    LeaseSubletSuccessActivity localLeaseSubletSuccessActivity = this.a;
    if (localLeaseSubletSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseSubletSuccessActivity.lease_sublet_success_btn = null;
    localLeaseSubletSuccessActivity.sublet_success_text = null;
    localLeaseSubletSuccessActivity.sublet_success_title = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */