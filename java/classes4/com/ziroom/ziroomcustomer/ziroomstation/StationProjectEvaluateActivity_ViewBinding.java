package com.ziroom.ziroomcustomer.ziroomstation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class StationProjectEvaluateActivity_ViewBinding<T extends StationProjectEvaluateActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public StationProjectEvaluateActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'onClick'");
    paramT.btn_back = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
    paramT.tv_title_project_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692584, "field 'tv_title_project_name'", TextView.class));
    paramT.rv_eva = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692585, "field 'rv_eva'", RecyclerView.class));
    paramT.rl_out_container = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692586, "field 'rl_out_container'", RelativeLayout.class));
    paramT.v_out_line = Utils.findRequiredView(paramView, 2131692587, "field 'v_out_line'");
  }
  
  public void unbind()
  {
    StationProjectEvaluateActivity localStationProjectEvaluateActivity = this.a;
    if (localStationProjectEvaluateActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStationProjectEvaluateActivity.btn_back = null;
    localStationProjectEvaluateActivity.v_divider = null;
    localStationProjectEvaluateActivity.tv_title_project_name = null;
    localStationProjectEvaluateActivity.rv_eva = null;
    localStationProjectEvaluateActivity.rl_out_container = null;
    localStationProjectEvaluateActivity.v_out_line = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationProjectEvaluateActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */