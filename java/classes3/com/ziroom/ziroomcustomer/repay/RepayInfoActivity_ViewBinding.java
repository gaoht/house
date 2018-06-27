package com.ziroom.ziroomcustomer.repay;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RepayInfoActivity_ViewBinding<T extends RepayInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public RepayInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.repay_data_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692227, "field 'repay_data_ll'", LinearLayout.class));
    paramT.complete_repay_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692214, "field 'complete_repay_ll'", LinearLayout.class));
    paramT.repay_info_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692217, "field 'repay_info_ll'", LinearLayout.class));
    paramT.repay_money_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692218, "field 'repay_money_tv'", TextView.class));
    paramT.repay_poundage_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692219, "field 'repay_poundage_tv'", TextView.class));
    paramT.repay_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692220, "field 'repay_time'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131692221, "field 'to_pay_tv' and method 'click'");
    paramT.to_pay_tv = ((TextView)Utils.castView(localView, 2131692221, "field 'to_pay_tv'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    paramT.hint_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692222, "field 'hint_rl'", RelativeLayout.class));
    paramT.error_iv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692223, "field 'error_iv'", ImageView.class));
    paramT.hint_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692224, "field 'hint_tv'", TextView.class));
    paramT.repay_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692213, "field 'repay_ll'", LinearLayout.class));
    paramT.repay_complete_iv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692215, "field 'repay_complete_iv'", ImageView.class));
    paramT.repay_complete_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692216, "field 'repay_complete_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690511, "method 'click'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692225, "method 'click'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692206, "method 'click'");
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131692226, "method 'click'");
    this.f = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    RepayInfoActivity localRepayInfoActivity = this.a;
    if (localRepayInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepayInfoActivity.repay_data_ll = null;
    localRepayInfoActivity.complete_repay_ll = null;
    localRepayInfoActivity.repay_info_ll = null;
    localRepayInfoActivity.repay_money_tv = null;
    localRepayInfoActivity.repay_poundage_tv = null;
    localRepayInfoActivity.repay_time = null;
    localRepayInfoActivity.to_pay_tv = null;
    localRepayInfoActivity.hint_rl = null;
    localRepayInfoActivity.error_iv = null;
    localRepayInfoActivity.hint_tv = null;
    localRepayInfoActivity.repay_ll = null;
    localRepayInfoActivity.repay_complete_iv = null;
    localRepayInfoActivity.repay_complete_tv = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */