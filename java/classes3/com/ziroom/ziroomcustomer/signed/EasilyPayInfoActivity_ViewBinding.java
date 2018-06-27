package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class EasilyPayInfoActivity_ViewBinding<T extends EasilyPayInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public EasilyPayInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.principal_sum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690512, "field 'principal_sum'", TextView.class));
    paramT.loan_periods = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690513, "field 'loan_periods'", TextView.class));
    paramT.should_pay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690514, "field 'should_pay'", TextView.class));
    paramT.principal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690515, "field 'principal'", TextView.class));
    paramT.interest = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690516, "field 'interest'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690517, "method 'onClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690511, "method 'onClick'");
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
    EasilyPayInfoActivity localEasilyPayInfoActivity = this.a;
    if (localEasilyPayInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEasilyPayInfoActivity.principal_sum = null;
    localEasilyPayInfoActivity.loan_periods = null;
    localEasilyPayInfoActivity.should_pay = null;
    localEasilyPayInfoActivity.principal = null;
    localEasilyPayInfoActivity.interest = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EasilyPayInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */