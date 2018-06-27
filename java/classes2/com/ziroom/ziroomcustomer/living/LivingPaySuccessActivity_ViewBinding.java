package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LivingPaySuccessActivity_ViewBinding<T extends LivingPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LivingPaySuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_pay_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690551, "field 'tv_pay_money'", TextView.class));
    paramT.tv_price_item = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690550, "field 'tv_price_item'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690552, "field 'tv_complete' and method 'onClick'");
    paramT.tv_complete = ((TextView)Utils.castView(localView, 2131690552, "field 'tv_complete'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
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
    LivingPaySuccessActivity localLivingPaySuccessActivity = this.a;
    if (localLivingPaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLivingPaySuccessActivity.tv_pay_money = null;
    localLivingPaySuccessActivity.tv_price_item = null;
    localLivingPaySuccessActivity.tv_complete = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */