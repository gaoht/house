package com.ziroom.ziroomcustomer.repay;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RepayCardActivity_ViewBinding<T extends RepayCardActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public RepayCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.repay_card_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692207, "field 'repay_card_name'", TextView.class));
    paramT.repay_card_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692208, "field 'repay_card_type'", TextView.class));
    paramT.repay_card_code = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692209, "field 'repay_card_code'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131692206, "field 'repay_card_ll' and method 'onClick'");
    paramT.repay_card_ll = ((LinearLayout)Utils.castView(localView, 2131692206, "field 'repay_card_ll'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.repay_bound_card_iv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692212, "field 'repay_bound_card_iv'", ImageView.class));
    paramT.repay_card_text_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692211, "field 'repay_card_text_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692210, "method 'onClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690511, "method 'onClick'");
    this.d = paramView;
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
    RepayCardActivity localRepayCardActivity = this.a;
    if (localRepayCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepayCardActivity.repay_card_name = null;
    localRepayCardActivity.repay_card_type = null;
    localRepayCardActivity.repay_card_code = null;
    localRepayCardActivity.repay_card_ll = null;
    localRepayCardActivity.repay_bound_card_iv = null;
    localRepayCardActivity.repay_card_text_tv = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */