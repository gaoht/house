package com.ziroom.ziroomcustomer.repay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RepayChangeCardActivity_ViewBinding<T extends RepayChangeCardActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public RepayChangeCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690143, "field 'change_card_state_btn' and method 'onClick'");
    paramT.change_card_state_btn = ((TextView)Utils.castView(localView, 2131690143, "field 'change_card_state_btn'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.change_card_state_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690142, "field 'change_card_state_tv'", TextView.class));
    paramT.change_card_state_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690141, "field 'change_card_state_img'", ImageView.class));
  }
  
  public void unbind()
  {
    RepayChangeCardActivity localRepayChangeCardActivity = this.a;
    if (localRepayChangeCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepayChangeCardActivity.change_card_state_btn = null;
    localRepayChangeCardActivity.change_card_state_tv = null;
    localRepayChangeCardActivity.change_card_state_img = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayChangeCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */