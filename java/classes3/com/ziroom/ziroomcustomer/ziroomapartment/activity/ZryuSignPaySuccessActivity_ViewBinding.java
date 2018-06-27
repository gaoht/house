package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ZryuSignPaySuccessActivity_ViewBinding<T extends ZryuSignPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public ZryuSignPaySuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.pay_status_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693031, "field 'pay_status_tv'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131693032, "field 'pay_status_btn1' and method 'onClick'");
    paramT.pay_status_btn1 = ((TextView)Utils.castView(localView, 2131693032, "field 'pay_status_btn1'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693033, "field 'pay_status_btn2' and method 'onClick'");
    paramT.pay_status_btn2 = ((TextView)Utils.castView(localView, 2131693033, "field 'pay_status_btn2'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.pay_status_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692230, "field 'pay_status_content'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
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
    ZryuSignPaySuccessActivity localZryuSignPaySuccessActivity = this.a;
    if (localZryuSignPaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuSignPaySuccessActivity.pay_status_tv = null;
    localZryuSignPaySuccessActivity.pay_status_btn1 = null;
    localZryuSignPaySuccessActivity.pay_status_btn2 = null;
    localZryuSignPaySuccessActivity.pay_status_content = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */