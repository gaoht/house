package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class EnterprisePaySuccessActivity_ViewBinding<T extends EnterprisePaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public EnterprisePaySuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'iv_back' and method 'onClic'");
    paramT.iv_back = ((ImageView)Utils.castView(localView, 2131689492, "field 'iv_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.tv_price_item = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690550, "field 'tv_price_item'", TextView.class));
    paramT.tv_pay_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690551, "field 'tv_pay_money'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690552, "field 'tv_complete' and method 'onClic'");
    paramT.tv_complete = ((TextView)Utils.castView(localView, 2131690552, "field 'tv_complete'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690549, "field 'back' and method 'onClic'");
    paramT.back = ((TextView)Utils.castView(paramView, 2131690549, "field 'back'", TextView.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    EnterprisePaySuccessActivity localEnterprisePaySuccessActivity = this.a;
    if (localEnterprisePaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEnterprisePaySuccessActivity.iv_back = null;
    localEnterprisePaySuccessActivity.tv_price_item = null;
    localEnterprisePaySuccessActivity.tv_pay_money = null;
    localEnterprisePaySuccessActivity.tv_complete = null;
    localEnterprisePaySuccessActivity.back = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EnterprisePaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */