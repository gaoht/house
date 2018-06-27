package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;

public class PeriodCleanerSelectActivity_ViewBinding<T extends PeriodCleanerSelectActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public PeriodCleanerSelectActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131692076, "field 'tvAddAddress' and method 'onViewClicked'");
    paramT.tvAddAddress = ((TextView)Utils.castView(localView, 2131692076, "field 'tvAddAddress'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llNoPlace = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692075, "field 'llNoPlace'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692077, "field 'llAddressSelect' and method 'onViewClicked'");
    paramT.llAddressSelect = ((LinearLayout)Utils.castView(localView, 2131692077, "field 'llAddressSelect'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvServiceMore = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692086, "field 'tvServiceMore'", TextView.class));
    paramT.listviewServiceMore = ((MyCleanListView)Utils.findRequiredViewAsType(paramView, 2131692087, "field 'listviewServiceMore'", MyCleanListView.class));
    paramT.scrollview = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvAddressSelect = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692078, "field 'tvAddressSelect'", TextView.class));
    paramT.v1 = Utils.findRequiredView(paramView, 2131689774, "field 'v1'");
    paramT.ll_service_history = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692080, "field 'll_service_history'", LinearLayout.class));
    paramT.listviewServiceHistory = ((MyCleanListView)Utils.findRequiredViewAsType(paramView, 2131692082, "field 'listviewServiceHistory'", MyCleanListView.class));
    paramT.gv_period = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131692079, "field 'gv_period'", MyGridView.class));
    paramT.ll_service_more = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692085, "field 'll_service_more'", LinearLayout.class));
    paramT.tv_service_history = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692081, "field 'tv_service_history'", TextView.class));
    paramT.v2 = Utils.findRequiredView(paramView, 2131689780, "field 'v2'");
    paramT.view_history_add = Utils.findRequiredView(paramView, 2131692084, "field 'view_history_add'");
    paramT.v3 = Utils.findRequiredView(paramView, 2131692083, "field 'v3'");
    paramT.tvServiceMessage = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692088, "field 'tvServiceMessage'", TextView.class));
  }
  
  public void unbind()
  {
    PeriodCleanerSelectActivity localPeriodCleanerSelectActivity = this.a;
    if (localPeriodCleanerSelectActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanerSelectActivity.ivBack = null;
    localPeriodCleanerSelectActivity.tvTitle = null;
    localPeriodCleanerSelectActivity.rlTitle = null;
    localPeriodCleanerSelectActivity.tvAddAddress = null;
    localPeriodCleanerSelectActivity.llNoPlace = null;
    localPeriodCleanerSelectActivity.llAddressSelect = null;
    localPeriodCleanerSelectActivity.tvServiceMore = null;
    localPeriodCleanerSelectActivity.listviewServiceMore = null;
    localPeriodCleanerSelectActivity.scrollview = null;
    localPeriodCleanerSelectActivity.btn = null;
    localPeriodCleanerSelectActivity.tvAddressSelect = null;
    localPeriodCleanerSelectActivity.v1 = null;
    localPeriodCleanerSelectActivity.ll_service_history = null;
    localPeriodCleanerSelectActivity.listviewServiceHistory = null;
    localPeriodCleanerSelectActivity.gv_period = null;
    localPeriodCleanerSelectActivity.ll_service_more = null;
    localPeriodCleanerSelectActivity.tv_service_history = null;
    localPeriodCleanerSelectActivity.v2 = null;
    localPeriodCleanerSelectActivity.view_history_add = null;
    localPeriodCleanerSelectActivity.v3 = null;
    localPeriodCleanerSelectActivity.tvServiceMessage = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanerSelectActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */