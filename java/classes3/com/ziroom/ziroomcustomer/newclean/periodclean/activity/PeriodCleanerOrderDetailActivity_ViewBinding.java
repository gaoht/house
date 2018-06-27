package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PeriodCleanerOrderDetailActivity_ViewBinding<T extends PeriodCleanerOrderDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public PeriodCleanerOrderDetailActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131690023, "field 'ivChat' and method 'onViewClicked'");
    paramT.ivChat = ((ImageView)Utils.castView(localView, 2131690023, "field 'ivChat'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690024, "field 'tvOrderState' and method 'onViewClicked'");
    paramT.tvOrderState = ((TextView)Utils.castView(localView, 2131690024, "field 'tvOrderState'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690025, "field 'tvOrderDetail' and method 'onViewClicked'");
    paramT.tvOrderDetail = ((TextView)Utils.castView(localView, 2131690025, "field 'tvOrderDetail'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.indicator = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690026, "field 'indicator'", ImageView.class));
    paramT.vpDetail = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690028, "field 'vpDetail'", ViewPager.class));
  }
  
  public void unbind()
  {
    PeriodCleanerOrderDetailActivity localPeriodCleanerOrderDetailActivity = this.a;
    if (localPeriodCleanerOrderDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanerOrderDetailActivity.ivBack = null;
    localPeriodCleanerOrderDetailActivity.tvTitle = null;
    localPeriodCleanerOrderDetailActivity.ivChat = null;
    localPeriodCleanerOrderDetailActivity.rlTitle = null;
    localPeriodCleanerOrderDetailActivity.tvOrderState = null;
    localPeriodCleanerOrderDetailActivity.tvOrderDetail = null;
    localPeriodCleanerOrderDetailActivity.indicator = null;
    localPeriodCleanerOrderDetailActivity.vpDetail = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanerOrderDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */