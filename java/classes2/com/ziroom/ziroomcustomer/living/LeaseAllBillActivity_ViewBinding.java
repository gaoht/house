package com.ziroom.ziroomcustomer.living;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.XListView;

public class LeaseAllBillActivity_ViewBinding<T extends LeaseAllBillActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public LeaseAllBillActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691914, "field 'mBack' and method 'onClick'");
    paramT.mBack = ((ImageView)Utils.castView(localView, 2131691914, "field 'mBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692830, "field 'mHouseBillLayout' and method 'onClick'");
    paramT.mHouseBillLayout = ((RelativeLayout)Utils.castView(localView, 2131692830, "field 'mHouseBillLayout'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692833, "field 'mLivingCostBillLayout' and method 'onClick'");
    paramT.mLivingCostBillLayout = ((RelativeLayout)Utils.castView(localView, 2131692833, "field 'mLivingCostBillLayout'", RelativeLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mHouseBillText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692831, "field 'mHouseBillText'", TextView.class));
    paramT.mHouseBillLine = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692832, "field 'mHouseBillLine'", TextView.class));
    paramT.mLivingCostBillText = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692834, "field 'mLivingCostBillText'", TextView.class));
    paramT.mLivingCostBillLine = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692835, "field 'mLivingCostBillLine'", TextView.class));
    paramT.mLeaseAllBillList = ((XListView)Utils.findRequiredViewAsType(paramView, 2131692838, "field 'mLeaseAllBillList'", XListView.class));
    paramT.lease_all_living_list = ((XListView)Utils.findRequiredViewAsType(paramView, 2131696598, "field 'lease_all_living_list'", XListView.class));
    paramT.lease_living_pay_layout = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696593, "field 'lease_living_pay_layout'", RelativeLayout.class));
    paramT.lease_living_pay_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696597, "field 'lease_living_pay_money'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696596, "field 'lease_living_pay_btn' and method 'onClick'");
    paramT.lease_living_pay_btn = ((TextView)Utils.castView(localView, 2131696596, "field 'lease_living_pay_btn'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.lease_tab = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692829, "field 'lease_tab'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131696580, "field 'tv_lease_text' and method 'onClick'");
    paramT.tv_lease_text = ((TextView)Utils.castView(localView, 2131696580, "field 'tv_lease_text'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.lease_all_bill_relative = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696592, "field 'lease_all_bill_relative'", RelativeLayout.class));
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tv_title'", TextView.class));
    paramT.lease_living_pay_cb = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131696595, "field 'lease_living_pay_cb'", CheckBox.class));
    paramView = Utils.findRequiredView(paramView, 2131696594, "method 'onClick'");
    this.g = paramView;
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
    LeaseAllBillActivity localLeaseAllBillActivity = this.a;
    if (localLeaseAllBillActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseAllBillActivity.mBack = null;
    localLeaseAllBillActivity.mHouseBillLayout = null;
    localLeaseAllBillActivity.mLivingCostBillLayout = null;
    localLeaseAllBillActivity.mHouseBillText = null;
    localLeaseAllBillActivity.mHouseBillLine = null;
    localLeaseAllBillActivity.mLivingCostBillText = null;
    localLeaseAllBillActivity.mLivingCostBillLine = null;
    localLeaseAllBillActivity.mLeaseAllBillList = null;
    localLeaseAllBillActivity.lease_all_living_list = null;
    localLeaseAllBillActivity.lease_living_pay_layout = null;
    localLeaseAllBillActivity.lease_living_pay_money = null;
    localLeaseAllBillActivity.lease_living_pay_btn = null;
    localLeaseAllBillActivity.lease_tab = null;
    localLeaseAllBillActivity.tv_lease_text = null;
    localLeaseAllBillActivity.lease_all_bill_relative = null;
    localLeaseAllBillActivity.tv_title = null;
    localLeaseAllBillActivity.lease_living_pay_cb = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseAllBillActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */