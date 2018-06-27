package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class EasilyPayLoanInfoActivity_ViewBinding<T extends EasilyPayLoanInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public EasilyPayLoanInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690511, "field 'back_iv' and method 'onClick'");
    paramT.back_iv = ((ImageView)Utils.castView(localView, 2131690511, "field 'back_iv'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690518, "field 'loan_cancle' and method 'onClick'");
    paramT.loan_cancle = ((TextView)Utils.castView(localView, 2131690518, "field 'loan_cancle'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.loan_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690519, "field 'loan_title'", TextView.class));
    paramT.loan_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690520, "field 'loan_hint'", TextView.class));
    paramT.loan_first_payment = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690521, "field 'loan_first_payment'", TextView.class));
    paramT.loan_principal_sum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690522, "field 'loan_principal_sum'", TextView.class));
    paramT.loan_loan_periods = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690523, "field 'loan_loan_periods'", TextView.class));
    paramT.loan_should_pay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690524, "field 'loan_should_pay'", TextView.class));
    paramT.loan_principal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690525, "field 'loan_principal'", TextView.class));
    paramT.loan_interest = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690526, "field 'loan_interest'", TextView.class));
    paramT.loan_to_pay_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690528, "field 'loan_to_pay_money'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690517, "field 'easily_btn' and method 'onClick'");
    paramT.easily_btn = ((TextView)Utils.castView(localView, 2131690517, "field 'easily_btn'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.loan_to_pay_money_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690527, "field 'loan_to_pay_money_rl'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    EasilyPayLoanInfoActivity localEasilyPayLoanInfoActivity = this.a;
    if (localEasilyPayLoanInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEasilyPayLoanInfoActivity.back_iv = null;
    localEasilyPayLoanInfoActivity.loan_cancle = null;
    localEasilyPayLoanInfoActivity.loan_title = null;
    localEasilyPayLoanInfoActivity.loan_hint = null;
    localEasilyPayLoanInfoActivity.loan_first_payment = null;
    localEasilyPayLoanInfoActivity.loan_principal_sum = null;
    localEasilyPayLoanInfoActivity.loan_loan_periods = null;
    localEasilyPayLoanInfoActivity.loan_should_pay = null;
    localEasilyPayLoanInfoActivity.loan_principal = null;
    localEasilyPayLoanInfoActivity.loan_interest = null;
    localEasilyPayLoanInfoActivity.loan_to_pay_money = null;
    localEasilyPayLoanInfoActivity.easily_btn = null;
    localEasilyPayLoanInfoActivity.loan_to_pay_money_rl = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EasilyPayLoanInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */