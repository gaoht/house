package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PeriodCleanSuccessActivity_ViewBinding<T extends PeriodCleanSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public PeriodCleanSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692101, "field 'btnOrderDetail' and method 'onViewClicked'");
    paramT.btnOrderDetail = ((Button)Utils.castView(localView, 2131692101, "field 'btnOrderDetail'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131692102, "field 'btnGetOrder' and method 'onViewClicked'");
    paramT.btnGetOrder = ((Button)Utils.castView(paramView, 2131692102, "field 'btnGetOrder'", Button.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    PeriodCleanSuccessActivity localPeriodCleanSuccessActivity = this.a;
    if (localPeriodCleanSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanSuccessActivity.ivBack = null;
    localPeriodCleanSuccessActivity.tvTitle = null;
    localPeriodCleanSuccessActivity.rlTitle = null;
    localPeriodCleanSuccessActivity.btnOrderDetail = null;
    localPeriodCleanSuccessActivity.btnGetOrder = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */