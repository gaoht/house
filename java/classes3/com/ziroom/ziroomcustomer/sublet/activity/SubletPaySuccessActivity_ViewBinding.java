package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SubletPaySuccessActivity_ViewBinding<T extends SubletPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public SubletPaySuccessActivity_ViewBinding(final T paramT, View paramView)
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
    SubletPaySuccessActivity localSubletPaySuccessActivity = this.a;
    if (localSubletPaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSubletPaySuccessActivity.lease_sublet_success_btn = null;
    localSubletPaySuccessActivity.sublet_success_text = null;
    localSubletPaySuccessActivity.sublet_success_title = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */