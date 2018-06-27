package com.ziroom.ziroomcustomer.repay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RepayPayStatusActivity_ViewBinding<T extends RepayPayStatusActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public RepayPayStatusActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.pay_status_state_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692228, "field 'pay_status_state_img'", ImageView.class));
    paramT.pay_status_state_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692229, "field 'pay_status_state_tv'", TextView.class));
    paramT.pay_status_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692230, "field 'pay_status_content'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131692231, "field 'pay_status_state_btn' and method 'onClick'");
    paramT.pay_status_state_btn = ((TextView)Utils.castView(paramView, 2131692231, "field 'pay_status_state_btn'", TextView.class));
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
    RepayPayStatusActivity localRepayPayStatusActivity = this.a;
    if (localRepayPayStatusActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepayPayStatusActivity.pay_status_state_img = null;
    localRepayPayStatusActivity.pay_status_state_tv = null;
    localRepayPayStatusActivity.pay_status_content = null;
    localRepayPayStatusActivity.pay_status_state_btn = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayPayStatusActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */