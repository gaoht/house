package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;

public class LeaseSubletSelectTimeActivity_ViewBinding<T extends LeaseSubletSelectTimeActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public LeaseSubletSelectTimeActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.bztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'bztb'", BasicZiroomToolBar.class));
    paramT.tvSelectDateTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696699, "field 'tvSelectDateTip'", TextView.class));
    paramT.tvSubletTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696436, "field 'tvSubletTime'", TextView.class));
    paramT.tvSubletTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696701, "field 'tvSubletTip'", TextView.class));
    paramT.llSubletTimeAndTipContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696700, "field 'llSubletTimeAndTipContainer'", LinearLayout.class));
    View localView = Utils.findRequiredView(paramView, 2131696702, "field 'tvLiveInTime' and method 'onViewClicked'");
    paramT.tvLiveInTime = ((TextView)Utils.castView(localView, 2131696702, "field 'tvLiveInTime'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696703, "field 'tvSubletPrice' and method 'onViewClicked'");
    paramT.tvSubletPrice = ((TextView)Utils.castView(localView, 2131696703, "field 'tvSubletPrice'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.cpvCalendarSublet = ((CalendarPickerView)Utils.findRequiredViewAsType(paramView, 2131696704, "field 'cpvCalendarSublet'", CalendarPickerView.class));
    paramView = Utils.findRequiredView(paramView, 2131691560, "field 'btnNext' and method 'onViewClicked'");
    paramT.btnNext = ((Button)Utils.castView(paramView, 2131691560, "field 'btnNext'", Button.class));
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
    LeaseSubletSelectTimeActivity localLeaseSubletSelectTimeActivity = this.a;
    if (localLeaseSubletSelectTimeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseSubletSelectTimeActivity.bztb = null;
    localLeaseSubletSelectTimeActivity.tvSelectDateTip = null;
    localLeaseSubletSelectTimeActivity.tvSubletTime = null;
    localLeaseSubletSelectTimeActivity.tvSubletTip = null;
    localLeaseSubletSelectTimeActivity.llSubletTimeAndTipContainer = null;
    localLeaseSubletSelectTimeActivity.tvLiveInTime = null;
    localLeaseSubletSelectTimeActivity.tvSubletPrice = null;
    localLeaseSubletSelectTimeActivity.cpvCalendarSublet = null;
    localLeaseSubletSelectTimeActivity.btnNext = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletSelectTimeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */