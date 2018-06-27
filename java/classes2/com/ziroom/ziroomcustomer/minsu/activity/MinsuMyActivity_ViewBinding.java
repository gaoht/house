package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.BadgeView;

public class MinsuMyActivity_ViewBinding<T extends MinsuMyActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  
  public MinsuMyActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691599, "field 'tv_order_more' and method 'goOrderList'");
    paramT.tv_order_more = ((TextView)Utils.castView(localView, 2131691599, "field 'tv_order_more'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderList();
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691600, "field 'rl_order_appointment' and method 'goOrderTypeList'");
    paramT.rl_order_appointment = ((RelativeLayout)Utils.castView(localView, 2131691600, "field 'rl_order_appointment'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderTypeList(paramAnonymousView);
      }
    });
    paramT.order_appointment_count = ((BadgeView)Utils.findRequiredViewAsType(paramView, 2131691603, "field 'order_appointment_count'", BadgeView.class));
    paramT.order_payment_count = ((BadgeView)Utils.findRequiredViewAsType(paramView, 2131691607, "field 'order_payment_count'", BadgeView.class));
    paramT.order_occupancy_count = ((BadgeView)Utils.findRequiredViewAsType(paramView, 2131691611, "field 'order_occupancy_count'", BadgeView.class));
    paramT.order_evaluate_count = ((BadgeView)Utils.findRequiredViewAsType(paramView, 2131691615, "field 'order_evaluate_count'", BadgeView.class));
    paramT.order_detail_area = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691616, "field 'order_detail_area'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691210, "field 'tv_house_name' and method 'goOrderDetail'");
    paramT.tv_house_name = ((TextView)Utils.castView(localView, 2131691210, "field 'tv_house_name'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderDetail();
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691378, "field 'tv_house_address' and method 'goOrderDetail'");
    paramT.tv_house_address = ((TextView)Utils.castView(localView, 2131691378, "field 'tv_house_address'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderDetail();
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691618, "field 'date_area' and method 'goOrderDetail'");
    paramT.date_area = ((LinearLayout)Utils.castView(localView, 2131691618, "field 'date_area'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderDetail();
      }
    });
    paramT.date_check_in = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691619, "field 'date_check_in'", TextView.class));
    paramT.date_check_out = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691620, "field 'date_check_out'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691604, "method 'goOrderTypeList'");
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderTypeList(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691608, "method 'goOrderTypeList'");
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderTypeList(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691612, "method 'goOrderTypeList'");
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.goOrderTypeList(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691621, "method 'contactLandlord'");
    this.j = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.contactLandlord();
      }
    });
  }
  
  public void unbind()
  {
    MinsuMyActivity localMinsuMyActivity = this.a;
    if (localMinsuMyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuMyActivity.tv_order_more = null;
    localMinsuMyActivity.rl_order_appointment = null;
    localMinsuMyActivity.order_appointment_count = null;
    localMinsuMyActivity.order_payment_count = null;
    localMinsuMyActivity.order_occupancy_count = null;
    localMinsuMyActivity.order_evaluate_count = null;
    localMinsuMyActivity.order_detail_area = null;
    localMinsuMyActivity.tv_house_name = null;
    localMinsuMyActivity.tv_house_address = null;
    localMinsuMyActivity.date_area = null;
    localMinsuMyActivity.date_check_in = null;
    localMinsuMyActivity.date_check_out = null;
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
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuMyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */