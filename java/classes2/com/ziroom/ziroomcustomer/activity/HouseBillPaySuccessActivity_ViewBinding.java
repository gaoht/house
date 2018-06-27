package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class HouseBillPaySuccessActivity_ViewBinding<T extends HouseBillPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public HouseBillPaySuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramView = Utils.findRequiredView(paramView, 2131690854, "method 'onClick'");
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
    if (this.a == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/HouseBillPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */